<%@page import="kh.semi.boardclass.game.model.vo.Game"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Game> volist = (ArrayList<Game>) request.getAttribute("gamevolist");
	int startPage = (int) request.getAttribute("startPage");
	int endPage = (int) request.getAttribute("endPage");
	int pageCount = (int) request.getAttribute("pageCount");
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

#nav2 {
	position: relative;
	top: 100px;
	left: 30px;
	font-size: 45px;
}

.ulist {
	list-style: none;
	font-size: 30px;
}

#section2 {
	position: relative;
	width: 1800px;
	height: 400px;
	left: 300px;
}

#board_info {
	position: relative;
	top: -280px;
	float: left;
	margin: 30px;
}

#d1 {
	position: relative;
	top: -280px;
	text-align: center;
	line-height: 200px;
	background-color: burlywood;
	width: 1570px;
	height: 180px;
	font-size: 50px;
}

#search {
	position: relative;
	left: 500px;
	top: -240px;
	font-size: 40px;
}

#text_name {
	position: relative;
	top: -6px;
	width: 250px;
	height: 40px;
	font-size: 20px;
}

#search_btn {
	position: relative;
	top: -7px;
	width: 100px;
	height: 40px;
}

#sort {
	position: relative;
	left: 1340px;
	top: -290px;
	width: 200px;
	height: 40px;
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
					<a href="#">카테고리</a> | <a href="#">게임랭킹</a> | <a href="#">중고거래</a>
					| <a href="#">게시판</a> | <a href="#">보드게임정보</a>
				</nav>
			</div>
			<br>
			<hr id="hrsolid">
		</header>
		<nav id="nav2">

			<p>ㅇㅇㅇ</p>
			<br>
			<ul class="ulist">
				<li><a href="#">전체</a></li>
				<li><a href="GameStrategyList">전략</a></li>
				<li><a href="GameTemaList">테마</a></li>
				<li><a href="GameFamilyList">가족</a></li>
				<li><a href="GamePartyList">파티</a></li>
				<li><a href="GameKoreanList">한글</a></li>

			</ul>

		</nav>

		<aside></aside>

		<section id="section2">
			<div id="d1">ㅇㅇㅇ</div>

			<div id="search">
				게임이름 <input type="text" id="text_name">
				<button type="button" id="search_btn" onclick="#">검색</button>
			</div>

			<select id="sort" onchange="window.open(value,'_self');">
				<option value="GameGradeList">평점 순</option>
				<option value="GameGradeDescList">평점 낮은순</option>
				<option value="GameLevelList">난이도 순</option>
				<option value="GameSortList">가나다 순</option>
			</select> <br>
			<%
				if (volist != null) {
					for (Game vo : volist) {
						// tr 이 volist 갯수 만큼 생기게 됨.
						// <%= 은 화면에 출력을 위한 표현식을 작성하는 태그, ;없어야 함.
			%>
			<div id="board_info">
				<button type="button" class="btn1" onclick="#">
					<img src="<%=request.getContextPath()%>/<%=vo.getGameImage()%>"
						width="250" height="250" />
					<div class="img-text">
						<%=vo.getGameKoName()%>
						<%=vo.getGameLevel()%>
					</div>
				</button>

			</div>
			<%
				}
				}
			%>

			<div id="page">
				<%
					if (startPage > 1) {
				%>
				이전
				<%
					}
					for (int i = startPage; i <= endPage; i++) {
				%>
				<a href="./GameTemaList?pagenum=<%=i%>"> <%=i%></a>
				<%
					if (i != endPage) {
				%>
				,
				<%
					}
					}
					if (endPage < pageCount) {
				%>
				다음
				<%
					}
				%>
			</div>


		</section>





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