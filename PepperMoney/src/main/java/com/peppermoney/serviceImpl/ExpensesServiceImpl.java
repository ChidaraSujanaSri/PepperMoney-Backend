package com.peppermoney.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peppermoney.entity.Expenses;
import com.peppermoney.exception.CustomException;
import com.peppermoney.repository.ExpensesRepository;
import com.peppermoney.services.ExpensesService;

@Service
public class ExpensesServiceImpl implements ExpensesService{
	
	@Autowired
	ExpensesRepository  expensesRepository;
	
	 @Override
	    public Expenses addExpenses(Expenses expenses) {
	        return expensesRepository.save(expenses);
	    }

	@Override
	public List<Expenses> getAllExpenses() {
		return expensesRepository.findAll();
	}

	@Override
	public Expenses getExpensesById(int expensesId) {
		 Optional<Expenses> expensesOptional = expensesRepository.findById(expensesId);
		    return expensesOptional.orElse(null);
	}



	
//	@Override
//	public Expenses updateExpenses(Expenses expenses, int expensesId) throws CustomException {
//	    Expenses existingExpenses = expensesRepository.findById(expensesId)
//	            .orElseThrow(() -> new CustomException("Expense doesn't exist with ID: " + expensesId));
//	    existingExpenses.setCreditIssue(expenses.getCreditIssue());
//	    existingExpenses.setDuration(expenses.getDuration());
//	    
//	    return expensesRepository.save(existingExpenses);
//	}
	@Override
	public Expenses updateExpenses(Expenses expenses, int expensesId) throws CustomException {
	    Expenses existingExpenses = expensesRepository.findById(expensesId)
	            .orElseThrow(() -> new CustomException("Expense doesn't exist with ID: " + expensesId));
	    existingExpenses.setCreditIssue(expenses.getCreditIssue());
	    existingExpenses.setDuration(expenses.getDuration());
	    existingExpenses.setDependents(expenses.getDependents());
	    existingExpenses.setMonthlyExpenses(expenses.getMonthlyExpenses());
	    existingExpenses.setCreditLimit(expenses.getCreditLimit());
	    existingExpenses.setLoanRepayments(expenses.getLoanRepayments());
	    return expensesRepository.save(existingExpenses);
	}
	
	 public void deleteExpenses(int expensesId) {
		 expensesRepository.deleteById(expensesId);
	 }
	 

}
