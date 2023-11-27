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
@Table(name = "Customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	private String customerName;
	private String emailId;
	private long mobileNo;
	
	public Customer(String customerName,
			String emailId, long mobileNo) {
		super();
		
		this.customerName = customerName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
	}

}
