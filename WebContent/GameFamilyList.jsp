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
<title>���� ����Ʈ</title>
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
					<a href="#">�α���</a> | <a href="#">ȸ������</a>
				</nav>
			</div>
			<div class="logo">
				<a href="#"><img src="./img/logo.png" alt=""></a>
			</div>
			<hr id="hrdash">
			<br>
			<div class="nav">
				<nav class="navcategory">
					<a href="#">ī�װ�</a> | <a href="#">���ӷ�ŷ</a> | <a href="#">�߰�ŷ�</a>
					| <a href="#">�Խ���</a> | <a href="#">�����������</a>
				</nav>
			</div>
			<br>
			<hr id="hrsolid">
		</header>
		<nav id="nav2">

			<p>������</p>
			<br>
			<ul class="ulist">
				<li><a href="#">��ü</a></li>
				<li><a href="GameStrategyList">����</a></li>
				<li><a href="GameTemaList">�׸�</a></li>
				<li><a href="GameFamilyList">����</a></li>
				<li><a href="GamePartyList">��Ƽ</a></li>
				<li><a href="GameKoreanList">�ѱ�</a></li>

			</ul>

		</nav>

		<aside></aside>

		<section id="section2">
			<div id="d1">������</div>

			<div id="search">
				�����̸� <input type="text" id="text_name">
				<button type="button" id="search_btn" onclick="#">�˻�</button>
			</div>

			<select id="sort" onchange="window.open(value,'_self');">
				<option value="GameGradeList">���� ��</option>
				<option value="GameGradeDescList">���� ������</option>
				<option value="GameLevelList">���̵� ��</option>
				<option value="GameSortList">������ ��</option>
			</select> <br>
			<%
				if (volist != null) {
					for (Game vo : volist) {
						// tr �� volist ���� ��ŭ ����� ��.
						// <%= �� ȭ�鿡 ����� ���� ǥ������ �ۼ��ϴ� �±�, ;����� ��.
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
				����
				<%
					}
					for (int i = startPage; i <= endPage; i++) {
				%>
				<a href="./GameStrategyList?pagenum=<%=i%>"> <%=i%></a>
				<%
					if (i != endPage) {
				%>
				,
				<%
					}
					}
					if (endPage < pageCount) {
				%>
				����
				<%
					}
				%>
			</div>


		</section>





		<footer>
			<div class="footer">
				<hr>
				<br> <span id="f_s">Copyright �� 2021 <b id="f_b">�������
						Ŀ�´�Ƽ ����Ŭ����</b> All rights reserved.
				</span> | <a href="#"><b>���� ���/��å</b></a> | <a href="#"><b>����������޹�ħ</b></a>
				| <a href="#">��������</a> | <a href="#">������</a>
			</div>
		</footer>
		<br>
	</div>





</body>
</html>