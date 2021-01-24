package com.accolite.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import javax.transaction.SystemException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/*
 * Library Books maintain class 
 * Have Functions 
 * 
 */




public class Library {
	
	 private static SessionFactory factory;
	 static Scanner sc;
	 static BufferedReader input;
	 public static void main(String[] args) throws IllegalStateException, SystemException, IOException {
		 sc = new Scanner(System.in);
		input = new BufferedReader(new InputStreamReader(System.in));
		try {

			factory = new Configuration().configure().buildSessionFactory();
			
		}catch(Exception e) {
			System.err.println(e);
		}
		
		Integer operation=0;
	
			
		
		do{
			
			
			System.out.println("Enter 1 for Add Books");
			System.out.println("Enter 2 for Get Books");
			System.out.println("Enter 3 for Update Book");
			System.out.println("Enter 4 for Delete Book");	
			System.out.println("Enter 5 for Get count of Books");
			System.out.println("Enter 0 for Exit\n\n");
			
			
			 try {
			 operation = sc.nextInt();
			}catch(Exception e) { 
				System.err.println("Input Must be Number");
			    break;
			
			
			}
			
			switch(operation) {
			case 1:{
				addBook();
				break;
			}
			case 2:{
				getBookDetails();
				break;
			}
			case 3:{
				System.out.println("Enter Id of the Book");
				int id = sc.nextInt();
				
				updateBookById( id);
				break;
			}
			case 4:{
				System.out.println("Enter Id of the Book for delete");
				int id = sc.nextInt();
				deleteBookById(id);
				break;
			}
			case 5:{
				
				int countofBooks = getCountofBooks();
				System.out.println("***********Count of Books is " + countofBooks +" ***********\n\n");
				break;
			}
			case 0:{
				 System.out.println("-----------------Complete execution ---------------");
				return ;
			}
			default : {
				System.err.println("**************oops wrong input*******");
				break;
			    }
			}
			
		}while(operation!=0);
		
		
		 System.out.println("-----------------Complete execution ---------------");
		
		
		
		 
	}
	 
	 /*
	  *  Add Book function take Books Details
	  *  and Call insertBookIntoTable method for insert into dataBAse table
	  *  Ask for number of Books wants to add 
	  *  
	  * 
	  */
	 static public void  addBook() throws IOException {
		 System.out.println("Enter Number of Books wants to Enter");
		 Integer numberOfBooks = sc.nextInt();
		 String title;
		 String language;
		 Integer price;
		 String authorName;
		 
		 for( int i = numberOfBooks;i>0;i--) {
			 System.out.println("Enter Title of Book");
			   title       = input.readLine();
			   
			 System.out.println("Enter Language of Book");
			   language    =  input.readLine();
			   
			 System.out.println("Enter price of Book");
			   price	   =  sc.nextInt();
			   
			 System.out.println("Enter Author Name of Book");
			   authorName  =  input.readLine();
			  
			 // calling insertBookIntoTable for store book details into table
			 insertBookIntoTable(title,language,price,authorName);
			   
			 System.out.println("-----------------Books Added---------------");
			
		 }
		 
		 
	 }
	 
	 /*
	  * insertBookIntoTable function is used to insert Book into table Book
	  */
	  private static Integer insertBookIntoTable(String title,String language,Integer price,String authorName) {
		
		 Session session = factory.openSession();
		 Transaction tx = null;
		 Integer bookId = null;
		 try {
			
			 tx = (Transaction) session.beginTransaction();
		
			 Book book1 = new Book(title,language,price,authorName);
			 
			 bookId = (Integer)session.save(book1);
			 
			 tx.commit();
		 }catch(Exception e) {
			 System.out.println(e);
			 tx.rollback();
		 }
		 finally {
			 session.close();
		 }
		 
		 return bookId;
	 }
	  
	  /*
	   * 
	   * getBooksDetails() used for print All the Books details present in dataBAse
	   *  createQuery() function is used to fetch all the Books Detail
	   *  
	   * 
	   */
	  	 private static void getBookDetails() throws IllegalStateException, SystemException {
			 
			 Session session = factory.openSession();
			 Transaction tx = null;
			 try {
				 tx =  (Transaction) session.beginTransaction();
				 List<Book> bookList = session.createQuery("From Book").list();
				 
				 for(Book result :  bookList) {
					 System.out.println("******************Book id : "+result.getId()+"**********************");
					 System.out.println(result.getLanguage());
					 System.out.println(result.getTitle());
					 System.out.println(result.getAuthorName());
					 System.out.println(result.getPrice());
				 }
			     
				 tx.commit();
			 }
			 catch(Exception e) {
				 System.out.println(e);
				 if(tx!=null) tx.rollback();
			 }
			 finally{
				
				 session.close();
			 }
			 System.out.println("-----------------All Books ---------------");
		 }
	  	 
