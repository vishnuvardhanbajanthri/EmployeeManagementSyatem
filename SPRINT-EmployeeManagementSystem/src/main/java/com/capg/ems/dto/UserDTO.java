package com.capg.ems.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
/*
 * Author : Vidya
 * Date : 06-01-2022
 * Description : User Entity Implementation
*/
public class UserDTO implements Serializable {

		private static final long serialVersionUID = 1L;

		@JsonProperty("UserId")
		private int userId;
		
		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		@NotEmpty(message = "Password cannot be empty")
	    @JsonProperty("Password")
	    private String password;

	    @NotEmpty(message = "Role cannot be empty")
	    @JsonProperty("Role")
	    private String Role;
		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getRole() {
			return Role;
		}

		public void setRole(String role) {
			Role = role;
		}
	}

