package co.edu.poligran.proyecto.controller;

import java.util.List;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poligran.proyecto.model.Dane;
import co.edu.poligran.proyecto.model.Mail;
import co.edu.poligran.proyecto.model.Persona;
import co.edu.poligran.proyecto.model.Usuario;
import co.edu.poligran.proyecto.repository.DaneRepository;
import co.edu.poligran.proyecto.repository.DocumentoRepository;
import co.edu.poligran.proyecto.repository.PersonaRepository;
import co.edu.poligran.proyecto.repository.UsuarioRepository;
import co.edu.poligran.proyecto.service.MailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@CrossOrigin(origins = "http://localhost:4200")
@Api(tags = { "Class: PersonaController" })
@RestController // Defines that this class is a spring bean
@RequestMapping("/api/v1/")
public class PersonaController {

	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private JavaMailSender emailSender;

	@Autowired
	private MailService notificationService;

	@Autowired
	private PersonaRepository personaRepository;

	@Autowired
	private DocumentoRepository documentoRepository;

	@Autowired
	private DaneRepository daneRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	String mailTo = "";
	String mailSubject = "Su usuario fue credo ";
	String mailContent = "Bienvendi@ a nuestro sistema para control de restitucion de tierras";
	String usuario = "";

	@GetMapping("/personasall")
	@ApiOperation(value = "*** Service Method Get All Persona ***", notes = "*** Get All Persona from CONFLICTO COLOMBIANO\\\\WebApp ***")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "*** Error Get All Customers!!! ***") })
	public List<Persona> getAllPersonass() {
		return personaRepository.findAll();
	}

	@GetMapping("/personas")
	public List<Persona> getAllPersonas() {
		return personaRepository.findAll();
	}

	@GetMapping("/personas/{idp}")
	public Persona getPersonaById(@PathVariable int idp) {
		Persona persona = personaRepository.findById(idp).get();
		return persona;
		/*
		 * if (personaRepository.existsById(idp)) { Persona persona =
		 * personaRepository.findById(idp).get(); return persona; return
		 * ResponseEntity.status(HttpStatus.OK).body(persona); } else { return
		 * ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		 */

	}

	@PostMapping("/personas")
	public Persona createPersona(@RequestBody Persona persona) {
		mailTo = persona.getCorreo();
		usuario = persona.getNombres() + " " + persona.getApellidos();

		System.out.println(mailTo);

		simpleTextMessage();
		return personaRepository.save(persona);

	}

	@PutMapping("/personas/{idp}")
	public Persona updatePersona(@PathVariable int idp, @RequestBody Persona personaNew) {
		Persona personadb = personaRepository.findById(idp).get();

		personadb.setIdp(personaNew.getIdp());
		personadb.setNombres(personaNew.getNombres());
		personadb.setApellidos(personaNew.getApellidos());
		personadb.setCelular(personaNew.getCelular());
		personadb.setCedula(personaNew.getCedula());
		personadb.setDireccion(personaNew.getDireccion());
		personadb.setDocumento(personaNew.getDocumento());
		personadb.setNivederiesgo(personaNew.getNivederiesgo());

		personaRepository.save(personadb);
		return personadb;
	}

	@DeleteMapping("/personas/{isp}")
	public Persona deleteBook(@PathVariable int idp) {
		Persona personadb = personaRepository.findById(idp).get();

		personadb.setDocumento(null);
		personadb.setUsuario(null);

		personaRepository.delete(personadb);
		return personadb;
	}

	@GetMapping("/datosprincipales")
	public List<Persona> getAllPersonasUsu() {
		return personaRepository.findByDatosPrincipales();
	}

	@GetMapping("/personasss")
	public List<Persona> getAllDocumentosPersona() {
		return personaRepository.findByDocumentosPersona();
	}

	@GetMapping("/messagge")
	public String sendEmail(@RequestBody Mail mail) {
		notificationService.sendEmail(mail);
		return "EMAIL ENVIADO EXITOSAMENTE";
	}

	public void simpleTextMessage() {
		String bodyMessage = "Estimad@ " + usuario + mailContent;

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(mailTo);
		message.setFrom("jose.david.rodriguez87@outlook.com");
		message.setSubject("Mensaje de Correo Electronico");
		message.setText(bodyMessage);

		emailSender.send(message);
	}
}