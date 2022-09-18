package palma.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import palma.app.models.Hospital;
import palma.app.repository.HospitalRepository;
import palma.app.service.IHospitalService;

@Service
public class HospitalServiceImp implements IHospitalService {
    @Autowired
	private HospitalRepository hospirepo;

    @Override
    public void guardar(Hospital gerente) {
      
        
    }

    @Override
    public void eliminar(Integer idGerente) {
        
        
    }

    @Override
    public List<Hospital> buscarTodas() {
        
        return null;
    }

    @Override
    public Hospital buscarPorId(Integer idGerente) {
        
        return null;
    }

    @Override
    public Page<Hospital> buscarTodas(Pageable page) {
     
        return null;
    }



    @Override
    public List<Hospital> buscarByExample(Example<Hospital> example) {
        return hospirepo.findAll(example);
    }
    
}
