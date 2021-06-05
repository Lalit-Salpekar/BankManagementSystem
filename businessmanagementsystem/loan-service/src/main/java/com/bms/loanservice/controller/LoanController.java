package com.bms.loanservice.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.bms.loanservice.model.LoanDetails;
import com.bms.loanservice.model.ResponseMessage;
import com.bms.loanservice.service.LoanService;



@RestController
public class LoanController {
	
	@Value("${data.insert.message}")
	private String insertMessage;
	
	@Value("${data.update.message}")
	private String updateMessage;
	
	@Value("${data.delete.message}")
	private String deleteMessage;
	
	@Autowired
	private LoanService loanService;
	
	
	
	/* For all loans*/
	@GetMapping(value="/loans",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getLoansDetails(@RequestHeader("secretId") @NotNull Double secretId) {
		
		boolean valid=loanService.validateHeader(secretId);
			
		if(valid) {
			
			return new ResponseEntity<List<LoanDetails>>(loanService.getLoansDetail(),HttpStatus.OK);
		}
		
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(false,new ArrayList(),"User don't have permissions to access"),HttpStatus.FORBIDDEN);
		
			
	}
	
	/* For Single loan */
	@GetMapping(value="/loans/{loanId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getLoanDetails(@RequestHeader("secretId") @NotNull Double secretId,@PathVariable Long loanId) {
		boolean valid=loanService.validateHeader(secretId);
		
		if(valid) {
			return new ResponseEntity<LoanDetails>(loanService.getLoanDetail(loanId),HttpStatus.OK);
		}
		
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(false,new ArrayList(),"User don't have permissions to access"),HttpStatus.FORBIDDEN);
			
	}
	
	/* Loan add */
	@PostMapping(value="/loans/{id}/apply",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addLoan(@RequestHeader("secretId") @NotNull Double secretId,@RequestBody LoanDetails loanDetails,@PathVariable Long id) {
			
		boolean valid=loanService.validateHeader(secretId);
		
		if(valid) {
			loanDetails.setLoanId(id);
			loanService.addLoanDetail(loanDetails);	
			return new ResponseEntity<String>(insertMessage,HttpStatus.OK);
		}
		
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(false,new ArrayList(),"User don't have permissions to access"),HttpStatus.FORBIDDEN);

	}
	
	/* Loan Update */
	@PutMapping(value="/loans/update",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateLoan(@RequestHeader("secretId") @NotNull Double secretId,@RequestBody LoanDetails loanDetails,@PathVariable Long id) {
			
		boolean valid=loanService.validateHeader(secretId);
		
		if(valid) {
			loanDetails.setLoanId(id);
			loanService.updateLoanDetail(loanDetails);	
			return new ResponseEntity<String>(updateMessage,HttpStatus.OK);
		}
		
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(false,new ArrayList(),"User don't have permissions to access"),HttpStatus.FORBIDDEN);

		
		
	
	}
	
	/* Remove Loan*/
	@DeleteMapping(value="/loans/{id}/close",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteLoan(@RequestHeader("secretId") @NotNull Double secretId,@RequestBody LoanDetails loanDetails,@PathVariable Long id) {
			
		boolean valid=loanService.validateHeader(secretId);
		
		if(valid) {
			loanDetails.setLoanId(id);
			loanService.deleteLoanDetail(loanDetails);	
			return new ResponseEntity<String>(deleteMessage,HttpStatus.OK);
		}
		
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(false,new ArrayList(),"User don't have permissions to access"),HttpStatus.FORBIDDEN);

	
	}
}
