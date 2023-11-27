package com.peppermoney.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Expenses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int expensesId;
	private long dependents;
	private long monthlyExpenses;
	private long creditLimit; // limit on credit and other cards
	private long loanRepayments; // loan and other repayments
	private String creditIssue; // if any previous credit issue
	private String duration;
	
	
	

}
