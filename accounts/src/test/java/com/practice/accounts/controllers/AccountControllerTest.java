package com.practice.accounts.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.accounts.controller.AccountController;
import com.practice.accounts.entity.Account;
import com.practice.accounts.service.AccountService;

@WebMvcTest(AccountController.class)
@RunWith(SpringRunner.class)
public class AccountControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	AccountController accountController;
	
	@Mock
	private AccountService accountService;
	
	
	@Test
	void findAllClientsTest () throws Exception {
		
		Account a1 = new Account();
		a1.setAccountNumber("478758");
		Account a2 = new Account();
		a2.setAccountNumber("225487");
        List<Account> lstAccount = new ArrayList<Account>();
        
        lstAccount.add(a1);
        lstAccount.add(a2);
 
        
        given(accountController.findAllAccounts()).willReturn(lstAccount);

        mvc.perform(get("http://localhost:8082/cuentas/findAll")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", IsCollectionWithSize.hasSize(2)))
                .andExpect(jsonPath("$[0].accountNumber", is(a1.getAccountNumber())));
        
        
	}
	
	@Test
	void createClientTest () throws Exception {
		
		Account a1 = new Account();
		a1.setAccountNumber("478758");
		
		given(accountController.createAccount(a1)).willReturn(a1);
		
		String json = new ObjectMapper().writeValueAsString(a1);
		
		
		mvc.perform(post("http://localhost:8082/cuentas/create")
				.contentType(MediaType.APPLICATION_JSON)
	            .content(json))
	            .andDo(print())
	            .andExpect(status().is2xxSuccessful());
		
        
	}
}
