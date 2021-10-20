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
<link rel="stylesheet" href="./css/user/loginHeaderFooter.css">

</head>
<body>
  <%@include file="/WEB-INF/user/userHeader.jsp" %>
	<%
		if (m != null) {
	%>

	<form method="post" id="checkUser" action="updateuser" enctype="multipart/form-data">
		<div class="container">
			<div class="insert">
				<table>
					<caption>
						<h2>회원정보조회</h2>
					</caption>
					<tr>
						<td class="col1">프로필사진</td>
						<td class="col2">
						<img alt="" src="<%=m.getUserImage()%>">
					</tr>
				
					<tr>
						<td class="col1">이름</td>
						<td class="col2"><input type="text" name="userName"
							id="userName" value="<%=m.getUserName()%>" readonly="readonly"></td>
					
					</tr>
					<tr>
						<td class="col1">닉네임</td>
						<td class="col2"><input type="text" name="userNickname"
							id="userNickname" value="<%=m.getUserNickname()%>" readonly="readonly"> 
			
					</tr>
					<tr>
						<td class="col1">아이디</td>
						<td class="col2"><input type="text" name="userId" id="userId"
							value="<%=m.getUserId()%>" readonly="readonly">
					</tr>

					<tr>
						<td class="col1">비밀번호</td>
						<td class="col2"><input type="password" name="userPassword"
							id="userPassword" value="<%=m.getUserPassword()%>" readonly="readonly"> 
					</tr>


					<tr>
						<td class="col1">이메일</td>
						<td class="col2"><input type="text" name="userEmail"
							id="userEmail" value="<%=m.getUserEmail()%>" readonly="readonly"></td>
					
					</tr>
					<tr>
						<td class="col1">휴대폰 번호</td>
						<td class="col2"><input type="number" name="userPhone"
							id="userPhone" value="0<%=m.getUserPhone()%>" readonly="readonly"> 

					</tr>
	
					<tr>
						<td class="col1">주소 (선택)</td>
						<td class="col2"><input type="text" name="userAddress"
							id="userAddress" value="<%=m.getUserAddress()%>" readonly="readonly"></td>
					</tr>
	
				</table>
			</div>
			<div class="create">		
				<input class="updateBtn" id="updateBtn" type="submit" value="회원정보 수정" >
			</div>
		</div>
	</form>
	<%
		}
	%>
   <%@include file="/WEB-INF/user/userFooter.jsp" %>
</body>
</html>