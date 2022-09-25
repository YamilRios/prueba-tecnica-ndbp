package com.practice.report.resttemplate;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.practice.report.entity.Movement;

@Component
public class MovementRestTemplate {
	@Value("${config.movement.endpoint}")
	String path;
	
	@Autowired
	RestTemplate restTemplate;
	
	public List<Movement> getMovementsByAccountFk(String accountFk){
        return Arrays.asList(restTemplate.getForObject(path+"/findAllByAccountFk/"+accountFk, Movement[].class));
    }
}
