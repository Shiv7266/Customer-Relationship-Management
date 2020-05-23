<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.lang.String, java.io.*, java.lang.Exception"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload</title>
<link rel="stylesheet" href="resources/css/normalize.css" />
</head>
<body>

	<br />
	<br />

	<center>
		<h1>Upload Files</h1>
		<form action="UploadFile" enctype="multipart/form-data" method="post">


			<table>
				<tr>
					<td>Enter File Name:</td>
					<td><input type="text" name="file_name"></td>
				</tr>

				<tr>
					<td>Select:</td>
					<td><input type="file" name="file2" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="upload" /></td>
				</tr>


			</table>

	</form>	
	</center>
	<br /> 
	<p  style="color:red;">Select the file from table to be downloaded:</p><br/>
	<table id="myTable">
		<tr>
			<th>File Name</th>
		<tr>
			<%
				File f = new File(
						"C:\\Users\\Surbhi\\workspace\\isource\\WebContent\\files\\uploadedfiles");
				String[] fileList = f.list();

				for (int i = 0; i < fileList.length; i++) {
			%>
		
		<tr>
			<td><%=fileList[i]%></td>
		</tr>


		<%
			}
		%>



	</table>


		<form action="DownLoadFile" method="post">
			<input type="text" name="filedownload" id="fileDownloadName" />
            <input type="Submit" value="Download"/>
</form>

	<%
		String file_name = (String) request.getParameter("filename");
		if (file_name != null) {
			out.println(file_name + " File uploaded successfuly");
		}
	%>

	<script>
		var table = document.getElementById('myTable');

		for (var i = 1; i < table.rows.length; i++) {
			table.rows[i].onclick = function() {
				//rIndex = this.rowIndex;
				document.getElementById("fileDownloadName").value = this.cells[0].innerHTML;

			};
		}
	</script>


</body>
</html>