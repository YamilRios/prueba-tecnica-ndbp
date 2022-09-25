package com.practice.movements.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.movements.entity.Account;
import com.practice.movements.entity.Movement;
import com.practice.movements.repository.MovementRepository;
import com.practice.movements.resttemplate.AccountRestTemplate;
import com.practice.movements.service.MovementService;

@Service
public class MovementServiceImpl implements MovementService {
	
	@Autowired
	MovementRepository movementRepository;
	
	@Autowired
	AccountRestTemplate accountRestTemplate;

	@Override
	public List<Movement> findAll() {
		return (List<Movement>) movementRepository.findAll();
	}

	@Override
	public Movement save(Movement m) throws IllegalArgumentException{
		Account account = accountRestTemplate.getAccount(m.getAccountFk());
		m.setInitialBalance(account.getBalance());
		
		if (m.getMovementType().equalsIgnoreCase("Debito")) {
			if(account.getBalance() - m.getAmount() >= 0) {
				// Actualizar el saldo de la cuenta
				account.setBalance(account.getBalance() - m.getAmount());
				accountRestTemplate.updateAccount(account, account.getAccountNumber());
				m.setAvaliableBalance(account.getBalance());
				return movementRepository.save(m);
			} else {
				 throw new IllegalArgumentException("Saldo no disponible");
			}
			
		} else {
			// Actualizar el saldo de la cuenta
			account.setBalance(account.getBalance() + m.getAmount());
			accountRestTemplate.updateAccount(account, account.getAccountNumber());
			m.setAvaliableBalance(account.getBalance());
			return movementRepository.save(m);
		}

	}

	@Override
	public Optional<Movement> findById(String id) {
		return movementRepository.findById(id);
	}

	@Override
	public Movement update(String id, Movement m) {
		return movementRepository.save(m);
	}

	@Override
	public Movement delete(String id, Movement m) {
		movementRepository.delete(m);
		return m;
	}

	@Override
	public List<Movement> findAllByAccountFk(String accountFk) {
		return movementRepository.findAllByAccountFk(accountFk);
	}
	
}
