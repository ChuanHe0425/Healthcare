package org.roncare.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CustomerDAO_mySQL implements CustomerDAO	{

	private String getAllCustomersQuery, getCustomerQuery, updateCustomerQuery, insertCustomerQuery, deleteCustomerQuery;
	private Connection conn;
	
	public CustomerDAO_mySQL()	{ 
	    this("jdbc:mysql://localhost", "roncare", "root", "root"); 
	}
	
	public CustomerDAO_mySQL(String url, String dbName, String username, String password)	{
		String JDBC_DRIVER="com.mysql.jdbc.Driver";
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(url + "/" + dbName,username,password);
		} catch (ClassNotFoundException e) {
			System.err.println("Cannot find Driver");
			e.printStackTrace();
			return;
		} catch (SQLException e1) {
			System.err.println("Cannot Connect to DB");
			e1.printStackTrace();
			return;
		}
		
		getAllCustomersQuery = "SELECT * "
								+ "FROM TBLCustomer";
		getCustomerQuery = "SELECT * "
								+ "FROM TBLCustomer "
								+ "WHERE id=?";
		insertCustomerQuery = "INSERT INTO "
								+ "TBLCustomer (FirstName, LastName, EmailAddress, UserPassword) "
								+ "VALUES (?,?,?,?)";
	}
	
	@Override
	public List<Customer> getAllCustomers() {
//		Statement stmt = conn.createStatement();
//		ResultSet rs = stmt.executeQuery(getAllCustomersQuery);
		
		return null;
	}

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCustomer(Customer c) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(insertCustomerQuery);
		ps.setString(1, c.getFirstName());
		ps.setString(2, c.getLastName());
		ps.setString(3, c.getEmail());
		ps.setString(4, c.getUserPassword());
		
		ps.addBatch();
		ps.executeBatch();
	}

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		
	}

}
