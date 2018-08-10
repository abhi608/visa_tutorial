<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 Welcome <%= session.getAttribute("user") %> <br/>
 Same as <br/>
 Welcome ${sessionScope.user}<br/>
 <a href = "LoginServlet"></a>
 
 <form method="post" action="ChatServlet">
 <input type="text" name="msg"/><button type="submit">Send</button>
 </form>
 
 <br/>
 
 <!-- Get messages from servlet context and print items -->
 <c:forEach items="${messages}" var="m">
 ${m} <br/>
 </c:forEach>

</body>
</html>