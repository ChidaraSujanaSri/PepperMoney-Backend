package com.peppermoney.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.peppermoney.entity.IncomeDetails;

import java.util.List;
import java.util.Optional;
@Repository
public interface IncomeDetailsRepository extends JpaRepository<IncomeDetails,Integer> {

	List<IncomeDetails> findAll();

}
