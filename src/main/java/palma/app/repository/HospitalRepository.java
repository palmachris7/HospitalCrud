package palma.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import palma.app.models.Hospital;
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    
}
