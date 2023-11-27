package com.peppermoney.util;

import org.springframework.stereotype.Component;

import com.peppermoney.dto.ExpensesDto;
import com.peppermoney.entity.Expenses;

@Component
public class ExpensesDtoConvertor {
	
	public ExpensesDto getExpensesdto(Expenses e)
	{ 
		return new ExpensesDto(e.getExpensesId(),e.getDependents(),e.getMonthlyExpenses(),e.getCreditLimit(),e.getLoanRepayments(),e.getCreditIssue(),e.getDuration());	
}

}
