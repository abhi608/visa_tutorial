<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
	.error {
		color: red;
		font-size: 12pt;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add user</title>
</head>
<body>
	<h1>User Form</h1>
	<form:form commandName="user" action="addUser.do">
		First Name <form:input path="firstName"/><br />
		Last Name <form:input path="lastName"/><br />
		EMail <form:input path="email"/><br />
		Phone No. <form:input path="phone"/><br />
		<button type="submit">Add user</button>
	</form:form>
</body>
</html>