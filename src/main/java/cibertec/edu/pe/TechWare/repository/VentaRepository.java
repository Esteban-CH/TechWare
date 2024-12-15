package cibertec.edu.pe.TechWare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cibertec.edu.pe.TechWare.entity.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long>{

}
