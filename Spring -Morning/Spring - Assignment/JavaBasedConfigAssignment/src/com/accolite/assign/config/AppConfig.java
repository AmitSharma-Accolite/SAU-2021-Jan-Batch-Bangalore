package com.accolite.assign.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.accolite.assign.model.Point;
import com.accolite.assign.model.Rectangle;



/*
 * Appconfig class is used to creating object and assigning values and returning 
 * corresponding to the name by using @Bean(name="uniqueName")
 * AnnotationConfigApplicationContext class scan that class and those have annotation @Bean store in 
 * repository 
 * 
 * @Configuration or @Component also we can use 
 * spring looking for components and configuration annotation 
 *  
 */
@Configuration
public class AppConfig {

	@Bean(name="rectangle")
	public Rectangle getTriangle() {
		return new Rectangle();
	}
	
	@Bean(name="pointA")
	public Point getPointA() {
		return new Point(0,0);
	}
	@Bean(name="pointB")
	public Point getPointB() {
		return new Point(0,10);
	}
	@Bean(name="pointC")
	public Point getPointC() {
		return new Point(20,0);
	}
	@Bean(name="pointD")
	public Point getPointD() {
		return new Point(20,10);
	}
	
	@Bean(name="height")
	public Integer getHeight() {
		return 10;
	}
	
	@Bean(name="width")
	public Integer getWidth() {
		return 20;
	}
	
}
