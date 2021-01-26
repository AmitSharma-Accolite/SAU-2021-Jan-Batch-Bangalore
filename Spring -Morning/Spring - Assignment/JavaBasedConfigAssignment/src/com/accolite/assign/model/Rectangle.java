package com.accolite.assign.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



/*
 *     Rectangle class having 4 Point object points _a,_b,_c,_d  
 *     height , width two integer and getters and setters 
 * 
 *     @Autoweired annotation is used for not create object 
 *	   getting object value from Appconfig.class 
 *     specified with @Qualifier annotation  
 * 
 */



public class Rectangle {
    
	
	 
	 
	
	 @Autowired
	 @Qualifier("pointA")
	private Point _a;
	 
	 @Autowired
	 @Qualifier("pointB")
	private Point _b;
	 
	 @Autowired
	 @Qualifier("pointC")
	private Point _c;
	 
	 @Autowired
	 @Qualifier("pointD")
	private Point _d;
	
	
	 @Autowired
	 @Qualifier("height")
	private Integer height;
	
	 @Autowired
	 @Qualifier("width")
	private Integer width;

	public Point get_a() {
		return _a;
	}

	public void set_a(Point _a) {
		this._a = _a;
	}

	public Point get_b() {
		return _b;
	}

	public void set_b(Point _b) {
		this._b = _b;
	}

	public Point get_c() {
		return _c;
	}

	public void set_c(Point _c) {
		this._c = _c;
	}

	public Point get_d() {
		return _d;
	}

	public void set_d(Point _d) {
		this._d = _d;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}
	
	
	
	
	
}
