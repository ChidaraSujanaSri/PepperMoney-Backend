package com.peppermoney.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
	
	private int customerId;
	private String customerName;
	private String emailId;
	private long mobileNo;

}
