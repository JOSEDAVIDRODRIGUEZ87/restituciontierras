package co.edu.poligran.proyecto.controller;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poligran.proyecto.model.Mail;
import co.edu.poligran.proyecto.service.MailService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class MailController {
 
	@Autowired
	private MailService notificationService;
	
	/* JSON email...
	{
	    "mailTo": "wsoto@poligran.edu.co",
	    "mailSubject": "hola mundo",
	    "mailContent": "bienvenidos",
	    "attachments" : ["/Users/wilsonsoto/Downloads/TransaccionPNCBANK.pdf"]
	}
	*/
	@GetMapping("/msg")
	public String sendEmail(@RequestBody Mail mail){
		
		notificationService.sendEmail(mail);
		return "Email sent successfully";
	}
	
}