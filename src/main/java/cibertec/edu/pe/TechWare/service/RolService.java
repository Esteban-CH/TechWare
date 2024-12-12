package cibertec.edu.pe.TechWare.service;

import java.util.List;

import cibertec.edu.pe.TechWare.entity.Rol;

public interface RolService {

	public abstract List<Rol> listaRoles();
	public abstract Rol findByNombre(String nombre);
}
