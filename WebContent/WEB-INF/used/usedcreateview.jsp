<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
^^;
	연결되었나요?

	<form action="usedcreate" method="post" enctype=“multipart/form-data”>
		<div>
			<table>
				<tr>
					<td rowspan=6>
							<input type="file" name="usedImg">
					</td>
					<td><label for="Title">제목 : </label></td>
					<td><input id="Title" name="usedTitle"></td>
				</tr>
				<tr>
					<td><label for="price">가격 : </label></td>
					<td><input id="price" name="usedPrice"></td>
				</tr>
				<tr>
					<td><label for="">상태 : </label></td>
					<td><input id="" name="usedState"></td>
				</tr>
				<tr>
					<td><label for="">교환여부 : </label></td>
					<td><input id="" name="usedChange"></td>
				</tr>
				<tr>
					<td><label for="">배송비 : </label></td>
					<td><input id="" name="usedPay"> 원</td>
				</tr>
				<tr>
					<td><label for="">지역 : </label></td>
					<td><input id="" name="usedArea"></td>
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
		<input type="submit" value="등록">
	</form>






</body>
</html>