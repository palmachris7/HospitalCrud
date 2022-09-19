package palma.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import palma.app.models.Cita;



public interface CitaRepository extends JpaRepository<Cita, Integer> {
    
}
