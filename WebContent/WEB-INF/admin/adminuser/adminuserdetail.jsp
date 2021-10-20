<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="./css/admin/main/adminHeader.css"/> 
	<link rel="stylesheet" href="./css/admin/adminuser/adminUserDetail.css?after"/>
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
                        <p>&nbsp;&nbsp;&nbsp;&nbsp; <span style = "color : grey">회원번호 : </span>${uservo.userNo}</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp; <span style = "color : grey">아이디 : </span>${uservo.userId}</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp; <span style = "color : grey">이메일 : </span>${uservo.userEmail}</p>
                        <p>&nbsp;&nbsp;&nbsp;&nbsp; <span style = "color : grey">주소 : </span>${uservo.userAddress}</p>
                        
                        <div style = "text-align : right; margin-right : 20px;"><button class = "btn danger memberdelete" id = "${uservo.userId}">탈퇴처리하기</button></div>
                    </div>
                    
                </div>

                <div class="navbar">
                    <div class="subnav">
                        <button class="subnavbtn">작성글 <i class="fa fa-caret-down"></i></button>
                        <div class="subnav-content">
                            <a href="#" class="board" id = "${uservo.userId}">커뮤니티글</a>
                            <a href="#" class = "used" id = "${uservo.userId}">중고거래글</a>
                        </div>
                    </div>
                    <div class="subnav">
                        <button class="subnavbtn">작성댓글 <i class="fa fa-caret-down"></i></button>
                        <div class="subnav-content">
                            <a href="#"></a>
                            <a href="#" class="comt" id = "${uservo.userId}">커뮤니티댓글</a>
                            <a href="#" class="review" id = "${uservo.userId}">리뷰글</a>
                        </div>
                    </div>
                    <div class="subnav">
                        <button class="subnavbtn">신고된 글 <i class="fa fa-caret-down"></i></button>
                        <div class="subnav-content">
                        	<a href="#"></a>
                        	<a href="#"></a>
                            <a href="#" class="reportboard" id = "${uservo.userId}">커뮤니티글</a>
                            <a href="#" class="reportused" id = "${uservo.userId}">중고거래글</a>
                        </div>
                    </div>
                    <div class="subnav">
                        <button class="subnavbtn">신고된 댓글 <i class="fa fa-caret-down"></i></button>
                        <div class="subnav-content">
                        	<a href="#"></a>
                        	<a href="#"></a>       
                        	<a href="#"></a>       
                            <a href="#" class="reportcomt" id = "${uservo.userId}">커뮤니티댓글</a>
                            <a href="#" class="reportreview" id = "${uservo.userId}">리뷰글</a>
                        </div>
                    </div>
                </div>
                <div id="contentdiv">
                    
                </div>
                <div style="padding:50px 16px" id="boarddiv">
                    <h1>커뮤니티 글</h1>
                    <div class="admin-table-div" style = "text-align : center">
						<table style="text-align: center; border : 1px solid black">
						<thead>
                        <tr style="text-align:center; font-size: 16px;">
                        	<td>글번호</td>
                            <td>게시판 카테고리</td>
                            <td>게시판 타입</td>
                            <td>글제목</td>
                            <td>글내용</td>
                            <td>글작성일 </td>
                        </tr>
                        </thead>
                         <tbody id="input_data"></tbody>
                         <tr>
                        </tr> 
                    </table>
					</div>
                </div>
                <div style="padding:50px 16px" id="useddiv">
                    <h3>중고 글</h3>
                     <div class="admin-table-div" style = "text-align : center">
						<table style="text-align: center; border : 1px solid black">
						<thead>
                        <tr style="text-align:center; font-size: 16px;">
                        	<td>중고글번호</td>
                            <td>중고글제목</td>
                            <td>상품상태</td>
                            <td>교환여부</td>
                            <td>거래방법</td>
                            <td>상품가격 </td>
                            <td>카테고리 </td>
                        </tr>
                        </thead>
                         <tbody id="input_data"></tbody>
                         <tr>
                        </tr> 
                    </table>
					</div>
                </div>
                <div style="padding:50px 16px" id="comtdiv">
                    <h3>커뮤니티 댓글</h3>
                    <div class="admin-table-div" style = "text-align : center">
						<table style="text-align: center; border : 1px solid black">
						<thead>
                        <tr style="text-align:center; font-size: 16px;">
                        	<td>댓글 번호</td>
                            <td>원본 글 제목</td>
                            <td>댓글</td>
                            <td>작성일</td>
                        </tr>
                        </thead>
                         <tbody id="input_data"></tbody>
                         <tr>
                        </tr> 
                    </table>
					</div>
                </div>
                <div style="padding:50px 16px" id="reviewdiv">
                    <h3>리뷰 글</h3>
                    <div class="admin-table-div" style = "text-align : center">
						<table style="text-align: center; border : 1px solid black">
						<thead>
                        <tr style="text-align:center; font-size: 16px;">
                        	<td>리뷰 번호</td>
                            <td>리뷰가 달린 게임 명</td>
                            <td>리뷰 내용</td>
                            <td>작성일</td>
                        </tr>
                        </thead>
                         <tbody id="input_data"></tbody>
                         <tr>
                        </tr> 
                    </table>
					</div>
                </div>
                <div style="padding:50px 16px" id="reportboarddiv">
                    <h3>커뮤니티 신고글</h3>
                  <div class="admin-table-div" style = "text-align : center">
						<table style="text-align: center; border : 1px solid black">
						<thead>
                        <tr style="text-align:center; font-size: 16px;">
                        	<td>신고횟수</td>
                        	<td>글번호</td>
                            <td>게시판 카테고리</td>
                            <td>게시판 타입</td>
                            <td>글제목</td>
                            <td>글작성일 </td>
                            <td>삭제 </td>
                        </tr>
                        </thead>
                         <tbody id="input_data"></tbody>
                         <tr>
                        </tr> 
                    </table>
					</div>                    
                </div>
                <div style="padding:50px 16px" id="reportuseddiv">
                    <h3>중고 신고글</h3>
                     <div class="admin-table-div" style = "text-align : center">
						<table style="text-align: center; border : 1px solid black">
						<thead>
                        <tr style="text-align:center; font-size: 16px;">
                        	<td>신고횟수</td>
                        	<td>중고글번호</td>
                            <td>중고글제목</td>
                            <td>상품상태</td>
                            <td>교환여부</td>
                            <td>거래방법</td>
                            <td>상품가격 </td>
                            <td>카테고리 </td>
                            <td>삭제 </td>
                        </tr>
                        </thead>
                         <tbody id="input_data"></tbody>
                         <tr>
                        </tr> 
                    </table>
					</div>                    
                </div>
                <div style="padding:50px 16px" id="reportcomtdiv">
                    <h3>커뮤니티 신고댓글</h3>
                    <div class="admin-table-div" style = "text-align : center">
						<table style="text-align: center; border : 1px solid black">
						<thead>
                        <tr style="text-align:center; font-size: 16px;">
                        	<td>신고횟수</td>
                        	<td>댓글 번호</td>
                            <td>원본 글 제목</td>
                            <td>댓글</td>
                            <td>작성일</td>
							<td>삭제 </td>                            
                        </tr>
                        </thead>
                         <tbody id="input_data"></tbody>
                         <tr>
                        </tr> 
                    </table>
					</div>                    
                </div>
                <div style="padding:50px 16px" id="reportreviewdiv">
                    <h3>리뷰 신고글</h3>
                    <div class="admin-table-div" style = "text-align : center">
						<table style="text-align: center; border : 1px solid black">
						<thead>
                        <tr style="text-align:center; font-size: 16px;">
                        	<td>신고횟수</td>
                        	<td>리뷰 번호</td>
                            <td>리뷰가 달린 게임 명</td>
                            <td>리뷰 내용</td>
                            <td>작성일</td>
                            <td>삭제 </td> 
                        </tr>
                        </thead>
                         <tbody id="input_data"></tbody>
                         <tr>
                        </tr> 
                    </table>
					</div>                    
                </div>
            </div>
        </div>
    </section>
</body>
</html>