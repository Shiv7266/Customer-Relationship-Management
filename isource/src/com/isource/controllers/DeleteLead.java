package com.isource.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isource.services.LeadsServices;

/**
 * Servlet implementation class DeleteLead
 */
@WebServlet("/DeleteLead")
public class DeleteLead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private LeadsServices ls;
	
    public DeleteLead() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		int id = Integer.parseInt(request.getParameter("leadid"));
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String emailAddress = request.getParameter("emailaddress");
		String mobileNumber = request.getParameter("mobileNumber");
		
		
		ls.deleteLead(id);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/reports.jsp");
		view.forward(request, response);
		
		
		
		
		
	}

}
