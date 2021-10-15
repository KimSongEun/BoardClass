<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardClass</title>
</head>
<body>
	<c:if test="${result > 0 }">
		<script>
			location.href="cfdetail?boardNo=${board.boardNo }&pageNum=${pageNum}";
		</script>
	</c:if>
	<c:if test="${result == 0 }">
		<script>
			alert("수정오류");
			location.href="cfupdate?boardNo=${board.boardNo }&pageNum=${pageNum}";
		</script>
	</c:if>
</body>
</html>