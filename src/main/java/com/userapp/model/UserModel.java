package com.userapp.model;

public class UserModel {

	String FirstName;
	String LastName;
	String UserName;
	String Password;
	String Email;

	public UserModel(String FirstName, String LastName, String UserName, String Password, String Email) {
		super();
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.UserName = UserName;
		this.Password = Password;
		this.Email = Email;
	}

	public UserModel() {
		super();
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String UserName) {
		this.UserName = UserName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}
}
