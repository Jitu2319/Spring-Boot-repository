<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result Page</title>
</head>
<body>
	<h2>All Leads</h2>
	<hr>
	<table border='2'>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>City</th>
			<th>Mobile</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		<c:forEach var="lead" items="${leads}">
			<tr>
				<td>${lead.id}</td>
				<td>${lead.name}</td>
				<td>${lead.email}</td>
				<td>${lead.city}</td>
				<td>${lead.mobile}</td>
				<td><a href="delete?id=${lead.id}">Delete</a>
				<td><a href="getleadinfo?id=${lead.id}">Edit</a>
			</tr>
		</c:forEach>
	</table>

</body>
</html>