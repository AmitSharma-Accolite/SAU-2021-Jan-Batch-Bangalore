package com.au.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class DrawingApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Triangle t = new Triangle();
		ApplicationContext factory = new FileSystemXmlApplicationContext("spring.xml");
		Triangle triangle = (Triangle)factory.getBean("triangle");
		triangle.draw();
		//t.draw();
		
		showLockManager(factory );
		showPrimeNumberSet(factory);
	}
	
	public static void showLockManager(ApplicationContext factory) {
		
		System.out.println("\n----------------- Show Lock Manager ----------------- \n");
		
		LockerMap lockerMap = (LockerMap)factory.getBean("lockerMap");
		System.out.println("Account id \t password \n");
		lockerMap.getPasswordManger().forEach((account,password)->{
			System.out.print(account + "\t" + password + "\n");
			
		});
	}
	
	
	public static void showPrimeNumberSet(ApplicationContext factory) {
		System.out.println("\n----------------- Show Prime Number ----------------- \n");
		PrimeNumberSet primeNumbers = (PrimeNumberSet)factory.getBean("primeNumbers");
		
		primeNumbers.getPrimeNumbers().forEach(prime->{
			System.out.println(prime);
		});
	}

}
