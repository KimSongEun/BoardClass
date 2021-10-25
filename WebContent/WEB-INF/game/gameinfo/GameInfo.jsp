<%@page import="kh.semi.boardclass.game.model.vo.Game"%>
<%@page import="kh.semi.boardclass.game.model.vo.GameReview"%>
<%@page import="kh.semi.boardclass.used.model.vo.Used"%>
<%@page import="kh.semi.boardclass.game.model.vo.GameLike"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%
	Game vo = (Game) request.getAttribute("gamevo");
	ArrayList<Used> vo2 = (ArrayList<Used>) request.getAttribute("usedvolist");
	ArrayList<GameReview> go2 = (ArrayList<GameReview>) request.getAttribute("riviewvolist");
	ArrayList<GameReview> go3 = (ArrayList<GameReview>) request.getAttribute("riviewvolist3");
	
	GameReview vo3 = (GameReview) request.getAttribute("reviewvolist");
	
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
	width: 1250px;
	height: 400px;
	left: 300px;
	top: 100px;
}

#info2 {
	position: relative;
	width: 1500px;
	height: 4100px;
	left: 200px;
	top: 340px;
	border: 1px solid black;
}

#info2-1 {
	position: relative;
	width: 1450px;
	height: 350px;
	left: 70px;
	top: 50px;
}

#info2-2 {
	position: relative;
	width: 1450px;
	height: 550px;
	left: 70px;
	top: 150px;
}

.info2-3 {
	position: relative;
	width: 1250px;
	height: 700px;
	left: 70px;
	top: 150px;
}

.info2-4 {
	position: relative;
	width: 1250px;
	height: 500px;
	left: 70px;
	top: 150px;
}

.info2-5 {
	position: relative;
	width: 1250px;
	height: 400px;
	left: 70px;
	top: 150px;
}

#plus {
	display: flex;
	justify-content: space-around;
}

#btnReview {
	position: absolute;
	top: 130px;
	left: 1060px;
}

.rule {
	position: relative;
	left: 70px;
}

.infoP {
	position: relative;
	left: 70px;
	font-size: 45px;
	width: 400px;
}

.infoPP {
	position: relative;
	left: 100px;
	font-size: 30px;
	width: 400px;
	top: 30px;
}

.infoPP2 {
	position: relative;
	left: 100px;
	font-size: 30px;
	width: 400px;
	
}

#infoTable {
	margin: auto;
}

#ReviewWrite {
	position: relative;
	width: 1500px;
	height: 100px;
	left: 200px;
	top: 320px;
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
	backdrop-filter: blur(4px);
	
}

.modal-content {
	width: 710px;
	height: 700px;
	top: 200px;
	margin: auto;
	position: relative;
	background-color: #D9F3F8;
	padding: 10px;
	border-bottom-left-radius: 5px;
	border-bottom-right-radius:5px; 
	border-top-right-radius: 5px;
	border-top-left-radius: 5px;
	border: 5px solid  burlywood;
	}
.modal-content2 {
	width: 800px;
	height: 365px;
	top: 100px;
	margin: auto;
	position: relative;
	background-color: #D9F3F8;
	padding: 10px;
	border-bottom-left-radius: 5px;
	border-bottom-right-radius:5px; 
	border-top-right-radius: 5px;
	border-top-left-radius: 5px;
	border: 5px solid  burlywood;
	border-collapse:collapse;
    border-right:none;
	border-left:none;
}
/* Modal Box content에 내용 크게 키우기 */
.modal-content2 .normal-table td {
	width:500px;
	align-content: center;
	font-size: 2em;
}
#rd .normal-table td {
	width:120px;
	
}


.btn1 {
 	position: relative;
	top: 15px;
	width: 345px;
	height: 100px;
	float:left;
	background-color: #D9E5FF;
}
.close{
 	position: relative;
	top: 15px;
	left: 15px;
	width: 345px;
	height: 100px;
	float:left;
	background-color: #D9E5FF;
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
	font-size: 4.5rem;
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
	background-color: #D9F3F8;
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
	height: 5000px;
}
#rd{
	width: 290px;
	height: 300px;
	position: relative;
	left: 100px;
	float: left;
	top: 30px;
	margin-left: 20px;
	
	
}
.normal-table{
border-collapse:collapse;
    border-right:none;
	border-left:none;
	border: 1px solid burlywood;
	
	
}
.rdbtn{
border-bottom-left-radius: 5px;
	border-bottom-right-radius:5px; 
	border-top-right-radius: 5px;
	border-top-left-radius: 5px;
	border: 1px solid burlywood;
}

