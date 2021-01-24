package com.accolite.assignment;


/*
 * 
 * Book class to store attributrs of the Book 
 * 
 */
public class Book {
  
	 private Integer id;
	 private String  title;
	 private String language;
	 private Integer price;
	 private String authorName;
	 
	 
	 Book(String title,String language,Integer price,String authorName){
		 this.title = title;
		 this.language = language;
		 this.price = price;
		 this.authorName = authorName;
	 }
	 Book(){
		 
	 }
	 
	 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	 
	 
	 

}
