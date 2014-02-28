package org.roncare.webapp;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dbadmin")
public class DatabaseAdmin extends HttpServlet {

	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DatabaseAdmin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		//connect to database
		// JDBC driver name and database URL
	      String JDBC_DRIVER="com.mysql.jdbc.Driver";  
	      String DB_URL="jdbc:mysql://localhost/TEST";
	      
	      //  Database credentials
	      String USER = "root";
	      String PASS = "root";
	      
	      Class.forName("com.mysql.jdbc.Driver");

	      // Open a connection
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);

	      // Execute SQL query
	      stmt = conn.createStatement();
	      String sql;
	      sql = "SELECT id, first, last, age FROM Employees";
	      ResultSet rs = stmt.executeQuery(sql);

	      // Extract data from result set
	      while(rs.next()){
	    	  //Retrieve by column name
	          int id  = rs.getInt("id");
	          int age = rs.getInt("age");
	          String first = rs.getString("first");
	          String last = rs.getString("last");

	          //Display values
	          out.println("ID: " + id + "<br>");
	          out.println(", Age: " + age + "<br>");
	          out.println(", First: " + first + "<br>");
	          out.println(", Last: " + last + "<br>");
	
	         }
	}
	

}
