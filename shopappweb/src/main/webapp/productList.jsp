<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product List</title>
</head>
<body>
	<div>
		Welcome ${sessionScope.user}
	</div>
	<h2>Product Catalogue</h2>
	<form method="post" action="cartAdd.do">
		<table border="1">
			<tr>
				<th>ID</th><th>Product</th><th>Price</th><th>Select</th>
			</tr>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${report.price}</td>
					<td><input type="checkbox" name="id" value="${product.id}"></td>
				</tr>
			</c:forEach>
		</table>
		<button type="submit">Add to Cart</button>
	</form>
</body>
</html>