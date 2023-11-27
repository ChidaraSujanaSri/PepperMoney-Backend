package com.peppermoney.entity;
import java.util.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "LoanDetails")
public class LoanDetails {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name="id")
	    private int id;

//	    public HashMap<String, ArrayList<String>> options =  new HashMap<>();
	    @Column(name="borrowers")
	    @NotNull(message="No. of borrowers cannot be null")
	    private int borrowers;

	    @Column(name = "purposeOfLoan")
	    @NotNull(message = "Purpose of Loan cannot be Null")
	    private String purposeOfLoan;

	    @Column(name="propertyValue")
	    @NotNull(message = "Value of Property cannot be Null")
	    private Long propertyValue;

	    @Column(name ="loanAmount")
	    @NotNull(message = "Loan Amount cannot be Null")
	    private long loanAmount;

	    @Column(name = "location")
	    @NotBlank(message = "Location cannot be Null")
	    private String location;

	    @Column(name = "intentToLive")
	    @NotNull(message = "Intent To Live cannot be Null")
	    private String intentToLive;

	    @Column(name = "repaymentType")
	    @NotNull(message = "Repayment Type cannot be Null")
	    private String repaymentType;


}
