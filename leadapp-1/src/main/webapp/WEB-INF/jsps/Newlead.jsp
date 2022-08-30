<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lead Page</title>
</head>
<body>
	<h1>Create New Lead Here</h1>
	<hr>
	<form action ="saveLead" method = "post">
		<pre>
				Id<input type="text" name="id" />
				First Name<input type="text" name="firstName" />
				Last Name<input type="text" name="lastName" />
				Email<input type="text" name="email" />
				City<input type="text" name="city" />
				Mobile<input type="text" name="mobile" />
				<input type="submit" value="Save" />
			</pre>
	</form>
	${msg}
</body>
</html>