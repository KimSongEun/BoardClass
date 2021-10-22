<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardClass</title>
<link rel="stylesheet" href="css/community/common.css" />
<link rel="stylesheet" href="css/community/freeBoardMain.css" />
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
</head>
<body>
<%@include file="/WEB-INF/index/header.jsp" %>

<div id="guide" class="row">
	
	<aside id="aside" class="c_category">
		<div class="as_inner">
		<h2 class="as_hgroup"><a href="./cmain">커뮤니티</a></h2>
		<nav id="lnb" class="lnb">
			<ul>
				<li><a href="./cnotice">공지사항</a></li>
				<li><a href="./cf">자유게시판</a></li>
				<li><a href="./cu">유저정보게시판</a></li>
				<li><a href="./cg">모임게시판</a></li>
			</ul>
		</nav>
		</div>
	</aside>
	
	<div id= "contents">
<div class="conwrap pb30">
<section id="boardlsit">
	<div class="h3group ">
		<h3 class="tit">공지사항</h3>
		<div class="location">
			<span class="depth">홈</span>
			<span class="depth">커뮤니티</span><strong class="this">공지사항</strong>
		</div>
	</div>
<div class="conwrap">
	<div class="h4group">
		<h4 class="tit">공지글 보기</h4>
	</div>
	
	<!-- 글 리스트 -->
	<div class="tbl_list">
		<table>
		<tbody>
		<colgroup>
			<col style="width: 58px;">
			<col style="width: auto;">
			<col style="width: 172px;">
		</colgroup>
			<c:if test="${noticevolist != null }">
			<c:forEach var="notice" items="${noticevolist }">
				<tr>
					<td class="idx">
						${notice.announceNo }
					</td>
					
					<td class="obj">
						<div class="tbox">
						<div class="tit">
							<a href="cnoticedetail?announceNo=${notice.announceNo }">${notice.adminTitle }</a>
						</div>
						</div>
					
					</td>
			
					<td class="etc">
						<div class="userid">관리자</div>
						<div class="date">${notice.adminWrDate }</div>
					</td>
				
				</tr>
			</c:forEach>
			</c:if>
			<c:if test="${noticevolist == null }">
				<tr>
					<td colspan="7">데이터가 없습니다</td>
				</tr>
			</c:if>
			</tbody>
		</table>
		</div>
	</section>
	
		<!-- 페이징  -->

            
	<div style="text-align: centerl; margin-top:20px;" class="pagination">
		<c:if test="${startPage > blockSize }">
			<a href="nmain?pageNum=${startPage-blockSize}">[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:if test="${pageNum == i }">
				<a href="nmain?pageNum=${i }" style="color: blue;">[${i }]</a>
			</c:if>
		<c:if test="${pageNum != i }">
			<a href="nmain?pageNum=${i }">[${i }]</a>
		</c:if>
		</c:forEach>
		<c:if test="${endPage < pageCnt }">
			<a href="nmain?pageNum=${startPage + blockSize }">[다음]</a>
		</c:if>
 	</div>
            
	
	
	
	
	
<script>
//change 될때마다 getListAjax
$(function(){
	$('#b_category').on('change', getList);
});
	function getList(){
		console.log("ajax 시작부분");
		$.ajax({
			type:"post",
			url: 'commlist',
			data: { category : $('#b_category').val()},
			dataType: 'json',
			success: function(data) {
				if(data.result == "ok") {
					$('#a1').html("");
					for(var i=0; i<data.volist.length; i++){
						var newNode = '<p id="id_'+data.volist[i].boardNo+'"><a href="#">'+data.volist[i].boardNo+'</a>  | '+data.volist[i].boardTitle+'</p>'; 
						$('#a1').append(newNode);
					}
				}else {
					
				}
			}
		});//ajax
	}
	
	
	
</script>
	
	
<%@include file="/WEB-INF/index/footer.jsp" %>
</body>
</html>