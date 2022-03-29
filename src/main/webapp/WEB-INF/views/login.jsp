<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>



<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<meta http-equiv='cache-control' content='no-cache'>
<meta http-equiv='expires' content='0'>
<meta http-equiv='pragma' content='no-cache'>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
	integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
	crossorigin="anonymous">
</script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
	integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
	crossorigin="anonymous">
</script>

<style><%@include file="/css/login.css"%></style>

</head>

<body>

	<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION }">
		<font color="red"> <c:out
				value="${SPRING_SECURITY_LAST_EXCEPTION.message }"></c:out>
		</font>
	</c:if>

	<nav class="navbar navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">PROJECT MANAGEMENT SYSTEM</a>

		</div>
		
	</nav>

	<section class="vh-100">
		<div class="container-fluid h-custom">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-md-9 col-lg-6 col-xl-5" class="container">
					<img
						src="https://i.ibb.co/5RyQKMh/Annotation-2022-03-21-110325.png"
						style="border-radius: 2rem;" class="img-fluid" alt="Sample image">
				</div>
				<div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1"
					class="form-div">


					<form action='applogin' method='POST'>

						<!-- Email input -->
						<div class="form-outline mb-4">
							<label class="form-label required" for="form3Example3">Username</label>
							<input type='text' name='cName' id="form3Example3"
								class="form-control form-control-lg"
								placeholder="Enter Username" required/>

						</div>

						<!-- Password input -->
						<div class="form-outline mb-3">
							<label class="form-label required" for="form3Example4">Password</label>
							<input type='password' name='cPass' id="form3Example4"
								class="form-control form-control-lg"
								placeholder="Enter password" required minlength="4"
								maxlength="12" />
						</div>



						<div class="text-center text-lg-start mt-4 pt-2"
							style="text-align-last: center;">
							<button type="submit" class="btn btn-primary btn-lg login-button" >Login</button>

						</div>

					</form>
				</div>
			</div>
		</div>
		<div
			class="d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-4 px-4 px-xl-5 bg-secondary copyright-bar">
			<!-- Copyright -->
			<div class="text-white mb-3 mb-0 copyright-div">
				Copyright © 2022. All rights reserved.</div>
			<!-- Copyright -->

			<!-- Right -->
	</section>


</body>
</html>