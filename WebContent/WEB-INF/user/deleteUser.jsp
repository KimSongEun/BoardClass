<%@page import="kh.semi.boardclass.user.model.vo.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	User m = (User) session.getAttribute("userSession");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 탈퇴</title>
 <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="css/user/deleteUser.css">
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

	<form name="form" method="post" id="deleteform" action="deleteuser.do" enctype="multipart/form-data">
		<div class="main">
				<table>
					<caption>
						<h1>회원탈퇴</h1>
					</caption>
				<tr>
					<div id="imgname">									
						<th class="col3" rowspan="4"><img src="<%=request.getContextPath()%>/<%=m.getUserImage()%>" width="250px" height="250px">
						<div id="name"><%=m.getUserName()%> 님</div></th>
					</div>
				</tr>
					<tr>
						<th class="col4" colspan="2">정말 회원을 탈퇴하시겠습니까?</th>
						
					</tr>
					<tr>
						<td class="col1">아이디</td>
						<td class="col2"><input type="text" name="userId" id="userId"
							value="<%=m.getUserId()%>" readonly="readonly">
					</tr>
					<tr>
						<td class="col1">비밀번호</td>
						<td class="col2"><input type="password" name="userPassword"
							id="userPassword" placeholder="비밀번호를 입력해주세요."> 
					</tr>

				</table>
			</div>
			<div class="create">		
				<input class="deleteBtn" id="deleteBtn" type="button" value="회원 탈퇴">
			</div>
	
	</form>
	<%
		}
	%>
	 <%@include file="/WEB-INF/index/footer.jsp" %>
	<script>
    $(function () {
	$("#deleteBtn").on("click", function(){
		if($("#userPassword").val()==""){
			alert("비밀번호를 입력해주세요.");
			$("#userPassword").focus();
			return false;
		}
		$.ajax({
			url: "deletechkpwd",
               type: "post",
               async: false,
               data: {
            	   userId: $("#userId").val(),
            	   userPassword: $('#userPassword').val()
               },
               dataType: "text",
			success: function(value){				
				if(value == "fail"){
					console.log("실패");
					alert("패스워드가 틀렸습니다.");
					return;
				}else{
				if(confirm("회원탈퇴하시겠습니까?")){
						$("#deleteform").submit();					
						alert("회원탈퇴에 성공했습니다.");
						}

					}
			}
		})
		
	});
	
    });
	</script>
   
</body>
</html>