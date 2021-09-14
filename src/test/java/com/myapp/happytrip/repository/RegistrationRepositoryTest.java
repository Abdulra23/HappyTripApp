package com.myapp.happytrip.repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.happytrip.model.Registration;
import com.myapp.happytrip.repository.RegistrationList;

@SpringBootTest
public class RegistrationRepositoryTest {
	
		
		@Autowired
		private RegistrationList repository;
		
		private static File DATA_JSON= Paths.get("src","test","resources","Registration.json").toFile();
		
		@BeforeEach
		public void setUp() throws JsonParseException, JsonMappingException, IOException {
			
			Registration Registration[]= new ObjectMapper().readValue(DATA_JSON, Registration[].class);
		
		// save each product to database
		Arrays.stream(Registration).forEach(repository::save);	

	}
		@AfterEach
		public void cleanUp() {
			repository.deleteAll();
			
		}
//		@Test
//		@DisplayName("Test userregistrationdetails not found for a non existing emailId")
//		public void testRegistrationNotFoundForNonExistingemailId() {
//
//			// given three products in the database
//			
//			
//			// when we retrieve a product using non existing id
//			List<Registration> list=repository.findByemailId("abdulraheem7794@gmail.com").get();
//			
//			// Then perform Assert Conditions To validate
//			Assertions.assertNull(list.get(0).getemailId());
//					
//		}
//		@Test
//		@DisplayName("Test Registration saved sucessfully")
//		public void testRegistrationSavedSucessfully() {
//			
//			// given a mock product
//			Registration Registration = new Registration("abdulraheem","abdulraheem7794@gmail.com","Abdul143@","01-07-1998","Male"  );
//			Registration.setemailId("abdulraheem7794@gmail.com");
//			
//			// when we retrieve a product using non existing id
//			Registration savedRegistration=repository.save(Registration);
//			
//			// Then perform Assert Conditions To validate
//			Assertions.assertNotNull(savedRegistration, 
//					"New Registration should be saved");
//			
//			Assertions.assertNotNull(savedRegistration.getemailId(), 
//					"New Registration should have emailId");
//			Assertions.assertEquals(Registration.getemailId(), 
//					savedRegistration.getemailId());
//			
//			
//			}
//		


	}

