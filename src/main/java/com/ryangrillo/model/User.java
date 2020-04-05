package com.ryangrillo.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

	@ApiModelProperty(required = true)
	@NotNull(message = "email must be provided")            
	private String email;
	
	@ApiModelProperty(required = true)
	@NotNull(message = "password must be provided")
	private String password;
	
	@Pattern(regexp = "^[0-9]{3}\\-[0-9]{3}\\-[0-9]{4}$", message = "phone number must be in XXX-XXX-XXXX format")
	private String phone;

	public User() {}

	public User(String email, String password, String phone) {
		super();
		this.email = email;
		this.password = password;
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "String [email=" + email + ", password=" + password + ", phone=" + phone + "]";
	}

	
	
	

}