.heart{
	width: 100px;
	height: 100px;
	background: url("https://cssanimation.rocks/images/posts/steps/heart.png") no-repeat;
	background-position: 0 0;
	cursor: pointer;
	transition: background-position .6s steps(28);
	transition-duration: 0s;
        }
        .heart.is-active{
	transition-duration: .6s;
	background-position: -2800px 0;
        }
      
</style>
</head>
<body>

	<div id="modal_01" class="modal">
		<div class="modal-content">
			<p style="font-size: 33px; background-color: #D9F3F8"><%=vo.getGameKoName()%></p>
			<form action="GameInsertReview" method="post" style="background-color: #D9F3F8">
				<div class="star-rating space-x-4 mx-auto">
				<input type = "hidden" value = "<%=vo.getGameNumber()%>" name = "no">
				<input type = "hidden" value = "<%=vo.getGameKoName()%>" name = "GAME_KONAME">
					<br> <br> 
					<input type="radio" id="5-stars" name="rating" value="5" v-model="ratings" /> 
						<label for="5-stars" class="star pr-4">★</label> 
						<input type="radio" id="4-stars" name="rating" value="4" v-model="ratings" />
						 <label for="4-stars" class="star">★</label> 
						<input type="radio" id="3-stars" name="rating" value="3" v-model="ratings" />
						 <label for="3-stars" class="star">★</label> 
						<input type="radio" id="2-stars" name="rating" value="2" v-model="ratings" />
						 <label for="2-stars" class="star">★</label> 
						<input type="radio" id="1-star" name="rating" value="1" v-model="ratings" /> 
						<label for="1-star" class="star">★</label>
				</div>
				<textarea rows="25" cols="98" name = "REVIEW_CONTENT" ></textarea>
				<input type="submit" value="등 록" class="btn1" >
			</form>
				<button value="취 소" class = "close" >취 소</button>
		</div>
	</div>
	

<!-- Modal Box -->
<div id="modal_02" class="modal">
<div class="modal-content2">
			
</div>
</div>
	
	
	<%@include file="/WEB-INF/index/header.jsp" %>
		
