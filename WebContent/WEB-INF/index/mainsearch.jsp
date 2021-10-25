<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<link rel="stylesheet" href="./css/index/maincss.css"/>
<title>메인검색결과페이지</title>
<style>
.div_product{
    width: 232px;
    height: 313px;
    border: 1px solid rgba(138, 138, 138, 0.993);
    margin-left: -1px;
    margin-top: -1px;
}
        
.div_product:hover{
	border: 2px solid #FFE699;
}

.div_img{
     width: 200px;
     height: 200px;
     padding: 15px;
}

.div_img img{
     width: 200px;
     height: 200px;
     object-fit: cover;
}

.div_img_text{
     width: 100%;
     height: 80px;
     overflow: hidden;
     margin-top: 1px;
}

.p_img_text{
    padding: 0px;
    margin: 0px;
    text-align: left;
    white-space: normal;
    line-height: 1.2em;
    padding-left: 14.5px;
    padding-right: 11px;
    font-family: 'Noto Sans KR light';
}
        
.div_first_game{
	display: flex;
	flex-wrap: wrap;
	margin-left: 20px;
}

.div_second_used{
	display: flex;
	flex-wrap: wrap;
	margin-left: 20px;
	margin-bottom: 50px;
}

.p_infoo_title{
	font-size: 25px;
	font-family: 'Noto Sans KR';
	margin-top: 50px;
	margin-bottom: 50px;
	margin-left: 20px;
}
.div_null{
 margin: auto;
}
.div_null p{
	text-align: center;
	font-size: 23px;
	font-family: 'Noto Sans KR light';
}
</style>
</head>
<body>
<%@include file="/WEB-INF/index/header.jsp" %>


	<p class="p_infoo_title">보드게임 검색 결과</p>
	<div class="div_first_game">
		<c:if test="${gamelist == null}">
			<div class="div_null">
				<p>"검색결과가 없습니다"</p>
			</div>
		</c:if>
		<c:if test="${gamelist != null}">
			<c:forEach var="r" items="${gamelist}">
				<div class="div_product">
					<div class="div_img">
						<a href="GameInfo?GAME_NO=${r.gameNumber}">
							<img src="${pageContext.request.contextPath}/${r.gameImage}">
						</a>
					</div>
					<div class="div_img_text">
						<p class="p_img_text">
							<a href="GameInfo?GAME_NO=${r.gameNumber}">
								${r.gameKoName}
							</a>
						</p>
					</div>
				</div>
			</c:forEach>
		</c:if>
	</div>
	<p class="p_infoo_title">중고거래 검색 결과</p>
	<div class="div_second_used">
		<c:if test="${usedlist == null}">
			<div class="div_null">
				<p>"검색결과가 없습니다"</p>
			</div>
		</c:if>
		<c:if test="${usedlist != null}">
			<c:forEach var="r" items="${usedlist}">
				<div class="div_product">
					<div class="div_img">
						<a href="usedinformation?no=${r.usedNo}">
							<img src="${pageContext.request.contextPath}/${r.usedImg}">
						</a>
					</div>
					<div class="div_img_text">
						<p class="p_img_text">
							<a href="usedinformation?no=${r.usedNo}">
								${r.usedTitle}
							</a>
						</p>
					</div>
				</div>
			</c:forEach>
		</c:if>
	</div>




<%@include file="/WEB-INF/index/footer.jsp" %>
</body>
</html>