package com.bms.routerservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bms.routerservice.model.LoanDetails;
import com.bms.routerservice.model.LoginDetails;
import com.bms.routerservice.model.RegistrationDetails;
import com.bms.routerservice.model.UpdateRegisterUser;

@Service
public class RouterService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	@LoadBalanced
	public RestTemplate getNewRestTemplate() {
		
		return new RestTemplate();
	}
	
	
	public void registerUser(RegistrationDetails registrationDetails){
		HttpHeaders httpHeader =new HttpHeaders();
		httpHeader.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity httpEntity=new HttpEntity(registrationDetails,httpHeader);
		restTemplate.exchange("http://localhost:8082/bms/registration", HttpMethod.POST, httpEntity,new ParameterizedTypeReference<RegistrationDetails>() {
        });
	
	}
	
	public ResponseEntity<LoginDetails> validateUser(LoginDetails loginDetails) {
		HttpHeaders httpHeader =new HttpHeaders();
		httpHeader.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity httpEntity=new HttpEntity("",httpHeader);
		return restTemplate.exchange("http://localhost:8082/bms/login", HttpMethod.GET, httpEntity,new ParameterizedTypeReference<LoginDetails>() {
        });
	}
	
	public void updateUser(UpdateRegisterUser updateDetails) {
		HttpHeaders httpHeader =new HttpHeaders();
		httpHeader.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity httpEntity=new HttpEntity(updateDetails,httpHeader);
		restTemplate.exchange("http://localhost:8082/bms/updateUser", HttpMethod.PUT, httpEntity,new ParameterizedTypeReference<UpdateRegisterUser>() {
        });
		
	}


	public void registerLoan(LoanDetails loanDetails) {
		HttpHeaders httpHeader =new HttpHeaders();
		httpHeader.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity httpEntity=new HttpEntity(loanDetails,httpHeader);
		restTemplate.exchange("http://localhost:8083/bms/addloan", HttpMethod.POST, httpEntity,new ParameterizedTypeReference<RegistrationDetails>() {
        });
		
	}




	
	
	
	
	
	
	
	
	
	
}
