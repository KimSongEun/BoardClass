<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>광고등록</title>
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
	<script src = "ckeditor/ckeditor.js"></script>
    <script type="text/javascript" src="./ckeditor/ckeditor.js"></script>

</head>

<body>
    <%@include file="/WEB-INF/admin/main/adminHeader.jsp" %>
    <div>
        <form method="post" action="admade" enctype = "multipart/form-data">
            <table style="text-align: center; font-size: 15px; margin: 0 auto; margin-top: 50px; width : 900px">
                <tr>
                    <td style="text-align: left; font-size: 34px; font-weight: bold;" colspan = "2">광고등록</td>
                </tr>
                <tr style="text-align: left; font-size: 16px;">
                    <td colspan = "2" style="font-weight: bold;"><input name=title type="text" style="width: 100%;" placeholder="제목을 입력해주세요." required><br></td>
                </tr>
                <tr>
                    <td colspan = "2"><textarea id="ckeditor" name="content" class="content" required></textarea></td>
                </tr>
				<tr>
                	<td style = "width : 180px; text-align : left"><br>광고 썸네일 이미지 등록</td>
                	<td><br><input type="file" name="uploadFile" /></td>
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
</script>

</body>

</html>