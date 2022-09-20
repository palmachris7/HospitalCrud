package palma.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import palma.app.models.Cita;

import palma.app.repository.CitaRepository;
import palma.app.service.ICitaService;



@Service
public class CitaServiceImp implements ICitaService {

    @Autowired
	private CitaRepository citaRepo;

    

    @Override
    public void guardar(Cita cita) {
       citaRepo.save(cita);
        
    }

    @Override
    public void eliminar(Integer idCita) {
       citaRepo.deleteById(idCita);
        
    }

    @Override
    public Cita buscarPorId(Integer idCita) {
        Optional<Cita> optional = citaRepo.findById(idCita);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
    }

    @Override
    public List<Cita> buscarTodas() {
        return citaRepo.findAll();
    }

    @Override
    public Page<Cita> buscarTodas(Pageable page) {
        return citaRepo.findAll(page);
    }


}