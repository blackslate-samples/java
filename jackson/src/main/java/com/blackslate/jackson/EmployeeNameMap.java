package com.blackslate.jackson;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

public class EmployeeNameMap {

	public String orgName;
	
	@JsonAnyGetter
	private Map<String, String> employeePropMap;
	
	public EmployeeNameMap(String orgName, Map<String, String> employeePropMap) {
		super();
		this.orgName = orgName;
		this.employeePropMap = employeePropMap;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
    
}
