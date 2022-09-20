package palma.app.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import palma.app.models.Cita;



public interface ICitaService {
    void guardar(Cita cita);
	void eliminar(Integer idCita);
	List<Cita> buscarTodas();
	Page<Cita> buscarTodas(Pageable page);
	Cita buscarPorId(Integer idCita);
	
}
