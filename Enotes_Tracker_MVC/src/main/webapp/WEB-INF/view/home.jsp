<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<!-- Home Image -->
<div class="container-fluid p-0 m-0">
<img alt="homeimage" src="<c:url value="/resources/images/notesbg.jpg"  />" width="100%" height="650vh" />
</div>
</body>
</html>