<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>κ³΅μ§λ±λ‘</title>
    <link rel="stylesheet" href="./css/admin/main/adminHeader.css"/> 
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src = "./ckeditor/ckeditor.js"></script>
    <script type="text/javascript" src="./ckfinder/ckfinder.js"></script>
    <script src="https://cdn.ckeditor.com/ckeditor5/25.0.0/classic/ckeditor.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
    <link rel="icon" href="./img/dicedice.ico" type="image/x-icon" sizes="16x16">
<!-- 	<style>
	.ck .ck-editor_main > .ck-editor_editable {
    	max-width: 800px;
    	height: 300px;
	}
	</style> -->
</head>

<body>
    <%@include file="/WEB-INF/admin/main/adminHeader.jsp" %>
    <div>
        <form method="post" action="noticemade">
            <table style="text-align: center; font-size: 15px; margin: 0 auto; margin-top: 50px; width : 900px">
                <tr>
                    <td style="text-align: left; font-size: 34px; font-weight: bold;">π κ³΅μ§λ±λ‘ π</td>
                </tr>
                <tr style="text-align: left; font-size: 16px;">
                    <td style="font-weight: bold;"><input name=title type="text" style="width: 100%;" placeholder="μ λͺ©μ μλ ₯ν΄μ£ΌμΈμ." required><br></td>
                </tr>
                <tr>
                    <td><textarea id="editor" name="content" class="content" required></textarea></td>
                </tr>
                <tr>
                    <td><br><button class='btn btn-warning' value='λ±λ‘' type="submit">λ±λ‘</button>
                        &nbsp;
                        <button type="button" class = 'btn btn-warning' onclick="if(confirm('κ³΅μ§μ¬ν­ μμ±μ μ·¨μνμκ² μ΅λκΉ?')){window.close()}else{}">μ·¨μ</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
<script>
var editor = CKEDITOR.replace("editor", {height : 300

/* 	,
	filebrowserBrowseUrl = "../ckfinder/ckfinder.html",
	filebrowserFlashBrowseUrl = "../ckfinder/ckfinder.html?type=Flash",
	filebrowserUploadUrl = "../ckfinder/core/connector/java/connctor.java?command=QuickUpload&type=Files",
	filebrowserImageUploadUrl = "../ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images",
	filebrowserFlashUploadUrl = "../ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash" */
	});
	
CKFinder.setupCKEditor(editor);
/* ClassicEditor
.create( document.querySelector( '#editor' ), {
	ckfinder : { uploadUrl: 'imageUpload'	},
	
} )
.then( editor => {
	window.editor = editor
} )
.catch( error => {
        console.log( "aaa" );
} ); */
</script>

</body>

</html>