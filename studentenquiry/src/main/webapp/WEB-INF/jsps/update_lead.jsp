<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lead</title>
</head>
<body>
	<h2>Lead | Create new Lead</h2>
	<hr>
	<form action = "updatelead" method = "post">
		<pre>
			Id<input type="text" name="id" value = "${lead.id}"/>
			First Name <input type="text" name="firstName" value = "${lead.firstName}"/>
			Last Name <input type="text" name="lastName"  value = "${lead.lastName}" />
			Email<input type="text" name="email" value = "${lead.email}" />
			City<input type="text" name="city" value = "${lead.city}"/>
			Mobile<input type="text" name="mobile" value = "${lead.mobile}"/>
			<input type="submit" value="save" />
	 	</pre>
	</form>
	${msg}
</body>
</html>