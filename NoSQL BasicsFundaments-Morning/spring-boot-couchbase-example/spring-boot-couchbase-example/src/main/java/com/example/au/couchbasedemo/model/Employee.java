package com.example.au.couchbasedemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;




@Document
public class Employee {
	
	@Id
	private String empId;
	
	
	@Field
	private String empName;
	
	
	@Field
	private String address;
	
	@Field 
	private String location;
	 
	@Field 
	private String pincode;
	
	
	public Employee(String empId, String empName, String address,String location,
			String pincode) {
		this.empId = empId;
		this.empName = empName;
		this.address = address;
		this.location = location;
		this.pincode = pincode;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	
	

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	

}
