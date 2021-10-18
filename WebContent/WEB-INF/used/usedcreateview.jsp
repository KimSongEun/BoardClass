<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script type="text/javascript" src="./js/used/usedcreate.js"></script>
<link rel="stylesheet" href="./css/index/maincss.css" />
<link rel="stylesheet" href="./css/used/usedcreate.css" />
<title>중고거래글 작성</title>
</head>
<body>
<%@include file="/WEB-INF/index/header.jsp"%>

	<section>
		<div class="article_create">
			<form action="usedcreate" method="post" enctype="multipart/form-data">
				<div>
					<table>
						<tr>
							<td rowspan=5>썸네일</td>
							<td><label for="title">제목 : </label></td>
							<td><input id="title" name="usedTitle"
								placeholder="제목을 입력해주세요"></td>
						</tr>
						<tr>
							<td><label for="price">가격 : </label></td>
							<td><input id="price" name="usedPrice"
								placeholder="숫자만 입력하세요"></td>
						</tr>
						<tr>
							<td><label for="state">상태 : </label></td>
							<td><select id="state" name="usedState">
									<option value="0">미개봉</option>
									<option value="1" selected>상태좋음</option>
									<option value="2">사용흔적있음</option>
									<option value="3">구성품누락</option>
							</select></td>
						</tr>
						<tr>
							<td><label for="changeable">교환여부 : </label></td>
							<td><select id="changeable" name="usedChange">
									<option value="0">교환가능</option>
									<option value="1">교환불가</option>
							</select></td>
						</tr>
						<tr>
							<td><label for="changetype">거래방식 : </label></td>
							<td><select id="changetype" name="usedExtype">
									<option value="0">직거래&amp;택배</option>
									<option value="1">직거래</option>
									<option value="2">택배</option>
							</select></td>
						</tr>
						<tr>
							<td><input type="file" name="usedImg">
							<td><label for="gamecate">카테고리 : </label></td>
							<td><select id="gamecate" name="usedCategory">
									<option value="" selected>없음</option>
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
							</select></td>
						</tr>
					</table>
				</div>
				<div>
					상품정보<br>
					<textarea id="info" name="usedInfo" placeholder="상품정보를 입력하세요"></textarea>
				</div>
				<div>
					<input type="text" id="searchresult" value="" readonly>
				</div>
				<div>
					검색 <input type="search" id="search" list="keywordResult">
					<button type="button" id="searchadd">추가</button>
					<datalist id="keywordResult">
					</datalist>
					<div id="searchnull"></div>
				</div>
				<button type="submit" onclick="return checkValAll();">등록</button>
			</form>


		</div>
	</section>
<%@include file="/WEB-INF/index/footer.jsp"%>
</body>
</html>