package cibertec.edu.pe.TechWare.service;

import java.util.List;

import cibertec.edu.pe.TechWare.entity.Usuario;
import jakarta.servlet.http.HttpSession;

public interface UsuarioService {

	public abstract List<Usuario> listarUsuarios();
	public abstract Usuario buscarPorId(Long id);
	public abstract Usuario registrarUsuario(Usuario usuario);
	public abstract Usuario actualizarUsuario(Usuario usuario);
	void eliminarUsuario(Long id);
	
 	public abstract Usuario findByNombreUsuario(String nombreUsuario);
 	boolean validarUsuario(Usuario usuario, HttpSession session);
 	int contarUsuarios();
}
