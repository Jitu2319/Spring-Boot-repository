<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lead Result page</title>
</head>
<body>

	<a href="ViewLeads">Create New Lead</a>
	<h2>All Leads Here</h2>
	<hr>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Lead Source</th>
			<th>Mobile</th>
		</tr>
		<c:forEach var="jitendra" items="${leads}">
			<tr>
				<td>${jitendra.id}</td>
				<td><a href="getLeadById?id=${jitendra.id}">${jitendra.firstName}</a></td>
				<td>${jitendra.lastName}</td>
				<td>${jitendra.email}</td>
				<td>${jitendra.leadSource}</td>
				<td>${jitendra.mobile}</td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>