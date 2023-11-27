package com.peppermoney.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.peppermoney.entity.BorrowingEstimate;
import com.peppermoney.entity.Expenses;

@Service
public interface BorrowingEstimateService {
	
	public BorrowingEstimate addBorrowingEstimate
			(BorrowingEstimate borrowingEstimate)throws Exception;
	public List<BorrowingEstimate>getAllBorrowingEstimate();

}
