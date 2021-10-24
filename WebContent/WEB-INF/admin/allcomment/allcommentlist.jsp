<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="./css/admin/main/adminHeader.css"/> 
    <link rel="stylesheet" href="./css/admin/allcomment/adminAllComment.css?"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="./js/admin/allcomment/allcommentlist.js?"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>  
    <link rel="icon" href="./img/dicedice.ico" type="image/x-icon" sizes="16x16">
    <title>전체 댓글 목록</title>
</head>

<body>
    <%@include file="/WEB-INF/admin/main/adminHeader.jsp" %>
    <header></header>
     <section>
        <div class="admin-allcomment-section">
            <div class="admin-allcomment-div">
                <div class="admin-allcomment-title">게시판👉🏻전체댓글목록</div>
                <table class="admin-allcomment-search">
                <tr>
                	<td>
                	<form action = "allcommentuseridsearch" method = "post" class = "searchselect">
                    <select class="admin-allcomment-search-select" name = "type">
                        <option value ="작성자아이디" <c:if test = "${type == '작성자아이디'}"> selected </c:if>>작성자아이디 </option>
                        <option value ="작성자 회원번호" <c:if test = "${type == '작성자 회원번호'}"> selected </c:if>>작성자 회원번호</option>
                        <option value ="댓글내용" <c:if test = "${type == '댓글내용'}"> selected </c:if>>댓글내용</option>
                    </select>
                    <input type="text" class="admin-allcomment-search-input" name = "keyword" id = "keyword" value="${keyword }">
                    <button type="submit" class="admin-allcomment-search-button">검색</button>
                    </form>
                    </td>
                    
                    <td style = "text-align : right; font-size : 15px">
                    	표시글 개수 : <select style = "height : 30px" name = "selectno" id = "selectno" onchange = "window.open(value, '_self');">
                    	<option value = "allcommentlist?viewcount=10" <c:if test = "${viewcount == 10}"> selected </c:if>>10</option>
                    	<option value = "allcommentlist?viewcount=20" <c:if test = "${viewcount == 20}"> selected </c:if>>20</option>
                    	<option value = "allcommentlist?viewcount=50" <c:if test = "${viewcount == 50}"> selected </c:if>>50</option>
                    </select>
                    </td>
                    </tr>
                </table>

                <div class="admin-allcomment-table-div">
                    <table class="table table-striped admin-allcomment-table" style="text-align: center;">
                        <tr style="text-align:center; font-size: 16px; font-weight: bold;">
                        	<td>글번호</td>
                            <td>원본 글 제목</td>
                            <td>댓글</td>
                            <td>작성자아이디</td>
                            <td>작성자회원번호 </td>
                            <td>글작성일 </td>
                            <td>삭제 </td>
                            
                        </tr>
                       <c:if test = "${allcommentuservolist != null}">
                        <c:forEach items = "${allcommentuservolist}" var="c" >
                         <tr>
                         	<td style = "vertical-align : middle" class = "commentNo">${c.commentNo}</td>
                            <td style = "vertical-align : middle; white-space : nowrap; text-overflow : ellipsis; overflow : hidden"><a href="bdetail?boardNo=${c.boardNo }" target="_blank"  style = "color : #754100">${c.boardTitle}</a></td>
                            <td style = "vertical-align : middle; white-space : nowrap; text-overflow : ellipsis; overflow : hidden" ><a href="#댓글보기" class = "comment-modal" id = "${c.commentNo}" style = "color : #754100">${c.commentContent}</a></td>
                            <td style = "vertical-align : middle"><a href="adminuserdetail?userId=${c.userId}" target="_blank" style = "color : #754100">${c.userId}</a></td>
                            <td style = "vertical-align : middle">${c.userNo}</td>
                            <td style = "vertical-align : middle">${c.commentRewriteDate}</td>
                            <td style = "vertical-align : middle"><button class="delete btn btn-primary" value="deletego" id="${c.commentNo}">삭제</button> </td>
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


				<div class="admin-allcomment-page-nav">
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
                    <a class="page-link" href="allcommentlist?pagenum=${startPage-1}&viewcount=${viewcount}" aria-label="Previous">
                      <span aria-hidden="true">&laquo;</span>
                    </a>
                  </li>
                  <c:forEach var = "i" begin = "${startPage}" end = "${endPage}" step = "1">
						<li class="page-item"><a class="page-link" href="allcommentlist?pagenum=${i}&viewcount=${viewcount}">${i}</a></li>
				  </c:forEach>
				  <c:choose>
					<c:when test = "${endPage}==${pageCount}">
						<li class="page-item-next disabled">
		             </c:when>
                	<c:otherwise>
                  		<li class="page-item-next">
                  </c:otherwise>
                  </c:choose>
                    <a class="page-link" href="allcommentlist?pagenum=${endPage+1}&viewcount=${viewcount}" aria-label="Next">
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