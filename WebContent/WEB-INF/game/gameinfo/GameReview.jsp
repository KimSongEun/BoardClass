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
	width: 2000px;
	height: 2600px;
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
	width: 1520px;
	height: 300px;
	margin-bottom: 30px;
	font-size: 30px;
}
.td2{
	margin-right: 20px;
}

#page {
	position: relative;
	top: -80px;
	left: 1100px;
	font-size: 40px;
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
								<td> &nbsp; @@</td>
								<td class = "td2" align=right >★   <%=go.getReviewScore()%> &nbsp; </td>								
							</tr>
							<tr>
								<td colspan="2" height="200px"><%=go.getReviewContent()%></td>
							</tr>
							<tr>
								<td> &nbsp; dd</td>
								<td class = "td2" align=right><%=go.getReviewDate()%> &nbsp;</td>
							</tr>
							
						</table>
			
			
		
		<%}} %>
</div>
			<div id="page">
				<%
					if (startPage > 1) {
				%>
				이전
				<%
					}
					for (int i = startPage; i <= endPage; i++) {
				%>
				<a href="./GameReview?GAME_NO=${gameno }&pagenum=<%=i%>"> <%=i%></a>
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
		
		
<%@include file="/WEB-INF/index/footer.jsp" %>
</body>
</html>