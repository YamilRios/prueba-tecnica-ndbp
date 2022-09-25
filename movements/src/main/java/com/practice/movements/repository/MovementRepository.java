package com.practice.movements.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.practice.movements.entity.Movement;

public interface MovementRepository extends CrudRepository<Movement, String>{
	
	List<Movement> findAllByAccountFk(String accountFk);
}
