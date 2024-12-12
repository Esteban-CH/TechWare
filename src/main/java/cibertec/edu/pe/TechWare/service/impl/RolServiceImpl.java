package cibertec.edu.pe.TechWare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.edu.pe.TechWare.entity.Rol;
import cibertec.edu.pe.TechWare.repository.RolRepository;
import cibertec.edu.pe.TechWare.service.RolService;

@Service
public class RolServiceImpl implements RolService{

	@Autowired
	private RolRepository rolRepository;
	
	@Override
	public List<Rol> listaRoles() {
		return rolRepository.findAll();
	}

	@Override
	public Rol findByNombre(String nombre) {
		return rolRepository.findByNombre(nombre);
	}

}
