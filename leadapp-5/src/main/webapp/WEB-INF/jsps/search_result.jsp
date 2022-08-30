<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result Page</title>
</head>
<body>
	<h1>All data</h1>
	<hr>
	<table border = '1'>
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>City</th>
			<th>Mobile</th>
		</tr>
		<c:forEach var="lead" items="leads">

			<th>${lead.id}</th>
			<th>${lead.firstName}</th>
			<th>${lead.lastName}</th>
			<th>${lead.Email}</th>
			<th>${lead.city}</th>
			<th>${lead.mobile}</th>

		</c:forEach>
	</table>

</body>
</html>