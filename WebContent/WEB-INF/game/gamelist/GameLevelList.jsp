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
	top: 830px;
	left: 900px;
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
	width: 2100px;
	height: 400px;
	left: 300px;
	top : -150px;
}

#board_info {
	position: relative;
	top: -280px;
	float: left;
	margin: 30px;
}

#d1 {
	position: relative;
	text-align: center;
	line-height: 200px;
	background-color: burlywood;
	width: 1880px;
	height: 180px;
	font-size: 50px;
	top : -320px;
}

#search {
	position: relative;
	left: 630px;
	font-size: 40px;
	top : -270px;
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
	height: 50px;
}

#sort {
	position: relative;
	left: 1600px;
	width: 250px;
	height: 50px;
	top: -320px;
}
#total{
	position: relative;
	width: 2000px;
	height: 1300px;
}


</style>
</head>
<body>
	<%@include file="/WEB-INF/index/header.jsp" %>
	
	<div id ="total">
		<nav id="nav2">

			<p>전체</p>
			<br>
			<ul class="ulist">
				<li><a href="GameLevelList">전체</a></li>
				<li><a href="GameStrategyList">전략</a></li>
				<li><a href="GameTemaList">테마</a></li>
				<li><a href="GameFamilyList">가족</a></li>
				<li><a href="GamePartyList">파티</a></li>
				<li><a href="GameKoreanList">한글</a></li>

			</ul>

		</nav>

		<aside></aside>

		<section id="section2">
			<div id="d1">전체</div>

			<div id="search">
				게임이름 <input type="text" id="text_name">
				<button type="button" id="search_btn">검색</button>
			</div>

			<%-- 		<script>
			$("#search_btn").click(searchF1);
		      function searchF1(){
		         if($("#text_name").val() == ""){
		            alert("잘못 입력하셨습니다.");
		            return;   
		         }
		         ajaxF1();
		      }
		      function ajaxF1(){
		          {
		            $.ajax({
		               type:"post",
		               url:"<%=request.getContextPath()%>/gamelist.ajax",
		               data: { 
		            	  gameKoName:$("#text_name").val(),	            	
		            	  gameLevel:0,	            	 
		            	  gameImage:"", 
		           
		               }, 
		               dataType:"json",
		               success: function(data){
		//[{"productNo":"a","productName":"b","parentCategory":"c","childCategory":"d","quantity":1,"price":2,"productInfoUrl":"e","productOption":"f","minPrice":0,"maxPrice":0}]
		                  resultHtml(data);
		               },
		               error: function(request, status, error){
		                  alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		               }
		            });
		         }
		      }
		      
		      function resultHtml(data){        
		    	  var html="<button type='button' class='btn1' onclick='#'>";
		         $.each(data, function(key, value){
		        	 html += "<img src="+ request.getContextPath() +"/"+ vo.getGameImage()+ "width='250' height='250' />";
			         html += "<div class='img-text'>";
			         html += vo.getGameKoName();
			         html += vo.getGameLevel();
			         html += "</div>";	    
		         });
		         
		         html += "</button>";
		         $("#board_info").empty(); 
		         $("#board_info").append(html);
		      }
			</script>
 --%>



			<select id="sort" onchange="window.open(value,'_self');">
				<option value="GameLevelList">난이도 순</option>
				<option value="GameGradeList">평점 순</option>
				<option value="GameGradeDescList">평점 낮은순</option>
				<option value="GameSortList">가나다 순</option>
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
					<input type = "hidden" value = "<%=vo.getGameNumber()%>"  name="GAME_NO">
					<button type="submit"    class="btn1" >
						<img src="<%=request.getContextPath()%>/<%=vo.getGameImage()%>"
							width="300" height="300" />
						<div class="img-text">
							<%=vo.getGameKoName()%>
							<%=vo.getGameLevel()%>
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
				<a href="./GameLevelList?pagenum=<%=i%>"> <%=i%></a>
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