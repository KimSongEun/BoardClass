$(function(){
	console.log ("시작");
	        $(window).click(function(e){
            console.log(e.target);
        });
	$(".deleteboard").click(function () {
    var deleteid = $(this).attr("id");
	if(confirm(deleteid+"번 게시글 삭제하시겠습니까?")){
    	location.href = "adminmainboarddelete?boardNo=" + deleteid;
	} else {
	}
	});
	$(".boarddetail").click(function () {
    var category = $(this).attr("category");
	console.log(category);
	var detailid = $(this).attr("id");
		if(category == "자유 게시판"){
			$(".boarddetail").attr("href", "cfdetail?boardNo="+detailid);
		} else if (category == "유저정보 게시판") {
			$(".boarddetail").attr("href", "cudetail?boardNo="+detailid);
		}else if (category == "모임 게시판") {
			$(".boarddetail").attr("href", "cgdetail?boardNo="+detailid);
		}
	});	
	$(".deletecomment").click(function () {
    var deleteid = $(this).attr("id");
	if(confirm(deleteid+"번 댓글 삭제하시겠습니까?")){
    	location.href = "adminmaincommentdelete?commentNo=" + deleteid;
	} else {
	}
	});
	$(".deletereview").click(function () {
    var deleteid = $(this).attr("id");
	if(confirm(deleteid+"번 리뷰 삭제하시겠습니까?")){
    	location.href = "adminmainreviewdelete?reviewNo=" + deleteid;
	} else {
	}
	});
	$(".deleteused").click(function () {
    var deleteid = $(this).attr("id");
	if(confirm(deleteid+"번 중고글 삭제하시겠습니까?")){
    	location.href = "adminmainuseddelete?usedNo=" + deleteid;
	} else {
	}
	});
	$(".updatenotice").click(function () {
    var updateid = $(this).attr('no');
    var newWindow = window.open("about:blank");
    newWindow.location.href = "noticecontent?no=" + updateid;
	});
	$(".deletenotice").click(function () {
    var deleteid = $(this).attr("id");
	if(confirm(deleteid+"번 공지 삭제하시겠습니까?")){
    location.href = "noticedelete?id=" + deleteid;
	} else {
	}
	});
	var commentmodal = document.getElementById("myCommentModal");
	var commentspan = document.getElementsByClassName("commentclose")[0];
	$(".commentmodal").click(comment);
	function comment() {
		var comment_id = $(this).attr("id");
		console.log(comment_id);
		$.ajax({
		url : "allcommentgetdetail.ajax",
		type : "post",
		data : {commentNo : comment_id},
		success : function(data){
			$('#modal-comment-content-detail').html(data);
			commentmodal.style.display = "block";
		},
		error : function(){
			console.log("ajax 실패");
		}
	});
		 
	};
	commentspan.onclick = function() {
 	commentmodal.style.display = "none";
	}
	
	
	var reviewmodal = document.getElementById("myReviewModal");
	var reviewspan = document.getElementsByClassName("reviewclose")[0];
	$(".reviewmodal").click(review);
	function review() {
		var review_id = $(this).attr("id");
		console.log(review_id);
		$.ajax({
		url : "reviewgetdetail.ajax",
		type : "post",
		data : {reviewNo : review_id},
		success : function(data){
			$('#modal-review-content-detail').html(data);
			reviewmodal.style.display = "block";
		},
		error : function(){
			console.log("ajax 실패");
		}
	});
		 
	};
	reviewspan.onclick = function() {
 	reviewmodal.style.display = "none";
	}
	
	window.onclick = function(event) {
		console.log("event:"+event.target);
	  if (event.target == commentmodal) {
	    commentmodal.style.display = "none";
	  } else if (event.target == reviewmodal) {
		reviewmodal.style.display = "none";
	}
	}
});