package com.myapp.happytrip.integration;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.happytrip.model.Registration;
import com.myapp.happytrip.repository.RegistrationList;

@SpringBootTest

@AutoConfigureMockMvc(addFilters = false)
public class RegistrationIntegrationTest {
	

		@Autowired
		private RegistrationList repository;

		@Autowired
		private MockMvc mockMvc;

//		private static File DATA_JSON = Paths.get("src", "test", "resources", "Registration.json").toFile();

//		@BeforeEach
//		public void setUp() throws JsonParseException, JsonMappingException, IOException {
//
//			Registration registration[] = new ObjectMapper().readValue(DATA_JSON, Registration[].class);
//
//			Arrays.stream(registration).forEach(repository::save);
//		}

		@AfterEach
		public void cleanUp() {
			repository.deleteAll();

		}

//		@Test
//		@DisplayName("Test userregistrationdetails by emailId - GET /api/v1/Registration/userregistrationdetails/{emailId}")
//		public void testRegistrationByemailId() throws Exception {
//
//			mockMvc.perform(MockMvcRequestBuilders.get("/api/v1//Registration/userregistrationdetails/{emailId}", "abdulraheem7794@gmail.com"))
//					// Validate Status should be 200 OK and JSON response received
//
//					.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//					.andExpect(jsonPath("$[0].fullName", is("abdulraheem")))
//					.andExpect(jsonPath("$[0].emailId", is("abdulraheem7794@gmail.com")))
//					.andExpect(jsonPath("$[0].password", is("Abdul143@")))
//					.andExpect(jsonPath("$[0].dateOfBirth", is("01-07-1998")))
//					.andExpect(jsonPath("$[0].gender", is("Male")));
//					
//		}

	}



