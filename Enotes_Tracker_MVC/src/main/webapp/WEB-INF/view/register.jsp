<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notify App</title>
<%@include file="/WEB-INF/resources/component/headerlink.jsp" %>
</head>
<body style="background-color: #f0f0f0; ">
<!-- Start Navbar-->
<%@include file="/WEB-INF/resources/component/navbar.jsp" %>
<!-- End Navbar-->
<div class="container mt-5">
	<div class="row">
		<div class="col-md-6 offset-md-3">
			<div class="card">
				<div class="card-header text-center">
					<h3>Register Page</h3>
					<c:if test="${ not empty msg }">
					<p class="fs-6 fw-bold text-success"> ${ msg }</p>
					</c:if>
					<c:remove var="msg"/>
				</div>
				<div class="card-body">
					<form action="registerUser" method="post">
						<div class="mb-3">
							<label> Full Name : </label>
							<input type="text" name="fullName" class="form-control" />
						</div>
						<div class="mb-3">
							<label> Qualification : </label>
							<input type="text" name="qualification" class="form-control" />
						</div>
						<div class="mb-3">
							<label> Email : </label>
							<input type="email" name="email" class="form-control" />
						</div>
						<div class="mb-3">
							<label> Password : </label>
							<input type="password" name="password" class="form-control" />
						</div>
						
						<button class="btn btn-warning col-md-12">Register</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>


</body>
</html>