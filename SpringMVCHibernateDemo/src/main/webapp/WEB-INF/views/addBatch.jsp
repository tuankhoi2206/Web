<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Batch</title>
</head>

<body>
	<form:form id="mainForm" method="post" commandName="model">
		<strong>Enter the batch name:</strong>
		<form:input path="batch.batchName" />
		<br />
		<br />
		<strong>Enter the student who belongs to the batch: </strong>
		<br />
		<strong>Student ID</strong>
		<form:input path="student.studentId" />
		<br />
		<br />
		<strong>Student Name</strong>
		<form:input path="student.studentName" />
		<br />
		<br />
		<form:button>Add Batch</form:button>
	</form:form>
</body>
</html>