package palma.app.service;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import palma.app.models.Gerente;

public interface IGerenteService {
    void guardar(Gerente gerente);
	void eliminar(Integer idGerente);
	List<Gerente> buscarTodas();
	Gerente buscarPorId(Integer idGerente);
	Page<Gerente> buscarTodas(Pageable page);
}
