<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Lead Page</title>
</head>
<body>
	<h2>Lead | Save Lead</h2>
	<hr>
	<form action="savelead" method="post">
		<pre>
				First Name: <input type="text" name="firstName" />
				Last Name: <input type="text" name="lastName" />
				Email: <input type="email" name="email" />
				Lead Source :
				<select name="leadsource">
				  <option value="Tv Commercial">Tv Commercial</option>
				  <option value="Newspaper">Newspaper</option>
				  <option value="Radio">Radio</option>
				  <option value="Online">Online</option>
				</select>
				Mobile: <input type="text" name="mobile" />
				<input type="submit" value="save" />
				
			</pre>
	</form>

</body>
</html>