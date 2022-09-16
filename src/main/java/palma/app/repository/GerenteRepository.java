package palma.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import palma.app.models.Gerente;

public interface GerenteRepository extends JpaRepository<Gerente, Integer> {
    
}
