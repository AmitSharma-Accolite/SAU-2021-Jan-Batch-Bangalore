package com.accolite.assignment.assign.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.accolite.assignment.assign.entity.Answear;

// Repository class of Answer handle communication with database 
public interface AnswearJPARespository extends CrudRepository<Answear, Integer> {
 
	// return all questions Available in the table
	public List<Answear> findAll();
  
}
