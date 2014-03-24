package org.roncare.dao.pojo;

public class State 
{
	private Integer id;
	private String name;
	private String abbrevName;
	private boolean selected = false;;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbrevName() {
		return abbrevName;
	}
	public void setAbbrevName(String abbrevName) {
		this.abbrevName = abbrevName;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
