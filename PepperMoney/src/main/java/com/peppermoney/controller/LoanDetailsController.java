package com.peppermoney.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.peppermoney.entity.LoanDetails;
import com.peppermoney.exception.LoanNotFoundException;
import com.peppermoney.repository.LoanDetailsRepository;
import com.peppermoney.services.LoanDetailsService;

import java.util.Optional;

@RestController
@RequestMapping("/loanDetails")
public class LoanDetailsController {
	
	 @Autowired
	    LoanDetailsService loanDetailsService;

	    @Autowired
	    LoanDetailsRepository repository;

	    @GetMapping("/allLoans")
	    public ResponseEntity<?> getAllLoans() throws LoanNotFoundException {
	        if(repository.findAll().isEmpty()){
	            throw new LoanNotFoundException("No Loans in list");
	        }

	        else{
	            return new ResponseEntity<>(loanDetailsService.loanList(), HttpStatus.OK);
	        }
	    }

	    @PostMapping("/addLoan")
	    public ResponseEntity<?> createLoan(@RequestBody LoanDetails loanDetails) throws LoanNotFoundException{
	        Optional<LoanDetails> opt = repository.findById(loanDetails.getId());
	        if(opt.isPresent()){
	            throw new LoanNotFoundException("Loan already exists");
	        }
	        else{
	            loanDetailsService.addLoan(loanDetails);
	            return new ResponseEntity<>("Loan is added to the list",HttpStatus.CREATED);
	        }
	    }

	    @DeleteMapping("/deleteLoan/{id}")
	    public ResponseEntity<?> deleteLoan(@PathVariable("id") int id) throws LoanNotFoundException{
	        Optional<LoanDetails> opt = repository.findById(id);
	        if(opt.isPresent()){
	            loanDetailsService.deleteLoan(id);
	            return new ResponseEntity<>("Loan id: " + id +" is deleted",HttpStatus.OK);
	        }
	        else{
	            throw new LoanNotFoundException("Loan Id: "+id+" is not found");
	        }
	    }

	    @PutMapping("/updateLoan/{id}")
	    public ResponseEntity<?> updateLoan(@PathVariable int id,@RequestBody LoanDetails loanDetails) throws LoanNotFoundException{
	        LoanDetails loan = repository.findById(id).orElseThrow(() -> new LoanNotFoundException("Loan not found for this Id: "+id));
	        loan.setBorrowers(loanDetails.getBorrowers());
	        loan.setPurposeOfLoan(loanDetails.getPurposeOfLoan());
	        loan.setPropertyValue(loanDetails.getPropertyValue());
	        loan.setLoanAmount(loanDetails.getLoanAmount());
	        loan.setLocation(loanDetails.getLocation());
	        loan.setIntentToLive(loanDetails.getIntentToLive());
	        loan.setRepaymentType(loanDetails.getRepaymentType());

	        final LoanDetails updatedLoan= repository.save(loan);
	        return ResponseEntity.ok(updatedLoan);
	    }

}
