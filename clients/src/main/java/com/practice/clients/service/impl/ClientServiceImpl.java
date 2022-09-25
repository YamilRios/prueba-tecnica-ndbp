package com.practice.clients.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.clients.entities.Client;
import com.practice.clients.repository.ClientRepository;
import com.practice.clients.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	ClientRepository clientRepository;

	@Override
	public List<Client> findAll() {
		return (List<Client>) clientRepository.findAll();
	}

	@Override
	public Client save(Client c) throws Exception{
		return clientRepository.save(c);
	}

	@Override
	public Optional<Client> findById(Long id) {
		return clientRepository.findById(id);
	}

	@Override
	public Client update(Long id, Client c) {
		return clientRepository.save(c);
	}

	@Override
	public Client delete(Long id, Client c) {
		clientRepository.deleteById(id);
		return c;
	}
	
}
