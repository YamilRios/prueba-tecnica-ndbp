package com.practice.report.entity;

import java.util.List;

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
	private List<Movement> lstMovements;
	
}
