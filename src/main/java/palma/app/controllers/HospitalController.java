package palma.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import palma.app.models.Hospital;
import palma.app.service.IHospitalService;
import palma.app.service.ISedeService;


@Controller
@RequestMapping(value="/hospitales")
public class HospitalController {
    @Autowired
	private IHospitalService serviceHospital;

    @Autowired
	private ISedeService serviceSede;


    @GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idHospital, Model model) {		
		Hospital hospital = serviceHospital.buscarPorId(idHospital);			
		model.addAttribute("hospital", hospital);
		return "detalle";
	}

    @ModelAttribute
	public void setGenericos(Model model){
		model.addAttribute("sedes", serviceSede.buscarTodas());	
	}
	
	
}
