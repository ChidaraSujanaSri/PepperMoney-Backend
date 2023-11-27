package com.peppermoney.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.peppermoney.entity.Expenses;


@Repository
public interface ExpensesRepository extends JpaRepository<Expenses,Integer> {

}
