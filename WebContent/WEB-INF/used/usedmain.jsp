<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고거래 메인</title>
</head>
<body>화면이 보이나요?
	<h1>화면 나오나?</h1>

	<div>
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
	<div>
		<form id="searchTandC" action="usedmain">
			<input type="search" name="search" placeholder="검색어를 입력해주세요">
			<button type="submit">검색</button>
		</form>
	</div>
	<table>
		<tr>
			<td>글번호</td>
			<td>이미지</td>
			<td>글제목</td>
			<td>유저ID</td>
		</tr>
		<c:if test="${usedlist != null}">
			<c:forEach var="r" items="${usedlist}">
				<tr>
					<td>${r.usedNo}</td>
					<td><a href="usedinformation?no=${r.usedNo}">${r.usedImg}</a></td>
					<td><a href="usedinformation?no=${r.usedNo}">${r.usedTitle}</a></td>
					<td>${r.userId}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<button type="button" onclick="location.href='./usedcreateview'">글쓰기</button>

</body>
</html>