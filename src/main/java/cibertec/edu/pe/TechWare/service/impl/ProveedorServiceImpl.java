package cibertec.edu.pe.TechWare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.edu.pe.TechWare.entity.Proveedor;
import cibertec.edu.pe.TechWare.repository.ProveedorRepository;
import cibertec.edu.pe.TechWare.service.ProveedorService;

@Service
public class ProveedorServiceImpl implements ProveedorService{

	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@Override
	public List<Proveedor> listarProveedores() {
		return proveedorRepository.findAll();
	}

	@Override
	public Proveedor buscarPorId(Long id) {
		return proveedorRepository.findById(id).get();
	}

	@Override
	public Proveedor registrarProveedor(Proveedor proveedor) {
		return proveedorRepository.save(proveedor);
	}

	@Override
	public Proveedor actualizarProveedor(Proveedor proveedor) {
		return proveedorRepository.save(proveedor);
	}

	@Override
	public void eliminarProveedor(Long id) {
		proveedorRepository.deleteById(id);
	}

	@Override
	public int contarProveedores() {
		return (int) proveedorRepository.count();
	}

}
