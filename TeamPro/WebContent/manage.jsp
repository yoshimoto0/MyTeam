<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<head>
	
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">
		
		<title>Quizlet</title>
		
		<!-- Bootstrap core CSS -->
		<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		
		<!-- Custom fonts for this template -->
		<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
		<link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
		
		<!-- Custom styles for this template -->
		<link href="css/clean-blog.min.css" rel="stylesheet">
	
	</head>

	<body>
	
		<!-- Navigation -->
		<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
			<div class="container">
				<a class="navbar-brand" href="home.jsp">Quizlet</a>
				<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
					Menu
					<i class="fas fa-bars"></i>
				</button>
				<div class="collapse navbar-collapse" id="navbarResponsive">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item">
							<a class="nav-link" href="home.jsp">Home</a>
						</li>						
						<c:choose>
							<c:when test="${login_user == null }">
								<li class="nav-item">
									<a class="nav-link" data-toggle="modal" data-target="#myModal">Login</a>
								</li>
								<li class="nav-item">
									<a class="nav-link" data-toggle="modal" data-target="#myModal2">Sign-up</a>
								</li>          	
							</c:when>
							<c:otherwise>
								<li class="nav-item">
									<a class="nav-link" href="viewOwnWordBook.word">나의 단어장</a>
								</li>
								<li class="nav-item">
									<a class="nav-link" href="study.jsp">학습하기</a>
								</li>
								<li class="nav-item">
									<a class="nav-link a" href="allWord.word">단어검색</a>
								</li>
								<c:if test="${login_user.isAdmin == 1}">
									<li class="nav-item">
										<a class="nav-link a" href="manage.html">단어관리</a>
									</li>					
								</c:if>
								<li class="nav-item">
									<a class="nav-link" href="updateForm.member">My Page</a>
								</li>
								<li class="nav-item">
									<a class="nav-link" href="logout.member">Logout</a>
								</li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</div>
		</nav>

		<!-- Page Header -->
		<header style="background-color:black; height:60px">
			<div class="overlay"></div>
		</header>

		<!-- Post Content -->
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<nav class="navbar navbar-expand-lg navbar-light bg-light">
						 
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="navbar-nav">
								<li class="nav-item dropdown">
									 <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown">Dropdown link</a>
									<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
										 <a class="dropdown-item" href="#">Action</a> <a class="dropdown-item" href="#">Another action</a> <a class="dropdown-item" href="#">Something else here</a>
										<div class="dropdown-divider">
										</div> <a class="dropdown-item" href="#">Separated link</a>
									</div>
								</li>
							</ul>
							<form class="form-inline">
								<input class="form-control mr-sm-2" type="text" /> 
								<button class="btn btn-primary my-2 my-sm-0" type="submit">
									Search
								</button>
							</form>
						</div>
					</nav>
					
					<table class="table">
						<thead>
							<tr>
								<th>
									#
								</th>
								<th>
									Product
								</th>
								<th>
									Payment Taken
								</th>
								<th>
									Status
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									1
								</td>
								<td>
									TB - Monthly
								</td>
								<td>
									01/04/2012
								</td>
								<td>
									Default
								</td>
							</tr>
							<tr class="table-active">
								<td>
									1
								</td>
								<td>
									TB - Monthly
								</td>
								<td>
									01/04/2012
								</td>
								<td>
									Approved
								</td>
							</tr>
							<tr class="table-success">
								<td>
									2
								</td>
								<td>
									TB - Monthly
								</td>
								<td>
									02/04/2012
								</td>
								<td>
									Declined
								</td>
							</tr>
							<tr class="table-warning">
								<td>
									3
								</td>
								<td>
									TB - Monthly
								</td>
								<td>
									03/04/2012
								</td>
								<td>
									Pending
								</td>
							</tr>
							<tr class="table-danger">
								<td>
									4
								</td>
								<td>
									TB - Monthly
								</td>
								<td>
									04/04/2012
								</td>
								<td>
									Call in to confirm
								</td>
							</tr>
						</tbody>
					</table>
					<nav>
						<ul class="pagination">
							<li class="page-item">
								<a class="page-link" href="#">Previous</a>
							</li>
							<li class="page-item">
								<a class="page-link" href="#">1</a>
							</li>
							<li class="page-item">
								<a class="page-link" href="#">2</a>
							</li>
							<li class="page-item">
								<a class="page-link" href="#">3</a>
							</li>
							<li class="page-item">
								<a class="page-link" href="#">4</a>
							</li>
							<li class="page-item">
								<a class="page-link" href="#">5</a>
							</li>
							<li class="page-item">
								<a class="page-link" href="#">Next</a>
							</li>
						</ul>
					</nav>
				</div>
			</div>
		</div>

  		<hr>

		<!-- Footer -->
		<footer>
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-md-10 mx-auto">
				  		<p class="copyright text-muted">Copyright &copy; Your Website 2019</p>
					</div>
				</div>
			</div>
		</footer>

		<!-- Bootstrap core JavaScript -->
		<script src="vendor/jquery/jquery.min.js"></script>
		<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
		
		<!-- Custom scripts for this template -->
		<script src="js/clean-blog.min.js"></script>

	</body>

</html>
