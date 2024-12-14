package cibertec.edu.pe.TechWare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import cibertec.edu.pe.TechWare.entity.Usuario;
import cibertec.edu.pe.TechWare.repository.UsuarioRepository;
import cibertec.edu.pe.TechWare.service.UsuarioService;
import jakarta.servlet.http.HttpSession;

@Service
public class UsuarioServiceImpl  implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario buscarPorId(Long id) {
		return usuarioRepository.findById(id).get();
	}

	@Override
	public Usuario registrarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public void eliminarUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}

	@Override
	public Usuario findByNombreUsuario(String nombreUsuario) {
		return usuarioRepository.findByNombreUsuario(nombreUsuario);
	}

	@Override
	public boolean validarUsuario(Usuario usuario, HttpSession session) {
	    Usuario user = usuarioRepository.findByNombreUsuario(usuario.getNombreUsuario());
	    if (user != null && user.getContrasena().equals(usuario.getContrasena())) { 
	        session.setAttribute("usuarioLogueado", user);
	        return true;
	    }
	    return false;
	}

	@Override
	public int contarUsuarios() {
		return (int) usuarioRepository.count();
	}
	
}
