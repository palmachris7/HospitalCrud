package palma.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import palma.app.models.Cita;
import palma.app.service.ICitaService;

@Controller
@RequestMapping("/citas")
public class CitaController {
    @Autowired
    private ICitaService serviceCita;

    @GetMapping("/index")
	public String mostrarIndex(Model model) {
    	List<Cita> lista = serviceCita.buscarTodas();
    	model.addAttribute("citas", lista);
		return "citas/listCitas";
	}
}
