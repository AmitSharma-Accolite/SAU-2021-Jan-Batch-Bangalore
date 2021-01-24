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
import javax.persistence.OneToOne;


@Entity

public class Quiz {
  
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}

	public Set<School> getSchools() {
		return schools;
	}

	public void setSchools(Set<School> schools) {
		this.schools = schools;
	}

	public Options getOptions() {
		return options;
	}

	public void setOptions(Options options) {
		this.options = options;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String Question;
	
	 @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	  Options options;
	 
	 @ManyToMany()
	 Set<School> schools;
}
