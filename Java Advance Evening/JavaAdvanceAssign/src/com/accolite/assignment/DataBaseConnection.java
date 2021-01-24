package com.accolite.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/*
 * 
 *    DataBase connection class with the function connectionDatabase() 
 *  , insertIntoDatabase() and parametric constructor 
 *  
 * 
 */

public class DataBaseConnection {
	
	private  String link;
	private  String schemaName;
	private String userName;
	private String password;
	
	
	
	DataBaseConnection(String url,String schemaName,String userName,String password){
		this.link = url;
		this.schemaName = schemaName;
		this.userName = userName;
		this.password = password;
	}
	
	
	
	
   
	// establish connection and return object of connection 
	public  Connection connectionDatabase() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		String url = link + schemaName; 
		Connection connection = DriverManager.getConnection(url, userName, password);
		return connection;
	}
	
	
	// insert into table and return status code 1 for successfully insert into table 
	public  int  insertIntoDatabase(Connection connection,String tableName,int key,String name) throws SQLException {
		Statement statement = connection.createStatement();
		String sql = "insert into "  + tableName + " values(?,?)";
	  
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, key);
	    preparedStatement.setString(2, name);
   	    //System.out.print(preparedStatement);
		int status = preparedStatement.executeUpdate();
		return status;
		
		
	}
	
	
	
	
}
