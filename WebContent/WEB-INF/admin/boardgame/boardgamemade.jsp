<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>보드게임 등록</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
	<script src = "ckeditor/ckeditor.js"></script>
    <script type="text/javascript" src="./ckfinder/ckfinder.js"></script>
       <link rel="stylesheet" href="./css/admin/boardgame/adminBoardGameMade.css" type="text/css">
    <script type="text/javascript" src="./js/admin/boardgame/adminBoardGameMade.js"></script>

</head>

<body>
    <%@include file="/WEB-INF/admin/main/adminHeader.jsp" %>
     <header></header>
    <section>
        <form action="boardgamemade" method="post" enctype="multipart/form-data">
            <div class="boardgame-div_bg">
                <div class="boardgame-main_body">
                    <div class="boardgame-main_body_img">
                        <div class="boardgame-main_body_imgcontent">
                            <h2>보드게임 등록</h2>
                            <br>
                            	보드게임 썸네일 이미지
                            <div class="boardgame-enroll_img_btn">
                                <span>이미지 업로드</span> <input type="file" multiple name="uploadFileImage" class="boardgame-enroll_box"
                                    id="photo_upload" onchange="loadImg(this)" id="boardgame-image">
                            </div>
                            <div class="boardgame-main_img" id="boardgame-img_viewer">
                                <img id="boardgame-img_view" height="420" style="max-width: 850px; max-height: 500px; text-align: center; vertical-align: middle;">
                                <button id="boardgame-img_del" class="boardgame-img_del_btn" type="button"> 지우기</button>
                            </div>

                            <div class="boardgame-item_main_back">
                                <fieldset class="boardgame-item_main">

                                    <div class="boardgame-item_menu">
                                        <label class="boardgame-item_menu_label">한글 상품명 :</label>
                                        <div class="boardgame-item_menu_title">
                                            <input type="text" class="boardgame-form_control_title"
                                                placeholder="한글상품명을 입력해주세요" name="kotitle" required>
                                        </div>
                                    </div>

                                    <div class="boardgame-item_menu">
                                        <br><br><label class="boardgame-item_menu_label">영어 상품명 :</label>
                                        <div class="boardgame-item_menu_title">
                                            <input type="text" class="boardgame-form_control_title"
                                                placeholder="영어상품명을 입력해주세요" name="entitle">
                                        </div>
                                    </div>

                                    <div class="boardgame-item_menu">
                                        <br><br><label class="boardgame-item_menu_label"> 카테고리 : &nbsp; &nbsp; </label>
                                        <div class="boardgame-item_menu_maincate">
                                            <select class="boardgame-mainCategory_select" name="category"
                                                id="boardgame-selectMain"  required>
                                                <option value="" selected disabled>카테고리를 선택해주세요</option>
                                                <option value="퍼즐">퍼즐</option>
                                                <option value="전략">전략</option>
                                                <option value="추상">추상</option>
                                                <option value="테마">테마</option>
                                                <option value="방탈출, 추리">방탈출, 추리</option>
                                                <option value="2인 추천">2인 추천</option>
                                                <option value="파티">파티</option>
                                                <option value="가족">가족</option>
                                                <option value="어린이">어린이</option>
                                                <option value="한글">한글</option>

                                            </select>
                                        </div>
                                    </div>
                                    <br>

                                    <div class="boardgame-item_menu">
                                        <br> <label class="boardgame-item_menu_label"> 대상연령
                                            : &nbsp;&nbsp;&nbsp; </label>
                                        <div class="boardgame-item_menu_title">
                                            <input type="text" class="boardgame-form_control_title"
                                                placeholder="대상연령을 입력해주세요" name="age">
                                        </div>
                                    </div>

                                    <div class="boardgame-item_menu">
                                        <br><br> <label class="boardgame-item_menu_label"> 게임인원
                                            : &nbsp;&nbsp;&nbsp; </label>
                                        <div class="boardgame-item_menu_title">
                                            <input type="text" class="boardgame-form_control_title"
                                                placeholder="게임인원을 입력해주세요" name="player">
                                        </div>
                                    </div>

                                    <div class="boardgame-item_menu">
                                        <br><br> <label class="boardgame-item_menu_label"> 게임시간
                                            : &nbsp;&nbsp;&nbsp; </label>
                                        <div class="boardgame-item_menu_title">
                                            <input type="text" class="boardgame-form_control_title"
                                                placeholder="게임시간을 입력해주세요" name="time">
                                        </div>
                                    </div>

                                    <div class="boardgame-item_menu">
                                        <br> <br> <label class="boardgame-item_menu_label"> 게임가격
                                            : &nbsp;&nbsp;&nbsp; </label>
                                        <div class="boardgame-item_menu_number">
                                            <input type="number" class="boardgame-form_control_number"
                                                placeholder="10000(가격은 숫자로만 입력)" name="price">
                                        </div>
                                    </div>

                                    <div class="boardgame-item_menu">
                                        <br> <br> <label class="boardgame-item_menu_label"> 게임평점
                                            : &nbsp;&nbsp;&nbsp; </label>
                                        <div class="boardgame-item_menu_title">
                                            <input type="text" class="boardgame-form_control_title"
                                                placeholder="평점은 숫자로만 입력해주세요" name="grade">
                                        </div>
                                    </div>

                                    <div class="boardgame-item_menu">
                                        <br> <br> <label class="boardgame-item_menu_label"> 게임 난이도
                                            : </label>
                                        <div class="boardgame-item_menu_title">
                                            <input type="text" class="boardgame-form_control_title"
                                                placeholder="난이도는 숫자로만 입력해주세요" name="level">
                                        </div>
                                    </div>

                                    <div class="boardgame-item_menu">
                                        <br> <br> <label class="boardgame-item_menu_label"> 디자이너
                                            : &nbsp;&nbsp;&nbsp; </label>
                                        <div class="boardgame-item_menu_title">
                                            <input type="text" class="boardgame-form_control_title"
                                                placeholder="디자이너를 입력해주세요" name="designer">
                                        </div>
                                    </div>

                                    <div class="boardgame-item_menu">
                                        <br> <br> <label class="boardgame-item_menu_label"> 게임작가
                                            : &nbsp;&nbsp;&nbsp; </label>
                                        <div class="boardgame-item_menu_title">
                                            <input type="text" class="boardgame-form_control_title"
                                                placeholder="작가를 입력해주세요" name="writer">
                                        </div>
                                    </div>

                                    <div class="boardgame-item_menu">
                                        <br> <br> <label class="boardgame-item_menu_label"> 게임 제조사
                                            : </label>
                                        <div class="boardgame-item_menu_title">
                                            <input type="text" class="boardgame-form_control_title"
                                                placeholder="게임제조사를 입력해주세요" name="brand">
                                        </div>
                                    </div>

                                    <div class="boardgame-item_menu">
                                        <br> <br> <label class="boardgame-item_menu_label"> 출시년도
                                            : &nbsp;&nbsp;&nbsp; </label>
                                        <div class="boardgame-item_menu_title">
                                            <input type="text" class="boardgame-form_control_title"
                                                placeholder="출시년도를 입력해주세요" name="releasedate" required>
                                        </div>
                                    </div>

                                    <div class="boardgame-item_menu">
                                        <br> <br> <label class="boardgame-item_menu_label"> 언어 의존도
                                            : </label>
                                        <div class="boardgame-item_menu_title">
                                            <input type="text" class="boardgame-form_control_title"
                                                placeholder="언어의존도를 입력해주세요" name="language">
                                        </div>
                                    </div>

                                    <div class="boardgame-item_menu">
                                        <br> <br> <label class="boardgame-item_menu_label"> 게임 확장판
                                            : </label>
                                        <div class="boardgame-item_menu_title">
                                            <input type="text" class="boardgame-form_control_title"
                                                placeholder="게임확장판을 입력해주세요" name="plus">
                                        </div>
                                    </div>

                                    <div class="boardgame-item_menu">
                                        <br> <br> <label class="boardgame-item_menu_label"> 규칙 이미지
                                            : </label>
                                        <div class="input-group mb-3" style="width : 771px;">
                                            &nbsp; &nbsp;
                                            <input type="file" class="form-control" id="inputGroupFile02"
                                                name="uploadFileRuleImage">
                                            <label class="input-group-text" for="inputGroupFile02">Upload</label>
                                        </div>
                                    </div>

                                    <br>
                                    <div class="boardgame-item_menu">
                                        <label class="boardgame-item_menu_label">게임 규칙 영상 및 게임 설명 :</label>
                                        <div class="boardgame-item_menu_comment">
                                            <br><br><textarea id = "ckeditor" name="video"></textarea>
                                        </div>
                                    </div>
                                    <div class="boardgame-item_upload">
                                        <div class="boardgame-upload_text">
                                            <button type="submit" class="boardgame-upload_btn">게임 등록</button>
                                        </div>
                                    </div>
                                </fieldset>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </section>

<script>
CKEDITOR.replace("ckeditor", {height : 300});
CKEDITOR.config.extraPlugins = 'youtube';
</script>

</body>

</html>