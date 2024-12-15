package cibertec.edu.pe.TechWare.service;

import java.util.List;

import cibertec.edu.pe.TechWare.entity.Venta;

public interface VentaService {
	
	List<Venta> listaVentas(); 
	Venta BuscarPorId(Long id); 
	Venta guardarVenta(Venta venta); 
	void eliminarVenta(Long id);
}
