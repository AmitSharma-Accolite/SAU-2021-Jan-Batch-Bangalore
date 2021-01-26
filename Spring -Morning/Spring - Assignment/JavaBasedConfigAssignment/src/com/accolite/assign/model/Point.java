package com.accolite.assign.model;


/*
 * 
 * Model class of Point
 * having two variable x and y and parameterized constructor
 * getter and setter 
 * 
 * 
 */
public class Point {
    
	 private Integer x;
	 private Integer y;
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	
	public Point(Integer x, Integer y) {
		
		this.x = x;
		this.y = y;
	}
	 
}
