package com.isource.controllers;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isource.models.Lead;
import com.isource.services.LeadsServices;

@WebServlet("/SearchLead")
public class SearchLead extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private LeadsServices ls;

	public SearchLead() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		

		List<Lead> allLeads = ls.searchLead();
		request.setAttribute("lead_list", allLeads);
		RequestDispatcher view = request
				.getRequestDispatcher("WEB-INF/views/search_lead.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	

	}

}
