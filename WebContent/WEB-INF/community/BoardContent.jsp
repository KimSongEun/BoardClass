<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="kh.semi.boardclass.community.model.vo.Board"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardClass</title>
<link rel="stylesheet" href="css/community/BoardContent.css" />
<link rel="stylesheet" href="css/index/maincss.css" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<style>
.hiddenText { display: none;}
.heart{
	width: 100px;
	height: 100px;
	background: url("https://cssanimation.rocks/images/posts/steps/heart.png") no-repeat;
	background-position: 0 0;
	cursor: pointer;
	transition: background-position .6s steps(28);
	transition-duration: 0s;
    justify-content: space-around;
}
.heart.is-active{
	transition-duration: .6s;
	background-position: -2800px 0;
} 
        
.like_article{
    display : inline-block;
    position: relative;
    vertical-align: top;
    font-size: 13px;
}
.like_article .button_like_list {
	position: absolute;
    top: -2px;
    left: 20px;
    right: 0;
    bottom: -2px;
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

<div id="a"></div>
<div id="b"></div>

<div id="guide" class="row">
	<aside id="aside" class="c_">
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

<div class="conwrap">
	<div class="h3group">
		<h3 class="tit">커뮤니티</h3>
		<div class="location">

		</div>
	</div>
	
	<div class="viewbody">
			<div class="hgroup">
				<div class="tit">${board.boardTitle }</div>
				<div class="util">
					<div class="name">${board.userId }</div>
					<div class="date"> ${board.boardWriteDate }</div>
					<div class="hit">조회수: ${board.boardViewCount }</div>
				</div>
			</div>
			<div class="board_content">
			 ${board.boardContent }
			</div>
		
	
		<!-- 추천 -->
			<c:if test="${board.userId != userSession.userId}">
				<!-- 좋아요 -->
				<div class="like_article">								
				      <div class="heart" id="btn_like"></div>
				 </div>	
			</c:if>	
				<div class="countlike">		
					      <div class="button_like_list">좋아요 ${totallike}</div>	
					
				</div>	
 
</div>
	
	
	<div class="btn_wrap">
		
		<c:if test="${board.userId eq userSession.userId}">
			<button type="button" class="movelist list" onclick="boardUpdate();">수정</button>
			<button type="button" class="movelist list" onclick="boardDelete();">삭제</button>
		</c:if>
		<c:if test="${board.userId != userSession.userId}">
			<button type="button" id="btn_report" class="movelist list">신고하기</button>
		</c:if>
		<c:if test="${board.boardCategory =='자유게시판'}">
		<a href="cf">
			<button class="movelist list" >목록</button>
		</a>
		</c:if>
		<c:if test="${board.boardCategory =='유저정보게시판'}">
		<a href="cu">
			<button class="movelist list" >목록</button>
		</a>
		</c:if>
		<c:if test="${board.boardCategory =='모임게시판'}">
		<a href="cg">
			<button class="movelist list" >목록</button>
		</a>
		</c:if>
	</div>
	
	
	<!-- 댓글 영역 -->
	<div class="fullcomment">
		<c:forEach var="comment" items="${list }">
			<div class=getComment>
				<div class="comment">
					<div class="imgcomt">
						<c:if test="${comment.commentReLevel > 0 }">
							<img src="img/relevel.png" width="${comment.commentReLevel*20 }">
							<img src="img/recomment.png" class="recomment">
						</c:if>
					</div>
				
			<div class="comment_box">
				<span class="material-icons">account_circle</span>
					<div class="comment_writer">
						${comment.userId }
					</div>
				
				<div class="cmt_area" style="margin-left: ${comment.commentReLevel*15}px; " >
					<span class="text_comment">${comment.commentContent }</span>
					
					<div class="comment_info_box">
						<div class="createDate">${comment.commentWriteDate }</div>
						<button type="button" class="infobtn recomt" onclick="re('${comment.commentNo}')">답글</button>
						<c:if test="${comment.userId eq userSession.userId}">
							<button type="button" class="infobtn delete" value="삭제" onclick="location.href='ccdelete?commentNo=${comment.commentNo}'">삭제</button>
						</c:if>
						<c:if test="${comment.userId != userSession.userId}">
							<button type="button" class="infobtn report"  onclick="comtReport('${comment.commentNo}')" >신고</button>
						</c:if>

					</div>
				</div>
					</div>	
					</div>
					<!-- 답글 영역 -->
				<div class="CommentWriterRe">
					<div class="hiddenText" id="a${comment.commentNo }">
						<form action="cclist?pageNum=${pageNum }" method="post" name="frm1" id="frm1">
							<input type="hidden" name="userId" value="${comment.userId }">
							<input type="hidden" name="boardNo" value=${board.boardNo }>
							<input type="hidden" name="commentNo" value=${comment.commentNo }>
							<input type="hidden" name="commentRef" value="${comment.commentRef }">
							<input type="hidden" name="commentReLevel" value="${comment.commentReLevel }">
							<input type="hidden" name="commentReStep" value="${comment.commentReStep }">
							
							<div class="comment_inbox">
						
							<textarea name="commentContent" id="commentContent" maxlength="800" required="required" class="comment_inbox_text"  placeholder="답글을 입력해주세요"></textarea>
							</div>
							<div class="comment_attach">
							<div class="register_box"><input type="submit" class="button btn_register" value="등록" id="comtBtn"></div>
							</div>
							
						</form>
					</div>
				</div>
					</div>
	</c:forEach>
					<!-- 댓글 insert 영역 -->
					
					<div class="CommentWriter">
						<form action="cclist" method="post" name="frm2">
							<input type="hidden" name="pageNum" value="${pageNum }">
							<input type="hidden" name="userId" value="${comment.userId }">
							<input type="hidden" name="boardNo" value=${board.boardNo }>
							<input type="hidden" name="commentNo" value=${comment.commentNo }>
							<input type="hidden" name="commentRef" value="${comment.commentRef }">
							<input type="hidden" name="commentReLevel" value="${comment.commentReLevel }">
							<input type="hidden" name="commentReStep" value="${comment.commentReStep }">
							
							<div class="comment_inbox">
								<div class="left"><label for="name">${comment.userId }</label></div>
								<textarea name="commentContent" id="commentContent" class="comment_inbox_text" maxlength="800" required="required" placeholder="댓글을 입력해주세요"></textarea>
							</div>

							<div class="comment_attach">
								<div class="register_box"><input type="submit" value="등록" class="button btn_register" id="comtBtn"></div>
							</div>
						</form>
					</div>
</div>
	</div>
	</div>

<script>
function boardUpdate(){
	if(window.confirm("수정하겠습니까?")){
		location.href='bupdate?boardNo=${board.boardNo }';
	} else {
		return;
	}
}


function boardDelete(){
	if(window.confirm("삭제하겠습니까?")){
		location.href='bdelete?boardNo=${board.boardNo }';
	} else {
		return;
	}
}


function del(){
	const del = confirm("해당 게시물을 삭제하시겠습니까?");
	if(del) {
		location.href='bdetail?boardNo=${board.boardNo }';
	}
}

$("#comtBtn").click(comtBtn);
function comtBtn(){
	if(!"${userSession}"){
		alert("로그인해주세요");
		return;
	}
}

// 신고
let reportedThis = false;
$("#btn_report").click(cbReport);

function cbReport(){
	if(!"${userSession}"){
		alert("로그인해주세요");
		return;
	}
	if("${reportresult}" == 1){
		alert("이미 신고하셨습니다.");
		reportedThis = true;
		return;
	}
	if(reportedThis){
		alert("이미 신고하셨습니다.");
		return;
	}
	$.ajax({
		type : "post",
		url : "creport.ajax",
		data : {
			loginId : "${userSession.userId}",
			thisboardNo : "${board.boardNo}"
		},
		dataType : "json",
		success : function(receive) {
			console.log("신고receive값은:"+receive);
			if(receive<1){
				reportedThis = true;
				alert("이미 접수되었습니다");
				return;
			}
			reportedThis = true;
			alert("신고가 접수되었습니다.");
		},
		error : function(request, status, error) {
			alert("code:" + request.status + "\n" + "message:"
					+ request.responseText + "\n" + "error:"
					+ error);
		}
	});
}

$(document).ready(function(){
	if("${likeresult}" == 1){
		$(".heart").toggleClass("is-active");
	}
});

$("#btn_like").click(cbLike);

	function cbLike(){
		if(!"${userSession}"){
			alert("로그인해주세요");
			return;
		}
		$.ajax({
			type : "post",
			url : "boardlike.ajax",
			data : {
				loginId : "${userSession.userId}",
				thisBoardNo : "${board.boardNo}"
			},
			dataType : "json",
			success : function(receive) {
				console.log("receive값은:"  + receive);
				$(".heart").toggleClass("is-active");
			},
			error : function(request, status, error) {
				alert("code:" + request.status + "\n" + "message:"
						+ request.responseText + "\n" + "error:"
						+ error);
			}
		});
	}


//댓글 신고
let reportedComtThis = false;
//$("#btn_report_comt").click(comtReport);

function comtReport(comment_no){
	if(!"${userSession}"){
		alert("로그인해주세요");
		return;
	}
	if("${countcomtreport }" == 1){
		alert("이미 신고하셨습니다.");
		reportedComtThis = true;
		return;
	}
	if(reportedComtThis){
		alert("이미 신고하셨습니다.");
		return;
	}
	console.log(comment_no);
	$.ajax({
		type : "post",
		url : "ccreport.ajax",
		data : {
			loginId : "${userSession.userId }",
			thisCommntNo : comment_no
		},
		dataType : "json",
		success : function(receive) {
			console.log("신고receive값은:"+receive);
			if(receive<1){
				reportedComtThis = true;
				alert("이미 접수되었습니다");
				return;
			}
			reportedComtThis = true;
			alert("신고가 접수되었습니다.");
		},
		error : function(request, status, error) {
			alert("code:" + request.status + "\n" + "message:"
					+ request.responseText + "\n" + "error:"
					+ error);
		}
	});
}
</script>
<%@include file="/WEB-INF/index/footer.jsp" %>
</body>
</html>