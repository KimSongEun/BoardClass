<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="./css/admin/main/adminHeader.css"/> 
    <link rel="stylesheet" href="./css/admin/reportused/adminReportUsed.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="./js/admin/reportused/adminReportUsed.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>  
    <title>신고 중고글 목록</title>
</head>

<body>
    <%@include file="/WEB-INF/admin/main/adminHeader.jsp" %>
    <header></header>
     <section>
        <div class="admin-reportused-section">
            <div class="admin-reportused-div">
                <div class="admin-reportused-title">회원관리👉🏻신고된 중고글</div>
                <table class="admin-reportused-search">
                <tr>
                	<td>
                	<form action = "reportuseduseridsearch" method = "post" class = "searchselect">
                    <select class="admin-reportused-search-select" name = "type">
                        <option value ="작성자아이디" <c:if test = "${type == '작성자아이디'}"> selected </c:if>>작성자아이디 </option>
                        <option value ="작성자 회원번호" <c:if test = "${type == '작성자 회원번호'}"> selected </c:if>>작성자 회원번호</option>
                    </select>
                    <input type="text" class="admin-reportused-search-input" name = "keyword" id = "keyword" value="${keyword }">
                    <button type="submit" class="admin-reportused-search-button">검색</button>
                    </form>
                    </td>
                    <td style = "text-align : right; font-size : 15px; ">
                    	정렬기준 : <select style = "height : 30px" name = "selectno" id = "selectno" onchange = "window.open(value, '_self');">
                    	<option value = "reportusedlist" <c:if test = "${selectno == 'reportusedlist'}"> selected </c:if>>신고횟수 많은 순</option>
                    	<option value = "reportusedasclist" <c:if test = "${selectno == 'reportusedasclist'}"> selected </c:if>>신고횟수 적은 순</option>
                    </select>
                    </td>
                    <td style = "text-align : right; font-size : 15px; width : 160px">
                    	|| 표시글 개수 : <select style = "height : 30px" name = "selectno" id = "selectno" onchange = "window.open(value, '_self');">
                    	<c:if test = "${empty selectno}">
                    	<option value = "reportcommentlist?viewcount=10" <c:if test = "${viewcount == 10}"> selected </c:if>>10</option>
                    	<option value = "reportcommentlist?viewcount=20" <c:if test = "${viewcount == 20}"> selected </c:if>>20</option>
                    	<option value = "reportcommentlist?viewcount=50" <c:if test = "${viewcount == 50}"> selected </c:if>>50</option>
                    	</c:if>
                    	<c:if test = "${selectno == 'reportusedlist'}">
                    	<option value = "reportusedlist?viewcount=10" <c:if test = "${viewcount == 10}"> selected </c:if>>10</option>
                    	<option value = "reportusedlist?viewcount=20" <c:if test = "${viewcount == 20}"> selected </c:if>>20</option>
                    	<option value = "reportusedlist?viewcount=50" <c:if test = "${viewcount == 50}"> selected </c:if>>50</option>
                    	</c:if>
                    	<c:if test = "${selectno == 'reportusedasclist'}">
                    	<option value = "reportusedasclist?viewcount=10" <c:if test = "${viewcount == 10}"> selected </c:if>>10</option>
                    	<option value = "reportusedasclist?viewcount=20" <c:if test = "${viewcount == 20}"> selected </c:if>>20</option>
                    	<option value = "reportusedasclist?viewcount=50" <c:if test = "${viewcount == 50}"> selected </c:if>>50</option>
                    	</c:if>
                    </select>
                    </td>
                    </tr>
                </table>

                <div class="admin-reportused-table-div">
                    <table class="table table-striped admin-reportused-table" style="text-align: center;">
                        <tr style="text-align:center; font-size: 16px; font-weight: bold;">
                        	<td>신고횟수</td>
                            <td>중고글번호</td>
                            <td>중고글제목 </td>
                            <td>작성자 아이디 </td>
                            <td style = "width : 160px">작성자 회원번호 </td>
                            <td>작성일 </td>
                            <td>삭제 </td>
                            
                        </tr>
                       <c:if test = "${reportusedvolist != null}">
                        <c:forEach items = "${reportusedvolist}" var="r" >
                         <tr>
                         	<td style = "vertical-align : middle; color : #f55354">${r.reportCount}</td>
                         	<td style = "vertical-align : middle">${r.usedNo}</td>
                         	<td style = "vertical-align : middle; white-space : nowrap; text-overflow : ellipsis; overflow : hidden" title = "${r.usedTitle}"><a href="usedinformation?no=${r.usedNo}" target="_blank" style = "color : #754100">${r.usedTitle}</a></td>
                         	<td style = "vertical-align : middle"><a href="adminuserdetail?userId=${r.userId}" target="_blank" style = "color : #754100">${r.userId}</a></td>
                         	<td style = "vertical-align : middle">${r.userNo}</td>
                         	<td style = "vertical-align : middle">${r.usedDate}</td>
                            <td style = "vertical-align : middle"><button class="delete btn btn-primary" value="deletego" id = "${r.usedNo}">삭제</button> </td>
                        </tr>
							</c:forEach>
                         </c:if> 
                    </table>
                </div>


				<div class="admin-reportused-page-nav">
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
                    <a class="page-link" href="reportusedlist?pagenum=${startPage-1}&viewcount=${viewcount}" aria-label="Previous">
                      <span aria-hidden="true">&laquo;</span>
                    </a>
                  </li>
                  <c:forEach var = "i" begin = "${startPage}" end = "${endPage}" step = "1">
						<li class="page-item"><a class="page-link" href="reportusedlist?pagenum=${i}&viewcount=${viewcount}">${i}</a></li>
				  </c:forEach>
				  <c:choose>
					<c:when test = "${endPage}==${pageCount}">
						<li class="page-item-next disabled">
		             </c:when>
                	<c:otherwise>
                  		<li class="page-item-next">
                  </c:otherwise>
                  </c:choose>
                    <a class="page-link" href="reportusedlist?pagenum=${endPage+1}&viewcount=${viewcount}" aria-label="Next">
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