<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

    
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
<style>
    .hometop{
    display:flex;
    margin-left:900px;
    padding: 1em;
    }
    #searchitem{
    margin
    }
</style> 
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
  	 <a class="navbar-brand" href="#">
      <img src="/docs/5.1/assets/brand/bootstrap-logo.svg" alt="" width="30" height="24">
    </a>
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent" align='right' display="flex">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
      </ul>
    </div>
  </div>
</nav>



<div class="hometop">
<div><form action="searchproject" method="get">
<span><input type="text" name="projectname" id="searchitem" value="${projectname}" 
placeholder="Search A Project"></span>
<button class="btn btn-primary" id="searchbutton">Search</button>
</form>
</div>
<div>
<a href="addproject" class="btn btn-primary" id="createbutton">CREATE PROJECT</a>
</div>
</div>

 <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="addproject">addProject</a></li>
    <li class="breadcrumb-item"><a href="logout">LogOut</a></li>
    <li class="breadcrumb-item active" aria-current="page">Library</li>
  </ol>
</nav> 


<%-- 	<form  action="searchproject" method="get">
        <input type="text" name="projectname" id="projectname" value="${projectname}"/>
        <input type="submit" value="Search"/> --%>
	
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
		
		
		
		<c:forEach items="${project}" var="project">
		<tr>
		<td> ${project.projectId} </td>
		<td> ${project.projectName} </td>
		<td> ${project.status} </td>
		<td> ${project.clientName} </td>
		
		<c:set var="status" value="${project.status}"/>
		<c:set var="profile" value="${user.profile}"/>
		
					<c:if test="${(status=='Not Started') && (profile=='ROLE_ADMIN')}">
					<td><a href="deleteProject/${project.projectId}">delete</a><br> </td>
					</c:if>
					 <c:if test="${(status=='Not Started') && (profile=='ROLE_USER') }">
					<td><a href="javascript:void(0)" style="color: grey">delete</a><br> </td>
					</c:if> 
					 <c:if test="${(status!='Not Started')}">
					<td><a href="javascript:void(0)" style="color: grey">delete</a><br> </td>
					</c:if> 
					
		
 
 				<c:if test="${(status!='Completed') && (profile=='ROLE_ADMIN')}">
					<td><a href="updateProject/${project.projectId}">update</a><br> </td>
					</c:if>
					<c:if test="${(status!='Completed') && (profile=='ROLE_USER')}">
					<td><a href="javascript:void(0)" style="color: grey">update</a><br> </td>
					</c:if>
					 <c:if test="${(status=='Completed')}">
					<td><a href="javascript:void(0)" style="color: grey">update</a><br> </td>
					</c:if> 
 
 
		
		
		
		</tr>
		</c:forEach>
	</table>

</body>
</html>