/**
 * 
 */
package com.example.au.couchbasedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.au.couchbasedemo.model.Employee;
import com.example.au.couchbasedemo.repository.EmployeeRepository;

import java.util.List;

/**
 * @author khand
 *
 */
@RestController
public class EmployeeController {
    @Autowired
	EmployeeRepository empRepo;
	
	@PostMapping("/employee")
	 public Employee addEmployeeDetails(@RequestBody Employee newEmp) {
        return empRepo.save(newEmp);
    }
	
	
	@GetMapping("/employee/location/{location}/pincode/{pincode}")
   
	public List<Employee>  getEmpDetails(@PathVariable String location ,@PathVariable String pincode) {
	    return   (List<Employee>) empRepo.getBylocationAndPincode(location,pincode);
	
	}
	
}
