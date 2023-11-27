package com.peppermoney.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peppermoney.dto.BorrowingEstimateDto;
import com.peppermoney.dto.ExpensesDto;
import com.peppermoney.entity.BorrowingEstimate;
import com.peppermoney.entity.Expenses;
import com.peppermoney.exception.LoanNotFoundException;
import com.peppermoney.repository.BorrowingEstimateRepository;
import com.peppermoney.services.BorrowingEstimateService;
import com.peppermoney.util.BorrowingEstimateDtoConvertor;

@RestController
@RequestMapping("/estimates")
public class BorrowingEstimateController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
      BorrowingEstimateService borrowingEstimateService;
	@Autowired
	BorrowingEstimateRepository borrowingEstimateRepository;
	@Autowired
	BorrowingEstimateDtoConvertor borrowingDtoConvertor;
	public BorrowingEstimateController() {
		logger.info("estimate controller");
		System.err.println("estimate controller");
	}
	@PostMapping("/add")
	public ResponseEntity<BorrowingEstimateDto> saveEstimates(@RequestBody BorrowingEstimate borrowingEstimate) throws Exception {
		BorrowingEstimate savedBorrowingEstimate = borrowingEstimateService.addBorrowingEstimate(borrowingEstimate);
		logger.info(" --->> Estimate saved " + savedBorrowingEstimate);
 
		if (savedBorrowingEstimate != null) {
			BorrowingEstimateDto dtoObj = borrowingDtoConvertor.getBorrowingEstimateDto(savedBorrowingEstimate);
			return new ResponseEntity<BorrowingEstimateDto>(dtoObj, HttpStatus.OK);
 
		}
		return null;
	}
	
	@GetMapping("/allEstimates")
	public ResponseEntity<List<BorrowingEstimateDto>> getAllBorrowingEstimate()
	{
		List<BorrowingEstimate> allBorrowingEstimateInDB = borrowingEstimateService.getAllBorrowingEstimate();

		List<BorrowingEstimateDto> dtoList = new ArrayList<>();
		for (BorrowingEstimate borrowingEstimate : allBorrowingEstimateInDB) {

			BorrowingEstimateDto dtoObj = borrowingDtoConvertor.getBorrowingEstimateDto(borrowingEstimate);
			dtoList.add(dtoObj);
		}

		return new ResponseEntity<List<BorrowingEstimateDto>>(dtoList,HttpStatus.OK);
	}

}
