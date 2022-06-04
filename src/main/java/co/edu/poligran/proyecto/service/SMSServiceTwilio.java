package co.edu.poligran.proyecto.service;

import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import co.edu.poligran.proyecto.model.SMS;



@Service
public class SMSServiceTwilio implements SMSService{
	
    // Find your Account Sid and Token at twilio.com/console
    public static final String ACCOUNT_SID = "ACf2c9adf30208c72c8b8c478c3823afad";
    public static final String AUTH_TOKEN = "7d8004699d983cdf29d29dd0bf089217";

    @Override
    public Message sendSMS(SMS sms) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(sms.getPhoneNumberTo()),
                new com.twilio.type.PhoneNumber("+16203180608"),//The Twilio phone number
                sms.getBody())
           .create();

        return message;
    }

    
}

