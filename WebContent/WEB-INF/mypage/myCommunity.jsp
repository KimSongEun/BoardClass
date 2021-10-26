<%@page import="kh.semi.boardclass.community.model.vo.Board"%>
<%@page import="kh.semi.boardclass.mypage.model.vo.UserMyComt"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
   ArrayList<Board> volist = (ArrayList<Board>) request.getAttribute("volist");
int startPage = (int) request.getAttribute("startPage");
int endPage = (int) request.getAttribute("endPage");
int pageCount = (int) request.getAttribute("pageCount");

ArrayList<UserMyComt> volist2 = (ArrayList<UserMyComt>) request.getAttribute("volist2");
int startPage2 = (int) request.getAttribute("startPage2");
int endPage2 = (int) request.getAttribute("endPage2");
int pageCount2 = (int) request.getAttribute("pageCount2");
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/index/maincss.css">
<link rel="stylesheet" href="css/mypage/myCommunity.css">
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<link rel="icon" href="./img/dicedice.ico" type="image/x-icon" sizes="16x16">
<title>마이페이지 커뮤니티 조회</title>
</head>

<body>

	 <%@include file="/WEB-INF/index/header.jsp" %>
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
				<img src="img/card.png" width="55px" height="55px" /> 커뮤니티 작성 글 <img
					src="img/card.png" width="55px" height="55px" />
			</h1>
			<div class="cboard">

				<%
               if (volist == null || volist.isEmpty()) {
            %>
				<div class="p">※ 작성한 커뮤니티 글이 없습니다. ※</div>
				<%
               } else {
            %>

				<table class="board">
					<thead>
						<tr>
							<td width="100">글번호</td>
							<td width="180">카테고리</td>
							<td width="500">제목</td>
							<td width="140">작성자</td>
							<td width="190">작성일자</td>
							<td width="130">조회수</td>
						</tr>
					</thead>

					<%
                  for (Board vo : volist) {
               %>


					<tbody>
						<tr>
							<td width="100"><%=vo.getBoardNo()%></td>
							<td width="180"><%=vo.getBoardCategory()%></td>
							<td width="500"><%=vo.getBoardTitle()%></td>
							<td width="140"><%=vo.getUserId()%></td>
							<td width="190"><%=vo.getBoardWriteDate()%></td>
							<td width="130"><%=vo.getBoardViewCount()%></td>
						</tr>
					</tbody>



					<%
                  }
               }
               %>
				</table>
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
				<a href="./mycommunity?pagenum=<%=i%>"> <%=i%></a>

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
				<img src="img/card.png" width="55px" height="55px" /> 커뮤니티 작성 댓글 <img
					src="img/card.png" width="55px" height="55px" />
			</h1>

			<div class="ccomt">


				<%
					if (volist2 == null || volist2.isEmpty()) {
				%>
				<div class="p">※ 작성한 커뮤니티 댓글이 없습니다. ※</div>
				<%
					} else {
				%>

				<table class="board">
					<thead>
						<tr>
							<td width="90">글번호</td>
							<td width="370">글제목</td>
							<td width="110">글작성자</td>
							<td width="510">댓글 내용</td>
							<td width="170">댓글 입력 날짜</td>
						</tr>
					</thead>

					<%
						for (UserMyComt c : volist2) {
					%>
					<tbody>
						<tr>
							<td width="90"><%=c.getBoardNo()%></td>
							<td width="370"><%=c.getBoardTitle()%></td>
							<td width="110"><%=c.getUserId()%></td>
							<td width="510"><%=c.getCommentContent()%></td>
							<td width="170"><%=c.getCommentWriteDate()%></td>
						</tr>
					</tbody>

					<%
						
					}
					}
					%>
				</table>
			</div>


			<div id="page">
				<%
					if (startPage2 > 1) {
				%>
				< 이전
				<%
 	}
 for (int j = startPage2; j <= endPage2; j++) {
 %>
				<a href="./mycommunity?pagenum2=<%=j%>"> <%=j%></a>
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
		<%@include file="/WEB-INF/index/footer.jsp" %>
</body>
</html>

