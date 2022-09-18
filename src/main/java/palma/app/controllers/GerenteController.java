package palma.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import palma.app.models.Gerente;
import palma.app.service.IGerenteService;

@Controller
@RequestMapping("/gerentes")
public class GerenteController {

    @Autowired
    private IGerenteService serviceGerente;

    
    @GetMapping("/index")
	public String mostrarIndex(Model model) {
    	List<Gerente> lista = serviceGerente.buscarTodas();
    	model.addAttribute("gerentes", lista);
		System.out.println("Gerentes"+lista);
		return "gerentes/listGerentes";
	}
	 
	@GetMapping("/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Gerente> lista = serviceGerente.buscarTodas(page);
		model.addAttribute("gerentes", lista);
		return "gerentes/listGerentes";
	}

	@GetMapping("/create")
	public String crear(Gerente gerente) {		
		return "gerentes/formGerente";
	}


	@PostMapping("/save")
	public String guardar(Gerente gerente, BindingResult result, Model model, RedirectAttributes attributes) {	
		
		if (result.hasErrors()){
			
			System.out.println("Existieron errores");
			return "gerentes/formGerente";
		}	
		serviceGerente.guardar(gerente);
		attributes.addFlashAttribute("msg", "Los datos del gerente fueron guardados!");
		return "redirect:/gerentes/indexPaginate";		
	}

	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idgerente, Model model) {		
		Gerente gerente = serviceGerente.buscarPorId(idgerente);			
		model.addAttribute("gerente", gerente);
		return "gerentes/formGerente";
	}

}
