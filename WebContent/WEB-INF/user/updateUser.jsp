<%@page import="kh.semi.boardclass.user.model.vo.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%
	User m = (User) session.getAttribute("userSession");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
<link rel="stylesheet" href="css/user/updateUser.css">
<link rel="stylesheet" href="css/index/maincss.css">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="./js/user/updateUser.js"></script>
<link rel="icon" href="./img/dicedice.ico" type="image/x-icon" sizes="16x16">
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
		<%
			if (m != null) {
		%>

		<form name="form" method="post" id="updateform" action="updateuser.do"
			enctype="multipart/form-data">


			<div class="main">
				<table>
					<caption>
						<h1>회원정보 수정</h1>
					</caption>

					<tr>
						<td class="col1">프로필사진</td>
						<td class="col2">
							<div id="">
								현재 적용된 파일 :
								<%=request.getContextPath()%>/<%=m.getUserImage()%></div>
							<div id="afile">
								수정할 파일 선택 : <input type="file" name="uploadFile" id="userImage">
							</div>
						</td>

					</tr>
					<tr>
						<td class="col1">이름</td>
						<td class="col2"><input type="text" name="userName"
							readonly="readonly" id="userName" value="<%=m.getUserName()%>"
							maxlength="5"></td>
						<td><div class="userName regex"></div></td>
					</tr>

					<tr>
						<td class="col1">닉네임</td>
						<td class="col2"><input type="text" name="userNickname" 
							id="userNickname" value="<%=m.getUserNickname()%>" maxlength="8"
							placeholder="닉네임을 입력해주세요."> <input
							class='dupnicknamechkBtn' id="dupnicknamechkBtn" name="dupnicknamechkBtn" type="button"
							
							value="중복확인" disabled="disabled" ></td>
						<td>
							<div id="nicknamecheck"></div>
						</td>
						<td><input type="hidden" name="nickDuplication"
							value="nicknameUncheck"></td>
					</tr>
					<tr>
						<td class="col1">아이디</td>
						<td class="col2"><input type="text" name="userId" id="userId"
							value="<%=m.getUserId()%>" maxlength="20" readonly="readonly"
							placeholder="아이디를 입력해주세요." onkeydown="inputIdChk()"> 
						</td>
					</tr>

					<tr>
						<td class="col1">비밀번호</td>
						<td class="col2"><input type="text" name="userPassword"
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
							id="userPhone" value="0<%=m.getUserPhone()%>"
							placeholder="휴대폰 번호를 입력해주세요.">
							<div id="phone">- 를 제외하고 숫자만 10~11자리 입력 EX)01012345678</div></td>

					</tr>
					<tr>
						<td class="col1">주소 (선택)</td>
						<td class="col2"><input type="text" name="userAddress"
							id="userAddress" value="<%=m.getUserAddress()%>"></td>
					</tr>

					<input type="hidden" name="image" value="<%=m.getUserImage()%>" />
					<input type="hidden" name="address" value="<%=m.getUserAddress()%>" />


				</table>
			</div>
			<div class="create">
				<input class="updateBtn" id="updateBtn" type="submit" value="수정하기">
				<input class="cancelBtn" type="reset" value="취소">

			</div>
		</form>
		<%
			}
		%>
		<%@include file="/WEB-INF/index/footer.jsp"%>
		
		<script>
	
		
		</script>
</body>
</html>