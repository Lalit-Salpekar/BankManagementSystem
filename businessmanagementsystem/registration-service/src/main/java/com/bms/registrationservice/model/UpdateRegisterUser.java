package com.bms.registrationservice.model;

import java.math.BigInteger;
import java.util.Date;


public class UpdateRegisterUser {
	
	private Long customerId;
	private String name;
	private BigInteger accountNumber;
	private String country;
	private String state;
	private String gender;
	private Date dOB;
	private Date registrationDate;
	private String bankName;
	private String branchName;
	private String identificationProofType;
	private String identificationDocNumber;
	private String accountHolderName;
	private BigInteger accountHolderAccountNumber;
	private String accountHolderAddress;
	private String address;
	private BigInteger contactnumber;
	private String mailId;
	private String maritalStatus;
	private String accountType;
	private String citizenship;
	private String citizenstatus;
	private String guardianType;
	private String guardianName;
	
	
	public UpdateRegisterUser() {
		super();
		
	}
	
	
	public UpdateRegisterUser(Long customerId, String name, BigInteger accountNumber, String country, String state,
			String gender, Date dOB, Date registrationDate, String bankName, String branchName,
			String identificationProofType, String identificationDocNumber, String accountHolderName,
			BigInteger accountHolderAccountNumber, String accountHolderAddress, String address,
			BigInteger contactnumber, String mailId, String maritalStatus, String accountType, String citizenship,
			String citizenstatus, String guardianType, String guardianName) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.accountNumber = accountNumber;
		this.country = country;
		this.state = state;
		this.gender = gender;
		this.dOB = dOB;
		this.registrationDate = registrationDate;
		this.bankName = bankName;
		this.branchName = branchName;
		this.identificationProofType = identificationProofType;
		this.identificationDocNumber = identificationDocNumber;
		this.accountHolderName = accountHolderName;
		this.accountHolderAccountNumber = accountHolderAccountNumber;
		this.accountHolderAddress = accountHolderAddress;
		this.address = address;
		this.contactnumber = contactnumber;
		this.mailId = mailId;
		this.maritalStatus = maritalStatus;
		this.accountType = accountType;
		this.citizenship = citizenship;
		this.citizenstatus = citizenstatus;
		this.guardianType = guardianType;
		this.guardianName = guardianName;
	}


	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigInteger getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(BigInteger accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getdOB() {
		return dOB;
	}
	public void setdOB(Date dOB) {
		this.dOB = dOB;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getIdentificationProofType() {
		return identificationProofType;
	}
	public void setIdentificationProofType(String identificationProofType) {
		this.identificationProofType = identificationProofType;
	}
	public String getIdentificationDocNumber() {
		return identificationDocNumber;
	}
	public void setIdentificationDocNumber(String identificationDocNumber) {
		this.identificationDocNumber = identificationDocNumber;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public BigInteger getAccountHolderAccountNumber() {
		return accountHolderAccountNumber;
	}
	public void setAccountHolderAccountNumber(BigInteger accountHolderAccountNumber) {
		this.accountHolderAccountNumber = accountHolderAccountNumber;
	}
	public String getAccountHolderAddress() {
		return accountHolderAddress;
	}
	public void setAccountHolderAddress(String accountHolderAddress) {
		this.accountHolderAddress = accountHolderAddress;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public BigInteger getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(BigInteger contactnumber) {
		this.contactnumber = contactnumber;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getCitizenship() {
		return citizenship;
	}
	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}
	public String getCitizenstatus() {
		return citizenstatus;
	}
	public void setCitizenstatus(String citizenstatus) {
		this.citizenstatus = citizenstatus;
	}
	public String getGuardianType() {
		return guardianType;
	}
	public void setGuardianType(String guardianType) {
		this.guardianType = guardianType;
	}
	public String getGuardianName() {
		return guardianName;
	}
	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}
	
	

	
}
