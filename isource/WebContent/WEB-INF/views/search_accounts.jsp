<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.*, com.isource.models.*, java.lang.Exception" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accounts Reports</title>
<link rel="stylesheet" href="resources/css/normalize.css"/>
</head>
<body>

<br/>
<br/>

<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search by mobile number" title="Type in a name">	
	
			
	<table id="myTable">
		<tr>
		      
		      <th>Id</th>
		      <th>Salutation</th>
		      <th>First Name</th>
		      <th>Last Name</th>
		      <th>Email Address</th>
		      <th>Mobile Number</th>
		      <th>Product Name</th>
		      <th>Product Price</th>
		      <th>Shipping Address</th>
		      <th>City</th>
		      <th>State</th>
		      <th>Country</th>
		      
     	</tr>
     
     	 <%
   	  try
     	   {
     	  List<Accounts_Data> accountList = null;
     	  
     	 accountList = (List<Accounts_Data>)request.getAttribute("account_list");
     	  
     	 for (int i = 0;i<accountList.size();i++) { %>
     	
     	<tr>
     		<td><%=accountList.get(i).getId() %></td>
     		<td><%=accountList.get(i).getSalutation() %></td>
     	    <td><%=accountList.get(i).getFirstName() %></td>
     	    <td><%=accountList.get(i).getLastName() %></td>
     	    <td><%=accountList.get(i).getEmailAddress() %></td>
     	    <td><%=accountList.get(i).getMobileNumber() %></td>
     	    <td><%=accountList.get(i).getProductName() %></td>
     	    <td><%=accountList.get(i).getProductPrice() %></td>
     	     <td><%=accountList.get(i).getShippingAddress() %></td>
     	     <td><%=accountList.get(i).getCity() %></td>
     	     <td><%=accountList.get(i).getState() %></td>
     	     <td><%=accountList.get(i).getCountry() %></td>
     	
     	</tr>
	
	
	<%}%>
     	
 <%}catch(Exception e){ %>
 
 <%} %>
</table>

<br/>

<Button onclick="ExportToExcel()">Click to Download Excel Report</Button>

<script type="text/javascript">
function ExportToExcel(mytblId){
       var htmltable= document.getElementById('myTable');
       var html = htmltable.outerHTML;
       window.open('data:application/vnd.ms-excel,' + encodeURIComponent(html));
    }
</script>

<script>
function myFunction() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[5];
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


</body>
</html>