<%@page import="kh.semi.boardclass.game.model.vo.Game"%>
<%@page import="kh.semi.boardclass.used.model.vo.Used"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Game vo = (Game) request.getAttribute("gamevolist");
	ArrayList<Used> vo2 = (ArrayList<Used>) request.getAttribute("usedvolist");
	String[] str2 = (String[]) request.getAttribute("str2");
	String[] str4 = (String[]) request.getAttribute("str4");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/index/maincss.css"/>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>보드 리스트</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
	height: 4450px;
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



.modal {
	display: none;
	width: 100%;
	height: 100%;
	position: fixed;
	z-index: 1;
	background-color: rgba(12, 12, 12, .3);
}

.modal-content {
	width: 700px;
	height: 680px;
	top: 50px;
	margin: auto;
	position: relative;
	background-color: #e9ecef;
	padding: 10px;
}

.btn1 {
	position: relative;
	top: 5px;
	width: 336px;
	height: 100px;
}
#close{
	position: relative;
	top: 5px;
	width: 336px;
	height: 100px;
	left:340px;
	top:-95px;
}
.star-rating {
	display: flex;
	flex-direction: row-reverse;
	font-size: 2.25rem;
	line-height: 2.5rem;
	justify-content: space-around;
	padding: 0 0.2em;
	text-align: center;
	width: 5em;
	
}

.star-rating1 {
	display: flex;
	flex-direction: row-reverse;
	font-size: 3rem;
	line-height: 2.5rem;
	justify-content: space-around;
	padding: 0 0.2em;
	text-align: center;
	width: 5em;
vertical-align: middle;	
}


.star-rating input {
	display: none;
}

.star-rating label {
	-webkit-text-fill-color: transparent;
	
	-webkit-text-stroke-width: 2.3px;
	-webkit-text-stroke-color: #2b2a29;
	cursor: pointer;
	background-color: #e9ecef;
}

.star-rating :checked ~ label {
	-webkit-text-fill-color: gold;
}

.star-rating label:hover, .star-rating label:hover ~ label {
	-webkit-text-fill-color: #fff58c;
}
#total{
	position: relative;
	width: 2000px;
	height: 5200px;
}
</style>
</head>
<body>

	<div id="modal_01" class="modal">
		<div class="modal-content">
			
			<p style="font-size: 50px; background-color: #e9ecef"><%=vo.getGameKoName()%></p>
			<form action="#" method="get" style="background-color: #e9ecef">
				<div class="star-rating space-x-4 mx-auto">
					<br> <br> <input type="radio" id="5-stars" name="rating"
						value="5" v-model="ratings" /> <label for="5-stars"
						class="star pr-4">★</label> <input type="radio" id="4-stars"
						name="rating" value="4" v-model="ratings" /> <label for="4-stars"
						class="star">★</label> <input type="radio" id="3-stars"
						name="rating" value="3" v-model="ratings" /> <label for="3-stars"
						class="star">★</label> <input type="radio" id="2-stars"
						name="rating" value="2" v-model="ratings" /> <label for="2-stars"
						class="star">★</label> <input type="radio" id="1-star"
						name="rating" value="1" v-model="ratings" /> <label for="1-star"
						class="star">★</label>
				</div>
				<textarea rows="25" cols="98"></textarea>
				<input type="submit" value="등 록" class="btn1">
			</form>
				<button value="취 소" id = "close" >취 소</button>
		</div>
	</div>
	
	<%@include file="/WEB-INF/index/header.jsp" %>
		
