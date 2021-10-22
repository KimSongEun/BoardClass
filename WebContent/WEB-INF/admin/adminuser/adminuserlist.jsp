<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="./css/admin/main/adminHeader.css"/> 
    <link rel="stylesheet" href="./css/admin/adminuser/adminUser.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="./js/admin/adminuser/adminUser.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>  
    <title>회원관리</title>
</head>

<body>
    <%@include file="/WEB-INF/admin/main/adminHeader.jsp" %>
    <header></header>
     <section>
        <div class="admin-adminuser-section">
            <div class="admin-adminuser-div">
                <div class="admin-adminuser-title">회원관리👉🏻회원관리</div>
                <table class="admin-adminuser-search">
                <tr>
                	<td>
                	<form action = "adminuseruseridsearch" method = "post" class = "searchselect">
                    <select class="admin-adminuser-search-select" name = "type">
                        <option value ="작성자아이디" <c:if test = "${type == '작성자아이디'}"> selected </c:if>>작성자아이디 </option>
                        <option value ="작성자 회원번호" <c:if test = "${type == '작성자 회원번호'}"> selected </c:if>>작성자 회원번호</option>
                    </select>
                    <input type="text" class="admin-adminuser-search-input" name = "keyword" id = "keyword" value="${keyword }">
                    <button type="submit" class="admin-adminuser-search-button">검색</button>
                    </form>
                    </td>
                    <td style = "text-align : right; font-size : 15px; width : 160px">
                    	표시글 개수 : <select style = "height : 30px" name = "selectno" id = "selectno" onchange = "window.open(value, '_self');">
                    	<option value = "adminuserlist?viewcount=10" <c:if test = "${viewcount == 10}"> selected </c:if>>10</option>
                    	<option value = "adminuserlist?viewcount=20" <c:if test = "${viewcount == 20}"> selected </c:if>>20</option>
                    	<option value = "adminuserlist?viewcount=50" <c:if test = "${viewcount == 50}"> selected </c:if>>50</option>
                    </select>
                    </td>
                    </tr>
                </table>

                <div class="admin-adminuser-table-div">
                    <table class="table table-striped admin-adminuser-table" style="text-align: center;">
                        <tr style="text-align:center; font-size: 16px; font-weight: bold;">
                        	<td style = "width : 80px">회원번호</td>
                            <td style = "width : 100px">회원 아이디</td>
                            <td style = "width : 130px">총 작성 글 개수</td>
                            <td style = "width : 150px">총 작성 댓글 개수</td>
                            <td style = "width : 150px">총 작성 리뷰 개수</td>
                            <td style = "width : 150px">총 작성 중고글 개수</td>
                            <td>사이트 방문횟수 </td>
                            <td>회원정보 상세보기</td>
                            
                        </tr>
                       <c:if test = "${adminuservolist != null}">
                        <c:forEach items = "${adminuservolist}" var="r" >
                         <tr>
                         	<td style = "vertical-align : middle">${r.userNo}</td>
                         	<td style = "vertical-align : middle">${r.userId}</td>
                         	<td style = "vertical-align : middle">${r.boardCount}개</td>
                         	<td style = "vertical-align : middle">${r.comtCount}개</td>
                         	<td style = "vertical-align : middle">${r.reviewCount}개</td>
                         	<td style = "vertical-align : middle">${r.usedCount}개</td>
                         	<td style = "vertical-align : middle">${r.userHistory}번</td>
                            <td style = "vertical-align : middle"><button class="detail btn btn-warning" value="detailgo" id = "${r.userId}">상세보기</button> </td>
                        </tr>
							</c:forEach>
                         </c:if> 
                    </table>
                </div>


				<div class="admin-adminuser-page-nav">
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
                    <a class="page-link" href="adminuserlist?pagenum=${startPage-1}&viewcount=${viewcount}" aria-label="Previous">
                      <span aria-hidden="true">&laquo;</span>
                    </a>
                  </li>
                  <c:forEach var = "i" begin = "${startPage}" end = "${endPage}" step = "1">
						<li class="page-item"><a class="page-link" href="adminuserlist?pagenum=${i}&viewcount=${viewcount}">${i}</a></li>
				  </c:forEach>
				  <c:choose>
					<c:when test = "${endPage}==${pageCount}">
						<li class="page-item-next disabled">
		             </c:when>
                	<c:otherwise>
                  		<li class="page-item-next">
                  </c:otherwise>
                  </c:choose>
                    <a class="page-link" href="adminuserlist?pagenum=${endPage+1}&viewcount=${viewcount}" aria-label="Next">
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