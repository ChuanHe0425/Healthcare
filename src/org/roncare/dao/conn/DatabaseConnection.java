package org.roncare.dao.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection 
{
	private final static String URL = "jdbc:mysql://localhost";
	private final static String DBNAME = "roncare";
	private final static String USER = "root";
	private final static String PASSWORD = "root";
	
	protected Connection conn;
	
	public DatabaseConnection()
	{
	}
	
	public void OpenConnection()
	{
		conn = null;
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		try 
		{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(URL + "/" + DBNAME, USER, PASSWORD);
		} 
		catch (ClassNotFoundException e) 
		{
			System.err.println("Cannot find Driver");
			e.printStackTrace();
		} 
		catch (SQLException e1) 
		{
			System.err.println("Cannot Connect to DB");
			e1.printStackTrace();
		}
	}
	
	public void CloseConnection()
	{
		try 
		{
			conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
