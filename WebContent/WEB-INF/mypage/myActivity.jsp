
<%@page import="kh.semi.boardclass.mypage.model.vo.*"%>
<%@page import="kh.semi.boardclass.user.model.vo.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	int MyTradeList = (int) request.getAttribute("MyTradeList");
%>


<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>전체글 목록</title>
<link rel="stylesheet" href="css/index/maincss.css">
<link rel="stylesheet" href="css/mypage/myActivity.css">
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>

<style>
.container {
	
}
</style>
</head>

<body>

	 <%@include file="/WEB-INF/index/header.jsp" %>
	<div class="container">
		<div class="sidenav">
			<div class="mypage">
				<p class="title">마이페이지</p>
				<a href="<%=request.getContextPath()%>/myactivity">- 내 활동</a> <a href="<%=request.getContextPath()%>/myboardgame">- 보드게임</a> <a
					href="<%=request.getContextPath()%>/mytrade">- 중고거래</a> <a href="<%=request.getContextPath()%>/mycommunity">- 커뮤니티</a>
			</div>

			<div class="userInfo">
				<p class="title">회원정보 관리</p>
				<a href="<%=request.getContextPath()%>/checkuser">- 회원정보 조회</a> <a href="<%=request.getContextPath()%>/updateuser">- 회원정보 수정</a> <a
					href="<%=request.getContextPath()%>/deleteuser">- 회원탈퇴</a>
			</div>
		</div>

		<div class="main">
			<h1>내 활동</h1>
			<div id="BoardGameLike">
				<table class="BoardGameLike">
					<tr>
						<td>찜한 보드게임 수</td>
					</tr>
					<c:if test="${BoardGameLike == null}">
						<tr>
							<td>0</td>
						</tr>
					</c:if>
					<c:if test="${BoardGameLike != null}">
						<tr>
							<td>${BoardGameLike}</td>
						</tr>
					</c:if>
				</table>
			</div>
			<div id="MyTradeList">
				<table class="MyTradeList">
					<tr>
						<td>판매 게시글 수</td>
					</tr>
					<c:if test="${MyTradeList == null}">
						<tr>
							<td>0</td>
						</tr>
					</c:if>
					<c:if test="${MyTradeList != null}">
						<tr>
							<td>${MyTradeList}</td>
						</tr>
					</c:if>
				</table>
			</div>
			<div id="MyTradeLike">
				<table class="MyTradeLike">
					<tr>
						<td>찜한 중고거래 수</td>
					</tr>
					<c:if test="${MyTradeLike == null}">
						<tr>
							<td>0</td>
						</tr>
					</c:if>
					<c:if test="${MyTradeLike != null}">
						<tr>
							<td>${MyTradeLike}</td>
						</tr>
					</c:if>
				</table>
			</div>
			<div id="MyBoardCount">
				<table class="MyBoardCount">
					<tr>
						<td>커뮤니티 작성글 수</td>
					</tr>
					<c:if test="${MyBoardCount == null}">
						<tr>
							<td>0</td>
						</tr>
					</c:if>
					<c:if test="${MyBoardCount != null}">
						<tr>
							<td>${MyBoardCount}</td>
						</tr>
					</c:if>
				</table>
			</div>
			<div id="MyBoardComtCount">
				<table class="MyBoardComtCount">
					<tr>
						<td>커뮤니티 댓글 작성 수</td>
					</tr>
					<c:if test="${MyBoardComtCount == null}">
						<tr>
							<td>0</td>
						</tr>
					</c:if>
					<c:if test="${MyBoardComtCount != null}">
						<tr>
							<td>${MyBoardComtCount}</td>
						</tr>
					</c:if>
				</table>
			</div>

		</div>
		</div>
		<%@include file="/WEB-INF/index/footer.jsp" %>
</body>
</html>