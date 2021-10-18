<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardClass</title>
<script type="text/javascript" src="./ckeditor/ckeditor.js"></script>
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
    <form action="<c:url value='cfupdate'/>" method="post">
    <div class="title">
    	<input type="hidden" name="boardNo"  value="${board.boardNo }" readonly >
     <p> 제목</p>
     <input type="text" name="title" value="${board.boardTitle}"  required="required"><br>
   </div>
	<select name="type" id="type">
				<option>사담</option>
				<option>건의</option>
				<option>질문</option>
	</select>
   <p>내용</p>
	<textarea class ="form-control" name="content" id="p_content" required="required">
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
</body>
</html>