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
	display: flex;
         justify-content: space-around;
        }
        .heart.is-active{
	transition-duration: .6s;
	background-position: -2800px 0;
        } 
        
        .placement{
        display: flex;
         justify-content: space-around;
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
			<span class="depth">홈</span>
			<span class="depth">커뮤니티</span><strong class="this">자유게시판</strong>
		</div>
	</div>
	
	<div class="viewbody">
		<div class="hgroup">
			<div class="tit">${board.boardTitle }</div>
			<div class="util">
				<div class="name">${board.userId }</div>
				<div class="date">시간: ${board.boardWriteDate }</div>
				<div class="hit">조회수: ${board.boardViewCount }</div>
			</div>
		</div>
		<div class= "content">
		내용 : ${board.boardContent }
		</div>
		
	
		<!-- 추천 -->
		<c:if test="${used.userId != userSession.userId}">
			<button type="button" id="btn_report">신고하기</button>
		</c:if>
				<!-- 좋아요 -->
				<div class="placement">								
			      <div class="heart" class="btn_like"></div>	
				</div>	
				 <div class="countheart">${likeresult }개</div>	
		
 
</div>
	
	
	<div class="btn_wrap">
		
		<c:if test="${board.userId eq userSession.userId}">
			<button type="button" onclick="boardUpdate();">수정</button>
			<button type="button" onclick="boardDelete();">삭제</button>
		</c:if>

		<c:if test="${board.boardCategory =='자유게시판'}">
		<a href="cf" class="btn btn3">
			<button >목록</button>
		</a>
		</c:if>
		<c:if test="${board.boardCategory =='유저정보게시판'}">
		<a href="cu" class="btn btn3">
			<button >목록</button>
		</a>
		</c:if>
		<c:if test="${board.boardCategory =='모임게시판'}">
		<a href="cg" class="btn btn3">
			<button >목록</button>
		</a>
		</c:if>
	</div>
	
	
	<!-- 댓글 영역 -->
	<div class="fullcomment">
		<c:forEach var="comment" items="${list }">
			<div class=getComment>
				<div class="comment">
					<c:if test="${comment.commentReLevel > 0 }">
						<img src="./img/comtimg.png" width="${comment.commentReLevel*10 }">
					</c:if>
				
			<div class="comment_box">
				<span class="material-icons">account_circle</span>
					<div class="comment_writer">
						${comment.userId }
					</div>
				
				<div class="cmt_area" style="margin-left: ${comment.commentReLevel*15}px; " >
					<span class="text_comment">${comment.commentContent }</span>
					
					<div class="comment_info_box">
						<div class="createDate">${comment.commentWriteDate }</div>
						<button type="button" class="info_btn" onclick="re('${comment.commentNo}')">답글</button>
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
							
							<div><input type="submit" value="등록" id="comtBtn"></div>
						</form>
					</div>
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
							<div class="btnFix"><input type="submit" value="등록" class="commentbtn" id="comtBtn"></div>
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
	
	//추천
	//$(".btn_like").click(cblike);

	function cbLike(){
		if(!"${userSession}"){
			alert("로그인해주세요");
			return;
		}
		if("${board.userId}" == "${userSession.userId}") {
			alert("본인이 작성한 게시글에는 '추천' 할 수 없습니다.");
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