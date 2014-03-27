package org.roncare.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.roncare.dao.conn.DatabaseConnection;
import org.roncare.dao.pojo.Customer;

public class CustomerDAO extends DatabaseConnection
{
	private static final String GET_CUSTOMER = "SELECT * FROM TBLCustomer WHERE EmailAddress=?";
	private static final String INSERT_CUSTOMER = "INSERT INTO TBLCustomer (FirstName, LastName, EmailAddress, UserPassword) VALUES (?,?,?,?)";
	private static final String INSERT_ROLE = "INSERT INTO TBLUserRole (EmailAddress, RoleName) VALUES (?,?)";
	private static final String CHANGE_PASSWORD = "UPDATE TBLCustomer SET UserPassword = ? WHERE UserEmail = ?;";
	private static final String CHANGE_PERSONAL_INFO = "UPDATE TBLCustomer SET FirstName = ?, LastName= ?, StreetNo = ?, StreetName = ?, City = ?, States = ?, Zip = ?, SSN = ?, PhoneNumber = ?, CellPhoneNumber = ? WHERE EmailAddress = ?;";
	
	
	public CustomerDAO() 
	{
		super();
	}


	public Customer getCustomer(String username)
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer cust = null;
		
		try 
		{
			this.OpenConnection();
			
			ps = conn.prepareStatement(GET_CUSTOMER);
			ps.setString(1, username);
			ps.setMaxRows(1);
			
			rs = ps.executeQuery();

			while (rs.next()) 
			{
				cust = new Customer();
				
				cust.setId(rs.getInt("ID"));
				
				cust.setUserPassword(rs.getString("UserPassword"));
				
				cust.setFirstName(rs.getString("FirstName"));
				cust.setLastName(rs.getString("LastName"));
				
				cust.setStreetNo(rs.getString("StreetNo"));
				cust.setStreetName(rs.getString("StreetName"));
				cust.setCity(rs.getString("City"));
				cust.setStates(rs.getInt("States"));
				if(rs.wasNull())
				{
					cust.setStates(null);
				}
				
				cust.setZip(rs.getString("Zip"));
				
				cust.setDob(rs.getDate("DOB"));
				cust.setSsn(rs.getString("SSN"));
				
				cust.setPhoneNum(rs.getString("PhoneNumber"));
				cust.setCellNum(rs.getString("CellPhoneNumber"));
				
				//Validate if the value was null, 
				//if it was null it will be set to zero since its a int value which cannot be null
				cust.setGender(rs.getInt("Gender"));
				if(rs.wasNull())
				{
					cust.setGender(null);
				}
				
				System.out.println("{CustomerDAO}: Returned Customer - " + username);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				rs.close();
			} 
			catch (Exception e1) 
			{
				e1.printStackTrace();
			}
			
			try 
			{
				ps.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			this.CloseConnection();
		}
		
		
		return cust;
	}

	public boolean addCustomer(Customer c) 
	{
		boolean processed = false;
		
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		
		try 
		{
			this.OpenConnection();
			
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(INSERT_CUSTOMER);
			
			ps.setString(1, c.getFirstName());
			ps.setString(2, c.getLastName());
			ps.setString(3, c.getEmail());
			ps.setString(4, c.getUserPassword());
			
			ps.addBatch();
			ps.executeBatch();
			
			ps1 = conn.prepareStatement(INSERT_ROLE);
			ps1.setString(1, c.getEmail());
			ps1.setString(2, "citizen");

			ps1.addBatch();
			ps1.executeBatch();
			
			conn.commit();
			conn.setAutoCommit(true);
			
			processed = true;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				ps.close();
			} 
			catch (Exception e1) 
			{
				e1.printStackTrace();
			}
			
			try 
			{
				ps1.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			this.CloseConnection();
		}
		
		return processed;
	}

	public boolean updatePassword(String username, String password)
	{
		boolean processed = false;
		
		PreparedStatement ps = null;
		try 
		{
			this.OpenConnection();
			conn.setAutoCommit(false);
			
			ps = conn.prepareStatement(CHANGE_PASSWORD);
			ps.setString(1, password);
			ps.setString(2, username);
			
			ps.executeUpdate();
			conn.commit();
			
			processed = true;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				ps.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			this.CloseConnection();
		}
		
		return processed;
	}
	
	public boolean updatePersonalInfo(
		String username, String firstName, String lastName, String streetNo,
		String streetName, String city, Integer state, String zip, String ssn,
		String phone, String cell)
	{
		boolean processed = false;
		
		PreparedStatement ps = null;
		try 
		{
			this.OpenConnection();
			conn.setAutoCommit(false);
			
			ps = conn.prepareStatement(CHANGE_PERSONAL_INFO);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, streetNo);
			ps.setString(4, streetName);
			ps.setString(5, city);
			ps.setInt(6, state);
			ps.setString(7, zip);
			ps.setString(8, ssn);
			ps.setString(9, phone);
			ps.setString(10, cell);
			ps.setString(11, username);
			
			ps.executeUpdate();
			conn.commit();
			
			processed = true;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				ps.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			this.CloseConnection();
		}
		
		return processed;
	}

}
