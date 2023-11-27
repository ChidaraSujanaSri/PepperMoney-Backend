package com.peppermoney.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.peppermoney.entity.LoanRepaymentCalculator;

@Repository
public interface LoanRepaymentCalculatorRepository 
			extends JpaRepository<LoanRepaymentCalculator, Long>{

}
