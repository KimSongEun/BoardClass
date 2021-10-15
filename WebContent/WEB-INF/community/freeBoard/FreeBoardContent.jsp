<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="kh.semi.boardclass.community.model.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<% Board vo = (Board)request.getAttribute("boardvo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보드클래스</title>
<link rel="stylesheet" href="css/community/BoardContent.css" />
<link rel="stylesheet" href="css/community/cmain.css" />
</head>
<body>
<c:import url="../header.jsp" />

<div id="guide" class="row">
<nav id="aside" class="column">
		<ul>
			<li><a href="./cmain">커뮤니티</a></li>
			<li><a href="#">공지사항</a></li>
			<li><a href="./cf">자유게시판</a></li>
			<li><a href="#">유저정보게시판</a></li>
			<li><a href="#">모임게시판</a></li>
		</ul>
</nav> <!-- TODO 링크 첨부 -->

<div class="conwrap">
	<div class="h3group">
		<h3 class="tit">자유게시판</h3>
		<div class="location">
			<span class="depth">홈</span>
			<span class="depth">커뮤니티</span><strong class="this">자유게시판</strong>
		</div>
	</div>
	
	<div class="viewbody">
		<div class="hgroup">
			<div class="tit">${board.boardTitle }</div>
			<div class="util">
				<div class="name">${board.userId }</div>
				<div class="date">시간:${board.boardWriteDate }</div>
				<div class="hit">조회수: ${board.boardViewCount }</div>
			</div>
		</div>
		<div class= "content">
		내용 : ${content }
		<!-- 파일첨부 -->
		</div>
	<div class="bottom">
		<div class="utils">
			<div class="function">
				<button type="button" class="report reportBtn ">
					<span class="ico">신고</span>
				</button>
			</div>
		</div>
	</div>
	<div class="updte">
			<input type="button" value="수정" onclick="location.href='cfupdate?=boardNo=${board.boardNo }&pageNum=${pageNum }'">
			<input type="button" value="삭제" >
	</div>
	
</div>
</div>
</body>
</html>