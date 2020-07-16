package com.projet.formationCertification.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class EmailController {
	public JavaMailSender jms  ;
	
	@Autowired
	public  EmailController(JavaMailSender jms) {

		this.jms = jms;
	} 
	
	@RequestMapping("/envoiMail")
	public String envoyer(@RequestParam("to") String to , @RequestParam("text") String  text, @RequestParam("objet") String  ob) {
		SimpleMailMessage mail=new SimpleMailMessage();
		mail.setTo(to);
		mail.setFrom("amirahajkacem123@gmail.com");
		mail.setSubject(ob);
		mail.setText(text);
		jms.send(mail);


	
		
		return "SS" ;
}
}
