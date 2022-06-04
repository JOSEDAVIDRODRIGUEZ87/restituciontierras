package co.edu.poligran.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.poligran.proyecto.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

	// SQL
	@Query(value = "SELECT persona.idp,persona.cedula,persona.nombres,persona.apellidos,persona.correo,persona.direccion,persona.celular,persona.nivelderiesgo, persona.usuario_id,persona.dane_id,dane.idd,dane.coddanedep,dane.coddanemun,dane.departamento,dane.municipio,dane.region\r\n"
			+ "			FROM persona\r\n"
			+ "            inner join dane on persona.dane_id=dane.idd", nativeQuery = true)
	List<Persona> findByDatosPrincipales();

	// SQL
	@Query(value = "SELECT persona.idp,persona.nombres,persona.apellidos,persona.direccion,persona.celular,persona.correo,persona.departamento_id,persona.usuario_id, documento.iddoc,documento.nombre,documento.tipo,documento.cantidad FROM persona inner join documento on persona.idp=documento.persona", nativeQuery = true)
	List<Persona> findByDocumentosPersona();
}
