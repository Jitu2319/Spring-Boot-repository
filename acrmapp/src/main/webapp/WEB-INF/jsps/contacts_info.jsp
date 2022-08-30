<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Info</title>
</head>
<body>
	<h2>Contact info</h2>
	<hr>
		First Name: ${contact.firstName}<br />
		Last Name: ${contact.lastName}	<br /> 
		Email: ${contact.email}	<br />
 		Lead Source: ${contact.leadsource}<br />
		 Mobile: ${contact.mobile}
		 
	<form action="sendemail" method="post">
		<input type="hidden" name="email" value="${contact.email}" /> 
		<input type="submit" value="Send Email" />
	</form>

</body>
</html>