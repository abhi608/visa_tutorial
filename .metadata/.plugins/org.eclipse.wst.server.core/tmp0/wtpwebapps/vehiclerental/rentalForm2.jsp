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
	<div>
		Welcome ${sessionScope.user}
	</div>
	<h2>Rental Form</h2>
	<form method="post" action="hireVehicle.do">
		Select vehicle:
		<select name="vehicle">
			<c:forEach items="${regNos}" var="no">
				<option value="${no}">${no}</option>
			</c:forEach>
		</select> <br />
		
		Select Customer: <input type="text" name="customerId" /> <br />
		
		Amount: <input type="text" name="rentalAmount" /> <br />
		
		<button type="submit">Rent a Vehicle</button>
	</form>
</body>
</html>