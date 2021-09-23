<%@page import="java.util.List"%>
<%@page import="model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>List Of Employees</h2>
	<table>
		<thead>
			<tr>
				<th>Employee Id</th>
				<th>First Name</th>
				<th>Last name</th>
				<th>City</th>
				<th>Country</th>
				<th>Salary</th>
			</tr>
		</thead>
		<tbody>
		<% 
		//Scriptlets in jsp
		//Java Code
		List<Employee> employees=(List<Employee>)request.getAttribute("employees");
		for(Employee e : employees)
		{
		%>
			<tr>
				<td><%=e.getId() %></td>
				<td><%=e.getFirstName() %></td>
				<td><%=e.getLastName() %></td>
				<td><%=e.getCity() %></td>
				<td><%=e.getCountry() %></td>
				<td><%=e.getSalary() %></td>
			</tr>
			<%} %>
		</tbody>
	</table>
</body>
</html>