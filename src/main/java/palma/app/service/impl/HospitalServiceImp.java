package palma.app.service.impl;

import java.util.List;
import java.util.Optional;

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
    public void guardar(Hospital hospital) {
      
        hospirepo.save(hospital);
    }

    @Override
    public void eliminar(Integer idHospital) {
        hospirepo.deleteById(idHospital);
    }

    @Override
    public List<Hospital> buscarTodas() {
        return hospirepo.findAll();
    }

    @Override
    public Hospital buscarPorId(Integer idHospital) {
        Optional<Hospital> optional = hospirepo.findById(idHospital);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
    }

    @Override
    public Page<Hospital> buscarTodas(Pageable page) {
        return hospirepo.findAll(page);
    }



    @Override
    public List<Hospital> buscarByExample(Example<Hospital> example) {
        return hospirepo.findAll(example);
    }
    
}
