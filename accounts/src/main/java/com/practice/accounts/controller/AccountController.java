package com.practice.accounts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.accounts.entity.Account;
import com.practice.accounts.service.AccountService;

@RestController
@RequestMapping("/cuentas")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@GetMapping("/findAll")
	public List<Account> findAllAccounts() {
		return accountService.findAll();
	}
	
	@GetMapping("/findAllByClientFk/{id}")
	public List<Account> getAccountsByClientFk(@PathVariable Long id) {
		return accountService.findAllByClientFk(id);
	}
	
	@GetMapping("/findById/{id}")
	public Optional<Account> getAccount(@PathVariable String id) {
		return accountService.findById(id);
	}
	
	@PostMapping("/create")
	public Account createAccount(@RequestBody Account a) {
		return accountService.save(a);
	}
	
	@PutMapping("/update/{id}")
	public Account updateAccount(@PathVariable String id, @RequestBody Account a) {
		return accountService.update(id, a);
	}
	
	@DeleteMapping("/delete/{id}")
	public Account deleteAccount(@PathVariable String id,@RequestBody Account a) {
		return accountService.delete(id, a);
	}
	
}
