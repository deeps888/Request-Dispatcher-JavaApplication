<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.io.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
window.onload = function () { history.forward(); };
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<%
		if (session.getAttribute("token") != null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	%>
	<center>
		<h1>Login</h1>
		<form action="login" method="post">
			<input type="text" name="username" />
			<input type="password"	name="password" /> 
			<input type="submit" name="submit" value="Login" />
		</form>
	</center>
</body>
</html>