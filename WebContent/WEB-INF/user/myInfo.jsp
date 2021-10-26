<%@page import="kh.semi.boardclass.user.model.vo.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%
	User m = (User) session.getAttribute("userSession");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 관리</title>
<link rel="stylesheet" href="css/user/myinfo.css">
<link rel="stylesheet" href="css/index/maincss.css">
<link rel="icon" href="./img/dicedice.ico" type="image/x-icon" sizes="16x16">
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
		
	<%
		if (m != null) {
	%>

		
	<form method="post" id="checkUser" action="updateuser" enctype="multipart/form-data">
		<div class="main">
				<table>
					<caption>
						<h1>회원정보 조회</h1>
					</caption>
				<tr>
					<div id="imgname">									
						<th  class="col3" rowspan="7"><img src="<%=request.getContextPath()%>/<%=m.getUserImage()%>" width="300px" height="300px">
						<div id="name"><%=m.getUserName()%> 님</div></th>
					</div>
				</tr>
					
					<tr>
						<td class="col1">닉네임</td>
						<td class="col2"><%=m.getUserNickname()%> </td>
					</tr>
					<tr>
						<td class="col1">아이디</td>
						<td class="col2"><%=m.getUserId()%> </td>
					</tr>

					<tr>
						<td class="col1">비밀번호</td>
						<td class="col2"><%=m.getUserPassword()%> </td>
					</tr>


					<tr>
						<td class="col1">이메일</td>
						<td class="col2"><%=m.getUserEmail()%></td>
					
					</tr>
					<tr>
						<td class="col1">휴대폰 번호</td>
						<td class="col2">0<%=m.getUserPhone()%></td>

					</tr>
	
					<tr>
						<td class="col1">주소 (선택)</td>
						<td class="col2"><%=m.getUserAddress()%></td>
					</tr>
	
				</table>
			</div>
			<div class="create">		
				<input class="updateBtn" id="updateBtn" type="submit" value="회원정보 수정" >
			</div>
	
	</form>
	<%
		}
	%>
    <%@include file="/WEB-INF/index/footer.jsp" %>
</body>
</html>