<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file = "menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lead Page</title>
</head>
<body>
	<h2>Lead | Create New Lead</h2>
	<hr>
	<form action="savelead">
		<pre>
			Id<input type="text" name="id" />
			Name<input type="text" name="name" />
			Email<input type="text" name="email" />
			City<input type="text" name="city" />
			Mobile<input type="text" name="mobile" />
			<input type="submit" value="Save" />
		</pre>
	</form>
	${msg}
</body>
</html>