<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>

	<!-- Định nghĩa đối tượng sẽ được hiển thị từ model -->
	<h1>Khôi Vũ - Spring MVC Demo</h1>
	<h2>model Books Show</h2>
	<form:form method="post" action="edit" modelAttribute="student">
		<h4>
			Your name :
			<form:label path="name">${student.name}</form:label>
			<form:hidden path="name" />
			<%-- <form:input path="name" /> --%>
		</h4>
		<h4>Edit your list of books</h4>
		<!-- spring làm điều này như thế nào??? -->
		<c:forEach items="${student.books }" var="book" varStatus="status">
			<form:input path="books[${status.index}]"></form:input>
		</c:forEach>
		<input type="submit" value="Finish">
	</form:form>
</body>
</html>