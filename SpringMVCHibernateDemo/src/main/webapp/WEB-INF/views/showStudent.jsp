<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Khai báo sử dụng JSTL Core Tags -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>

	<form id="mainForm" method="get" action="showStudent">
		Choose the batch <select onchange="submitForm()">
			<c:forEach items="${lstBatch}" var="batch">
				<option id="${batch.getBatchId()}">${batch.getBatchName()}</option>
			</c:forEach>
		</select>

		<%-- <table border="1">
			<c:forEach items="${model}" var="student">
				<tr>
					<td>${student.getStudentName()}</td>
				</tr>
			</c:forEach>
		</table> --%>
	</form>
</body>
<script type="text/javascript">
	function submitForm() {
		document.getElementById('mainForm').submit();
	}
</script>
</html>
