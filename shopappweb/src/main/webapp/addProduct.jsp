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
		${param.msg}
	</div>
	
	<form method="post" action="productAdd.do">
		Product Name <input type="text" name="name" /><br />
		Price <input type="text" name="price" /><br />
		Quantity <input type="number" name="quantity" /><br />
		<button type="submit">Add Product</button>
	</form>
</body>
</html>