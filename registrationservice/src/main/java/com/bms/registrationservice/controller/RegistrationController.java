package com.bms.registrationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bms.registrationservice.model.RegistrationDetails;
import com.bms.registrationservice.service.RegistrationService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class RegistrationController {
	
	@Value("${data.insert.message}")
	private String insertMessage;
	
	@Autowired
	private RegistrationService  registrationService;
	
	
	@GetMapping(value="/getUser/{UserId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RegistrationDetails> getBlog(@PathVariable Long UserId) {
		return new ResponseEntity<RegistrationDetails>(registrationService.getUserDetail(UserId),HttpStatus.OK);	
	}
	
	@PostMapping(value="/registration",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addUser(@RequestBody RegistrationDetails registrationDetails) {
		
			registrationService.addUserDetail(registrationDetails);	
			return new ResponseEntity<String>(insertMessage,HttpStatus.OK);
	
	}
	

}
