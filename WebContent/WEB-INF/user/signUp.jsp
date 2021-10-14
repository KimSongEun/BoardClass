<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="./css/user/signUp.css">
  <link rel="stylesheet" href="./css/user/loginHeaderFooter.css">
</head>
<body>
 <%@include file="/WEB-INF/user/userHeader.jsp" %>
<form name="form" method="post" id="signform" action="signup.do" >
        <div class="container">
            <div class="insert">
                <table>
                    <caption>
                        <h2>회원가입</h2>
                        <h3>정보입력</h3>
                        <h4>*은 필수작성 항목입니다.</h4>
                    </caption>
					<tr>
						<td class="col1">프로필사진</td>
						<td class="col2"><input type="file" name="uploadFile" id="userImage" /></td>
					</tr>

					<tr>
                        <td class="col1">* 이름</td>
                        <td class="col2"><input type="text" name="userName" id="userName" maxlength="5"
                                placeholder="이름을 입력해주세요.">
                        </td>
                    </tr>
                    <tr>
                        <td class="col1">* 닉네임</td>
                        <td class="col2">
                            <input type="text" name="userNickname" id="userNickname" maxlength="8" placeholder="닉네임을 입력해주세요.">
                            <input class='CheckBtn' id="dupnicknamechkBtn" type="button" value="중복확인" onclick="">
                        </td>
                    </tr>
                    <tr>
                        <td class="col1">* 아이디</td>
                        <td class="col2">
                            <input type="text" name="userId" id="userId" maxlength="20" placeholder="아이디를 입력해주세요." onkeydown="inputIdChk()">
                            <input class='CheckBtn' id="dupidchkBtn" type="button" value="중복확인" >     
                        </td>
                    </tr>
                    <tr>
                        <td class="col1">* 비밀번호</td>
                        <td class="col2">
                            <input type="password" name="userPassword" id="userPassword" maxlength="20" placeholder="비밀번호를 입력해주세요.">
                            <div>5자리 이상, 대/소문자 구분</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="col1">* 비밀번호 확인</td>
                        <td class="col2"><input type="password" name="pwdCheck" id="pwdCheck" maxlength="20"
                                placeholder="비밀번호를 확인해주세요."></td>     
                    </tr>
                    <tr>
                        <td class="col1">* 이메일</td>
                        <td class="col2">
                            <input type="text"  name="userEmail" id="userEmail" placeholder="이메일을 입력해주세요.">
                        </td>
                    </tr>
                    <tr>
                        <td class="col1">* 핸드폰 번호</td>
                        <td class="col2">
                            <input type="number"  name="userPhone" id="userPhone" placeholder="핸드폰 번호를 입력해주세요.">
                            <input class='CheckBtn' type="button" value="인증번호 전송" onclick="">
                             <div> - 를 제외하고 숫자만 10~11자리 입력  EX)01012345678 </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="col1">* 인증번호 확인</td>
                        <td class="col2"><input type="number" name="confirmNum" id="confirmNum" maxlength="6" placeholder="전송받은 인증번호 입력">
                            <input class='CheckBtn' type="button" value="인증번호 확인" onclick="">
                        </td>
                    </tr>
                    <tr>
                        <td class="col1">주소 (선택)</td>
                        <td class="col2"><input type="text" name="address" id="address" maxlength="25" placeholder="주소를 입력해주세요.">
                    </tr>

                </table>
            </div>
            <div class="create">
                 <input class="signupBtn" id="signupBtn" type="button" value="회원가입" > 
                <input class="cancelBtn" type="reset" value="취소" onclick="">

            </div>
        </div>
  </form>
   <%@include file="/WEB-INF/user/userFooter.jsp" %>
</body>
</html>