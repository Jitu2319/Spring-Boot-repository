<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Lead</title>
</head>
<body>
	<h2>Search Lead by Id</h2>
	<hr>
	<form action = "getleadinfo" method = "post">
		Lead Id : <input type = "text" name = "id"/>
		<input type = "submit" value ="Search"/>
	</form>

</body>
</html>