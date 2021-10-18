<%@page import="kh.semi.boardclass.game.model.vo.Game"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Game vo = (Game) request.getAttribute("gamevolist");
	String[] str2 = (String[]) request.getAttribute("str2");
	String[] str4 = (String[]) request.getAttribute("str4");

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

.hrr {
	position: relative;
	top: 50px;
	width: 80%;
	align: right;
}

#info {
	position: relative;
	width: 1500px;
	height: 400px;
	left: 200px;
	top: 100px;
}

#info2 {
	position: relative;
	width: 1500px;
	height: 4150px;
	left: 200px;
	top: 240px;
	border: 1px solid black;
}

#info2-1 {
	position: relative;
	width: 1400px;
	height: 350px;
	left: 50px;
	top: 50px;
}

#info2-2 {
	position: relative;
	width: 1400px;
	height: 1000px;
	left: 50px;
	top: 150px;
}

.info2-3 {
	position: relative;
	width: 1200px;
	height: 700px;
	left: 50px;
	top: 150px;
}

.info2-4 {
	position: relative;
	width: 1200px;
	height: 500px;
	left: 50px;
	top: 150px;
}

.info2-5 {
	position: relative;
	width: 1200px;
	height: 400px;
	left: 50px;
	top: 150px;
}

#plus {
	display: flex;
	justify-content: space-around;
}

#btnReview {
	position: relative;
	top: -10px;
	left: 1100px;
}

.rule {
	position: relative;
	left: 100px;
}

.infoP {
	position: relative;
	left: 50px;
	font-size: 45px;
	width: 400px;
}

.infoPP {
	position: relative;
	left: 50px;
	font-size: 30px;
	width: 400px;
	top: 30px;
}

.infoPP2 {
	position: relative;
	left: 50px;
	font-size: 30px;
	width: 400px;
	top: 400px;
}

#infoTable {
	margin: auto;
}

#ReviewWrite {
	position: relative;
	width: 1500px;
	height: 100px;
	left: 200px;
	top: 180px;
	background-color: #D9E5FF;
	display: flex;
	justify-content: center;
	align-items: center;
}

#tab1 {
	border-collapse: collapse;
	border-color: #D9E5FF;
}

.tc {
	background-color: #D9E5FF;
	font-size: 25px;
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

		<div id="info">
			<table>
				<tr>
					<th rowspan="8"><img
						src="<%=request.getContextPath()%>/<%=vo.getGameImage()%>"
						width="400" height="400" /></th>
					<td>&emsp;&emsp; &emsp;&emsp; &emsp;&emsp;</td>
					<td colspan="3" height="50px" width="540px" style="font-size: 40px">전체순위</td>
				</tr>
				<tr>
					<td></td>
					<td colspan="3" height="50px" style="font-size: 50px"><%=vo.getGameKoName()%></td>
				</tr>
				<tr>
					<td></td>
					<td colspan="3" height="50px" style="font-size: 40px"><%=vo.getGameEnName()%></td>
				</tr>
				<tr>
					<td height="30"></td>
				</tr>
				<tr>
					<td></td>
					<td width="170px" height="30px" align="center"
						style="font-size: 30px">게임 인원</td>
					<td width="170px" height="30px" align="center"
						style="font-size: 30px">사용 연령</td>
					<td width="170px" height="30px" align="center"
						style="font-size: 30px">플레이 시간</td>
				</tr>
				<tr>
					<td></td>
					<td width="170px" height="30px" align="center"
						style="font-size: 30px"><%=vo.getGamePlayer()%></td>
					<td width="170px" height="30px" align="center"
						style="font-size: 30px"><%=vo.getGameAge()%></td>
					<td width="170px" height="30px" align="center"
						style="font-size: 30px"><%=vo.getGameTime()%></td>

				</tr>
				<tr>
					<td height="30"></td>
				</tr>
				<tr>
					<td></td>
					<td><button
							style="height: 70px; width: 170px; font-size: 25px">>
							찜하기</button></td>
					<td></td>
					<td colspan="2"><%=vo.getGameGrade()%></td>
				</tr>
			</table>
		</div>

		<div id="ReviewWrite">
			<table id="tab1">
				<tr>
					<td width="50" class="tc"></td>
					<td class="tc">이 보드게임에 대한 @@님의 평가를 남겨보세요! >>></td>
					<td width="300" class="tc"></td>
					<td><button
							style="height: 70px; width: 200px; background-color: #E2E2E2; font-size: 25px">
							평가 남기기</button></td>
				</tr>
			</table>
		</div>

		<div id="info2">
			<div id="info2-1">
				<p class="infoP">게임 정보</p>
				<br> <br>
				<table id="infoTable">
					<tr>
						<td width="100px"></td>
						<td width="500px" height="80" style="font-size: 30px">게임 난이도
							: <%=vo.getGameLevel()%></td>
						<td width="600px" height="80" style="font-size: 30px"><%=vo.getGameLanguage()%></td>
					</tr>
					<tr>
						<td></td>
						<td width="500px" height="80" style="font-size: 30px">출시 년도 :
							<%=vo.getGameReleaseDate()%></td>
						<td width="600px" height="80" style="font-size: 30px">제조사 : <%=vo.getGameBrand()%></td>
					</tr>
					<tr>
						<td></td>
						<td width="500px" height="80" style="font-size: 30px">디자이너 :
							<%=vo.getGameDesigner()%></td>
						<td width="600px" height="80" style="font-size: 30px">작가 : <%=vo.getGameWriter()%></td>
					</tr>
				</table>
				<br> <br>
			</div>

			<div id="info2-2">
				<p class="infoP">코멘트</p>
				<p class="infoPP">Hot Review</p>
				<button id="btnReview"
					style="width: 200px; height: 50px; font-size: 25px;">전체 보기
					>></button>

				<p class="infoPP2">Recent Review</p>
			</div>
			<br> <br>
			<div class="info2-3">
				<p class="infoP">게임 규칙</p>
				<br> <br> <img class="rule"
					src="<%=request.getContextPath()%>/<%=vo.getGameRuleImage()%>"
					width="1200" height="600" />
			</div>
			<br> <br> <br> <br>

			<div class="info2-3">
				<p class="infoP">HOW TO PLAY</p>
				<br> <br>

				<iframe class="rule" width="1200" height="600"
					src="<%=vo.getGameVideo()%>" title="YouTube video player"
					frameborder="0"
					allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
					allowfullscreen></iframe>

			</div>
			<br> <br> <br> <br>

			<div class="info2-4">
				<p class="infoP">중고 거래 정보</p>


			</div>
			<br> <br> <br> <br>

			<div class="info2-5">
				<p class="infoP">확장판</p>
				<br> <br>
				<% int n = 0;
					String a = Integer.toString(n);
					%>
				<% if(!str2[0].equals(a)){ 
				 for(int i = 0; i<str2.length; i++){ %>
				<button class="rule">
					<img src="<%=request.getContextPath()%>/<%=str2[i]%>"
						width="250" height="250" />
					<div id="plus">
						<%=str4[i]%>
					</div>
				</button>
				<%}} else{%>
					<p>확장판이 없습니다<p>
				<%} %>
			</div>
			<br> <br> <br> <br>

		</div>



		<br>
</body>
</html>