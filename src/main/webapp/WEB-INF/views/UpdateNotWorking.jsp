<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- <form:checkboxes path="users">
	    	
	    	<table>
	    	<tr>
	    	
		<c:forEach items="${userList}" var="usersList">
			<c:set var="contains" value="false" />
			<c:forEach items="${projectDto.users}" var="AllocatedUsers">	
				
				<c:if test="${usersList==AllocatedUsers}" >
				<td><input type="checkbox" path="users"  value="${usersList}" checked="checked"/>${usersList}</input><br /></td>
				<c:set var="contains" value="true" />
				</c:if>
				
			</c:forEach>
			
			<c:if test= "${contains eq 'false'}" >
				<td><input type="checkbox" path="users"  value="${usersList}" />${usersList}</input><br /></td>
			</c:if>
			
		</c:forEach>
		
		</table>
	    	</tr>
         
	</form:checkboxes> --%>
</body>
</html>