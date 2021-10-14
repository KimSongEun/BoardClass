<%@page import="kh.semi.boardclass.game.model.vo.Game"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    ArrayList<Game> volist=(ArrayList<Game>)request.getAttribute("gamevolist");
	int startPage = (int)request.getAttribute("startPage");
	int endPage = (int)request.getAttribute("endPage");
	int pageCount = (int)request.getAttribute("pageCount");
	%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="./css/admin/main/adminHeader.css"/> 
    <link rel="stylesheet" href="./css/admin/boardgame/adminBoardGame.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="./js/admin/boardgame/adminBoardGame.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>  
    <title>보드게임 조회</title>
</head>

<body>
    <%@include file="/WEB-INF/admin/main/adminHeader.jsp" %>
    <header></header>
     <section>
        <div class="admin-boardgame-section">
            <div class="admin-boardgame-div">
                <div class="admin-boardgame-title">보드게임 조회</div>
                <table class="admin-boardgame-search">
                <tr>
                	<td>
                    <select class="admin-boardgame-search-select">
                        <option>게임명 </option>
                    </select>
                    <input type="text" class="admin-boardgame-search-input">
                    <input type="button" value="검색" class="admin-boardgame-search-button">
                    </td>
                    
                    <td style = "text-align : right; font-size : 15px">
                    	표시글 개수 : <select style = "height : 30px" name = "selectno" id = "selectno" onchange = "window.open(value, '_self');">
                    	<option value = "boardgamelist?viewcount=10" <c:if test = "${viewcount == 10}"> selected </c:if>>10</option>
                    	<option value = "boardgamelist?viewcount=20" <c:if test = "${viewcount == 20}"> selected </c:if>>20</option>
                    	<option value = "boardgamelist?viewcount=50" <c:if test = "${viewcount == 50}"> selected </c:if>>50</option>
                    </select>
                    </td>
                    </tr>
                </table>

                <div class="admin-boardgame-table-div">
                    <table class="table table-striped admin-boardgame-table" style="text-align: center;">
                        <tr style="text-align:center; font-size: 16px; font-weight: bold;">
                            <td style = "width : 80px">글번호</td>
                            <td style = "width : 120px">보드게임 분류</td>
                            <td style = "width : 250px">한글상품명</td>
                            <td style = "width : 250px">영어상품명</td>
                            <td style = "width : 100px">수정 </td>
                            <td style = "width : 100px">삭제 </td>
                        </tr>
                        <%if(volist !=null){
						 for(Game g : volist){ %> 
                        <tr>
                            <td style = "vertical-align : middle"><%=g.getGameNumber() %></td>
                            <td style = "vertical-align : middle"><%=g.getGameCategory() %></td>
                            <td style = "vertical-align : middle; white-space : nowrap; text-overflow : ellipsis; overflow : hidden"><a href = #사용자가보는게임화면새창열기 target = '_blank'> <%=g.getGameKoName() %></a></td>
                            <td style = "vertical-align : middle; white-space : nowrap; text-overflow : ellipsis; overflow : hidden"><a href = #사용자가보는게임화면새창열기 target = '_blank'><%=g.getGameEnName() %></a></td>
                            <td style = "vertical-align : middle"><button class="update btn btn-danger" value="updatego" no="<%=g.getGameNumber()%>">게임수정</button> </td>
                            <td style = "vertical-align : middle"><button class="delete btn btn-primary" value="deletego" id="<%=g.getGameNumber() %>">게임삭제</button> </td>
                        </tr>
                         <%} }%> 
                         <tr>
                          <td colspan = "6"><button type="button" class="insert btn btn-primary"
                    style="float : right; background-color: #285226; color: #EAEAEA; border-radius: 5px;">게임작성</button></td>
                    </tr>
                    </table>
                </div>

            <div class="admin-boardgame-page-nav">
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