<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee</title>
</head>
<body>

<h1>Employee</h1>
<table>
<c:forEach var="l" items="${listEmployee}">
<tr>
<td><c:out value="${l.id}"></c:out><br></td>
<td><c:out value="${l.name}"></c:out></td>
<td><a href="/location/delete.do?id=${l.id}">Delete</a></td>
</c:forEach>
</table>
</body>
</html>