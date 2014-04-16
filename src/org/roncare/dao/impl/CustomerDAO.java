package org.roncare.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.roncare.dao.conn.DatabaseConnection;
import org.roncare.dao.pojo.Customer;

public class CustomerDAO extends DatabaseConnection
{
	private static final String GET_CUSTOMER = "SELECT * FROM TBLApplicant WHERE email=?";
	private static final String INSERT_CUSTOMER = "INSERT INTO TBLApplicant (first_name, last_name, email, password) VALUES (?,?,?,?)";
	private static final String INSERT_ROLE = "INSERT INTO TBLUserRole (email, RoleName) VALUES (?,?)";
	private static final String CHANGE_PASSWORD = "UPDATE TBLApplicant SET password = ? WHERE email = ?;";
	private static final String CHANGE_PERSONAL_INFO = "UPDATE TBLApplicant SET first_name = ?, last_name= ?, street_number = ?, street_name = ?, city = ?, state = ?, zipcode = ?, ssn = ?, phone_number = ? WHERE email = ?;";
	
	
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
				
				cust.setId(rs.getInt("applicant_id"));
				
				cust.setUserPassword(rs.getString("password"));
				
				cust.setFirstName(rs.getString("first_name"));
				cust.setLastName(rs.getString("last_name"));
				
				cust.setStreetNo(rs.getString("street_number"));
				cust.setStreetName(rs.getString("street_name"));
				cust.setCity(rs.getString("city"));
				cust.setStates(rs.getInt("state"));
				if(rs.wasNull())
				{
					cust.setStates(null);
				}
				
				cust.setZip(rs.getString("zipcode"));
				
				cust.setDob(rs.getDate("dob"));
				cust.setSsn(rs.getString("ssn"));
				
				cust.setPhoneNum(rs.getString("phone_number"));
				
				
				//Validate if the value was null, 
				//if it was null it will be set to zero since its a int value which cannot be null
				cust.setGender(rs.getInt("gender_id"));
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
			ps.setString(10, username);
			
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
