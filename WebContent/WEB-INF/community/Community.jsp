<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardClass</title>
<link rel="stylesheet" href="css/community/community.css" />
<link rel="stylesheet" href="css/community/common.css" />
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
			<li><a href="#">공지사항</a></li>
			<li><a href="./cf">자유게시판</a></li>
			<li><a href="./cu">유저정보게시판</a></li>
			<li><a href="./cg">모임게시판</a></li>
		</ul>
		</nav>
		</div>
	</aside>
	
<section>


<div class="conwrap">
<div class="h3group mb30">
	<h3 class="tit">커뮤니티</h3>
</div>

<article class="best">
	<div class="h4group bdb_n">
	    <h4 class="tit">인기글</h4>
	</div>
  	<div class="board_rank_wrap">
    <div class="rbox">
      <dl>
      	<dt>자유게시판 인기글</dt>
       <dd>
       	<ol>
       		<li>
              <div class="rank">1</div>
              <a href="#" class="tit">내용</a>
              <div class="commt">댓글수</div>
            </li>
            <li>
              <div class="rank">2</div>
              <a href="#" class="tit">내용</a>
              <div class="commt">댓글수</div>
            </li>
            <li>
              <div class="rank">3</div>
              <a href="#" class="tit">내용</a>
              <div class="commt">댓글수</div>
            </li>
            <li>
              <div class="rank">4</div>
              <a href="#" class="tit">내용</a>
              <div class="commt">댓글수</div>
            </li>
            <li>
              <div class="rank">5</div>
              <a href="#" class="tit">내용</a>
              <div class="commt">조회수</div>
            </li>
          </ol>
        </dd>
      </dl>
    </div>
    <div class="cbox">
      <dl>
        <dt>유저정보게시판 인기글</dt>
        <dd>
          <ol>
            <li>
              <div class="rank">1</div>
              <a href="#" class="tit">내용</a>
              <div class="commt">댓글수</div>
            </li>
            <li>
              <div class="rank">2</div>
              <a href="#" class="tit">내용</a>
              <div class="commt">댓글수</div>
            </li>
            <li>
              <div class="rank">3</div>
              <a href="#" class="tit">내용</a>
              <div class="commt">댓글수</div>
            </li>
            <li>
              <div class="rank">4</div>
              <a href="#" class="tit">내용</a>
              <div class="commt">댓글수</div>
            </li>
            <li>
              <div class="rank">5</div>
              <a href="#" class="tit">내용</a>
              <div class="commt">조회수</div>
            </li>
          </ol>
        </dd>
      </dl>
    </div>
   	</div>
</article>


	<div class="h4group">
		<h4 class="tit">전체글 보기</h4>
	</div>
	
	
	
	<table class="c_table">
	<tr>
	<td style="width: 10%; text-align: center;">번호</td>
	<td style="width: 40%; text-align: center;">제목</td>
	<td style="width: 10%; text-align: center;">작성자</td>
	<td style="width: 10%; text-align: center;">날짜</td>
	<td style="width: 10%; text-align: center;">조회수</td>
	</tr>
	<c:if test="${totCnt > 0 }">
	<c:forEach var="board" items="${list }">
		<tr>
			<td style="width: 10%; font-size: 18px; text-align: center;">
				${board.boardNo }
			</td>
			<td style="width: 40%; font-weight: bold; font-size: 18px">
				<a href="cfdetail?boardNo=${board.boardNo }&pageNum=${currentPage}">${board.boardTitle }</a>
			</td>
			<td style="width: 10%; text-align: center;">${board.userId }</td>
			<td style="width: 10%;">${board.boardWriteDate }</td>
			<td style="width: 10%; text-align: center;">${board.boardViewCount }</td>
		</tr>
	</c:forEach>
	</c:if>
	<c:if test="${totCnt == 0 }">
		<tr>
			<td colspan="7">데이터가 없습니다</td>
		</tr>
	</c:if>
	</table>
	</div>
	
</div>

</section>
<%@include file="/WEB-INF/index/footer.jsp" %>
</body>
</html>