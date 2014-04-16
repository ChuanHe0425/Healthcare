package org.roncare.dao.pojo;

import java.io.Serializable;

public class Plan implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private double cost_individual;
	private double cost_family_zero;
	private double cost_family_one;
	private double cost_family_more;
	private InsuranceCompany insuranceCompany;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setCostIndividual(double cost) {
		this.cost_individual = cost;
	}
	
	public Double getCostIndividual() {
		return this.cost_individual;
	}

	public void setCostFamilyZero(double cost) {
		this.cost_family_zero = cost;
	}
	
	public Double getCostFamilyZero() {
		return this.cost_family_zero;
	}
	public void setCostFamilyOne(double cost) {
		this.cost_family_one = cost;
	}
	
	public Double getCostFamilyOne() {
		return this.cost_family_one;
	}
	public void setCostFamilyMore(double cost) {
		this.cost_family_more = cost;
	}
	
	public Double getCostFamilyMore() {
		return this.cost_family_more;
	}
	
	public InsuranceCompany getInsuranceCompany() {
		return insuranceCompany;
	}
	public void setInsuranceCompany(InsuranceCompany insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}

}
