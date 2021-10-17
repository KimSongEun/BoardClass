<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="./css/admin/main/adminHeader.css"/> 
    <link rel="stylesheet" href="./css/admin/reportreview/adminReportReview.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="./js/admin/reportreview/adminReportReview.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>  
    <title>신고 리뷰 목록</title>
</head>

<body>
    <%@include file="/WEB-INF/admin/main/adminHeader.jsp" %>
    <header></header>
     <section>
        <div class="admin-reportreview-section">
            <div class="admin-reportreview-div">
                <div class="admin-reportreview-title">회원관리👉🏻신고된 리뷰</div>
                <table class="admin-reportreview-search">
                <tr>
                	<td>
                	<form action = "reportreviewuseridsearch" method = "post" class = "searchselect">
                    <select class="admin-reportreview-search-select" name = "type">
                        <option value ="작성자아이디" <c:if test = "${type == '작성자아이디'}"> selected </c:if>>작성자아이디 </option>
                        <option value ="작성자 회원번호" <c:if test = "${type == '작성자 회원번호'}"> selected </c:if>>작성자 회원번호</option>
                    </select>
                    <input type="text" class="admin-reportreview-search-input" name = "keyword" id = "keyword" value="${keyword }">
                    <button type="submit" class="admin-reportreview-search-button">검색</button>
                    </form>
                    </td>
                    <td style = "text-align : right; font-size : 15px; ">
                    	정렬기준 : <select style = "height : 30px" name = "selectno" id = "selectno" onchange = "window.open(value, '_self');">
                    	<option value = "reportreviewlist" <c:if test = "${selectno == 'reportreviewlist'}"> selected </c:if>>신고횟수 많은 순</option>
                    	<option value = "reportreviewasclist" <c:if test = "${selectno == 'reportreviewasclist'}"> selected </c:if>>신고횟수 적은 순</option>
                    </select>
                    </td>
                    <td style = "text-align : right; font-size : 15px; width : 160px">
                    	|| 표시글 개수 : <select style = "height : 30px" name = "selectno" id = "selectno" onchange = "window.open(value, '_self');">
                    	<c:if test = "${empty selectno}">
                    	<option value = "reportreviewlist?viewcount=10" <c:if test = "${viewcount == 10}"> selected </c:if>>10</option>
                    	<option value = "reportreviewlist?viewcount=20" <c:if test = "${viewcount == 20}"> selected </c:if>>20</option>
                    	<option value = "reportreviewlist?viewcount=50" <c:if test = "${viewcount == 50}"> selected </c:if>>50</option>
                    	</c:if>
                    	<c:if test = "${selectno == 'reportreviewlist'}">
                    	<option value = "reportreviewlist?viewcount=10" <c:if test = "${viewcount == 10}"> selected </c:if>>10</option>
                    	<option value = "reportreviewlist?viewcount=20" <c:if test = "${viewcount == 20}"> selected </c:if>>20</option>
                    	<option value = "reportreviewlist?viewcount=50" <c:if test = "${viewcount == 50}"> selected </c:if>>50</option>
                    	</c:if>
                    	<c:if test = "${selectno == 'reportreviewasclist'}">
                    	<option value = "reportreviewasclist?viewcount=10" <c:if test = "${viewcount == 10}"> selected </c:if>>10</option>
                    	<option value = "reportreviewasclist?viewcount=20" <c:if test = "${viewcount == 20}"> selected </c:if>>20</option>
                    	<option value = "reportreviewasclist?viewcount=50" <c:if test = "${viewcount == 50}"> selected </c:if>>50</option>
                    	</c:if>
                    </select>
                    </td>
                    </tr>
                </table>

                <div class="admin-reportreview-table-div">
                    <table class="table table-striped admin-reportreview-table" style="text-align: center;">
                        <tr style="text-align:center; font-size: 16px; font-weight: bold;">
                        	<td>신고횟수</td>
                            <td>리뷰번호</td>
                            <td>게임명</td>
                            <td>리뷰내용</td>
                            <td>작성자 아이디 </td>
                            <td>작성자 회원번호 </td>
                            <td>리뷰 작성일 </td>
                            <td>삭제 </td>
                            
                        </tr>
                       <c:if test = "${reportreviewvolist != null}">
                        <c:forEach items = "${reportreviewvolist}" var="r" >
                         <tr>
                         	<td style = "vertical-align : middle; color : #f55354">${r.reportCount}</td>
                         	<td style = "vertical-align : middle" class = "commentNo">${r.reviewNo}</td>
                         	<td style = "vertical-align : middle">${r.gameKoName}</td>
                         	<td style = "vertical-align : middle; white-space : nowrap; text-overflow : ellipsis; overflow : hidden" ><a href="#" class = "review-modal" id = "${r.reviewNo}" style = "color : #754100">${r.reviewContent}</a></td>
                         	<td style = "vertical-align : middle"><a href="#회원정보조회" style = "color : #754100">${r.userId}</a></td>
                         	<td style = "vertical-align : middle">${r.userNo}</td>
                         	<td style = "vertical-align : middle">${r.reviewDate}</td>
                            <td style = "vertical-align : middle"><button class="delete btn btn-primary" value="deletego" onclick="location.href='reportreviewdelete?reviewNo=${r.reviewNo}'">삭제</button> </td>
                        </tr>
                        		<!-- The Modal -->
								<div id="myModal" class="modal">

									<!-- Modal content -->
									<div class="modal-review">
										<span class="close">&times;</span>
										<h3 style = "color : gray">리뷰 내용 상세보기</h3>
										<br>
										<p id = "modal-review-detail"></p>
									</div>

								</div>
							</c:forEach>
                         </c:if> 
                    </table>
                </div>


				<div class="admin-reportreview-page-nav">
            <nav aria-label="Page navigation example">
                <ul class="pagination justify-report-center">
                <c:choose>
                <c:when test = "${startPage == 1}">
                	<li class="page-item-previous disabled">
                	</c:when>
                	<c:otherwise>
                  <li class="page-item-previous">
                  </c:otherwise>
                  </c:choose>
                    <a class="page-link" href="reportreviewlist?pagenum=${startPage-1}&viewcount=${viewcount}" aria-label="Previous">
                      <span aria-hidden="true">&laquo;</span>
                    </a>
                  </li>
                  <c:forEach var = "i" begin = "${startPage}" end = "${endPage}" step = "1">
						<li class="page-item"><a class="page-link" href="reportreviewlist?pagenum=${i}&viewcount=${viewcount}">${i}</a></li>
				  </c:forEach>
				  <c:choose>
					<c:when test = "${endPage}==${pageCount}">
						<li class="page-item-next disabled">
		             </c:when>
                	<c:otherwise>
                  		<li class="page-item-next">
                  </c:otherwise>
                  </c:choose>
                    <a class="page-link" href="reportreviewlist?pagenum=${endPage+1}&viewcount=${viewcount}" aria-label="Next">
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