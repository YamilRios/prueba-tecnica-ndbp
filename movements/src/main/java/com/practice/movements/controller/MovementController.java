package com.practice.movements.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.movements.entity.Movement;
import com.practice.movements.service.MovementService;

@RestController
@RequestMapping("/movimientos")
public class MovementController {
	
	@Autowired
	MovementService movementService;
	
	@GetMapping("/findAll")
	public List<Movement> findAllMovements() {
		return movementService.findAll();
	}
	
	@GetMapping("/findAllByAccountFk/{id}")
	public List<Movement> getMovementsByAccountFk(@PathVariable String id) {
		return movementService.findAllByAccountFk(id);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Map<String, Object>> createMovement(@RequestBody Movement m) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			movementService.save(m);
			response.put("movement", m);
			response.put("message", "Objeto creado satisfactoriamente");
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			response.put("message", e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping("/update/{id}")
	public Movement updateMovement(@PathVariable String id, @RequestBody Movement m) {
		return movementService.update(id, m);
	}
	
	@DeleteMapping("/delete/{id}")
	public Movement deleteMovement(@PathVariable String id, @RequestBody Movement m) {
		return movementService.delete(id, m);
	}
}
