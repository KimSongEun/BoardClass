<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%! public int getRandom(){
	int random = 0;
	random = (int)Math.floor((Math.random()*(99999-10000+1)))+10000;
	return random;
} %>
</head>
<body>
<form action="send" method="post" id = "form1">
		<table>
			<tr>
				<td><input type='text' id="receiver" name='receiver'  placeholder="이메일을 입력하세요."/></td>
				<td><input id = "submit" type="submit"  value="인증번호발송"></td>
					<td><input type="hidden" readonly="readonly" name="code_check"
					id="code_check" value="<%=getRandom()%>" /></td>
			</tr>
		</table>
	</form>
</body>
</html>