<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leads</title>
</head>
<body>
	<br />
	<br />
	<div id="form-wrapper" style="max-width: 500px; margin: auto;">
	
		<form action="AddLead" method="post">
			
			
			<table>

				<tr>
				    <td>Salutation:</td>
					<td><select name="salutation">
							<option value="Mr">Mr</option>
							<option value="Mrs">Mrs</option>
					</select></td>
				</tr>
				<tr>
					<td>First Name:</td>
					<td><input type="text" name="firstname" id="first_name" value=<%=request.getAttribute("first_name") %>></input></td>
					
					<% if(request.getAttribute("first_name_error")!=null) { %>
					
					      <td style="color:Tomato;">First name invalid or empty!</td>
					
					<%} %>
					
					
				</tr>

				<tr>
					<td>Last Name:</td>
					<td><input type="text" name="lastname" id="last_name" value=<%=request.getAttribute("last_name") %>></td>
					<% if(request.getAttribute("last_name_error")!=null) { %>
					
					      <td style="color:Tomato;">last name invalid or empty!</td>
					
					<%} %>
				</tr>

				<tr>
					<td>Email Id:</td>
					<td><input type="text" name="emailaddress" id="email_address" value=<%=request.getAttribute("email_address") %> ></td>
					<% if(request.getAttribute("email_address_error")!=null) { %>
					
					      <td style="color:Tomato;">Email address invalid or empty!</td>
					
					<%} %>
				</tr>

				<tr>
					<td>Mobile Number:</td>
					<td><input type="text" name="mobilenumber" id="mobile_number" value=<%=request.getAttribute("mobile_number") %>></td>
					<% if(request.getAttribute("mobile_number_error")!=null) { %>
					
					      <td style="color:Tomato;">mobile number invalid or empty!</td>
					
					<%} %>
				</tr>
				
				<tr>
					<td><input type="submit" value="Save"></td>
					<td><input type="reset"  value="clear"></td>
					
				</tr>
			</table>
			
			

			
		</form>
	</div>
</body>
</html>