package org.customer.service.controller;

import java.util.List;

import org.customer.service.entities.Customer;
import org.customer.service.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CustomerController {
	private CustomerRepository customerRepository;
	
	@GetMapping("/customers")
	public List<Customer> customerList(){
		return customerRepository.findAll();
	}
	
	@GetMapping("/customers/{id}")
	public Customer customerById(@PathVariable(value = "id") Long id) {
		return customerRepository.findById(id).get();
	}
}
