package org.roncare.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dbinit")
public class DatabaseAdmin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public DatabaseAdmin() {
		// TODO Auto-generated constructor stub
	}

	private String executeSqlFile(String path, Connection dbConn) {
		Scanner input;
		Statement stmt;
		StringBuilder msg = new StringBuilder();
		String sqlStatement;

		try {
			input = new Scanner(new File(path));
		} catch (Exception e) {
			msg.append("FAILED to open file:\n " + path);
			msg.append("\n " + e.getMessage() + "\n");
			return msg.toString();
		}

		sqlStatement = input.useDelimiter("\\A").next();
		String statements[] = sqlStatement.split(";");

		for (String s : statements) {
			try {
				stmt = dbConn.createStatement();
				stmt.execute(s);
				msg.append("Successfully executed SQL file: " + path + "\n");
			} catch (Exception e) {
				msg.append("FAILED to execute sql command:\n " + sqlStatement);
				msg.append("\n " + e.getMessage() + "\n");
				input.close();
				return msg.toString();
			}
		}
		input.close();
		msg.append("Successfully executed SQL file: " + path + "\n");
		return msg.toString();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String SQL_PATH = "/srv/sql/";
		String SQL_DROP_SCHEMA = "DropSchema.sql";
		String MANIFEST = "Manifest.txt";


		// connect to database
		// JDBC driver name and database URL
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost";
		String DB_NAME = "roncare";

		PrintWriter out = response.getWriter();

		// Database credentials
		String USER = "root";
		String PASS = "root";

		Statement stmt = null;

		try {

			Class.forName(JDBC_DRIVER);
			response.getWriter().write("Opening connection...\n");
			// Open a connection
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			out.write("Connected...\n");

			out.write("Cheching for database: " + DB_NAME + "...\n");
			ResultSet resultSet = conn.getMetaData().getCatalogs();
			Boolean hasDB = false;
			
			while (resultSet.next()) 
			{

				String databaseName = resultSet.getString(1);

				if (databaseName.equals(DB_NAME)) 
				{
					out.write("Database " + DB_NAME + " FOUND!!!\n");
					hasDB = true;
					break;
				}
			}
			resultSet.close();
			
			String ret;
			//Drop schema
			if (hasDB)
			{
				ret = executeSqlFile(SQL_PATH + SQL_DROP_SCHEMA, conn);
			}

			// create Database
			try 
			{
				out.write("Dropping Schema: " + DB_NAME + "\nn");
				stmt = conn.createStatement();
				stmt.executeUpdate("CREATE DATABASE " + DB_NAME);
			} 
			catch (Exception e) 
			{
				out.write("FAILED to create database: " + DB_NAME);
			}

			conn.setCatalog(DB_NAME);

			
			try {
				Scanner manifest = new Scanner(new File(SQL_PATH + MANIFEST));
				while (manifest.hasNext()) {
					ret = executeSqlFile(SQL_PATH + manifest.next(), conn);
					out.write(ret);
				}
				manifest.close();

			} catch (Exception e) {
				out.append("FAILED to open file:\n " + MANIFEST);
				out.append("\n " + e.getMessage() + "\n");
				return ;
			}

				
		}
		catch (SQLException se) 
		{
			// Handle errors for JDBC
			response.getWriter().write("catch 1: " + se.toString());
			se.printStackTrace();
		} 
		catch (Exception e) 
		{
			response.getWriter().write("catch 2: ");
			// Handle errors for Class.forName
			e.printStackTrace();
		}

	}

}
