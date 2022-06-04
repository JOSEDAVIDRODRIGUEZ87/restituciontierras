package co.edu.poligran.proyecto.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.rest.api.v2010.account.Message;

import co.edu.poligran.proyecto.model.SMS;
import co.edu.poligran.proyecto.service.SMSService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SMSController {

	@Autowired
	private SMSService smsService;

	@PostMapping("/api/v1/sms")
	public Message sendSMS(@RequestBody SMS sms) {
		return smsService.sendSMS(sms);
	}

}