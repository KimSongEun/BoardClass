<%@page import="kh.semi.boardclass.user.model.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
User user = (User)request.getAttribute("users");

%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/index/maincss.css">
  <link rel="stylesheet" href="css/user/searchIdPwd.css">
  <link rel="icon" href="./img/dicedice.ico" type="image/x-icon" sizes="16x16">

</head>
<body>

	<%@include file="/WEB-INF/index/header.jsp" %>

<section>
	<div class="tab">
            <button class="tablinks" onclick="openIdPwd(event, 'Id')" id="defaultOpen" >아이디 찾기</button>
            <button class="tablinks" onclick="openIdPwd(event, 'Password')" >비밀번호 찾기</button>
    </div>

	      
 		<div id="Id" class="tabcontent">
            <h1>아이디 찾기</h1>
           
            <form name="formId" method="post" id="searchIdform" action="searchid.do">
                <table>
                    <tr>
                        <td class="id1"> 이름</td>
                        <td class="id2"><input type="text" name="userName" id="userName" class="form-control"
                                placeholder="이름을 입력하세요"></td>
                    </tr>

                    <tr>
                        <td class="id1"> 이메일</td>
                        <td class="id2"><input type="text" name="userEmail" id="userEmail" class="form-control"
                                placeholder="이메일을 입력하세요"></td>
                    </tr>
                    <tr>
                        <td class="id1"> 휴대폰 번호</td>
                        <td class="id2"><input type="number" name="userPhone" id="userPhone" class="form-control"
                                placeholder="휴대폰 번호를 입력하세요 (- 제외)"></td>
                    </tr>
                </table>
                <div id="searchId">
                    <input class="searchIdBtn" id="searchIdBtn" type="button" value="아이디 검색">
                    <input class="resetIdBtn" id="resetIdBtn" type="reset" value="취소">
                </div>
            </form>
        </div>

        <div id="Password" class="tabcontent">
            <h1>비밀번호 찾기</h1>
            <form name="formPwd" method="post" id="searchPwdform" action="searchpwd.do">
                <table>
                    <tr>
                        <td class="pwd1"> 이름</td>
                        <td class="pwd2"><input type="text" name="userName" id="userName" class="form-control"
                                placeholder="이름을 입력하세요"></td>
                    </tr>
                    <tr>
                        <td class="pwd1"> 아이디</td>
                        <td class="pwd2"><input type="text" name="userId" id="userId" class="form-control"
                                placeholder="아이디를 입력하세요."></td>
                    </tr>
                    <tr>
                        <td class="pwd1"> 이메일</td>
                        <td class="pwd2"><input type="text" name="userEmail" id="userEmail" class="form-control"
                                placeholder="이메일을 입력하세요"></td>
                    </tr>

                </table>
                <div id="searchPwd">
                    <input class="searchPwdBtn" id="searchPwdBtn" type="button" value="비밀번호 검색">
                    <input class="resetPwdBtn" id="resetPwdBtn" type="reset" value="취소">
                </div>
            </form>
        </div>
</section>
	


	 <%@include file="/WEB-INF/index/footer.jsp" %>
	
<script>

function openIdPwd(evt, IdPwd) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(IdPwd).style.display = "block";
    evt.currentTarget.className += " active";
}

// Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();


window.addEventListener("load", pageLoadedHandler);
function pageLoadedHandler() {
    document.getElementById("searchIdBtn").addEventListener("click", formIdCheck);
    document.getElementById("searchPwdBtn").addEventListener("click", formPwdCheck);
}
function formIdCheck() {
	if (formId.userName.value == "") {
        alert('이름을 입력하세요.');
        formId.userName.focus();
        return false;
    }
	   if (formId.userEmail.value == "") {
        alert('이메일을 입력하세요.');
        formId.userEmail.focus();
        return false;
    }
	   if (formId.userPhone.value == "") {
	    alert('핸드폰 번호를 입력하세요.');
        formId.userPhone.focus();
        return false;
    }
	   formId.submit()
}
function formPwdCheck() {
	if (formPwd.userName.value == "") {
        alert('이름을 입력하세요.');
        formPwd.userName.focus();
        return false;
    }
	   if (formPwd.userId.value == "") {
	        alert('아이디을 입력하세요.');
	        formPwd.userId.focus();
	        return false;
	    }
	   if (formPwd.userEmail.value == "") {
        alert('이메일을 입력하세요.');
        formPwd.userEmail.focus();
        return false;
    }
	   formPwd.submit()
}

</script>

</body>
</html>

