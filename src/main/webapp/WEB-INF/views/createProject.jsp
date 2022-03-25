<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>

		<head>
			<meta charset="ISO-8859-1">
			<title>Create New Project</title>
			
			<!-- jQuery -->
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
			
			<!-- Bootstrap CSS -->
			<link
				href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
				rel="stylesheet"
				integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
				crossorigin="anonymous">
			
			<!-- Popper.js -->
			<script
				src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
				integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
				crossorigin="anonymous">
			</script>
			
			<script>
				 $(document).ready(function () {
					 $('form').submit(function(ev){
				
					 /* Start date should be less than End date validation */
				
					 if(Date.parse($('#startdate').val()) < Date.parse($('#enddate').val())){
					 console.log('nice date');
					 }
					 else{
					    alert('startdate should be lesser than enddate');
					    ev.preventDefault();
					 }
					 })
				})
 			</script>
			
			<jsp:include page="/WEB-INF/views/navbar.jsp" />
			
			<style><%@include file="/css/projectCrud.css"%></style>
		
		</head>
		
		<body>
		
			<div class="project-div">
			
				<form:form class="project-form" action="addproject" method="post" modelAttribute="project">
					<legend class="heading">Enter Project Details</legend>
		
					<div class="form-outline mb-3">
						Enter Project Name:
						<form:input class="form-control" autocomplete="off"
							path="projectName" required="required" minlength="2" maxlength="50"
							pattern=".*\\S.*[a-zA-z0-9 ]" />
		
						<br />
					</div>
		
		
					<div class="form-outline mb-3">
						Enter client name:
						<form:input class="form-control" autocomplete="off"
							path="clientName" required="required" minlength="2" maxlength="50"
							pattern=".*\\S.*[a-zA-z0-9 ]" />
						<br />
					</div>
		
					<div class="row g-3">
						<div class="col-md-6">
							Enter start date:
							<form:input class="form-control" required="required" id="startdate"
								type="date" path="startDate" />
							<br>
						</div>
						<div class="col-md-6">
							Enter end date :
							<form:input class="form-control" required="required" id="enddate"
								type="date" path="endDate" />
							<br />
						</div>
					</div> 
					Project Status:<form:select class="form-select" path="status"
						id="status" required="required" aria-label="Default select example">
						<option selected></option>
						<option value="Completed">Completed</option>
						<option value="In Progress">In Progress</option>
						<option value="Not Started">Not Started</option>
					</form:select>
					<br />
					
					Please Allocate Resources:<br>
					<div class="allocated-resources">
		
						<c:forEach items="${userList}" var="user">
							<tr>
								<td><form:checkbox path="users" class="form-check-input" id="chechbox"
										value="${ user}" />${user.userName}</td>
							</tr>
							<br>
						</c:forEach>
					</div>
					<br>
					<input type="submit" class="btn btn-primary" id="button"/>
		
				</form:form>
			</div>
		
		</body>
</html>




