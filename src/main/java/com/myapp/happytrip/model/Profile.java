package com.myapp.happytrip.model;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set.*;
@Entity
@Table(name="userprofiledetails")
public class Profile {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer id;

		@NotNull
		@Column(name = "Fullname")
			private String fullName;
		
		@Column(name = "Gender")
		@NotNull
			private String gender;

		
		@Column(name = "DateOfBirth")
		@NotNull
			private String dateOfBirth;

		@Column(name = "Address")
		@NotNull
			private  String address;

		@Column(name = "City")
		@NotNull
			private  String city;

		@Column(name = "State")
		@NotNull
			private  String state;
         

		@Column(name = "Country")
		@NotNull
			private  String country;
		
		@Column(name = "Pincode")
		@NotNull
			private Integer pincode;
		
		@Column(name = "PhoneNumber")
		@NotNull
			private Integer phoneNumber;
		@NotNull
		@Column(name = "EmailId")
			private String emailId;
		

		public Profile() {
			// TODO Auto-generated constructor stub
		}
		

		/**
		 * @param fullName
		 * @param gender
		 * @param dateOfBirth
		 * @param address
		 * @param city
		 * @param state
		 * @param country
		 * @param pincode
		 * @param phoneNumber
		 */
		public Profile(@NotNull String fullName, @NotNull String gender, @NotNull String dateOfBirth,
				@NotNull String address, @NotNull String city, @NotNull String state, @NotNull String country,
				@NotNull Integer pincode, @NotNull Integer phoneNumber, @NotNull String emailId) {
			super();
			this.fullName = fullName;
			this.gender = gender;
			this.dateOfBirth = dateOfBirth;
			this.address = address;
			this.city = city;
			this.state = state;
			this.country = country;
			this.pincode = pincode;
			this.phoneNumber = phoneNumber;
			this.emailId = emailId;
		}


		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(String dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public Integer getPincode() {
			return pincode;
		}

		public void setPincode(Integer pincode) {
			this.pincode = pincode;
		}

		public Integer getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(Integer phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		

		public String getEmailId() {
			return emailId;
		}


		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}


		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Profile [id=");
			builder.append(id);
			builder.append(", fullName=");
			builder.append(fullName);
			builder.append(", gender=");
			builder.append(gender);
			builder.append(", dateOfBirth=");
			builder.append(dateOfBirth);
			builder.append(", address=");
			builder.append(address);
			builder.append(", city=");
			builder.append(city);
			builder.append(", state=");
			builder.append(state);
			builder.append(", country=");
			builder.append(country);
			builder.append(", pincode=");
			builder.append(pincode);
			builder.append(", phoneNumber=");
			builder.append(phoneNumber);
			builder.append(", emailId=");
			builder.append(emailId);
			builder.append("]");
			return builder.toString();
		}
		}




			





