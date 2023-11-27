package com.peppermoney.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peppermoney.dto.CustomerDto;
import com.peppermoney.entity.Customer;
import com.peppermoney.services.CustomerService;
import com.peppermoney.util.CustomerDtoConvertor;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
      CustomerService customerService;
	
	@Autowired
	CustomerDtoConvertor customerDtoConvertor;
	
	public CustomerController() {
		logger.info("customer controller");
		System.err.println("customer controller");
	}
	
	@PostMapping("/register")
	public ResponseEntity<CustomerDto> saveCustomer(@RequestBody Customer customer) throws Exception {
		Customer savedCustomer = customerService.addCustomer(customer);
		logger.info(" --->> Customer saved " + savedCustomer);

		if (savedCustomer != null) {
			CustomerDto dtoObj = customerDtoConvertor.getCustomerdto(savedCustomer);
			return new ResponseEntity<CustomerDto>(dtoObj, HttpStatus.OK);

		}
		return null;
	}

}
