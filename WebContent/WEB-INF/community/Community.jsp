<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="kh.semi.boardclass.community.model.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티</title>
<link rel="stylesheet" href="./css/community/community.css" />
</head>
<body>
<c:import url="./header.jsp" />
	<nav id="c_category" class="c_category">
		<ul>
			<li><a href="#">커뮤니티</a></li>
			<li><a href="#">공지사항</a></li>
			<li><a href="./cf">자유게시판</a></li>
			<li><a href="#">유저정보게시판</a></li>
			<li><a href="#">모임게시판</a></li>
		</ul>
	</nav>
<section>
<div class="best">
	<div class="freeboardbest">
	<h1>자유게시판 인기글</h1>
		<ul>
			<li>1</li>
			<li>2</li>
			<li>3</li>
			<li>4</li>
			<li>5</li>
		</ul>
	</div>
	<div class="userboardbest">
	<h1>유저정보게시판 인기글</h1>
		<ul>
			<li>1</li>
			<li>2</li>
			<li>3</li>
			<li>4</li>
			<li>5</li>
		</ul>
	</div>
</div>
<div class="list">
	<h1>전체글 보기</h1>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>날짜</td>
		<tr>
<c:if test="${boardList !=null }">
	<c:forEach items="${boardList }" var="vo" >
		<tr>
			<td>${vo.boardNo }</td>
			<td>${vo.boardTitle }</td>
			<td>${vo.userId }</td>
			<td>${vo.boardWriteDate }</td>			
		</tr> 
	</c:forEach>
</c:if>
<c:if test="${boardList ==null }">
	<tr><td colspan="4">게시글이 없습니다.</td></tr>
</c:if>
		
	</table>
</div>
</section>
<c:import url="footer.jsp" />
</body>
</html>