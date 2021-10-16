$(function(){
	console.log ("시작");
/*	$(window).click(function(e){
		console.log(e.target);
	});*/
	$(".admin-allboard-search-select").change(f1);
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
});