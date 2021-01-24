package main;

import java.util.Scanner;

public class Question2 { 
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		/*
		 * Taking input from the user
		 * 
		 */
		
		System.out.println("Enter dividend");
		int dividend  = sc.nextInt();
		
		System.out.println("Enter divisor");
		int divisor   = sc.nextInt();
		
		
	  /*
	   * calling divide function with parameter dividend and  divisor 
	   * Printing the result 
	   * 
	   */
		
	    System.out.println( "Result" + divide(dividend ,divisor ));
	   
	   
	   /* 
	    * Handing Exception at the time of function calling because function have throws keyword with it 
	    */
	    
	    try {
		   System.out.println("Result" + divide_th(dividend,divisor ));
	   }catch(ArithmeticException e){
		   System.out.println("not divided by zero");
	   }
	   
		 
	}
	
	
	/*
	 * try catch block used inside the function and use throw keyword 
	 * 
	 */
	 static public int divide(int dividend ,int divisor) {
		int quotient = 0;
		 try {
			 quotient = dividend/divisor;
			 throw new ArithmeticException("divisor not be zero");
		 }catch(Exception e) {
			 System.out.println(e.getMessage());
		 }
		 return quotient;
	 }
	 
	 
	 
	 /*
	  *  used keyword throws with the function means whole function need to execute inside the try block 
	  */
	 static public int  divide_th(int dividend , int divisor) throws ArithmeticException{
			int  quotient = dividend/divisor;
			 return quotient;
		 }
	 
}
	
