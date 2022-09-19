package palma.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import palma.app.models.Distrito;
import palma.app.repository.DistritoRepository;
import palma.app.service.IDistritoService;


@Service
public class DistritoServiceImp implements IDistritoService {

    @Autowired
	private DistritoRepository distriRepo;

    @Override
    public List<Distrito> buscarTodas() {
       return distriRepo.findAll();
    }


}