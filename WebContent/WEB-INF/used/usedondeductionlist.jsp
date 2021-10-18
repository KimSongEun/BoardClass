<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<select id="gameCategory" onchange="window.open(value,'_self');">
			<option value="usedmain">전체</option>
			<option value="UsedOnPuzzleList">퍼즐</option>
			<option value="UsedOnStrategyList">전략</option>
			<option value="UsedOnAbstractList">추상</option>
			<option value="UsedOnThemeList">테마</option>
			<option value="UsedOnDeductionList" selected>방탈출, 추리</option>
			<option value="UsedOnTwoPlayerList">2인 추천</option>
			<option value="UsedOnPartyList">파티</option>
			<option value="UsedOnFamilyList">가족</option>
			<option value="UsedOnChildList">어린이</option>
			<option value="UsedOnKoreanList">한글</option>
		</select>
	</div>
	<div>
		<input type="search" placeholder="검색어를 입력해주세요">
		<button type="submit">검색</button>
	</div>
	<div>
		<c:if test="${usedlist != null}">
			<c:forEach var="r" items="${usedlist}">
				<div id="board_info">
					<button type="button" class="btn1" onclick="#">
						<img src="${r.usedImg}" width="250" height="250" />
						<div class="img-text">
							${r.usedTitle}
							${r.usedState}
						</div>
					</button>
				</div>
			</c:forEach>
		</c:if>
	</div>
</body>
</html>