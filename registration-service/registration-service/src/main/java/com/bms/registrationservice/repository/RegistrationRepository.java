package com.bms.registrationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bms.registrationservice.model.RegistrationDetails;

@Repository
public interface RegistrationRepository extends JpaRepository<RegistrationDetails, Long> {

}
