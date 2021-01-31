package com.accolite.junit.controller;

import com.accolite.junit.model.Employee;

public class EmployeeController {
	
		public Employee employee;
		
		public  String addEmployee(Employee employee) {
			this.employee = employee;
			
			return employee.getFirstName();
		}
		
		
		
}
