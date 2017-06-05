<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Form</title>
<spring:url value="/resources/css/style.css" var="styleCSS" />
<spring:url value="/resources/js/jquery-3.1.0.js" var="jqueryJS" />
<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script> -->
<link href="${styleCSS}" rel="stylesheet" />
<script src="${jqueryJS}"></script>
<script type="text/javascript">
	
</script>
<!-- <style type="text/css">
.errors {
	color: red;
}
</style> -->
</head>
<body>
	<form:form method="POST" commandName="form">
		<h1>Khôi Test</h1>
		<table>
			<tr>
				<td>Enter your name</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="errors" /></td>
			</tr>

			<tr>
				<td>Enter your mail</td>
				<td><form:input path="mail" /></td>
				<td><form:errors path="mail" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit"></td>
				<td></td>
			</tr>
		</table>
	</form:form>
</body>
</html>