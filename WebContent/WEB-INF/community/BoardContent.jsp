<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="kh.semi.boardclass.community.model.vo.Board"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% Board vo = (Board)request.getAttribute("board"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
</head>
<body>
	<h2>${board.boardTitle }</h2>
	<div>
		<span style="font-size: 18px; font-weight: bold; float: left; margin-left:20px;">${board.userId }</span>
		<span style="float: right; margiin-rignt: 10px;">${board.boardWriteDate }</span>
		<span style="float: right; margiin-rignt: 10px;">조회수 : ${board.boardViewCount }</span>
	</div>
	
	<div style="margin-top: 50px; margin-bottom: 100px;">
		<div style="position: absolute; right: 11%;">
			<c:if test="${board.userId == userId }">
				<input type="button" value="수정" />
				<input type="button" value="삭제" />
			</c:if>
		</div>
	</div>
	<hr>
	<div class="cot">
		${board.boardContent }
	</div>

	<a href="boardwrite?bno=${board.boardNo }">답글작성</a>
</body>
</html>