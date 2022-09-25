package com.practice.movements.service;

import java.util.List;
import java.util.Optional;

import com.practice.movements.entity.Movement;

public interface MovementService {
	
	List<Movement> findAll();
	
	List<Movement> findAllByAccountFk(String accountFk);

	Movement save(Movement m);

	Optional<Movement> findById(String id);

	Movement update(String id, Movement m);

	Movement delete(String id, Movement m);
}
