<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="kh.semi.boardclass.community.model.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<% Board vo = (Board)request.getAttribute("vo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="./img/dicedice.ico" type="image/x-icon" sizes="16x16">
<title>신고하기</title>
</head>
<body>
	
	<form action="#" method="post">
		<div class="report_header">
			<p>제 목: </p><%=vo.getBoardTitle() %>
			<p>작성자:</p><%=vo.getBoardContent() %>
		</div>
		<div class="report_contetn">
			<p>사유 선택</p>
			<input type="checkbox" value="부적절한 홍보 게시글">
		</div>
	
	</form>
	
</body>
</html>