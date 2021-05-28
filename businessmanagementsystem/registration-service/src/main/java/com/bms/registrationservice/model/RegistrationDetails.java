package com.bms.registrationservice.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;



@Document(collection = "registration")
@JsonIgnoreProperties({ "registrationId"})
public class RegistrationDetails implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long registrationId;
	private String regNumber;
	private String name;
	private String userName;
	private String password;
	private String guardianName;
	private String address;
	private String emailAddress;
	private String gender;
	private String maritalStatus;
	private BigInteger contactNo;
	private Date date0fBirth;
	private String accountType;
	private List<LoanDetails> loan;
	
	
	public RegistrationDetails() {
		super();
	}


	public RegistrationDetails(Long registrationId, String regNumber, String name, String userName, String password,
			String guardianName, String address, String emailAddress, String gender, String maritalStatus,
			BigInteger contactNo, Date date0fBirth, String accountType, List<LoanDetails> loan) {
		super();
		this.registrationId = registrationId;
		this.regNumber = regNumber;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.guardianName = guardianName;
		this.address = address;
		this.emailAddress = emailAddress;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.contactNo = contactNo;
		this.date0fBirth = date0fBirth;
		this.accountType = accountType;
		this.loan = loan;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(Long registrationId) {
		this.registrationId = registrationId;
	}
	
	public String getRegNumber() {
	
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		
		this.password = password;
	}
	
	/*private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }*/
	public String getGuardianName() {
		return guardianName;
	}
	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public BigInteger getContactNo() {
		return contactNo;
	}
	public void setContactNo(BigInteger contactNo) {
		this.contactNo = contactNo;
	}
	public Date getDate0fBirth() {
		return date0fBirth;
	}
	public void setDate0fBirth(Date date0fBirth) {
		this.date0fBirth = date0fBirth;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public List<LoanDetails> getLoan() {
		return loan;
	}

	public void setLoan(List<LoanDetails> loan) {
		this.loan = loan;
	}
	
	@Override
    public String toString() {
    	ObjectMapper mapper = new ObjectMapper();
    	
    	String jsonString = "";
		try {
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			jsonString = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
    	return jsonString;
    }

}
