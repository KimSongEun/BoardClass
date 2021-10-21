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
<link rel="stylesheet" href="css/community/BoardContent.css" />
<link rel="stylesheet" href="css/index/maincss.css" />
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js" ></script>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<style>
.hiddenText { display: none;}
.modal {
  display: none; 
  position: fixed; 
  z-index: 1; 
  left: 0;
  top: 0;
  width: 100%; 
  height: 100%; 
  overflow: auto; 
  background-color: rgb(0,0,0); 
  background-color: rgba(0,0,0,0.4); 
}
.modal_content {
	background-color: #fff;
  	margin: 15% auto; 
  	padding: 20px;
  	border: 1px solid #888;
  	width: 400px;
  	height: 400px;
  	position: relative;
}
h1 {
	padding:10px;
	font-size: 18px;
	font-weight: bold;
}

.modal .modal_content .report_title {
	border-bottom: 1px solid #888;
	padding: 10px;
	margin-bottom: 20px;
	
}

.modal .modal_content .report_content {
	border-bottom: 1px solid #888;
	padding-bottom: 10px;
	margin-bottom: 10px;
}
.modal .modal_content .report_btn {
	margin: 0 auto;
	
}
</style>
<script type="text/javascript">
	var b = "a";
	function re(id) {
		var content2 = document.getElementById(b);
		content2.style.display= "none";
		var a = "a" +id;
		var content = document.getElementById(a);
		content.style.display="block";
		b=a;
	}

</script>
</head>
<body>
<%@include file="/WEB-INF/index/header.jsp" %>

<div class="modal">
	<div class="modal_content">
			<div class="modal__style">
				<h1>신고하기</h1>
				<div class="report_title">
					<input type="hidden" name="boardNo" value=${board.boardNo }>
					<span class="report_">제   목:</span><span class="board_report"> ${board.boardTitle}</span><br>
					<span class="report">작성자:</span><span class="board_report"> ${board.userId } </span>
				</div>
				<div class="report_content">
					<textarea maxlength="1000" name="boardReport" placeholder="신고내용을 입력해주세요." rows="10" cols="40"></textarea>
				</div>
					<div class="report_btn">
						<input type="button" value="전송" onclick="reportBtn()"/>
						<input type="button" class="close" value="취소"/>
					</div>
				</div>
	</div>
</div>

<div id="a"></div>
<div id="b"></div>

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

<div class="conwrap">
	<div class="h3group">
		<h3 class="tit">커뮤니티</h3>
	</div>
	
	<div class="viewbody">
		<div class="h3group">
			<h3 class="tit">유저정보게시판</h3>
			<div class="location">
				<span class="depth">홈</span>
				<span class="depth">커뮤니티</span><strong class="this">유저정보게시판</strong>
			</div>
		</div>	
		<div class= "content">
		내용 : ${board.boardContent }
	
		</div>
		<!-- 신고하기 -->
	<div class="bottom">
		<div class="report">
			<button id="report_modal">신고</button>
		</div>
	</div>
	
	
	<div class="btn_wrap">
	<!-- 아이디 확인한 후 버튼 생성 가능-->
	
		<a href="cupdate?boardNo=${board.boardNo }" class="btn btn1">
			<button>수정</button>
		</a>
		<input type="button" id="boardUpdate" class="btn btn1" value="수정" onclick="update()">
		<input type="button" class="btn btn2" value="삭제" onclick="del()">
		<input type="button" id="moveList" class="btn btn3" value="목록">
		<a href="cu" class="btn btn3">
			<button >목록</button>
		</a>
		
	</div>
	<!--  댓글  TODO 로그인과정 -->
	<div class="comment">
		<c:forEach var="comment" items="${list }">
			<div class=getComment>
				<div class="getWriter">
					<c:if test="${comment.commentReLevel > 0 }">
						<img src="./img/comtimg.png" width="${comment.commentReLevel*10 }">
					</c:if>
					
					<span class="material-icons">account_circle</span>
					${comment.userId }
				</div>
						
				<br>
				<div class="cmt_area" style="margin-left: ${comment.commentReLevel*15}px; " >
					<div class="getTxt">${comment.commentContent }</div>
					<div class="createDate">${comment.commentWriteDate }</div>
				</div>
					<input type="button" value="답글" onclick="re('${comment.commentNo}')">
					<!-- c:if 아이디 확인 부분 추가 -->
					<input type="button" value="삭제" onclick="location.href='ccdelete?commentNo=${comment.commentNo}'">
					<!-- 답글 영역 -->
					<div class="hiddenText" id="a${comment.commentNo }">
						<form action="cclist?pageNum=${pageNum }" method="post" name="frm1" id="frm1">
							<input type="hidden" name="userId" value="${comment.userId }">
							<input type="hidden" name="boardNo" value=${board.boardNo }>
							<input type="hidden" name="commentNo" value=${comment.commentNo }>
							<input type="hidden" name="commentRef" value="${comment.commentRef }">
							<input type="hidden" name="commentReLevel" value="${comment.commentReLevel }">
							<input type="hidden" name="commentReStep" value="${comment.commentReStep }">
						
							<div><span class="left"><label for="name">${comment.userId }</label></span></div>
							<div><textarea name="commentContent" id="commentContent" maxlength="800" required="required" placeholder="답글을 입력해주세요"></textarea></div>
							
							<div><input type="submit" value="등록" id="submitBtn"></div>
						</form>
					</div>
					</c:forEach>
					<!-- 댓글 insert 영역 -->
					
					<div class="inputtxt">
						<form action="cclist" method="post" name="frm2">
							<input type="hidden" name="pageNum" value="${pageNum }">
							<input type="hidden" name="userId" value="${comment.userId }">
							<input type="hidden" name="boardNo" value=${board.boardNo }>
							<input type="hidden" name="commentNo" value=${comment.commentNo }>
							<input type="hidden" name="commentRef" value="${comment.commentRef }">
							<input type="hidden" name="commentReLevel" value="${comment.commentReLevel }">
							<input type="hidden" name="commentReStep" value="${comment.commentReStep }">
							
							<div>
								<span class="left"><label for="name">${comment.userId }</label></span>
							</div>
							<div class="inputComment">
								<div><textarea name="commentContent" id="commentContent" maxlength="800" required="required" placeholder="댓글을 입력해주세요"></textarea></div>
							</div>
							<div class="btnFix"><input type="submit" value="등록" id="submitBtn"></div>
						</form>
					</div>
			</div>
		
		</div>
	</div>
</div>
<script>
//모달창

$("#report_modal").click(function() {
	$(".modal").show();
});
$(".close").click(function() {
	$(".modal").hide();
});

//신고

function reportBtn() {
   if (confirm("신고 후 취소하실 수 없습니다. 정말 신고하시겠습니까?")) {
   		//전송
             alert("신고가 완료되었습니다.");
         } else {
       	  alert("신고가 취소되었습니다.");
         }
	}
	
//삭제 수정 목록

function del(){
	const del = confirm("해당 게시물을 삭제하시겠습니까?");
	if(del) {
		location.href='cudelete?boardNo=${board.boardNo }';
	}
}

$("#boardUpdate").click(function(){
	location.href="cupdate?boardNo=${board.boardNo }";
})
$("#moveList").click(function () {
	location.href="cu";
})


</script>
<%@include file="/WEB-INF/index/footer.jsp" %>
</body>
</html>