<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Data</title>
</head>
<body>
	<h1>All list of registration</h1>
	<hr>
	<table border = '1'>
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>City</th>
			<th>Mobile</th>
			<th>Delete</th>
			<th>Edit</th>
		</tr>
		<c:forEach var="lead" items="${leads}">
			<tr>
			<td>${lead.id}</td>
			<td>${lead.firstName}</td>
			<td>${lead.lastName}</td>
			<td>${lead.email}</td>
			<td>${lead.city}</td>
			<td>${lead.mobile}</td>
			<td><a href = "delete?id=${lead.id}">Delete</a>
			<td><a href = "getLeadInfo?id=${lead.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>