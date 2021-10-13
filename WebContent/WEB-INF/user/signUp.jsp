<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
                        <td class="col1">* 이름</td>
                        <td class="col2"><input type="text" name="userName" id="userName" maxlength="5"
                                placeholder="이름을 입력해주세요.">
                        </td>
                    </tr>
                    <tr>
                        <td class="col1">* 닉네임</td>
                        <td class="col2">
                            <input type="text" name="userNickname" id="userNickname" maxlength="8" placeholder="닉네임을 입력해주세요.">
                            <input class='dupnicknamechkBtn' id="dupnicknamechkBtn" type="button" value="중복확인" onclick="">
                        </td>
                    </tr>
                    <tr>
                        <td class="col1">* 아이디</td>
                        <td class="col2">
                            <input type="text" name="userId" id="userId" maxlength="20" placeholder="아이디를 입력해주세요." onkeydown="inputIdChk()">
                            <input class='dupidchkBtn' id="dupidchkBtn" type="button" value="중복확인" >     
                        </td>
                    </tr>
                    <tr>
                        <td class="col1">* 비밀번호</td>
                        <td class="col2">
                            <input type="password" name="userPassword" id="userPassword" maxlength="16" placeholder="비밀번호를 입력해주세요.">
                            <span>8자리 이상, 대/소문자 구분</span>
                        </td>
                    </tr>
                    <tr>
                        <td class="col1">* 비밀번호 확인</td>
                        <td class="col2"><input type="password" name="pwdCheck" id="pwdCheck" maxlength="16"
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
                            <input type="text"  name="userPhone" id="userPhone" placeholder="핸드폰 번호를 입력해주세요.">
                             <span>  - 를 제외하고 숫자만 10~11자리 입력  EX)01012345678 </span>
                            <input class='phoneNumBtn' type="button" value="인증번호 전송" onclick="">
                        </td>
                    </tr>
                    <tr>
                        <td class="col1">* 인증번호 확인</td>
                        <td class="col2"><input type="number" name="confirmNum" id="confirmNum" maxlength="6" placeholder="전송받은 인증번호 입력">
                            <input class='confirmNumBtn' type="button" value="인증번호 확인" onclick="">
                        </td>
                    </tr>
                    <tr>
                        <td class="col1">주소 (선택)</td>
                        <td class="col2"><input type="text" name="address" id="address" maxlength="16" placeholder="주소를 입력해주세요.">
                    </tr>

                </table>
            </div>
            <div class="create">
                 <input class="signupBtn" id="signupBtn" type="button" value="회원가입" > 
                <input class="cancelBtn" type="reset" value="취소" onclick="">

            </div>
        </div>
  </form>
</body>
</html>