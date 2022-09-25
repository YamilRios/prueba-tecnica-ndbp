package com.practice.movements.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.movements.entity.Movement;
import com.practice.movements.service.MovementService;

@WebMvcTest(MovementController.class)
@RunWith(SpringRunner.class)
public class MovementControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	MovementController movementController;
	
	@Mock
	private MovementService movementService;
	
	
	@Test
	void findAllMovementsTest () throws Exception {
		
		Movement a1 = new Movement();
		a1.setMovementId("M1");
		Movement a2 = new Movement();
		a2.setMovementId("M2");
        List<Movement> lstMovementId = new ArrayList<Movement>();
        
        lstMovementId.add(a1);
        lstMovementId.add(a2);
 
        
        given(movementController.findAllMovements()).willReturn(lstMovementId);

        mvc.perform(get("http://localhost:8083/movimientos/findAll")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", IsCollectionWithSize.hasSize(2)))
                .andExpect(jsonPath("$[0].movementId", is(a1.getMovementId())));
        
        
	}
	
	@Test
	void createMovementTest () throws Exception {
		Map<String, Object> response = new HashMap<>();
		
		Movement m = new Movement();
		m.setMovementId("M1");
		
		response.put("movement", m);
		
		ResponseEntity<Map<String, Object>> a1 = new ResponseEntity<>(response, HttpStatus.CREATED);
		
		given(movementController.createMovement(m)).willReturn(a1);
		
		String json = new ObjectMapper().writeValueAsString(a1);
		
		
		mvc.perform(post("http://localhost:8083/movimientos/create")
				.contentType(MediaType.APPLICATION_JSON)
	            .content(json))
	            .andDo(print())
	            .andExpect(status().is2xxSuccessful());
		
        
	}
}
