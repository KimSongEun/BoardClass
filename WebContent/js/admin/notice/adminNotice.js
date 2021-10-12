$(function(){
$(".update").click(function () {
    var updateid = $(this).attr('no');
    var newWindow = window.open("about:blank");
    newWindow.location.href = "noticecontent?no=" + updateid;
});
$(".delete").click(function () {
    var deleteid = $(this).attr("id");

    location.href = "noticedelete?id=" + deleteid;
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