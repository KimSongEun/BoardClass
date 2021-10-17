$(function(){
	console.log ("시작");
	$(window).click(function(e){
		console.log(e.target);
	});
	$(".admin-reportreview-search-select").change(f1);
	f1();
	function f1() {
		console.log("변경");
		if($(".admin-reportreview-search-select").val() == "작성자아이디"){
			console.log("1바꿈");
			$(".searchselect").attr("action", "reportreviewuseridsearch");
			/*console.log($(".searchselect").attr("action"));*/
		} else if ($(".admin-reportreview-search-select").val() == "작성자 회원번호") {
			console.log("2바꿈");
			$(".searchselect").attr("action", "reportreviewusernosearch");
			/*console.log($(".searchselect").attr("action"));*/
		}
	};
	
	var modal = document.getElementById("myModal");
	var span = document.getElementsByClassName("close")[0];
	
	
	$(".review-modal").click(review);
	function review() {
		var review_id = $(this).attr("id");
		console.log(review_id);
		$.ajax({
		url : "reviewgetdetail.ajax",
		type : "post",
		data : {reviewNo : review_id},
		success : function(data){
			$('#modal-review-detail').html(data);
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