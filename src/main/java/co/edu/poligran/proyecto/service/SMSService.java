package co.edu.poligran.proyecto.service;


import com.twilio.rest.api.v2010.account.Message;

import co.edu.poligran.proyecto.model.SMS;



public interface SMSService {
	
	public Message sendSMS(SMS sms);

}