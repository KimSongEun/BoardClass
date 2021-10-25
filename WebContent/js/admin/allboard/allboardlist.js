$(function(){
	console.log ("시작");
/*	$(window).click(function(e){
		console.log(e.target);
	});*/
	$(".admin-allboard-search-select").change(f1);
	f1();
	function f1() {
		console.log("변경");
		if($(".admin-allboard-search-select").val() == "작성자아이디"){
			$(".searchselect").attr("action", "allboarduseridsearch");
			/*console.log($(".searchselect").attr("action"));*/
		} else if ($(".admin-allboard-search-select").val() == "작성자 회원번호") {
			$(".searchselect").attr("action", "allboardusernosearch");
			/*console.log($(".searchselect").attr("action"));*/
		}else if ($(".admin-allboard-search-select").val() == "글제목") {
			$(".searchselect").attr("action", "allboardtitlesearch");
			/*console.log($(".searchselect").attr("action"));*/
		}
	};
	$(".admin-select").change(selectCategory);
	function selectCategory() {
		var index = $(".admin-select").index(this);
		var free = ["사담", "건의", "질문"];
		var userInfo = [ "기사", "후기", "공식", "팁"];
		var party = [ "모임후기", "모집", "일정안내"];
		var selectItem = $(".admin-select").eq(index).val();
		var changeItem;
		if (selectItem == "자유게시판") {
			changeItem = free;
		} else if (selectItem == "유저정보게시판") {
			changeItem = userInfo;
		} else if (selectItem == "모임게시판") {
			changeItem = party;
		} 
		$('.admin-sub-select').eq(index).empty();
		for (var count = 0; count < changeItem.length; count++) {
			var option = $("<option>" + changeItem[count] + "</option>");
			$('.admin-sub-select').eq(index).append(option);
		}
	}; 
	
	$(".update").click(function(){
	console.log("ajax 시작");
	var index =$(".update").index(this); 
	var boardNo = $(".boardNo").eq(index).html();
	var select1 = $(".admin-select option:selected").eq(index).val();
	var select2 = $(".admin-sub-select option:selected").eq(index).val();
	$.ajax({
		url : "allboardupdate.ajax",
		type : "post",
		data : {boardNo : boardNo,
				selectCategory : select1,
				selectSubCategory : select2},
		success : function(data){
			$(".admin-select option:selected").eq(index).html(selectCategory);
			alert("변경완료");
		},
		error : function(){
			console.log("ajax 실패");
		}
	});
});

	$(".delete").click(function () {
    var deleteid = $(this).attr("id");
	if(confirm(deleteid+"번 게시글 삭제하시겠습니까?")){
    	location.href = "allboarddelete?boardNo=" + deleteid;
	} else {
	}
	});
});