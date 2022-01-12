package com.capg.ems.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.capg.ems.entities.Department;
import com.fasterxml.jackson.annotation.JsonProperty;
/*
 * Author : Riyanka
 * Date : 06-01-2022
 * Description : Employee Entity Implementation
*/
public class EmployeeDTO implements Serializable {

		private static final long serialVersionUID = 1L;

		@JsonProperty("userId")
		private int userId;

	    public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		@NotEmpty(message = "FirstName cannot be empty")
	    @JsonProperty("FirstName")
	    private String firstName;

	    @NotEmpty(message = "LastName cannot be empty")
	    @JsonProperty("LastName")
	    private String lastName;

	    @NotNull
	    @JsonProperty("DOB")
	    private LocalDate dob;

	    @NotEmpty(message = "Email cannot be empty")
	    @JsonProperty("Email")
	    @Pattern(regexp = "^\\S*$", message = "Space is not allowed in email")
	    @Size(min = 3, max = 128, message = "Email length should between 3 and 128")
	    private String email;	    
	  
	    public Department getDepartment() {
			return department;
		}

		public void setDepartment(Department department) {
			this.department = department;
		}

		private Department department;
	    

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public LocalDate getDob() {
			return dob;
		}

		public void setDob(LocalDate dob) {
			this.dob = dob;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}



	}

