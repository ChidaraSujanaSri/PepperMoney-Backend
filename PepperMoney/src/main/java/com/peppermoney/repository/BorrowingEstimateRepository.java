package com.peppermoney.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.peppermoney.entity.BorrowingEstimate;

@Repository
public interface BorrowingEstimateRepository extends 
	JpaRepository<BorrowingEstimate, Integer> {

}
