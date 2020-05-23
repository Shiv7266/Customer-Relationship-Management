package com.isource.controllers;

import java.io.IOException;






import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isource.models.Lead;
import com.isource.models.Salutation;
import com.isource.services.LeadsServices;

/**
 * Servlet implementation class AddLead
 */
@WebServlet("/AddLead")
public class AddLead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private LeadsServices ls;
	
	
    public AddLead() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setAttribute("first_name", "");
	    request.setAttribute("last_name", "");
	    request.setAttribute("email_address", "");
	    request.setAttribute("mobile_number", "");
	    request.setAttribute("message","");
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/add_leads.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		request.setAttribute("errors", false);
		
		String salutation = request.getParameter("salutation");
		String firstName  = request.getParameter("firstname");
		String lastName   = request.getParameter("lastname");
		String emailAddress = request.getParameter("emailaddress");
		String mobileNumber = request.getParameter("mobilenumber");
		
		
		String firstname_regex = "[a-zA-Z]+\\.?";
		String lastname_regex  = "[a-zA-Z]+\\.?";
		String emailregex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		String mobile_regex    = "[7-9][0-9]{9}";
		
		
		
		if((firstName.matches(firstname_regex) && firstName.length()>2)==false){
			request.setAttribute("errors", true);
			request.setAttribute("first_name_error", true);
			request.setAttribute("first_name", "");
		}else{
			request.setAttribute("first_name", firstName);
			System.out.println("Correct:"+firstName);
		}
		
		if((lastName.matches(lastname_regex) && firstName.length()>2)==false){
			request.setAttribute("errors", true);
			request.setAttribute("last_name_error", true);
			request.setAttribute("last_name", "");
		}else{
			request.setAttribute("last_name", lastName);
			System.out.println("Correct:"+lastName);
		}
		
		if(emailAddress.matches(emailregex)==false){
			request.setAttribute("errors", true);
			request.setAttribute("email_address_error", true);
			request.setAttribute("email_address", "");
		}else{
			request.setAttribute("email_address", emailAddress);
			System.out.println("Correct:"+emailAddress);
		}
		
		if(mobileNumber.matches(mobile_regex)==false ){
			request.setAttribute("errors", true);
			request.setAttribute("mobile_number_error", true);
			request.setAttribute("mobile_number", "");
		}else{
			request.setAttribute("mobile_number", mobileNumber);
			System.out.println("Correct:"+mobileNumber);
		}
		
		if((Boolean)request.getAttribute("errors")){
			
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/add_leads.jsp");
			view.forward(request, response);
			
			
		}else{
			Lead l = new Lead();
			if(salutation.equals("Mr")){
				l.setSalutation(Salutation.Mr);
			}
			if(salutation.equals("Mrs")){
				l.setSalutation(Salutation.Mrs);
			}
			l.setFirstName(firstName);
			l.setLastName(lastName);
			l.setEmailId(emailAddress);
			l.setMobileNumber(mobileNumber);
			ls.addLead(l);
			request.setAttribute("first_name", "");
		    request.setAttribute("last_name", "");
		    request.setAttribute("email_address", "");
		    request.setAttribute("mobile_number", "");
		    request.setAttribute("message","");
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/add_leads.jsp");
			view.forward(request, response);		
		}
		
	
		
	}

}
