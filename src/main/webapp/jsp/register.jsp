<%@page contentType="text/html; UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//0TD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>后台管理系统-用户注册</title>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-editable-select.min.css">
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
                                <h1>金凤羚后台管理系统</h1>
                            </div>
                            <p>用户注册</p>
                        </div>
                    </div>
                </div>
                <!-- Form Panel    -->
                <div class="col-lg-6 bg-white">
                    <div class="form d-flex align-items-center">
                        <div class="content">
                            <form id="register" name="register" method="post" action="login.jsp">
                                <div class="form-group">
                                    <input id="register-username" class="input-material" type="text" name="registerUsername"
                                           placeholder="请输入用户姓名" autocomplete="off">
                                    <div class="invalid-feedback">
                                        姓名输入不合法
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input id="register-userphone" class="input-material" type="phone" autocomplete="off"
                                           name="registerUserPhone" placeholder="请输入用户联系电话">
                                    <div class="invalid-feedback">
                                        电话号码不合法
                                    </div>
                                </div>
                                <table>
                                    <tr>
                                        <td>
                                            <div class="form-group">
                                                <input id="register-code" type="text" name="code" autocomplete="off"
                                                       placeholder="请输入验证码" placeholder="请输入验证码" class="input-material"
                                                       style="width: 250px;font-size: 16px;">
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
                                    <input id="register-password" class="input-material" type="password"
                                           name="registerPassword" placeholder="请输入密码">
                                    <div class="invalid-feedback">
                                        密码必须在6~12位之间
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input id="register-passwords" class="input-material" type="password"
                                           name="registerPasswords" placeholder="确认密码">
                                    <div class="invalid-feedback">
                                        两次密码必须相同 且在6~10位之间
                                    </div>
                                </div>
                                <div class="form-group">
                                    <button id="regbtn" type="button" name="registerSubmit" class="btn btn-primary">注册
                                    </button>
                                </div>
                            </form>

                            <small>已有账号?</small><a href="login.jsp" class="signup">&nbsp;登录</a>
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
<script src="${pageContext.request.contextPath}/js/jquery-editable-select.js"></script>
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
        $("#btn").attr("readonly", "true");
        var flagName = false;
        var flagPhone = false;
        var flagPas = false;
        var flagPass = false;
        var flagCode = false;
        var sms = "";
        /*验证用户名*/
        var name, phone, code,passWord, passWords;
        $("#btn").attr("readonly", "true");
        $("#register-username").change(function () {
            name = $("#register-username").val();
            if (name.length < 0 || name.length > 4) {
                $("#register-username").removeClass("form-control is-valid")
                $("#register-username").addClass("form-control is-invalid");
                flagName = false;
            } else {
                $("#register-username").removeClass("form-control is-invalid")
                $("#register-username").addClass("form-control is-valid");
                flagName = true;
            }
        });
        /*验证电话号码*/
        $("#register-userphone").change(function () {
            phone = $("#register-userphone").val();
            if (phone.length != 11) {
                $("#register-userphone").removeClass("form-control is-valid")
                $("#register-userphone").addClass("form-control is-invalid");
                flagPhone = false;
            } else {
                $("#register-userphone").removeClass("form-control is-invalid")
                $("#register-userphone").addClass("form-control is-valid");
                flagPhone = true;
            }
        });
        /*验证验证码*/
        $("#register-code").change(function () {
            code = $("#register-code").val();
            if (code.length < 1) {
                $("#register-code").removeClass("form-control is-valid")
                $("#register-code").addClass("form-control is-invalid");
                flagCode = false;
            } else {
                $("#register-code").removeClass("form-control is-invalid")
                $("#register-code").addClass("form-control is-valid");
                flagCode = true;
            }
        });

        /*验证密码*/
        $("#register-password").change(function () {
            passWord = $("#register-password").val();
            if (passWord.length < 6 || passWord.length > 12) {
                $("#register-password").removeClass("form-control is-valid")
                $("#register-password").addClass("form-control is-invalid");
                flagPas = false;
            } else {
                $("#register-password").removeClass("form-control is-invalid")
                $("#register-password").addClass("form-control is-valid");
                flagPas = true;
            }
        })
        /*验证确认密码*/
        $("#register-passwords").change(function () {
            passWords = $("#register-passwords").val();
            if ((passWord != passWords) || (passWords.length < 6 || passWords.length > 12)) {
                $("#register-passwords").removeClass("form-control is-valid")
                $("#register-passwords").addClass("form-control is-invalid");
                flagPass = false;
            } else {
                $("#register-passwords").removeClass("form-control is-invalid")
                $("#register-passwords").addClass("form-control is-valid");
                flagPass = true;
            }
        });

        $("#register-code").focus(function () {
            $("#register-userphone").trigger("change");
        });

        $("#btn").click(function () {
            var phone = $("#register-userphone").val();
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
                closeWith: ['click'],
                animation: animationOptions,
                showButtons: false,
                showProgress: true
            };
        }

        $("#regbtn").click(function () {
            var options = getOptions();
            if (flagName && flagPhone && flagCode && flagPas && flagPass) {
                if (code != sms) {
                    options.description = '验证码输入有误:( 请重新输入！';
                    //options.image = 'img/success.png';
                    options.image = {
                        visible: false
                    };
                    options.type = 'info';
                    GrowlNotification.notify(options);
                    $("#register-code").val("");
                    $("#register-code").trigger("change");
                    document.getElementById("register-code").focus();
                    return;
                }
                var userRegisterX1 = {
                    "userName": name,
                    "userPassword": passWord,
                    "userPhone": phone,
                    "priorityLevel": 1
                }
                var userRegisterInput = {"userRegisterX1": userRegisterX1}
                $.ajax({
                    type: "POST",
                    url: "http://localhost:8080/pas2/user/register",
                    dataType: "json",
                    contentType: "application/json",
                    data: JSON.stringify(userRegisterInput),
                    headers: {'Content-Type': 'application/json'},
                    success: function (data) {
                        console.log(data);
                        if (data.userRegisterZ1 != null) {
                            var userNumber = data.userRegisterZ1.userNumber;
                            options.title = '注册成功 :)';
                            options.description = '您的登录用户号为：' + userNumber + "  已发送至您的手机，请注意查收:)";
                            //options.image = 'img/success.png';
                            options.image = {
                                visible: true
                            };
                            options.type = 'success';
                            options.closeTimeout = 3000;
                            GrowlNotification.notify(options);
                            window.setTimeout("register.submit();", 3000);
                        } else {
                            var error = data.Error;
                            options.title = '注册失败 :(';
                            options.description = '错误信息：' + error.message;
                            //options.image = 'img/success.png';
                            options.image = {
                                visible: true
                            };
                            options.type = 'error';
                            options.closeTimeout = 3000;
                            GrowlNotification.notify(options);
                            $("#register").attr('action', 'register.jsp');
                            window.setTimeout("register.submit();", 3000);
                        }
                    },
                    error: function (e) {
                        console.log('ajax请求异常，异常信息如下：', e);
                    }
                });
            } else {
                if (!flagName) {
                    $("#register-username").addClass("form-control is-invalid");
                }
                if (!flagPhone) {
                    $("#register-userphone").addClass("form-control is-invalid");
                }
                if (!flagCode) {
                    $("#register-code").addClass("form-control is-invalid");
                }
                if (!flagPas) {
                    $("#register-password").addClass("form-control is-invalid");
                }
                if (!flagPass) {
                    $("#register-passwords").addClass("form-control is-invalid");
                }
            }
        })
    });
</script>
</body>
</html>