<div id ="total">
		<div id="info">
			<table>
				<tr>
					<th rowspan="8"><img
						src="<%=request.getContextPath()%>/<%=vo.getGameImage()%>"
						width="500" height="500" /></th>
					<td></td>
				</tr>
				<tr>
					<td width = 250px></td>
					<td colspan="3" height="50px" width="1200px;" style="font-size: 40px"><%=vo.getGameKoName()%></td>
				</tr>
				<tr>
					<td></td>
					<td colspan="3" height="50px" style="font-size: 35px"><%=vo.getGameEnName()%></td>
				</tr>
				<tr>
					<td height="30"></td>
				</tr>
				<tr>
					<td></td>
					<td width="250px" height="30px" align="center"
						style="font-size: 25px">게임 인원</td>
					<td width="150px" height="30px" align="center"
						style="font-size: 25px">사용 연령</td>
					<td width="150px" height="30px" align="center"
						style="font-size: 25px">플레이 시간</td>
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
					<td style = "width: 200px; height: 70px">
					<c:if test="${game.userId != userSession.userId}">
						<div class="placement">								
					      <div class="heart" id="btn_like"></div>				
    					</div>
					</c:if></td>
					<td colspan="2" style = "text-align: center; vertical-align: middle;">
				
					<script>
					$(document).ready(function(){
						if("${likeresult}" == 1){
							$(".heart").toggleClass("is-active");
						}
					});
					
					$("#btn_like").click(cbLike);

					function cbLike(){
						if(!"${userSession}"){
							alert("로그인해주세요");
							return;
						}
						$.ajax({
							type : "post",
							url : "gameLike.ajax",
							data : {
								loginId : "${userSession.userId}",
								thisGameNo : "${gamevo.gameNumber}"
							},
							success : function(receive) {
								console.log("receive값은:"  + receive);
								// 1 : 좋아요 ->x
								// 0 :x-> 좋아요
								if(receive == 1) {
									$(".heart").removeClass("is-active");
								} else {
									$(".heart").addClass("is-active");
								}
								//$(".heart").toggleClass("is-active");
							},
							error : function(request, status, error) {
								alert("code:" + request.status + "\n" + "message:"
										+ request.responseText + "\n" + "error:"
										+ error);
							}
						});
					}
					</script>	
					 
					<% int star = vo.getGameGrade();
					
					if(star<2 && star >0){%>
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
					<td class="tc">이 보드게임에 대한 여러분의 평가를 남겨보세요! >>></td>
					<td width="300" class="tc"></td>

					<td><button id="btnModalShow"
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
						<td width="80px"></td>
						<td width="600px" height="80" style="font-size: 30px">게임 난이도
							: <%=vo.getGameLevel()%></td>
						<td width="600px" height="80" style="font-size: 30px"><%=vo.getGameLanguage()%></td>
					</tr>
					<tr>
						<td></td>
						<td width="600px" height="80" style="font-size: 30px">출시 년도 :
							<%=vo.getGameReleaseDate()%></td>
						<td width="600px" height="80" style="font-size: 30px">제조사 : <%=vo.getGameBrand()%></td>
					</tr>
					<tr>
						<td></td>
						<td width="600px" height="80" style="font-size: 30px">디자이너 :
							<%=vo.getGameDesigner()%></td>
						<td width="600px" height="80" style="font-size: 30px">작가 : <%=vo.getGameWriter()%></td>
					</tr>
				</table>
				<br> <br>
			</div>

			<div id="info2-2">
				<p class="infoP">리뷰</p>
				<p class="infoPP">Hot Review</p>
				<form action="GameReview" method="post">
					<input type = "hidden" value = "<%=vo.getGameNumber()%>" name = "GAME_NO">					
					<button type = "submit" id="btnReview" style="width: 260px; height: 50px; font-size: 25px;">전체글 보기(${reviewcount}) >></button>
				</form>
				<%
					if (go3 != null) {
					for (GameReview go : go3) {
				%>
					<div id="rd">
						<input type = "hidden" value = "<%=go.getReviewNo()%>" name = "REVIEW_NO">
						<input type = "hidden" value = "<%=vo.getGameKoName()%>" name = "GAME_KONAME">
				
						<button type="button" name="re" class="rdbtn" id="c_<%=go.getReviewNo()%>">
						<table border = "1" class="normal-table">
							<tr>
								<td width="120px"><%=go.getUserId()%></td>
								<td width="120px">★   <%=go.getReviewScore()%> </td>								
							</tr>
							<tr>
								<td colspan="2" height="200px"><%=go.getReviewContent()%></td>
							</tr>
							<tr>
								<td>♥ <%=go.getLikecount()%>개</td>
								<td><%=go.getReviewDate()%></td>
							</tr>
							
						</table>
						</button>
				</div>
				<%}} %>

			</div>
			
		<script>
		$("#btnModalShow").click(cbLike1);

		function cbLike1(){
			if(!"${userSession}"){
				alert("로그인해주세요");
				
				return;
			}else 
				$("#btnModalShow").click(function() {
					$("#modal_01").show();
				});
				$(".close").click(function() {
					$(".modal").hide();
				});
		}
			$(".rdbtn").click(function() {
				var html= $(this).html();
				console.log(html);
				$(".modal-content2").html("");
				$(".modal-content2").append(html);
				//html='<br><button value="취 소" class="close">취 소</button>';
				//$(".modal-content2").append(html);
				$("#modal_02").show();
				//$(".c_2").css("display","block");
			});
			
			$(".close").click(function() {
				$(".modal").hide();
			});

			$(window).on("click", function(e) {
				//var modal = document.getElementById("modal_01");
				//if (e.target == modal) {
				$(".modal").each(function () {
					if(e.target == this){
						$(this).hide();
					}	
				});
				
			});

		</script>
			
			<br> <br>
			<div class="info2-3">
				<p class="infoP">게임 이미지</p>
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
				<button class="rule" style = "width: 220px;" onclick="location.href='./usedinformation?no=<%=vo22.getUsedNo()%>'">
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