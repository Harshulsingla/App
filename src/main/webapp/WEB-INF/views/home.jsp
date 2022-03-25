<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PROJECT MANAGEMENT APPLICATION</title>


<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous">
</script>
	
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
 
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
 
 <jsp:include page="/WEB-INF/views/navbar.jsp" />
 
 <style><%@include file="/css/home.css"%></style>
 
</head>
<body>

<c:if test="${not empty success}">

<div class="alert alert-success alert-dismissible fade show"
		role="alert">

		<%=request.getParameter("success")%>
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div>

<c:remove var = "success" scope = "session" />
</c:if>


<c:if test="${not empty error}">

<div class="alert alert-danger alert-dismissible fade show"
		role="alert">

		<%=request.getParameter("error")%>
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div>

<c:remove var = "error" scope = "session" />
</c:if>


	<div class="search-create">
		<div style="white-space: nowrap;">
			<form action="searchproject" method="get">
				<div class="input-group mb-3">
					<input type="text" class="form-control" name="projectname"
						id="searchitem" value="${projectname}"
						placeholder="Search A Project">
					<div class="input-group-append">
						<button class="btn btn-primary" id="searchbutton">Search</button>
					</div>
				</div>
			</form>
		</div>

		<c:set var="profile" value="${user.profile}" />

		<c:if test="${profile=='ROLE_ADMIN'}">
			<div style="white-space: nowrap;">
				<a href="addproject" class="btn btn-primary" id="createbutton">CREATE
					PROJECT</a>
			</div>
		</c:if>
		<c:if test="${profile=='ROLE_USER'}">
			<div style="white-space: nowrap;">
				<a href="javascript:void(0)" 
					class="btn btn-light disable" id="createbutton">CREATE PROJECT</a>
			</div>
		</c:if>

	</div>
	
	<h1 class="page-heading">PROJECT DETAILS</h1>

	<div style="padding: 2rem">
		<table class="table">
			<thead class="thead-dark">
				<tr class="table-primary">
					<th scope="col">Project Id</th>
					<th scope="col">Project Name</th>
					<th scope="col">Project Status</th>
					<th scope="col">Start Date</th>
					<th scope="col">End Date</th>
					<th scope="col">Client Name</th>
					<th scope="col">Delete</th>
					<th scope="col">Update</th>
				</tr>
			</thead>


			<tbody>
				<c:forEach items="${project}" var="project">
					<tr class="table-light">
						<td>${project.projectId}</td>
						<td>
							 <button type="button" class="btn btn-light" data-bs-toggle="modal" data-bs-target="#showproject-${project.projectId}">${project.projectName}</button>
						</td>

						
<div class="container mt-5">
        
        <div class="modal" id="showproject-${project.projectId}">
            
            <div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title">${project.projectName}</h5>
										<button type="button" class="btn-close"	data-bs-dismiss="modal"></button>
									</div>
									<div class="modal-body">
										<form>
											<div class="mb-3">
												<p>
													<strong>Client Name:</strong> ${project.clientName}
												</p>
											</div>
											<div class="mb-3">
												<p>
													<strong>Project Status:</strong> ${project.status}
												</p>
											</div>
											<div class="mb-3">
												<p>
													<strong>Start Date:</strong> ${project.startDate}
												</p>
											</div>
											<div class="mb-3">
												<p>
													<strong>End Date:</strong> ${project.endDate}
												</p>
											</div>
											<div class="mb-3">
												<p>
													<strong>Allocated Resources: </strong>
												</p>
												<ul>
													<c:forEach items="${project.users}" var="user">
														<li>${user.userId}: ${user.userName}</li>
														<br>
													</c:forEach>
												</ul>
											</div>
										</form>
									</div>
									<div class="modal-footer"></div>
								</div>
							</div>
        </div>
    </div>



						<c:choose>
							<c:when test="${project.status=='Not Started'}">
								<td><div class="not-started">${project.status}</div></td>
							</c:when>

							<c:when test="${project.status=='In Progress'}">
								<td><div class="in-progress">${project.status}</div></td>
							</c:when>

							<c:otherwise>
								<td><div class="completed">${project.status}</div></td>
							</c:otherwise>
						</c:choose>



						<td>${project.startDate}</td>
						<td>${project.endDate}</td>
						<td>${project.clientName}</td>

						<c:set var="status" value="${project.status}" />
						<c:set var="profile" value="${user.profile}" />

						<c:if test="${(status=='Not Started') && (profile=='ROLE_ADMIN')}">
							<td>
								<button type="button" class="btn btn-light" class="enable" data-bs-toggle="modal" data-bs-target="#deleteModal-${project.projectId}"><strong>DELETE</strong></button>
							</td>

								<div class="modal" id="deleteModal-${project.projectId}">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title">${project.projectName}</h5>
												<button type="button" class="btn-close" id="close" data-bs-dismiss="modal">x</button>
											</div>
											<div class="modal-body">
												<form action="deleteProject/${project.projectId}" method="get">
													<div class="mb-3">
														<p>
															<strong>${user.userName} are You Sure, You want to Delete this Project?</strong>
														</p>
													</div>
													
											<div class="modal-footer">
													<button type="submit" class="btn btn-primary">Yes</button>
											</div>
												</form>
											</div>
										</div>
									</div>
								</div>


						</c:if>
						<c:if test="${(status=='Not Started') && (profile=='ROLE_USER') }">
							<td><button disabled="disabled" class="btn btn-light"> DELETE</button><br>
							</td>
						</c:if>
						<c:if test="${(status!='Not Started')}">
							<td><button disabled="disabled" class="btn btn-light"> DELETE</button><br>
							</td>
						</c:if>



						<c:if test="${(status!='Completed') && (profile=='ROLE_ADMIN')}">
							<td><a id="update-link" class="btn btn-light enable" href="updateProject/${project.projectId}"><strong>UPDATE</strong></a><br>
							</td>
						</c:if>
						<c:if test="${(status!='Completed') && (profile=='ROLE_USER')}">
							<td><button disabled="disabled" class="btn btn-light disable">UPDATE</button><br>
							</td>
						</c:if>
						<c:if test="${(status=='Completed')}">
							<td><button disabled="disabled" class="btn btn-light disable">UPDATE</button><br>
							</td>
						</c:if>


						<div id="id01-${project.projectId}" class="modal">
							<span onclick="document.getElementById('id01-${project.projectId}').style.display='none'" class="close" title="Close Modal">x</span>
							<form class="modal-content" action="deleteProject/${project.projectId}">
								<div class="container">
									<h1>Delete Project</h1>
									<p>Are you sure you want to delete your project?</p>
									<div class="clearfix">
										<button type="button" onclick="document.getElementById('id01-${project.projectId}').style.display='none'" class="cancelbtn">Cancel</button>
										<button class="deletebtn">Confirm</button>
									</div>
								</div>
							</form>
						</div>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>