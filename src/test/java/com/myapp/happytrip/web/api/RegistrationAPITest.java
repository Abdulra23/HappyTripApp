package com.myapp.happytrip.web.api;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.myapp.happytrip.model.Registration;
import com.myapp.happytrip.repository.RegistrationList;



@SpringBootTest


@AutoConfigureMockMvc(addFilters = false)
public class RegistrationAPITest {
	




	@MockBean
	private RegistrationList repository;


	@Autowired
	private MockMvc mockMvc;


	@Test
	@DisplayName("Test Registration by emailId - GET /api/v1/registration")
	public void testfindByfindByfullName() throws Exception {


	// Prepare Mock Registration
		Registration Registration1 = new Registration("AbdulRaheem","abdulraheem7794@gmail.com","Abdul143@","01-07-1998","Male"  );
		Registration Registration2 = new Registration("vamsiKrishna","vamsikrishna12@gmail.com","Vamsi123@","09-08-1998","Male"  );
		List<Registration> Abc = new ArrayList<>();
		Abc.add(Registration1);
		Abc.add(Registration2);
		String emailId = "abdulraheem7794@gmail.com";
		
	//System.out.println(Abc.get(0));

	// Prepare Mock Service Method


		doReturn(Optional.of(Abc)).when(repository).findByemailId(emailId);

	// Perform GET Request


//		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/Registration/userregistrationdetails/{emailId}", "abdulraheem7794@gmail.com"))
//	// Validate Status should be 200 OK and JSON response received
//	.andExpect(status().isOk())
//	.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))


	// Validate Response Body


	//.andExpect(jsonPath("$[0].fullName", is("AbdulRaheem")))
//	.andExpect(jsonPath("$[0].emailId", is("abdulraheem7794@gmail.com")))
//	.andExpect(jsonPath("$[0].password", is("Abdul143@")))
//	.andExpect(jsonPath("$[0].dateOfBirth", is("01-07-1998")))
//	.andExpect(jsonPath("$[0].gender", is("Male")));
	
	}


	}


