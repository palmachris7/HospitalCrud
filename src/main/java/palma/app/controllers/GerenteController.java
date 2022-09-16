package palma.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    	model.addAttribute("GERENTES", lista);
		System.out.println("Gerentes"+lista);
		return "gerentes/listGerentes";
	}
	 
	@GetMapping("/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Gerente> lista = serviceGerente.buscarTodas(page);
		model.addAttribute("GERENTES", lista);
		return "gerentes/listGerentes";
	}
}
