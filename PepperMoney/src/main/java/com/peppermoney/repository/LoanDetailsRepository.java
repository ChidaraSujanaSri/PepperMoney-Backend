package com.peppermoney.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.peppermoney.entity.LoanDetails;

import java.util.Optional;
@Repository
public interface LoanDetailsRepository extends JpaRepository<LoanDetails,Integer>{

}
