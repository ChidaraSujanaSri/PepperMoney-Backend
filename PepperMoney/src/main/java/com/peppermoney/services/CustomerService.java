package com.peppermoney.services;

import org.springframework.stereotype.Service;

import com.peppermoney.entity.Customer;

@Service
public interface CustomerService {
	
	public Customer addCustomer(Customer customer)throws Exception;

}
