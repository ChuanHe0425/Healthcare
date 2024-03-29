package org.roncare.dao.pojo;

public class InsuranceCompany 
{
	private String id;
	private String name;
	private String city;
	private String state;
	private String representative;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	public String getRepresentative() {
		return representative;
	}
	public void setRepresentative(String rep) {
		this.representative = rep;
	}
	
}
