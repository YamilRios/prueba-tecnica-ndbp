package com.practice.report.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.practice.report.entity.Client;

@Component
public class ClientRestTemplate {
	
	@Value("${config.client.endpoint}")
	String path;
	
	@Autowired
	RestTemplate restTemplate;
	
	public Client getClient(Long id){
        return restTemplate.getForObject(path+"/findById/"+id.toString(), Client.class);
    }
	
}
