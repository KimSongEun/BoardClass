<%@page import="kh.semi.boardclass.user.model.vo.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%
	User m = (User) session.getAttribute("userSession");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Info View</title>
<link rel="stylesheet" href="./css/user/loginHeaderFooter.css">
</head>
<body>
<%@include file="/WEB-INF/user/userHeader.jsp" %>
	<h2 align="center">내 정보 보기</h2>
	<hr>
	<%
		if (m != null) {
	%>

	<form method="post" id="updateform" action="updateuser.do" enctype="multipart/form-data">
		<div class="container">
			<div class="insert">
				<table>
					<caption>
						<h2>회원정보조회</h2>
					</caption>

					<tr>
						<td class="col1">프로필사진</td>
						<td class="col2">
						<td class="col2"><input type="file" name="uploadFile" id="userImage" value="<%=m.getUserImage()%>"></td>

							
					</tr>
					<tr>
						<td class="col1">이름</td>
						<td class="col2"><input type="text" name="userName"
							id="userName" value="<%=m.getUserName()%>" maxlength="5"
							placeholder="이름을 입력해주세요."></td>
						<td><div class="userName regex"></div></td>
					</tr>
					<tr>
						<td class="col1">닉네임</td>
						<td class="col2"><input type="text" name="userNickname"
							id="userNickname" value="<%=m.getUserNickname()%>" maxlength="8"
							placeholder="닉네임을 입력해주세요."> <input
							class='dupnicknamechkBtn' id="dupnicknamechkBtn" type="button"
							value="중복확인" onclick=""></td>
						<td>
							<div id="nicknamecheck"></div>
						</td>
						<td><input type="button" name="nickDuplication"
							value="nicknameUncheck"></td>
					</tr>
					<tr>
						<td class="col1">아이디</td>
						<td class="col2"><input type="text" name="userId" id="userId"
							value="<%=m.getUserId()%>" maxlength="20" readonly="readonly"
							placeholder="아이디를 입력해주세요." onkeydown="inputIdChk()"> <input
							class='dupidchkBtn' id="dupidchkBtn" type="button" value="중복확인">
						</td>
						<td>
							<div id="idcheck"></div>
						</td>
						<td><input type="button" name="idDuplication"
							value="idUncheck"></td>
					</tr>

					<tr>
						<td class="col1">비밀번호</td>
						<td class="col2"><input type="password" name="userPassword"
							id="userPassword" value="<%=m.getUserPassword()%>" maxlength="16"
							placeholder="비밀번호를 입력해주세요."> <span>8자리 이상, 대/소문자
								구분</span></td>
						<td><div class="userPassword regex"></div></td>
					</tr>


					<tr>
						<td class="col1">이메일</td>
						<td class="col2"><input type="text" name="userEmail"
							id="userEmail" value="<%=m.getUserEmail()%>"
							placeholder="이메일을 입력해주세요."></td>
						<td><div class="userEmail regex"></div></td>
					</tr>
					<tr>
						<td class="col1">휴대폰 번호</td>
						<td class="col2"><input type="number" name="userPhone"
							id="userPhone" value="<%=m.getUserPhone()%>"
							placeholder="휴대폰 번호를 입력해주세요."> <span> - 를 제외하고 숫자만
								10~11자리 입력 EX)01012345678 </span> <input class='phoneNumBtn'
							type="button" value="인증번호 전송" onclick=""></td>

					</tr>
					<tr>
						<td class="col1">주소 (선택)</td>
						<td class="col2"><input type="text" name="userAddress"
							id="userAddress" value="<%=m.getUserAddress()%>"></td>
					</tr>
					
					<input type="hidden" name="image" value="<%=m.getUserImage()%>"/>
					<input type="hidden" name="address" value="<%=m.getUserAddress()%>"/>
						

				</table>
			</div>
			<div class="create">
				<input class="signupBtn" id="signupBtn" type="submit" value="수정하기">
				<input class="cancelBtn" type="reset" value="취소">

			</div>
		</div>
	</form>
	<%
		}
	%>
	<%@include file="/WEB-INF/user/userFooter.jsp" %>
</body>
</html>