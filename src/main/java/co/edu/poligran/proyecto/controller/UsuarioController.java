package co.edu.poligran.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poligran.proyecto.model.Persona;
import co.edu.poligran.proyecto.model.Usuario;
import co.edu.poligran.proyecto.repository.PersonaRepository;
import co.edu.poligran.proyecto.repository.UsuarioRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController // Defines that this class is a spring bean
@RequestMapping("/api/v1/")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private PersonaRepository personaRepository;

	@GetMapping("/usuarios")
	public List<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
	}

	@GetMapping("/usuarios/{idu}")
	public Usuario getRegistrosUsuarioById(@PathVariable int idu) {
		Usuario usuario = usuarioRepository.findById(idu).get();
		return usuario;
	}

	@GetMapping("/usuarioss/{username}")
	public Usuario findByUserName(@PathVariable String username) {
		Usuario usuario = usuarioRepository.findByUserName(username);
		return usuario;
	}

	@PostMapping("/usuarios")
	public Usuario createUsuario(@RequestBody Usuario usuario) {

		return usuarioRepository.save(usuario);
	}

	@PutMapping("/usuarios/{idu}")
	public Usuario updateUsuario(@PathVariable int idu, @RequestBody Usuario usuarioNew) {
		Usuario usuario = usuarioRepository.findById(idu).get();

		usuario.setIdu(usuarioNew.getIdu());
		usuario.setUserName(usuarioNew.getUserName());
		usuario.setPassword(usuarioNew.getPassword());
		usuario.setActive(usuarioNew.isActive());
		usuario.setRoles(usuarioNew.getRoles());
		// usuario.setPersona(usuarioNew.getPersona());

		usuarioRepository.save(usuario);

		return usuario;
	}

	@DeleteMapping("/usuarios/{idu}")
	public Usuario deleteUsuario(@PathVariable int idu) {
		Usuario usuario = usuarioRepository.findById(idu).get();
		usuarioRepository.deleteById(idu);
		return usuario;
	}

	@PutMapping("/usuarios/{idu}/{idp}")
	public Usuario associate(@PathVariable int idu, @PathVariable int idp) {

		Usuario usuario = usuarioRepository.findById(idu).get();
		Persona persona = personaRepository.findById(idp).get();

		usuario.setPersona(persona);
		persona.setUsuario(usuario);

		usuarioRepository.save(usuario);
		personaRepository.save(persona);

		return usuario;
	}

}
