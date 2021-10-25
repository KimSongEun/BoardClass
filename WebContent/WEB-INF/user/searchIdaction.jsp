<%@page import="kh.semi.boardclass.user.model.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
User user = (User)request.getAttribute("users");

%>



<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/index/maincss.css">
<link rel="stylesheet" href="css/user/searchIdPwd.css">

</head>
<body>

	 <%@include file="/WEB-INF/index/header.jsp" %>

<section>
	

	      
 		<div id="Result" >
		<p>아이디 찾기</p>
		 <hr id="idpwd">
		<%
			if (user != null) {
		%>
		<div class="p">
			아이디 찾기에 성공했습니다!
		</div>
		<div id="name">
			[  <%=user.getUserName()%>  ] 님의 아이디는
		</div>
		<br>
		<div id="id">
			[  <%=user.getUserId()%>  ] 입니다.
		</div>

		<div id="page">
			 <button id="mainpage"  onclick = "location.href = '<%=request.getContextPath() %>/main'"> 메인페이지로 이동</button>
			 <button id="pwdpage"  onclick = "location.href = '<%=request.getContextPath() %>/searchpwd'"> 비밀번호 찾기</button>
		</div>


		<%
			} else {
		%>
	
		<div class="p">입력하신 정보와 일치하는 아이디를 찾을 수 없습니다.</div>
		<div class="p">아이디 찾기를 다시 시도해주세요.</div>
		<div class="p"></div>
		<div id="page">
			 <button id="mainpage"  onclick = "location.href = '<%=request.getContextPath() %>/main'"> 메인페이지로 이동</button>
			 <button id="signpage"  onclick = "location.href = '<%=request.getContextPath() %>/signup'"> 회원가입 하기</button>
        	 <button id="idpage"  onclick = "location.href = '<%=request.getContextPath() %>/searchid'"> 아이디 찾기</button>
		</div>
		
		
		<%
			}
		%>
	</div>

</section>

	 <%@include file="/WEB-INF/index/footer.jsp" %>

</body>
</html>

