package palma.app.service;

import java.util.List;

import palma.app.models.Cita;



public interface ICitaService {
    void guardar(Cita cita);
	void eliminar(Integer idCita);
	List<Cita> buscarTodas();
	Cita buscarPorId(Integer idCita);
	
}
