package com.accolite.assignment.assign.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Answear {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRightOption() {
		return rightOption;
	}

	public void setRightOption(String rightOption) {
		this.rightOption = rightOption;
	}

	public Options getOption() {
		return option;
	}

	public void setOption(Options option) {
		this.option = option;
	}

	@Column
    private String rightOption;
	
	@OneToOne
	private Options option;
}
