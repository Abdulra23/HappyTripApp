package com.myapp.happytrip.integration;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.happytrip.model.Passenger;
import com.myapp.happytrip.repository.PassengerList;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class TravellerDetailsIntegrationTest {

		@Autowired
		private PassengerList repository;
		
		@Autowired
		private MockMvc mockMvc;
		
		private static File DATA_JSON= Paths.get("src","test","resources","TravellerDetailsInteg.json").toFile();
		
		@BeforeEach
		public void setUp() throws JsonParseException, JsonMappingException, IOException {
				
			Passenger Passenger[] = new ObjectMapper().readValue(DATA_JSON, Passenger[].class);
			
			Arrays.stream(Passenger).forEach(repository::save);
		}
		
		@AfterEach
		public void cleanUp() {
			repository.deleteAll();
		}
		
		@Test
		@DisplayName("Test Add New Passenger(post)")
		public void testAddNewProduct() throws Exception {
			
			Passenger newpassenger = new Passenger(5, "Abdul","Raheem","abdulraheem7794@gmail.com","2637289745",23,"M");
	
			Passenger mockpassenger = new Passenger(5, "Vamsi","Krishna","vamsikrishna4@gmail.com","2637289745",23,"M");
			mockpassenger.setPassenger_id(50);
			
			mockMvc.perform(post("/api/v1/passengerdetails")
					.contentType(MediaType.APPLICATION_JSON_VALUE)
					.content(new ObjectMapper().writeValueAsString(newpassenger)))
					// Validate Response Body
					.andExpect(status().isCreated())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
					.andExpect(jsonPath("$.passenger_id", is(5)))
					.andExpect(jsonPath("$.first_name", is("Abdul")))
					.andExpect(jsonPath("$.last_name", is("Raheem")))
					.andExpect(jsonPath("$.email", is("abdulraheem7794@gmail.com")))
					.andExpect(jsonPath("$.phone", is("2637289745")))
					.andExpect(jsonPath("$.age", is(23)))
					.andExpect(jsonPath("$.gender", is("M")));
		}
}