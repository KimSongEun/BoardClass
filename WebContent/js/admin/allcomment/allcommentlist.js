$(function(){
	console.log ("시작");
	$(window).click(function(e){
		console.log(e.target);
	});
	$(".admin-allcomment-search-select").change(f1);
	f1();
	function f1() {
		console.log("변경");
		if($(".admin-allcomment-search-select").val() == "작성자아이디"){
			$(".searchselect").attr("action", "allcommentuseridsearch");
			/*console.log($(".searchselect").attr("action"));*/
		} else if ($(".admin-allcomment-search-select").val() == "작성자 회원번호") {
			$(".searchselect").attr("action", "allcommentusernosearch");
			/*console.log($(".searchselect").attr("action"));*/
		}else if ($(".admin-allcomment-search-select").val() == "글제목") {
			$(".searchselect").attr("action", "allcommenttitlesearch");
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

});