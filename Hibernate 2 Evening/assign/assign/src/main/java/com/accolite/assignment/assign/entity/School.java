package com.accolite.assignment.assign.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;


/*
 * School class with id , name
 * Many - Many relationship with Quiz ( Question)
 * 
 */
@Entity
public class School {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	 @Column
	private String  name;
	
	 
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


	public Set<Quiz> getQuizs() {
		return quizs;
	}


	public void setQuizs(Set<Quiz> quizs) {
		this.quizs = quizs;
	}


	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 Set<Quiz> quizs;
	
}
