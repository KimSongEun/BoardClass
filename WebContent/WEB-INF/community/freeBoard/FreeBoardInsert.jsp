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
<title>자유게시판 새글쓰기</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">
<link rel="stylesheet" href="./css/community/wrtite.css" />
<script type="text/javascript" src="./ckeditor/ckeditor.js"></script>
<style>
	section {margin: 0 0 20px; padding: 30px 30px 60px; background:#fff;}
	.write_header {overflow:hidden; margin: -30px -30px 0; padding: 30px; border-bottm:1px solid #e6e6e8; backgorund:#fff;}
	.write_header .location .depth {display: block; float: left; position: relative; font-size: 14px; line-height: 44px; color:#777;}
	.write_header .location .this {display: block; float:left; font-weight: 700; font-size:14px; line-height: 44px; color:#2d2d2d;}
	section .write_header h1 { font-weight: 700; font-size: 30px; color:#2d2d2d;}
	section .title input {
	width: 785px;
	height: 30px;
	}
	section .title input:focus {
	border-color: 
	}
</style>
</head>
<body>
<%@include file="/WEB-INF/community/header.jsp" %>
<section>
	<div class="write_header">
	<h1 class="tit">자유게시판</h1>
	<div class="location">
	<span class="depth">홈     ></span>
	<span class="depth">커뮤니티     > </span><strong class="this">자유게시판</strong>
	</div>
	</div>

    <form method="post" action="cfwrite" >
    <div class="title">
    	<input type="hidden" name="bno"  value="<%=boardNo%>" readonly >
     <p> 제목</p>
     <input type="text" name="title" required="required"><br>
   </div>
   <p>내용</p>
<textarea class ="form-control" id="p_content" required="required">
<div class="container">
    <div class="content" style="width: 70%">
      <div class="row justify-content-md-center">
          <div class="col_c" style="margin-bottom: 30px">
                <div class="input-group">                 
                  <textarea class="form-control" id="p_content"></textarea>
                  <script type="text/javascript">
                  CKEDITOR.replace('p_content' , {
                	  	height: 500,
	              		width: 825,
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
<input type="submit" value="등록">
</form>
<%@include file="/WEB-INF/community/footer.jsp" %>
</section>
</body>
</html>