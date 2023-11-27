package com.peppermoney.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peppermoney.entity.LoanDetails;
import com.peppermoney.repository.LoanDetailsRepository;
import com.peppermoney.services.LoanDetailsService;

import java.util.List;

@Service
public class LoanDetailsServiceImpl implements LoanDetailsService {

    @Autowired
    private LoanDetailsRepository repository;

    @Override
    public List<LoanDetails> loanList() {
        return repository.findAll();
    }

    @Override
    public LoanDetails addLoan(LoanDetails loanDetails) {
        return repository.save(loanDetails);
    }

    @Override
    public void updateLoan(LoanDetails loanDetails) {
        repository.save(loanDetails);

    }

    @Override
    public void deleteLoan(int id) {
        repository.deleteById(id);

    }

    @Override
    public LoanDetails getLoan(int id) {
        return repository.findById(id).get();
    }

}
