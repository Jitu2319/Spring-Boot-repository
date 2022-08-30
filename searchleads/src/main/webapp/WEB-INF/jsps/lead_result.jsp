<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lead Info</title>
</head>
<body>
	<h2>Lead Details</h2>
	<hr>
	Lead id : ${lead.id}<br/>
	Name: ${lead.name}<br/>
	Email : ${lead.email}<br/>
	City: ${lead.city}<br/>
	Mobile: ${lead.mobile}<br/>
	
${Error}
</body>
</html>