package com.hellospring;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class WebAppTest {
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
	}
	
	@Test
	public void getMessage() throws Exception {
		this.mockMvc.perform(get("/hello")).andExpect(status().isOk());
	}
	
	
	@Test
	public void getEmployee() throws Exception {		
		this.mockMvc.perform(get("/host/employee?gender=\"male\"")).andExpect(status().isOk());
		this.mockMvc.perform(get("/host/employee?gender=\"male\"")).andReturn().equals("John<br>Jim");
	}

}
