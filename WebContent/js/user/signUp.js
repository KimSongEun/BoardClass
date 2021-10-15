
    $(function () {
        // 아이디 중복 체크
        $("#dupidchkBtn").on('click', function () {
            var regex = /^[A-Za-z0-9]{1,20}$/; // 정규식을 통한 문자열 패턴 분석
            var chk = 0;
            if (form.userId.value == "") {
                $("#idcheck").text("");
                alert('아이디를 입력하세요.');
                form.userId.focus();
                return false;
            }

            $.ajax({ // ajax를 통한 아이디 중복 값 체크
                url: "dupidchk",
                type: "post",
                async: false,
                data: {
                    userId: $('#userId').val()
                },
                dataType: "text",
                success: function (value) {
                    if (value === "fail") {
                        //alert("이미 존재하는 아이디입니다.");
                        $("#idcheck").text("이미 존재하는 아이디입니다.\n 아이디를 다시 입력해주세요.");
                        $("#idcheck").css("color", "red");
                        document.form.idDuplication.value = "idUncheck";
                    } else {
                        if ($('#userId').val().length > 20) {
                            $("#idcheck").text("");
                            alert("아이디는 20자 이내로 작성되어야 합니다.");
                        } else if (!regex.test($('#userId').val())) {
                            $("#idcheck").text("");
                            alert("아이디는 영문자와 숫자만 입력가능합니다.");
                        } else {
                            $("#idcheck").text("사용할 수 있는 아이디입니다.");
                            $("#idcheck").css("color", "blue");
                            document.form.idDuplication.value = "idCheck";
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
 });