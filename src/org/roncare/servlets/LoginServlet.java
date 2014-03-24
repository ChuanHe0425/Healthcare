package org.roncare.servlets;

import java.io.IOException;

import javax.annotation.security.DeclareRoles;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
@DeclareRoles("citizen")
public class LoginServlet extends HttpServlet 
{
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 6390748054627797564L;

	public LoginServlet() 
    {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException 
	{
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException 
	{
		System.out.println("{LoginServlet} User -" + request.getRemoteUser());
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
