package com.peppermoney.services;

import java.util.List;

import com.peppermoney.entity.LoanDetails;

public interface LoanDetailsService {

	 List<LoanDetails> loanList();

	    public LoanDetails addLoan(LoanDetails loanDetails);
	    public void updateLoan(LoanDetails loanDetails);

	    public void deleteLoan(int id);

	    public LoanDetails getLoan(int id);
}
