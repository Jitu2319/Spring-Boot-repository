<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lead Result</title>
</head>
<body>
	<h2>Lead Data</h2>
	<hr>
	<table border = '1'>
		<tr>
			<th>Lead Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>City</th>
			<th>Mobile</th>
		</tr>
		<tr>
			<td>${lead.id}</td>
			<td>${lead.name}</td>
			<td>${lead.email}</td>
			<td>${lead.city}</td>
			<td>${lead.mobile}</td>
		</tr>
	</table>

</body>
</html>