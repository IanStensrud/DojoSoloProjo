package com.projects.dojosoloprojo.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class LoginUser {

	@NotEmpty
	@Email(message="Please enter valid email.")
	private String confirmEmail;

	@NotEmpty
	@Size(min=8, max=128, message="Password: At least 8 characters.")
	private String confirmPassword;

	public LoginUser() {}

	public String getConfirmEmail() {
		return confirmEmail;
	}

	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


}
