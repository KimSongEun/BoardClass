<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$("#btnInsert").click(checkValue);

	function checkValue() {
		alert("기다려봐");
	}
</script>
<style>
</style>
</head>
<body>
	^^; 연결되었나요?

	<form action="usedcreate" method="post" enctype="multipart/form-data">  
		<div>
			<table>
				<tr>
					<td rowspan=4>썸네일</td>
					<td><label for="title">제목 : </label></td>
					<td><input id="title" name="usedTitle"
						placeholder="제목을 입력해주세요"></td>
				</tr>
				<tr>
					<td><label for="price">가격 : </label></td>
					<td><input id="price" name="usedPrice" pattern="[0-9]+" placeholder="숫자만 입력하세요"></td>
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
					<td><input type="file" name="usedImg"></td>
					<td><label for="changetype">거래방식 : </label></td>
					<td><select id="changetype" name="usedExtype">
							<option value="0">직거래&amp;택배</option>
							<option value="1">직거래</option>
							<option value="2">택배</option>
					</select></td>
				</tr>
			</table>
		</div>
		<div>
			상품정보<br>
			<textarea name="usedInfo" placeholder="상품정보를 입력하세요"></textarea>
		</div>
		<div>
			검색창 <input type="search">
		</div>
		<button type="submit" id="btnInsert">등록</button>
	</form>






</body>
</html>