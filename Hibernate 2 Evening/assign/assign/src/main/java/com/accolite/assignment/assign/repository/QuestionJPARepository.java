package com.accolite.assignment.assign.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.accolite.assignment.assign.entity.Quiz;

// Repository of the Quiz and handle CRUD operation in the database corresponding to Quiz table
public interface QuestionJPARepository extends CrudRepository<Quiz, Integer> {
	
   // return list of quiz(Questions) from the table Quiz 
	List<Quiz> findAll();
}
