package com.peppermoney.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peppermoney.entity.BorrowingEstimate;
import com.peppermoney.entity.Expenses;
import com.peppermoney.exception.InvalidInputDataException;
import com.peppermoney.repository.BorrowingEstimateRepository;
import com.peppermoney.services.BorrowingEstimateService;

@Service
public class BorrowingEstimateServiceImpl implements BorrowingEstimateService{
	
	@Autowired
	BorrowingEstimateRepository borrowingEstimateRepository;
 
	@Override
	public BorrowingEstimate addBorrowingEstimate(BorrowingEstimate borrowingEstimate) throws Exception {
		if (borrowingEstimate != null) {
			if (borrowingEstimate.getPaymentFrequency().equals("")) {
				throw new InvalidInputDataException("borrowingEstimate", "borrowingEstimate is null");
			}
			BorrowingEstimate savedBorrowingEstimate = borrowingEstimateRepository.save(borrowingEstimate);
			return savedBorrowingEstimate;
		} else
			throw new NullPointerException("borrowingEstimate is null");
	}
	
	@Override
	public List<BorrowingEstimate> getAllBorrowingEstimate() {
		return borrowingEstimateRepository.findAll();
	}

}
