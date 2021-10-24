<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="./css/admin/main/adminHeader.css"/> 
    <link rel="stylesheet" href="./css/admin/reportboard/adminReportBoard.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="./js/admin/reportboard/adminReportBoard.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>  
    <title>신고 게시글 목록</title>
</head>

<body>
    <%@include file="/WEB-INF/admin/main/adminHeader.jsp" %>
    <header></header>
     <section>
        <div class="admin-reportboard-section">
            <div class="admin-reportboard-div">
                <div class="admin-reportboard-title">회원관리👉🏻신고된 글</div>
                <table class="admin-reportboard-search">
                <tr>
                	<td>
                	<form action = "reportboarduseridsearch" method = "post" class = "searchselect">
                    <select class="admin-reportboard-search-select" name = "type">
                        <option value ="작성자아이디" <c:if test = "${type == '작성자아이디'}"> selected </c:if>>작성자아이디 </option>
                        <option value ="작성자 회원번호" <c:if test = "${type == '작성자 회원번호'}"> selected </c:if>>작성자 회원번호</option>
                    </select>
                    <input type="text" class="admin-reportboard-search-input" name = "keyword" id = "keyword" value="${keyword }">
                    <button type="submit" class="admin-reportboard-search-button">검색</button>
                    </form>
                    </td>
                    <td style = "text-align : right; font-size : 15px; ">
                    	정렬기준 : <select style = "height : 30px" name = "selectno" id = "selectno" onchange = "window.open(value, '_self');">
                    	<option value = "reportboardlist" <c:if test = "${selectno == 'reportboardlist'}"> selected </c:if>>신고횟수 많은 순</option>
                    	<option value = "reportboardasclist" <c:if test = "${selectno == 'reportboardasclist'}"> selected </c:if>>신고횟수 적은 순</option>
                    </select>
                    </td>
                    <td style = "text-align : right; font-size : 15px; width : 160px">
                    	|| 표시글 개수 : <select style = "height : 30px" name = "selectno" id = "selectno" onchange = "window.open(value, '_self');">
                    	<c:if test = "${empty selectno}">
                    	<option value = "reportboardlist?viewcount=10" <c:if test = "${viewcount == 10}"> selected </c:if>>10</option>
                    	<option value = "reportboardlist?viewcount=20" <c:if test = "${viewcount == 20}"> selected </c:if>>20</option>
                    	<option value = "reportboardlist?viewcount=50" <c:if test = "${viewcount == 50}"> selected </c:if>>50</option>
                    	</c:if>
                    	<c:if test = "${selectno == 'reportboardlist'}">
                    	<option value = "reportboardlist?viewcount=10" <c:if test = "${viewcount == 10}"> selected </c:if>>10</option>
                    	<option value = "reportboardlist?viewcount=20" <c:if test = "${viewcount == 20}"> selected </c:if>>20</option>
                    	<option value = "reportboardlist?viewcount=50" <c:if test = "${viewcount == 50}"> selected </c:if>>50</option>
                    	</c:if>
                    	<c:if test = "${selectno == 'reportboardasclist'}">
                    	<option value = "reportboardasclist?viewcount=10" <c:if test = "${viewcount == 10}"> selected </c:if>>10</option>
                    	<option value = "reportboardasclist?viewcount=20" <c:if test = "${viewcount == 20}"> selected </c:if>>20</option>
                    	<option value = "reportboardasclist?viewcount=50" <c:if test = "${viewcount == 50}"> selected </c:if>>50</option>
                    	</c:if>
                    </select>
                    </td>
                    </tr>
                </table>

                <div class="admin-reportboard-table-div">
                    <table class="table table-striped admin-reportboard-table" style="text-align: center;">
                        <tr style="text-align:center; font-size: 16px; font-weight: bold;">
                        	<td>신고횟수</td>
                            <td>글번호</td>
                            <td style = "width : 130px">게시판 카테고리</td>
                            <td>게시판 타입</td>
                            <td>글제목 </td>
                            <td style = "width : 110px">작성자 아이디 </td>
                            <td style = "width : 160px">작성자 회원번호 </td>
                            <td>최초 작성일 </td>
                            <td>최종 수정일 </td>
                            <td>삭제 </td>
                            
                        </tr>
                       <c:if test = "${reportboardvolist != null}">
                        <c:forEach items = "${reportboardvolist}" var="r" >
                         <tr>
                         	<td style = "vertical-align : middle; color : #f55354">${r.reportCount}</td>
                         	<td style = "vertical-align : middle">${r.boardNo}</td>
                         	<td style = "vertical-align : middle">${r.boardType}</td>
                         	<td style = "vertical-align : middle">${r.boardCategory}</td>
                         	<td style = "vertical-align : middle;white-space : nowrap; text-overflow : ellipsis; overflow : hidden"><a href="bdetail?boardNo=${r.boardNo }" target="_blank" style = "color : #754100">${r.boardTitle}</a></td>
                         	<td style = "vertical-align : middle"><a href="adminuserdetail?userId=${r.userId}" target="_blank"style = "color : #754100">${r.userId}</a></td>
                         	<td style = "vertical-align : middle">${r.userNo}</td>
                         	<td style = "vertical-align : middle">${r.boardWriteDate}</td>
                         	<td style = "vertical-align : middle">${r.boardRewriteDate}</td>
                            <td style = "vertical-align : middle"><button class="delete btn btn-primary" value="deletego" id = "${r.boardNo}">삭제</button> </td>
                        </tr>
							</c:forEach>
                         </c:if> 
                    </table>
                </div>


				<div class="admin-reportboard-page-nav">
            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center">
                <c:choose>
                <c:when test = "${startPage == 1}">
                	<li class="page-item-previous disabled">
                	</c:when>
                	<c:otherwise>
                  <li class="page-item-previous">
                  </c:otherwise>
                  </c:choose>
                    <a class="page-link" href="reportboardlist?pagenum=${startPage-1}&viewcount=${viewcount}" aria-label="Previous">
                      <span aria-hidden="true">&laquo;</span>
                    </a>
                  </li>
                  <c:forEach var = "i" begin = "${startPage}" end = "${endPage}" step = "1">
						<li class="page-item"><a class="page-link" href="reportboardlist?pagenum=${i}&viewcount=${viewcount}">${i}</a></li>
				  </c:forEach>
				  <c:choose>
					<c:when test = "${endPage}==${pageCount}">
						<li class="page-item-next disabled">
		             </c:when>
                	<c:otherwise>
                  		<li class="page-item-next">
                  </c:otherwise>
                  </c:choose>
                    <a class="page-link" href="reportboardlist?pagenum=${endPage+1}&viewcount=${viewcount}" aria-label="Next">
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