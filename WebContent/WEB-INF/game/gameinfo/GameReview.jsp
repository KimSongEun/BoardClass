<%@page import="kh.semi.boardclass.game.model.vo.Game"%>
<%@page import="kh.semi.boardclass.game.model.vo.GameReview"%>
<%@page import="kh.semi.boardclass.used.model.vo.Used"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<GameReview> go2 = (ArrayList<GameReview>) request.getAttribute("reviewvolist");
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





#info2-2 {
	position: relative;
	width: 1450px;
	height: 1000px;
	left: 70px;
	top: 150px;
}





#total{
	position: relative;
	width: 1500px;
	height: 2950px;
}
#rd{
	width: 290px;
	height: 300px;
	position: relative;
	left: 100px;
	top: 30px;
}
#tb{
	position:relative;
	top: 100px;
	left: 400px;
	width: 1100px;
	height: 300px;
	margin-bottom: 30px;
	font-size: 30px;
	border-collapse:collapse;
    border-right:none;
border-left:none;
}

.td2{
	margin-right: 20px;
}

#page {
	position: relative;
	
	font-size: 40px;
}
 .heart{
	width: 100px;
	height: 100px;
	background: url("https://cssanimation.rocks/images/posts/steps/heart.png") no-repeat;
	background-position: 0 0;
	cursor: pointer;
	transition: background-position .6s steps(28);
	transition-duration: 0s;
	display: flex;
         justify-content: space-around;
        }
        .heart.is-active{
	transition-duration: .6s;
	background-position: -2800px 0;
        } 
        
.placement{
	height:30px;
	position: relative;
	top : -50px;
     display: flex;
    justify-content: space-around;
 }
         
.btn_report{
	position: relative;
	top : 25px;
      height: 50px; 
      width: 130px;
}
.btn_report2{
	position: relative;
	top : 25px;
      height: 50px; 
      width: 130px;
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
		
<div id ="total">
<%
					if (go2 != null) {
					for (GameReview go : go2) {
				%>
		
		<table border = "1" id = "tb">
							<tr>
								<td width="450px;"><%=go.getUserId()%>님</td>
								<td class="reviewNo"><%=go.getReviewNo()%></td>
								<td class = "td2" align=right >★   <%=go.getReviewScore()%> &nbsp; </td>								
							</tr>
							<tr>
								<td colspan="3" height="200px"><%=go.getReviewContent()%></td>
							</tr>
							<tr>
							<td colspan="2" > &nbsp;
								<div class="placement" >
								 <p>♥ <%=go.getLikecount()%>개 </p>	
								<c:if test="${game.userId != userSession.userId}">
								
					     		 <div class="heart <%if(go.getLiked()>0) {%>is-active<%} %>" id="btn_like"></div>
					     		
					     		 
					     		 <button type="button" class ="btn_report">신고하기</button>
								</c:if>
					     		 <c:if test="${game.userId != userSession.userId}">
    							 <button type="button" class ="btn_report2">삭제</button>
    							</div>
								</c:if></td>
								
								<td class = "td2" align=right><%=go.getReviewDate()%> &nbsp;</td>
							</tr>
						</table>
					<%}} %>	
</div>

				
				
				
				
		<div class="div_paging_before">
			<div id="page" class="div_paging">
				<%
					if (startPage > 1) {
				%>
				<a href="GameReview?GAME_NO=${gameno }&pagenum=${startPage-1}" class="pageprevious">&laquo;</a>
				<%
					} else {
				%>
				<a href="GameReview?GAME_NO=${gameno }&pagenum=1" class="pageprevious">&laquo;</a>
				<%	}
					for (int i = startPage; i <= endPage; i++) {
				%>
				<a href="GameReview?GAME_NO=${gameno }&pagenum=<%=i%>" class="pagecurrent"> <%=i%></a>
				<%
					}
					if (endPage < pageCount) {
				%>
				<a href="GameReview?GAME_NO=${gameno }&pagenum=${endPage+1}" class="pagenext">&raquo;</a>
				<%
					} else {
				%>
				<a href="GameReview?GAME_NO=${gameno }&pagenum=${pageCount}" class="pagenext">&raquo;</a>
				<% } %>
			</div>
		</div>
			

<%@include file="/WEB-INF/index/footer.jsp" %>

<script>

$(".btn_report2").click(conDelete);

function conDelete(){
	console.log($(this));
	var $eleClickThis = $(this);
	var $eleTable = $(this).parents("table");
	var $eleReviewNo = $eleTable.find(".reviewNo");
	var reviewNo = $eleReviewNo.text();
	if(window.confirm("삭제하겠습니까?")){
		location.href='reviewdeletee?reviewNo='+reviewNo;
	} else {
		return;
	}
}
	
	$(".heart").click(cbLike);

	function cbLike(){
		console.log($(this));
		var $eleClickThis = $(this);
		var $eleTable = $(this).parents("table");
		var $eleReviewNo = $eleTable.find(".reviewNo");
		var reviewNo = $eleReviewNo.text();

		if(!"${userSession}"){
			alert("로그인해주세요");
			return;
		}
		
		$.ajax({
			type : "post",
			url : "reviewLike.ajax",
			data : {
				loginId : "${userSession.userId}",
				thisReviewNo : reviewNo,
				thisGameNo : "${gameno}"
			},
			
			success : function(receive) {
				console.log("receive값은:"  + receive);
				// 1 : 좋아요 ->x
				// 0 : x-> 좋아요
				if(receive == 1) {
					$eleClickThis.removeClass("is-active");
				} else {
					$eleClickThis.addClass("is-active");
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
	$(".btn_report").click(cbReport);

	function cbReport(){
		console.log($(this));
		var $eleClickThis = $(this);
		var $eleTable = $(this).parents("table");
		var $eleReviewNo = $eleTable.find(".reviewNo");
		var reviewNo = $eleReviewNo.text();
		
		var reportedThis = false;
		
		if(!"${userSession}"){
			alert("로그인해주세요");
			return;
		}
		if("${reportresult}" == 1){
			alert("이미 신고하셨습니다.");
			reportedThis = true;
			return;
		}
		if(reportedThis){
			alert("이미 신고하셨습니다.");
			return;
		}
		$.ajax({
			type : "post",
			url : "reviewReport.ajax",
			data : {
				loginId : "${userSession.userId}",
				thisReviewNo : reviewNo,
				thisGameNo : "${gameno}"
			},
			
			success : function(receive) {
				console.log("신고receive값은:"+receive);
				if(receive<1){
					reportedThis = true;
					alert("이미 접수되었습니다");
					return;
				}
				reportedThis = true;
				alert("신고가 접수되었습니다.");
			},
			error : function(request, status, error) {
				alert("code:" + request.status + "\n" + "message:"
						+ request.responseText + "\n" + "error:"
						+ error);
			}
		});
	}

</script>
</body>
</html>