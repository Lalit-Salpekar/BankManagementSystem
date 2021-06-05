package com.bms.tokenservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.bms.tokenservice.model.TokenDetails;


public interface TokenRepository extends MongoRepository<TokenDetails, Double> {
	
	@Query("{token:'?0'}")
	public TokenDetails findByUserName(String username);
}
