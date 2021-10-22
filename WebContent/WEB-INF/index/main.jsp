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
		<!--BC 검색창 넣을 부분 -->
		<br>
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

		 <div class="notice-div" style="margin:0 auto;">
                <table class="table  notice-table" style="text-align: center;">
                    <colgroup>
	                   	<col width="100px">
	                   	<col width="300px">
	                   	<col width="150px">
                   	</colgroup>
                    <thead>
                        <tr>
                            <td colspan="2" style="text-align:left; font-size: 18px; font-weight: bold; padding-left:20px"> 📋 공지사항</td>
                            <td style = "font-size : 10px; text-align:right;"><a href = "#공지사항으로이동">+더보기</a></td>
                        </tr>
                    </thead>
                    <tbody>
                    <tr style="text-align:center; font-size: 16px; font-weight: bold;">
                        <td>공지 번호</td>
                        <td>공지 제목</td>
                        <td>공지 작성일</td>
                    </tr>
			<c:if test="${noticevolist != null}">
				<c:forEach items="${noticevolist}" var="n">						 
                    <tr>
                        <td>${n.announceNo}</td>
                        <td style="white-space : nowrap; text-overflow : ellipsis; overflow : hidden" title = "${n.adminTitle}"><a href="#공지가항보러가깅" style = "color : #754100;">${n.adminTitle}</a></td>
                        <td>${n.adminRwrDate}</td>
                    </tr>
                   </c:forEach>
                   </c:if>
                   </tbody>
                </table>
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