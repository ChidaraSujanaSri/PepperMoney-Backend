package com.peppermoney.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.peppermoney.entity.Expenses;
import com.peppermoney.exception.CustomException;

@Service
public interface ExpensesService {
	
	public Expenses addExpenses(Expenses expenses);
	public List<Expenses>getAllExpenses();
	public Expenses getExpensesById(int expensesId);
	public Expenses updateExpenses(Expenses expenses ,int expensesId)throws CustomException;
	public void deleteExpenses(int expensesId);

}
