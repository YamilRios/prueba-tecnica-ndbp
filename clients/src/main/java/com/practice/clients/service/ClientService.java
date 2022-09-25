package com.practice.clients.service;

import java.util.List;
import java.util.Optional;

import com.practice.clients.entities.Client;

public interface ClientService {
	List<Client> findAll();

	Client save(Client c);

	Optional<Client> findById(Long id);

	Client update(Long id, Client c);

	Client delete(Long id, Client c);
}
