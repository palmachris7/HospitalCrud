package palma.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import palma.app.models.Distrito;


public interface DistritoRepository extends JpaRepository<Distrito, Integer> {
    
}
