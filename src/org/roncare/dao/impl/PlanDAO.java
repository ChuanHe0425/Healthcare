/**
 * 
 */
package org.roncare.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.roncare.dao.conn.DatabaseConnection;
import org.roncare.dao.impl.InsuranceCompanyDAO;

import org.roncare.dao.pojo.Customer;
import org.roncare.dao.pojo.FamilyMember;
import org.roncare.dao.pojo.InsuranceCompany;
import org.roncare.dao.pojo.Plan;
/**
 * @author Samir
 *
 */
public class PlanDAO extends DatabaseConnection 
{
	private final static String SELECT_ALL_PLANS = "SELECT * FROM TBLInsurancePlan";
	
	public ArrayList<Plan> getAllPlans() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Plan> plans = new ArrayList<Plan>();
		
		try 
		{

			this.OpenConnection();
			
			ps = conn.prepareStatement(SELECT_ALL_PLANS);
			
			rs = ps.executeQuery();

			while (rs.next()) 
			{
				Plan p = new Plan();
				
				p.setId(rs.getString("plan_id"));
				p.setName(rs.getString("plan_name"));
				p.setInsuranceCompany(new InsuranceCompanyDAO().getCompany(rs.getString("insurance_company_id")));
				p.setCostIndividual(rs.getDouble("cost_individual"));
				p.setCostFamilyZero(rs.getDouble("cost_family_zero"));
				p.setCostFamilyOne(rs.getDouble("cost_family_one"));
				p.setCostFamilyMore(rs.getDouble("cost_family_more"));
				
				plans.add(p);
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
		
		return plans;
	}
	
}
