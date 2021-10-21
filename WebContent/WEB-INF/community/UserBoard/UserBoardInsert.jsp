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
</head>
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
	<h1 class="tit">유저정보게시판</h1>
	<div class="location">
	<span class="depth">홈     ></span>
	<span class="depth">커뮤니티     > </span><strong class="this">유저정보게시판</strong>
	</div>
	</div>
    <form method="post" action="cuwrite" >
    <div class="hgroup">
    	<input type="hidden" name="bno"  value="<%=boardNo%>" readonly >
     <p class="tit">제목</p>
     <input type="text" name="title" required="required"><br>
	<select name="type" id="type">
				<option>기사</option>
				<option>후기</option>
				<option>공식</option>
				<option>팁</option>
	</select>
	</div>
	<textarea class ="form-control" name="content" id="p_content" required="required">
	
	    <div class="content" style="width: 70%">
	     
	          <div class="col_c" style="margin-bottom: 30px">
	                <div class="input-group">                 
	                  <textarea class="form-control" id="p_content"></textarea>
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
	   
	              <div class="input-group-prepend">
	                <span class="input-group-text" id="inputGroupFileAddon01">파일 추가</span>
	              </div>
	              <div class="custom-file">
	                  &nbsp;<input type="file" class="form-control-file" id="exampleFormControlFile1">
	              </div>
		      
		</div>
		
	</textarea>
		<input type="submit" value="등록">
</form>
</div>


</section>
</div>
<%@include file="/WEB-INF/index/footer.jsp" %>
</html>