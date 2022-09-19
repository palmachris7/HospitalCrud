package palma.app.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import palma.app.models.Hospital;
import palma.app.service.ICondicionService;
import palma.app.service.IDistritoService;
import palma.app.service.IGerenteService;
import palma.app.service.IHospitalService;
import palma.app.service.ISedeService;


@Controller
@RequestMapping(value="/hospitales")
public class HospitalController {

	@Value("${hospitalapp.ruta.imagenes}")
	private String ruta;

    @Autowired
	private IHospitalService serviceHospital;

    @Autowired
	private ISedeService serviceSede;
	@Autowired
	private IGerenteService serviceGerente;
	 @Autowired
	private IDistritoService serviceDistrito;
	@Autowired
	private ICondicionService serviceCondicion;
	
	
	


    @GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idHospital, Model model) {		
		Hospital hospital = serviceHospital.buscarPorId(idHospital);			
		model.addAttribute("hospital", hospital);
		return "detalle";
	}
	
	@GetMapping("/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Hospital> lista = serviceHospital.buscarTodas(page);
		model.addAttribute("hospitales", lista);
		return "hospitales/listHospitales";
	}

	@GetMapping("/create")
	public String crear(@ModelAttribute Hospital hospital) {		
		return "hospitales/formHospital";
	}
	

	@PostMapping("/save")
	public String guardar(@ModelAttribute Hospital hospital, BindingResult result, Model model,RedirectAttributes attributes ) {	
		
		if (result.hasErrors()){
			
			System.out.println("Existieron errores");
			return "hospitales/formHospital";
		}	
		serviceHospital.guardar(hospital);
		attributes.addFlashAttribute("msg", "Los datos de la vacante fueron guardados!");
	
		return "redirect:/hospitales/indexPaginate";		
	}
	

	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idHospital, Model model) {		
		Hospital hospital = serviceHospital.buscarPorId(idHospital);			
		model.addAttribute("hospital", hospital);
		return "hospitales/formHospital";
	}

	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idHospital, RedirectAttributes attributes) {
		serviceHospital.eliminar(idHospital);
		attributes.addFlashAttribute("msg", "La vacante fue eliminada!.");
		return "redirect:/hospitales/indexPaginate";
	}

    @ModelAttribute
	public void setGenericos(Model model){
		model.addAttribute("sedes", serviceSede.buscarTodas());	
		model.addAttribute("gerentes", serviceGerente.buscarTodas());
		model.addAttribute("distritos", serviceDistrito.buscarTodas());	
		model.addAttribute("condiciones", serviceCondicion.buscarTodas());	
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	
}
