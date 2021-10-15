<%@page import="kh.semi.boardclass.admin.model.vo.AllBoardUser"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="./css/admin/main/adminHeader.css"/> 
    <link rel="stylesheet" href="./css/admin/allboard/adminAllBoard.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="./js/admin/allboard/allboardlist.js?after"></script>
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
                        	<td>글번호</td>
                            <td>게시판 카테고리</td>
                            <td>게시판 타입</td>
                            <td>글제목</td>
                            <td>작성자아이디</td>
                            <td>작성자회원번호 </td>
                            <td>글작성일 </td>
                            <td>수정 </td>
                            <td>삭제 </td>
                            
                        </tr>
                       <c:if test = "${allboarduservolist != null}">
                        <c:forEach items = "${allboarduservolist}" var="b" >
                         <tr>
                         	<td style = "vertical-align : middle" class = "boardNo">${b.boardNo}</td>
                            <td style = "vertical-align : middle" id = "select-main-td">
                             <select class = "admin-select" name = "selectCategory" id = "allboard-select-main">
                          		<option value="자유 게시판"<c:if test = "${b.boardCategory=='자유 게시판'}">selected</c:if>>자유 게시판</option>
								<option value="유저정보 게시판"<c:if test = "${b.boardCategory=='유저정보 게시판'}">selected</c:if>>유저정보 게시판</option>
								<option value="모임 게시판"<c:if test = "${b.boardCategory=='모임 게시판'}">selected</c:if>>모임 게시판</option>
                            </select>
                            </td>
                            <td style = "vertical-align : middle">
                            <select class="admin-sub-select" name="selectSubCategory" id = "allboard-select-sub">
                            		<c:if test="${b.boardCategory=='자유 게시판'}"> 
										<option value="사담"<c:if test = "${b.boardType=='사담'}">selected</c:if>>사담</option>
										<option value="건의"<c:if test = "${b.boardType=='건의'}">selected</c:if>>건의</option>
										<option value="질문"<c:if test = "${b.boardType=='질문'}">selected</c:if>>질문</option>
									</c:if>
									<c:if test="${b.boardCategory=='유저정보 게시판'}"> 
										<option value="기사"<c:if test = "${b.boardType=='기사'}">selected</c:if>>기사</option>
										<option value="후기"<c:if test = "${b.boardType=='후기'}">selected</c:if>>후기</option>
										<option value="공식"<c:if test = "${b.boardType=='공식'}">selected</c:if>>공식</option>
										<option value="팁"<c:if test = "${b.boardType=='팁'}">selected</c:if>>팁</option>
									</c:if>
									<c:if test="${b.boardCategory=='모임 게시판'}"> 
										<option value="모임후기"<c:if test = "${b.boardType=='모임후기'}">selected</c:if>>모임후기</option>
										<option value="모집"<c:if test = "${b.boardType=='모집'}">selected</c:if>>모집</option>
										<option value="일정안내"<c:if test = "${b.boardType=='일정안내'}">selected</c:if>>일정안내</option>
									</c:if>
                            </select>
                            </td>
                            <td style = "vertical-align : middle">${b.boardTitle}</td>
                            <td style = "vertical-align : middle">${b.userId}</td>
                            <td style = "vertical-align : middle">${b.userNo}</td>
                            <td style = "vertical-align : middle">${b.boardRewriteDate}</td>
                            <td style = "vertical-align : middle"><button class="update btn btn-danger" value="updatego">수정</button> </td>
                            <td style = "vertical-align : middle"><button class="delete btn btn-primary" value="deletego" onclick="location.href='allboarddelete?boardNo=${b.boardNo}'">삭제</button> </td>
                        </tr> 
                         </c:forEach>
                         </c:if> 
                    </table>
                </div>

            <div class="admin-allboard-page-nav">
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
                    <a class="page-link" href="allboardlist?pagenum=${startPage-1}&viewcount=${viewcount}" aria-label="Previous">
                      <span aria-hidden="true">&laquo;</span>
                    </a>
                  </li>
                  <c:forEach var = "i" begin = "${startPage}" end = "${endPage}" step = "1">
						<li class="page-item"><a class="page-link" href="allboardlist?pagenum=${i}&viewcount=${viewcount}">${i}</a></li>
				  </c:forEach>
				  <c:choose>
					<c:when test = "${endPage}==${pageCount}">
						<li class="page-item-next disabled">
		             </c:when>
                	<c:otherwise>
                  		<li class="page-item-next">
                  </c:otherwise>
                  </c:choose>
                    <a class="page-link" href="allboardlist?pagenum=${endPage+1}&viewcount=${viewcount}" aria-label="Next">
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