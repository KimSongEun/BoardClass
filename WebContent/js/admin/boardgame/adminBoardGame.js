$(function(){
$(".update").click(function () {
    var updateid = $(this).attr('no');
    var newWindow = window.open("about:blank");
    newWindow.location.href = "boardgamecontent?no=" + updateid;
});
$(".delete").click(function () {
    var deleteid = $(this).attr("id");

    location.href = "boardgamedelete?id=" + deleteid;
});

$(".insert").click(function () {
    var newWindow = window.open("about:blank");
    newWindow.location.href = "boardgamemadeview";
});

});