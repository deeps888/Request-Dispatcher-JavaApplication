<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
window.onload = function () { history.forward(); };
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error</title>
</head>
<body>
<%if (session.getAttribute("token") != null) {
	session.invalidate();
} %>
Sorry..! Something went wrong.<br/>
Click here to login <a href="<%=request.getScheme() + "://" + request.getServerName() + ":" +request.getServerPort() + request.getContextPath()%>">login</a>
</body>
</html>