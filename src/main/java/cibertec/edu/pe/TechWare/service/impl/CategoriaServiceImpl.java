package cibertec.edu.pe.TechWare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.edu.pe.TechWare.entity.Categoria;
import cibertec.edu.pe.TechWare.repository.CategoriaRepository;
import cibertec.edu.pe.TechWare.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public List<Categoria> listarCategorias() {
		return categoriaRepository.findAll();
	}

	@Override
	public Categoria buscarPorId(Long id) {
		return categoriaRepository.findById(id).get();
	}

	@Override
	public Categoria registrarCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	@Override
	public Categoria actualizarCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	@Override
	public void eliminarCategoria(Long id) {
		categoriaRepository.deleteById(id);
	}

}
