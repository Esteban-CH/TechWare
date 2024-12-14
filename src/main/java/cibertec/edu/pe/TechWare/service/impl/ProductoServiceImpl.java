package cibertec.edu.pe.TechWare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cibertec.edu.pe.TechWare.entity.Producto;
import cibertec.edu.pe.TechWare.repository.ProductoRepository;
import cibertec.edu.pe.TechWare.service.ProductoService;
import cibertec.edu.pe.TechWare.utils.*;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public List<Producto> listarProductos() {
		return productoRepository.findAll();
	}

	@Override
	public Producto buscarPorId(Long id) {
		return productoRepository.findById(id).get();
	}

	@Override
	public Producto registrarProducto(Producto producto, MultipartFile file) {
		if (file != null && !file.isEmpty()) {
            String nombreImagen = Utilitarios.Imagen(file);
            producto.setImagenUrl(nombreImagen);
        }
		return productoRepository.save(producto);
	}

	@Override
	public Producto actualizarProducto(Producto producto, MultipartFile file) {
		Producto productoExistente = buscarPorId(producto.getId());
		if (file != null && !file.isEmpty()) {
            if (productoExistente.getImagenUrl() != null) {
                Utilitarios.eliminarImagen(productoExistente.getImagenUrl());
            }
            String nombreImagen = Utilitarios.Imagen(file);
            producto.setImagenUrl(nombreImagen);
        } else {
            producto.setImagenUrl(producto.getImagenUrl());
        }
		return productoRepository.save(producto);
	}

	@Override
	public void eliminarProducto(Long id) {
		productoRepository.deleteById(id);
	}

	@Override
	public int contarProductos() {
		return (int) productoRepository.count();
	}

}