<div id ="total">
		<div id="info">
			<table>
				<tr>
					<th rowspan="8"><img
						src="<%=request.getContextPath()%>/<%=vo.getGameImage()%>"
						width="400" height="400" /></th>
					<td>&emsp;&emsp; &emsp;&emsp; &emsp;&emsp;</td>
					<td colspan="3" height="50px" width="600px" style="font-size: 40px">전체순위</td>
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
					<td style = "width: 200px; height: 70px"><button
							style="height: 70px; width: 170px; font-size: 25px">>
							찜하기</button></td>
					
					<td colspan="2">
						
					<br> <br>  
					<% int star = vo.getGameGrade();
					System.out.println(star);
					if(star<2 && star >=0){%>
					<div class="star-rating1 space-x-4 mx-auto">
					<label for="5-stars" class="star pr-4">★</label>  
						<label for="4-stars" class="star">★</label>  
						<label for="3-stars" class="star">★</label> 
						<label for="2-stars"class="star">★</label> 
						 <label for="1-star" class="star" style = "color: gold">★</label>
				</div>
				<%}else if(star>=2 && star <3){ %>
				<div class="star-rating1 space-x-4 mx-auto">
					<label for="5-stars" class="star pr-4">★</label>  
						<label for="4-stars" class="star">★</label>  
						<label for="3-stars" class="star">★</label> 
						<label for="2-stars"class="star"style = "color: gold">★</label> 
						 <label for="1-star" class="star" style = "color: gold">★</label>
				</div>
				<%}else if(star>=3 && star <4){ %>
				<div class="star-rating1 space-x-4 mx-auto">
				<label for="5-stars" class="star pr-4" >★</label>  
						<label for="4-stars" class="star">★</label>  
						<label for="3-stars" class="star" style = "color: gold">★</label> 
						<label for="2-stars"class="star" style = "color: gold" >★</label> 
						 <label for="1-star" class="star" style = "color: gold">★</label>
				</div>
				<%}else if(star>=4 && star <5){ %>
				<div class="star-rating1 space-x-4 mx-auto">
				<label for="5-stars" class="star pr-4" >★</label>  
						<label for="4-stars" class="star" style = "color: gold">★</label>  
						<label for="3-stars" class="star" style = "color: gold">★</label> 
						<label for="2-stars"class="star" style = "color: gold" >★</label> 
						 <label for="1-star" class="star" style = "color: gold ">★</label>
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
					</td>

				</tr>
			</table>
		</div>



		<div id="ReviewWrite">
			<table id="tab1">
				<tr>
					<td width="50" class="tc"></td>
					<td class="tc">이 보드게임에 대한 @@님의 평가를 남겨보세요! >>></td>
					<td width="300" class="tc"></td>

					<td><button id="btnModalShow"
							style="height: 70px; width: 200px; background-color: #E2E2E2; font-size: 25px">
							평가 남기기</button></td>

				</tr>
			</table>

		</div>


		<script>
			$("#btnModalShow").click(function() {
				$(".modal").show();
			});
			$("#close").click(function() {
				$(".modal").hide();
			});

			$(window).on("click", function(e) {
				var modal = document.getElementById("modal_01");
				if (e.target == modal) {
					$(".modal").hide();
				}
			});
		</script>


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
				<div class="rule">
					<%=vo.getGameVideo()%>
				</div>
			</div>
			<br> <br> <br> <br>

			<div class="info2-4">
				<p class="infoP">중고 거래 정보</p>
				<br> <br>

				<%
					if (vo2 != null) {
						for (Used vo22 : vo2) {
				%>
				<button class="rule">
					<img src="<%=request.getContextPath()%>/<%=vo22.getUsedImg()%>"
						width="250" height="250" />
					<div id="plus">
						<%=vo22.getUsedTitle()%>
					</div>
				</button>
				<%
					}
					} else {
				%>
				<div class="rule">
					<p style="font-size: 30px">중고 물품이 없습니다.</p>
				</div>
				<%
					}
				%>
			</div>
			<br> <br> <br> <br>

			<div class="info2-5">
				<p class="infoP">확장판</p>
				<br> <br>
				<%
					int n = 0;
					String a = Integer.toString(n);
				%>
				<%
					if (!str2[0].equals(a)) {
						for (int i = 0; i < str2.length; i++) {
				%>
				<button class="rule"
					onclick="location.href='./GameInfo?GAME_KONAME=<%=str4[i]%>'">
					<img src="<%=request.getContextPath()%>/<%=str2[i]%>" width="250"
						height="250" />
					<div id="plus">
						<%=str4[i]%>
					</div>
				</button>
				<%
					}
					} else {
				%>
				<div class="rule">
					<p style="font-size: 30px">확장판이 없습니다.</p>
				</div>
				<%
					}
				%>
			</div>
			<br> <br> <br> <br>

		</div>
</div>
		
		
<%@include file="/WEB-INF/index/footer.jsp" %>
</body>
</html>