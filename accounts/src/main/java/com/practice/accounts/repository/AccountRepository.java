package com.practice.accounts.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.practice.accounts.entity.Account;

public interface AccountRepository extends CrudRepository<Account, String>{
	
	List<Account> findAllByClientFk(Long id);
}
                