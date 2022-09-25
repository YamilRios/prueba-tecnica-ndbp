package com.practice.clients.controller;

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

import com.practice.clients.entities.Client;
import com.practice.clients.service.ClientService;

@RestController
@RequestMapping("/clientes")
public class ClientController {
	
	@Autowired
	ClientService clientService;
	
	@GetMapping("/findAll")
	public List<Client> findAllClients() {
		return clientService.findAll();
	}
	
	@GetMapping("/findById/{id}")
	public Optional<Client> getClient(@PathVariable Long id) {
		return clientService.findById(id);
	}
	
	@PostMapping("/create")
	public Client createClient(@RequestBody Client c) {
		return clientService.save(c);
	}
	
	@PutMapping("/update/{id}")
	public Client updateClient(@PathVariable Long id, @RequestBody Client c) {
		return clientService.update(id, c);
	}
	
	@DeleteMapping("/delete/{id}")
	public Client deleteClient(@PathVariable Long id,@RequestBody Client c) {
		return clientService.delete(id, c);
	}
}
