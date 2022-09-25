package com.practice.accounts.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.accounts.entity.Account;
import com.practice.accounts.repository.AccountRepository;
import com.practice.accounts.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountRepository accountRepository;

	@Override
	public List<Account> findAll() {
		return (List<Account>) accountRepository.findAll();
	}

	@Override
	public Account save(Account a) {
		return accountRepository.save(a);
	}

	@Override
	public Optional<Account> findById(String id) {
		return accountRepository.findById(id);
	}

	@Override
	public Account update(String id, Account a) {
		return accountRepository.save(a);
	}

	@Override
	public Account delete(String id, Account a) {
		accountRepository.delete(a);
		return a;
	}

	@Override
	public List<Account> findAllByClientFk(Long id) {
		return accountRepository.findAllByClientFk(id);
	}
	
}
