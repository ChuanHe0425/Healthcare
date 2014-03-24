package org.roncare.servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().write("Hello from /Login get!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String userInput = request.getParameter("username");
        String passInput = request.getParameter("password"); 
        boolean loggedIn = false;
        
        String qry = "SELECT EmailAddress, UserPassword FROM TBLCustomer WHERE EmailAddress = '" + userInput + "';";
        
        Executor exec = new Executor();        
        ResultSet result = exec.getResultSet(qry);
        
        String error = exec.getLogMessage();
        String username = "";
        String pass = "";
        
        try {
			if (result.next()) {
				username = result.getString(1);
				pass = result.getString(2);
			}
		} catch (Exception e) {
			error += e.getMessage();
		}        
        
        if (username.equals(userInput) && passInput.equals(pass)) {
        	loggedIn = true;
        }
        
        exec.close();                  
        
        if (loggedIn) {
        	request.getSession().setAttribute("currentUser", username);
        	request.setAttribute("error", "");
        	request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
        	request.setAttribute("error", "Login Failed. Please try again.\n" + error);
        	request.getRequestDispatcher("/welcome.jsp").forward(request, response);
        }	
	}

}