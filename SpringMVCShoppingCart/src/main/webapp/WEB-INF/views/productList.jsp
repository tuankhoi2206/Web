<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<!-- Let's add tag srping:url -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<spring:url value="/resources/css/style.css" var="styleCSS" />
<link href="${styleCSS}" rel="stylesheet" />
<spring:url value="/resources/images/banner.png" var="bannerIMG" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<!-- Finish adding tags -->
<title>Trang chủ</title>
<style type="text/css">
#banner {
	height: 50px;
	background-image: url("${bannerIMG}");
	background-repeat: repeat-x;
}
</style>
</head>
<body>
	<div id="mainContainer">
		<jsp:include page="banner.jsp" />
		<jsp:include page="menubar.jsp" />

		<div id="content">
			<table>
				<tr>
					<th>Code</th>
					<th>Create Date</th>
					<th>Name</th>
					<th>Price</th>
					<th>Action</th>
				</tr>

				<c:forEach var="p" items="${lstProduct }">
					<tr>
						<td>${p.code }</td>
						<td>${p.createDate }</td>
						<td>${p.name }</td>
						<td>${p.price }</td>
						<td><spring:url value="/buyProduct?code=${p.code}"
								var="buyProduct" /> <a href="${buyProduct }">Buy Now</a></td>
					</tr>
				</c:forEach>
				
			</table>
		</div>
	</div>
	<!-- FOOTER -->
	<jsp:include page="footer.jsp" />
</body>
</html>