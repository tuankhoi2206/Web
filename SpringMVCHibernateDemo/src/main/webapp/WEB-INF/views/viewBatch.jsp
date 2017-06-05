<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Batch</title>
</head>
<body>
	<form:form method="POST" modelAttribute="batch">
		<div>
			Choose the batch
			<!-- path thuộc tính trả về -->
			<!-- dùng reflect để bindata -->
			<!-- dữ liệu này tương ứng với thuộc tính nào??? -->
			<form:select path="batchId" onchange="this.form.submit()">
				<form:option value="0" label="Select" />
				<form:options items="${batchs}" itemValue="batchId"
					itemLabel="batchName" />
			</form:select>

			<%-- <td><form:select items="${tutors}" path="tutor" /></td> --%>
		</div>
		<div>
			Students engaged to the batch:<br>
			<table border="1">
				<tr>
					<td>ID</td>
					<td>Name</td>
				</tr>
				<c:forEach var="st" items="${students}">
					<tr>
						<td><c:out value="${st.studentId}" /></td>
						<td><c:out value="${st.studentName}" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</form:form>
</body>
</html>
