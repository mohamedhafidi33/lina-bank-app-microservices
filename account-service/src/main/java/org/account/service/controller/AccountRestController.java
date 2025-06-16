package org.account.service.controller;

import java.util.List;

import org.account.service.entities.BankAccount;
import org.account.service.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestController {
	private BankAccountRepository accountRepository;
	
	
	
	public AccountRestController(BankAccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@GetMapping("/accounts")
	public List<BankAccount> accountList(){
		return accountRepository.findAll();
	}
	
	@GetMapping("/accounts/{id}")
	public BankAccount bankAccountById(@PathVariable String id) {
		return accountRepository.findById(id).get();
	}

}
