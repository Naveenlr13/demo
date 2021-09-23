<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Index Page</title>
</head>
<body>

	<h1>Enter The Login Details</h1>
<hr/>
    ${msg }
	<form action="LoginController" method="post">
		User Name <input type="text" name="userName" /> <br /> 
		Password <input	type="password" name="password" /> <br /> 
		<input type="submit" value="login" name="login">

	</form>

</body>
</html>