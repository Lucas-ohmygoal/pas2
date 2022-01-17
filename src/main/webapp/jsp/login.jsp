<%@page contentType="text/html; UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//0TD HTML 4.01 Transitional//EN">
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>金凤羚后台管理系统</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="robots" content="all,follow">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
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
                                <h1>金风羚电器有限公司</h1>
                            </div>
                            <p>后台管理系统</p>
                        </div>
                    </div>
                </div>
                <!-- Form Panel    -->
                <div class="col-lg-6 bg-white">
                    <div class="form d-flex align-items-center">
                        <div class="content">
                            <form method="post" action="homepage.jsp" id="loginForm" name="loginForm">
                                <div class="form-group">
                                    <input id="login-username" type="text" name="userName" autocomplete="off"
                                           placeholder="用户号" class="input-material">
                                    <div class="invalid-feedback">
                                        请输入登录用户号
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input id="login-password" type="password" name="passWord"
                                           placeholder="密码" class="input-material">
                                    <div class="invalid-feedback">
                                        请输入登录密码
                                    </div>
                                </div>
                                <table>
                                    <tr>
                                        <td>
                                            <div class="form-group">
                                                <input id="login-code" type="text" name="code" autocomplete="off"
                                                       placeholder=验证码 placeholder="请输入验证码" class="input-material"
                                                       style="width: 300px">
                                                <div class="invalid-feedback">
                                                    请输入验证码
                                                </div>
                                            </div>
                                        </td>
                                        <td>
                                            <div style="background: #b1b3b2; width: 89px; height: 45px; margin-left:20px; margin-top: -40px">
                                                <canvas id="canvas" width="87" height="43" onclick="dj()"
                                                        style="border: 1px solid #eee;border-radius: 2px;color: #4e555b;cursor: pointer;">
                                                </canvas>
                                            </div>
                                        </td>
                                    </tr>
                                </table>

                                <button id="login" type="button" class="btn btn-primary">登录</button>
                                <div style="margin-top: -40px;">
                                    <!-- <input type="checkbox"  id="check1"/>&nbsp;<span>记住密码</span>
                                        <input type="checkbox" id="check2"/>&nbsp;<span>自动登录</span> -->
                                    <div class="custom-control custom-checkbox " style="float: right;">
                                        <input type="checkbox" class="custom-control-input" id="automatic">
                                        <label class="custom-control-label" for="automatic">自动登录</label>
                                    </div>
                                    <div class="custom-control custom-checkbox " style="float: right;">
                                        <input type="checkbox" class="custom-control-input" id="memorized">
                                        <label class="custom-control-label" for="memorized">记住密码&nbsp;&nbsp;</label>
                                    </div>
                                </div>
                            </form>
                            <br/>
                            <small>没有账号?</small><a href="register.jsp" class="signup">&nbsp;注册</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <small>忘记秘密？</small><a href="retrieve.jsp" class="signup">&nbsp;找回密码</a>
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
<!--表单验证-->
<!-- Main File-->
<script src="${pageContext.request.contextPath}/js/jquery.cookie.js"></script>
<script src="${pageContext.request.contextPath}/js/growl-notification.min.js"></script>
<script type="text/javascript">
    var show_num = [];
    draw(show_num);

    function dj() {
        draw(show_num);
    }

    $(function () {
        var flagId = false;
        var flagPassword = false;
        var flagCode = false;
        var id, password, code;
        $("#login-username").change(function () {
            id = $("#login-username").val();
            if (id.length < 1) {
                $("#login-username").removeClass("form-control is-valid");
                $("#login-username").addClass("form-control is-invalid");
                flagId = false;
            } else {
                $("#login-username").removeClass("form-control is-invalid");
                $("#login-username").addClass("form-control is-valid");
                flagId = true;
            }
            change(id);
        });
        $("#login-password").change(function () {
            password = $("#login-password").val();
            if (password.length < 1) {
                $("#login-password").removeClass("form-control is-valid");
                $("#login-password").addClass("form-control is-invalid");
                flagPassword = false;
            } else {
                $("#login-password").removeClass("form-control is-invalid");
                $("#login-password").addClass("form-control is-valid");
                flagPassword = true;
            }
        });
        $("#login-code").change(function () {
            code = $("#login-code").val();
            if (code < 1) {
                $("#login-code").removeClass("form-control is-valid");
                $("#login-code").addClass("form-control is-invalid");
                flagCode = false;
            } else {
                $("#login-code").removeClass("form-control is-invalid");
                $("#login-code").addClass("form-control is-valid");
                flagCode = true;
            }
        });

        /*登录*/
        $("#login").on('click', function () {
            var options = getOptions();
            if (flagId && flagPassword && flagCode) {
                var val = document.getElementById("login-code").value;
                var num = show_num.join("");
                if (val == '') {
                } else {
                    if (val == num) {
                        verify();
                        draw(show_num);
                    } else {
                        options.title = '温馨提示 :(';
                        options.description = '验证码错误！请重新输入！';
                        //options.image = 'img/success.png';
                        options.image = {
                            visible: true
                        };
                        options.type = 'warning';
                        GrowlNotification.notify(options);
                        document.getElementById("login-code").value = '';
                        draw(show_num);
                        $("#login-code").addClass("form-control is-invalid");
                    }
                }
            } else {
                if (!flagId) {
                    $("#login-username").addClass("form-control is-invalid");
                }
                if (!flagPassword) {
                    $("#login-password").addClass("form-control is-invalid");
                }
                if (!flagCode) {
                    $("#login-code").addClass("form-control is-invalid");
                }
            }

        });

    });

    /*判断上次是否勾选记住密码和自动登录*/
    function change(id) {
        var userInfoQueryX1 = {
            "userNumber": id,
            "userPriority": 1
        };
        var userInfoQueryInput = {"userInfoQueryX1": userInfoQueryX1};
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/pas2/user/query",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(userInfoQueryInput),
            headers: {'Content-Type': 'application/json'},
            success: function (data) {
                console.log(data);
                if (data.userInfoQueryZ1 != null) {
                    var isMemorized = data.userInfoQueryZ1.isMemorized;
                    var isAutomatic = data.userInfoQueryZ1.isAutomatic;
                    if (isMemorized == "Y") {
                        $("#memorized").attr("checked", "checked");
                        $("#login-password").val(data.userInfoQueryZ1.userPassword);
                        $("#login-password").trigger("change");
                        document.getElementById("login-code").focus();
                    }
                    if (isMemorized == "Y" && isAutomatic == "Y") {
                        $("#automatic").attr("checked", "checked");
                        var num = show_num.join("");
                        $("#login-code").val(num);
                        $("#login-code").trigger("change");
                        $("#login").trigger("click");
                        $("#login-code").blur();
                        window.setTimeout("loginForm.submit();", 2000);
                    }
                }

            },
            error: function (e) {
                console.log('ajax请求异常，异常信息如下：', e);
            }
        });
    }

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
            closeTimeout: 2000,
            showButtons: false,
            showProgress: true
        };
    }

    function verify() {
        var options = getOptions();
        var memorized = "false";
        var automatic = "false";
        var isMemorized = $("#memorized").is(':checked');
        var isAutomatic = $("#automatic").is(':checked');
        if (isMemorized == true) {
            memorized = "true";
        }
        if (isAutomatic == true) {
            automatic = "true";
        }

        var userLoginX1 = {
            "userNumber": $("#login-username").val(),
            "userPassword": $("#login-password").val(),
            "isRememberPassword": memorized,
            "isAutoLogin": automatic
        };
        var userLoginInput = {"userLoginX1": userLoginX1};
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/pas2/user/login",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(userLoginInput),
            headers: {'Content-Type': 'application/json'},
            success: function (data) {
                console.log(data);
                if (data.userLoginZ1 != null) {
                    var verifyResult = data.userLoginZ1.verifyResult;
                    var verifyInfo = data.userLoginZ1.verifyInfo;
                    if (verifyResult == "T") {
                        $("#loginForm").attr('action', 'homepage.jsp');
                        $("#loginForm").submit();
                    } else {
                        options.title = '登录失败 :(';
                        options.description = '错误信息：' + verifyInfo;
                        //options.image = 'img/success.png';
                        options.image = {
                            visible: true
                        };
                        options.type = 'error';
                        GrowlNotification.notify(options);
                        $("#loginForm").attr('action', 'login.jsp');
                        window.setTimeout("loginForm.submit();", 2200);
                    }
                } else {
                    var error = data.Error;
                    options.title = '系统出错 :(';
                    options.description = '错误信息：' + error.message;
                    //options.image = 'img/success.png';
                    options.image = {
                        visible: true
                    };
                    options.type = 'error';
                    GrowlNotification.notify(options);
                    $("#loginForm").attr('action', 'login.jsp');
                    window.setTimeout("loginForm.submit();", 2200);
                }
            },
            error: function (e) {
                console.log('ajax请求异常，异常信息如下：', e);
            }
        });
    }

    function draw(show_num) {

        var canvas_width = document.getElementById('canvas').clientWidth;
        var canvas_height = document.getElementById('canvas').clientHeight;
        var canvas = document.getElementById("canvas");//获取到canvas的对象，演员
        var context = canvas.getContext("2d");//获取到canvas画图的环境，演员表演的舞台
        canvas.width = canvas_width;
        canvas.height = canvas_height;
        var sCode = "A,B,C,E,F,G,H,J,K,L,M,N,P,Q,R,S,T,W,X,Y,Z,1,2,3,4,5,6,7,8,9,0,q,w,e,r,t,y,u,i,o,p,a,s,d,f,g,h,j,k,l,z,x,c,v,b,n,m";
        var aCode = sCode.split(",");
        var aLength = aCode.length;//获取到数组的长度

        for (var i = 0; i <= 3; i++) {
            var j = Math.floor(Math.random() * aLength);//获取到随机的索引值
            var deg = Math.random() * 30 * Math.PI / 180;//产生0~30之间的随机弧度
            var txt = aCode[j];//得到随机的一个内容
            show_num[i] = txt;
            var x = 10 + i * 20;//文字在canvas上的x坐标
            var y = 20 + Math.random() * 8;//文字在canvas上的y坐标
            context.font = "bold 23px 微软雅黑";

            context.translate(x, y);
            context.rotate(deg);

            context.fillStyle = randomColor();
            context.fillText(txt, 0, 0);

            context.rotate(-deg);
            context.translate(-x, -y);
        }
        for (var i = 0; i <= 5; i++) { //验证码上显示线条
            context.strokeStyle = randomColor();
            context.beginPath();
            context.moveTo(Math.random() * canvas_width, Math.random() * canvas_height);
            context.lineTo(Math.random() * canvas_width, Math.random() * canvas_height);
            context.stroke();
        }
        for (var i = 0; i <= 30; i++) { //验证码上显示小点
            context.strokeStyle = randomColor();
            context.beginPath();
            var x = Math.random() * canvas_width;
            var y = Math.random() * canvas_height;
            context.moveTo(x, y);
            context.lineTo(x + 1, y + 1);
            context.stroke();
        }
    }

    function randomColor() {//得到随机的颜色值
        var r = Math.floor(Math.random() * 256);
        var g = Math.floor(Math.random() * 256);
        var b = Math.floor(Math.random() * 256);
        return "rgb(" + r + "," + g + "," + b + ")";
    }


</script>
</body>

</html>
