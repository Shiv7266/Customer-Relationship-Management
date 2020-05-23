<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file = "header.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Send SMS</title>
</head>
<body>
<br/>
<br/>
<center>
<form action="SendSms" method="post">

<table>

       <tr><td>Sender Id:</td><td><input type="text" name="textSms" id="textSmsId"/></td></tr>
	   <tr><td>Mobile Number:</td><td><input type="text" name="smsNumber" id="smsNumberId"/></td></tr>	 
	   <tr><td>Sms Text:</td><td><textarea name="messageSms" rows="10" cols="20"></textarea></td></tr>
	   <tr><td><input type="submit" value="Send Message"/></td></tr>
</table>


</form>
</center>
</body>
</html>