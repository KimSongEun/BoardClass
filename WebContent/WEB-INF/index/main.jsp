<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardClass</title>
<link rel="stylesheet" href="./css/index/maincss.css" />
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/index/main.js"></script>
</head>
<body>
	<c:import url="/WEB-INF/index/header.jsp" />
	<section>
		<div class="slideshow-container">
			<c:if test="${advolist != null}">
				<c:forEach items="${advolist}" var="a">
					<div class="mySlides fade">
						<div class="numbertext">${a.rownum}/ ${adCnt}</div>
						<img src="<%=request.getContextPath()%>${a.promotionImg}"
							style="width: 100%">
					</div>
				</c:forEach>
			</c:if>
			<br>
			<div style="text-align: center;">
			<c:if test="${advolist != null}">
				<c:forEach items="${advolist}" var="a">
						<span class="dot" onclick="currentSlide(${a.rownum});"></span>
				</c:forEach>
			</c:if>
					</div>

			<a class="prev" onclick="plusSlides(-1);">&#10094;</a> <a
				class="next" onclick="plusSlides(1);">&#10095;</a>
		</div>
		<br>



	</section>
	<c:import url="/WEB-INF/index/footer.jsp" />

	<script>
  	console.log("시작");
 	var slideIndex = 1;
	var slideIndexAuto = 0;
  	
  	$(function(){
		showSlides(slideIndex);
		
		showSlidesAuto();
  	});
	
	</script>
</body>
</html>