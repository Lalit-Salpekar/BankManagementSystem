package com.bms.registrationservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bms.registrationservice.model.RegistrationDetails;

@Repository
public interface RegistrationRepository extends MongoRepository<RegistrationDetails, Long> {

}
