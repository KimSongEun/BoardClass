<%@page import="kh.semi.boardclass.game.model.vo.Game"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Game vo = (Game) request.getAttribute("gamevolist");
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
	height: 2000px;
	left: 200px;
	top: 240px;
}
#info2-1 {
	position: relative;
	width: 1400px;
	height: 300px;
	left: 50px;
	top: 50px;
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
#tab1{
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
					<td height="50" width="100" style = "font-size: 40px">전체순위</td>
				</tr>
				<tr>
					<td></td>
					<td colspan="3" height="50" style = "font-size: 50px"><%=vo.getGameKoName()%></td>
				</tr>
				<tr>
					<td></td>
					<td colspan="3" height="50" style = "font-size: 40px"><%=vo.getGameEnName()%></td>
				</tr>
				<tr>
					<td height="30"></td>
				</tr>
				<tr>
					<td></td>
					<td width="150" height="30" style = "font-size: 30px">게임 인원</td>
					<td width="150" height="30" style = "font-size: 30px">사용 연령</td>
					<td width="150" height="30" style = "font-size: 30px">플레이 시간</td>
				</tr>
				<tr>
					<td></td>
					<td width="150" height="30" style = "font-size: 30px"><%=vo.getGamePlayer()%></td>
					<td width="150" height="30" style = "font-size: 30px"><%=vo.getGameAge()%></td>
					<td width="150" height="30" style = "font-size: 30px"><%=vo.getGameTime()%></td>

				</tr>
				<tr>
					<td height="30"></td>
				</tr>
				<tr>
					<td></td>
					<td><font size="6"><button
								style="height: 70px; width: 200px; font-size: 25px">> 찜하기</button></font></td>
					<td></td>
					<td><%=vo.getGameGrade()%></td>
				</tr>
			</table>
		</div>

		<div id="ReviewWrite">
			<table id = "tab1">
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

		<div id = "info2">
			<div id = "info2-1">
				
			</div>
			
			<div id = "info2-2">
			
			</div>
		</div>


	
		<br>
	</div>





</body>
</html>