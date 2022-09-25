package com.practice.report.entity;


import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Person implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String identification;
	private String name;
	private Integer age;
	private String gender;
	private String address;
	private String telephone;
	
	public Person(String identification, String name, Integer age, String gender, String address, String telephone) {
		super();
		this.identification = identification;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.telephone = telephone;
	}
	
	
}
