package palma.app.service;

import java.util.List;


import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import palma.app.models.Hospital;

public interface IHospitalService {
    void guardar(Hospital gerente);
	void eliminar(Integer idGerente);
	List<Hospital> buscarTodas();
	Hospital buscarPorId(Integer idGerente);
	Page<Hospital> buscarTodas(Pageable page);
	List<Hospital> buscarByExample(Example<Hospital> example);
}
