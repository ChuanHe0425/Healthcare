package org.roncare.dao.pojo;

public class Plan 
{
	private String id;
	private State state;
	private String plan;
	private InsuranceCompany insuranceCompany;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public InsuranceCompany getInsuranceCompany() {
		return insuranceCompany;
	}
	public void setInsuranceCompany(InsuranceCompany insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}

}
