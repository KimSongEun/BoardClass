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
<link rel="stylesheet" href="./css/index/maincss.css"/>
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
	top: 1480px;
	left: 890px;
	font-size: 40px;
}
#nav2 {
	position: relative;
	left: 30px;
	top: 70px;
	font-size: 45px;
}
.ulist {
	position:relative;
	top:-100px;
	list-style: none;
	font-size: 30px;
}
#section2 {
	position: relative;
	width: 1450px;
	height: 1000px;
	left: 300px;
	
}
#board_info {
	position: relative;
	top: -280px; 
	float: left;
	margin: 30px;
}
#d2{
	position: relative;
	
	top: -15px;
	width: 900px;
	height: 100px;
	font-size: 50px;
}
#d1 {
	position: relative;
	text-align: center;
	left: 240px;
	width: 900px;
	height: 100px;
	font-size: 50px;
}
#search {
	position: relative;
	top : -270px;
	
	font-size: 40px;
	
    
}
#hrline{
position: relative;
top: -410px;
width: 95%;
border: 1px solid grey;
}
#text_name {
	position: relative;
	top: -6px;
	width: 250px;
	height: 40px;
	font-size: 20px;
}

#sort {
	position: relative;
	left: 1120px;
	top: -330px;
	width: 250px;
	height: 50px;
}
#total{
	position: relative;
	width: 1300px;
	height: 1250px;
}
.btn1{
	height: 300px;
	width: 220px;
	border: 1px solid burlywood;
	border-bottom-left-radius: 5px;
	border-bottom-right-radius:5px; 
	border-top-right-radius: 5px;
	border-top-left-radius: 5px;
}
#result{
	position: relative;
	width: 200x;
	font-size: 20px;
	top: 70px;
}


.div_paging_before{
	display: flex;
	justify-content: center;
	padding-top: 30px;
	padding-bottom: 30px;
}

.div_paging {
	padding-bottom: 20px;
}

.pageprevious {
	background-color: black;
	color: white;
	text-decoration: none;
	padding: 5px 13px;
}

.pagecurrent {
	color: black;
	text-decoration: none;
	padding: 5px 13px;
}

.pagecurrent:hover {
	background-color: #ddd;
}

.pagenext {
	background-color: black;
	color: white;
	text-decoration: none;
	padding: 5px 13px;
}


</style>
</head>
<body>
	<%@include file="/WEB-INF/index/header.jsp" %>
	<div id="total">
		
		<nav id="nav2">
	<form action="GameGradeRank"  name="sort" method="post">
			<select id="sort1" name="sort1"  >
				<option value="" hidden>=== 대상 연령 ===</option>
				<option value="8세">8세 이상</option>
				<option value="12세">12세 이상</option>
				<option value="13세">13세 이상</option>
				<option value="14세">14세 이상</option>
			</select> <br>
			<select id="sort2" name="sort2"  >
				<option value="" hidden>=== 게임 인원 ===</option>
				<option value="2명">2명 정도</option>
				<option value="4명">4명 정도</option>
				<option value="5명">5명 정도</option>
				<option value="10명">10명 정도</option>
				<option value="12명">12명 정도</option>
			</select> <br>
			<select id="sort3" name="sort3"  >
				<option value="" hidden>=== 게임 시간 ===</option>
				<option value="30">30분</option>
				<option value="60">60분</option>
				<option value="90">90분</option>
				<option value="120">120분</option>
			</select> <br>
			<select id="sort4" name="sort4"  >
				<option value="" hidden>=== 게임 장르 ===</option>
				<option value="전략">전략</option>
				<option value="테마">테마</option>
				<option value="가족">가족</option>
				<option value="파티">파티</option>
				<option value="한글">한글</option>
			</select> <br>
			<input type = "submit" value = "검색" style = "width: 80px; height: 30px;">
		</form>
		<div id ="result">${Sort}</div>
		</nav>

		<aside></aside>

		<section id="section2">
	<div id="search">
				<div id="d2">게임 순위</div>
				<div id="d1">찜 상품 순</div>
				
				
			</div>
			
		<hr id="hrline">	
			<select id="sort" onchange="window.open(value,'_self');">
				<option value="GameJjimRank">찜 상품 순</option>
				<option value="GameGradeRank" >평점 순</option>
				<option value="GameViewRank" >조회수 순</option>
				
				
				
			</select> <br>
			<%
				if (volist != null) {
					for (Game vo : volist) {
						// tr 이 volist 갯수 만큼 생기게 됨.
						// <%= 은 화면에 출력을 위한 표현식을 작성하는 태그, ;없어야 함.
			%>
			<form name = "fom" method="get" action="GameInfo">
			<div id="board_info">
			
				<input type = "hidden" value = "<%=vo.getGameKoName()%>"  name="GAME_KONAME">
					<h2><%=vo.getR()%>등</h2>		
				<button type="submit"    class="btn1" >
						<img src="<%=request.getContextPath()%>/<%=vo.getGameImage()%>"
						width="200" height="200"/>
					<div class="img-text">
						<%=vo.getGameKoName()%><br>
						게임 인원 : <%=vo.getGameLevel()%>명<br>
						게임 연령 : <%=vo.getGameAge()%><br>
						게임 시간 : <%=vo.getGameTime()%>분
						
					</div>
				</button>
			</div>
			</form>
			<%
				}
				}
			%>

		</section>

	</div>
	<div class="div_paging_before">
			<div id="page" class="div_paging">
				<%
					if (startPage > 1) {
				%>
				<a href="GameJjimRank?pagenum=${startPage-1}" class="pageprevious">&laquo;</a>
				<%
					} else {
				%>
				<a href="GameJjimRank?pagenum=1" class="pageprevious">&laquo;</a>
				<%	}
					for (int i = startPage; i <= endPage; i++) {
				%>
				<a href="GameJjimRank?pagenum=<%=i%>" class="pagecurrent"> <%=i%></a>
				<%
					}
					if (endPage < pageCount) {
				%>
				<a href="GameJjimRank?pagenum=${endPage+1}" class="pagenext">&raquo;</a>
				<%
					} else {
				%>
				<a href="GameJjimRank?pagenum=${pageCount}" class="pagenext">&raquo;</a>
				<% } %>
			</div>
		</div>



<%@include file="/WEB-INF/index/footer.jsp" %>



</body>
</html>