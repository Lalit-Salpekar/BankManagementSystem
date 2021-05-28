package com.bms.registrationservice.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "loan")
public class LoanDetails implements Serializable {
	
	
	@Id
	private Long LoanId;
	private String LoanType;
	private String LoanAmount;
	private Date LoanApplyDate;
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

	public LoanDetails(Long loanId, String loanType, String loanAmount, Date loanApplyDate, Integer rateOfInterest,
			Integer durationofLoan, BigInteger courseFee, String course, String fatherName, BigInteger annualIncome,
			String companyName) {
		super();
		LoanId = loanId;
		LoanType = loanType;
		LoanAmount = loanAmount;
		LoanApplyDate = loanApplyDate;
		this.rateOfInterest = rateOfInterest;
		this.durationofLoan = durationofLoan;
		this.courseFee = courseFee;
		this.course = course;
		this.fatherName = fatherName;
		this.annualIncome = annualIncome;
		this.companyName = companyName;
	}

	public Long getLoanId() {
		return LoanId;
	}

	public void setLoanId(Long loanId) {
		LoanId = loanId;
	}

	public String getLoanType() {
		return LoanType;
	}

	public void setLoanType(String loanType) {
		LoanType = loanType;
	}

	public String getLoanAmount() {
		return LoanAmount;
	}

	public void setLoanAmount(String loanAmount) {
		LoanAmount = loanAmount;
	}

	public Date getLoanApplyDate() {
		return LoanApplyDate;
	}

	public void setLoanApplyDate(Date loanApplyDate) {
		LoanApplyDate = loanApplyDate;
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
