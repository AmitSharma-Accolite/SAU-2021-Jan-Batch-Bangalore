package com.accolite.junit.model;

import java.util.Scanner;

public class year {
	int year;
	
	
	void get(int year)
	{
		Scanner sc=new Scanner(System.in);
		year=sc.nextInt();
		
	}
	 boolean checkYear(int year)
	    {
	       
	        if (year % 400 == 0)
	            return true;
	     
	        
	        if (year % 100 == 0)
	            return false;
	   
	        if (year % 4 == 0)
	            return true;
	        return false;
	    }
	         
	

}
