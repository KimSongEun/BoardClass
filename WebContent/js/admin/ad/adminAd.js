$(function(){
	        $(window).click(function(e){
             console.log(e.target);
        });
$(".update").click(function () {
    var updateid = $(this).attr('no');
    var newWindow = window.open("about:blank");
    newWindow.location.href = "adcontent?no=" + updateid;
});

$(".delete").click(function () {
    var deleteid = $(this).attr("id");
	if(confirm(deleteid+"번 광고 삭제하시겠습니까?")){
    	location.href = "addelete?id=" + deleteid;
	} else {
	}
});

$(".insert").click(function () {
    var newWindow = window.open("about:blank");
    newWindow.location.href = "admadeview";
});

	var chk;
	$(".form-check-input").change(function(){
	console.log("ajax 시작");
	console.log($(".form-check-input").is(":checked"));
	if($(".form-check-input").is(":checked")) {
		console.log("체크");
		chk = 1;
	} else {
		console.log("체크해제");
		chk = 0;
	}
	console.log("chk : " +chk);
	var index =$(".form-check-input").index(this); 
	var promotionNo = $(".promotionNo").eq(index).html();
	console.log("promotionNo : " +promotionNo);
	var chk = chk;
	console.log("chk : " + chk);
	$.ajax({
		url : "adupdatemain.ajax",
		type : "post",
		data : {promotionNo : promotionNo,
				promotionPlace : chk},
		success : function(data){
			console.log("ajax 성공")
		},
		error : function(){
			console.log("ajax 실패");
		}
	});
});
});