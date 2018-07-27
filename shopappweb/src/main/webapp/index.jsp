<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping App</title>
</head>
<body>
	<h3>Shopping Application</h3>
	<div>
		Welcome ${sessionScope.user}
	</div>
	<div>
		${param.msg}
	</div>
	<a href="login.jsp">Login</a> <br />
	<a href="addProduct.jsp">Add Product</a> <br />
	<a href="listProduct.do">List Products / Add Products to Cart</a> <br />

</body>
</html>