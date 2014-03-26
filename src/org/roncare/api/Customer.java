package org.roncare.api;

import java.util.Date;

public class Customer {
	
	private int id;
	private String firstName;
	private String lastName;
	private String streetNo;
	private String streetName;
	private String city;
	private int states; // FK to other table
	private int zip;
	private Date dob;	// using java.util import, may be changed later
	private String ssn;
	private String phoneNumber;
	private String cellPhoneNumber;
	private String email;
	private String userPassword;
	private int gender;
	private int race;
	private int employmentStatus;
	private int income;
	private int healthCareCoverageType;
	private int dentalCareCoverageType;
	private int planType;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getStreetNo() {
		return streetNo;
	}
	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getStates() {
		return states;
	}
	public void setStates(int states) {
		this.states = states;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}
	public void setCellPhoneNumber(String cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getRace() {
		return race;
	}
	public void setRace(int race) {
		this.race = race;
	}
	public int getEmploymentStatus() {
		return employmentStatus;
	}
	public void setEmploymentStatus(int employmentStatus) {
		this.employmentStatus = employmentStatus;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public int getHealthCareCoverageType() {
		return healthCareCoverageType;
	}
	public void setHealthCareCoverageType(int healthCareCoverageType) {
		this.healthCareCoverageType = healthCareCoverageType;
	}
	public int getDentalCareCoverageType() {
		return dentalCareCoverageType;
	}
	public void setDentalCareCoverageType(int dentalCareCoverageType) {
		this.dentalCareCoverageType = dentalCareCoverageType;
	}
	public int getPlanType() {
		return planType;
	}
	public void setPlanType(int planType) {
		this.planType = planType;
	}

	
	
//	public int getId()	{	return id;	}
//	public void setId(int id)	{	this.id = id;	}
//	
//	public String getFirstName()	{	return firstName;	}
//	public void setFirstName(String firstName)	{	this.firstName = firstName;	}
//	
//	public String getLastName()	{	return lastName;	}
//	public void setLastName(String lastName)	{	this.lastName = lastName;	}
//	
//	public String getEmail()	{	return emailAddress;	}
//	public void setEmail(String email)	{	this.emailAddress = email;	}
//
//	public String getUserPassword()	{	return userPassword;	}
//	public void setUserPassword(String userPassword)	{	this.userPassword = userPassword;	}
}
