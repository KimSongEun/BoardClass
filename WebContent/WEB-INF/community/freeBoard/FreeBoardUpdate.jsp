<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="kh.semi.boardclass.community.model.vo.Board"%>
<%@page import="java.util.ArrayList"%>
    <%
	Board board = (Board)request.getAttribute("BoardNo");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardClass</title>
<script type="text/javascript" src="./ckeditor/ckeditor.js"></script>
<link rel="icon" href="./img/dicedice.ico" type="image/x-icon" sizes="16x16">
</head>
<body>
	<c:import url="../header.jsp" />

	<nav id="c_category" class="c_category">
		<ul>
			<li><a href="./cmain">커뮤니티</a></li>
			<li><a href="#">공지사항</a></li>
			<li><a href="./cf">자유게시판</a></li>
			<li><a href="#">유저정보게시판</a></li>
			<li><a href="#">모임게시판</a></li>
		</ul>
	</nav>
	
<section>
<div class="conwrap">
	<div class="write_header">
	<h1 class="tit">자유게시판</h1>
	<div class="location">
	<span class="depth">홈     ></span>
	<span class="depth">커뮤니티     > </span><strong class="this">자유게시판</strong>
	</div>
	</div>
    <form action="<c:url value='cfupdate'/>" class="updateForm" method="post">
    <div class="title">
    	<input type="hidden" name="boardNo"  value="${board.boardNo }" readonly >
     <p> 제목</p>
     <input type="text" name="title" value="${board.boardTitle}"  required="required"><br>
   </div>
<select class = "category-select" name = "selectCategory" id = "allboard-select-main">
	            <option value="자유게시판"<c:if test = "${category=='자유게시판'}">selected</c:if>>자유게시판</option>
				<option value="유저정보게시판"<c:if test = "${category=='유저정보게시판'}">selected</c:if>>유저정보게시판</option>
				<option value="모임게시판"<c:if test = "${category=='모임게시판'}">selected</c:if>>모임게시판</option>
		</select>
	 	<select class="type-select" name="selectSubCategory" id = "allboard-select-sub">
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
   <p>내용</p>
	
	<div class="container">
	    <div class="content" style="width: 70%">
	      <div class="row justify-content-md-center">
	          <div class="col_c" style="margin-bottom: 30px">
	                <div class="input-group">                 
	                  <textarea class="form-control" id="p_content">${board.boardContent}</textarea>
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
	      </div>
	      <div class="row justify-content-md-center">
	            <div class="input-group mb-3">
	              <div class="input-group-prepend">
	                <span class="input-group-text" id="inputGroupFileAddon01">파일 추가</span>
	              </div>
	              <div class="custom-file">
	                  &nbsp;<input type="file" class="form-control-file" id="exampleFormControlFile1">
	              </div>
	            </div>
		      </div>
		  </div>
		</div>
	</textarea>
       <div>
           <input type="submit" value="글수정"/>
           <input type="reset" value="초기화"/>
       </div>
</form>
</div>


</section>

<c:import url="../footer.jsp" />
<script type="text/javascript">
$(window).on("beforeunload", function() {
	return "작성중인 글은 저장되지 않습니다. 페이지를 나가시겠습니까?";
});

$(document).ready(function() {
    $(".updateForm").on("submit", function (e) {
        $(window).off("beforeunload");
        return true; })
    });
    
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