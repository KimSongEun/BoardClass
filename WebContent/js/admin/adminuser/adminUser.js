$(function(){
	console.log ("시작");
	$(window).click(function(e){
		console.log(e.target);
	});
	$(".admin-adminuser-search-select").change(f1);
	f1();
	function f1() {
		console.log("변경");
		if($(".admin-adminuser-search-select").val() == "작성자아이디"){
			$(".searchselect").attr("action", "adminuseruseridsearch");
			/*console.log($(".searchselect").attr("action"));*/
		} else if ($(".admin-adminuser-search-select").val() == "작성자 회원번호") {
			$(".searchselect").attr("action", "adminuserusernosearch");
			/*console.log($(".searchselect").attr("action"));*/
		}
	};
	$(".detail").click(function () {
    var detailid = $(this).attr("id");
    	location.href = "adminuserdetail?userNo=" + detailid;
});
});