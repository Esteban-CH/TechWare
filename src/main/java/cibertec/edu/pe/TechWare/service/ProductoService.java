package cibertec.edu.pe.TechWare.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cibertec.edu.pe.TechWare.entity.Producto;

public interface ProductoService {
	
	public abstract List<Producto> listarProductos();
	public abstract Producto buscarPorId(Long id);
	public abstract Producto registrarProducto(Producto producto, MultipartFile file);
	public abstract Producto actualizarProducto(Producto producto, MultipartFile file);
	void eliminarProducto(Long id);
}
