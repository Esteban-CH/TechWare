package cibertec.edu.pe.TechWare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cibertec.edu.pe.TechWare.entity.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{

	Rol findByNombre(String nombre);
}
