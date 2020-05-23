package com.isource.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.HttpURLConnection;

/**
 * Servlet implementation class SendSms
 */
@WebServlet("/SendSms")
public class SendSms extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendSms() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/send_sms.jsp");
		view.forward(request, response);
	}

	/**
	 * @return 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String senderId = request.getParameter("textSms");
		String mobileNumber = request.getParameter("smsNumber");
		String smsMessage = request.getParameter("messageSms");
		
		try {
			// Construct data
			String apiKey = "apikey=" + "UPGE/If3eNU-Vz283kS03VJSu9TQeXfQZlHWqZo3Fw";
			String message = "&message=" + smsMessage;
			String sender = "&sender=" + senderId;
			String numbers = "&numbers=" + mobileNumber;
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			
			
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			
		}


		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/send_sms.jsp");
		view.forward(request, response);
 




	}

}
