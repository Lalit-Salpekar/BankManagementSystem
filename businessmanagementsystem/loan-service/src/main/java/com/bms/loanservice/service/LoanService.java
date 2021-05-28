package com.bms.loanservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.loanservice.model.LoanDetails;
import com.bms.loanservice.repository.LoanRepository;

@Service
public class LoanService {
	
	@Autowired
	private LoanRepository loanRepository;
	
	public LoanDetails getLoanDetail(Long loanId) {
		return loanRepository.findById(loanId).get();
	}

	public void addLoanDetail(LoanDetails loanDetails) {
		loanRepository.save(loanDetails);
	}

	public void updateLoanDetail(LoanDetails loanDetails) {
		
		
		
	}

}
