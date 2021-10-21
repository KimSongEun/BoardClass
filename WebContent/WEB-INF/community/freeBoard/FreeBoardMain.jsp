<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="kh.semi.boardclass.community.model.vo.Board"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardClass</title>
<link rel="stylesheet" href="css/community/freeBoardMain.css" />
<link rel="stylesheet" href="css/community/common.css" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js" ></script>

</head>
<body>
<%@include file="/WEB-INF/index/header.jsp" %>

<div id="guide" class="row">
	
	<aside id="aside" class="c_category">
		<div class="as_inner">
		<h2 class="as_hgroup"><a href="./cmain">커뮤니티</a></h2>
		<nav id="lnb" class="lnb">
			<ul>
				<li><a href="#">공지사항</a></li>
				<li><a href="./cf">자유게시판</a></li>
				<li><a href="./cu">유저정보게시판</a></li>
				<li><a href="./cg">모임게시판</a></li>
			</ul>
		</nav>
		</div>
	</aside>
		
		 <!-- TODO 링크 첨부 -->
		 
<div id= "contents">
<div class="conwrap pb30">
<section id="boardlsit">
	<div class="h3group ">
		<h3 class="tit">자유게시판</h3>
		<div class="location">
			<span class="depth">홈</span>
			<span class="depth">커뮤니티</span><strong class="this">자유게시판</strong>
		</div>
	</div>
<div class="conwrap">
	<div class="h4group">
		<h4 class="tit">전체글 보기</h4>
	</div>
	
	<!-- 검색 영역 -->
	<div class="data_srch_wrap bdt_n ">
		<form action = "searchallboarduserid" method = "post" class = "searchselect">
		<div class="slt_box">
			<select class="search_select" name="type" style="width: 189px;">
				<option value="제목" <c:if test = "${type == '제목'}"> selected </c:if>>제목</option>
				<option value="내용" <c:if test = "${type == '내용'}"> selected </c:if>>내용</option>
				<option value="작성자" <c:if test = "${type == '작성자'}"> selected </c:if>> 작성자 </option>
				</select>
		</div>
		<div class="ipt_box">
			<input type="text" id="keyword" name="keyword" class="ipt" value="${keyword }" placeholder="검색어를 입력해주세요">
			 <button type="submit" class="w3-button w3-light-grey"></button>
		</div>
		
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
			<c:if test="${list != null }">
			<c:forEach var="board" items="${list }">
				<tr>
					<td class="idx">
						${board.boardNo }
						<div class="hidden" >${board.boardCategory }</div>
					</td>
					
					<td class="obj">
						<div class="tbox">
						<div class="tit">
							${board.boardType }
							<a href="cfdetail?boardNo=${board.boardNo }">${board.boardTitle }</a>
						</div>
						</div>
						<div class="util">
							<div class="hit">조회수 : <span class="val">${board.boardViewCount }</span></div>
							<div class="comt">댓글수: <span class="val">2</span> </div>
						</div>
					
					</td>
			
					<td class="etc">
						<div class="userid">${board.userId }</div>
						<div class="date">${board.boardWriteDate }</div>
					</td>
			
				</tr>
			</c:forEach>
			</c:if>
			<c:if test="${list == null }">
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
			<a href="cf?pageNum=${startPage-blockSize}">[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:if test="${pageNum == i }">
				<a href="cf?pageNum=${i }" style="color: blue;">[${i }]</a>
			</c:if>
		<c:if test="${pageNum != i }">
			<a href="cf?pageNum=${i }">[${i }]</a>
		</c:if>
		</c:forEach>
		<c:if test="${endPage < pageCnt }">
			<a href="cf?pageNum=${startPage + blockSize }">[다음]</a>
		</c:if>
 	</div>
	
	<div class="btn_wrap">
  <div class="fl_c">
    <a href="./cfwrite" class="btn50 c3 reg" style="width: 240px;" tmp="contents/bod" mn="60" cn="0"><span class="write">글작성</span></a>
  </div>
</div>
	
	<!-- 검색 영역 -->



	
	
	
	
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
			$(".searchselect").attr("action", "searchallboardtitle");
			
			
		} else if ($(".search_select").val() == "내용") {
			$(".searchselect").attr("action", "searchallboardcontent");
			
			
		}else if ($(".search_select").val() == "작성자") {
			$(".searchselect").attr("action", "searchallboarduserid");
			
		}
	};	

	
	
</script>



<%@include file="/WEB-INF/index/footer.jsp" %>
</body>
</html>