package cibertec.edu.pe.TechWare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.edu.pe.TechWare.entity.Venta;
import cibertec.edu.pe.TechWare.repository.VentaRepository;
import cibertec.edu.pe.TechWare.service.VentaService;

@Service
public class VentaServiceImpl implements VentaService{

	@Autowired
	private VentaRepository ventaRepository;
	
	@Override
	public List<Venta> listaVentas() {
		return ventaRepository.findAll();
	}

	@Override
	public Venta BuscarPorId(Long id) {
		return ventaRepository.findById(id).get();
	}

	@Override
	public Venta guardarVenta(Venta venta) {
		return ventaRepository.save(venta);
	}

	@Override
	public void eliminarVenta(Long id) {
		ventaRepository.deleteById(id);
	}

}
