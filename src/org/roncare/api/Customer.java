package org.roncare.api;

public class Customer {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String userPassword;
	
	public int getId()	{	return id;	}
	public void setId(int id)	{	this.id = id;	}
	
	public String getFirstName()	{	return firstName;	}
	public void setFirstName(String firstName)	{	this.firstName = firstName;	}
	
	public String getLastName()	{	return lastName;	}
	public void setLastName(String lastName)	{	this.lastName = lastName;	}
	
	public String getEmail()	{	return email;	}
	public void setEmail(String email)	{	this.email = email;	}

	public String getUserPassword()	{	return userPassword;	}
	public void setUserPassword(String userPassword)	{	this.userPassword = userPassword;	}
}