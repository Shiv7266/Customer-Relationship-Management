package com.isource.controllers;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.Transient;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isource.models.Accounts_Data;
import com.isource.models.Lead;
import com.isource.models.Product;
import com.isource.models.Salutation;
import com.isource.services.AccountsServices;
import com.isource.services.LeadsServices;

/**
 * Servlet implementation class Accounts
 */
@WebServlet("/Accounts")
public class Accounts extends HttpServlet {
	@Transient
	private static final long serialVersionUID = 1L;
       
    @EJB
    private LeadsServices ls;
    
    @EJB
    private AccountsServices as;
    
    public Accounts() {
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
	    request.setAttribute("product_price", "");
	    request.setAttribute("shipping_address", "");
	    request.setAttribute("city_area", "");
	    request.setAttribute("state_area", "");
	    request.setAttribute("country_area", "");
	    List<Lead> allLeads = ls.searchLead();
		request.setAttribute("lead_list", allLeads);
		
	    RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/add_accounts.jsp");
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
		String productName = request.getParameter("productname");
		String productPrice = request.getParameter("productprice");
		String shippingAddress = request.getParameter("shippingaddress");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		
		String firstname_regex = "[a-zA-Z]+\\.?";
		String lastname_regex  = "[a-zA-Z]+\\.?";
		String emailregex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		String mobile_regex    = "[7-9][0-9]{9}";
		String productprice_regex = "[1000-15000]";
		String city_regex = "[a-zA-Z]+\\.?";
		String state_regex = "[a-zA-Z]+\\.?";
		String country_regex = "[a-zA-Z]+\\.?";
		
		
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
		
		if((productPrice.length())==0){
			request.setAttribute("errors", true);
			request.setAttribute("product_price_error", true);
			request.setAttribute("product_price", "");
		}else{
			request.setAttribute("product_price", productPrice);
		}
		
		if(shippingAddress.length()==0){
			request.setAttribute("errors", true);
			request.setAttribute("shipping_address_error", true);
			request.setAttribute("shipping_address", "");
		}else{
			request.setAttribute("shipping_address", shippingAddress);
		}
		if((city.matches(city_regex)&& city.length()>2)==false){
			request.setAttribute("errors", true);
			request.setAttribute("city_area_error", true);
			request.setAttribute("city_area", "");
		}else{
			request.setAttribute("city_area", city);
		}
		
		if((state.matches(state_regex)&& state.length()>2)==false){
			request.setAttribute("errors", true);
			request.setAttribute("state_area_error", true);
			request.setAttribute("state_area", "");
		}else{
			request.setAttribute("state_area", state);
		}
		
		if((country.matches(country_regex)&& country.length()>2)==false){
			request.setAttribute("errors", true);
			request.setAttribute("country_area_error", true);
			request.setAttribute("country_area", "");
		}else{
			request.setAttribute("country_area", country);
		}
		
		if((Boolean)request.getAttribute("errors")){
			
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/add_accounts.jsp");
			view.forward(request, response);
			
			
		}else{
			Accounts_Data accountsData = new Accounts_Data();
		
			if(salutation.equals("Mr")){
				accountsData.setSalutation(Salutation.Mr);
			}
			if(salutation.equals("Mrs")){
				accountsData.setSalutation(Salutation.Mrs);
			}
			if(productName.equals("HP_LaserJet_Pro_M404n")){
				accountsData.setProductName(Product.HP_LaserJet_Pro_M404n);
			}
			if(productName.equals("HP_LaserJet_Pro_MFP_M428fdn")){
				accountsData.setProductName(Product.HP_LaserJet_Pro_MFP_M428fdn);
			}
			if(productName.equals("HP_OfficeJet_3830")){
				accountsData.setProductName(Product.HP_OfficeJet_3830);
			}
		
		
			
			accountsData.setFirstName(firstName);
			accountsData.setLastName(lastName);
			accountsData.setEmailAddress(emailAddress);
			accountsData.setMobileNumber(mobileNumber);
			accountsData.setProductPrice(Integer.parseInt(productPrice));
			accountsData.setShippingAddress(shippingAddress);
			accountsData.setCity(city);
			accountsData.setState(state);
			accountsData.setCountry(country);
			
			as.addAccounts(accountsData);
			
			request.setAttribute("first_name", "");
		    request.setAttribute("last_name", "");
		    request.setAttribute("email_address", "");
		    request.setAttribute("mobile_number", "");
		    request.setAttribute("product_price", "");
		    request.setAttribute("shipping_address", "");
		    request.setAttribute("city_area", "");
		    request.setAttribute("state_area", "");
		    request.setAttribute("country_area", "");
		    
		    
		    
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/reports.jsp");
			view.forward(request, response);		
		}
		
	}

}
