<%@page contentType="text/html; UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//0TD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>后台管理系统-找回密码</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.default.css" id="theme-stylesheet">
    <link href="${pageContext.request.contextPath}/css/light-theme.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/dark-theme.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/colored-theme.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/buttonStyle.css" rel="stylesheet">
</head>
<body>
<div class="page login-page">
    <div class="container d-flex align-items-center">
        <div class="form-holder has-shadow">
            <div class="row">
                <!-- Logo & Information Panel-->
                <div class="col-lg-6">
                    <div class="info d-flex align-items-center">
                        <div class="content">
                            <div class="logo">
                                <h1>金风羚后台管理系统</h1>
                            </div>
                            <p>密码找回</p>
                        </div>
                    </div>
                </div>
                <!-- Form Panel    -->
                <div class="col-lg-6 bg-white">
                    <div class="form d-flex align-items-center">
                        <div class="content">
                            <div class="form-group">
                                <input id="retrieve-userid" type="text" name="userId" autocomplete="off"
                                       placeholder="请输入用户号" class="input-material">
                                <div class="invalid-feedback">
                                    请输入登录用户号
                                </div>
                            </div>
                            <div class="form-group">
                                <input id="retrieve-userphone" class="input-material" type="phone" autocomplete="off"
                                       name="registerUserPhone" placeholder="请输入用户手机号">
                                <div class="invalid-feedback">
                                    请输入用户手机号码
                                </div>
                            </div>
                            <table>
                                <tr>
                                    <td>
                                        <div class="form-group">
                                            <input id="retrieve-code" type="text" name="code" autocomplete="off"
                                                   placeholder="请输入验证码" placeholder="请输入验证码" class="input-material"
                                                   style="width: 250px">
                                            <div class="invalid-feedback" id="verifyCode">
                                                请输入验证码
                                            </div>
                                        </div>
                                    </td>
                                    <td>
                                        <div style="background: #b1b3b2;  height:39px; margin-left:10px; margin-top: -35px; border-radius: 0.1rem">
                                            <input style="border-radius: 0.1rem; width: 190px" class="btn btn-primary"
                                                   id="btn" name="btn" value="发送验证码" onclick="sendMessage()">
                                        </div>
                                    </td>
                                </tr>
                            </table>
                            <div class="form-group">
                                <input id="retrieve-password" class="input-material" type="password"
                                       name="registerPassword" placeholder="请输入新密码">
                                <div class="invalid-feedback">
                                    密码必须在6~12位之间
                                </div>
                            </div>
                            <div class="form-group">
                                <input id="retrieve-passwords" class="input-material" type="password"
                                       name="registerPasswords" placeholder="请确认新密码">
                                <div class="invalid-feedback">
                                    两次密码必须相同 且在6~10位之间
                                </div>
                            </div>
                            <div class="form-group">
                                <button id="regbtn" type="button" name="registerSubmit" class="btn btn-primary">提交
                                </button>
                            </div>
                            <small>密码记住了:)</small><a href="login.jsp" class="signup">&nbsp;登录</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- JavaScript files-->
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/growl-notification.min.js"></script>
<script type="text/javascript">

    var InterValObj; //timer变量，控制时间
    var count = 60; //间隔函数，1秒执行
    var curCount;//当前剩余秒数
    function sendMessage() {
        curCount = count;
        $("#btn").attr("disabled", "true");
        $("#btn").val(curCount + "秒后可重新发送");
        InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一次请求后台发送验证码 TODO
    }

    //timer处理函数
    function SetRemainTime() {
        if (curCount == 0) {
            window.clearInterval(InterValObj);//停止计时器
            $("#btn").removeAttr("disabled");//启用按钮
            $("#btn").val("重新发送验证码");
        } else {
            curCount--;
            $("#btn").val(curCount + "秒后可重新发送");
        }
    }

    $(function () {
        /*错误class  form-control is-invalid
        正确class  form-control is-valid*/
        var flagId = false;
        var flagPhone = false;
        var flagCode = false;
        var flagPas = false;
        var flagPass = false;
        var sms = "";
        /*验证用户号*/
        var id, phone, code, passWord, passWords;
        $("#btn").attr("readonly", "true");
        $("#retrieve-userid").change(function () {
            id = $("#retrieve-userid").val();
            if (id.length < 1) {
                $("#retrieve-userid").removeClass("form-control is-valid")
                $("#retrieve-userid").addClass("form-control is-invalid");
                flagId = false;
            } else {
                $("#retrieve-userid").removeClass("form-control is-invalid")
                $("#retrieve-userid").addClass("form-control is-valid");
                flagId = true;
            }
        });
        /*验证电话号码*/
        $("#retrieve-userphone").change(function () {
            phone = $("#retrieve-userphone").val();
            if (phone.length != 11) {
                $("#retrieve-userphone").removeClass("form-control is-valid")
                $("#retrieve-userphone").addClass("form-control is-invalid");
                flagPhone = false;
            } else {
                $("#retrieve-userphone").removeClass("form-control is-invalid")
                $("#retrieve-userphone").addClass("form-control is-valid");
                flagPhone = true;
            }
        });
        /*验证验证码*/
        $("#retrieve-code").change(function () {
            code = $("#retrieve-code").val();
            if (code.length < 1) {
                $("#retrieve-code").removeClass("form-control is-valid")
                $("#retrieve-code").addClass("form-control is-invalid");
                flagCode = false;
            } else {
                $("#retrieve-code").removeClass("form-control is-invalid")
                $("#retrieve-code").addClass("form-control is-valid");
                flagCode = true;
            }
        });
        /*验证密码*/
        $("#retrieve-password").change(function () {
            passWord = $("#retrieve-password").val();
            if (passWord.length < 6 || passWord.length > 12) {
                $("#retrieve-password").removeClass("form-control is-valid")
                $("#retrieve-password").addClass("form-control is-invalid");
                flagPas = false;
            } else {
                $("#retrieve-password").removeClass("form-control is-invalid")
                $("#retrieve-password").addClass("form-control is-valid");
                flagPas = true;
            }
        })
        /*验证确认密码*/
        $("#retrieve-passwords").change(function () {
            passWords = $("#retrieve-passwords").val();
            if ((passWord != passWords) || (passWords.length < 6 || passWords.length > 12)) {
                $("#retrieve-passwords").removeClass("form-control is-valid");
                $("#retrieve-passwords").addClass("form-control is-invalid");
                flagPass = false;
            } else {
                $("#retrieve-passwords").removeClass("form-control is-invalid");
                $("#retrieve-passwords").addClass("form-control is-valid");
                flagPass = true;
            }
        });

        $("#retrieve-code").focus(function () {
            $("#retrieve-userphone").trigger("change");
        });

        $("#btn").click(function () {
            var phone = $("#retrieve-userphone").val();
            var messageCodeX1 = {
                "phone": phone
            };
            var messageCodeInput = {"messageCodeX1": messageCodeX1};
            $.ajax({
                type: "POST",
                url: "http://localhost:8080/pas2/user/code",
                dataType: "json",
                contentType: "application/json",
                data: JSON.stringify(messageCodeInput),
                headers: {'Content-Type': 'application/json'},
                success: function (data) {
                    console.log(data);
                    if (data.messageCodeZ1 != null) {
                        sms = data.messageCodeZ1.code;
                    }
                }
            });

        });

        function getOptions() {
            var animationOptions = {
                open: "slide-in",
                close: "slide-out"
            };
            return options = {
                image: {
                    visible: true
                },
                position: "top-center",
                closeTimeout: 2000,
                closeWith: ['click'],
                animation: animationOptions,
                showButtons: false,
                showProgress: true
            };
        }

        $("#regbtn").click(function () {
            var options = getOptions();
            if (flagId && flagPhone && flagCode && flagPas && flagPass) {
                if (code != sms) {
                    options.description = '验证码输入有误:( 请重新输入！';
                    //options.image = 'img/success.png';
                    options.image = {
                        visible: false
                    };
                    options.type = 'info';
                    GrowlNotification.notify(options);
                    $("#retrieve-code").val("");
                    $("#retrieve-code").trigger("change");
                    document.getElementById("retrieve-code").focus();
                    return;
                }
                var updatePasswordX1 = {
                    "userId": id,
                    "userPhone": phone,
                    "userPassword": passWord
                }
                var updatePasswordInput = {"updatePasswordX1": updatePasswordX1}
                $.ajax({
                    type: "POST",
                    url: "http://localhost:8080/pas2/user/update",
                    dataType: "json",
                    contentType: "application/json",
                    data: JSON.stringify(updatePasswordInput),
                    headers: {'Content-Type': 'application/json'},
                    success: function (data) {
                        console.log(data);
                        if (data.Error == null) {
                            options.description = '密码修改成功! 这次要记牢咯 :)';
                            //options.image = 'img/success.png';
                            options.image = {
                                visible: false
                            };
                            options.type = 'success';
                            GrowlNotification.notify(options);
                            window.setTimeout(function () {
                                window.location.replace("login.jsp");
                            }, 2000);

                        } else {
                            var error = data.Error;
                            options.description = '密码修改失败:( 错误信息：' + error.message;
                            //options.image = 'img/success.png';
                            options.image = {
                                visible: false
                            };
                            options.type = 'warning';
                            GrowlNotification.notify(options);
                            $("#retrieve-userphone").val("");
                            $("#retrieve-userphone").removeClass("form-control is-valid");
                            $("#retrieve-code").val("");
                            $("#retrieve-code").removeClass("form-control is-valid");
                            $("#retrieve-password").val("");
                            $("#retrieve-password").removeClass("form-control is-valid");
                            $("#retrieve-passwords").val("");
                            $("#retrieve-passwords").removeClass("form-control is-valid");
                            document.getElementById("retrieve-userphone").focus()
                        }
                    },
                    error: function (e) {
                        console.log('ajax请求异常，异常信息如下：', e);
                    }
                });
            } else {
                if (!flagId) {
                    $("#retrieve-userid").addClass("form-control is-invalid");
                }
                if (!flagPhone) {
                    $("#retrieve-userphone").addClass("form-control is-invalid");
                }
                if (!flagCode) {
                    $("#retrieve-code").addClass("form-control is-invalid");
                }
                if (!flagPas) {
                    $("#retrieve-password").addClass("form-control is-invalid");
                }
                if (!flagPass) {
                    $("#retrieve-passwords").addClass("form-control is-invalid");
                }
            }
        })
    })
</script>
</body>
</html>
