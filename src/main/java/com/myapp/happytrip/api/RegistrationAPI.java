package com.myapp.happytrip.api;

import java.sql.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.happytrip.model.Registration;
import com.myapp.happytrip.repository.RegistrationList;
@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationAPI extends UserRegistrationAPI {

	@Autowired
	private RegistrationList Registration;
	@GetMapping("userregistrationdetails/{emailId}")
	public ResponseEntity<List<Registration>> findByemailId(@PathVariable("emailId") String Email) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			String emailId= Email ;
			System.out.println(fullName + emailId + password + dateOfBirth + gender);
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","Abdul143@");
			String query = "INSERT INTO userregistrationdetails(FULL_NAME, EMAIL, PASSWORD,DATE_OF_BIRTH, GENDER,) VALUES(?, ?, ?, ?, ?);";
			PreparedStatement myInsert = con.prepareStatement(query);
			myInsert.setString(1, fullName);
			myInsert.setString(2, emailId);
			myInsert.setString(3, password);
			myInsert.setString(4, dateOfBirth);
			myInsert.setString(5, gender);
			myInsert.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Registration>>(Registration.findByemailId(Email).get(), HttpStatus.OK);
	}

		

}
