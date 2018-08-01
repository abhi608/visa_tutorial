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
	<form:form commandName="event" action="addEvent.do">
		Event Id <form:input path="id"/><br />
		Event Name <form:input path="eventName"/><br />
		Event Date <form:input path="eventDate"/><br />
		Location <form:input path="location"/><br />
		<button type="submit">Add event</button>
	</form:form>
</body>
</html>