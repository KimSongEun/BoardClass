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

</head>

<body>
    <%@include file="/WEB-INF/admin/main/adminHeader.jsp" %>
    <div>
        <form method="post" action="boardgamemade" enctype = "multipart/form-data">
            <table style="text-align: center; font-size: 15px; margin: 0 auto; margin-top: 50px; width : 900px">
                <tr>
                    <td style="text-align: left; font-size: 34px; font-weight: bold;" colspan = "2">보드게임 등록</td>
                </tr>
                <tr style="text-align: left; font-size: 16px;">
                    <td colspan = "2" style="font-weight: bold;"><input name=title type="text" style="width: 100%;" placeholder="제목을 입력해주세요." required><br></td>
                </tr>
                <tr>
                    <td colspan = "2"><textarea id="ckeditor" name="content" class="content" required></textarea></td>
                </tr>
				<tr>
					<td style = "width : 220px; text-align : left; font-size : 18px">보드게임 썸네일 이미지 등록</td>
                	<!-- <td><br><input type="file" name="uploadFile" /></td> -->
                	<td>
                	<br>
                	<div class="input-group mb-3">
  					<input type="file" class="form-control" id="inputGroupFile02" name = "uploadFile">
  					<label class="input-group-text" for="inputGroupFile02">Upload</label>
					</div>
                	</td>
                </tr>
                <tr>
                    <td colspan = "2"><br><button class='btn btn-warning' value='등록' type="submit">등록</button>
                        &nbsp;
                        <button type="reset" class = 'btn btn-warning'>취소</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
<script>
CKEDITOR.replace("ckeditor", {height : 300});
CKEDITOR.config.extraPlugins = 'youtube';
</script>

</body>

</html>