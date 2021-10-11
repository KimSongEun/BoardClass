<%@page import="kh.semi.boardclass.admin.model.vo.Banner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	Banner b = (Banner)request.getAttribute("bannervo");
	%>
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
        <form method="post" action="adupdate">
            <table style="text-align: center; font-size: 15px; margin: 0 auto; margin-top: 50px; width : 900px">
                <tr>
                    <td style="text-align: left; font-size: 34px; font-weight: bold;">광고수정</td>
                </tr>
                <tr style="text-align: left; font-size: 16px;">
                <%if(b !=null){%>
                    <td style="font-weight: bold;"><input name=title type="text" style="width: 100%;" value = "<%=b.getPromotionTitle()%>" required><br></td>
                </tr>
                <tr>
                    <td><textarea id="ckeditor" name="content" class="content" required><%=b.getPromotionContent() %></textarea></td>
                </tr>
                
                <tr style="text-align: left; font-size: 16px;">
					<td style="font-weight: bold;">작성일 <%=b.getPromotionDate()%> </td>
				</tr>
				<input type="hidden" name="no" value="<%=b.getPromotionNo()%>"/>
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