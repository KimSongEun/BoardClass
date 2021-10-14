function loadImg(f) {
    console.log(f.files); // input태그에 선택된 파일을 배열로 가져옴
    if (f.files.length != 0 && f.files[0] != 0) {
        var reader = new FileReader();
        reader.readAsDataURL(f.files[0]); // 매개변수로 지정한 파일의 경로
        reader.onload = function(e) {
            $("#boardgame-img_view").attr('src', e.target.result);
        }
    } else {
        $("#boardgame-img_view").attr('src', '');
    }
}
$(function() {

    // 이미지 미리보기 지우기
    $('#boardgame-img_del').click(function() {
        alert('삭제되었습니다~');
        $('#boardgame-image').remove();
        // 미리보기 제거
        $("#boardgame-img_view").attr('src', '');
    });
});
