<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
        "http://www.w3.org/TR/html4/strict.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
<title>JPA Performance</title>
</head>
<body>
<h3> JPA Performance - Player ID <c:out value="${player.id}"/> </h3>
<table>
<tr><td>Query time: <c:out value="${time}"/> ms </td></tr>
  <tr><td>
       <c:out value="${player.firstName}"/>
       <c:out value="${player.lastName}"/>
 </td></tr>
</table>
</body>
</html>
