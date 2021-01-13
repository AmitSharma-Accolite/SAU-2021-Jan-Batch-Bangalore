/**
 * 
 */
package com.example.au.couchbasedemo.model;

import org.springframework.data.annotation.Id;

import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

/**
 * @author khand
 *
 */
@Document
public class CricketDB {
	
	
	
	  @Id
	  String playerId;
	  
	  @Field
	  String name;
	  
	  @Field
	  Integer run;
	  
	  @Field
	  Integer wicket;
	  
	  @Field 
	  Integer averageRun;
    
	  
	 public CricketDB(String playerId,String name,Integer run,Integer wicket,Integer averageRun) {
		super();
		 this.playerId = playerId;
		 this.name = name;
		 this.run = run;
		 this.wicket = wicket;
		 this.averageRun = averageRun;
	 }
	  
	  
	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRun() {
		return run;
	}

	public void setRun(Integer run) {
		this.run = run;
	}

	public Integer getWicket() {
		return wicket;
	}

	public void setWicket(Integer wicket) {
		this.wicket = wicket;
	}

	public Integer getAverageRun() {
		return averageRun;
	}

	public void setAverageRun(Integer averageRun) {
		this.averageRun = averageRun;
	}

	
	  
	  
	  
	  
	  
	     
}
