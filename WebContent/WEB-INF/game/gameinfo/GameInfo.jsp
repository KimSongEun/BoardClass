<%@page import="kh.semi.boardclass.game.model.vo.Game"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Game> volist = (ArrayList<Game>) request.getAttribute("gamevolist");	
	
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/index.css">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>보드 리스트</title>
<style>
@font-face {
	font-family: 'ImcreSoojin';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-04@2.3/ImcreSoojin.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

@MEDIA {
}

#page {
	position: absolute;
	top: 680px;
	left: 750px;
	font-size: 40px;
}

.footer {
	width: 78%;
	top: 1400px;
	height: 100px;
	position: absolute;
}
</style>
</head>
<body>
	<div class="total">
		<header>
			<div class="nav">
				<nav class="navlogin">
					<a href="#">로그인</a> | <a href="#">회원가입</a>
				</nav>
			</div>
			<div class="logo">
				<a href="#"><img src="./img/logo.png" alt=""></a>
			</div>
			<hr id="hrdash">
			<br>
			<div class="nav">
				<nav class="navcategory">
					<a href="#">카테고리</a> | <a href="GameGradeRank">게임랭킹</a> | <a
						href="#">중고거래</a> | <a href="#">게시판</a> | <a href="GameLevelList">보드게임정보</a>
				</nav>
			</div>
			<br>
			<hr id="hrsolid">
		</header>

		<div id="bg">
			<%
			
				if (volist != null) {
					for (Game vo : volist) {
						// <%= 은 화면에 출력을 위한 표현식을 작성하는 태그, ;없어야 함.
			%>
			<img src="<%=request.getContextPath() %>/<%=vo.getGameImage()%>"
				width="250" height="250" />
				
				<%=vo.getGameKoName()%>
				<%=vo.getGameEnName()%>
				<%=vo.getGamePlayer()%>
				<%=vo.getGameAge()%>
				<%=vo.getGameTime()%>
				<%=vo.getGameGrade()%>
			
			<%
				}
				}
			%>

		</div>

	



		<footer>
			<div class="footer">
				<hr>
				<br> <span id="f_s">Copyright ⓒ 2021 <b id="f_b">보드게임
						커뮤니티 보드클래스</b> All rights reserved.
				</span> | <a href="#"><b>서비스 약관/정책</b></a> | <a href="#"><b>개인정보취급방침</b></a>
				| <a href="#">공지사항</a> | <a href="#">고객센터</a>
			</div>
		</footer>
		<br>
	</div>





</body>
</html>