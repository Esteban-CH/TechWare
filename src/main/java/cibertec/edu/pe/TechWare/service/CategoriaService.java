package cibertec.edu.pe.TechWare.service;

import java.util.List;

import cibertec.edu.pe.TechWare.entity.Categoria;

public interface CategoriaService {
	
	public abstract List<Categoria> listarCategorias();
	public abstract Categoria buscarPorId(Long id);
	public abstract Categoria registrarCategoria(Categoria categoria);
	public abstract Categoria actualizarCategoria(Categoria categoria);
	void eliminarCategoria(Long id);
	int contarCategorias();
	}
