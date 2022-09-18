package palma.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import palma.app.models.Usuario;
import palma.app.repository.UsuariosRepository;
import palma.app.service.IUsuariosService;

@Service
public class UsuarioServiceImp implements IUsuariosService {
    @Autowired
	private UsuariosRepository usuariosRepo;
    
    @Override
    public void guardar(Usuario usuario) {
        usuariosRepo.save(usuario);
        
    }

    @Override
    public void eliminar(Integer idUsuario) {
        usuariosRepo.deleteById(idUsuario);
        
    }

    @Override
    public List<Usuario> buscarTodos() {
        return usuariosRepo.findAll();
        
    }

    @Override
    public List<Usuario> buscarRegistrados() {
        
        return null;
    }

    @Override
    public Usuario buscarPorId(Integer idUsuario) {
        
        return null;
    }

    @Override
    public Usuario buscarPorUsername(String username) {
        return usuariosRepo.findByUsername(username);
    }
    
}
