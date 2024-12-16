package cibertec.edu.pe.TechWare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cibertec.edu.pe.TechWare.entity.DetalleVenta;
import cibertec.edu.pe.TechWare.repository.DetalleVentaRepository;
import cibertec.edu.pe.TechWare.service.DetalleVentaService;

public class DetalleVentaServiceImpl implements DetalleVentaService{

	@Autowired
	private DetalleVentaRepository detalleVentaRepository;
	
	@Override
	public List<DetalleVenta> listadoDetalleVenta() {
		return detalleVentaRepository.findAll();
	}

	@Override
	public DetalleVenta buscarPorId(Long id) {
		return detalleVentaRepository.findById(id).get();
	}

	@Override
	public DetalleVenta guardarDetalleVenta(DetalleVenta detalleVenta) {
		return detalleVentaRepository.save(detalleVenta);
	}

	@Override
	public void eliminarDetalleVenta(Long id) {
		detalleVentaRepository.deleteById(id);
	}

}
