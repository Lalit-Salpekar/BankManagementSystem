package com.bms.routerservice.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class LoanDetails implements Serializable {
	
	
	private Long loanId;
	private String loanOwner;
	private String loanType;
	private String loanAmount;
	private Date loanApplyDate;
	private Integer rateOfInterest;
	private Integer durationofLoan;
	
	/*Education LoanDetails*/
	private BigInteger courseFee; 
	private String course;
	private String fatherName;
	
	/*Personal Loan*/
	private BigInteger annualIncome;
	private String companyName;
	
	public LoanDetails() {
		super();
		
	}

	public LoanDetails(Long loanId, String loanOwner, String loanType, String loanAmount, Date loanApplyDate,
			Integer rateOfInterest, Integer durationofLoan, BigInteger courseFee, String course, String fatherName,
			BigInteger annualIncome, String companyName) {
		super();
		this.loanId = loanId;
		this.loanOwner = loanOwner;
		this.loanType = loanType;
		this.loanAmount = loanAmount;
		this.loanApplyDate = loanApplyDate;
		this.rateOfInterest = rateOfInterest;
		this.durationofLoan = durationofLoan;
		this.courseFee = courseFee;
		this.course = course;
		this.fatherName = fatherName;
		this.annualIncome = annualIncome;
		this.companyName = companyName;
	}

	public Long getLoanId() {
		return loanId;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	public String getLoanOwner() {
		return loanOwner;
	}

	public void setLoanOwner(String loanOwner) {
		this.loanOwner = loanOwner;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public String getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Date getLoanApplyDate() {
		return loanApplyDate;
	}

	public void setLoanApplyDate(Date loanApplyDate) {
		this.loanApplyDate = loanApplyDate;
	}

	public Integer getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(Integer rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public Integer getDurationofLoan() {
		return durationofLoan;
	}

	public void setDurationofLoan(Integer durationofLoan) {
		this.durationofLoan = durationofLoan;
	}

	public BigInteger getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(BigInteger courseFee) {
		this.courseFee = courseFee;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public BigInteger getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(BigInteger annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
