package com.hellospring;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HostControllerTest {

	private MockMvc mockMvc;
	
	private ObjectMapper mapper = new ObjectMapper();

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new HostController()).build();
	}

	@Test
	public void selectGenderAndExpectStatusOk() throws Exception {
		this.mockMvc.perform(get("/host/employees?gender=\"male\"")).andExpect(status().isOk());
	}

	@Test
	public void checkContentByGet() throws Exception {
		String result = this.mockMvc.perform(get("/host/employees?gender=male")).andReturn().getResponse()
				.getContentAsString();
		assertEquals("John<br>Jim<br>", result);
	}

	@Test
	public void createEmployeeAndExpectStatusOk() throws Exception {
		String json = mapper.writeValueAsString(new Employee("Jeremy", "male"));
		System.out.println(json);
		mockMvc.perform(post("/host/employees").contentType(MediaType.APPLICATION_JSON)
				.content(json).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
