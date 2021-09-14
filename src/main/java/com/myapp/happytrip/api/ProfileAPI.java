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

import com.myapp.happytrip.model.Profile;
import com.myapp.happytrip.repository.ProfileList;

@RestController
@RequestMapping("/api/v1/profiledetails")
public class ProfileAPI extends ProfileDetails{

		@Autowired
		private ProfileList Profile;
		@GetMapping("userprofiledetails/{phoneNumber}")
		public ResponseEntity<List<Profile>> findByphoneNumber(@PathVariable("phoneNumber") Integer PhoneNumber) {

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			try {
				Integer phoneNumber = PhoneNumber ;
				System.out.println(fullName + gender + dateOfBirth + address + city + state + country + pincode + phoneNumber + emailId);
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Registration","root","Abdul143@");
				String query = "INSERT INTO userprofiledetails(FULL_NAME, GENDER ,DATE_OF_BIRTH, ADDRESS, CITY, STATE, COUNTRY, PINCODE, MOBILE_NUMBER, EMAIL_ID) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ? );";
				PreparedStatement myInsert = con.prepareStatement(query);
				myInsert.setString(1, fullName);
				myInsert.setString(2, gender);
				myInsert.setString(3, dateOfBirth);
				myInsert.setString(4, address);
				myInsert.setString(5, city);
				myInsert.setString(6, state);
				myInsert.setString(7, country);
				myInsert.setInt(8, pincode);
				myInsert.setInt(9, phoneNumber);
				myInsert.setString(10, emailId);
				myInsert.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return new ResponseEntity<List<Profile>>(Profile.findByphoneNumber(PhoneNumber).get(), HttpStatus.OK);
		}

			

	}


