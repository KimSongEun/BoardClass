<%@page import="kh.semi.boardclass.admin.model.vo.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
    ArrayList<Notice> volist=(ArrayList<Notice>)request.getAttribute("noticevolist");
	%>
	<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>관리자 페이지</title>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<link rel="stylesheet" href="./css/admin/main/adminMain.css" />
</head>
<body>
	<%@include file="/WEB-INF/admin/main/adminHeader.jsp" %>
    <section>
        <div class="admin-main-section">
            <div class="admin-main-title">admin님 방문을 환영합니다.</div>

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
                    <table class="table table-hover admin-report-board-table" style="text-align: center;">
                        <thead>
                            <tr>
                                <td colspan="3" class="table-active"
                                    style="text-align:center; font-size: 18px; font-weight: bold; background-color: #dedfe0;">신고 된 글 리스트
                                </td>
                            </tr>
                        </thead>
                        <tr style="text-align:center; font-size: 16px; font-weight: bold;">
                            <td style="width : 100px">신고 번호</td>
                            <td>신고된 글 제목</td>
                            <td>아이디</td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>예시 글 제목</td>
                            <td>예시 아이디</td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>예시 글 제목</td>
                            <td>예시 아이디</td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>예시 글 제목</td>
                            <td>예시 아이디</td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>예시 글 제목</td>
                            <td>예시 아이디</td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>예시 글 제목</td>
                            <td>예시 아이디</td>
                        </tr>
                    </table>
                </div>

                <div class="admin-report-comment-table-div" style="margin:0 auto;">
                    <table class="table table-hover admin-report-comment-table" style="text-align: center;">
                        <thead>
                            <tr>
                                <td colspan="3" style="text-align:center; font-size: 18px; font-weight: bold;  background-color: #dedfe0;">신고 된 댓글
                                    리스트
                                </td>
                            </tr>
                        </thead>
                        <tr style="text-align:center; font-size: 16px; font-weight: bold;">
                            <td style="width : 100px">신고 번호</td>
                            <td>댓글 내용</td>
                            <td>아이디</td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>예시 댓글 내용</td>
                            <td>예시 아이디</td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>예시 댓글 내용</td>
                            <td>예시 아이디</td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>예시 댓글 내용</td>
                            <td>예시 아이디</td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>예시 댓글 내용</td>
                            <td>예시 아이디</td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>예시 댓글 내용</td>
                            <td>예시 아이디</td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="admin-notice-div" style="margin:0 auto;">
                <table class="table table-hover admin-notice-table" style="text-align: center;">
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
                        <%if(volist !=null){
						 for(Notice n : volist){ %> 
                    <tr>
                        <td><%=n.getAnnounceNo() %></td>
                        <td><%=n.getAdminTitle() %></td>
                        <td><%=n.getAdminRwrDate() %></td>
                    </tr>
                   <%} }%> 
                </table>
            </div>
        </div>
    </section>
</body>
</html>