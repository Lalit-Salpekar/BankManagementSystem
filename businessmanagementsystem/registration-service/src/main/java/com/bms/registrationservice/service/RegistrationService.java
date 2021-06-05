package com.bms.registrationservice.service;

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

import com.bms.registrationservice.model.LoginDetails;
import com.bms.registrationservice.model.RegistrationDetails;
import com.bms.registrationservice.model.TokenDetails;
import com.bms.registrationservice.model.UpdateRegisterUser;
import com.bms.registrationservice.repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository registrationRepository; 
	
	@Autowired
	RestTemplate restTemplate;

	@Bean
	@LoadBalanced
	public RestTemplate getNewRestTemplate() {
		
		return new RestTemplate();
	}
	
	
	public void addUserDetail(RegistrationDetails registrationDetails) {
		if(null !=registrationDetails) {
			registrationDetails.setRegNumber("R"+ Math.floor(Math.random()*(999-100+1)+100));
		}
		registrationRepository.save(registrationDetails);
	}


	public RegistrationDetails getUserDetail(Long userId) {
		return registrationRepository.findById(userId).get();
	}

	/* Programming is incomplete due to data mismatch*/
	public void updateUserDetail(UpdateRegisterUser updateRegisterDetails) {
		
		RegistrationDetails reg=new RegistrationDetails();
		registrationRepository.save(reg);
		
	}


	public boolean validateUser(LoginDetails loginDetails) {
		
		RegistrationDetails regDtl=registrationRepository.findCustomByUserName(loginDetails.getUserName());
		
		if(null == regDtl) {
			return false;
		}
		
		if(regDtl.getPassword().equals(loginDetails.getPassword())) {	
			
			HttpHeaders httpHeader =new HttpHeaders();
			httpHeader.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity httpEntity=new HttpEntity(new TokenDetails(loginDetails.getUserName(),Math.floor(Math.random()*(99999-1000+1)+1000)),httpHeader);
			ResponseEntity res=   restTemplate.exchange("http://localhost:8085/bms/generateToken", HttpMethod.POST, httpEntity,new ParameterizedTypeReference<String>() {});
				
			if(res.getStatusCode().equals(HttpStatus.OK)) {
				return true;
			}
			/*tokenRepository.save(new TokenDetails(loginDetails.getUserName(),Math.floor(Math.random()*(99999-1000+1)+1000)));*/	
		}
		
		return false;		
	}
	
	
	public boolean logOffUser(String username) {
		
		
		HttpHeaders httpHeader =new HttpHeaders();
		httpHeader.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity httpEntity=new HttpEntity("",httpHeader);
		ResponseEntity res =restTemplate.exchange("http://localhost:8085/bms/deleteToken/"+username, HttpMethod.DELETE, httpEntity,new ParameterizedTypeReference<String>() {});
		
		if(res.getStatusCode().equals(HttpStatus.OK)) {
			return true;
		}
		
		return false;
		
		
	}

	

}
