package com.peppermoney.util;

import org.springframework.stereotype.Component;

import com.peppermoney.dto.BorrowingEstimateDto;
import com.peppermoney.entity.BorrowingEstimate;

@Component
public class BorrowingEstimateDtoConvertor {
	
	public BorrowingEstimateDto getBorrowingEstimateDto(BorrowingEstimate BE)
	{ 
		return new BorrowingEstimateDto(BE.getBorrowingEstimateId(),BE.getLoanAmount(),BE.getMonthlyExpenses(),BE.getRefinance(),BE.getLoanTerm(),BE.getRepaymentType(),BE.getInterest(),BE.getPaymentFrequency());
}

}
