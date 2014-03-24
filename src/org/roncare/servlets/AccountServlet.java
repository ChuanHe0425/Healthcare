package org.roncare.servlets;

import java.io.IOException;
import java.util.List;

import javax.annotation.security.DeclareRoles;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.roncare.dao.impl.CustomerDAO;
import org.roncare.dao.impl.FamilyMemberDAO;
import org.roncare.dao.impl.StateDAO;
import org.roncare.dao.pojo.Customer;
import org.roncare.dao.pojo.FamilyMember;
import org.roncare.dao.pojo.State;
import org.roncare.util.EncryptionUtil;

/*
 * 
 */
@WebServlet("/AccountServlet")
@DeclareRoles("citizen")
public class AccountServlet extends HttpServlet 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2885930091734320201L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		System.out.println("{AccountServlet}");
		
		HttpSession session = req.getSession();
		
		String action = req.getParameter("action");
		System.out.println("{AccountServlet}: Action - " + action);
		System.out.println("{AccountServlet}: URL - " + req.getRequestURL());
		
		//Action is null so let figure out where they are trying to go...
		if (action == null || "".equals(action))
		{
			if (req.getRequestURL() != null)
			{
				String url = req.getRequestURL().toString();
				
				if (url.endsWith("/account"))
				{
					req.getRequestDispatcher("/jsp/user/account.jsp").forward(req, resp);
					return;
				}
				else if (url.endsWith("/family"))
				{
					addFamilyMembersSessionVariables(req);
					req.getRequestDispatcher("/jsp/user/family.jsp").forward(req, resp);
					return;
				}
				else if (url.endsWith("/profile"))
				{
					//Add variables to session
					addCustomerSessionVariables(req);
					req.getRequestDispatcher("/jsp/user/profile.jsp").forward(req, resp);
					return;
				}
			}
			
			req.getRequestDispatcher("/jsp/user/account.jsp").forward(req, resp);
			return;
		}
		
		
		if ("change_password".equals(action))
		{
			String currentPassword = req.getParameter("confirmPassword");
			String newPassword = req.getParameter("newPassword");
			String newPassword1 = req.getParameter("newPassword1");
			
			String username = req.getRemoteUser();
			Customer cust = getCustomer(username);
			
			if (cust == null)
			{
				session.setAttribute("PasswordMsg", "Unable to locate account");
			}
			else if (!cust.getUserPassword().equals(EncryptionUtil.encryptSHA512(currentPassword)))
			{
				session.setAttribute("PasswordMsg", "Your current Password doesn't match what's stored in the database");
				
			}
			else if (!newPassword.equals(newPassword1))
			{
				session.setAttribute("PasswordMsg", "Your new password missmatches your confirm password");
			}
			else if (new CustomerDAO().updatePassword(username, EncryptionUtil.encryptSHA512(newPassword)))
			{
				System.out.println("{AccountServlet}: Password Changed");
			}
			else
			{
				session.setAttribute("PasswordMsg", "Error attempting to store the password");
			}
			
			req.getRequestDispatcher("/jsp/user/account.jsp").forward(req, resp);
			return;
		}
		else if ("change_info".equals(action))
		{
			String firstName = req.getParameter("firstName");
			String lastName = req.getParameter("lastName");
			String streetNo = req.getParameter("streetNo");
			String streetName = req.getParameter("streetName");
			String city = req.getParameter("city");
			String zip = req.getParameter("zip");
			String ssn = req.getParameter("ssn");
			String phone = req.getParameter("phone");
			String cell = req.getParameter("cell");
			
			String state = req.getParameter("state");
			Integer stateInt = null;
			try
			{
				stateInt = Integer.parseInt(state);
			}
			catch(Exception e)
			{
				System.out.println("{AccountServlet}: State Exception setting to 1");
				stateInt = 1;
			}
			
			
			if (new CustomerDAO().updatePersonalInfo(
					req.getRemoteUser(), firstName, lastName, streetNo, streetName, city, stateInt, zip, ssn, phone, cell))
			{
				System.out.println("{AccountServlet}: Password Changed");
				addCustomerSessionVariables(req);
			}
			else
			{
				session.setAttribute("InfoChngMsg", "Error attempting to personal info");
			}
			
			
			req.getRequestDispatcher("/jsp/user/profile.jsp").forward(req, resp);
			return;
		}
		else if ("add_family_member".equals(action))
		{
			String firstName = req.getParameter("firstName");
			String lastName = req.getParameter("lastName");
			String age = req.getParameter("age");
			
			Integer ageInt = -1;
			try
			{
				ageInt = Integer.parseInt(age);
			}
			catch (Exception e)
			{
				System.out.println("{AccountServlet}: State Exception setting to -1");
			}
			
			if (new FamilyMemberDAO().addFamilyMember(
					req.getRemoteUser(), firstName, lastName, ageInt))
			{
				System.out.println("{AccountServlet}: Family Member added");
				addFamilyMembersSessionVariables(req);
			}
			else
			{
				session.setAttribute("FamilyAddMsg", "Error attempting to personal info");
			}
			
			req.getRequestDispatcher("/jsp/user/family.jsp").forward(req, resp);
			return;
			
		}
		else if ("remove_family_member".equals(action))
		{
			String id = req.getParameter("id");
			Integer idInt = -1;
			
			try
			{
				idInt = Integer.parseInt(id);
			}
			catch (Exception e)
			{
				session.setAttribute("FamilyRemvoceMsg", "Bad ID");
			}
			
			
			if (new FamilyMemberDAO().removeFamilyMember(req.getRemoteUser(), idInt))
			{
				System.out.println("{AccountServlet}: Family Member removed");
				addFamilyMembersSessionVariables(req);
			}
			else
			{
				session.setAttribute("FamilyAddMsg", "Error attempting to personal info");
			}
			
			req.getRequestDispatcher("/jsp/user/family.jsp").forward(req, resp);
			return;
		}
		else
		{
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			return;
		}
	}
	
	public Customer getCustomer(String emailAddress)
	{
		return new CustomerDAO().getCustomer(emailAddress);
	}
	
	public List<State> getStates()
	{
		return new StateDAO().getAllStates();
	}
	
	public List<FamilyMember> getFamilyMembers(String username)
	{
		return new FamilyMemberDAO().getAllFamilyMemebers(username);
	}
	
	public void addCustomerSessionVariables(HttpServletRequest req)
	{
		Customer user = getCustomer(req.getRemoteUser());
		req.getSession().setAttribute("user", user);
		
		List<State> states = getStates();
		
		System.out.println("{AccountServlet}: Number of States - " + states.size());
		
		if (user.getStates() != null)
		{
			for (State state: states)
			{
				if (state.getId() == user.getStates())
				{
					state.setSelected(true);
					break;
				}
			}
		}
		
		req.setAttribute("states", states);
	}
	
	public void addFamilyMembersSessionVariables(HttpServletRequest req)
	{
		List<FamilyMember> family = getFamilyMembers(req.getRemoteUser());
		
		req.setAttribute("family", family);
	}
}
