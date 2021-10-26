
<%@page import="kh.semi.boardclass.mypage.model.vo.UserMyUsed"%>
<%@page import="kh.semi.boardclass.used.model.vo.Used"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
ArrayList<Used> volist = (ArrayList<Used>) request.getAttribute("volist");
int startPage = (int)request.getAttribute("startPage");
int endPage = (int)request.getAttribute("endPage");
int pageCount = (int)request.getAttribute("pageCount");

ArrayList<UserMyUsed> volist2 = (ArrayList<UserMyUsed>) request.getAttribute("volist2");
int startPage2 = (int)request.getAttribute("startPage2");
int endPage2 = (int)request.getAttribute("endPage2");
int pageCount2 = (int)request.getAttribute("pageCount2");
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/index/maincss.css">
<link rel="stylesheet" href="css/mypage/myUsedList.css">
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<link rel="icon" href="./img/dicedice.ico" type="image/x-icon" sizes="16x16">
<title>마이페이지 중고거래 조회</title>
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
				<img src="img/card.png" width="55px" height="55px" /> 판매 게시글 <img
					src="img/card.png" width="55px" height="55px" />
			</h1>
			<%
				if (volist == null || volist.isEmpty()) {
			%>
			<div class="p">※ 작성한 판매 게시글이 없습니다. ※</div>
			<%
				} else {
			for (Used vo : volist) {
			%>

			<table class="info">
				<tr>
					<td class="a"><img
						src="<%=request.getContextPath()%>/<%=vo.getUsedImg()%>"
						width="200" height="200" style="border-radius: 25px"/></td>
						<td class="b">
						<div class="info_text">
							제목 : <%=vo.getUsedTitle()%><br>
							가격 : <%=vo.getUsedPrice()%><br>
							등록날짜 : <%=vo.getUsedDay()%></div>
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
				<a href="./mytrade?pagenum=<%=i%>"> <%=i%></a>

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
				<img src="img/card.png" width="55px" height="55px" /> 찜리스트 <img
					src="img/card.png" width="55px" height="55px" />
			</h1>

			<%
				if (volist2 == null || volist2.isEmpty()) {
			%>
			<div class="p">※ 찜한 중고거래가 없습니다. ※</div>
			<%
				} else {
			for (UserMyUsed L : volist2) {
			%>

			<table class="info">
				<tr>
					<td class="a"><div class="imgR"><img
						src="<%=request.getContextPath()%>/<%=L.getUsedNo()%>" width="200" height="200" style="border-radius: 25px"/></div></td>
					<td class="b">
						<div class="info_text">
							제목 : <%=L.getUsedTitle()%><br>
							가격 : <%=L.getUsedPrice()%><br>
							카테고리 : <%=L.getUsedCategory()%></div>
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
				<a href="./mytrade?pagenum2=<%=j%>"> <%=j%></a>
				<%
			
				}
				if (endPage2 < pageCount2) {
				%>
				다음 >
				<%
					}
				%>
			</div>
			<%@include file="/WEB-INF/index/footer.jsp"%>
</body>
</html>