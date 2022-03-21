<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

    
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SEARCH RESULT</title>
</head>
<body>


 <table>
		<thead>
		<tr>
		<th> Project Id </th>
		<th> Project Name </th>
		<th> Project Status </th>
		<th> Project Client Name </th>
		<th> Delete Project </th>
		<th> Update Project </th>
		</tr>
		</thead>
		
		
		
		<c:forEach items="${resultProjects}" var="resultProject">
		<tr>
		<td> ${resultProject.projectId} </td>
		<td> ${resultProject.projectName} </td>
		<td> ${resultProject.status} </td>
		<td> ${resultProject.clientName} </td>
		<td><a href="deleteProject/${resultProject.projectId}">delete</a><br> </td>
		<td><a href="updateProject/${resultProject.projectId}">update</a><br> </td>
		
		</tr>
		</c:forEach>
	</table>

</body>
</html>