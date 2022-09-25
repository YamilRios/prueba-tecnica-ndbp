package com.practice.accounts.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	
	@Id
	private String accountNumber;
	private String accountType;
	private Double balance;
	private Boolean state;
	private Long clientFk;
	/*
	@Transient
	private Client client;
	*/
}
