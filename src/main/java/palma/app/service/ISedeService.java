package palma.app.service;

import java.util.List;

import palma.app.models.Sede;

public interface ISedeService {
    void guardar(Sede sede);
	void eliminar(Integer idSede);
	List<Sede> buscarTodas();
	Sede buscarPorId(Integer idSede);
}
