package org.account.service.controller;

import java.util.List;

import org.account.service.clients.CustomerRestClient;
import org.account.service.entities.BankAccount;
import org.account.service.model.Customer;
import org.account.service.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestController {
	private BankAccountRepository accountRepository;
	private CustomerRestClient customerRestClient;
	
	
	
	public AccountRestController(BankAccountRepository accountRepository, CustomerRestClient customerRestClient) {
		this.accountRepository = accountRepository;
		this.customerRestClient = customerRestClient;
	}

	@GetMapping("/accounts")
	public List<BankAccount> accountList(){
		List<BankAccount> accountList = accountRepository.findAll();
		accountList.forEach(acc -> {
			acc.setCustomer(customerRestClient.findCustomerById(acc.getCustomerId()));
		});
		return accountList;
	}
	
	@GetMapping("/accounts/{id}")
	public BankAccount bankAccountById(@PathVariable String id) {
		BankAccount bankAccount = accountRepository.findById(id).get();
		Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
		bankAccount.setCustomer(customer);
		return bankAccount;
	}

}
