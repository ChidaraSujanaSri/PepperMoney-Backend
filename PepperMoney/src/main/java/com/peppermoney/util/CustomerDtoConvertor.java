package com.peppermoney.util;

import org.springframework.stereotype.Component;

import com.peppermoney.dto.CustomerDto;
import com.peppermoney.entity.Customer;

@Component
public class CustomerDtoConvertor {
	
	public CustomerDto getCustomerdto(Customer c)
	{ 
		return new CustomerDto(c.getCustomerId(),c.getCustomerName(),c.getEmailId(),c.getMobileNo());

	
}

}
