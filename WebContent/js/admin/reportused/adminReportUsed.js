$(function(){
	console.log ("시작");
	$(window).click(function(e){
		console.log(e.target);
	});
	$(".admin-reportused-search-select").change(f1);
	f1();
	function f1() {
		console.log("변경");
		if($(".admin-reportused-search-select").val() == "작성자아이디"){
			$(".searchselect").attr("action", "reportuseduseridsearch");
			/*console.log($(".searchselect").attr("action"));*/
		} else if ($(".admin-reportused-search-select").val() == "작성자 회원번호") {
			$(".searchselect").attr("action", "reportusedusernosearch");
			/*console.log($(".searchselect").attr("action"));*/
		}
	};
	$(".delete").click(function () {
    var deleteid = $(this).attr("id");
	if(confirm(deleteid+"번 중고글 삭제하시겠습니까?")){
    	location.href = "reportuseddelete?usedNo=" + deleteid;
	} else {
	}
});
});