$(function(){
	console.log ("시작");
	$(window).click(function(e){
		console.log(e.target);
	});
	$(".admin-reportcomment-search-select").change(f1);
	f1();
	function f1() {
		console.log("변경");
		if($(".admin-reportcomment-search-select").val() == "작성자아이디"){
			console.log("1바꿈");
			$(".searchselect").attr("action", "reportcommentuseridsearch");
			/*console.log($(".searchselect").attr("action"));*/
		} else if ($(".admin-reportcomment-search-select").val() == "작성자 회원번호") {
			console.log("2바꿈");
			$(".searchselect").attr("action", "reportcommentusernosearch");
			/*console.log($(".searchselect").attr("action"));*/
		}
	};
	
	var modal = document.getElementById("myModal");
	var span = document.getElementsByClassName("close")[0];
	
	
	$(".comment-modal").click(comment);
	function comment() {
		var comment_id = $(this).attr("id");
		console.log(comment_id);
		$.ajax({
		url : "allboardgetdetail.ajax",
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

});