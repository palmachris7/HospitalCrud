package palma.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import palma.app.models.Condicion;


public interface CondicionRepository extends JpaRepository<Condicion, Integer> {
    
}
