<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1>Login Form</h1>
	<% if (request.getAttribute("errorMessage") != null) {
		out.print(request.getAttribute("errorMessage"));
	}%>
	<form action="./LoginServlet" method="POST">
	<div>
		<label>Email:</label>
		<input type="text" name="email"/>
	</div>
	<div>
		<label>Password:</label>
		<input type="text" name="password"/>
	</div>
	<div>
		
		<input type="submit" Value="Login"/>
	</div>
	</form>
</body>
</html>