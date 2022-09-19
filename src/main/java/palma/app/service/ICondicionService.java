package palma.app.service;

import java.util.List;




import palma.app.models.Condicion;

public interface ICondicionService {
    // void guardar(Condicion condicion);
	// void eliminar(Integer idCondicion);
	List<Condicion> buscarTodas();
	// Condicion buscarPorId(Integer idCondicion);
	// Page<Condicion> buscarTodas(Pageable page);
}
