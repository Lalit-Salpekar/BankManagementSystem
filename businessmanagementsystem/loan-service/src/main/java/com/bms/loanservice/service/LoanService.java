package com.bms.loanservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bms.loanservice.model.LoanDetails;
import com.bms.loanservice.repository.LoanRepository;

@Service
public class LoanService {
	
	@Autowired
	private LoanRepository loanRepository;
	
	@Autowired
	RestTemplate restTemplate;

	@Bean
	@LoadBalanced
	public RestTemplate getNewRestTemplate() {
		
		return new RestTemplate();
	}
	
	
	 public boolean validateHeader(Double secretId){
		 
		 HttpHeaders httpHeader =new HttpHeaders();
			httpHeader.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity httpEntity=new HttpEntity("",httpHeader);
			ResponseEntity res=   restTemplate.exchange("http://localhost:8085/bms//token/"+secretId, HttpMethod.GET, httpEntity,new ParameterizedTypeReference<String>() {});
				
			if(res.getStatusCode().equals(HttpStatus.OK)) {
				return true;
			}
		 
		return false;
	}
	
	public LoanDetails getLoanDetail(Long loanId) {
		return loanRepository.findById(loanId).get();
	}

	public void addLoanDetail(LoanDetails loanDetails) {
		loanRepository.save(loanDetails);
	}


	public List<LoanDetails> getLoansDetail() {
		
		return loanRepository.findAll();
	}


	public void updateLoanDetail(LoanDetails loanDetails) {
		
		loanRepository.save(loanDetails);
		
	}


	public void deleteLoanDetail(LoanDetails loanDetails) {
		loanRepository.delete(loanDetails);
		
	}

}
