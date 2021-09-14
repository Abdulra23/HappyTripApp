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

import com.myapp.happytrip.model.Booking;
import com.myapp.happytrip.repository.BookingList;



@SpringBootTest


@AutoConfigureMockMvc(addFilters = false)
public class BookingAPITest {


@MockBean
private BookingList repository;


@Autowired
private MockMvc mockMvc;


@Test
@DisplayName("Test Booking by FirstName - GET /api/v1/bookingdetails")
public void testfindByfindByFirstName() throws Exception {


// Prepare Mock Flight
	Booking Booking1 = new Booking("0286", "Abdul", "Raheem", "INDIGO", "QW16H", "Hydrabad", "2021-08-31", "Mumbai", "2021-08-31"  );
	Booking Booking2 = new Booking("0296", "Ravi", "Raj", "INDIGO", "QW16H", "Mumbai", "2021-08-31", "Banglore", "2021-08-31"  );
	
	List<Booking> Booking = new ArrayList<>();
	Booking.add(Booking1);
	Booking.add(Booking2);
	String firstName = "Abdul";
	
System.out.println(Booking.get(0));

// Prepare Mock Service Method


	doReturn(Optional.of(Booking)).when(repository).findByfirstName(firstName);

// Perform GET Request


	mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/bookingdetails/passenger/{firstN}", "Abdul"))
// Validate Status should be 200 OK and JSON response received
.andExpect(status().isOk())
.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))


// Validate Response Body


.andExpect(jsonPath("$[0].bookingId", is("0286")))
.andExpect(jsonPath("$[0].firstName", is("Abdul")))
.andExpect(jsonPath("$[0].lastName", is("Raheem")))
.andExpect(jsonPath("$[0].flightId", is("QW16H")))
.andExpect(jsonPath("$[0].flightName", is("INDIGO")))
.andExpect(jsonPath("$[0].departureLocation", is("Hydrabad")))
.andExpect(jsonPath("$[0].departureDate", is("2021-08-31")))
.andExpect(jsonPath("$[0].arrivalLocation", is("Mumbai")))
.andExpect(jsonPath("$[0].arrivalDate", is("2021-08-31")));

}


}
