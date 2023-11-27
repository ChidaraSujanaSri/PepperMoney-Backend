package com.peppermoney.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.peppermoney.entity.IncomeDetails;

public interface IncomeDetailsService {
	
	List<IncomeDetails> incomeList();

    public IncomeDetails addIncome(IncomeDetails incomeDetails);
    public void updateIncome(IncomeDetails incomeDetails);

    public void deleteIncome(int id);

    public IncomeDetails getIncome(int id);

}
