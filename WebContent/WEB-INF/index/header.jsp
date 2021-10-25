<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="kh.semi.boardclass.user.model.vo.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/user/login.css" />
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>

<header>

	<c:if test="${user == null }">
		<nav class="navlogin">
			<a id="modal_opne_btn">로그인</a> | <a
				href="<%=request.getContextPath()%>/signup">회원가입</a>
		</nav>
	</c:if>
	<c:if test="${userType == '1'}">
		<nav class="navlogin">
			<a href="<%=request.getContextPath()%>/logout">로그아웃</a> | <a
				href="<%=request.getContextPath()%>/adminmain" target="_blank">관리자 페이지</a>
		</nav>
	</c:if>
	<c:if test="${userType == '0'}">
		<nav class="navlogin">
			<a href="<%=request.getContextPath()%>/logout">로그아웃</a> | <a
				href="<%=request.getContextPath()%>/checkuser">회원정보 관리</a> | <a
				href="<%=request.getContextPath()%>/myactivity">마이페이지</a>
		</nav>
	</c:if>

	<div class="header_logo">
		<div class="div_logo">
			<a href="#"> <img src="./img/logo.png">
			</a>
		</div>
		<div></div>
		<div class="div_toggle">
			<a href="" class="menu_toggleBtn"> <i class="fas fa-bars"></i>
			</a> <a href="" class="member_toggleBtn"> <i
				class="fas fa-address-card"></i>
			</a>
		</div>
	</div>
	<hr>
	<nav class="header_menu">
		<div class="div_menu">
			<a href="GameGradeRank">게임랭킹</a> <a href="GameAllList">보드게임</a> <a
				href="cmain">커뮤니티</a> <a href="usedmain">중고거래</a>
		</div>
	</nav>
	<hr>
</header>

<div id="modal">
        <!-- Modal content -->
        <div class="modal_content">
            <button type="button" id="modal_close_btn">x</button>
            <div class="login">
                <h2>로그인</h2>
                <ul>
                    <li><input type="text" name="userid" id="userid" placeholder="아이디"></li>
                    <li><input type="password" name="userpwd" id="userpwd"  placeholder="비밀번호"></li>
                    <li><button type="button" id="btnLogin">로그인</button></li>
                </ul>
                <div>
                    <ul>
                   		<li><a href="<%=request.getContextPath() %>/signup">회원가입</a></li>
                        <li><a href="<%=request.getContextPath() %>/searchid">아이디 찾기</a></li>
                        <li><a href="<%=request.getContextPath() %>/searchpwd">비밀번호 찾기</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="modal_layer"></div>
    </div>

<script>
$(function() {
	$("#btnLogin").on('click', function() {
		console.log("ajax시작");
		$.ajax({ // JQuery 를 통한 ajax 호출 방식 사용
			type : "post",
			url : "login.do",
			data : {
					userId : $("#userid").val(),
					userPassword : $("#userpwd").val()
				},
			dataType : "json", // 전달받을 객체는 JSON 이다.
			success : function(d) {
		
					if(d.result == "ok"){ 
						 $("#modal").hide(); 
							var text = 
								"<a href='logout'>로그아웃</a> | <a href='checkuser'>회원정보 관리</a> | <a href='myactivity'>마이페이지</a>";
						
								$(".navlogin").html(text);
								location.href="main"
						//예시 1
						console.log(d.memberInfo);//결과 {id: 'user11', passwd: 'pass11', name: '사용자1', email: 'user11@test.or.kr'}
						console.log(d.memberInfo.userId);//결과 user11
					} else {
						alert("로그인에 실패했습니다. \n ID와 비밀번호를 다시 확인해주세요.");
					}					
				},
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
         $('#userid').val('');
         $('#userpwd').val('');
     });

     $(".modal_layer").click(function () {
         $("#modal").fadeOut();
         $('#userid').val('');
         $('#userpwd').val('');
     });

});
</script>

</html>