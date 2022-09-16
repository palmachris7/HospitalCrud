package palma.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import palma.app.models.Gerente;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public void run(String... args) throws Exception {
		String sql = "SELECT * FROM GERENTE";
         
        List<Gerente> gerentes = jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(Gerente.class));
         System.out.println("Hola"+gerentes);
        gerentes.forEach(System.out :: println);
		
	}

}
