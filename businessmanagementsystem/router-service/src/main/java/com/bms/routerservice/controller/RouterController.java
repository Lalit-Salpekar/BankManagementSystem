package com.bms.routerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bms.routerservice.model.LoanDetails;
import com.bms.routerservice.model.LoginDetails;
import com.bms.routerservice.model.RegistrationDetails;
import com.bms.routerservice.model.UpdateRegisterUser;
import com.bms.routerservice.service.RouterService;


@RestController
public class RouterController {
	
	@Autowired
	private RouterService routerService;
	
	@Value("${data.insert.message}")
	private String insertMessage;
	
	
	@Value("${data.update.message}")
	private String updateMessage;
	
	/* For Registering User*/
	@PostMapping(value="/registerUser",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addUser(@RequestBody RegistrationDetails registrationDetails) {
		
		routerService.registerUser(registrationDetails);	
			return new ResponseEntity<String>(insertMessage,HttpStatus.OK);
	
	}
	
	/* For Login User*/
	
	@GetMapping(value="/loginUser",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LoginDetails> loginUser(@RequestParam LoginDetails loginDetails){
		return routerService.validateUser(loginDetails);
		
	}
	
	/* Update User Details */
	
	
	@PutMapping(value="/updateUserDetails",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateLoanForUser(@RequestBody UpdateRegisterUser updateDetails) {
		
		routerService.updateUser(updateDetails);	
			return new ResponseEntity<String>(updateMessage,HttpStatus.OK);
	
	}
	
	
	
	
	/* Add Loan Details */
	
	@PostMapping(value="/addLoanDetails",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addLoanForUser(@RequestBody LoanDetails loanDetails) {
		
		routerService.registerLoan(loanDetails);	
			return new ResponseEntity<String>(insertMessage,HttpStatus.OK);
	
	}
	
	
	
	
	
}
