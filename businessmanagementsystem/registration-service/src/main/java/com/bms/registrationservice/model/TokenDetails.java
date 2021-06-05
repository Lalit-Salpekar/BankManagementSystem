package com.bms.registrationservice.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="token")
public class TokenDetails implements Serializable {
	
	@Id
	private Double secretId;
	
	private String username;
	
	
	public TokenDetails() {
		super();
	}
	
	public TokenDetails(String username, Double secretId) {
		super();
		this.username = username;
		this.secretId = secretId;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Double getSecretId() {
		return secretId;
	}
	public void setSecretId(Double secretId) {
		this.secretId = secretId;
	}
	
	
	
}
