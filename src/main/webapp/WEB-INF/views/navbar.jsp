<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>

#home-button {
	margin-left: 1000px;
}

.navbar-light .navbar-brand {
    color: rgb(255,255,255);
     font-size: 21px;
} 
</style>


</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img
				src="https://cdn-icons.flaticon.com/png/512/3051/premium/3051605.png?token=exp=1648321389~hmac=2abcdd53061c7cad65aeff7dae22c0e1" alt="" width="40"
				height="40">
			</a> <a class="navbar-brand" href="home">PROJECT MANAGEMENT</a>
			<div class="collapse navbar-collapse" id="navbarSupportedContent"
				align='right'>
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item" id="home-button"><a
						class="nav-link active" aria-current="page" href="/projectmgmt/home"><button type="button" class="btn btn-outline-light">HOME</button></a>
					</li>
					<li class="nav-item"><a class="nav-link" href="/projectmgmt/logout"><button type="button" class="btn btn-outline-danger">Log Out</button></a>
					</li>
				</ul>
			</div>
		</div>
	</nav>

</body>
</html>