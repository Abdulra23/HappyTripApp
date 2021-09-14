package com.myapp.happytrip.model;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set.*;
@Entity
@Table(name="userregistrationdetails")
public class Registration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull
	@Column(name = "Fullname")
		private String fullName;

	@Column(name = "EmailId")
	@NotNull
		private  String emailId;

	@Column(name = "Password")
	@NotNull
		private  String password;

	@Column(name = "Gender")
	@NotNull
		private String gender;

	@Column(name = "DateOfBirth")
	@NotNull
		private String dateOfBirth;

	public Registration() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param fullname
	 * @param emailId
	 * @param password
	 * @param gender
	 * @param dateOfBirth
	 */
	public Registration(@NotNull String fullname, @NotNull String emailId, @NotNull String password,
			 @NotNull String dateOfBirth,@NotNull String gender) {
		super();
		this.fullName = fullname;
		this.emailId = emailId;
		this.password = password;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullname() {
		return fullName;
	}

	public void setFullname(String fullname) {
		this.fullName = fullname;
	}

	public String getemailId() {
		return emailId;
	}

	public void setemailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Registration [id=");
		builder.append(id);
		builder.append(", fullName=");
		builder.append(fullName);
		builder.append(", emailId=");
		builder.append(emailId);
		builder.append(", password=");
		builder.append(password);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", dateOfBirth=");
		builder.append(dateOfBirth);
		builder.append("]");
		return builder.toString();
	}


	
	
	
	}




		


