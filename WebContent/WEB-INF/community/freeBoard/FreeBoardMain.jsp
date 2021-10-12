<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유 게시판</title>
</head>
<%@include file="/WEB-INF/community/header.jsp" %>
<body>
<nav id="c_category" class="c_category">
		<ul>
			<li><a href="#">커뮤니티</a></li>
			<li><a href="#">공지사항</a></li>
			<li><a href="./cf">자유게시판</a></li>
			<li><a href="#">유저정보게시판</a></li>
			<li><a href="#">모임게시판</a></li>
		</ul>
</nav> <!-- TODO 링크 첨부 -->
<section>

</section>
<input type="button" value="새글쓰기" id="btn_write" onclick="location.href ='cfwrite.do'"/>
<!-- <a href="/cfinsert">새글쓰기</a> -->
<%@include file="/WEB-INF/community/footer.jsp" %>
</body>
</html>