<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Add Employee</h2>
<h4>Enter employee details</h4><br/>
<form action="EmployeeController" method="post">
	Employee Id<input type="number" name="id"/><br/>
	First Name<input type="text" name="firstName"/><br/>
	Last Name <input type="text" name="lastName"/><br/>
	City <input type="text" name="city"/><br/>
	Country<input type="text" name="country"/><br/>
	Salary <input type="number" step="any" name="salary"/><br/>
	<input type="submit" value="Add employee" name="Add employee" /><br/>

</body>
</html>