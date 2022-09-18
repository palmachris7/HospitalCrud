package palma.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import palma.app.models.Sede;
import palma.app.repository.SedeRepository;
import palma.app.service.ISedeService;
@Service
public class SedeServiceImpl implements ISedeService {
    @Autowired
	private SedeRepository sederepo;
    @Override
    public void guardar(Sede sede) {
        sederepo.save(sede);
    }

    @Override
    public void eliminar(Integer idSede) {
        sederepo.deleteById(idSede);
    }

    @Override
    public List<Sede> buscarTodas() {
        return sederepo.findAll();
    }

    @Override
    public Sede buscarPorId(Integer idSede) {
        Optional<Sede> optional = sederepo.findById(idSede);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
    }
    
}
