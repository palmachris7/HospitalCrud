package palma.app.service;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import palma.app.models.Distrito;


public interface IDistritoService {
    // void guardar(Distrito distrito);
	// void eliminar(Integer idDistrito);
	List<Distrito> buscarTodas();
	// Distrito buscarPorId(Integer idDistrito);
	// Page<Distrito> buscarTodas(Pageable page);
}
