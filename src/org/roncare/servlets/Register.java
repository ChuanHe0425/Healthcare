package org.roncare.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.roncare.api.InputValidation;
import org.roncare.dao.impl.CustomerDAO;
import org.roncare.dao.pojo.Customer;
import org.roncare.util.EncryptionUtil;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 2L;

	/**
	 * Default constructor.
	 */
	public Register() 
	{
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{
		request.getRequestDispatcher("/register.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw = response.getWriter();

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("password");
		String email = request.getParameter("email");

		if (!InputValidation.validateRegister(email, firstName, lastName,
				password, confirmPassword)) {
			request.setAttribute("error", "Invalid Input");
			request.getRequestDispatcher("/register.jsp").forward(request,
					response);
			return;
		}
		
		String encryptPass = EncryptionUtil.encryptSHA512(password);

		Customer c = new Customer();
		c.setFirstName(firstName);
		c.setLastName(lastName);
		c.setUserPassword(encryptPass);
		c.setEmail(email);

		CustomerDAO dao = new CustomerDAO();

		if (!dao.addCustomer(c))
		{
			request.setAttribute("error", "SQL error");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}

		request.setAttribute("customer", c);
		request.getSession().setAttribute("currentUser", c.getEmail());
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
