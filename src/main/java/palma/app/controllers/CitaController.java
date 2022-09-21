package palma.app.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import palma.app.models.Cita;
import palma.app.models.Hospital;
import palma.app.models.Usuario;
import palma.app.service.ICitaService;
import palma.app.service.IHospitalService;
import palma.app.service.IUsuariosService;


@Controller
@RequestMapping("/citas")
public class CitaController {
    @Autowired
    private ICitaService serviceCita;
	@Autowired
    private IHospitalService serviceHospital;
	@Autowired
    private IUsuariosService serviceUsuario;


	

	
    @GetMapping("/index")
	public String mostrarIndex(Model model) {
    	List<Cita> lista = serviceCita.buscarTodas();
    	model.addAttribute("citas", lista);
		return "citas/listCitas";
	}

	@GetMapping("/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Cita> lista = serviceCita.buscarTodas(page);
		model.addAttribute("citas", lista);
		return "citas/listCitas";
	}

	@GetMapping("/create")
	public String crear(@ModelAttribute Cita cita) {		
		return "citas/formCita";
	}

	@GetMapping("/crearu/{username}")
	public String crearu(@PathVariable("username") String username , @ModelAttribute Cita cita) {	
		Usuario usuario = serviceUsuario.buscarPorUsername(username);
		cita.setUsuario(usuario);	
		return "citas/formCita";
	}

	@GetMapping("/crear/{id}/{username}")
	public String crearr(@PathVariable("id") int idHospital, @PathVariable("username") String username , @ModelAttribute Cita cita) {	
		Usuario usuario = serviceUsuario.buscarPorUsername(username);
		Hospital hospital = serviceHospital.buscarPorId(idHospital);
		cita.setUsuario(usuario);
		cita.setHospital(hospital);	
		return "citas/formCita";
	}

	@PostMapping("/save")
	public String guardar(@ModelAttribute Cita cita, BindingResult result, Model model,RedirectAttributes attributes ) {	
		
		if (result.hasErrors()){
			
			System.out.println("Existieron errores");
		
			return "citas/formCita";
		}
		
		serviceCita.guardar(cita);
		attributes.addFlashAttribute("msg", "Los datos de la cita fueron guardados!");
	
		return "redirect:/citas/indexPaginate";		
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idCita, Model model) {		
		Cita cita = serviceCita.buscarPorId(idCita);			
		model.addAttribute("cita", cita);
		return "citas/formCita";
	}

	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idCita, RedirectAttributes attributes) {
		serviceCita.eliminar(idCita);
		attributes.addFlashAttribute("msg", "La cita fue eliminada!.");
		return "redirect:/citas/index";
	}

	@ModelAttribute
	public void setGenericos(Model model){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		model.addAttribute("hospitales", serviceHospital.buscarTodas());	
		model.addAttribute("usuario", serviceUsuario.buscarPorUsername(currentPrincipalName));
		model.addAttribute("cantidad", serviceCita.buscarTodas().size());	
	}
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

}
