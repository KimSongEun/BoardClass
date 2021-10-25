<%@page import="kh.semi.boardclass.admin.model.vo.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    ArrayList<Notice> volist=(ArrayList<Notice>)request.getAttribute("noticevolist");
	int startPage = (int)request.getAttribute("startPage");
	int endPage = (int)request.getAttribute("endPage");
	int pageCount = (int)request.getAttribute("pageCount");
	%>
<!DOCTYPE html>
<%@page import="kh.semi.boardclass.admin.model.vo.Notice"%>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="./css/admin/main/adminHeader.css"/> 
    <link rel="stylesheet" href="./css/admin/notice/adminNotice.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="./js/admin/notice/adminNotice.js?"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>  
    <link rel="icon" href="./img/dicedice.ico" type="image/x-icon" sizes="16x16">
    <title>공지사항 조회</title>
</head>

<body>
    <%@include file="/WEB-INF/admin/main/adminHeader.jsp" %>
    <header></header>
     <section>
        <div class="admin-notice-section">
            <div class="admin-notice-div">
                <div class="admin-notice-title"> 📋 공지사항 조회 📋</div>
                <table class="admin-notice-search">
                	<tr>
                	<td>
                	<form action = "noticesearch" method = "post">
                    <select class="admin-notice-search-select">
                        <option>공지 제목 </option>
                    </select>
                    <input type="text" class="admin-notice-search-input" name = "keyword" id = "keyword" value="${keyword }">
                    <input type="submit" value="검색" class="admin-notice-search-button">
                    </form>
                    </td>
                    <td style = "text-align : right; font-size : 15px">
                                             표시글 개수 : <select style = "height : 30px" name = "selectno" id = "selectno" onchange = "window.open(value, '_self');">
                    	<option value = "noticelist?viewcount=10" <c:if test = "${viewcount == 10}"> selected </c:if>>10</option>
                    	<option value = "noticelist?viewcount=20" <c:if test = "${viewcount == 20}"> selected </c:if>>20</option>
                    	<option value = "noticelist?viewcount=50" <c:if test = "${viewcount == 50}"> selected </c:if>>50</option>
                    </select>
                    </td>
                    </tr>
                </table>

                <div class="admin-notice-table-div">
                    <table class="table table-striped admin-notice-table" style="text-align: center;">
                        <tr style="text-align:center; font-size: 16px; font-weight: bold;">
                            <td>글번호</td>
                            <td style="width : 200px;">글제목</td>
                            <td>최초 작성일</td>
                            <td>최종 수정일</td>
                            <td>수정 </td>
                            <td>삭제 </td>
                        </tr>
                        <%if(volist !=null){
						 for(Notice n : volist){ %> 
                        <tr>
                            <td style = "vertical-align : middle"><%=n.getAnnounceNo() %></td>
                            <td style = "vertical-align : middle;white-space : nowrap; text-overflow : ellipsis; overflow : hidden"><a href = "cnoticedetail?announceNo=<%=n.getAnnounceNo() %>" target="_blank" style = "color : #754100" title = "<%=n.getAdminTitle() %>" target = '_blank' style = "color : #754100" title = "<%=n.getAdminTitle() %>"> <%=n.getAdminTitle() %></a></td>
                            <td style = "vertical-align : middle"><%=n.getAdminWrDate() %></td>
                            <td style = "vertical-align : middle"><%=n.getAdminRwrDate() %></td>
                            <td style = "vertical-align : middle"><button class="update btn btn-danger" value="updatego" no="<%=n.getAnnounceNo()%>">글수정 </button> </td>
                            <td style = "vertical-align : middle"><button class="delete btn btn-primary" value="deletego" id="<%=n.getAnnounceNo() %>">글삭제</button> </td>
                        </tr>
                         <%} }%> 
                         <tr>
                         	<td colspan = "6"> <button type="button" class="insert btn btn-primary"
                    style="float: right; background-color: #285226; color: #EAEAEA; border-radius: 5px;">📋 공지사항작성 📋</button></td>
                         </tr>
                    </table>
                </div>
            <div class="admin-notice-page-nav">
            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center">
                <% if(startPage == 1) {%>
                	<li class="page-item-previous disabled">
                	<%} else { %>
                  <li class="page-item-previous">
                  <% }%>
                    <a class="page-link" href="noticelist?pagenum=${startPage-1}&viewcount=${viewcount}" aria-label="Previous">
                      <span aria-hidden="true">&laquo;</span>
                    </a>
                  </li>
  				<%for (int i = startPage; i <= endPage; i++) {%>
				<li class="page-item"><a class="page-link" href="noticelist?pagenum=<%=i%>&viewcount=${viewcount}"><%=i%></a></li>
				<%} if(endPage == pageCount){%>
				<li class="page-item-next disabled">
				<%}else{ %>
                  <li class="page-item-next">
                  <% }%>
                    <a class="page-link" href="noticelist?pagenum=${endPage+1}&viewcount=${viewcount}" aria-label="Next">
                      <span aria-hidden="true">&raquo;</span>
                    </a>
                  </li>
                </ul>
              </nav>
            </div>
        </div>
        </div>
    </section>
</body>

</html>