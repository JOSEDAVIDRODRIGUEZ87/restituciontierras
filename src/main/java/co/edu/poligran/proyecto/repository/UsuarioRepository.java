package co.edu.poligran.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.poligran.proyecto.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


	Usuario findByUserName(String userName);
}