	  	 /*
	  	  * updatedBookId() method is used to update title of the book 
	  	  * get() function is used to filter all the object of book with particular id
	  	  * setTitle() is used to update title of book object
	  	  * update() function is used to update corresponding Book object data in Table
	  	  */
	  	 
	  	public static void updateBookById(int id)
	    {
	        
	        Session session = factory.openSession();
	        Transaction tx = null;
	        try {
	        	tx =  (Transaction) session.beginTransaction();
	        	 Book book = (Book)session.get(Book.class, id);
	        	 
	        	 int option = selectOption();
	        	 
	        	 switch(option) {
	        	 case 1:{
	        		 System.out.println("Enter Title to update from " + book.getTitle());
	        		 String title = input.readLine();
	        		 book.setTitle(title);
	        		 break;
	        	  }
	        	 case 2:{
	        		 System.out.println("Enter Author Name to update from " + book.getAuthorName());
	        		 String authorName = input.readLine();
	        		 book.setAuthorName(authorName);
	        		 break;
	        	  }
	        	 case 3:{
	        		 System.out.println("Enter Price to update from " + book.getPrice());
	        		 Integer price = sc.nextInt();
	        		 book.setPrice(price);
	        		 break;
	        	  }
	        	 case 4:{
	        		 System.out.println("Enter Language  to update from " + book.getLanguage());
	        		 String language= input.readLine();
	        		 book.setLanguage(language);
	        		 break;
	        	  }
	        	 default:{
	        		 System.err.println("Wrong input"); 
	        	 }
	        	 }
	        	
	        	 session.update(book);
	        	 tx.commit();
	        }
	        catch(Exception e) {
	        	System.out.println(e);
	        }
	        finally{
				
				 session.close();
			 }
	       
	        System.out.println("-----------------Book updated ---------------");
	      
	        
	    }
	  	static public int selectOption() {
	  		
	  		System.out.println("Enter 1 for update Title");
	  		System.out.println("Enter 2 for update Author Name");
	  		System.out.println("Enter 3 for update Price");
	  		System.out.println("Enter 4 for update language");
	  		int option = 0;
	  		try {
	  		option = sc.nextInt();
	  		}catch(Exception e) {
	  			System.err.println("Input Must be integer");
	  		}
			return option;
	  		
	  	}
	  	
	  	/*
	  	 * deleteBookById() is used to delete object corresponding with id key
	  	 * get() is used to filter object with corresponding  id 
	  	 * delete() is used to remove the data of object form table 
	  	 * 
	  	 */
	  
	    public static void deleteBookById(int id)
	    {
	    	
	    	
	    	
	    	Session session = factory.openSession();
	        Transaction tx = null;
	        try {
	        	tx =  (Transaction) session.beginTransaction();
	        	 Book book = (Book)session.get(Book.class, id);
	        	 session.delete(book);
	        	 tx.commit();
	        }
	        catch(Exception e) {
	        	System.out.println(e);
	        }
	        finally{
				
				 session.close();
			 }
	       
	        System.out.println("-----------------Book Deleted---------------");
	       
	    }
	    
	    /*
	     * getCOuntofBooks() is return number of Books in the table
	     * createQuery() is used to fetch all rows and store into booklist
	     * return size of list 
	     */
	    
	 private static int getCountofBooks() throws IllegalStateException, SystemException {
			 
			 Session session = factory.openSession();
			 Transaction tx = null;
			 Integer countofBooks=0;
			 try {
				 tx =  (Transaction) session.beginTransaction();
				 List<Book> bookList = session.createQuery("From Book").list();
				 countofBooks = bookList.size();
			     
				 tx.commit();
			 }
			 catch(Exception e) {
				 if(tx!=null) tx.rollback();
			 }
			 finally{
				
				 session.close();
			 }
			return  countofBooks;
		 }
}

