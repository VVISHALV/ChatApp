<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<%
		

		if (session.getAttribute("contactID") != null)
			response.sendRedirect("welcome.jsp");
	%>
	<h1>Login</h1>
	<form action="LoginServlet" method="post">
		<label for="email_address">Email:</label>
		<input type="email" id="email_address" name="email_address" required><br>
		<label for="password">Password:</label>
		<input type="password" id="password" name="password" required><br>
		<input type="submit" value="Login">
	</form>
</body>
</html>