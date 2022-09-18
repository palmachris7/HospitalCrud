package palma.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import palma.app.models.Sede;

public interface SedeRepository extends JpaRepository<Sede, Integer>{
    
}
