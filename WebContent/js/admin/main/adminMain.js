$(function(){
	console.log ("시작");
	$(".deleteboard").click(function () {
    var deleteid = $(this).attr("id");
	if(confirm(deleteid+"번 게시글 삭제하시겠습니까?")){
    	location.href = "adminmainboarddelete?boardNo=" + deleteid;
	} else {
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
	var modal = document.getElementById("myModal");
	var span = document.getElementsByClassName("close")[0];
	$(".comment-modal").click(comment);
	function comment() {
		var comment_id = $(this).attr("id");
		console.log(comment_id);
		$.ajax({
		url : "allcommentgetdetail.ajax",
		type : "post",
		data : {commentNo : comment_id},
		success : function(data){
			$('#modal-content-detail').html(data);
			modal.style.display = "block";
		},
		error : function(){
			console.log("ajax 실패");
		}
	});
		 
	};
	span.onclick = function() {
 	modal.style.display = "none";
	}
	
	window.onclick = function(event) {
	  if (event.target == modal) {
	    modal.style.display = "none";
	  }
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
	  if (event.target == reviewmodal) {
	    reviewmodal.style.display = "none";
	  }
	}
});