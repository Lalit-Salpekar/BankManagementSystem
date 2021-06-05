package com.bms.registrationservice.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bms.registrationservice.model.LoginDetails;
import com.bms.registrationservice.model.RegistrationDetails;
import com.bms.registrationservice.model.ResponseMessage;
import com.bms.registrationservice.model.TokenDetails;
import com.bms.registrationservice.model.UpdateRegisterUser;
import com.bms.registrationservice.service.RegistrationService;

@RestController
public class RegistrationController {
	
	@Value("${data.insert.message}")
	private String insertMessage;
	
	@Autowired
	private RegistrationService registrationService;
		
	
	@PostMapping(value="/registration",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addUser(@RequestBody RegistrationDetails registrationDetails) {
		
			registrationService.addUserDetail(registrationDetails);	
			return new ResponseEntity<String>(insertMessage,HttpStatus.OK);
	
	}
	
	@GetMapping(value="/login",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseMessage> getLogin(@RequestBody LoginDetails loginDetails) {
		
		boolean response=registrationService.validateUser(loginDetails);
		if(response) {
			return new ResponseEntity<ResponseMessage>(new ResponseMessage(true,new ArrayList(),"No Error"), HttpStatus.OK);
		}
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(false,new ArrayList(),"Invalid Username or password"), HttpStatus.FORBIDDEN);
			
	}
	
	@GetMapping(value="/logout",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseMessage> getLogOut(@RequestBody TokenDetails tokenDetails) {
		
		
		
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(true,new ArrayList(),"Log Off Successfully"), HttpStatus.OK);
	}
	
	@PutMapping(value="/updateUser",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateUser(@RequestBody UpdateRegisterUser registrationDetails) {
		
			registrationService.updateUserDetail(registrationDetails);	
			return new ResponseEntity<String>(insertMessage,HttpStatus.OK);
	}
	
	
	@GetMapping(value="/getUser/{UserId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RegistrationDetails> getBlog(@PathVariable Long UserId) {
		return new ResponseEntity<RegistrationDetails>(registrationService.getUserDetail(UserId),HttpStatus.OK);	
	}

}
