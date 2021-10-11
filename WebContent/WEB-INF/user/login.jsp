<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="kh.semi.boardclass.user.model.vo.*"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	User m = (User) session.getAttribute("user");
%>
<!DOCTYPE html>
<html lang="en">
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/user/login.css">
<link rel="stylesheet" href="./css/index.css">




<style>
@font-face {
	font-family: 'ImcreSoojin';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-04@2.3/ImcreSoojin.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

@media {
}
</style>

</head>
<body>
<div class="total">
	<header>
<div class="nav">
	<%
	if (m == null) {
%>	

			<nav class="navlogin">
				 <a id="modal_opne_btn" href="#">로그인</a>
				<!--<button class="trigger" > 로그인</button> -->
				 | <a href="signup.jsp">회원가입</a>
			</nav>
			<%
	} else {
%>

	<nav class="navlogin">
		<a href="logout">로그아웃</a> | 
		<a href="#">회원정보 관리</a> | 
		<a href="#">마이페이지</a>
	</nav>

<%
	}
%>


	</div>
		<div class="logo">
			<a href="#"><img src="img/logo.png" /></a>
		</div>
		<hr id="hrdash">
		<br>
		<div class="nav">
			<nav class="navcategory">
				<a href="#">카테고리</a> | <a href="#">게임랭킹</a> | <a href="#">중고거래</a> |
				<a href="#">게시판</a> | <a href="#">보드게임정보</a>
			</nav>
		</div>
		<br>
		<hr id="hrsolid">
	</header>
	<aside></aside>
	<section></section>
	<hr>
	<br>
	<footer>
		<div class="footer">
			<span id="f_s">Copyright ⓒ 2021 <b id="f_b">보드게임 커뮤니티
					보드클래스</b> All rights reserved.
			</span> | <a href="#"><b>서비스 약관/정책</b></a> | <a href="#"><b>개인정보취급방침</b></a>
			| <a href="#">공지사항</a> | <a href="#">고객센터</a>
		</div>
	</footer>
	<br>
</div>

    <div id="modal">

        <!-- Modal content -->
        <div class="modal_content">
            <button type="button" id="modal_close_btn">x</button>
            <!-- <button type="button" id="modal_close_btn">&times;</button> -->
            <!-- <span class="modal_close_btn">&times;</span> -->
            <div class="login">
                <h2>로그인</h2>
                <ul>
                    <li><input type="text" name="userid" id="userid" placeholder="아이디"></li>
                    <li><input type="password" name="userpwd" id="userpwd"  placeholder="비밀번호"></li>
                    <li><button type="button" id="btnLogin">로그인</button></li>
                </ul>
                <div>
                    <ul>
                        <li><a href="#">회원가입</a></li>
                        <li><a href="#">아이디 찾기</a></li>
                        <li> <a href="#">비밀번호 찾기</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="modal_layer"></div>
    </div>


</body>


<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js" ></script>
	<script>

	

$(function() {
	$("#btnLogin").on('click', function() {
		console.log("ajax시작");
		// $(함수); 과 비슷  $.ajax();
		// $.ajax(오브젝트타입);
		// $.ajax({ key1:v1  , key2:v2  ,  ....});
		// object에서 key는 string타입, value에는 함수,숫자,문자,배열,오브젝트 등 모든타입가능
		//  
		$.ajax({ // JQuery 를 통한 ajax 호출 방식 사용
			type : "post",
			url : "login",
			data : {
					userId : $("#userid").val(),
					userPassword : $("#userpwd").val()
				},
			dataType : "json", // 전달받을 객체는 JSON 이다.
			success : function(d) {
					// /* 이부분은 예시 1,2 경우에 가능
					
					
	
		
					
					
					if(d.result == "ok"){ 
						 $("#modal").hide(); 
						
							var text = 
								"<a href='logout'>로그아웃</a> | <a href='#'>회원정보 관리</a> | <a href='#'>마이페이지</a>";
						
								$(".navlogin").html(text);
						//예시 1
						console.log(d.memberInfo);//결과 {id: 'user11', passwd: 'pass11', name: '사용자1', email: 'user11@test.or.kr'}
						console.log(d.memberInfo.userId);//결과 user11
						//예시 2
						//console.log(d.memberInfo);//결과 0: {id: 'user11', passwd: 'pass11', name: '사용자1', email: 'user11@test.or.kr'} 1: {id: 'user11', passwd: 'pass11', name: '사용자1', email: 'user11@test.or.kr'} length: 2
						//console.log(d.memberInfo[0].id);//결과 user11

				
						
						
						
						
					} else {
						alert("로그인 실패!\nID와 비밀번호를 다시 확인하세요.");
					}
					// */
					
					//예시 3
					//console.log(d);//결과  {id: 'user11', passwd: 'pass11', name: '사용자1', email: 'user11@test.or.kr'}
					//console.log(d.id);//결과 user11
					
					//예시 4
					//console.log(d);//결과 0: {id: 'user11', passwd: 'pass11', name: '사용자1', email: 'user11@test.or.kr'}	1: {id: 'user11', passwd: 'pass11', name: '사용자1', email: 'user11@test.or.kr'}	length: 2
					//console.log(d[0].id);//결과 user11					
				},
			// error 상황을 만들어보려면 url: 없는 url을 작성. 또는 지원하지 않는 type 
			// 예) url : "login.loa",
			// 예) type : "get",
			error : function(request,status,error) {
				alert("code:"+request.status+"\n"+"message:"+request.responseText+
				"\n"+"error:"+error);
				}
		});
	});
	
	
	 $("#modal_opne_btn").click(function () {
         $("#modal").fadeIn();
     });

     $("#modal_close_btn").click(function () {
         $("#modal").fadeOut();
     });

     $(".modal_layer").click(function () {
         $("#modal").fadeOut();
     });
	
	
	
});


	


</script>

</html>