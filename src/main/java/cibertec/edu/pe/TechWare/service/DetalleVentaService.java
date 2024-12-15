package cibertec.edu.pe.TechWare.service;

import java.util.List;

import cibertec.edu.pe.TechWare.entity.DetalleVenta;

public interface DetalleVentaService {
	List<DetalleVenta> listadoDetalleVenta(); 
	DetalleVenta buscarPorId(Long id); 
	DetalleVenta guardarDetalleVenta(DetalleVenta detalleVenta); 
	void eliminarDetalleVenta(Long id);
}
