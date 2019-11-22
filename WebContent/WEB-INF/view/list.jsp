<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
		border-collapse: collapse;
	}
	td, th {
		padding:5px;
		border:1px solid black;
	}
	body>a:first-child {
		border:1px solid black;
		background:skyblue;
		margin:5px;
		padding:5px;
		display:inline-block;
		text-decoration: none;
		color:black;
	}
</style>
</head>
<body>
	<a href="add.do">새 프로젝트 등록</a>
	<table>
		<tr>
			<th>프로젝트 이름</th>
			<th>시작날짜</th>
			<th>종료날짜</th>
			<th>상태</th>
		</tr>
		<c:forEach var="project" items="${list}">
			<tr>
				<td><a href="detail.do?no=${project.no}">${project.title}</a></td>
				<fmt:formatDate var="s_date" pattern="yyyy-MM-dd" value="${project.start_date}"/>
				<td>${s_date}</td>
				<fmt:formatDate var="e_date" pattern="yyyy-MM-dd" value="${project.end_date}"/>
				<td>${e_date}</td>
				<td>${project.state}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>