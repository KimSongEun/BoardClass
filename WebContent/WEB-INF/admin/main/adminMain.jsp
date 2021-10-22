<%@page import="kh.semi.boardclass.admin.model.vo.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%
    ArrayList<Notice> noticevolist=(ArrayList<Notice>)request.getAttribute("noticevolist");
	%>
	<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>관리자 페이지</title>
<link rel="stylesheet" href="./css/admin/main/adminHeader.css"/> 
<link rel="stylesheet" href="./css/admin/main/adminMain.css" />
   <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
   <script type="text/javascript" src="./js/admin/main/adminMain.js"></script>
</head>
<body>
	<%@include file="/WEB-INF/admin/main/adminHeader.jsp" %>
	<header></header>
    <section>
        <div class="admin-main-section">
            <div class="admin-main-title">😊 admin님 방문을 환영합니다. 😊</div>

            <div class="admin-count-div">
                <div class="admin-count-allmember-div">
                    <table class="admin-count-table">
                        <tr>
                            <td style="text-align:center; font-size: 18px; font-weight: bold;">총 회원수</td>
                        </tr>
                        <tr>
                            <td style="text-align:center; font-size: 18px; font-weight: bold;">0</td>
                        </tr>
                    </table>
                </div>
                <div class="admin-count-todayvisit-div">
                    <table class="admin-count-table">
                        <tr>
                            <td style="text-align:center; font-size: 18px; font-weight: bold;">일일 방문횟수</td>
                        </tr>
                        <tr>
                            <td style="text-align:center; font-size: 18px; font-weight: bold;">0</td>
                        </tr>
                    </table>
                </div>
                <div class="admin-count-monthvisit-div">
                    <table class="admin-count-table">
                        <tr>
                            <td style="text-align:center; font-size: 18px; font-weight: bold;">월간 방문횟수</td>
                        </tr>
                        <tr>
                            <td style="text-align:center; font-size: 18px; font-weight: bold;">0</td>
                        </tr>
                    </table>
                </div>
                <div class="admin-count-todayboard-div">
                    <table class="admin-count-table">
                        <tr>
                            <td style="text-align:center; font-size: 18px; font-weight: bold;">일일 등록글 수</td>
                        </tr>
                        <tr>
                            <td style="text-align:center; font-size: 18px; font-weight: bold;">0</td>
                        </tr>
                    </table>
                </div>
            </div>

            <div class="admin-report-div">

                <div class="admin-report-board-table-div" style="margin:0 auto;">
                    <table class="table table-hover admin-report-board-table" style="text-align: center; width : 550px">
                    <colgroup>
	                   	<col width="100px">
	                   	<col width="110px">
	                   	<col width="120px">
	                   	<col width="120px">
	                   	<col width="100px">
                   	</colgroup>
                        <thead>
                            <tr>
                                <td colspan="5" class="table-active"
                                    style="text-align:center; font-size: 18px; font-weight: bold; background-color: #dedfe0;">신고 된 글 리스트
                                </td>
                            </tr>
                        </thead>
                        <tr style="text-align:center; font-size: 16px; font-weight: bold;">
                            <td>신고 횟수</td>
                            <td>게시글 번호</td>
                            <td>게시글 제목</td>
                            <td>아이디</td>
                            <td>삭제</td>
                        </tr>
                        <c:if test = "${reportboardvolist !=null}">
                        <c:forEach items = "${reportboardvolist}" var = "rb">
                        <tr>
                            <td style = "color : #f55354">${rb.reportCount}</td>
                            <td>${rb.boardNo}</td>
                            <td style="white-space : nowrap; text-overflow : ellipsis; overflow : hidden"><a href="#글내용조회" style = "color : #754100" title="${rb.boardTitle}">${rb.boardTitle}</a></td>
                            <td><a href="#회원정보조회" style = "color : #754100">${rb.userId}</a></td>
                            <td><button class="deleteboard btn btn-primary" value="deletego" id = "${rb.boardNo}">삭제</button></td>
                        </tr>
                        </c:forEach>
                        </c:if>
                    </table>
                </div>

                <div class="admin-report-comment-table-div" style="margin:0 auto;">
                    <table class="table table-hover admin-report-comment-table" style="text-align: center; width : 550px">
                    <colgroup>
	                   	<col width="100px">
	                   	<col width="110px">
	                   	<col width="120px">
	                   	<col width="120px">
	                   	<col width="100px">
                   	</colgroup>                    
                        <thead>
                            <tr>
                                <td colspan="5" style="text-align:center; font-size: 18px; font-weight: bold;  background-color: #dedfe0;">신고 된 댓글
                                    리스트
                                </td>
                            </tr>
                        </thead>
                        <tr style="text-align:center; font-size: 16px; font-weight: bold;">
                            <td>신고 횟수</td>
                            <td>댓글 번호</td>
                            <td>댓글 내용</td>
                            <td>아이디</td>
                            <td>삭제</td>
                        </tr>
                        <c:if test = "${reportcommentvolist !=null}">
                        <c:forEach items = "${reportcommentvolist}" var = "rc">
                        <tr>
                            <td style = "color : #f55354">${rc.reportCount}</td>
                            <td>${rc.commentNo}</td>
                            <td style = "vertical-align : middle; white-space : nowrap; text-overflow : ellipsis; overflow : hidden" ><a href="#댓글내용" class = "comment-modal" id = "${rc.commentNo}" style = "color : #754100">${rc.commentContent}</a></td>
                            <td><a href="#회원정보조회" style = "color : #754100">${rc.userId}</a></td>
                            <td><button class="deletecomment btn btn-primary" value="deletego" id = "${rc.commentNo}">삭제</button></td>
                        </tr>
								<!-- The Modal -->
								<div id="myModal" class="modal">

									<!-- Modal content -->
									<div class="modal-content">
										<span class="close">&times;</span>
										<h3 style = "color : gray">댓글 내용 상세보기</h3>
										<br>
										<p id = "modal-content-detail"></p>
									</div>

								</div>                        
                        </c:forEach>
                        </c:if>
                    </table>
                </div>
            </div>
            
                        <div class="admin-report-div">

                <div class="admin-report-board-table-div" style="margin:0 auto;">
                    <table class="table table-hover admin-report-board-table" style="text-align: center; width : 550px">
                    <colgroup>
	                   	<col width="100px">
	                   	<col width="110px">
	                   	<col width="120px">
	                   	<col width="120px">
	                   	<col width="100px">
                   	</colgroup>                    
                        <thead>
                            <tr>
                                <td colspan="5" class="table-active"
                                    style="text-align:center; font-size: 18px; font-weight: bold; background-color: #dedfe0;">신고 된 리뷰 리스트
                                </td>
                            </tr>
                        </thead>
                        <tr style="text-align:center; font-size: 16px; font-weight: bold;">
                            <td>신고 횟수</td>
                            <td>리뷰 번호</td>
                            <td>리뷰 내용</td>
                            <td>아이디</td>
                            <td>삭제</td>
                        </tr>
                        <c:if test = "${reportreviewvolist !=null}">
                        <c:forEach items = "${reportreviewvolist}" var = "rr">
                        <tr>
                            <td style = "color : #f55354">${rr.reportCount}</td>
                            <td>${rr.reviewNo}</td>
                            <td style = "vertical-align : middle; white-space : nowrap; text-overflow : ellipsis; overflow : hidden" ><a href="#리뷰내용" class = "reviewmodal" id = "${rr.reviewNo}" style = "color : #754100">${rr.reviewContent}</a></td>
                            <td><a href="#회원정보조회" style = "color : #754100">${rr.userId}</a></td>
                            <td><button class="deletereview btn btn-primary" value="deletego" id = "${rr.reviewNo}">삭제</button></td>
                        </tr>
								<!-- The Modal -->
								<div id="myReviewModal" class="review-modal">

									<!-- Modal content -->
									<div class="modal-review-content">
										<span class="reviewclose">&times;</span>
										<h3 style = "color : gray">리뷰 내용 상세보기</h3>
										<br>
										<p id = "modal-review-content-detail"></p>
									</div>

								</div>                        
                        </c:forEach>
                        </c:if>
                    </table>
                </div>

                <div class="admin-report-comment-table-div" style="margin:0 auto;">
                    <table class="table table-hover admin-report-comment-table" style="text-align: center; width : 550px">
                    <colgroup>
	                   	<col width="100px">
	                   	<col width="110px">
	                   	<col width="120px">
	                   	<col width="120px">
	                   	<col width="100px">
                   	</colgroup>                    
                        <thead>
                            <tr>
                                <td colspan="5" style="text-align:center; font-size: 18px; font-weight: bold;  background-color: #dedfe0;">신고 된 중고글
                                    리스트
                                </td>
                            </tr>
                        </thead>
                        <tr style="text-align:center; font-size: 16px; font-weight: bold;">
                            <td>신고 횟수</td>
                            <td>중고글 번호</td>
                            <td>중고글 제목</td>
                            <td>아이디</td>
                            <td>삭제</td>
                        </tr>
                        <c:if test = "${reportusedvolist !=null}">
                        <c:forEach items = "${reportusedvolist}" var = "ru">
                        <tr>
                            <td style = "color : #f55354">${ru.reportCount}</td>
                            <td>${ru.usedNo}</td>
                            <td style = "vertical-align : middle; white-space : nowrap; text-overflow : ellipsis; overflow : hidden" ><a href="#중고글조회" id = "${ru.usedNo}" style = "color : #754100" title = "${ru.usedTitle}">${ru.usedTitle}</a></td>
                            <td><a href="#회원정보조회" style = "color : #754100">${ru.userId}</a></td>
                            <td><button class="deleteused btn btn-primary" value="deletego" id = "${ru.usedNo}">삭제</button></td>
                        </tr>
                        </c:forEach>
                        </c:if>
                    </table>
                </div>
            </div>
            
            <div class="admin-notice-div" style="margin:0 auto;">
                <table class="table table-hover admin-notice-table" style="text-align: center; width : 600px">
                    <colgroup>
	                   	<col width="100px">
	                   	<col width="300px">
	                   	<col width="200px">
                   	</colgroup>                  
                    <thead>
                        <tr>
                            <td colspan="3" style="text-align:center; font-size: 18px; font-weight: bold; background-color: #dedfe0;">공지사항</td>
                        </tr>
                    </thead>
                    <tr style="text-align:center; font-size: 16px; font-weight: bold;">
                        <td style="width : 100px">공지 번호</td>
                        <td>공지 제목</td>
                        <td>공지 작성일</td>
                    </tr>
                        <%if(noticevolist !=null){
						 for(Notice n : noticevolist){ %> 
                    <tr>
                        <td><%=n.getAnnounceNo() %></td>
                        <td style="white-space : nowrap; text-overflow : ellipsis; overflow : hidden""><a href="#공지가항보러가깅" style = "color : #754100" title = "<%=n.getAdminTitle() %>"><%=n.getAdminTitle() %></a></td>
                        <td><%=n.getAdminRwrDate() %></td>
                    </tr>
                   <%} }%> 
                </table>
            </div>
        </div>
    </section>
</body>
</html>