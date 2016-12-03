<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

<p> <a href ="${pageContext.request.contextPath}/totalGradeforsemester"> 1. 학기별 이수 학점 조회 </a>
<p> <a href ="${pageContext.request.contextPath}/totalGradefordivision"> 2. 이수 구분별 학점 조회 </a>
<p> <a href ="${pageContext.request.contextPath}/createSubject"> 3. 수강 신청하기  </a>
<p> <a href ="${pageContext.request.contextPath}/checkApply"> 4. 수강 신청 조회 </a>

</body>
</html>
