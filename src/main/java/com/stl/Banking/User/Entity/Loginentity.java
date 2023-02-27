package com.stl.Banking.User.Entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Loginentity {

	@NotEmpty
	@Size(min =  4 , message = "name need to be atleast 4 characters")
	private String username;
	@NotEmpty
	@Size(min =  4 , message = "name need to be atleast 4 characters")
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Loginentity(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Loginentity [username=" + username + ", password=" + password + "]";
	}
	
	
}
