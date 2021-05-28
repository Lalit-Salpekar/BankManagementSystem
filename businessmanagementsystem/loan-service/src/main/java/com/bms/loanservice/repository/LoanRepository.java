package com.bms.loanservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bms.loanservice.model.LoanDetails;



@Repository
public interface LoanRepository extends MongoRepository<LoanDetails, Long> {

}
