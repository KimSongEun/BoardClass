<%@page import="kh.semi.boardclass.used.model.vo.Used"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
ArrayList<Used> volist = (ArrayList<Used>) request.getAttribute("usedlist");
int startPage = (int) request.getAttribute("startPage");
int endPage = (int) request.getAttribute("endPage");
int pageCount = (int) request.getAttribute("pageCount");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고거래 메인</title>
</head>
<body>화면이 보이나요?
<body>
	<h1>화면 나오나?</h1>

	<form action="/usedmain" method="post">
		<div>
			<select id="gameCategory">
				<option value="퍼즐">퍼즐</option>
				<option value="전략">전략</option>
				<option value="추상">추상</option>
				<option value="테마">테마</option>
				<option value="방탈출, 추리">방탈출, 추리</option>
				<option value="2인 추천">2인 추천</option>
				<option value="파티">파티</option>
				<option value="가족">가족</option>
				<option value="어린이">어린이</option>
				<option value="한글">한글</option>
			</select>
		</div>
		<div>
			<input type="search" placeholder="검색어를 입력해주세요">
			<button type="submit">검색</button>
		</div>
	</form>
	<table>
		<tr>
			<td>글번호</td>
			<td>이미지</td>
			<td>글제목</td>
			<td>유저ID</td>
		</tr>
		<%
		if (volist != null) {
			for (Used u : volist) {
		%>
		<tr>
			<td><a href="#"><%=u.getUsedNo()%></a></td>
			<td><a href="#"><%=u.getUsedImg()%></a></td>
			<td><a href="#"><%=u.getUsedTitle()%></a></td>
			<td><a href="#"><%=u.getUserId()%></a></td>
		</tr>
		<%
		}
		}
		%>
	</table>
	<button type="button">글쓰기</button>
	<table>
		<tr>
			<td>글번호</td>
			<td>이미지</td>
			<td>글제목</td>
			<td>유저ID</td>
		</tr>
		<c:if test="${usedlist} != null">
			<c:forEach var="r" items="${usedlist}" begin="0" end="3" step="1">
				<tr>
					<td>${r.usedNo}</td>
					<td><a href="#">${r.usedImg}</a></td>
					<td><a href="#">${r.usedTitle}</a></td>
					<td>${r.usedId}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<button type="button" onclick="location.href='./usedcreateview'">글쓰기</button>

</body>
</html>