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

		<spring:url value="/updateCart" var="updateCart" />

		<!-- This tag defines the modelAttribute name for Spring mapping.
		 On form submission, Spring will parse the values from request and
		 fill the ContactForm bean and pass it to the controller. -->

		<form:form action="${updateCart }" method="POST"
			modelAttribute="myCart">
			<div id="content">
				<!-- iterator myCart -->
				<table border="1"
					style="border-collapse: collapse; border-color: gray;">
					<tr>
						<th>Code</th>
						<th>Create Date</th>
						<th>Name</th>
						<th>Quantity</th>
						<th>Price</th>
						<th>Subtotal</th>
					</tr>
					<c:forEach items="${myCart.listItem }" varStatus="status">
						<tr>
							<td><form:input
									path="listItem[${status.index}].products.code" type="text" /></td>
							<td>21-09-2016</td>
							<td><form:input
									path="listItem[${status.index}].products.name" type="text" /></td>
							<td><form:input path="listItem[${status.index}].numbers" /></td>
							<td><form:input
									path="listItem[${status.index}].products.price" type="text" /></td>
							<td><c:out value="${c.numbers*c.products.price }" /></td>
						</tr>
					</c:forEach>
				</table>
				<div>
					<table>
						<tr>
							<td><input type="submit" value="Update Quantity" /></td>
							<td><spring:url value="/shoppingCartCustomer"
									var="shoppingCartCust" /> <a href="${shoppingCartCust }">Enter
									Custome Info</a></td>
							<td><spring:url value="/productList" var="home" /> <a
								href="${home}">Continue Buy</a></td>
						</tr>
					</table>
				</div>
			</div>
			<!-- FOOTER -->
		</form:form>

	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>