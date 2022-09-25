package com.practice.report.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.practice.report.entity.Account;
import com.practice.report.entity.Client;
import com.practice.report.entity.Movement;
import com.practice.report.entity.Report;
import com.practice.report.resttemplate.AccountRestTemplate;
import com.practice.report.resttemplate.ClientRestTemplate;
import com.practice.report.resttemplate.MovementRestTemplate;
import com.practice.report.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	AccountRestTemplate accountRestTemplate;
	
	@Autowired
	MovementRestTemplate movementRestTemplate;
	
	@Autowired
	ClientRestTemplate clientRestTemplate;

	@Override
	public Report reportByDateAndClient(@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate, @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate, Long clientId) {
		Report report = new Report();
		Client c = clientRestTemplate.getClient(clientId);
		List<Account> lstAccount = accountRestTemplate.getAccountsByClientFk(clientId);
		
		lstAccount.stream().forEach(account -> {
			account.setLstMovements(movementRestTemplate.getMovementsByAccountFk(account.getAccountNumber())
					.stream()
					.filter(movement -> movement.getDate().before(endDate) && movement.getDate().after(startDate))
					.collect(Collectors.toList()));
		});
		
		c.setLstAccount(lstAccount);
		report.setClient(c);
		return report;
	}

}
