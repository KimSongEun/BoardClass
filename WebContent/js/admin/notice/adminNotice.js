$(function(){
$(".update").click(function () {
    var updateid = $(this).attr('no');
    var newWindow = window.open("about:blank");
    newWindow.location.href = "noticecontent?no=" + updateid;
});
$(".delete").click(function () {
    var deleteid = $(this).attr("id");
	if(confirm(deleteid+"번 공지 삭제하시겠습니까?")){
    location.href = "noticedelete?id=" + deleteid;
	} else {
	}
});

$(".insert").click(function () {
    var newWindow = window.open("about:blank");
    newWindow.location.href = "noticemadeview";
});

var viewcount = $("#viewcount");
$("#selectno").change(function() {
	var ele = $(this).find('option:selected');
	var sel = ele.attr("viewcount");
	viewcount.val(sel);
})

});