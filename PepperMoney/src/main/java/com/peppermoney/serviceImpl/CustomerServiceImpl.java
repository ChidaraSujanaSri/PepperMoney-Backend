package com.peppermoney.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peppermoney.entity.Customer;
import com.peppermoney.exception.InvalidInputDataException;
import com.peppermoney.repository.CustomerRepository;
import com.peppermoney.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer) throws Exception {
			if (customer != null) {
				if (customer.getCustomerName().equals("")) {
					throw new InvalidInputDataException("customer", "customer is null");
				}
				Customer savedCustomer = customerRepository.save(customer);
				return savedCustomer;
			} else
				throw new NullPointerException("customer is null");
		}

}
