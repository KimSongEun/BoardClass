<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="./css/admin/main/adminHeader.css"/> 
	<link rel="stylesheet" href="./css/admin/adminuser/adminUserDetail.css"/>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="./js/admin/adminuser/adminUserDetail.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script> 
<title>회원정보상세조회</title>
</head>
<body>
    <%@include file="/WEB-INF/admin/main/adminHeader.jsp" %>
    <header></header>
    <section>
        <div class="admin_user-flex">
            <div class="admin_user">
                <div class="admin_user_top">
                    <div class="admin_user_view">
                        <div class="admin_user_view_img"><img src="${uservo.userImage}"></div>
                        <br>
                        <div class="admin_user_view_nickname">${uservo.userNickname}</div>
                    </div>

                    <div class="admin_user_info">
                        <p>&nbsp;&nbsp;&nbsp;&nbsp; 회원번호 : ${uservo.userNo}</p>
                        <br>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp; 아이디 : ${uservo.userId}</p>
                        <br>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp; 이메일 : ${uservo.userEmail}</p>
                        <br>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp; 주소 : ${uservo.userAddress}</p>
                    </div>
                </div>

                <div class="navbar">
                    <div class="subnav">
                        <button class="subnavbtn">작성글 <i class="fa fa-caret-down"></i></button>
                        <div class="subnav-content">
                            <a href="#" class="board">커뮤니티글</a>
                            <a href="#" class = "used">중고거래글</a>
                        </div>
                    </div>
                    <div class="subnav">
                        <button class="subnavbtn">작성댓글 <i class="fa fa-caret-down"></i></button>
                        <div class="subnav-content">
                            <a href="#"></a>
                            <a href="#" class="comt">커뮤니티댓글</a>
                            <a href="#" class="review">리뷰글</a>
                        </div>
                    </div>
                    <div class="subnav">
                        <button class="subnavbtn">신고된 글 <i class="fa fa-caret-down"></i></button>
                        <div class="subnav-content">
                        	<a href="#"></a>
                        	<a href="#"></a>
                            <a href="#" class="reportboard">커뮤니티글</a>
                            <a href="#" class="reportused">중고거래글</a>
                        </div>
                    </div>
                    <div class="subnav">
                        <button class="subnavbtn">신고된 댓글 <i class="fa fa-caret-down"></i></button>
                        <div class="subnav-content">
                        	<a href="#"></a>
                        	<a href="#"></a>       
                        	<a href="#"></a>       
                            <a href="#" class="reportcomt">커뮤니티댓글</a>
                            <a href="#" class="reportreview">리뷰글</a>
                        </div>
                    </div>
                </div>
                <div id="contentdiv">
                    
                </div>
                <div style="padding:50px 16px" id="boarddiv">
                    <h3>커뮤니티 글</h3>
                    <div>Hover over the "about", "services" or "partners" link to see the sub navigation menu.</div>
                </div>
                <div style="padding:50px 16px" id="useddiv">
                    <h3>중고 글</h3>
                    <div>Hover over the "about", "services" or "partners" link to see the sub navigation menu.</div>
                </div>
                <div style="padding:50px 16px" id="comtdiv">
                    <h3>커뮤니티 댓글</h3>
                    <div>Hover over the "about", "services" or "partners" link to see the sub navigation menu.</div>
                </div>
                <div style="padding:50px 16px" id="reviewdiv">
                    <h3>리뷰 글</h3>
                    <div>Hover over the "about", "services" or "partners" link to see the sub navigation menu.</div>
                </div>
                <div style="padding:50px 16px" id="reportboarddiv">
                    <h3>커뮤니티 신고글</h3>
                    <div>Hover over the "about", "services" or "partners" link to see the sub navigation menu.</div>
                </div>
                <div style="padding:50px 16px" id="reportuseddiv">
                    <h3>중고 신고글</h3>
                    <div>Hover over the "about", "services" or "partners" link to see the sub navigation menu.</div>
                </div>
                <div style="padding:50px 16px" id="reportcomtdiv">
                    <h3>커뮤니티 신고댓글</h3>
                    <div>Hover over the "about", "services" or "partners" link to see the sub navigation menu.</div>
                </div>
                <div style="padding:50px 16px" id="reportreviewdiv">
                    <h3>리뷰 신고글</h3>
                    <div>Hover over the "about", "services" or "partners" link to see the sub navigation menu.</div>
                </div>
            </div>
        </div>
    </section>
</body>
</html>