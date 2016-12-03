<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/main.css"></link>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<sf:form method="get"
		action="${pageContext.request.contextPath}/docreate"
		modelAttribute="subject">
		<table class="tableform">
			<tr>
				<td>Year :</td>
				<td><sf:select path="year" size="1"  >
				<option selected value=2017>2017</option>
				</sf:select>
				<br/> 
<%-- 				<sf:errors cssClass = "error" path="name"></sf:errors> --%>
				</td>
			</tr>
			<tr>
				<td>Semester :</td>
				<td><sf:select path="semester" size="1"  >
				<option selected value=1>1</option>
				</sf:select>
				<br/>
<%-- 				<sf:errors cssClass = "error"  path="email"></sf:errors> --%>
				</td>
			</tr>
			<tr>
				<td>Code :</td>
				<td><sf:input path="code" type="text" />
				<br/>
<%-- 				<sf:errors  cssClass = "error" path="text"></sf:errors> --%>
				</td>
			</tr>
			
			<tr>
				<td>Name :</td>
				<td><sf:input path="name" type="text" />
				<br/>
<%-- 				<sf:errors  cssClass = "error" path="text"></sf:errors> --%>
				</td>
			</tr>
			
			
			<tr>
				<td>Division :</td>
				<td>
					<sf:select path="division" size="1">
						<option value="자율">자율</option>
						<option value="토대">토대</option>
						<option value="인재">인재</option>
						<option value="교필">교필</option>
						<option value="전기">전기</option>
						<option value="전선">전선</option>
						<option value="전지">전지</option>
					</sf:select> 
					<br/>
<%-- 				<sf:errors  cssClass = "error" path="text"></sf:errors> --%>
				</td>
			</tr>
			
			
			<tr>
				<td>Grade :</td>
				<td>
				<sf:select path="grade" size="1">
						<option  value=1>1</option>
						<option  value=2>2</option>
						<option  value=3>3</option>
				</sf:select> 
				<br /> 
<%-- 				<sf:errors  cssClass = "error" path="text"></sf:errors> --%>
				</td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="Create Subject"></td>
			</tr>
			
			

		</table>
	</sf:form>
</body>
</html>