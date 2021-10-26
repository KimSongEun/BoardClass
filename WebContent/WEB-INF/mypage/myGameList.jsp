
<%@page import="kh.semi.boardclass.mypage.model.vo.MyGameReview"%>
<%@page import="kh.semi.boardclass.mypage.model.vo.MyGameLike"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	ArrayList<MyGameLike> volist = (ArrayList<MyGameLike>) request.getAttribute("volist");
int startPage = (int) request.getAttribute("startPage");
int endPage = (int) request.getAttribute("endPage");
int pageCount = (int) request.getAttribute("pageCount");

ArrayList<MyGameReview> volist2 = (ArrayList<MyGameReview>) request.getAttribute("volist2");
int startPage2 = (int) request.getAttribute("startPage2");
int endPage2 = (int) request.getAttribute("endPage2");
int pageCount2 = (int) request.getAttribute("pageCount2");
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/mypage/myGameList.css">
<link rel="stylesheet" href="css/index/maincss.css">

<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<title>마이페이지 보드게임 조회</title>
</head>

<body>
	<%@include file="/WEB-INF/index/header.jsp"%>
	<div class="container">
		<div class="sidenav">
			<div class="mypage">
				<p class="title">마이페이지</p>
				<a href="<%=request.getContextPath()%>/myactivity">- 내 활동</a> <a
					href="<%=request.getContextPath()%>/myboardgame">- 보드게임</a> <a
					href="<%=request.getContextPath()%>/mytrade">- 중고거래</a> <a
					href="<%=request.getContextPath()%>/mycommunity">- 커뮤니티</a>
			</div>

			<div class="userInfo">
				<p class="title">회원정보 관리</p>
				<a href="<%=request.getContextPath()%>/checkuser">- 회원정보 조회</a> <a
					href="<%=request.getContextPath()%>/updateuser">- 회원정보 수정</a> <a
					href="<%=request.getContextPath()%>/deleteuser">- 회원탈퇴</a>
			</div>
		</div>



		<div class="main">

			<h1>
				<img src="img/card.png" width="55px" height="55px" /> 보드게임 찜 리스트 <img
					src="img/card.png" width="55px" height="55px" />
			</h1>
			<%
				if (volist == null || volist.isEmpty()) {
			%>
			<div class="p">※ 찜을 한 보드게임이 없습니다. ※</div>
			<%
				} else {
			for (MyGameLike vo : volist) {
			%>

			<table class="info">
				<tr>
					<td class="a"><img
						src="<%=request.getContextPath()%>/<%=vo.getGameImage()%>"
						width="250" height="250" style="border-radius: 25px"/></td>
				</tr>
				<tr>
					<td class="b">
						<div class="info_text">
							<%=vo.getGameKoName()%><br>
							카테고리 : <%=vo.getGameCategory()%><br>
							게임평점 : <%=vo.getGameGrade()%></div>
					</td>

				</tr>
			</table>

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
				<a href="./myboardgame?pagenum=<%=i%>"> <%=i%></a>
	
				<%
		
				}
				if (endPage < pageCount) {
				%>
				다음
				<%
					}
				%>
			</div>

			<hr id="hrdash">

			<h1>
				<img src="img/card.png" width="55px" height="55px" /> 리뷰를 작성한 보드게임 <img
					src="img/card.png" width="55px" height="55px" />
			</h1>
			<%
				if (volist2 == null || volist2.isEmpty()) {
			%>
			<div class="p">※ 리뷰를 작성한 보드게임이 없습니다. ※</div>
			<%
				} else {
			for (MyGameReview R : volist2) {
			%>

			<table class="info">
				<tr>
					<td class="a"><img
						src="<%=request.getContextPath()%>/<%=R.getGameImage()%>"
						width="250" height="250" style="border-radius: 25px"/></td>
				</tr>
				<tr>
					<td class="b">
						<div class="info_text">
							<%=R.getGameKoName()%><br>
							카테고리 : <%=R.getGameCategory()%><br>
							리뷰평점 : <%=R.getReviewScore()%></div>
					</td>

				</tr>
			</table>

			<%
				}
			}
			%>

<div id="page">
				<%
					if (startPage2 > 1) {
				%>
				< 이전
				<%
					}
				for (int j = startPage2; j <= endPage2; j++) {
				%>
			<a href="./myboardgame?pagenum2=<%=j%>"> <%=j%></a>
				<%
			
				}
				if (endPage2 < pageCount2) {
				%>
				다음 >
				<%
					}
				%>
			</div>
		</div>
		<%@include file="/WEB-INF/index/footer.jsp"%>

	</body>
</html>