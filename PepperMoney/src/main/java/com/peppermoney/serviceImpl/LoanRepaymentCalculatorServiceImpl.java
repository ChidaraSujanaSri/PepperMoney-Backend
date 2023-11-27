package com.peppermoney.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.peppermoney.entity.LoanRepaymentCalculator;
import com.peppermoney.repository.LoanRepaymentCalculatorRepository;
import com.peppermoney.services.LoanRepaymentCalculatorService;

@Service
public class LoanRepaymentCalculatorServiceImpl implements LoanRepaymentCalculatorService {
	
	private final LoanRepaymentCalculatorRepository calculatorRepository;

	@Autowired
    public LoanRepaymentCalculatorServiceImpl(LoanRepaymentCalculatorRepository calculatorRepository) {
        this.calculatorRepository = calculatorRepository;
    }

	public LoanRepaymentCalculator saveLoanRepaymentCalculator(LoanRepaymentCalculator calculator) {
		return calculatorRepository.save(calculator);
	}

}
