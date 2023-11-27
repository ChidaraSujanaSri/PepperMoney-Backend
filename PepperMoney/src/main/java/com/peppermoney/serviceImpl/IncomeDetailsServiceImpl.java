package com.peppermoney.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.peppermoney.entity.IncomeDetails;
import com.peppermoney.repository.IncomeDetailsRepository;
import com.peppermoney.services.IncomeDetailsService;

import java.util.List;

@Service
public class IncomeDetailsServiceImpl implements IncomeDetailsService {

    @Autowired
    private IncomeDetailsRepository repository;
    
    @Override
    public List<IncomeDetails> incomeList() {
        return repository.findAll();
    }

    @Override
    public IncomeDetails addIncome(IncomeDetails incomeDetails) {
        return repository.save(incomeDetails);
    }

    @Override
    public void updateIncome(IncomeDetails IncomeDetails) {
        repository.save(IncomeDetails);

    }

    @Override
    public void deleteIncome(int id) {
        repository.deleteById(id);

    }

    @Override
    public IncomeDetails getIncome(int id) {
        return repository.findById(id).get();
    }


}
