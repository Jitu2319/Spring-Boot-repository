<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Lead Page</title>
</head>
<body>
	<h1>Search Lead By Id</h1>
	<hr>
	<form action = "getleadinfo" method = "post">
		Lead id: <input type = "text" name = "id"/>
		<input type = "submit" value = "Search"/>
	</form>

</body>
</html>