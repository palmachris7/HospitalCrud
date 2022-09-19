package palma.app.service;

import java.util.List;


import palma.app.models.Distrito;


public interface IDistritoService {
    // void guardar(Distrito distrito);
	// void eliminar(Integer idDistrito);
	List<Distrito> buscarTodas();
	// Distrito buscarPorId(Integer idDistrito);
	// Page<Distrito> buscarTodas(Pageable page);
}
