package com.practice.movements.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.practice.movements.entity.Account;

@Component
public class AccountRestTemplate {
	
	@Value("${config.account.endpoint}")
	String path;
	
	@Autowired
	RestTemplate restTemplate;
	
	public Account getAccount(String id){
        return restTemplate.getForObject(path+"/findById/"+id, Account.class);
    }
	
	public Account updateAccount(Account a, String accountNumber){
		//MyRequest body = ...
		RequestEntity<Account> request = RequestEntity
				     .put(path+"/update/"+accountNumber)
				     .accept(MediaType.APPLICATION_JSON)
				     .body(a);
		return restTemplate.exchange(request, Account.class).getBody();
    }
}
