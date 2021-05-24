package com.bms.registrationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.registrationservice.model.RegistrationDetails;
import com.bms.registrationservice.repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository registrationRepository; 
	
	
	public void addUserDetail(RegistrationDetails registrationDetails) {
		if(null !=registrationDetails) {
			registrationDetails.setRegNumber("R"+ Math.floor(Math.random()*(999-100+1)+100));
		}
		registrationRepository.saveAndFlush(registrationDetails);
	}


	public RegistrationDetails getUserDetail(Long userId) {
		return registrationRepository.findById(userId).get();
	}

}
