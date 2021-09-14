package com.myapp.happytrip.web.api;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.happytrip.model.Passenger;
import com.myapp.happytrip.repository.PassengerList;

@SpringBootTest

@AutoConfigureMockMvc(addFilters = false)
public class PassengerAPITest {

	@MockBean
	private PassengerList repository;

	@Autowired
	private MockMvc mockMvc;

	private Object newPassenger;

	@Test
	@DisplayName("Test Add New Passenger")
	public void testAddNewPassenger() throws Exception {

// Prepare Mock Flight
		Passenger passenger = new Passenger(13, "Abdul", "Raheem", "abdulraheem7794@gmail.com", "7075874195", 22, "Male");
		Passenger mockPassenger = new Passenger(13, "Abdul", "Raheem", "abdulraheem@gmail.com", "985236553", 23, "Male");

// Prepare Mock Service Method

		doReturn(mockPassenger).when(repository).save(ArgumentMatchers.any());

// Perform GET Request

		mockMvc.perform(post("/api/v1/passengerdetails")
// Validate Status should be 200 OK and JSON response received

				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(new ObjectMapper().writeValueAsString(passenger)))

// Validate Response Body

				.andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))

				.andExpect(jsonPath("$.passenger_id", is(13)))
				.andExpect(jsonPath("$.first_name", is("Abdul")))
				.andExpect(jsonPath("$.last_name", is("Raheem")))
				.andExpect(jsonPath("$.email", is("abdulraheem@gmail.com")))
				.andExpect(jsonPath("$.phone", is("985236553")))
				.andExpect(jsonPath("$.age", is(23)))
				.andExpect(jsonPath("$.gender", is("Male")));

	}

}