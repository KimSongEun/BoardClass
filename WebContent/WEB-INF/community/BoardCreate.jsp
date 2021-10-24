<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kh.semi.boardclass.community.model.vo.Board"%>
<% 
	String boardNo = request.getParameter("board_no");
	if(boardNo == null || boardNo.equals("")) {
		boardNo="";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardClass</title>
<link rel="stylesheet" href="css/community/reset.css" />
<link rel="stylesheet" href="css/community/write.css" />
<link rel="stylesheet" href="css/community/common.css" />
<script type="text/javascript" src="./ckeditor/ckeditor.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
</head>
<body>
<%@include file="/WEB-INF/index/footer.jsp" %>
<div id="guide">
	<aside id="aside" class="c_category">
		<div class="as_inner">
		<h2 class="as_hgroup"><a href="./cmain">커뮤니티</a></h2>
		<nav id="lnb" class="lnb">
			<ul>
				<li><a href="#">공지사항</a></li>
				<li><a href="./cf">자유게시판</a></li>
				<li><a href="./cg">유저정보게시판</a></li>
				<li><a href="./cu">모임게시판</a></li>
			</ul>
		</nav>
		</div>
	</aside>
	
<section>
<div class="conwrap">
	<div class="h3group mb30">
	<h1 class="tit">커뮤니티 </h1>
	<div class="location">
	<span class="depth">홈     ></span>
	<span class="depth">커뮤니티     > </span><strong class="this">글 작성</strong>
	</div>
	</div>
    <form method="post" action="boardcreate" >
    <div class="hgroup">
    	
     <p class="tit">제목</p>
     <input type="text" name="title" required="required"><br>
	<select class = "category-select" name = "category" id = "allboard-select-main">
	            <option value="자유게시판"<c:if test = "${category=='자유게시판'}">selected</c:if>>자유게시판</option>
				<option value="유저정보게시판"<c:if test = "${category=='유저정보게시판'}">selected</c:if>>유저정보게시판</option>
				<option value="모임게시판"<c:if test = "${category=='모임게시판'}">selected</c:if>>모임게시판</option>
		</select>
	 	<select class="type-select" name="type" id = "allboard-select-sub">
		 	<c:if test="${category=='자유게시판'}"> 
				<option value="사담"<c:if test = "${type=='사담'}">selected</c:if>>사담</option>
				<option value="건의"<c:if test = "${type=='건의'}">selected</c:if>>건의</option>
				<option value="질문"<c:if test = "${type=='질문'}">selected</c:if>>질문</option>
			</c:if>
			<c:if test="${category=='유저정보게시판'}"> 
				<option value="기사"<c:if test = "${type=='기사'}">selected</c:if>>기사</option>
				<option value="후기"<c:if test = "${type=='후기'}">selected</c:if>>후기</option>
				<option value="공식"<c:if test = "${type=='공식'}">selected</c:if>>공식</option>
				<option value="팁"<c:if test = "${type=='팁'}">selected</c:if>>팁</option>
			</c:if>
				<c:if test="${category =='모임게시판'}"> 
				<option value="모임후기"<c:if test = "${type=='모임후기'}">selected</c:if>>모임후기</option>
				<option value="모집"<c:if test = "${type=='모집'}">selected</c:if>>모집</option>
				<option value="일정안내"<c:if test = "${type=='일정안내'}">selected</c:if>>일정안내</option>
			</c:if>
		</select>
	</div>
	          <div class="col_c" style="margin-bottom: 30px; width: 70%">
	                <div class="input-group">                 
	                  <textarea class="form-control" name="content" id="p_content"  required="required"></textarea>
	                  <script type="text/javascript">
	                  CKEDITOR.replace('p_content' , {
	                	  	height: 500,
		              		width: 750,
		            		language: 'ko',
		            		fontSize_defaultLabel: '12',
		            		font_names: '맑은 고딕/Malgun Gothic;굴림/Gulim;돋움/Dotum;바탕/Batang;궁서/Gungsuh;Arial/Arial;Comic Sans MS/Comic Sans MS;Courier New/Courier New;Georgia/Georgia;Lucida Sans Unicode/Lucida Sans Unicode;Tahoma/Tahoma;Times New Roman/Times New Roman;MS Mincho/MS Mincho;Trebuchet MS/Trebuchet MS;Verdana/Verdana',
		            		font_defaultLabel: '맑은 고딕/Malgun Gothic'});
	                  </script>
	                </div>
	            </div> 
	<button class='btn btn-warning' value='등록' type="submit">등록</button>
		
</form>
</div>


</section>
</div>
<%@include file="/WEB-INF/index/footer.jsp" %>
<script type="text/javascript">

$(".category-select").change(selectCategory);  
function selectCategory() {
	console.log("변경");
	var index = $(".category-select").index(this);
	var free = ["사담", "건의", "질문"];
	var userInfo = [ "기사", "후기", "공식", "팁"];
	var party = [ "모임후기", "모집", "일정안내"];
	var selectItem = $(".category-select").eq(index).val();
	var changeItem;
	if (selectItem == "자유게시판") {
		changeItem = free;
	} else if (selectItem == "유저정보게시판") {
		changeItem = userInfo;
	} else if (selectItem == "모임게시판") {
		changeItem = party;
	} 
	$('.type-select').eq(index).empty();
	for (var count = 0; count < changeItem.length; count++) {
		var option = $("<option>" + changeItem[count] + "</option>");
		$('.type-select').eq(index).append(option);
	}
};
</script>
</body>
</html>