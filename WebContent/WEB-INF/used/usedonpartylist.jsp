<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<link rel="stylesheet" href="./css/index/maincss.css"/>
<link rel="stylesheet" href="./css/used/usedmain.css"/>
<link rel="icon" href="./img/dicedice.ico" type="image/x-icon" sizes="16x16">
<title>중고거래 메인</title>
</head>
<body>

<%@include file="/WEB-INF/index/header.jsp" %>

<section>
<div class="secfirst">
	<div class="div_select">
		<select id="gameCategory" onchange="window.open(value,'_self');">
			<option value="usedmain">전체</option>
			<option value="UsedOnPuzzleList">퍼즐</option>
			<option value="UsedOnStrategyList">전략</option>
			<option value="UsedOnAbstractList">추상</option>
			<option value="UsedOnThemeList">테마</option>
			<option value="UsedOnDeductionList">방탈출, 추리</option>
			<option value="UsedOnTwoPlayerList">2인 추천</option>
			<option value="UsedOnPartyList" selected>파티</option>
			<option value="UsedOnFamilyList">가족</option>
			<option value="UsedOnChildList">어린이</option>
			<option value="UsedOnKoreanList">한글</option>
		</select>
	</div>
	<div class="div_search">
		<form id="searchTandC" action="UsedOnPartyList">
			<input type="search" name="search" placeholder="검색어를 입력해주세요">
			<button type="submit">검색</button>
		</form>
	</div>
</div>
	<div class="secsecond">
		<c:if test="${usedlist != null}">
			<c:forEach var="r" items="${usedlist}">
				<div class="div_product">
					<div class="div_img">
							<a href="usedinformation?no=${r.usedNo}">
								<c:choose>
									<c:when test="${r.usedImg != null}">
										<img src="${pageContext.request.contextPath}/${r.usedImg}">
									</c:when>
								</c:choose>
							</a>
					</div>
					<div class="div_img_text">
						<p class="p_img_text">
							<a href="usedinformation?no=${r.usedNo}">
								${r.usedTitle}
							</a>
						</p>
					</div>
				</div>
			</c:forEach>
		</c:if>
</div>
<div class="secthird">
		<button type="button" onclick="location.href='./usedcreateview'">글쓰기</button>
</div>
<div class="secfourth">
		<div class="div_paging">
			<c:if test="${startPage > 1}">
				<a href="usedmain?pagenum=${startPage-1}" class="pageprevious">&laquo;</a>
			</c:if>
			<c:if test="${startPage <= 1}">
				<a href="usedmain?pagenum=1" class="pageprevious">&laquo;</a>
			</c:if>
			<c:forEach var="p" begin="1" step="1" end="${endPage}">
				<a href="usedmain?pagenum=${p}" class="pagecurrent">${p}</a>
			</c:forEach>
			<c:if test="${endPage < pageCount}">
				<a href="usedmain?pagenum=${endPage+1}" class="pagenext">&raquo;</a>
			</c:if>
			<c:if test="${endPage >= pageCount}">
				<a href="usedmain?pagenum=${pageCount}" class="pagenext">&raquo;</a>
			</c:if>
		</div>
	</div>
</section>

<%@include file="/WEB-INF/index/footer.jsp" %>
</body>
</html>