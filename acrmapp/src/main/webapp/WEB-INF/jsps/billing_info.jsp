<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Billing Page</title>
</head>
<body>
	<h2>Billing | Create</h2>
	<hr>
	<form action="generateBill" method="post">
		<pre>
				First Name: <input type="text" name="firstName" value = "${contact.firstName}" readonly/>
				Last Name: <input type="text" name="lastName" value = "${contact.lastName}" readonly/>
				Email: <input type="email" name="email" value = "${contact.email}" readonly/>
				Mobile: <input type="text" name="mobile" value = "${contact.mobile}" readonly/>
				Product: <input type = "text" name = "product"/>
				Amount: <input type = "text" name = "amount"/>
				Mode of Payment:
				Cash <input type="radio" name="mode" value="cash">
				Online <input type="radio" name="mode" value="online">
				<input type="submit" value="Generate" />
				
			</pre>
	</form>

</body>
</html>