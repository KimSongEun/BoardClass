<%@page import="kh.semi.boardclass.game.model.vo.Game"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
	Game g = (Game)request.getAttribute("gamevo");
	%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>보드게임 수정</title>
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
	<script src = "ckeditor/ckeditor.js"></script>
    <script type="text/javascript" src="./ckeditor/ckeditor.js"></script>

</head>

<body>
    <%@include file="/WEB-INF/admin/main/adminHeader.jsp" %>
    <div>
        <form method="post" action="boardgameupdate" enctype = "multipart/form-data">
            <table style="text-align: center; font-size: 15px; margin: 0 auto; margin-top: 50px; width : 900px">
                <tr>
                    <td style="text-align: left; font-size: 34px; font-weight: bold;">보드게임 수정</td>
                </tr>
                <tr style="text-align: left; font-size: 16px;">
                <%if(g !=null){%>
                    <td style="font-weight: bold;"><input name=title type="text" style="width: 100%;" value = "<%=g.getGameKoName()%>" required><br></td>
                </tr>
                <tr>
                    <td><textarea id="ckeditor" name="content" class="content" required><%=g.getGameEnName() %></textarea></td>
                </tr>
                
                <tr style="text-align: left; font-size: 16px;">
					<td><br>보드게임 썸네일 이미지 : <%=g.getGameRuleImage()%> </td>
				</tr>
				<tr>
					<td style = "text-align: left; font-size: 16px; color : #F08080">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								👆🏻수정 파일 등록 : <input style = "display : inline-block"type="file" name="uploadFile"/></td>
				</tr>
				<input type="hidden" name="no" value = "${gameno}" />
				<input type="hidden" name="originimg" value="<%=g.getGameImage()%>"/>
				<%} %>
                <tr>
                    <td><br><button class='btn btn-warning' value='등록' type="submit">수정</button>
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