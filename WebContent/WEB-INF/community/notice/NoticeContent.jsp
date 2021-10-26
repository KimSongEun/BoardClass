<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardClass</title>
<link rel="stylesheet" href="css/community/BoardContent.css" />
<link rel="stylesheet" href="css/index/maincss.css" />
</head>
<body>
<%@include file="/WEB-INF/index/header.jsp" %>

<div id="a"></div>
<div id="b"></div>

<div id="guide" class="row">
	<aside id="aside" class="c_category">
			<div class="as_inner">
			<h2 class="as_hgroup"><a href="./cmain">커뮤니티</a></h2>
			<nav id="lnb" class="lnb">
			<ul>
				<li><a href="./nmain">공지사항</a></li>
				<li><a href="./cf">자유게시판</a></li>
				<li><a href="./cu">유저정보게시판</a></li>
				<li><a href="./cg">모임게시판</a></li>
			</ul>
			</nav>
			</div>
	</aside>
<div class="conwrap">
	<div class="h3group">
		<h3 class="tit">커뮤니티</h3>
		<div class="location">
			<span class="depth">홈</span>
			<span class="depth">커뮤니티</span><strong class="this">공지사항</strong>
		</div>
	</div>
	
	<div class="viewbody">
		<div class="hgroup">
			<div class="tit">${notice.adminTitle }</div>
			<div class="util">
				<div class="name">${notice.userId }</div>
				<div class="date">시간: ${notice.adminWrDate }</div>
			</div>
		</div>
		<div class= "content">
		내용 : ${notice.adminContent }
	
		</div>
	
	
	<div class="btn_wrap">
	<!-- 아이디 확인한 후 버튼 생성 가능-->
	
		<a href="nmain">
			<button class="movelist list">목록</button>
		</a>
		
	</div>
</div>
</div>
</div>

<script>
	
</script>
<%@include file="/WEB-INF/index/footer.jsp" %>
</body>
</html>