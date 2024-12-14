package cibertec.edu.pe.TechWare.service;

import java.util.List;

import cibertec.edu.pe.TechWare.entity.Proveedor;

public interface ProveedorService {
	
	public abstract List<Proveedor> listarProveedores();
	public abstract Proveedor buscarPorId(Long id);
	public abstract Proveedor registrarProveedor(Proveedor proveedor);
	public abstract Proveedor actualizarProveedor(Proveedor proveedor);
	void eliminarProveedor(Long id);
	int contarProveedores();
}
