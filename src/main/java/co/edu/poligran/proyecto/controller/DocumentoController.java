package co.edu.poligran.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poligran.proyecto.repository.DocumentoRepository;
import co.edu.poligran.proyecto.repository.PersonaRepository;
import co.edu.poligran.proyecto.model.Documento;
import co.edu.poligran.proyecto.model.Persona;

@CrossOrigin(origins = "http://localhost:4200")
@RestController // Defines that this class is a spring bean
@RequestMapping("/api/v1/")
public class DocumentoController {

	@Autowired
	private DocumentoRepository documentoRepository;
	@Autowired
	private PersonaRepository personaRepository;

	@GetMapping("/documentos")
	public List<Documento> getAllDocumentos() {
		return documentoRepository.findAll();
	}

	@GetMapping("/documentos/{iddoc}")
	public Documento getRegistrosDocumentoById(@PathVariable int iddoc) {
		Documento documento = documentoRepository.findById(iddoc).get();
		return documento;
	}

	@PostMapping("/documentos")
	public Documento createDocumento(@RequestBody Documento documento) {
		return documentoRepository.save(documento);
	}

	@PutMapping("/documentos/{iddoc}")
	public Documento updateDocumento(@PathVariable int iddoc, @RequestBody Documento documentoNew) {
		Documento documento = documentoRepository.findById(iddoc).get();

		documento.setIddoc(documentoNew.getIddoc());
		documento.setNombre(documentoNew.getNombre());
		documento.setTipo(documentoNew.getTipo());
		documento.setCantidad(documentoNew.getCantidad());
		documento.setPersona(documentoNew.getPersona());

		documentoRepository.save(documento);

		return documento;
	}

	@DeleteMapping("/documentos/{iddoc}")
	public Documento deleteDocumento(@PathVariable int iddoc) {
		Documento documento = documentoRepository.findById(iddoc).get();
		documentoRepository.deleteById(iddoc);
		return documento;
	}

	@PutMapping("/documentos/{iddoc}/{idp}")
	public Documento associate(@PathVariable int iddoc, @PathVariable int idp) {

		Documento documento = documentoRepository.findById(iddoc).get();
		Persona persona = personaRepository.findById(idp).get();

		documento.setPersona(persona);

		documentoRepository.save(documento);
		personaRepository.save(persona);

		return documento;
	}
}
