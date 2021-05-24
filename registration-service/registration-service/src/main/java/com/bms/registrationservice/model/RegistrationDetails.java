package com.bms.registrationservice.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@JsonIgnoreProperties({ "registrationId"})
public class RegistrationDetails extends BaseEntity {
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long registrationId;
	
	@Column(name="REGISTRATION_NUMBER",unique = true)
	private String regNumber;
	
	@Column(name="NAME",unique = true)
	private String name;
	
	@Column(name="USER_NAME",unique = true)
	private String userName;
	
	@Column(name="USER_PASSWORD")
	private String password;
	
	@Column(name="GUARDIAN_NAME")
	private String guardianName;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="USER_EMAIL",length=50,unique = true)
	private String emailAddress;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="MARITIAL_STATUS")
	private String maritalStatus;
	
	@Column(name="USER_PHONENUMBER",length=10,precision=10, scale=0,unique = true)
	private BigInteger contactNo;
	
	@Column(name="USER_DOB",length=10)
	private Date date0fBirth;
	
	@Column(name="ACCOUNT_TYPE")
	private String accountType;
	
	
	public RegistrationDetails() {
		super();
	}

	public RegistrationDetails(Long registrationId, String regNumber, String name, String userName, String password,
			String guardianName, String address, String emailAddress, String gender, String maritalStatus,
			BigInteger contactNo, Date date0fBirth, String accountType) {
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
	
}
