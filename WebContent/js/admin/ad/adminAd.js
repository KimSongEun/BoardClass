$(function(){
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

});