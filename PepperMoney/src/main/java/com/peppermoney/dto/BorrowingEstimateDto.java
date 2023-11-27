package com.peppermoney.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowingEstimateDto {
		
	private int borrowingEstimateId;
	private long loanAmount;
	private long monthlyExpenses;
	private long refinance;
	private String loanTerm;
	private String repaymentType;
	private double interest;
	private String paymentFrequency;

}
