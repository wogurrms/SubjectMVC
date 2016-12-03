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
	<c:forEach var="subject" items="${totalGradeForSemester}">
		<tr>
			<td>${subject.key}</td>
			<td>${subject.value}</td>
			<td><a href="${pageContext.request.contextPath}/subjectsForSemester?semester=${subject.key}">상세보기</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>