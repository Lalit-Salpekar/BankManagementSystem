package com.bms.tokenservice.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bms.tokenservice.model.ResponseMessage;
import com.bms.tokenservice.model.TokenDetails;
import com.bms.tokenservice.repository.TokenRepository;




@RestController
public class TokenController {
	
	@Value("${data.insert.message}")
	private String insertMessage;
	
	@Value("${data.delete.message}")
	private String deleteMessage;
	
	@Autowired
	private TokenRepository tokenRepository;
	
	@GetMapping(value="/token/{secretId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getToken(@PathVariable Double secretId) {
		
		TokenDetails tokenDetails =tokenRepository.findById(secretId).get();
		
		if(null==tokenDetails) {
			return new ResponseEntity<ResponseMessage>(new ResponseMessage(false,new ArrayList(),"User has not Login"), HttpStatus.FORBIDDEN);
		}
			
		return new ResponseEntity<String>(tokenDetails.getUsername(), HttpStatus.OK);
	
		}
	
	
	@PostMapping(value="/generateToken",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addToken(@RequestBody TokenDetails tokenDetails) {
		
			tokenRepository.save(tokenDetails);
			return new ResponseEntity<String>(insertMessage,HttpStatus.OK);
	
	}
	
	@DeleteMapping(value="/deleteToken/{username}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> removeToken(@PathVariable String username) {
		TokenDetails tokenDetails =tokenRepository.findByUserName(username);	
			tokenRepository.delete(tokenDetails);
			return new ResponseEntity<String>(deleteMessage,HttpStatus.OK);
	
	}
	
	
}