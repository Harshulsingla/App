<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="addUser" method="post"
		modelAttribute="addUser">
	Enter User Id:<form:input path="id" />
		<br />
	Enter User name:<form:input path="userName" />
		<br />
		<input type="submit" />
	</form:form>
</body>
</html>