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
	top: 700px;
	left: 700px;
	font-size: 40px;
}

#nav2 {
	position: relative;
	
	left: 30px;
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
	top : -150px;
}

#board_info {
	position: relative;
	top: -310px;
	float: left;
	margin: 35px;
}

#d1 {
	position: relative;
	text-align: center;
	line-height: 200px;
	background-color: burlywood;
	width: 1430px;
	height: 180px;
	font-size: 50px;
	top : -320px;
}

#search {
	position: relative;
	left: 400px;
	font-size: 40px;
	top : -270px;
}

#text_name {
	position: relative;
	top: -6px;
	width: 250px;
	height: 40px;
	font-size: 15px;
}

#search_btn {
	position: relative;
	top: -7px;
	width: 100px;
	height: 40px;
}
#sort {
	position: relative;
	left: 1150px;
	width: 250px;
	height: 50px;
	top: -320px;
}
#total{
	position: relative;
	width: 1550px;
	height: 1200px;
}
.btn1{
	height: 275px;
	width: 215px;
	border: 1px solid burlywood;
	border-bottom-left-radius: 5px;
	border-bottom-right-radius:5px; 
	border-top-right-radius: 5px;
	border-top-left-radius: 5px;
}
#result{
	position: relative;
	left: 1250px;
	width: 150px;
	
	top: -450px;
}

</style>
</head>
<body>

	<%@include file="/WEB-INF/index/header.jsp" %>
	<div id="total">
		
		<nav id="nav2">

			<p>한글</p>
			<br>
			<ul class="ulist">
				<li><a href="GameAllList">전체</a></li>
				<li><a href="GameStrategyList">전략</a></li>
				<li><a href="GameTemaList">테마</a></li>
				<li><a href="GameFamilyList">가족</a></li>
				<li><a href="GamePartyList">파티</a></li>
				<li><a href="GameKoreanList">한글</a></li>

			</ul>

		</nav>

		<aside></aside>

		<section id="section2">
			<div id="d1">한글</div>
<div id='result'> 
			<p style = "font-size: 25px;">${ASort}</p>
			</div>
			<div id="search">
				<form action="GameKoreaList" method="post">
				게임이름 <input type="search" id="text_name" name="search">
				<button type="submit" id="search_btn" >검색</button>
				</form>
			</div>

			<form action="GameKoreanList"   name="sort" method="post">
			<select id="sort" name="sort" onchange="this.form.submit()" >
				<option value="none">=== 정렬 선택 ===</option>
				<option value="GameLevelList">난이도 순</option>
				<option value="GameGradeList">평점 순</option>
				<option value="GameGradeDescList">평점 낮은순</option>
				<option value="GameSortList">가나다 순</option>
			</select> </form><br>
			<%
				if (volist != null) {
					for (Game vo : volist) {
						// tr 이 volist 갯수 만큼 생기게 됨.
						// <%= 은 화면에 출력을 위한 표현식을 작성하는 태그, ;없어야 함.
			%>
				<form name = "fom" method="get" action="GameInfo">
 				<div id="board_info">
					<input type = "hidden" value = "<%=vo.getGameKoName()%>"  name="GAME_KONAME">
				<input type = "hidden" value = "<%=vo.getGameNumber()%>"  name="GAME_NO">
					
					<button type="submit"    class="btn1" >
						<img src="<%=request.getContextPath()%>/<%=vo.getGameImage()%>"
							width="200" height="200" />
						<div class="img-text">
							<%=vo.getGameKoName()%>
												<% int star = vo.getGameGrade();
					
					if(star<2 && star >0){%>
					<div class="star-rating1 space-x-4 mx-auto">
					<label for="1-star" class="star" style = "color: gold">★</label>
					<label for="5-stars" class="star pr-4">★</label>  
						<label for="4-stars" class="star">★</label>  
						<label for="3-stars" class="star">★</label> 
						<label for="2-stars"class="star">★</label> 
						 
				</div>
				<%}else if(star>=2 && star <3){ %>
				<div class="star-rating1 space-x-4 mx-auto">
						<label for="2-stars"class="star"style = "color: gold">★</label> 
						 <label for="1-star" class="star" style = "color: gold">★</label>
					<label for="5-stars" class="star pr-4">★</label>  
						<label for="4-stars" class="star">★</label>  
						<label for="3-stars" class="star">★</label> 
					
				</div>
				<%}else if(star>=3 && star <4){ %>
				<div class="star-rating1 space-x-4 mx-auto">
				<label for="3-stars" class="star" style = "color: gold">★</label> 
						<label for="2-stars"class="star" style = "color: gold" >★</label> 
						 <label for="1-star" class="star" style = "color: gold">★</label>
				<label for="5-stars" class="star pr-4" >★</label>  
						<label for="4-stars" class="star">★</label>  
						
				</div>
				<%}else if(star>=4 && star <5){ %>
				<div class="star-rating1 space-x-4 mx-auto">
				<label for="4-stars" class="star" style = "color: gold">★</label>  
						<label for="3-stars" class="star" style = "color: gold">★</label> 
						<label for="2-stars"class="star" style = "color: gold" >★</label> 
						 <label for="1-star" class="star" style = "color: gold ">★</label>
				<label for="5-stars" class="star pr-4" >★</label>  
						
				</div>
				<%}else if(star == 5){ %>
				<div class="star-rating1 space-x-4 mx-auto">
				<label for="5-stars" class="star pr-4" style = "color: gold">★</label>  
						<label for="4-stars" class="star" style = "color: gold">★</label>  
						<label for="3-stars" class="star" style = "color: gold">★</label> 
						<label for="2-stars"class="star" style = "color: gold">★</label> 
						 <label for="1-star" class="star" style = "color: gold" >★</label>
				</div>
				<%}else if(star == 0){ %>
					<div class="star-rating1 space-x-4 mx-auto">
					<label for="5-stars" class="star pr-4" >★</label>  
						<label for="4-stars" class="star" >★</label>  
						<label for="3-stars" class="star" >★</label> 
						<label for="2-stars"class="star" >★</label> 
						 <label for="1-star" class="star" >★</label>
				</div>
				
				<%} %>
				<%=vo.getGameGrade()%>	
						</div>
					</button>
				</div>
			</form>
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
				<a href="./GameKoreanList?pagenum=<%=i%>"> <%=i%></a>
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

	</div>



<%@include file="/WEB-INF/index/footer.jsp" %>



</body>
</html>