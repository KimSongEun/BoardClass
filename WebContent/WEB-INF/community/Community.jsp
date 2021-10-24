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
<style>
/* 사이드 */
/* input[type="radio"] { display: none; } */
input:nth-of-type(1) { display: none; }
input:nth-of-type(2) { display: none; }

/* input ~ div {display:none;} */
input:nth-of-type(1) ~ div:nth-of-type(1){display:none;}
input:nth-of-type(2) ~ div:nth-of-type(2){display:none;}
/* 눌려진 div 보이게 */
input:nth-of-type(1):checked ~ div:nth-of-type(1) {display: block;}
input:nth-of-type(2):checked ~ div:nth-of-type(2) {display: block;}

/* 탭모양 */
.cbox > label {
    display: block; float: right;

    text-align: center;
    line-height: 30px;

    border: 1px solid black;
    box-sizing: border-box;

    background-color: black;
    color: white;
}
input:nth-of-type(1):checked ~ label:nth-of-type(1) {
    background-color: white;
    color:black;
}
input:nth-of-type(2):checked ~ label:nth-of-type(2){
    background-color: white;
    color:black;
}
/* 탭목록 */
.tab_item .item {
    overflow: hidden;
    padding: 10px;
    border: 1px solid black;
    border-top: none;
}
.item .thumbnail {
    float: left;
}
.item .description {
    float: left;
    margin-left: 10px;
    width: 120px;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
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
			<li><a href="./nmain">공지사항</a></li>
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
		 			 <c:forEach var="freebest" items="${bestfreeone }">
			 			<li>
				 			 <div class="rank">1</div>
				              <a href="bdetail?boardNo=${freebest.boardNo }" class="tit">${freebest.boardTitle }</a>
				              <div class="commt">${freebest.boardViewCount }</div>
			             </li>
		             </c:forEach>
		             <c:forEach var="freebest" items="${bestfreetwo }">
			 			<li>
				 			<div class="rank">2</div>
			              <a href="bdetail?boardNo=${freebest.boardNo }" class="tit">${freebest.boardTitle }</a>
			           	  <div class="commt">${freebest.boardViewCount }</div>
			             </li>
		             </c:forEach>
		            <c:forEach var="freebest" items="${bestfreethree }">
			 			<li>
			 			 <div class="rank">3</div>
			              <a href="bdetail?boardNo=${freebest.boardNo }" class="tit">${freebest.boardTitle }</a>
			              <div class="commt">${freebest.boardViewCount }</div>
			             </li>
		             </c:forEach>
		              <c:forEach var="freebest" items="${bestfreefour }">
			 			<li>
			 			 <div class="rank">4</div>
			              <a href="bdetail?boardNo=${freebest.boardNo }" class="tit">${freebest.boardTitle }</a>
			              <div class="commt">${freebest.boardViewCount }</div>
			            </li>
		             </c:forEach>
		             <c:forEach var="freebest" items="${bestfreefive }">
			 			<li>
			 			 <div class="rank">5</div>
			              <a href="bdetail?boardNo=${freebest.boardNo }" class="tit">${freebest.boardTitle }</a>
			              <div class="commt">${freebest.boardViewCount }</div>
			            </li>
		             </c:forEach>
		            
	       		</ol>
	   		
		</dd>
	</dl>
    </div>
<div class="board_rank_wrap">
    <div class="cbox">
     <dl>
      	<dt>자유게시판 인기글</dt>
    
		 <dd>	
         <input type="radio" id="r_first" name="tab" checked>
         <input type="radio" id="r_second" name="tab">
         <label for="r_first">조회순</label>
         <label for="r_second">댓글순</label>
         <br>
          <div class="tab_item">
          	<ol>
         		<c:forEach var="freebest" items="${bestfreeone }">
		 			<li>
			 			 <div class="rank">1</div>
			              <a href="bdetail?boardNo=${freebest.boardNo }" class="tit">${freebest.boardTitle }</a>
			              <div class="commt">${freebest.boardViewCount }</div>
		             </li>
	             </c:forEach>
	             <c:forEach var="freebest" items="${bestfreetwo }">
		 			<li>
			 			<div class="rank">2</div>
		              <a href="bdetail?boardNo=${freebest.boardNo }" class="tit">${freebest.boardTitle }</a>
		           	  <div class="commt">${freebest.boardViewCount }</div>
		             </li>
	             </c:forEach>
	            <c:forEach var="freebest" items="${bestfreethree }">
		 			<li>
		 			 <div class="rank">3</div>
		              <a href="bdetail?boardNo=${freebest.boardNo }" class="tit">${freebest.boardTitle }</a>
		              <div class="commt">${freebest.boardViewCount }</div>
		             </li>
	             </c:forEach>
	              <c:forEach var="freebest" items="${bestfreefour }">
		 			<li>
		 			 <div class="rank">4</div>
		              <a href="bdetail?boardNo=${freebest.boardNo }" class="tit">${freebest.boardTitle }</a>
		              <div class="commt">${freebest.boardViewCount }</div>
		            </li>
	             </c:forEach>
	             <c:forEach var="freebest" items="${bestfreefive }">
		 			<li>
		 			 <div class="rank">5</div>
		              <a href="bdetail?boardNo=${freebest.boardNo }" class="tit">${freebest.boardTitle }</a>
		              <div class="commt">${freebest.boardViewCount }</div>
		            </li>
	             </c:forEach>
          	</ol>
          	</dt>
          	</dl>
          </div>
           <div class="tab_item">
           <dl>
           	<dt>
           	<ol>
           		<c:forEach var="freebest" items="${bestfreeone }">
		 			<li>
			 			 <div class="rank">1</div>
			              <a href="bdetail?boardNo=${freebest.boardNo }" class="tit">${freebest.boardTitle }</a>
			              <div class="commt">${freebest.comment_no }</div>
		             </li>
	             </c:forEach>
	             <c:forEach var="freebest" items="${bestfreetwo }">
		 			<li>
			 			<div class="rank">2</div>
		              <a href="bdetail?boardNo=${freebest.boardNo }" class="tit">${freebest.boardTitle }</a>
		           	  <div class="commt">${freebest.comment_no }</div>
		             </li>
	             </c:forEach>
	            <c:forEach var="freebest" items="${bestfreethree }">
		 			<li>
		 			 <div class="rank">3</div>
		              <a href="bdetail?boardNo=${freebest.boardNo }" class="tit">${freebest.boardTitle }</a>
		              <div class="commt">${freebest.comment_no }</div>
		             </li>
	             </c:forEach>
	              <c:forEach var="freebest" items="${bestfreefour }">
		 			<li>
		 			 <div class="rank">4</div>
		              <a href="bdetail?boardNo=${freebest.boardNo }" class="tit">${freebest.boardTitle }</a>
		              <div class="commt">${freebest.comment_no }</div>
		            </li>
	             </c:forEach>
	             <c:forEach var="freebest" items="${bestfreefive }">
		 			<li>
		 			 <div class="rank">5</div>
		              <a href="bdetail?boardNo=${freebest.boardNo }" class="tit">${freebest.boardTitle }</a>
		              <div class="commt">${freebest.comment_no }</div>
		            </li>
	             </c:forEach>
	        </ol>
	           </dt>
          	</dl>
           </div>
    </div>
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
				<a href="bdetail?boardNo=${board.boardNo }&pageNum=${currentPage}">${board.boardTitle }</a>
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