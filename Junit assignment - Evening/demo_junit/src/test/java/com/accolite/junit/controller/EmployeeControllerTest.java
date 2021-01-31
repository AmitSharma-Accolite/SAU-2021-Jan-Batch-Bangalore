package com.accolite.junit.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.exceptions.verification.WantedButNotInvoked;

import com.accolite.junit.model.Employee;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EmployeeControllerTest {

	
//	void test() {
//		fail("Not yet implemented");
//	}
	EmployeeController empCon;
	
	
	@BeforeAll
	public void beforeAll() {
		System.out.println("Welcome");
	}
	
	@BeforeEach
	public void beforeEachTest() {
		System.out.println("Before Each");
		 empCon = new EmployeeController();
	}
	
	@Test
	public void testAddEmployee() {
		System.out.println("first test case");
		Employee emp = new  Employee("Herry","vink",20,0);
	 
	    String name =  empCon.addEmployee(emp);
	    assertEquals("Herry", name);
	}
	
//	@Mock
//	Employee emp ;
	@Test
	public void testAddEmployee2() {
		System.out.println("Second test case");
		Employee emp = Mockito.mock(Employee.class);
		Mockito.when(emp.getFirstName()).thenReturn("Herry");
	   
	    String name =  empCon.addEmployee(emp);
	    assertEquals("Herry", name);
	   // verify(emp,times(WantedButNotInvoked:1)).getFirstName();
	}
	
	@AfterEach
	public void afterEach() {
	  empCon = null;
	}
	
	
}
