package com.practice.report.entity;


import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Client extends Person {

	private String clientId;
	private String password;
	private Boolean state;
	private List<Account> lstAccount;

	private static final long serialVersionUID = 1L;

	public Client(String identification, String name, Integer age, String gender, String address, String telephone,
			String clientId, String password, Boolean state, List<Account> lstAccount) {
		super(identification, name, age, gender, address, telephone);
		this.clientId = clientId;
		this.password = password;
		this.state = state;
		this.lstAccount = lstAccount;
	}
	
	
}
