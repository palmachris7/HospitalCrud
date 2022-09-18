package palma.app.controllers;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import palma.app.models.Hospital;
import palma.app.models.Perfil;
import palma.app.models.Usuario;
import palma.app.service.IHospitalService;
import palma.app.service.ISedeService;
import palma.app.service.IUsuariosService;
@Controller
public class HomeController {

	

	@Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
   	private IUsuariosService serviceUsuarios;

	@Autowired
	private IHospitalService serviceHospital;

	@Autowired
	private ISedeService serviceSede;

    @GetMapping("/")
	public String mostrarHome() {
		return "home";
	}

    @GetMapping("/index")
	public String mostrarIndex(Authentication authentication, HttpSession session) {		
		
		String username = authentication.getName();		
		
		for(GrantedAuthority rol: authentication.getAuthorities()) {
			System.out.println("ROL: " + rol.getAuthority());
		}
		
		if (session.getAttribute("usuario") == null){
			Usuario usuario = serviceUsuarios.buscarPorUsername(username);	
			System.out.println("Usuario: " + usuario);
			 session.setAttribute("usuario", usuario);
		}
		
		return "redirect:/";
	}

	@GetMapping("/signup")
	public String registrarse(Usuario usuario) {
		return "formRegistro";
	}

	@PostMapping("/signup")
	public String guardarRegistro(Usuario usuario, RedirectAttributes attributes) {
		String pwdPlano = usuario.getPassword();
		String pwdEncriptado = passwordEncoder.encode(pwdPlano); 
		usuario.setPassword(pwdEncriptado);	
		Perfil perfil = new Perfil();
		usuario.setEstatus(1); 
		perfil.setIdPerfil(2); 
		usuario.agregar(perfil);
		serviceUsuarios.guardar(usuario);	
		attributes.addFlashAttribute("msg", "Has sido registrado. ¡Ahora puedes ingresar al sistema!");
		
		return "redirect:/login";
	}

	@GetMapping("/about")
	public String mostrarAcerca() {			
		return "acerca";
	}

	@GetMapping("/login")
	public String mostrarLogin() {
		return "formLogin";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		logoutHandler.logout(request, null, null);
		return "redirect:/";
	}


	@GetMapping("/search")
	public String buscar(@ModelAttribute("search") Hospital hospital, Model model) {
		
		ExampleMatcher matcher  = ExampleMatcher.matching().
			withMatcher("nombre", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
		Example<Hospital> example = Example.of(hospital, matcher);
		List<Hospital> lista = serviceHospital.buscarByExample(example);
		model.addAttribute("hospitales", lista);
		return "home";
	}

	@ModelAttribute
	public void setGenericos(Model model){
		Hospital hospitalSearch = new Hospital();
		model.addAttribute("search", hospitalSearch);
		model.addAttribute("hospitales", serviceHospital.buscarTodas());	
	    model.addAttribute("sedes", serviceSede.buscarTodas());	
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
}
