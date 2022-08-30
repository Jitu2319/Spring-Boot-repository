<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lead Info</title>
</head>
<body>
	<h2>Lead info</h2>
	<hr>
	First Name: ${lead.firstName}
	<br /> Last Name: ${lead.lastName}
	<br /> Email: ${lead.email}
	<br /> Lead Source: ${lead.leadsource}
	<br /> Mobile: ${lead.mobile}
	<br />

	<form action="sendemail" method="post">
		<input type="hidden" name="email" value="${lead.email}" /> <input
			type="submit" value="Send Email" />
	</form>
	<form action="convertToContact" method="post">
		<input type="hidden" name="id" value="${lead.id}" /> <input
			type="submit" value="Convert" />
	</form>
</body>
</html>