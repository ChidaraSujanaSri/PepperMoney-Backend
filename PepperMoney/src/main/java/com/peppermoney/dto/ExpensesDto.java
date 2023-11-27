package com.peppermoney.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpensesDto {
	
	private int expensesId;
	private long dependents;
	private long monthlyExpenses;
	private long creditLimit; // limit on credit and other cards
	private long loanRepayments; // loan and other repayments
	private String creditIssue; // if any previous credit issue
	private String duration;

}
