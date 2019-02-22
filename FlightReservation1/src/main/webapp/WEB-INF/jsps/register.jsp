<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
<h2>Register to the system</h2>
	<form:form modelAttribute="User" action="registerUser" >
		<pre>
		Name : <form:input type="text" path="firstName" />
		Email : <form:input type="text" path="email" /> 
		Password : <form:input type="password" path="password" /> 
		<input type="submit" value="Register me" />
		</pre>
	</form:form>
</body>
</html>