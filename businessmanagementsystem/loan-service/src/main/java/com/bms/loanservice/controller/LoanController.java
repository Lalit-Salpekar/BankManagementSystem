package com.bms.loanservice.controller;

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

import com.bms.loanservice.model.LoanDetails;
import com.bms.loanservice.service.LoanService;



@RestController
public class LoanController {
	
	@Value("${data.insert.message}")
	private String insertMessage;
	
	@Value("${data.update.message}")
	private String updateMessage;
	
	@Autowired
	private LoanService loanService;
	
	
	@GetMapping(value="/getLoan/{loanId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LoanDetails> getLoanDetails(@PathVariable Long loanId) {
		return new ResponseEntity<LoanDetails>(loanService.getLoanDetail(loanId),HttpStatus.OK);	
	}
	
	@PostMapping(value="/addloan",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addLoan(@RequestBody LoanDetails loanDetails) {
		
			loanService.addLoanDetail(loanDetails);	
			return new ResponseEntity<String>(insertMessage,HttpStatus.OK);
	
	}
	
	@PutMapping(value="/updateLoan",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateLoan(@RequestBody LoanDetails loanDetails) {
		
			loanService.updateLoanDetail(loanDetails);	
			return new ResponseEntity<String>(updateMessage,HttpStatus.OK);
	
	}
	
}
