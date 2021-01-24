package com.accolite.assignment.assign.repository;

import org.springframework.data.repository.CrudRepository;


import com.accolite.assignment.assign.entity.School;


// Repository if School i.e convert function into query and handle communication with the database 
public interface SchoolJPA extends CrudRepository<School,Integer> {
	
	// return value object of School corresponding  to the id 
	School findById(int id);
}
