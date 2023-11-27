package com.peppermoney.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class LoanRepaymentCalculator {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Column(name = "frequency")
	    private String frequency;
	    @Column(name = "loan_amount")
	    private double loanAmount;
	    @Column(name = "loan_term_in_years")
	    private int loanTermInYears;
	    @Column(name = "repayment_type")
	    private String repaymentType;
	    @Column(name = "interest_rate")
	    private double interestRate;
	    @Column(name = "initial_interest")
	    private double initialInterest;
	    @Column(name = "principle_interest")
	    private double principleInterest;
	    
	    
	    
	    public LoanRepaymentCalculator() {
			
		}

		public LoanRepaymentCalculator(String frequency,double loanAmount,int loanTermInYears,double interestRate,String repaymentType, double initialInterest, double principleInterest) {
			super();
			this.frequency = frequency;
			this.loanAmount = loanAmount;
			this.loanTermInYears = loanTermInYears;
			this.interestRate = interestRate;
			this.repaymentType = repaymentType;
			this.initialInterest = initialInterest;
			this.principleInterest = principleInterest;
		}
		
		public String getFrequency() {
			return frequency;
		}

		public void setFrequency(String frequency) {
			this.frequency = frequency;
		}

		public double getLoanAmount() {
			return loanAmount;
		}

		public void setLoanAmount(double loanAmount) {
			this.loanAmount = loanAmount;
		}
		public int getLoanTermInYears() {
	        return loanTermInYears;
	    }

	    public void setLoanTermInYears(int loanTermInYears) {
	        this.loanTermInYears = loanTermInYears;
	    }

	    public double getInterestRate() {
	        return interestRate;
	    }
	    public void setInterestRate(double interestRate) {
	        this.interestRate = interestRate;
	    }

	    public String getRepaymentType() {
	        return repaymentType;
	    }

	    public void setRepaymentType(String repaymentType) {
	        this.repaymentType = repaymentType;
	    }
	    
	    public double getInitialInterest() {
			return initialInterest;
		}

		public void setInitialInterest(double initialInterest) {
			this.initialInterest = initialInterest;
		}
		
		public double getPrincipleInterest() {
			return principleInterest;
		}

		public void setPrincipleInterest(double principleInterest) {
			this.principleInterest = principleInterest;
		}


}
