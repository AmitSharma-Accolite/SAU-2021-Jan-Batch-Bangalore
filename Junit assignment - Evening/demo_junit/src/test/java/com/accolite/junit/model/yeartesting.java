package com.accolite.junit.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class yeartesting {

	@Test
	void test() {
		year y=new year();
		boolean output=y.checkYear(200);
		
		
		assertEquals(false,output);
	}
	@Test
	void test1() {
		year y=new year();
		boolean output=y.checkYear(2000);
		
		
		assertEquals(true,output);
	}

}
