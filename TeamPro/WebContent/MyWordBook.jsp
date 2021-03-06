<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<!-- Modal memberupdate -->
		<div class="modal fade" id="myModal2" role="dialog">
			<div class="modal-dialog">
		  	
				<div class="modal-content card" style="width: 80%; height: 80%;">
				<div class="card-header">
					<h3>개인정보 수정</h3>
				</div>
				<div class="card-body">
					<form action="updateAction.member" method="post" enctype="multipart/form-data">
						<h6>빈칸 입력시에는 정보변경을 하지 않고 입력한 정보만 변경되게 됩니다.</h6>
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<input type="password" class="form-control" name = "user_pass" placeholder="password" required>
						</div>
						<div class="input-group form-group">
							<div class="input-group-prepend">				
								<span class="input-group-text"><i class="fas fa-at"></i></span>
							</div>
							<input type="text" class="form-control" name = "user_name" placeholder="User Name" required>						
						</div>
						<div class="input-group form-group">
							<div class="input-group-prepend">				
								<span class="input-group-text"><i class="fas fa-at"></i></span>
							</div>
							<input type="file" class="form-control" name = "image" placeholder="image" required>						
						</div>
						<div class="input-group form-group">
							<div class="input-group-prepend">				
								<span class="input-group-text"><i class="fas fa-at"></i></span>
							</div>
							<input type="text" class="form-control" name = "email" placeholder="e-mail" required>						
						</div>
						<c:if test="${kindList != null}">
							<div class="input-group form-group">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="fas fa-at"></i></span>
								</div>
								<select class="form-control" id="category" name="favor">
			                        <c:forEach var="kind" items="${kindList}" varStatus="status">
			                        	<option value="${kind.kind_id }">${kind.kind_name }</option>
			                        </c:forEach>
								</select>
							</div>
						</c:if>
						<div class="form-group">
							<input type="submit" value="변경" class="btn float-right login_btn">
						</div>
						</form>
					</div>
					<div class="card-footer">
					</div>
				</div>		    
			</div>
		</div>
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
		<header class="masthead" style="background-image: url('img/about-bg.jpg')">
			<div class="overlay"></div>
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-md-10 mx-auto">
						<div class="page-heading">
							<h1>나의 단어장</h1>
						</div>
					</div>
				</div>
			</div>
		</header>

		<!-- Main Content -->
		<div class="container-fluid">
	
			<div class="row">
				<div class="col-md-4 text-center">
					<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg" class="img-thumbnail" />
				</div>
				<div class="col-md-8">
					<h2>
						${login_user.user_id }
					</h2>
					<p>
						안녕하세요. ${login_user.user_name }입니다.
					</p>
						<li class="nav-item">
							<a class="btn btn-primary my-2 my-sm-0" data-toggle="modal" data-target="#myModal2">개인정보 수정</a>
						</li>     
					<div class="text-right" style="padding: 0.5rem 1rem;">
						<button class="btn btn-primary my-2 my-sm-0" type="submit">
								단어장 만들기
						</button>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<ul class="nav">
						<li class="nav-item dropdown ml-md-auto">
							 <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown">분류별 검색</a>
							<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
								 <c:forEach var="kind" items="${kindList }" varStatus="status">
										<a class="dropdown-item" href="fillteringBookKind?kind_id=${kind.kind_id }">${kind.kind_name }</a>
								</c:forEach>
								 <!-- <a class="dropdown-item" href="#">정보처리기사</a>
								 <a class="dropdown-item" href="#">토익</a> 
								 <a class="dropdown-item" href="#">JLPT 1급</a> -->
								<div class="dropdown-divider">
								</div> <a class="dropdown-item" href="#">전체</a>
							</div>
						</li>
					</ul>
					<div class="row">
						<c:forEach var="book" items="${bookList }" varStatus="book_cnt">					
							<div class="col-md-4">
								<div class="card">
									<div class="card-block">
										<h3 class="card-title">
											${book.book_name}
										</h3>
										<h5 class="card-kind">
											<c:forEach var="kind" items="${kindList }" varStatus="status">
												<c:if test="${book.kind_id == kind.kind_id }">
													${kind.kind_name }		
												</c:if>
											</c:forEach>									
										</h5>
										<p class="card-text">
											단어장 자유 메모. Ex) 암기용, 30일, 매일보기....
										</p>
										<p>
											<a class="btn btn-primary" href="wordBookDetail.word?book_id=${book.book_id}">View</a>
										</p>
									</div>
								</div>
							</div>
						</c:forEach>
						<!-- <div class="col-md-4">
							<div class="card">
								<div class="card-block">
									<h3 class="card-title">
										단어장 이름
									</h3>
									<h5 class="card-kind">
										분류
									</h5>
									<p class="card-text">
										단어장 자유 메모. Ex) 암기용, 30일, 매일보기....
									</p>
									<p>
										<a class="btn btn-primary" href="WordBookDetail.html">View</a>
									</p>
								</div>
							</div>
						</div> -->
					</div>
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