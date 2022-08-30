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
	<form action = "savelead" method = "post">
		<pre>
			Id<input type="text" name="id" />
			First Name <input type="text" name="firstName" />
			Last Name <input type="text" name="lastName" />
			Email<input type="text" name="Email" />
			City<input type="text" name="City" />
			Mobile<input type="text" name="mobile" />
			<input type="submit" value="save" />
	 	</pre>
	</form>
	${msg}
</body>
</html>