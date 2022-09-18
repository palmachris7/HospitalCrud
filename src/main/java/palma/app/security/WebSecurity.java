package palma.app.security;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username, password, estatus from Usuario where username=?")
				.authoritiesByUsernameQuery("select username as username , perfil as perfil from Usuario_Perfil " +
						"inner join usuario using (idusuario)" +
						"inner join perfil using (idperfil) " +
						"where username = ?");
	}



	/**
	 * Personalizamos el Acceso a las URLs de la aplicación
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()

				// Los recursos estáticos no requieren autenticación
				.antMatchers(
						"/bootstrap/**",
						"/images/**",
						"/tinymce/**",
						"/logos/**")
				.permitAll()

				// Las vistas públicas no requieren autenticación
				.antMatchers("/",
						"/login",
						"/signup",
						"/search",
						"/bcrypt/**",
						"/about",
						"/hospitales/view/**")
				.permitAll()

				// Asignar permisos a URLs por ROLES
				.antMatchers("/solicitudes/create/**",
						"/solicitudes/save/**")
				.hasAuthority("USUARIO")
				// "/solicitudes/save/**").hasAuthority("Usuario")

				.antMatchers("/solicitudes/**").hasAnyAuthority("USUARIO", "ADMINISTRADOR")
				.antMatchers("/vacantes/**").hasAnyAuthority("Supervisor", "ADMINISTRADOR")
				.antMatchers("/categorias/**").hasAnyAuthority("Supervisor", "ADMINISTRADOR")
				.antMatchers("/Usuarios/**").hasAnyAuthority("ADMINISTRADOR")

				// Todas las demás URLs de la Aplicación requieren autenticación
				.anyRequest().authenticated()
				// El formulario de Login no requiere autenticacion
				.and().formLogin().loginPage("/login").permitAll()
				.and().logout().permitAll();
	}

	/**
	 * Implementación de Spring Security que encripta passwords con el algoritmo
	 * Bcrypt
	 * 
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}