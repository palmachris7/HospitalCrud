package palma.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import palma.app.models.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer>{
    Usuario findByUsername(String username);
	
} 
