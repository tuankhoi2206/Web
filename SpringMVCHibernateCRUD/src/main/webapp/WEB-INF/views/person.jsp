<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Person</title>
</head>
<body>
	<h1>Add Person</h1>

	<!-- lúc mình set cứng /person/add sao lại nối chuỗi  
	
	sử dụng tag url tương đương ${pageContext.request.contextPath}/person/add
	
	lưu ý dấu / đằng sau
	-->
	<c:url value="/person/add" var="addAction" />
	<form:form method="POST" modelAttribute="person" action="${addAction}">
		<table>
			<tr>
				<td>ID</td>
				<td><form:input path="id" disabled="true" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Country</td>
				<td><form:input path="country" /></td>
			</tr>
			<tr>
				<td></td>
				<td><c:choose>
						<c:when test="${!empty person.name}">
							<input type="submit" value="Edit Person" />
						</c:when>
						<c:otherwise>
							<input type="submit" value="Add Person" />
						</c:otherwise>
					</c:choose></td>
			</tr>
		</table>

		<h2>Persons List</h2>
		<table border="1" cellpadding="3" cellspacing="0">
			<!-- viết th cho tiêu đề -->
			<tr>
				<th width="80">Person ID</th>
				<th width="120">Person Name</th>
				<th width="120">Person Country</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>

			<c:forEach var="p" items="${lstPersons}">
				<tr>
					<td><c:out value="${p.id }" /></td>
					<td><c:out value="${p.name}" /></td>
					<td><c:out value="${p.country}" /></td>
					<td>
						<!-- tương đương 
							http://localhost:8080/SpringMVCHibernateCRUD/person/edit/1
							ngược lại /person/edit/
							--> <a
						href="${pageContext.request.contextPath}/person/edit/${p.id}">Edit</a>
					</td>
					<!-- xem lại phần contextPath  -->
					<td><a
						href="${pageContext.request.contextPath}/person/delete/${p.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</form:form>
</body>
</html>