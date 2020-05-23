<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import = "java.util.*, com.isource.models.*, java.lang.Exception" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accounts</title>
<link rel="stylesheet" href="resources/css/normalize.css"/>
</head>
<body>
<br />
	<br />
	<div id="form-wrapper" style="max-width: 500px; margin: auto;">
	
		<form action="Accounts" method="post">
			
			
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
					<td><input type="text" name="firstname" id="first_name" readonly value=<%=request.getAttribute("first_name") %> ></input></td>
					
					<% if(request.getAttribute("first_name_error")!=null) { %>
					
					      <td style="color:Tomato;">First name invalid or empty!</td>
					
					<%} %>
					
					
				</tr>

				<tr>
					<td>Last Name:</td>
					<td><input type="text" name="lastname" id="last_name" readonly value=<%=request.getAttribute("last_name") %> ></td>
					<% if(request.getAttribute("last_name_error")!=null) { %>
					
					      <td style="color:Tomato;">last name invalid or empty!</td>
					
					<%} %>
				</tr>

				<tr>
					<td>Email Id:</td>
					<td><input type="text" name="emailaddress" id="email_address" readonly value=<%=request.getAttribute("email_address") %> ></td>
					<% if(request.getAttribute("email_address_error")!=null) { %>
					
					      <td style="color:Tomato;">Email address invalid or empty!</td>
					
					<%} %>
				</tr>

				<tr>
					<td>Mobile Number:</td>
					<td><input type="text" name="mobilenumber" id="mobile_number" value=<%=request.getAttribute("mobile_number") %> ></td>
					<% if(request.getAttribute("mobile_number_error")!=null) { %>
					
					      <td style="color:Tomato;">mobile number invalid or empty!</td>
					
					<%} %>
				</tr>
				
				<tr>
					<td>Product Name:</td>
					<td><select name="productname">
							<option value="HP_LaserJet_Pro_MFP_M428fdn">HP_LaserJet_Pro</option>
							<option value="HP_OfficeJet_3830">HP_OfficeJet</option>
							<option value="HP_LaserJet_Pro_M404n">HP_LaserJet_Pro</option>
					</select></td>
				</tr>
				
				<tr>
					<td>Product Price:</td>
					<td><input type="text" name="productprice" id="product_price" value=<%=request.getAttribute("product_price") %>></td>
					<% if(request.getAttribute("product_price_error")!=null) { %>
					
					      <td style="color:Tomato;">Invalid Product Price!</td>
					
					<%} %>
				</tr>
				
				<tr>
					<td>Shipping Address:</td>
					<td><input type="text" name="shippingaddress"  id="shippping_address" value=<%=request.getAttribute("shipping_address") %>></td>
					<% if(request.getAttribute("shipping_address_error")!=null) { %>
					
					      <td style="color:Tomato;"><p>Invalid Shippping Address!</p></td>
					
					<%} %>
				</tr>
				
				<tr>
					<td>City:</td>
					<td><input type="text" name="city" id="city_area" value=<%=request.getAttribute("city_area") %>></td>
					<% if(request.getAttribute("city_area_error")!=null) { %>
					
					      <td style="color:Tomato;"><p>Invalid city!</p></td>
					
					<%} %>
				</tr>
				
				<tr>
					<td>State:</td>
					<td><input type="text" name="state" id="state_area" value=<%=request.getAttribute("state_area") %>></td>
					<% if(request.getAttribute("state_area_error")!=null) { %>
					
					      <td style="color:Tomato;"><p>Invalid state!</p></td>
					
					<%} %>
				</tr>
				
				<tr>
					<td>Country:</td>
					<td><input type="text" name="country" id="country_area" value=<%=request.getAttribute("country_area") %>></td>
					<% if(request.getAttribute("country_area_error")!=null) { %>
					
					      <td style="color:Tomato;"><p>Invalid state!</p></td>
					
					<%} %>
				</tr>
				
				<tr>
					<td><input type="submit" value="Save"></td>
					<td><input type="reset"  value="clear"></td>
					
				</tr>
			</table>
		</form>
	</div>
	<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search by mobile number" title="Type in a name">	
	
			
	<table id="myTable">
		<tr>
		      
		      <th>Id</th>
		      <th>First Name</th>
		      <th>Last Name</th>
		      <th>Email Address</th>
		      <th>Mobile Number</th>
     	</tr>
     
     	 <%
   	  try
     	   {
     	  List<Lead> leadList = null;
     	  
     	 leadList = (List<Lead>)request.getAttribute("lead_list");
     	  
     	  for (int i = 0;i<leadList.size();i++) { %>
     	
     	<tr>
     		<td><%=leadList.get(i).getId() %></td>
     	    <td><%=leadList.get(i).getFirstName() %></td>
     	    <td><%=leadList.get(i).getLastName() %></td>
     	    <td><%=leadList.get(i).getEmailId() %></td>
     	    <td><%=leadList.get(i).getMobileNumber() %></td>
     	
     	
     	</tr>
	
	
	<%}%>
     	
 <%}catch(Exception e){ %>
 
 <%} %>
</table>
	
<script>
function myFunction() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[4];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}
</script>

<script>
    
                var table = document.getElementById('myTable');
                
                for(var i = 1; i < table.rows.length; i++)
                {
                    table.rows[i].onclick = function()
                    {
                         //rIndex = this.rowIndex;
                         document.getElementById("first_name").value = this.cells[1].innerHTML;
                         document.getElementById("last_name").value = this.cells[2].innerHTML;
                         document.getElementById("email_address").value = this.cells[3].innerHTML;
                         document.getElementById("mobile_number").value = this.cells[4].innerHTML;
                    };
                }
    
</script>

</body>
</html>