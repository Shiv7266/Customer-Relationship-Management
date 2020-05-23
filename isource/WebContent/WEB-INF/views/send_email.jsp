<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.*, com.isource.models.*, java.lang.Exception" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Send Email</title>
</head>
<body>
<br/>
<br/>
<center>
<form action="Email" method="post">
<table>
        
        
        <tr><td>To Email:</td><td><input type="text" name="toEmail" id = "toEmailAddress" readonly></td></tr>
        <tr><td>Subject:</td><td><input type="text" name="subject" id = "sendmessage" ></td></tr>
        <tr><td>Message:</td><td><textarea name="message" rows="20" cols="50"></textarea></td></tr>
        
        <tr><td><input type="submit" value="Send Email"></input></td>
        <td><input type="reset" value="clear"></input></td></tr>





</table>

 </form>
 </center>
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
<br/>
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
                         document.getElementById("toEmailAddress").value = this.cells[3].innerHTML;
                         
                    };
                }
    
</script>

</body>
</html>