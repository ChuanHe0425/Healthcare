package org.roncare.servlets;

import java.util.List;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.roncare.dao.impl.PlanDAO;
import org.roncare.dao.pojo.Customer;
import org.roncare.dao.pojo.Plan;

@WebServlet("/PlanServlet")
public class PlanServlet extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6226349242501272216L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		
	
		if (req.getParameter("filter") != null) {
			//process filter options
		} else {
			// return all plants
			List<Plan> plans = new PlanDAO().getAllPlans();
			
			if (plans.isEmpty()) {
				req.getRequestDispatcher("/jsp/acc/login.jsp").forward(req, resp);
			}
			
			req.setAttribute("plans", plans);
			
			req.getRequestDispatcher("/jsp/plan/plans.jsp").forward(req, resp);
		}
	}
}
