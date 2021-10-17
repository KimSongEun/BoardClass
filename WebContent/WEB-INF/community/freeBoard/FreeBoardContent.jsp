<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="kh.semi.boardclass.community.model.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<% Board vo = (Board)request.getAttribute("boardvo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보드클래스</title>
<link rel="stylesheet" href="css/community/BoardContent.css" />
<link rel="stylesheet" href="css/community/cmain.css" />
<script>

</script>
</head>
<body>
<div id="a"></div>
<div id="b"></div>

<c:import url="../header.jsp" />

<div id="guide" class="row">
<nav id="aside" class="column">
		<ul>
			<li><a href="./cmain">커뮤니티</a></li>
			<li><a href="#">공지사항</a></li>
			<li><a href="./cf">자유게시판</a></li>
			<li><a href="#">유저정보게시판</a></li>
			<li><a href="#">모임게시판</a></li>
		</ul>
</nav> <!-- TODO 링크 첨부 -->

<div class="conwrap">
	<div class="h3group">
		<h3 class="tit">자유게시판</h3>
		<div class="location">
			<span class="depth">홈</span>
			<span class="depth">커뮤니티</span><strong class="this">자유게시판</strong>
		</div>
	</div>
	
	<div class="viewbody">
		<div class="hgroup">
			<div class="tit">${board.boardTitle }</div>
			<div class="util">
				<div class="name">${board.userId }</div>
				<div class="date">시간:${board.boardWriteDate }</div>
				<div class="hit">조회수: ${board.boardViewCount }</div>
			</div>
		</div>
		<div class= "content">
		내용 : ${board.boardContent }
		<!-- 댓글 -->
		</div>
	<div class="bottom">
		<div class="utils">
			<div class="function">
				<button type="button" class="report reportBtn ">
					<span class="ico">신고</span>
				</button>
			</div>
		</div>
	</div>
	<div class="btn_wrap">
	<!-- 아이디 확인한 후 버튼 생성 가능-->
	
			<a href="cfupdate?boardNo=${board.boardNo }" class="btn btn1">
				<button>수정</button>
			</a>
			<input type="button" class="btn btn2" value="삭제" onclick="del()">
			<a href="cf" class="btn btn3">
				<button >목록</button>
			</a>
	</div>
	
	<div class="comment">
		<c:forEach var="comment" items="${list }">
		<div class="getComment">
			<div class="getWriter">
				<c:if test="${comment.commentReLevel > 0 }">

				</c:if>
				${comment.userId }
			</div>
			<br>
			<div style="margin-left: ${comment.commentReLevel * 15}px;">
				<div class="getTxt">${comment.commentContent }</div>
				<div class="createDate">${comment.commentWriteDate }</div>
			</div>
				<input type="button" value="답글" onclick="re(${comment.commentNo})" />
				<!-- TODO 아이디 일치 확인 -->
				<input type="button" value="삭제" />
				
				<div class="hidenText" id="a${comment.commentNo }">
					<form action="cclist?pageNum=${pageNum }" method="post" name="frm1" id="frm1">
						<input type="hidden" name="userId" value="${userId }"/>
						<input type="hidden" name="boardNo" value="${board.boardNo }"/>
						<input type="hidden" name="commentNo" value="${comment.commentNo }"/>
						<input type="hidden" name="commentRef" value="${comment.commentRef }"/>
						<input type="hidden" name="commentReLevel" value="${comment.commentReLevel }">
						<input type="hidden" name="commentReStep" value="${comment.commentReStep }">
						<div><span class="left"><label for="userId">${userId }</label></span></div>
						<div><textarea name="commentContent" id="commentContent" maxlength="2000" style="height:100px; width: 400px" required="required" placeholder="댓글을 입력해주세요"></textarea></div>
						<div><input type="submit" value="등록"></div>
					</form>
				</div>
				</div>
		</c:forEach>
				<div class="inputtext">
					<form action="cclist?pageNum=${pageNum }" method="post" name="frm2">
						<input type="hidden" name="userId" value="${userId }">
						<input type="hidden" name="boardNo" value="${board.boardNo }">
						<input type="hidden" name="commentNo" value="${comment.commentNo }">
						<input type="hidden" name="commentRef" value="${comment.commentRef }"/>
						<input type="hidden" name="commentReLevel" value="${comment.commentReLevel }">
						<input type="hidden" name="commentReStep" value="${comment.commentReStep }">
						
						<div>
							<span class="left"><label for="userId">${userId }</label></span>
						</div>
						
						<div class="inputComment">
							<textarea name="commentContent" id="commentContent" maxlength="2000" style="height:100px; width: 400px;" required="required" placeholder="댓글을 입력해주세요"></textarea>
						</div>
						<div class="btnFix"><input type="submit" value="등록" id="submitBtn"></div>
					</form>
				</div>
		
	</div>
	
</div>
	
</div>
<script>
var b = "a";
function re(id){
  var content2 = document.getElementById(b);
  content2.style.display="none";
  var a = "a" + id;
  var content = document.getElementById(a);
  content.style.display="block";
  b=a;
}


function del(){
	const del = confirm("해당 게시물을 삭제하시겠습니까?");
	if(del) {
		location.href='cfdelete?boardNo=${board.boardNo }';
	}
}
</script>
</body>
</html>