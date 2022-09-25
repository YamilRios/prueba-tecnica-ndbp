package com.practice.clients.repository;

import org.springframework.data.repository.CrudRepository;

import com.practice.clients.entities.Client;

public interface ClientRepository extends CrudRepository<Client, Long>{

}
