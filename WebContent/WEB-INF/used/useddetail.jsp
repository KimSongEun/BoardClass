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
<link rel="stylesheet" href="./css/used/useddetail.css"/>
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/index/header.jsp" %>

<c:if test="${used != null}">
	<section>
		<div class="article">
		<div class="article_detail">
				<div class="div_btn">
					<c:if test="${used.userId eq userSession.userId}">
						<button type="button" onclick="conUpdate();">수정</button>
						<button type="button" onclick="conDelete();">삭제</button>
					</c:if>
				</div>
				<div class="div_title">
					${used.usedTitle}
				</div>
				<div class="div_img">
					<div class="div_thumbnail">	
						<c:choose>
							<c:when test="${used.usedImg != null}">
								<img src="${pageContext.request.contextPath}/${used.usedImg}">
							</c:when>
							<c:when test="${!used.usedImg}">
								<img src="./img/logo.png">
							</c:when>
						</c:choose>
					</div>
				</div>
				<div class="div_price">
					<span>&#8361;  ${used.usedPrice}</span>
				</div>
				<div class="div_detail">
					<table>
						<tr>
							<th>판매자</th>
							<td></td>
							<td>${used.userId}</td>
						</tr>
						<tr>
							<th>상품상태</th>
							<td></td>
							<td>
								<c:choose>
									<c:when test="${used.usedState eq '0'}">미개봉</c:when>
									<c:when test="${used.usedState eq '1'}">상태좋음</c:when>
									<c:when test="${used.usedState eq '2'}">사용흔적있음</c:when>
									<c:when test="${used.usedState eq '3'}">구성품누락</c:when>
								</c:choose>
							</td>
						</tr>
						<tr>
							<th>교환여부</th>
							<td></td>
							<td>
								<c:choose>
									<c:when test="${used.usedChange eq '0'}">교환가능</c:when>
									<c:when test="${used.usedChange eq '1'}">교환불가</c:when>
								</c:choose>
							</td>
						</tr>
						<tr>
							<th>거래방법</th>
							<td></td>
							<td>
								<c:choose>
									<c:when test="${used.usedExtype eq '0'}">직거래&amp;택배</c:when>
									<c:when test="${used.usedExtype eq '1'}">직거래</c:when>
									<c:when test="${used.usedExtype eq '2'}">택배</c:when>
								</c:choose>
							</td>
						</tr>
					</table>
				</div>
				<div class="div_contact">
					<c:if test="${used.userId != userSession.userId}">
						<div class="placement">
      						<div class="heart" id="btn_like"></div>
    					</div>
    					<div class="div_report">
							<button type="button" id="btn_report">신고하기</button>
						</div>
					</c:if>
				</div>
				<div class="div_info">
					<p class="p_info_title">상품 상세설명</p>
					<p class="p_info">${used.usedInfo}</p>
				</div>
		</div>
		</div>
	</section>
</c:if>
	
<%@include file="/WEB-INF/index/footer.jsp"%>


		
<script>
let reportedThis = false;
$(document).ready(function(){
	if("${likeresult}" == 1){
		$(".heart").toggleClass("is-active");
	}
});

function conUpdate(){
	if(window.confirm("수정하겠습니까?")){
		location.href='UsedGetUpdate?usedNo=${used.usedNo}';
	} else {
		return;
	}
}

function conDelete(){
	if(window.confirm("삭제하겠습니까?")){
		location.href='useddelete?usedNo=${used.usedNo}';
	} else {
		return;
	}
}


$("#btn_like").click(cbLike);

function cbLike(){
	if(!"${userSession}"){
		alert("로그인해주세요");
		return;
	}
	$.ajax({
		type : "post",
		url : "usedunlike.ajax",
		data : {
			loginId : "${userSession.userId}",
			thisUsedNo : "${used.usedNo}"
		},
		dataType : "json",
		success : function(receive) {
			console.log("receive값은:"  + receive);
			$(".heart").toggleClass("is-active");
		},
		error : function(request, status, error) {
			alert("code:" + request.status + "\n" + "message:"
					+ request.responseText + "\n" + "error:"
					+ error);
		}
	});
}

$("#btn_report").click(cbReport);

function cbReport(){
	if(!"${userSession}"){
		alert("로그인해주세요");
		return;
	}
	if("${reportresult}" == 1){
		alert("이미 신고하셨습니다.");
		reportedThis = true;
		return;
	}
	if(reportedThis){
		alert("이미 신고하셨습니다.");
		return;
	}
	$.ajax({
		type : "post",
		url : "usedreport.ajax",
		data : {
			loginId : "${userSession.userId}",
			thisUsedNo : "${used.usedNo}"
		},
		dataType : "json",
		success : function(receive) {
			console.log("신고receive값은:"+receive);
			if(receive<1){
				reportedThis = true;
				alert("이미 접수되었습니다");
				return;
			}
			reportedThis = true;
			alert("신고가 접수되었습니다.");
		},
		error : function(request, status, error) {
			alert("code:" + request.status + "\n" + "message:"
					+ request.responseText + "\n" + "error:"
					+ error);
		}
	});
}

</script>
</body>
</html>