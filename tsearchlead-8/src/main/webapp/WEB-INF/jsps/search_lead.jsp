<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Page</title>
</head>
<body>
	<h1>Search By Lead Id</h1>
	<hr>
	<form action = "getleadinfo" method = "post">
		<pre>
			Lead Id <input type="search" name="id" />
			<input type="submit" value="Search" /> 
		</pre>
	</form>

</body>
</html>