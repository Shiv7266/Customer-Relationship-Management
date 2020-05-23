<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.*, com.isource.models.*, java.lang.Exception" %>
<%@ include file = "header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Lead</title>
<link rel="stylesheet" href="resources/css/normalize.css"/>
</head>
<body>
<br/>
<br/>
<p style="color:red;">Select the row from table below to delete the record*</p><br/>

<form action="./DeleteLead" method="post">

	    Id:<input type="text" name="leadid" id="lid" required="">
        First Name:<input type="text" name="firstName" id="fname" required="">
        Last Name:<input type="text" name="lastName" id="lname" required="">
		Email Address:<input type="text" name="emailaddress" id="eaddress" required="">
        Mobile Number:<input type="text" name="mobilenumber" id="mnumber" required="">
        <input type="submit" value="Delete">
</form>
<br/>
<br/>
        
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
                         document.getElementById("lid").value = this.cells[0].innerHTML;
                         document.getElementById("fname").value = this.cells[1].innerHTML;
                         document.getElementById("lname").value = this.cells[2].innerHTML;
                         document.getElementById("eaddress").value = this.cells[3].innerHTML;
                         document.getElementById("mnumber").value = this.cells[4].innerHTML;
                    };
                }
    
</script>

</body>
</html>