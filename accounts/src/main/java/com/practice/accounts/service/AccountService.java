package com.practice.accounts.service;

import java.util.List;
import java.util.Optional;

import com.practice.accounts.entity.Account;

public interface AccountService {
	
	List<Account> findAll();
	
	List<Account> findAllByClientFk(Long id);

	Account save(Account a);

	Optional<Account> findById(String id);

	Account update(String id, Account a);

	Account delete(String id, Account a);
}
