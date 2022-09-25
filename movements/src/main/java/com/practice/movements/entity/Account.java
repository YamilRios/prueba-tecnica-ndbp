package com.practice.movements.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	
	private String accountNumber;
	private String accountType;
	private Double balance;
	private Boolean state;
	private Long clientFk;
	
}
