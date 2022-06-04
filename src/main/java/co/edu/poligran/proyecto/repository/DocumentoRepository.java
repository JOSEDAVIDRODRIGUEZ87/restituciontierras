package co.edu.poligran.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.poligran.proyecto.model.Documento;


public interface DocumentoRepository extends JpaRepository<Documento,Integer>{

}