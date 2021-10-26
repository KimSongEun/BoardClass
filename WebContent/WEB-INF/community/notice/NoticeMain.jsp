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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<style>
body{
display: felx;
}
</style>
</head>
<body>
<%@include file="/WEB-INF/index/header.jsp" %>

<div id="guide" class="row">
	
	<aside id="aside" class="c_category">
		<div class="as_inner">
		<h2 class="as_hgroup"><a href="./cmain">커뮤니티</a></h2>
		<nav id="lnb" class="lnb">
			<ul>
				<li><a href="./nmain" style="color:#ffd642;">공지사항</a></li>
				<li><a href="./cf">자유게시판</a></li>
				<li><a href="./cu" >유저정보게시판</a></li>
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

		<!-- 검색창 -->
	<div class="data_srch_wrap bdt_n ">
		<form action = "searchnoticetitle" method = "post" class = "searchselect">
				<select class="search_select" name="type" style="width: 189px;">
					<option value="제목" <c:if test = "${type == '제목'}"> selected </c:if>>제목</option>
					<option value="내용" <c:if test = "${type == '내용'}"> selected </c:if>>내용</option>
				</select>
				<input type="text" id="keyword" name="keyword" class="ipt" value="${keyword }" placeholder="검색어를 입력해주세요">
				<button type="submit"><i class="fa fa-search"></i></button>
		 </form>
	
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
			<a href="nmain?pageNum=${startPage-blockSize}" style="color:#555;">[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:if test="${pageNum == i }">
				<a href="nmain?pageNum=${i }" style="color:#555;">[${i }]</a>
			</c:if>
		<c:if test="${pageNum != i }">
			<a href="nmain?pageNum=${i }" style="color:#555;">[${i }]</a>
		</c:if>
		</c:forEach>
		<c:if test="${endPage < pageCnt }">
			<a href="nmain?pageNum=${startPage + blockSize }" style="color:#555;">[다음]</a>
		</c:if>
 	</div>
            
</div>
</div>
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
	
	$(".search_select").change(f1);
	f1();
	function f1() {
		console.log("변경");
		if($(".search_select").val() == "제목"){
			$(".searchselect").attr("action", "searchnoticetitle");
			
			
		} else if ($(".search_select").val() == "내용") {
			$(".searchselect").attr("action", "searchnoticecontent");	
			
		}
	};	
	
	
	
	
</script>
	
	
<%@include file="/WEB-INF/index/footer.jsp" %>
</body>
</html>