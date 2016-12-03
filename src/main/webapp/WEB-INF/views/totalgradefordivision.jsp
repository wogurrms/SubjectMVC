<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<c:set var="sum" value="0"></c:set>
	<c:forEach var="subject" items="${totalGradeForDivision}">
		<tr>
			<td>${subject.key}</td>
			<td>${subject.value}</td>
		</tr>
		<c:set var="sum" value="${sum+subject.value}"></c:set>
	</c:forEach>
	<tr>
	
			<td>합계</td>
			<td>${sum}</td>
	</tr>
</table>
</body>
</html>