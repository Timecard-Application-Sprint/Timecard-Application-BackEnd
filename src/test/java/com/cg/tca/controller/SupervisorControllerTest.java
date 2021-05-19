package com.cg.tca.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.cg.tca.entities.Supervisor;
import com.cg.tca.services.SupervisorService;
import com.cg.tca.services.TimeCardService;

@WebMvcTest(SupervisorController.class)
class  SupervisorControllerTest{
	
	@Autowired
	private MockMvc mockMvc;
	
	// LEARNING 1 :: DUMMY OBJECT :: MOCK OBJECT
	@MockBean
	private SupervisorService supervisorService;
	@MockBean
	private TimeCardService tcs;

	@Test
	void getSupervisorTest() throws Exception {
		
		Supervisor sup = new Supervisor();
		//e.setName("rahul");
		//e.setEmail("rahul@gmail.com");
		
		Mockito.when(supervisorService.getSupervisorById(Mockito.anyInt())).thenReturn(sup);
		
		mockMvc.perform(get("/api/supervisor/1"))
				.andExpect(MockMvcResultMatchers.status().isOk());
				//.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("rahul"));
	}


}

