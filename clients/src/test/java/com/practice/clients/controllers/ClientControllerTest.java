package com.practice.clients.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.practice.clients.controller.ClientController;
import com.practice.clients.entities.Client;
import com.practice.clients.service.ClientService;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
public class ClientControllerTest {
	
	@InjectMocks
	ClientController clientController;
	
	@Mock
	private ClientService clientService;
	
	
	@Test
	void findAllClientsTest () throws Exception {
		
		Client c1 = new Client();
		c1.setAge(25);
		Client c2 = new Client();
		c2.setAge(26);
        List<Client> lstClient = new ArrayList<Client>();
        
        lstClient.add(c1);
        lstClient.add(c2);
 
        when(clientService.findAll()).thenReturn(lstClient);
 
        // when
        List<Client> lstClientResult = clientService.findAll();
 
        // then
        assertThat(lstClientResult.size()).isEqualTo(2);
         
        assertThat(lstClientResult.get(0).getAge())
                        .isEqualTo(c1.getAge());
         
        assertThat(lstClientResult.get(1).getAge())
                        .isEqualTo(c2.getAge()); 
	}
	
	@Test
	void createClientTest () throws Exception {
		
		Client c1 = new Client();
		c1.setAge(25);
		c1.setIdentification("12345645");
		c1.setName("Jose Lema");
		c1.setGender("Masculino");
		c1.setAddress("Otavalo sn y principal");
		c1.setTelephone("098254785");
		c1.setClientId("A1");
		c1.setPassword("1234");
		c1.setState(true);
 
        when(clientService.save(c1)).thenReturn(c1);
 
        ResponseEntity<Map<String, Object>> responseEntity = clientController.createClient(c1);
        
        Client cResponse = (Client) responseEntity.getBody().get("client");
        
        assertThat(cResponse.getName()).isEqualTo(c1.getName());
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        
	}
}
