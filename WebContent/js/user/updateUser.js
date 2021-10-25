
    $(function () {
	$('#userPassword').val('');
	

        // 닉네임 중복 체크
        $("#dupnicknamechkBtn").on('click', function () {
            var regex = /^[A-Za-z0-9가-힣]{1,8}$/; // 정규식을 통한 문자열 패턴 분석
            var chk = 0;
            if (form.userNickname.value == "") {
                $("#nicknamecheck").text("");
                alert('닉네임을 입력하세요.');
                form.userNickname.focus();
                return;
            }

            $.ajax({ // ajax를 통한 닉네임 중복 값 체크
                url: "dupnicknamechk",
                type: "post",
                async: false,
                data: {
                    userNickname: $('#userNickname').val()
                },
                dataType: "text",
                success: function (value) {
                    if (value === "fail") {
                        $("#nicknamecheck").text("이미 존재하는 닉네임입니다.");
                        $("#nicknamecheck").css("color", "red");
                        document.form.nickDuplication.value = "nicknameUncheck";

                    } else {

                        if (!regex.test($('#userNickname').val())) {
                            $("#nicknamecheck").text("");
                            alert("닉네임는 영문자, 숫자, 한글 입력가능합니다.");
                        }
                        else if ($('#userNickname').val().length > 8) {
                            $("#nicknamecheck").text("");
                            alert("닉네임은 8자 이내로 작성되어야 합니다.");
                        } else {
                            $("#nicknamecheck").text("사용할 수 있는 닉네임입니다.");
                            $("#nicknamecheck").css("color", "blue");
                            document.form.nickDuplication.value = "nicknameCheck";
                            chk++;
                        }
                    }
                },
                error: function (request, status, error) {
                    alert("code:" + request.status + "\n" + "message:"
                        + request.responseText + "\n" + "error:"
                        + error);
                }
            });
        });


        //비밀번호 유효성검사
        $("#userPassword").on("input", function () {
            var regex = /^[a-zA-Z0-9]{5,20}$/;
            var result = regex.exec($("#userPassword").val())

            if (result != null) {
                $(".userPassword.regex").html("");
            } else {
                $(".userPassword.regex").html("영어대소문자 및 숫자를 사용하여 5-20자리이내로 입력해주세요");
                $(".userPassword.regex").css("color", "red");
            }
        });

        //email유효성 검사
        $("#userEmail").on("input", function () {
            var regex = /^[A-Za-z0-9]*[@]{1}[A-Za-z0-9]+[A-Za-z0-9]*[.]{1}[A-Za-z]{1,3}$/;
            var result = regex.exec($("#userEmail").val());

            if (result != null) {
                $(".userEmail.regex").html("");
            } else {
                $(".userEmail.regex").html("올바른 이메일 형식이 아닙니다");
                $(".userEmail.regex").css("color", "red");
            }
        });

        //휴대폰 번호 유효성검사
        $("#userPhone").on("input", function () {
            var regex = /^01\d\d{3,4}\d{4}$/;
            var result = regex.exec($("#userPhone").val());

            if (result != null) {
                $(".userPhone.regex").html("");
            } else {
                $(".userPhone.regex").html("올바른 핸드폰 번호 형식이 아닙니다");
                $(".userPhone.regex").css("color", "red");
            }

        });
        $("#userAddress").on("input", function () {
            var regex = /[가-힣]{2,}/;
            var result = regex.exec($("#userAddress").val());

            if (result != null) {
                $(".userAddress.regex").html("");
            } else {
                $(".userAddress.regex").html("올바른 주소 형식이 아닙니다");
                $(".userAddress.regex").css("color", "red");
            }

        });
 
	$('input[name="userNickname"]').change(function(){
  if ($(this).val())
  {
    $("input[name='dupnicknamechkBtn']").removeAttr('disabled');
  }
});

//회원가입 버튼 눌렀을 때, 빈칸 있으면 다시 유효성 검사진행    
        $("#updateBtn").on("click", function () {

           
            var nickname = $("#userNickname").val();
            var pw = $("#userPassword").val();
            var email = $("#userEmail").val();
            var phone = $("#userPhone").val();
       

         
            var nicknameregex = /^[A-Za-z0-9가-힣]{1,8}$/;
            var pwregex = /^[a-zA-Z0-9]{5,20}$/;
            var emailregex = /^[A-Za-z0-9]*[@]{1}[A-Za-z0-9]+[A-Za-z0-9]*[.]{1}[A-Za-z]{1,3}$/;
            var phoneregex = /^01\d\d{3,4}\d{4}$/;
       

         
            var nicknameregex = nicknameregex.exec(nickname);
            if (nicknameregex == null) {
                alert("닉네임을 다시 확인해주세요 \n 닉네임은 한글과 영문자만 입력가능합니다.");
                form.userNickname.focus();
                retrun;
            }
           
            var pwregex = pwregex.exec(pw);
            if (pwregex == null) {
                alert("비밀번호를 다시 확인해주세요. \n 비밀번호는 영문자와 숫자, 5~20자 이내로 입력가능합니다.");
                form.userPassword.focus();
                return false;
            }
            var emailregex = emailregex.exec(email);
            if (emailregex == null) {
                alert("이메일을 다시 확인해주세요 \n ex)aaa123@aaaa.com");
                form.userEmail.focus();
                return false;
            }
            var phoneregex = phoneregex.exec(phone);
            if (phoneregex == null) {
                alert("휴대폰 번호를 다시 확인해주세요 \n 휴대폰 번호는 - 를 제외한 숫자 10~11자리만 입력가능합니다.");
                form.userPhone.focus();
                return false;
            }

            //빈칸 없을 때 제출.
            $("#signform").submit();
 
        });

        // 아이디 입력창에 값 입력시 hidden에 idUncheck를 세팅한다.
        // 중복체크 후 다시 아이디 창이 새로운 아이디를 입력했을 때 다시 중복체크
        
        function inputNicknameChk() {
            document.form.nickDuplication.value = "nicknameUncheck";
        }


 });