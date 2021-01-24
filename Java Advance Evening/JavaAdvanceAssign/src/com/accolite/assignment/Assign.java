package com.accolite.assignment;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import java.sql.Connection;



/*
 *  
 *  Main class 
 * 
 * 
 */

public class Assign {
	
	/*
	 * cretae Random class object for generate random number 
	 */

	   static Random random = new Random();
		
	   public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		   
		  // maxBound variable for define maximum limit of random value 
		  int maxBound = 100;
		  
		 FileInputStream fin = new FileInputStream("test.txt");
	     FileOutputStream fout = new FileOutputStream("test.txt");
	  
	     
		 // used to write in file name test.txt
	      writeIntofile(fout,maxBound);
	      
	      // read values from file name test.txt
		  List<Integer> randomNumberList = getFromfile(fin);
		  
		  //System.out.println(randomNumberList);
		  
		  // generating key to store name with it 
		  Integer key = streamOperation(randomNumberList);
		  String name = "amit";
		  
		  // data store into database with key and name 
		  storeDatabase(key,name) ;
		  
		 
	}
	   /*
	    * function used to give random number whenever in the range [0,maxBound]
	    */
	   
	   static public int getRandomNumber(int maxBound) {
		   return random.nextInt(maxBound);
	   }
	   
	   /*
	    * function is used to write random number inside the file test
	    */
	   
	   static public void writeIntofile( FileOutputStream fout,int maxBound) throws IOException {
		   int randomNumber = 0;
		  
		   // store number into file till not encounter with divisible with 5 
		    do {
		    	
		    	randomNumber = getRandomNumber(maxBound);
		    	
		    	fout.write(randomNumber);
		    	
		    	// used to give space between numbers 
		    	fout.write(' ');
		    	
		    }while(randomNumber%5!=0);
	   }
	   
	   /*
	    * read from the file test and store number into list and return list of number that's stored in file 
	    */
	   static public List<Integer> getFromfile(FileInputStream fin) throws IOException{
		   List<Integer> readRandomNumfromfileList = new ArrayList<>();
		   int read;
		   while ((read = fin.read()) != -1) {
			   
			   // read!=' ' means not store value of space i.e 32 because we inserted above 
			   if(read!=' ')
				   readRandomNumfromfileList.add(read);
			}
		   
		   return readRandomNumfromfileList;
	   }
	   
	   /*
	    * generting key that's store in database and return value of key 
	    */
	   
	   static public int streamOperation(List<Integer> randomNumberList) {
		   
		   
		 Integer key = randomNumberList.stream().filter(num -> num%5==0).map(num -> num*2).reduce((a,b) -> {
			            throw new IllegalStateException("Elements");
			        }).get();
		
		return key;
		   
	   }
	   
	   /*
	    *  storing key and name value into remote database
	    *   having url , schemaName,userName,Password
	    *   also work for local while changing url field 
	    *   making connection and insertintoDatabase with the help of DataBaseConnection class  
	    * 
	    */
	   public static void storeDatabase(int key,String name) throws ClassNotFoundException, SQLException {
		     
		     
		      String url = "jdbc:mysql://remotemysql.com:3306/";
		      String schemaName = "sMkXvyYxZM";
		      String userName = "sMkXvyYxZM";
		      String password = "8h9tWhCKws";
		      
		      String tableName ="test";
		      
		      DataBaseConnection DB = new DataBaseConnection(url,schemaName,userName,password);
		      Connection connection = (Connection) DB.connectionDatabase();
		      int status = DB.insertIntoDatabase(connection,tableName,key,name);
		      if(status==1) {
		    	  System.out.println("insert sucess");
		      }
			 
	   }
	   
}
