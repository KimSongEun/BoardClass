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
});