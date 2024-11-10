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
<body>
<!-- Start Navbar-->
<%@include file="/WEB-INF/resources/component/navbar.jsp" %>
<!-- End Navbar-->
<div class="container mt-5">
	<div class="row">
		<div class="col-md-10 offset-md-1">
			<div class="card">
				<div class="card-header text-center">
					<h3>Edit Your Notes</h3>
					<c:if test="${ not empty msg }">
					<p class="fs-6 fw-bold text-success"> ${ msg }</p>
					</c:if>
					<c:remove var="msg"/>
				</div>
				<div class="card-body">
					<form action="updateNotes" method="post">
						
						<div class="mb-3">
							<label> Title : </label>
							<input type="text" name="title" class="form-control" value="${notes.title }"/>
						</div>
						<div class="mb-3">
							<label> Description : </label>
							<textarea rows="4" class="form-control" name="description">${notes.description }</textarea>
						</div>
						<input type="hidden" name="id" value="${notes.id }">
						<button class="btn btn-warning mt-4">Save</button>
					</form>
				</div>
				
			</div>
		</div>
	</div>
</div>
</body>
</html>