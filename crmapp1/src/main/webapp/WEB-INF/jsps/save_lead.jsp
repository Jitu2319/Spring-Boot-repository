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
	<h2>Lead || Save Lead Here</h2>
	<hr>
	<form action="savelead" method="post">
		<pre>
				Email<input type="email" name="email" />
				First Name<input type="text" name="firstName" />
				Last Name<input type="text" name="lastName" />
				Lead Source:
				<select name="leadSource">
			 	 <option value="TV Commercial">TV Commercial</option>
			  	<option value="Newspaper">Newspaper</option>
			  	<option value="Radio">Radio</option>
			  	<option value="Online">Online</option>
				</select>
				Mobile<input type="text" name="mobile" />
				<input type="submit" value="Save" />
		</pre>
	</form>

</body>
</html>