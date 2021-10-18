<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<link rel="stylesheet" href="./css/index.css"/>
<link rel="stylesheet" href="./css/used/usedmain.css"/>
<title>중고거래 메인</title>
</head>
<body>

<%@include file="/WEB-INF/index/header.jsp" %>

<section class="section">
<div class="secfirst">
	<div class="div_select">
		<select id="gameCategory" onchange="window.open(value,'_self');">
			<option value="usedmain" selected>전체</option>
			<option value="UsedOnPuzzleList">퍼즐</option>
			<option value="UsedOnStrategyList">전략</option>
			<option value="UsedOnAbstractList">추상</option>
			<option value="UsedOnThemeList">테마</option>
			<option value="UsedOnDeductionList">방탈출, 추리</option>
			<option value="UsedOnTwoPlayerList">2인 추천</option>
			<option value="UsedOnPartyList">파티</option>
			<option value="UsedOnFamilyList">가족</option>
			<option value="UsedOnChildList">어린이</option>
			<option value="UsedOnKoreanList">한글</option>
		</select>
	</div>
	<div class="div_search">
		<form id="searchTandC" action="usedmain">
			<input type="search" name="search" placeholder="검색어를 입력해주세요">
			<button type="submit">검색</button>
		</form>
	</div>
</div>
<div class="secsecond">
		<c:if test="${usedlist != null}">
			<c:forEach var="r" items="${usedlist}">
				<form class="form_usedinfo">
					<div class="div_usedinfo">
						<a href="usedinformation?no=${r.usedNo}">
							<img src="${pageContext.request.contextPath}
							/${r.usedImg}" alt="이미지없음">
						</a>
						<div class="img_text">
							<a href="usedinformation?no=${r.usedNo}">${r.usedTitle}</a>
						</div>
					</div>
				</form>
			</c:forEach>
		</c:if>
</div>
<div class="secthird">
		<button type="button" onclick="location.href='./usedcreateview'">글쓰기</button>
</div>
<div class="secfourth">
	<div class="div_paging">
		<c:if test="${startPage > 1}">
			<a href="#" class="previous">&laquo;</a>
		</c:if>
		<c:forEach var="p" begin="1" step="1" end="${endPage}">
			<a href="./usedmain?pagenum=${p}" class="current">${p}</a>
		</c:forEach>
		<c:if test="${endPage < pageCount}">
			<a href="#" class="next">&raquo;</a>
		</c:if>
	</div>
</div>
</section>

<%@include file="/WEB-INF/index/footer.jsp" %>
</body>
</html>