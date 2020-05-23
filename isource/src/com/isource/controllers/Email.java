package com.isource.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Properties;    

import javax.ejb.EJB;
import javax.mail.*;    
import javax.mail.internet.*;   

import com.isource.models.Lead;
import com.isource.services.LeadsServices;

/**
 * Servlet implementation class Email
 */
@WebServlet("/Email")
public class Email extends HttpServlet {
	private static final long serialVersionUID = 1L;
   @EJB
   private LeadsServices ls;
    public Email() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Lead> allLeads = ls.searchLead();
		request.setAttribute("lead_list", allLeads);
		
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/send_email.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String toEmail = request.getParameter("toEmail");
		String subject = request.getParameter("subject");
		String messageContent = request.getParameter("message");
		
		Properties props = new Properties();    
        props.put("mail.smtp.host", "smtp.gmail.com");    
        props.put("mail.smtp.socketFactory.port", "465");    
        props.put("mail.smtp.socketFactory.class",    
                  "javax.net.ssl.SSLSocketFactory");    
        props.put("mail.smtp.auth", "true");    
        props.put("mail.smtp.port", "465");    
        //get Session   
        Session session = Session.getDefaultInstance(props,    
         new javax.mail.Authenticator() {    
         protected PasswordAuthentication getPasswordAuthentication() {    
         return new PasswordAuthentication("mutha.pankaj@gmail.com","Number1*pankaj");  
         }    
        });    
        //compose message    
        try {    
         MimeMessage message = new MimeMessage(session);    
         message.addRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));    
         message.setSubject(subject);    
         message.setText(messageContent);    
         //send message  
         Transport.send(message);    
         System.out.println("message sent successfully");    
        } catch (MessagingException e) {throw new RuntimeException(e);}    
         
        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/send_email.jsp");
        view.forward(request, response);
	}

}














