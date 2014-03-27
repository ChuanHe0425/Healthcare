package org.roncare.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.roncare.dao.conn.DatabaseConnection;
import org.roncare.dao.pojo.State;

public class StateDAO extends DatabaseConnection 
{
	private final static String SELECT_ALL_STATES = "SELECT * FROM TBLStatesZips ORDER BY AbbrevState ASC;";
	
	
	public StateDAO()
	{
		super();
	}
	
	public List<State> getAllStates()
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<State> states = new java.util.ArrayList<State>();
		
		try 
		{
			this.OpenConnection();
			
			ps = conn.prepareStatement(SELECT_ALL_STATES);
			
			rs = ps.executeQuery();

			while (rs.next()) 
			{
				State state = new State();
				state.setId(rs.getInt("StateID"));
				state.setName(rs.getString("LowerState"));
				state.setAbbrevName(rs.getString("AbbrevState"));
				
				states.add(state);
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
		
		return states;
	}
}
