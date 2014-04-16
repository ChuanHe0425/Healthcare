package org.roncare.dao.impl;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.roncare.dao.conn.DatabaseConnection;
import org.roncare.dao.pojo.InsuranceCompany;

public class InsuranceCompanyDAO extends DatabaseConnection implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String GET_COMPANY = "SELECT * FROM TBLInsuranceCompany WHERE insurance_company_id=?";
	
	public InsuranceCompanyDAO() {
		super();
	}
	
	public InsuranceCompany getCompany(String id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		InsuranceCompany company = null;
		
		try 
		{
			this.OpenConnection();
			
			ps = conn.prepareStatement(GET_COMPANY);
			ps.setString(1, id);
			ps.setMaxRows(1);
			
			rs = ps.executeQuery();

			while (rs.next()) 
			{
				company = new InsuranceCompany();
				
				company.setId(rs.getString("insurance_company_id"));
				company.setName(rs.getString("company_name"));
				company.setCity(rs.getString("city"));
				company.setState(rs.getString("state"));
				company.setRepresentative(rs.getString("representative_name"));
				
				System.out.println("{InsuranceCompanyDAO}: Returned Insurance Co - " + company.getName());
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
		
		
		return company;
	}
	
}
