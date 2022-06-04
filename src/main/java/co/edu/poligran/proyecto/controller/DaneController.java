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

import co.edu.poligran.proyecto.model.Dane;
import co.edu.poligran.proyecto.model.Persona;
import co.edu.poligran.proyecto.repository.DaneRepository;
import co.edu.poligran.proyecto.repository.PersonaRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController // Defines that this class is a spring bean
@RequestMapping("/api/v1/")
public class DaneController {

	@Autowired
	private DaneRepository daneRepository;
	@Autowired
	private PersonaRepository personaRepository;

	@GetMapping("/registrosdane")
	public List<Dane> getAllDane() {
		return daneRepository.findAll();
	}

	@GetMapping("/registrosdane/{idd}")
	public Dane getRegistrosDaneById(@PathVariable int idd) {
		Dane dane = daneRepository.findById(idd).get();
		return dane;
	}

	@PostMapping("/registrosdane")
	public Dane createDane(@RequestBody Dane dane) {
		return daneRepository.save(dane);
	}

	@PutMapping("/registrosdane/{idd}")
	public Dane updateEditorial(@PathVariable int idd, @RequestBody Dane daneNew) {
		Dane dane = daneRepository.findById(idd).get();

		dane.setIdd(daneNew.getIdd());
		dane.setRegion(daneNew.getRegion());
		dane.setCoddanedep(daneNew.getCoddanedep());
		dane.setDepartamento(daneNew.getDepartamento());
		dane.setCodddanemun(daneNew.getCodddanemun());
		dane.setMunicipio(daneNew.getMunicipio());
		dane.setPersona(daneNew.getPersona());

		daneRepository.save(dane);

		return dane;
	}

	@DeleteMapping("/registrosdane/{idd}")
	public Dane deleteEditorial(@PathVariable int idd) {
		Dane dane = daneRepository.findById(idd).get();
		daneRepository.deleteById(idd);
		dane.setPersona(null);
		return dane;
	}

	@PutMapping("/registrosdane/{idd}/{idp}")
	public Dane associate(@PathVariable int idd, @PathVariable int idp) {

		Dane dane = daneRepository.findById(idd).get();
		Persona persona = personaRepository.findById(idp).get();

		// persona.setDane_id();

		daneRepository.save(dane);
		personaRepository.save(persona);

		return dane;
	}

}