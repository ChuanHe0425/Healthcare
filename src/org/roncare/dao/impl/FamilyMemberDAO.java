package org.roncare.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.roncare.dao.conn.DatabaseConnection;
import org.roncare.dao.pojo.Customer;
import org.roncare.dao.pojo.FamilyMember;

public class FamilyMemberDAO extends DatabaseConnection 
{
	private static final String GET_ALL = "SELECT * FROM TBLFamilyMember WHERE Customer = ?;";
	private static final String INSERT_MEMBER = "INSERT INTO TBLFamilyMember (FirstName, LastName, Age, Customer) VALUES (?, ?, ?, ?);";
	private static final String REMOVE_MEMBER = "DELETE FROM TBLFamilyMember WHERE Customer = ? and ID = ?;";
	
	public FamilyMemberDAO()
	{
		super();
	}
	
	public List<FamilyMember> getAllFamilyMemebers(String username)
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<FamilyMember> family = new java.util.ArrayList<FamilyMember>();
		
		try 
		{
			Customer cust = new CustomerDAO().getCustomer(username);
			
			this.OpenConnection();
			
			ps = conn.prepareStatement(GET_ALL);
			
			ps.setInt(1, cust.getId());
			
			rs = ps.executeQuery();

			while (rs.next()) 
			{
				FamilyMember fam = new FamilyMember();
				fam.setAge(rs.getInt("Age"));
				if(rs.wasNull())
				{
					fam.setAge(null);
				}
				fam.setFirstName(rs.getString("FirstName"));
				fam.setLastName(rs.getString("LastName"));
				fam.setId(rs.getInt("ID"));
				
				family.add(fam);
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
		
		return family;
	}
	
	
	public boolean addFamilyMember(
		String username, String firstName, String lastName, Integer age)
	{
		boolean processed = false;
		
		PreparedStatement ps = null;
		
		try 
		{
			this.OpenConnection();
			
			Customer cust = new CustomerDAO().getCustomer(username);
						
			if (cust == null)
			{
				throw new Exception("Customer null");
			}
			
			System.out.println("{FamilyDAO} - addingFamilyMember to " + cust.getId());

			
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(INSERT_MEMBER);
			
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setInt(3, age);
			ps.setInt(4, cust.getId());
			
			ps.addBatch();
			ps.executeBatch();
			
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
			
			this.CloseConnection();
		}
		
		return processed;
	}
	
	public boolean removeFamilyMember(String username, Integer id)
	{
		boolean processed = false;
		
		PreparedStatement ps = null;
		
		try 
		{
			this.OpenConnection();
			
			Customer cust = new CustomerDAO().getCustomer(username);
			
			if (cust == null)
			{
				throw new Exception("Customer null");
			}
			
			System.out.println("{FamilyDAO} - removingFamilyMember CustID " + cust.getId() + " FamMemID " + id);
			
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(REMOVE_MEMBER);
			
			ps.setInt(1, cust.getId());
			ps.setInt(2, id);
			
			ps.addBatch();
			ps.executeBatch();
			
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
			
			this.CloseConnection();
		}
		
		return processed;
	}
	
}
