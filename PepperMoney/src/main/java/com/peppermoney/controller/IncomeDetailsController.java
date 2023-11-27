package com.peppermoney.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.peppermoney.entity.IncomeDetails;
import com.peppermoney.exception.IncomeNotFoundException;
import com.peppermoney.repository.IncomeDetailsRepository;
import com.peppermoney.serviceImpl.IncomeDetailsServiceImpl;

import java.util.Optional;
@RestController
@RequestMapping("/incomeDetails")

public class IncomeDetailsController {
	
	 @Autowired
	 IncomeDetailsServiceImpl incomeDetailsService;

	    @Autowired
	    IncomeDetailsRepository repository;

	    @GetMapping("/allIncome")
	    public ResponseEntity<?> getAllIncome() throws IncomeNotFoundException {
	        if(repository.findAll().isEmpty()){
	            throw new IncomeNotFoundException("No Income in list");
	        }

	        else{
	            return new ResponseEntity<>(incomeDetailsService.incomeList(), HttpStatus.OK);
	        }
	    }

	    @PostMapping("/addIncome")
	    public ResponseEntity<?>createIncome(@RequestBody IncomeDetails incomeDetails) throws IncomeNotFoundException{
	        Optional<IncomeDetails> opt = repository.findById(incomeDetails.getId());
	        if(opt.isPresent()){
	            throw new IncomeNotFoundException("Income already exists");
	        }
	        else{
	        	incomeDetailsService.addIncome(incomeDetails);
	            return new ResponseEntity<>("Income is added to the list",HttpStatus.CREATED);
	        }
	    }

	    @DeleteMapping("/deleteIncome/{id}")
	    public ResponseEntity<?> deleteIncome(@PathVariable("id") int id) throws IncomeNotFoundException{
	        Optional<IncomeDetails> opt = repository.findById(id);
	        if(opt.isPresent()){
	            incomeDetailsService.deleteIncome(id);
	            return new ResponseEntity<>("Income id: " + id +" is deleted",HttpStatus.OK);
	        }
	        else{
	            throw new IncomeNotFoundException("Income Id: "+id+" is not found");
	        }
	    }

	    @PutMapping("/updateIncome/{id}")
	    public ResponseEntity<?> updateIncome(@PathVariable int id,@RequestBody IncomeDetails incomeDetails) throws IncomeNotFoundException{
	    	IncomeDetails income = repository.findById(id).orElseThrow(() -> new IncomeNotFoundException("Income not found for this Id: "+id));
	        income.setIncomeType(incomeDetails.getIncomeType());
	        income.setIncomeValue(incomeDetails.getIncomeValue());
	        income.setSelfYears(incomeDetails.getSelfYears());
	        income.setSelfMonths(incomeDetails.getSelfMonths());
	        

	        final IncomeDetails updateIncome= repository.save(income);
	        return ResponseEntity.ok(updateIncome);
	    }

}
