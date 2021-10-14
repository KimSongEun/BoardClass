<%@page import="kh.semi.boardclass.admin.model.vo.AllBoardUser"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%
        ArrayList<AllBoardUser> volist=(ArrayList<AllBoardUser>)request.getAttribute("allboarduservolist");
	int startPage = (int)request.getAttribute("startPage");
	int endPage = (int)request.getAttribute("endPage");
	int pageCount = (int)request.getAttribute("pageCount");
	%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="./css/admin/main/adminHeader.css"/> 
    <link rel="stylesheet" href="./css/admin/allboard/adminAllBoard.css?"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="./js/admin/boardgame/adminBoardGame.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>  
    <title>전체글 목록</title>
</head>

<body>
    <%@include file="/WEB-INF/admin/main/adminHeader.jsp" %>
    <header></header>
     <section>
        <div class="admin-allboard-section">
            <div class="admin-allboard-div">
                <div class="admin-allboard-title">게시판👉🏻전체글목록</div>
                <table class="admin-allboard-search">
                <tr>
                	<td>
                    <select class="admin-allboard-search-select">
                        <option>작성자아이디 </option>
                        <option>작성자 회원번호</option>
                        <option>글제목</option>
                    </select>
                    <input type="text" class="admin-allboard-search-input">
                    <input type="button" value="검색" class="admin-allboard-search-button">
                    </td>
                    
                    <td style = "text-align : right; font-size : 15px">
                    	표시글 개수 : <select style = "height : 30px" name = "selectno" id = "selectno" onchange = "window.open(value, '_self');">
                    	<option value = "allboardlist?viewcount=10" <c:if test = "${viewcount == 10}"> selected </c:if>>10</option>
                    	<option value = "allboardlist?viewcount=20" <c:if test = "${viewcount == 20}"> selected </c:if>>20</option>
                    	<option value = "allboardlist?viewcount=50" <c:if test = "${viewcount == 50}"> selected </c:if>>50</option>
                    </select>
                    </td>
                    </tr>
                </table>

                <div class="admin-allboard-table-div">
                    <table class="table table-striped admin-allboard-table" style="text-align: center;">
                        <tr style="text-align:center; font-size: 16px; font-weight: bold;">
                            <td>게시판 카테고리</td>
                            <td>게시판 타입</td>
                            <td>글제목</td>
                            <td>작성자아이디</td>
                            <td>작성자회원번호 </td>
                            <td>글작성일 </td>
                            <td>수정 </td>
                            <td>삭제 </td>
                            
                        </tr>
                         <%if(volist !=null){
						 for(AllBoardUser g : volist){ %> 
<%--                         <c:if test = "${allboarduservolist != null}">
                        <c:forEach items = "${allboarduservolist}" var="b" > --%>
                        <tr>
                            <td style = "vertical-align : middle"><%=g.getBoardCategory() %></td>
                            <td style = "vertical-align : middle"><%=g.getBoardType() %></td>
                            <td style = "vertical-align : middle"><%=g.getBoardTitle() %></td>
                            <td style = "vertical-align : middle"><%=g.getUserId() %></td>
                            <td style = "vertical-align : middle"><%=g.getUserNo() %></td>
                            <td style = "vertical-align : middle"><%=g.getBoardRewriteDate() %></td>
                            <td style = "vertical-align : middle"><button class="update btn btn-danger" value="updatego">수정</button> </td>
                            <td style = "vertical-align : middle"><button class="delete btn btn-primary" value="deletego" id="<%=g.getBoardNo() %>">삭제</button> </td>
                        </tr>
<%--                         </c:forEach>
                         </c:if> --%>
                          <%} }%> 
                    </table>
                </div>

            <div class="admin-allboard-page-nav">
            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center">
                <% if(startPage == 1) {%>
                	<li class="page-item-previous disabled">
                	<%} else { %>
                  <li class="page-item-previous">
                  <% }%>
                    <a class="page-link" href="boardgamelist?pagenum=${startPage-1}&viewcount=${viewcount}" aria-label="Previous">
                      <span aria-hidden="true">&laquo;</span>
                    </a>
                  </li>
  	<%for (int i = startPage; i <= endPage; i++) {%>
		<li class="page-item"><a class="page-link" href="boardgamelist?pagenum=<%=i%>&viewcount=${viewcount}"><%=i%></a></li>
		<%} if(endPage == pageCount){%>
		<li class="page-item-next disabled">
		<%}else{ %>
                  <li class="page-item-next">
                  <% }%>
                    <a class="page-link" href="boardgamelist?pagenum=${endPage+1}&viewcount=${viewcount}" aria-label="Next">
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