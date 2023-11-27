package com.peppermoney.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BorrowingEstimate")
public class BorrowingEstimate {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int borrowingEstimateId;
		private long loanAmount;
		private long monthlyExpenses;
		private long refinance;
		private String loanTerm;
		private String repaymentType;
		private double interest;
		//private int interest;
		private String paymentFrequency;// monthly, fornightly, weekly

}
