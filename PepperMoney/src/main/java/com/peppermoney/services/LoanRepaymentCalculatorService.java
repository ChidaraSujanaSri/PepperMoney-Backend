package com.peppermoney.services;

import org.springframework.stereotype.Service;

import com.peppermoney.entity.LoanRepaymentCalculator;

@Service
public interface LoanRepaymentCalculatorService {
	
	LoanRepaymentCalculator saveLoanRepaymentCalculator(LoanRepaymentCalculator calculator);

}
