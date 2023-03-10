<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import = "java.util.ArrayList" %>
	<%@ page import = "com.wu.crmdemo.entity.Customer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Customer</title>
</head>
<body>


	<div id="wrapper">

		<div id-="header">
			<h1>CRM-Customer Relationship Manager</h1>
			<h2>List of customers</h2>
		</div>
	</div>
	
	
	
	<div id="button">
		<form action="FormForAdd.jsp">
			<input type="submit" value="ADD CUSTOMER">
		</form>
	</div>
	
	
	
	<div id="tablediv">
		<!-- Adding HTML Table here -->
		<table border="1">
		<tr>
		<th>Frist Name</th>
		<th>Last Name</th>
		<th>Email</th>
		<th>Action</th>
		</tr>
		<tr>
		<% ArrayList<Customer> customers =(ArrayList<Customer>) request.getAttribute("custdata"); %>
		<%for(Customer customer:customers) {%>
		<td><%=customer.getFirstName() %></td>
		<td><%=customer.getLastName() %></td>
		<td><%=customer.getEmail() %></td>
		<td> <a href="showFormForUpdate.jsp?fristName=<%=customer.getFirstName()%>
			&lastName=<%=customer.getLastName()%>
			&email=<%=customer.getEmail()%>"
		>UPDATE / DELETE</a></td>
		</tr>
		<%}%>
		
		
		</table>
	</div>



</body>
</html>