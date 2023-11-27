package com.peppermoney.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peppermoney.entity.LoanRepaymentCalculator;
import com.peppermoney.services.LoanRepaymentCalculatorService;

@RestController
@RequestMapping("/loan")
public class LoanRepaymentCalculatorController {
	
	 private final LoanRepaymentCalculatorService service;

	    @Autowired
	    public LoanRepaymentCalculatorController(LoanRepaymentCalculatorService service) {
	        this.service = service;
	    }

	    @PostMapping("/apply")
	    public LoanRepaymentCalculator applyLoan(@RequestBody LoanRepaymentCalculator calculator) {
	        return service.saveLoanRepaymentCalculator(calculator);
	    }

}
