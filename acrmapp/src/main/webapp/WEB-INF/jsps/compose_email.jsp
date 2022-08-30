<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Compose</title>
</head>
<body>
	<h1>Send Email</h1>
	<hr>
	<form action="send" method="post">
		<pre>
			To<input type="email" name="to" value="${to}" />
			Subject<input type="text" name="subject" />
			<textarea name="message" rows="20" cols="30">
			</textarea>
			<input type="submit" value="Send Email" />
		</pre>
	</form>
	${msg}

</body>
</html>