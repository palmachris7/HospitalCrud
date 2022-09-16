package palma.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import palma.app.models.Gerente;
import palma.app.repository.GerenteRepository;
import palma.app.service.IGerenteService;

@Service
public class GerenteServiceImp implements IGerenteService {

    @Autowired
	private GerenteRepository gerenteRepo;

    @Override
    public void guardar(Gerente gerente) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void eliminar(Integer idGerente) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Gerente> buscarTodas() {
        return gerenteRepo.findAll();
    }

    @Override
    public Gerente buscarPorId(Integer idGerente) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<Gerente> buscarTodas(Pageable page) {
        return gerenteRepo.findAll(page);	
    }

}