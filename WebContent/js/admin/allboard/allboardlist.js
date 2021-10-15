$(function(){
	console.log ("시작");
/*	$(window).click(function(e){
		console.log(e.target);
	});*/
	
	$(".admin-select").change(selectCategory);
	function selectCategory() {
		var index = $(".admin-select").index(this);
		var free = ["사담", "건의", "질문"];
		var userInfo = [ "기사", "후기", "공식", "팁"];
		var party = [ "모임후기", "모집", "일정안내"];
		var selectItem = $(".admin-select").eq(index).val();
		var changeItem;
		if (selectItem == "자유 게시판") {
			changeItem = free;
		} else if (selectItem == "유저정보 게시판") {
			changeItem = userInfo;
		} else if (selectItem == "모임 게시판") {
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

});