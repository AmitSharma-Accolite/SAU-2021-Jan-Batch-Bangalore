package com.accolite.junit.model;

public class Employee {

	public String firstName;
	public String secondName;
	public int age;
	public float salary;
	
	
	public Employee(String firstName, String secondName, int age, float salary) {
		
		this.firstName = firstName;
		this.secondName = secondName;
		this.age = age;
		this.salary = salary;
	}
	
	public Employee() {
		
		this.firstName = "";
		this.secondName = "";
		this.age = 0;
		this.salary = 0.0f;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	
	
}
