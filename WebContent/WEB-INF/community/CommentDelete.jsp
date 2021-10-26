<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="./img/dicedice.ico" type="image/x-icon" sizes="16x16">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${result > 0 }">
		<script>
			location.href="cfdetail?boardNo=${board.boardNo }&pageNum=${pageNum }";
		</script>
	</c:if>
	<c:if test="${result == 0 }">
		<script>
			alert("삭제를 실패했습니다.");
			location.href="cfdetail?boardNo=${board.boardNo }&pageNum=${pageNum }";
		</script>
	</c:if>
</body>
</html>