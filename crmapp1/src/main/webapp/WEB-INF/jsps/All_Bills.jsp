<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bills page</title>
</head>
<body>

	<h2>All Bills Here</h2>
	<hr>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Amount</th>
			<th>Mode</th>
			<th>Product</th>
		</tr>
		<c:forEach var="bill" items="${bills}">
			<tr>
				<td>${billing.id}</td>
				<td>${billing.firstName}</td>
				<td>${billing.lastName}</td>
				<td>${billing.email}</td>
				<td>${billing.leadSource}</td>
				<td>${billing.mobile}</td>
				<td>${billing.amount}</td>
				<td>${billing.mode}</td>
				<td>${billing.product}</td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>