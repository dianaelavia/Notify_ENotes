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
<div class="container-fluid p-2">
	<div class="card-header text-center">
		<h4 >View All Notes</h4>
		<c:if test="${ not empty msg }">
			<p class="fs-6 fw-bold text-success"> ${ msg }</p>
		</c:if>
		<c:remove var="msg"/>
	</div>
	<div class="row">
	   <c:forEach items="${noteslist}" var="n">
		<div class="col-md-10 offset-md-1 mt-2">
		 	<div class="card">
				<div class="card-body">
					<div class="text-center">
						<img alt="View" src="<c:url value="/resources/images/viewnotes.jpg"  />" width="100px" height="100px" />
					</div>
					<p>${n.title }</p>
					<p>${n.description }</p>
					<p>Publish Date : ${n.date }</p>
					
					<div class="text-center">
						<a href="editNotes?id=${n.id }" class="btn btn-warning btn-sm">Edit</a>
						<a href="deleteNotes?id=${n.id }" class="btn btn-danger btn-sm">Delete</a>
					</div>
				</div>
			</div>
		</div>
	   </c:forEach>
	</div>
</div>
</body>
</html>