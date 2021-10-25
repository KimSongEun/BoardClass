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
.tab {
  overflow: hidden;
  border-bottom: 1px solid #ccc;
}
.tab button {
  background-color: inherit;
  float: right;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 10px;
  transition: 0.3s;
  font-size: 12px;
}
.tab button:hover {
  background-color: #FFE699;
}

.tab button.active {
  background-color: #FFE699;
}

.usercontent {
  display: none;
}
.usercontent {
  display: none;
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


	<div class="conwrap pb30">
	<div class="h3group mb30">
		<h3 class="tit">커뮤니티</h3>
	</div>
	
		<div class="h4group bdb_n">
		    <h4 class="tit">인기글</h4>
		</div>
		
		<div class="board_rank_wrap">
	    <div class="rbox">
	     <dl>
	     	<dt>자유게시판 인기글</dt>
			 	<dd>
			    <div class="tab">
		  			<button class="tablinks" onclick="openRank(event, 'leftview')" id="defaultOpen" >조회순</button>
		  			<button class="tablinks" onclick="openRank(event, 'leftcomt')">댓글순</button>
		  			<button class="tablinks" onclick="openRank(event, 'leftlike')">추천순</button>
				</div>
			          <div class="tabcontent" id="leftview">
			          	<ol>
			         		<c:forEach var="freebest" items="${bestfreeone }">
					 			<li class="item">
						 			 <div class="rank">1</div>
						              <a href="bdetail?boardNo=${freebest.boardNo }" class="tit">${freebest.boardTitle }</a>
						              <div class="commt">${freebest.boardViewCount }</div>
					             </li>
				             </c:forEach>
				             <c:forEach var="freebest" items="${bestfreetwo }">
					 			<li class="item">
						 			<div class="rank">2</div>
					              <a href="bdetail?boardNo=${freebest.boardNo }" class="tit">${freebest.boardTitle }</a>
					           	  <div class="commt">${freebest.boardViewCount }</div>
					             </li>
				             </c:forEach>
				            <c:forEach var="freebest" items="${bestfreethree }">
					 			<li class="item">
					 			 <div class="rank">3</div>
					              <a href="bdetail?boardNo=${freebest.boardNo }" class="tit">${freebest.boardTitle }</a>
					              <div class="commt">${freebest.boardViewCount }</div>
					             </li>
				             </c:forEach>
				              <c:forEach var="freebest" items="${bestfreefour }">
					 			<li class="item">
					 			 <div class="rank">4</div>
					              <a href="bdetail?boardNo=${freebest.boardNo }" class="tit">${freebest.boardTitle }</a>
					              <div class="commt">${freebest.boardViewCount }</div>
					            </li>
				             </c:forEach>
				             <c:forEach var="freebest" items="${bestfreefive }">
					 			<li class="item">
					 			 <div class="rank">5</div>
					              <a href="bdetail?boardNo=${freebest.boardNo }" class="tit">${freebest.boardTitle }</a>
					              <div class="commt">${freebest.boardViewCount }</div>
					            </li>
				             </c:forEach>
			          	</ol>
			          	</div>
		          	</dd>
		          	</dl>
		          	<dl>
		          	<dd>
			    		<div class="tabcontent" id="leftcomt">
			    			<ul>
				           		<c:forEach var="freebest" items="${bestfreecomt }">
						 			<li class="item">
							 			 <div class="rank">${freebest.boardRank }</div>
							              <a href="bdetail?boardNo=${freebest.boardNo }" class="tit">${freebest.boardTitle }</a>
							              <div class="commt">${freebest.commentCount}</div>
						             </li>
					             </c:forEach>
					       	 </ul>	
				        </div>
				       </dd>
			         </dl>
			         <dl>
		          	<dd>
			    		<div class="tabcontent" id="leftlike">
			    			<ul>
				           		<c:forEach var="freebest" items="${bestfreelike }">
						 			<li class="item">
							 			 <div class="rank">${freebest.boardRank }</div>
							              <a href="bdetail?boardNo=${freebest.boardNo }" class="tit">${freebest.boardTitle }</a>
							              <div class="commt">${freebest.boardLikeCount}</div>
						             </li>
					             </c:forEach>
					       	 </ul>	
				        </div>
				       </dd>
			         </dl>
		    </div>   
		   	</div>
	  	<div class="board_rank_wrap">
	    <div class="cbox">
	      <dl>
	      	<dt>유저정보게시판 인기글</dt> 
			 <dd>	
				<div class="tab">
		  			<button class="userlinks" onclick="userRank(event, 'rightview')" id="defaultOpen2" >조회순</button>
		  			<button class="userlinks" onclick="userRank(event, 'rightcomt')">댓글순</button>
		  			<button class="userlinks" onclick="userRank(event, 'rightlike')">추천순</button>
				</div>
			 	<dl>
		          	<dd>
			    		<div class="usercontent" id="rightview">
				          	 	<ol>
				           		<c:forEach var="freebest" items="${bestuserviewone }">
						 			<li class="item">
							 			 <div class="rank">1</div>
							              <a href="bdetail?boardNo=${freebest.boardNo }" class="tit">${freebest.boardTitle }</a>
							              <div class="commt">${freebest.boardViewCount }</div>
						             </li>
					             </c:forEach>
					             <c:forEach var="freebest" items="${bestuserviewtwo }">
						 			<li class="item">
							 			<div class="rank">2</div>
						              <a href="bdetail?boardNo=${freebest.boardNo }" class="tit">${freebest.boardTitle }</a>
						           	  <div class="commt">${freebest.boardViewCount }</div>
						             </li>
					             </c:forEach>
					            <c:forEach var="freebest" items="${bestuserviewthree }">
						 			<li class="item">
						 			 <div class="rank">3</div>
						              <a href="bdetail?boardNo=${freebest.boardNo }" class="tit">${freebest.boardTitle }</a>
						              <div class="commt">${freebest.boardViewCount }</div>
						             </li>
					             </c:forEach>
					              <c:forEach var="freebest" items="${bestuserviewfour }">
						 			<li class="item">
						 			 <div class="rank">4</div>
						              <a href="bdetail?boardNo=${freebest.boardNo }" class="tit">${freebest.boardTitle }</a>
						              <div class="commt">${freebest.boardViewCount }</div>
						            </li>
					             </c:forEach>
					             <c:forEach var="freebest" items="${bestuserviewfive }">
						 			<li class="item">
						 			 <div class="rank">5</div>
						              <a href="bdetail?boardNo=${freebest.boardNo }" class="tit">${freebest.boardTitle }</a>
						              <div class="commt">${freebest.boardViewCount }</div>
						            </li>
					             </c:forEach>
					       	 </ol>	
				        </div>
				       </dd>
			         </dl>
			         	<dl>
		          	<dd>
			    		<div class="usercontent" id="rightcomt">
				          	 	<ol>
				           		<c:forEach var="freebest" items="${bestusercomtone }">
						 			<li class="item">
							 			 <div class="rank">1</div>
							              <a href="bdetail?boardNo=${freebest.boardNo }" class="tit">${freebest.boardTitle }</a>
							              <div class="commt">${freebest.comment_no }</div>
						             </li>
					             </c:forEach>
					             <c:forEach var="freebest" items="${bestusercomttwo }">
						 			<li class="item">
							 			<div class="rank">2</div>
						              <a href="bdetail?boardNo=${freebest.boardNo }" class="tit">${freebest.boardTitle }</a>
						           	  <div class="commt">${freebest.comment_no }</div>
						             </li>
					             </c:forEach>
					            <c:forEach var="freebest" items="${bestusercomtthree }">
						 			<li class="item">
						 			 <div class="rank">3</div>
						              <a href="bdetail?boardNo=${freebest.boardNo }" class="tit">${freebest.boardTitle }</a>
						              <div class="commt">${freebest.comment_no }</div>
						             </li>
					             </c:forEach>
					              <c:forEach var="freebest" items="${bestusercomtfour }">
						 			<li class="item">
						 			 <div class="rank">4</div>
						              <a href="bdetail?boardNo=${freebest.boardNo }" class="tit">${freebest.boardTitle }</a>
						              <div class="commt">${freebest.comment_no }</div>
						            </li>
					             </c:forEach>
					             <c:forEach var="freebest" items="${bestusercomtfive }">
						 			<li class="item">
						 			 <div class="rank">5</div>
						              <a href="bdetail?boardNo=${freebest.boardNo }" class="tit">${freebest.boardTitle }</a>
						              <div class="commt">${freebest.comment_no }</div>
						            </li>
					             </c:forEach>
					       	 </ol>	
				        </div>
				       </dd>
			         </dl>
			         	<dl>
		          	<dd>
			    		<div class="usercontent" id="rightlike">
				          	 	<ol>
				           		<c:forEach var="freebest" items="${bestuserlike }">
								 	<li class="item">
							 			 <div class="rank">${freebest.boardRank }</div>
							              <a href="bdetail?boardNo=${freebest.boardNo }" class="tit">${freebest.boardTitle }</a>
							              <div class="commt">${freebest.boardLikeCount}</div>
						             </li>
					             </c:forEach>
					       	 </ol>	
				        </div>
				       </dd>
			         </dl>
			</dd>
		</dl>
	    </div>
		
		   	</div>
		   	</div>
	
<div class="conwrap">
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

<script type="text/javascript">
function openRank(evt, rankName) {
	  var i, tabcontent, tablinks;
	  tabcontent = document.getElementsByClassName("tabcontent");
	  for (i = 0; i < tabcontent.length; i++) {
	    tabcontent[i].style.display = "none";
	  }
	  tablinks = document.getElementsByClassName("tablinks");
	  for (i = 0; i < tablinks.length; i++) {
	    tablinks[i].className = tablinks[i].className.replace(" active", "");
	  }
	  document.getElementById(rankName).style.display = "block";
	  evt.currentTarget.className += " active";
	}
	//Get the element with id="defaultOpen" and click on it
	document.getElementById("defaultOpen").click();
	
	function userRank(evt, userName) {
	  var i, usercontent, userlinks;
	  usercontent = document.getElementsByClassName("usercontent");
	  for (i = 0; i < usercontent.length; i++) {
	    usercontent[i].style.display = "none";
	  }
	  userlinks = document.getElementsByClassName("userlinks");
	  for (i = 0; i < userlinks.length; i++) {
		  userlinks[i].className = userlinks[i].className.replace(" active", "");
	  }
	  document.getElementById(userName).style.display = "block";
	  evt.currentTarget.className += " active";
	}
	// Get the element with id="defaultOpen" and click on it
	document.getElementById("defaultOpen2").click();
</script>
<%@include file="/WEB-INF/index/footer.jsp" %>
</body>
</html>