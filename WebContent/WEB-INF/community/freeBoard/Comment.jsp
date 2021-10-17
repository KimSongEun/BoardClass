<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${result > 0 }">
		<script>
			location.href="cfdetail?boardNo=${boardNo }&pageNum=${pageNum }";
		</script>
	</c:if>
	<c:if test="${result == 0 }">
		<script>
			alert("댓글 등록 실패");
			history.back();
		</script>
	</c:if>
</body>
</html>