<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Rental Report</h2>
	<table border="1">
		<tr>
			<th>ID</th><th>Customer Email</th><th>Vehicle Registration</th><th>Type</th><th>Rental Date</th>
		</tr>
		<c:forEach items="${reports}" var="report">
			<tr>
				<td>${report.id}</td>
				<td>${report.email}</td>
				<td>${report.registrationNumber}</td>
				<td>${report.vehicleType}</td>
				<td>${report.rentalDate}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>