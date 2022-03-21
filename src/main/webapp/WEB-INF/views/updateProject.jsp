<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<form:form action="../updateProject" method="post"
		modelAttribute="projectDto" >
		
		<form:hidden path="id"/><br/>
	
	Enter project name:<form:input path="projectName"/><br />
	
	 Enter start date:<form:input path="startDate" /><br />
	Enter end date :<form:input path="endDate" /><br /> 
	
	Enter status:<form:input path="status" /><br />
	
	Enter client name:<form:input path="clientName" /><br />
	
	
	</form:form>
	
	<form:form action="../updateProject" method="post"
		modelAttribute="projectDto" >
	
	Allocated Resources:
	
	<table>
         
            <tr>
                
                	
		<c:forEach items="${userList}" var="users">
		<td><input type="checkbox" name="language"  value="${users}"/>${users}</input><br /></td>
		</c:forEach>
 
            </tr>
 
        </table>
	

		<input type="submit" />
	
	</form:form>
	
</body>
</html> --%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="../updateProject" method="post"
		modelAttribute="projectDto">

		<form:hidden path="id" />
		<br />
	
	Enter project name:<form:input path="projectName" />
		<br />

	<%--  Enter start date:<form:input path="startDate" /><br />
	Enter end date :<form:input path="endDate" /><br />  --%>
	
	Enter status:<form:input path="status" />
		<br />
	
	Enter client name:<form:input path="clientName" />
		<br />
	
	Allocated Resources:
	
	<c:forEach items="${userList}" var="user">
			<tr>
				<c:set var="contains" value="false" />
				<c:forEach items="${projectDto.users}" var="users">
					<c:if test="${user } == ${ users}">
						<c:set var="contains" value="true" />
					</c:if>
				</c:forEach>

				<c:choose>
					<c:when test="${contains } == 'true'">
					
					<form:checkbox path="users" value="${ user}" checked="checked" />${user.userName}
					</c:when>
					<c:otherwise>
					
				<form:checkbox path="users" value="${ user}" />${user.userName}
					</c:otherwise>
				</c:choose>
				 </td>

			</tr>
			<br>
		</c:forEach>

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


		<input type="submit" />
	</form:form>
</body>
</html>