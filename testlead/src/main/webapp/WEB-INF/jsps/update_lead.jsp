<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file = "menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Page</title>
</head>
<body>
	<h2>Lead | Update Lead</h2>
	<hr>
	<form action="updatelead">
		<pre>
			Id<input type="text" name="id" value = "${lead.id}"/>
			Name<input type="text" name="name" value = "${lead.name}"/>
			Email<input type="text" name="email" value = "${lead.email}"/>
			City<input type="text" name="city" value = "${lead.city}"/>
			Mobile<input type="text" name="mobile" value = "${lead.mobile}"/>
			<input type="submit" value="Update" />
		</pre>
	</form>
</body>
</html>