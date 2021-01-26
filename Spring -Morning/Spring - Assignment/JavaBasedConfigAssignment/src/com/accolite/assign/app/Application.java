package com.accolite.assign.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.accolite.assign.config.AppConfig;
import com.accolite.assign.model.Rectangle;

/*
 * Main class 
 * 
 */

public class Application {
  
	public static void main(String[] args) {
		
		/*
		 * AnnotationConfigApplicationContext() taking class as a parameter and scan AppConfig.class
		 * And scan all the @Bean annotaion and create reposiorty for all that 
		 * and whenever we required any object of class we ask ApplicationContext and using getBean() method 
		 * for getting object 
		 * 
		 */
		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
		
		// getting object of rectangle class 
		Rectangle rectangle = (Rectangle)factory.getBean("rectangle");
		
		
		// creating string to show All the points 
		String showA = "Points A \t x : " + rectangle.get_a().getX() + "\t  y : " + rectangle.get_a().getY();
		String showB = "Points B \t x : " + rectangle.get_b().getX() + "\t  y : " + rectangle.get_b().getY();
		String showC = "Points C \t x : " + rectangle.get_c().getX() + "\t  y : " + rectangle.get_c().getY();
		String showD = "Points D \t x : " + rectangle.get_d().getX() + "\t  y : " + rectangle.get_d().getY();
		
		// creating string to show height and width of the rectangle
		String property = "Height : " + rectangle.getHeight() + "\t Width : " + rectangle.getWidth();
		
		// print points ShowA,ShowB,ShowC,ShowD
		System.out.println("----------------- Show data of rectangle object ----------------- \n");
		System.out.println(showA);
		System.out.println(showB);
		System.out.println(showC);
		System.out.println(showD);
		
		// print property
		System.out.println(property);

		
	}
	
}
