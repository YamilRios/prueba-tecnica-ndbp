package com.practice.report.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.practice.report.entity.Report;
import com.practice.report.service.ReportService;

@RestController
@RequestMapping("/reportes")
public class ReportController {
	
	@Autowired
	ReportService reportService;
	
	@GetMapping("/{startDate}/{endDate}/{clientId}")
	public Report getMovementsByAccountFk(@PathVariable @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate, @PathVariable @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate,@PathVariable Long clientId) {
		return reportService.reportByDateAndClient(startDate, endDate, clientId);
	}
	
}
