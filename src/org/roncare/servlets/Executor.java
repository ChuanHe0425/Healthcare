package org.roncare.servlets;

//Executer.java

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Executor {

	//connect to database
	// JDBC driver name and database URL
	String JDBC_DRIVER="com.mysql.jdbc.Driver";  
	String DB_URL="jdbc:mysql://localhost";
	String DB_NAME="roncare";	
	
	//  Database credentials
	String USER = "root";
	String PASS = "root";
	Connection connection;
	
	String logMsg = "";

	//constructor
	public Executor () {
  	    try {
			Class.forName(JDBC_DRIVER);			
			// Open a connection
			connection = DriverManager.getConnection(DB_URL + "/" + DB_NAME, USER, PASS);
		} catch (Exception e) {
			logMsg += e.getMessage();
		}
		if (!isConnected()) {
			logMsg += "\nFailed to connect to MySql DB. ConnectionString=" + DB_URL + "/" + DB_NAME + "?" + USER + "&3ncrypt3dPwd";
		}  	    
	}



	public ResultSet getResultSet(String qry) {
		Statement s1;
		ResultSet answer = null;
		try {			
			s1 = connection.createStatement();
			answer = s1.executeQuery(qry);

		} catch (Exception e) {
			logMsg += e.getMessage();
		}	

		return answer;
	}

	public void executeMyQuery(String qry) {
		Statement s1;
		try {
			s1 = connection.createStatement();
			s1.executeUpdate(qry);
		} catch (Exception e) {			
			logMsg += e.getMessage();
		}
	}
	
	public void close() {
		try {
			connection.close();
		} catch (Exception e) {
			logMsg += e.getMessage();
		}
	}
	
	public boolean isConnected() {
		return connection != null;
	}
	
	public String getLogMessage() {
		return logMsg;
	}
}


