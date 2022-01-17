<%@page contentType="text/html; UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//0TD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>后台管理系统-主页</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/homepage.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-editable-select.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.default.css" id="theme-stylesheet">
    <link href="${pageContext.request.contextPath}/css/light-theme.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/dark-theme.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/colored-theme.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/tableStyle.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/basicTable.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/buttonStyle.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootstrap-chosen.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/datepicker.min.css" rel="stylesheet">
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    String userId = request.getParameter("userId");
    String type = "BS";
%>
<div class="login-page">
    <div class="vessel">
        <div class='nav'>
            <ul>
                <li><a href='homepage.jsp?userName=<%=userId%>'>主页</a></li>
                <li><a href='#'>产品管理</a>
                    <ul>
                        <li><a href='roof-fan.jsp?userId=<%=userId%>'>楼顶扇</a></li>
                        <li><a href='ground-fan.jsp?userId=<%=userId%>'>趴地扇</a></li>
                        <li><a href='floor-fan.jsp?userId=<%=userId%>'>商务扇</a></li>
                        <li><a href='#'>循环扇</a></li>
                    </ul>
                </li>
                <li><a href='#'>部门工作</a>
                    <ul>
                        <li><a href='#'>财务部</a></li>
                        <li><a href='#'>销售部</a></li>
                        <li><a href='#'>技术部</a></li>
                        <li><a href='#'>后勤部</a></li>
                    </ul>
                </li>
                <li><a href='#'>行政管理</a>
                    <ul>
                        <li><a href='#'>人事管理</a></li>
                        <li><a href='#'>客户管理</a></li>
                        <li><a href='#'>物料管理</a></li>
                        <li><a href='#'>设备管理</a></li>
                    </ul>
                </li>
                <li><a href='#'>关于我们</a></li>
                <li><a href='#'>联系我们</a></li>
                <li><a href='#'>个人中心</a></li>
                <li><a href='login.jsp'>退出</a></li>
                <li class='lamp'><span></span></li>
            </ul>
        </div>

        <div class="container d-flex align-items-center" id="roof_fan" style="display: none;">
            <div class="form-holder has-shadow ">
                <div class="row">
                    <!-- Logo & Information Panel-->
                    <div class="col-lg-3">
                        <div class="info">
                            <div class="content">
                                <div class="logo">
                                    <h1>产品管理</h1>
                                </div>
                                <p>商务扇</p>
                            </div>
                            <div class="content">
                                <button style="border-radius: 0.1rem; width: 200px" class="btn btn-light" id="query"
                                        name="query" onclick="query()">
                                    存库综合查询>>
                                </button>
                                <button style="border-radius: 0.1rem; width: 200px" class="btn btn-secondary" id="info"
                                        name="info" onclick="info()">
                                    产品信息查询>>
                                </button>
                                <button style="border-radius: 0.1rem; width: 200px" class="btn btn-success"
                                        id="register"
                                        name="register" onclick="register()">
                                    产品登记>>
                                </button>
                                <button style="border-radius: 0.1rem; width: 200px" class="btn btn-warning"
                                        id="yielding"
                                        name="yielding" onclick="yielding()">
                                    入库登记>>
                                </button>
                                <button style="border-radius: 0.1rem; width: 200px" class="btn btn-info"
                                        id="delivery"
                                        name="delivery">
                                    出库登记>>
                                </button>
                                <button style="border-radius: 0.1rem; width: 200px" class="btn btn-dark" id="details"
                                        name="details" onclick="details()">
                                    进出库明细>
                                </button>
                            </div>
                        </div>
                    </div>
                    <!-- Form Panel    -->
                    <div class="col-lg-9 bg-white">
                        <div class="form d-flex ">
                            <div class="content">
                                <img src="../img/floor-fan.jpg" id="floor"
                                     style="position: relative; height: 420px; width: 360px; top:20px;padding: 0px;left: 23%;">
                                <div id="queryContent" style="display: none">
                                    <h5>︎<a style="color: #007bff;">↯</a>商务扇库存综合查询</h5>
                                    <br/>
                                    <table>
                                        <tr>
                                            <td>
                                                <select id="queryCondition" data-placeholder="请选择查询条件(多选)" class="chosen-select custom-select" style = "width: 450px;" multiple tabindex="5">
                                                    <optgroup label="产品型号" id = "queryTypes" value="labelType">
                                                        <option value="PD-78JU">PD-78JU</option>
                                                        <option value="PD-88HK">PD-88HK</option>
                                                        <option value="PD-89NB">PD-89NB</option>
                                                        <option value="PD-56UH">PD-56UH</option>
                                                    </optgroup>
                                                    <optgroup label="品牌名称" id="queryBrands" value="labelBrand">
                                                        <option value="jt">劲特</option>
                                                        <option value="fly">风来雅</option>
                                                        <option value="zs">钻石</option>
                                                        <option value="czy">创正园</option>
                                                        <option value="kf">可丰</option>
                                                        <option value="nfld">纳丰拉德</option>
                                                    </optgroup>
                                                    <optgroup label="产品尺寸" id="querySizes" value="labelSize">
                                                        <option value="12">12寸</option>
                                                        <option value="14">14寸</option>
                                                        <option value="16">16寸</option>
                                                        <option value="18">18寸</option>
                                                        <option value="20">20寸</option>
                                                    </optgroup>
                                                    <optgroup label="产品颜色" id="queryColors" value="labelColor">
                                                        <option value="white">白色</option>
                                                        <option value="black">黑色</option>
                                                        <option value="gold">金色</option>
                                                        <option value="pink">紫色</option>
                                                        <option value="green">绿色</option>
                                                        <option value="yellow">黄色</option>
                                                    </optgroup>
                                                    <optgroup label="叶片规格" id="queryBlades" value="labelBlade">
                                                        <option value="l3">铝三叶</option>
                                                        <option value="l5">铝五叶</option>
                                                        <option value="p3">塑三叶</option>
                                                        <option value="p5">塑五叶</option>
                                                        <option value="p7">塑七叶</option>
                                                        <option value="i3">铁三叶</option>
                                                        <option value="i5">铁五叶</option>
                                                    </optgroup>
                                                    <optgroup label="电机规格" id="queryMotors" value="labelMotor">
                                                        <option value="ct">铜线T型电机</option>
                                                        <option value="lt">铝线T型电机</option>
                                                        <option value="ca">铜线A型电机</option>
                                                        <option value="la">铝线A型电机</option>
                                                        <option value="lb">铝线B型电机</option>
                                                    </optgroup>
                                                </select>
                                                <div class="invalid-feedback"><a style="position:absolute;font-size: 15px; top:130px;">
                                                    ✗ 查询条件还是要输入一下的吧...
                                                </a>
                                                </div>
                                            </td>
                                            <td>
                                                <button id="storageQuery" type="button" class="btn btn-primary"
                                                        style="width: 90px; margin-left: 80px;">查询
                                                </button>
                                            </td>
                                        </tr>
                                    </table>
                                    <br/><br/><br/>
                                    <div id="resultHolder"  style="width: 450px !important; display: none;">
                                        <table class="table" id="resultTable" >
                                            <thead>
                                            <tr>
                                                <th style="text-align: center; font-size: 20px; font-family: cursive; background-color: #337ab7">查询结果(台)</th>
                                            </tr>
                                            </thead>
                                            <tbody id="resultBody">
                                            <tr id="resultRow" style="height: 60px;">
                                                <td id="result" style="text-align: center;background-color: white;color: #ff666c; font-family: cursive; font-size: 60px;"></td>
                                            </tr>
                                            </tbody>
                                        </table>
                                        <table>
                                            <tr>
                                                <td>
                                                    <div><a style="font-size: 17px;color: #337ab7">
                                                        >> 目前商务扇的库存总量为
                                                    </a><a style="font-family: cursive;font-size: 30px;" id="allStocks"></a></div>
                                                </td>
                                            </tr>
                                        </table>
                                    </div>

                                </div>

                                <div id="registerContent"
                                     style="display: none; position: relative;">
                                    <h5>︎<a style="color: #007bff;">↯</a>商务扇产品信息登记</h5><br/>
                                    <table>
                                        <form method="post" action="floor-fan.jsp?userId=<%=userId%>" id="registerForm"
                                              name="registerForm">
                                            <tr>
                                                <td>
                                                    <div class="form-group">
                                                        <h5 style="color: #1b1e21">产品型号：<a style="color: red;">✎ </a>
                                                        </h5>
                                                        <input id="productsType" type="text" name="productType" required
                                                               data-msg="请输入产品型号" placeholder="PD-28DK"
                                                               class="input-material" autocomplete="off"
                                                               style="width: 200px;">
                                                        <div class="invalid-feedback">
                                                            请输入产品型号
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-group" style="margin-left: 20px;">
                                                        <h5 style="color: #1b1e21"> 产品名称：<a style="color: red;">✎ </a>
                                                        </h5>
                                                        <select class="custom-select" data-msg="请输入产品名称"
                                                                placeholder="普通商务扇" id="productsName"
                                                                style="width: 200px;">
                                                            <option value=rf>普通商务扇</option>
                                                            <option value=rf>变频商务扇</option>
                                                        </select>
                                                        <div class="invalid-feedback">
                                                            请输入产品名称
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-group" style="margin-left: 20px;">
                                                        <h5 style="color: #1b1e21"> 品牌名称：<a style="color: red;">✎ </a>
                                                        </h5>
                                                        <select class="custom-select" data-msg="请输入品牌名称"
                                                                id="productsBrand" placeholder="劲特"
                                                                style="width: 200px;">
                                                            <option value="jt">劲特</option>
                                                            <option value="fly">风来雅</option>
                                                            <option value="zs">钻石</option>
                                                            <option value="czy">创正园</option>
                                                            <option value="kf">可丰</option>
                                                            <option value="kf">钻美特</option>
                                                        </select>
                                                        <div class="invalid-feedback">
                                                            请输入品牌名称
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <div class="form-group">
                                                        <h5 style="color: #1b1e21"> 产品尺寸：<a style="color: red;">✎ </a>
                                                        </h5>
                                                        <select class="custom-select" data-msg="请输入产品尺寸"
                                                                placeholder="16寸" id="productsSize"
                                                                style="width: 200px;">
                                                            <option value="12">12寸</option>
                                                            <option value="14">14寸</option>
                                                            <option value="16">16寸</option>
                                                            <option value="18">18寸</option>
                                                            <option value="20">20寸</option>
                                                        </select>
                                                        <div class="invalid-feedback">
                                                            请输入产品尺寸
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-group" style="margin-left: 20px;">
                                                        <h5 style="color: #1b1e21"> 产品颜色：<a style="color: red;">✎ </a>
                                                        </h5>
                                                        <select class="custom-select" data-msg="请输入产品颜色"
                                                                placeholder="黑色" id="productsColor"
                                                                style="width: 200px;">
                                                            <option value="white">白色</option>
                                                            <option value="black">黑色</option>
                                                            <option value="gold">金色</option>
                                                            <option value="pink">紫色</option>
                                                            <option value="green">绿色</option>
                                                            <option value="yellow">黄色</option>
                                                        </select>
                                                        <div class="invalid-feedback">
                                                            请输入产品颜色
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-group" style="margin-left: 20px;">
                                                        <h5 style="color: #1b1e21"> 叶片规格：<a style="color: red;">✎ </a>
                                                        </h5>
                                                        <select class="custom-select" data-msg="请输入叶片规格"
                                                                placeholder="铝三叶" id="productsBlade"
                                                                style="width: 200px;">
                                                            <option value="l3">铝三叶</option>
                                                            <option value="l5">铝五叶</option>
                                                            <option value="p3">塑三叶</option>
                                                            <option value="p5">塑五叶</option>
                                                            <option value="p7">塑七叶</option>
                                                            <option value="i3">铁三叶</option>
                                                            <option value="i5">铁五叶</option>
                                                        </select>
                                                        <div class="invalid-feedback">
                                                            请输入叶片规格
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <div class="form-group">
                                                        <h5 style="color: #1b1e21"> 电机规格：<a style="color: red;">✎ </a>
                                                        </h5>
                                                        <select class="custom-select" data-msg="请输电机规格"
                                                                placeholder="铜线T型电机" id="productsMotor"
                                                                style="width: 200px;">
                                                            <option value="ct">铜线T型电机</option>
                                                            <option value="lt">铝线T型电机</option>
                                                            <option value="ca">铜线A型电机</option>
                                                            <option value="la">铝线A型电机</option>
                                                            <option value="lb">铝线B型电机</option>
                                                        </select>
                                                        <div class="invalid-feedback">
                                                            请输入电机规格
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-group" style="margin-left: 20px;">
                                                        <h5 style="color: #1b1e21"> 预售价格(元)：<a
                                                                style="color: red;">✎ </a></h5>
                                                        <input id="productsPrice" type="text" name="productPrice"
                                                               required data-msg="请输入预售价格" placeholder="57.5"
                                                               class="input-material" autocomplete="off"
                                                               style="width: 200px;">
                                                        <div class="invalid-feedback">
                                                            请输入预售价格
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                        </form>
                                    </table>
                                    <br/>
                                    <button id="submit" type="submit" class="btn btn-primary">提交</button>
                                </div>

                                <div id="infoContent" style="position: relative; display: none;">
                                    <h5>︎<a style="color: #007bff;">↯</a>楼顶扇产品信息查询</h5><br/>
                                    <table>
                                        <tr>
                                            <td>
                                                <select id="conditions" class="custom-select"
                                                        style="position: relative; width: 270px;">
                                                    <option value="default">请选择查询条件☟</option>
                                                    <option value="id">按编号查询</option>
                                                    <option value="brands">按品牌查询</option>
                                                    <option value="sizes">按尺寸查询</option>
                                                    <option value="types">按型号查询</option>
                                                    <option value="colors">按颜色查询</option>
                                                    <option value="all">全部</option>
                                                </select>
                                            </td>
                                            <td>
                                                <div id="items"
                                                     style="position: relative; width: 200px; margin-left: 30px; display: none">
                                                    <input id="id" type="text" name="productType" required
                                                           data-msg="请输入产品编号" placeholder="请输入产品编号"
                                                           class="input-material" autocomplete="off"
                                                           style="width: 200px;display: none;">
                                                    <select class="custom-select" id="brands" placeholder="请输入品牌名称"
                                                            style="display: none; width: 200px">
                                                        <option value="劲特">劲特</option>
                                                        <option value="风来雅">风来雅</option>
                                                        <option value="钻石">钻石</option>
                                                        <option value="创正园">创正园</option>
                                                        <option value="可丰">可丰</option>
                                                    </select>

                                                    <select class="custom-select" id="sizes" placeholder="请输入产品尺寸"
                                                            style="display: none; width: 200px">
                                                        <option value="12寸">12寸</option>
                                                        <option value="14寸">14寸</option>
                                                        <option value="16寸">16寸</option>
                                                        <option value="18寸">18寸</option>
                                                        <option value="20寸">20寸</option>
                                                    </select>

                                                    <select class="custom-select" id="types" placeholder="请输入产品型号"
                                                            style="display: none; width: 200px">
                                                        <option value="PD-78JU">PD-78JU</option>
                                                        <option value="PD-88HK">PD-88HK</option>
                                                        <option value="PD-89NB">PD-89NB</option>
                                                        <option value="PD-56UH">PD-56UH</option>
                                                    </select>

                                                    <select class="custom-select" id="colors" placeholder="请输入产品颜色"
                                                            style="display: none; width: 200px">
                                                        <option value="白色">白色</option>
                                                        <option value="金色">金色</option>
                                                        <option value="紫色">紫色</option>
                                                        <option value="黑色">黑色</option>
                                                        <option value="绿色">绿色</option>
                                                    </select>
                                                </div>
                                            </td>
                                            <td>
                                                <button id="dataQuery" type="button" class="btn btn-primary"
                                                        style="width: 90px; margin-left: 50px;">查询
                                                </button>
                                            </td>
                                        </tr>
                                    </table>

                                    <br/><br/>
                                    <div id="tableHolder" class="fadeInLeft"
                                         style="position: relative; display: none; margin: 0px 0px 0px 0px;">
                                        <table class="table" id="table">
                                            <thead>
                                            <tr>
                                                <th>编号</th>
                                                <th>型号</th>
                                                <th>品牌</th>
                                                <th>尺寸</th>
                                                <th>颜色</th>
                                                <th>叶片</th>
                                                <th>电机</th>
                                                <th>库存</th>
                                                <th>预售价格</th>
                                            </tr>
                                            </thead>
                                            <tbody id="tableBody">
                                            <tr id="template">
                                                <td id="code"></td>
                                                <td id="type"></td>
                                                <td id="brand"></td>
                                                <td id="size"></td>
                                                <td id="color"></td>
                                                <td id="blade"></td>
                                                <td id="motor"></td>
                                                <td id="stock"></td>
                                                <td id="price"></td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                                <div id="detailsContent" style="display: none">
                                    <h5>︎<a style="color: #007bff;">↯</a>楼顶扇进出库明细</h5><br/>
                                    <table>
                                        <tr>
                                            <td style="width: 250px;">
                                                <input type="text" id="beginDate" style="border-color: #796AEE;"
                                                       placeholder="请输入起始日期"
                                                       data-language="en" value=""
                                                       class="input-material datepicker-here"/>
                                            </td>
                                            <td style="width: 250px;">
                                                <input type="text" id="endDate" style="margin-left:40px;border-color: #796AEE;"
                                                       placeholder="请输入终止日期"
                                                       data-language="en"
                                                       class="input-material datepicker-here"/>
                                            </td>
                                            <td>
                                                <button id="detailsQuery" type="button" class="btn btn-primary"
                                                        style="width: 90px; margin-left: 80px;">查询
                                                </button>
                                            </td>
                                        </tr>
                                    </table>
                                    <div id="detailsHolder"
                                         style="position: relative; top:40px;display:none; width:696px; margin: 0px 0px 0px 0px;">
                                        <table class="table" id="detailsTable">
                                            <thead>
                                            <tr>
                                                <th>进出库单号</th>
                                                <th>产品编号</th>
                                                <th>进出数量</th>
                                                <th>是否带有风杯</th>
                                                <th>是否带有中环</th>
                                                <th>是否带调速器</th>
                                                <th>操作柜员</th>
                                                <th>日期</th>
                                                <th>时间</th>
                                            </tr>
                                            </thead>
                                            <tbody id="detailsBody">
                                            <tr id="detailsPattern">
                                                <td id="series"></td>
                                                <td id="productId"></td>
                                                <td id="number"></td>
                                                <td id="cup"></td>
                                                <td id="circle"></td>
                                                <td id="switch"></td>
                                                <td id="operator"></td>
                                                <td id="date"></td>
                                                <td id="time"></td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                            </div>
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
<script src="${pageContext.request.contextPath}/js/homepage.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-editable-select.js"></script>
<script src="${pageContext.request.contextPath}/js/growl-notification.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.freezeHeader.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.basicTable.min.js"></script>
<script src="${pageContext.request.contextPath}/js/chosen.jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/datepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/js/i18n/datepicker.en.js"></script>
<script type="text/javascript">
    var priorityType="1";
    var userInfoQueryX1 = {
        "userNumber": <%=userId%>,
        "userPriority": 1
    };
    var userInfoQueryInput = {"userInfoQueryX1": userInfoQueryX1};
    $.ajax({
        type: "POST",
        url: "http://3xsw4k.natappfree.cc/pas2/user/query",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(userInfoQueryInput),
        headers: {'Content-Type': 'application/json'},
        success: function (data) {
            console.log(data);
            if (data.userInfoQueryZ1 != null) {
                var userInfo = data.userInfoQueryZ1;
                priorityType= userInfo.userPriority;
            }
        },
        error: function (e) {
            console.log('ajax请求异常，异常信息如下：', e);
        }
    });
    function query() {
        $("#query").attr("readonly", "true");
        if (!$('#floor').is(':hidden')) {
            document.getElementById("floor").style.display = 'none';
        }
        if ($('#registerContent').css("display")!='none') {
            document.getElementById("registerContent").style.display = 'none';
        }
        if ($('#infoContent').css("display")!='none') {
            document.getElementById("infoContent").style.display = 'none';
        }
        if ($('#detailsContent').css("display")!='none') {
            document.getElementById("detailsContent").style.display = 'none';
        }
        document.getElementById("queryContent").style.display = 'inline';
        $('.chosen-select').chosen();
        $('.chosen-select-deselect').chosen({allow_single_deselect: true});
    }

    function info() {
        $("#info").attr("readonly", "true");
        if (!$('#floor').is(':hidden')) {
            document.getElementById("floor").style.display = 'none';
        }
        if ($('#registerContent').css("display")!='none') {
            document.getElementById("registerContent").style.display = 'none';
        }
        if ($('#queryContent').css("display")!='none') {
            document.getElementById("queryContent").style.display = 'none';
        }
        if ($('#detailsContent').css("display")!='none') {
            document.getElementById("detailsContent").style.display = 'none';
        }
        document.getElementById("infoContent").style.display = 'inline';
        $('#brands').editableSelect({
            effects: 'slide'
        });
        $('#sizes').editableSelect({
            effects: 'slide'
        });
        $('#types').editableSelect({
            effects: 'slide'
        });
        $('#colors').editableSelect({
            effects: 'slide'
        });
    }

    function register() {
        $("#register").attr("readonly", "true");
        if (!$('#floor').is(':hidden')) {
            document.getElementById("floor").style.display = 'none';
        }
        if ($('#queryContent').css("display")!='none') {
            document.getElementById("queryContent").style.display = 'none';
        }
        if ($('#infoContent').css("display")!='none') {
            document.getElementById("infoContent").style.display = 'none';
        }
        if ($('#detailsContent').css("display")!='none') {
            document.getElementById("detailsContent").style.display = 'none';
        }
        document.getElementById("registerContent").style.display = 'inline';
        $('#productsName').editableSelect({
            effects: 'slide'
        });
        $('#productsSize').editableSelect({
            effects: 'slide'
        });
        $('#productsBrand').editableSelect({
            effects: 'slide'
        });
        $('#productsColor').editableSelect({
            effects: 'slide'
        });
        $('#productsMotor').editableSelect({
            effects: 'slide'
        });
        $('#productsBlade').editableSelect({
            effects: 'slide'
        });
    }

    function details() {
        $("#details").attr("readonly", "true");
        if (!$('#floor').is(':hidden')) {
            document.getElementById("floor").style.display = 'none';
        }
        document.getElementById("queryContent").style.display = 'none';
        document.getElementById("infoContent").style.display = 'none';
        document.getElementById("registerContent").style.display = 'none';
        document.getElementById("detailsContent").style.display = 'inline';

    }

    $(function () {
        var types = new Array();
        var brands = new Array();
        var sizes = new Array();
        var colors = new Array();
        var blades = new Array();
        var motors = new Array();
        var row = $("#resultRow").clone();
        document.getElementById("resultRow").style.display = "none";
        var flagCondition = false;
        $('#queryCondition').change(function () {
            $("#resultBody tr:gt(0)").remove();
            $("#storageQuery").attr("disabled", false);
            document.getElementById("resultHolder").style.display = "none";
            types=[];
            brands=[];
            sizes=[];
            colors=[];
            blades=[];
            motors=[];
            if ($(this).find("option:selected").text() == "") {
                $("#queryCondition").removeClass("form-control is-valid");
                $("#queryCondition").addClass("form-control is-invalid");
                flagCondition = false;
            } else {
                $("#queryCondition").removeClass("form-control is-invalid");
                $("#queryCondition").addClass("form-control is-valid");
                flagCondition = true;
            }
        });

        function getOptions() {
            var animationOptions = {
                open: "slide-in",
                close: "slide-out"
            };
            return options = {
                position: "top-center",
                closeWith: ['click'],
                animation: animationOptions,
                showButtons: false,
                showProgress: false
            };
        }

        $('#storageQuery').click(function () {
            $("#storageQuery").attr("disabled", true);
            if (flagCondition) {
                $('#queryCondition').find("option:selected").each(function () {
                    switch ($(this).parent().attr("label")) {
                        case "产品型号": {
                            types[types.length] = $(this).text();
                            break;
                        }
                        case "品牌名称": {
                            brands[brands.length] = $(this).text();
                            break;
                        }
                        case "产品尺寸": {
                            sizes[sizes.length] = $(this).text();
                            break;
                        }
                        case "产品颜色": {
                            colors[colors.length] = $(this).text();
                            break;
                        }
                        case "叶片规格": {
                            blades[blades.length] = $(this).text();
                            break;
                        }
                        case "电机规格": {
                            motors[motors.length] = $(this).text();
                            break;
                        }
                        default: {

                        }
                    }
                });
                var productsStorageX1 = {
                    "productCode": "BS",
                    "productTypes": types,
                    "productBrands": brands,
                    "productSizes": sizes,
                    "productColors": colors,
                    "productBlades": blades,
                    "productMotors": motors,
                };
                var productsStorageInput = {"productsStorageX1": productsStorageX1};
                $.ajax({
                    type: "POST",
                    url: "http://localhost:8080/pas2/product/stock",
                    dataType: "json",
                    contentType: "application/json",
                    data: JSON.stringify(productsStorageInput),
                    headers: {'Content-Type': 'application/json'},
                    success: function (data) {
                        console.log(data);
                        var options = getOptions();
                        var result = data.productsStorageZ1;
                        document.getElementById("resultHolder").style.display = "inline";
                        if (result != null) {
                            var rowc = row.clone();
                            rowc.find("#result").text(result.result);
                            rowc.appendTo("#resultTable");
                            $("#resultTable").basictable();
                            $("#allStocks").html(result.gross);
                        } else {
                            var error = data.Error
                            options.title = "查询出错了:( "
                            options.description = "错误信息:"+error.message;
                            options.closeTimeout = 3000;
                            options.type = "error";
                            GrowlNotification.notify(options);
                        }
                    },
                    error: function (e) {
                        console.log('ajax请求异常，异常信息如下：', e);
                    }
                });
            } else {
                $("#queryCondition").addClass("form-control is-invalid");
            }
        });
    });

    $(function () {
        var flagConditions = false;
        var flagId = false;
        var flagBrands = false;
        var flagSizes = false;
        var flagTypes = false;
        var flagColors = false;
        var row = $("#template").clone();
        var conditions, id, brands, sizes, types, colors;
        $("#conditions").change(function () {
            $("#dataQuery").attr("disabled", false);
            conditions = $("#conditions").val();
            if (conditions == "default") {
                $("#conditions").removeClass("form-control is-valid");
                $("#conditions").addClass("form-control is-invalid");
                flagConditions = false;
            } else {
                $("#conditions").removeClass("form-control is-invalid");
                $("#conditions").addClass("form-control is-valid");
                flagConditions = true;
            }
            switch (conditions) {
                case "default" : {
                    $("#tableBody tr:gt(0)").empty();
                    document.getElementById("items").style.display = 'none';
                    document.getElementById("tableHolder").style.display = "none";
                    break;
                }
                case "id" : {
                    $("#tableBody tr:gt(0)").empty();
                    document.getElementById("items").style.display = 'inline';
                    document.getElementById("tableHolder").style.display = "none";
                    document.getElementById("sizes").style.display = 'none';
                    document.getElementById("types").style.display = 'none';
                    document.getElementById("colors").style.display = 'none';
                    document.getElementById("brands").style.display = 'none';
                    document.getElementById("id").style.display = 'inline';
                    flagBrands = false;
                    $("#id").val("");
                    $("#id").removeClass("form-control is-valid");
                    $("#id").removeClass("form-control is-invalid");
                    break;
                }
                case "brands" : {
                    $("#tableBody tr:gt(0)").empty();
                    document.getElementById("items").style.display = 'inline';
                    document.getElementById("tableHolder").style.display = "none";
                    document.getElementById("sizes").style.display = 'none';
                    document.getElementById("types").style.display = 'none';
                    document.getElementById("colors").style.display = 'none';
                    document.getElementById("id").style.display = 'none';
                    document.getElementById("brands").style.display = 'inline';
                    flagBrands = false;
                    $("#brands").val("");
                    $("#brands").removeClass("form-control is-valid");
                    $("#brands").removeClass("form-control is-invalid");
                    break;
                }
                case "sizes": {
                    $("#tableBody tr:gt(0)").empty();
                    document.getElementById("items").style.display = 'inline';
                    document.getElementById("tableHolder").style.display = "none";
                    document.getElementById("brands").style.display = 'none';
                    document.getElementById("types").style.display = 'none';
                    document.getElementById("colors").style.display = 'none';
                    document.getElementById("id").style.display = 'none';
                    document.getElementById("sizes").style.display = 'inline';
                    flagSizes = false;
                    $("#sizes").val("");
                    $("#sizes").removeClass("form-control is-valid");
                    $("#sizes").removeClass("form-control is-invalid");
                    break;
                }
                case "types": {
                    $("#tableBody tr:gt(0)").empty();
                    document.getElementById("items").style.display = 'inline';
                    document.getElementById("tableHolder").style.display = "none";
                    document.getElementById("sizes").style.display = 'none';
                    document.getElementById("brands").style.display = 'none';
                    document.getElementById("colors").style.display = 'none';
                    document.getElementById("id").style.display = 'none';
                    document.getElementById("types").style.display = 'inline';
                    flagTypes = false;
                    $("#types").val("");
                    $("#types").removeClass("form-control is-valid");
                    $("#types").removeClass("form-control is-invalid");
                    break;
                }
                case "colors": {
                    $("#tableBody tr:gt(0)").empty();
                    document.getElementById("items").style.display = 'inline';
                    document.getElementById("tableHolder").style.display = "none";
                    document.getElementById("sizes").style.display = 'none';
                    document.getElementById("brands").style.display = 'none';
                    document.getElementById("types").style.display = 'none';
                    document.getElementById("id").style.display = 'none';
                    document.getElementById("colors").style.display = 'inline';
                    flagTypes = false;
                    $("#colors").val("");
                    $("#colors").removeClass("form-control is-valid");
                    $("#colors").removeClass("form-control is-invalid");
                    break;
                }
                case "all" : {
                    $("#tableBody tr:gt(0)").empty();
                    document.getElementById("items").style.display = 'none';
                    document.getElementById("tableHolder").style.display = "none";
                    break;
                }
                default : {

                }
            }
        });

        $("#id").change(function () {
            $("#dataQuery").attr("disabled", false);
            $("#tableBody tr:gt(0)").empty();
            document.getElementById("tableHolder").style.display = "none";
            id = $("#id").val();
            if (id == "") {
                $("#id").removeClass("form-control is-valid");
                $("#id").addClass("form-control is-invalid");
                flagId = false;
            } else {
                $("#id").removeClass("form-control is-invalid");
                $("#id").addClass("form-control is-valid");
                flagId = true;
            }
        });

        $('#brands')
            .editableSelect()
            .on('select.editable-select', function () {
                brands = $("#brands").val();
                if (brands == "") {
                    $("#brands").removeClass("form-control is-valid");
                    $("#brands").addClass("form-control is-invalid");
                    flagBrands = false;
                } else {
                    $("#brands").removeClass("form-control is-invalid");
                    $("#brands").addClass("form-control is-valid");
                    flagBrands = true;
                }
            });

        $("#brands").change(function () {
            $("#dataQuery").attr("disabled", false);
            $("#tableBody tr:gt(0)").empty();
            document.getElementById("tableHolder").style.display = "none";
            brands = $("#brands").val();
            if (brands == "") {
                $("#brands").removeClass("form-control is-valid");
                $("#brands").addClass("form-control is-invalid");
                flagBrands = false;
            } else {
                $("#brands").removeClass("form-control is-invalid");
                $("#brands").addClass("form-control is-valid");
                flagBrands = true;
            }
        });

        $('#sizes')
            .editableSelect()
            .on('select.editable-select', function () {
                sizes = $("#sizes").val();
                if (sizes == "") {
                    $("#sizes").removeClass("form-control is-valid");
                    $("#sizes").addClass("form-control is-invalid");
                    flagSizes = false;
                } else {
                    $("#sizes").removeClass("form-control is-invalid");
                    $("#sizes").addClass("form-control is-valid");
                    flagSizes = true;
                }
            });

        $("#sizes").change(function () {
            $("#dataQuery").attr("disabled", false);
            $("#tableBody tr:gt(0)").empty();
            document.getElementById("tableHolder").style.display = "none";
            sizes = $("#sizes").val()
            if (sizes == "") {
                $("#sizes").removeClass("form-control is-valid");
                $("#sizes").addClass("form-control is-invalid");
                flagSizes = false;
            } else {
                $("#sizes").removeClass("form-control is-invalid");
                $("#sizes").addClass("form-control is-valid");
                flagSizes = true;
            }
        });

        $('#types')
            .editableSelect()
            .on('select.editable-select', function (e, li) {
                types = $("#types").val();
                if (types == "") {
                    $("#types").removeClass("form-control is-valid");
                    $("#types").addClass("form-control is-invalid");
                    flagTypes = false;
                } else {
                    $("#types").removeClass("form-control is-invalid");
                    $("#types").addClass("form-control is-valid");
                    flagTypes = true;
                }
            });

        $("#types").change(function () {
            $("#dataQuery").attr("disabled", false);
            $("#tableBody tr:gt(0)").empty();
            document.getElementById("tableHolder").style.display = "none";
            types = $("#types").val();
            if (types == "") {
                $("#types").removeClass("form-control is-valid");
                $("#types").addClass("form-control is-invalid");
                flagTypes = false;
            } else {
                $("#types").removeClass("form-control is-invalid");
                $("#types").addClass("form-control is-valid");
                flagTypes = true;
            }
        });

        $('#colors')
            .editableSelect()
            .on('select.editable-select', function () {
                colors = $("#colors").val();
                if (colors == "") {
                    $("#colors").removeClass("form-control is-valid");
                    $("#colors").addClass("form-control is-invalid");
                    flagColors = false;
                } else {
                    $("#colors").removeClass("form-control is-invalid");
                    $("#colors").addClass("form-control is-valid");
                    flagColors = true;
                }
            });

        $("#colors").change(function () {
            $("#dataQuery").attr("disabled", false);
            $("#tableBody tr:gt(0)").empty();
            document.getElementById("tableHolder").style.display = "none";
            colors = $("#colors").val();
            if (colors == "") {
                $("#colors").removeClass("form-control is-valid");
                $("#colors").addClass("form-control is-invalid");
                flagColors = false;
            } else {
                $("#colors").removeClass("form-control is-invalid");
                $("#colors").addClass("form-control is-valid");
                flagColors = true;
            }
        });

        function getOptions() {
            var animationOptions = {
                open: "slide-in",
                close: "slide-out"
            };
            return options = {
                position: "top-center",
                closeWith: ['click'],
                animation: animationOptions,
                showButtons: false,
                showProgress: false
            };
        }

        function query(condition, param) {
            var productsInfoX1 = {
                "productCode": "BS",
                "queryCondition": condition,
                "queryParam": param
            };
            var productsInfoInput = {"productsInfoX1": productsInfoX1};
            $.ajax({
                type: "POST",
                url: "http://localhost:8080/pas2/product/info",
                dataType: "json",
                contentType: "application/json",
                data: JSON.stringify(productsInfoInput),
                headers: {'Content-Type': 'application/json'},
                success: function (data) {
                    console.log(data);
                    var options = getOptions();
                    var infos = data.productsInfoZ1s;
                    if (infos[0] != null) {
                        document.getElementById("tableHolder").style.display = "inline";
                        $.each(infos, function (i, n) {
                            var rowc = row.clone();
                            rowc.find("#code").text(n.productModelId);
                            rowc.find("#type").text(n.productType);
                            rowc.find("#brand").text(n.productBrand);
                            rowc.find("#size").text(n.productSize);
                            rowc.find("#color").text(n.productColor);
                            rowc.find("#blade").text(n.productBlade);
                            rowc.find("#motor").text(n.productMotor);
                            rowc.find("#stock").text(n.productStock);
                            rowc.find("#price").text(n.sellingPrice);
                            rowc.appendTo("#table");
                        });
                        $("#table").freezeHeader();
                        $("#table").basictable();
                        document.getElementById("template").style.display = "none";
                    } else {
                        options.description = "空空如也 :) 满足条件的数据似乎没有。。";
                        options.closeTimeout = 3000;
                        options.type = "info"
                        GrowlNotification.notify(options);
                    }

                },
                error: function (e) {
                    console.log('ajax请求异常，异常信息如下：', e);
                }
            });


        }

        $("#dataQuery").click(function () {
            $("#dataQuery").attr("disabled", true);
            if (flagConditions) {
                switch (conditions) {
                    case "id": {
                        if (!flagId) {
                            $("#id").addClass("form-control is-invalid");
                        }
                        query(conditions, id);
                        break;
                    }
                    case "brands": {
                        if (!flagBrands) {
                            $("#brands").addClass("form-control is-invalid");
                        }
                        query(conditions, brands);
                        break;
                    }
                    case "sizes": {
                        if (!flagSizes) {
                            $("#sizes").addClass("form-control is-invalid");
                        }
                        query(conditions, sizes);
                        break;
                    }
                    case "types": {
                        if (!flagTypes) {
                            $("#types").addClass("form-control is-invalid");
                        }
                        query(conditions, types);
                        break;
                    }
                    case "colors": {
                        if (!flagColors) {
                            $("#colors").addClass("form-control is-invalid");
                        }
                        query(conditions, colors);
                        break;
                    }
                    case "all": {
                        query(conditions, "");
                        break;
                    }
                    default : {

                    }
                }
            } else {
                $("#conditions").addClass("form-control is-invalid");
            }
        });

    });

    $(function () {
        var flagType = false;
        var flagName = false;
        var flagBrand = false;
        var flagSize = false;
        var flagColor = false;
        var flagBlade = false;
        var flagMotor = false;
        var flagPrice = false;
        var type, name, brand, size, color, blade, motor, price;

        $("#productsType").change(function () {
            type = $("#productsType").val();
            if (type == "") {
                $("#productsType").removeClass("form-control is-valid");
                $("#productsType").addClass("form-control is-invalid");
                flagType = false;
            } else {
                $("#productsType").removeClass("form-control is-invalid");
                $("#productsType").addClass("form-control is-valid");
                flagType = true;
            }
        });

        $('#productsName')
            .editableSelect()
            .on('select.editable-select', function () {
                name = $("#productsName").val();
                if (name == "") {
                    $("#productsName").removeClass("form-control is-valid");
                    $("#productsName").addClass("form-control is-invalid");
                    flagName = false;
                } else {
                    $("#productsName").removeClass("form-control is-invalid");
                    $("#productsName").addClass("form-control is-valid");
                    flagName = true;
                }
            });

        $("#productsName").change(function () {
            name = $("#productsName").val();
            if (name == "") {
                $("#productsName").removeClass("form-control is-valid");
                $("#productsName").addClass("form-control is-invalid");
                flagName = false;
            } else {
                $("#productsName").removeClass("form-control is-invalid");
                $("#productsName").addClass("form-control is-valid");
                flagName = true;
            }
        });

        $('#productsBrand')
            .editableSelect()
            .on('select.editable-select', function () {
                brand = $("#productsBrand").val();
                if (brand == "") {
                    $("#productsBrand").removeClass("form-control is-valid");
                    $("#productsBrand").addClass("form-control is-invalid");
                    flagBrand = false;
                } else {
                    $("#productsBrand").removeClass("form-control is-invalid");
                    $("#productsBrand").addClass("form-control is-valid");
                    flagBrand = true;
                }
            });

        $("#productsBrand").change(function () {
            brand = $("#productsBrand").val();
            if (brand == "") {
                $("#productsBrand").removeClass("form-control is-valid");
                $("#productsBrand").addClass("form-control is-invalid");
                flagBrand = false;
            } else {
                $("#productsBrand").removeClass("form-control is-invalid");
                $("#productsBrand").addClass("form-control is-valid");
                flagBrand = true;
            }
        });

        $('#productsSize')
            .editableSelect()
            .on('select.editable-select', function () {
                size = $("#productsSize").val();
                if (size == "") {
                    $("#productsSize").removeClass("form-control is-valid");
                    $("#productsSize").addClass("form-control is-invalid");
                    flagSize = false;
                } else {
                    $("#productsSize").removeClass("form-control is-invalid");
                    $("#productsSize").addClass("form-control is-valid");
                    flagSize = true;
                }
            });

        $("#productsSize").change(function () {
            size = $("#productsSize").val();
            if (size == "") {
                $("#productsSize").removeClass("form-control is-valid");
                $("#productsSize").addClass("form-control is-invalid");
                flagSize = false;
            } else {
                $("#productsSize").removeClass("form-control is-invalid");
                $("#productsSize").addClass("form-control is-valid");
                flagSize = true;
            }
        });

        $('#productsColor')
            .editableSelect()
            .on('select.editable-select', function () {
                color = $("#productsColor").val();
                if (color == "") {
                    $("#productsColor").removeClass("form-control is-valid");
                    $("#productsColor").addClass("form-control is-invalid");
                    flagColor = false;
                } else {
                    $("#productsColor").removeClass("form-control is-invalid");
                    $("#productsColor").addClass("form-control is-valid");
                    flagColor = true;
                }
            });

        $("#productsColor").change(function () {
            color = $("#productsColor").val();
            if (color == "") {
                $("#productsColor").removeClass("form-control is-valid");
                $("#productsColor").addClass("form-control is-invalid");
                flagColor = false;
            } else {
                $("#productsColor").removeClass("form-control is-invalid");
                $("#productsColor").addClass("form-control is-valid");
                flagColor = true;
            }
        });

        $('#productsBlade')
            .editableSelect()
            .on('select.editable-select', function () {
                blade = $("#productsBlade").val();
                if (blade == "") {
                    $("#productsBlade").removeClass("form-control is-valid");
                    $("#productsBlade").addClass("form-control is-invalid");
                    flagBlade = false;
                } else {
                    $("#productsBlade").removeClass("form-control is-invalid");
                    $("#productsBlade").addClass("form-control is-valid");
                    flagBlade = true;
                }
            });

        $("#productsBlade").change(function () {
            blade = $("#productsBlade").val();
            if (blade == "") {
                $("#productsBlade").removeClass("form-control is-valid");
                $("#productsBlade").addClass("form-control is-invalid");
                flagBlade = false;
            } else {
                $("#productsBlade").removeClass("form-control is-invalid");
                $("#productsBlade").addClass("form-control is-valid");
                flagBlade = true;
            }
        });

        $('#productsMotor')
            .editableSelect()
            .on('select.editable-select', function () {
                motor = $("#productsMotor").val();
                if (motor == "") {
                    $("#productsMotor").removeClass("form-control is-valid");
                    $("#productsMotor").addClass("form-control is-invalid");
                    flagMotor = false;
                } else {
                    $("#productsMotor").removeClass("form-control is-invalid");
                    $("#productsMotor").addClass("form-control is-valid");
                    flagMotor = true;
                }
            });

        $("#productsMotor").change(function () {
            motor = $("#productsMotor").val();
            if (motor == "") {
                $("#productsMotor").removeClass("form-control is-valid");
                $("#productsMotor").addClass("form-control is-invalid");
                flagMotor = false;
            } else {
                $("#productsMotor").removeClass("form-control is-invalid");
                $("#productsMotor").addClass("form-control is-valid");
                flagMotor = true;
            }
        });

        $("#productsPrice").change(function () {
            price = $("#productsPrice").val();
            if (price == "") {
                $("#productsPrice").removeClass("form-control is-valid");
                $("#productsPrice").addClass("form-control is-invalid");
                flagPrice = false;
            } else {
                $("#productsPrice").removeClass("form-control is-invalid");
                $("#productsPrice").addClass("form-control is-valid");
                flagPrice = true;
            }
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
                closeTimeout: 2000,
                showButtons: false,
                showProgress: false
            };
        }

        $("#submit").on('click', function () {
            var options = getOptions();
            if (flagType && flagName && flagBrand && flagSize && flagColor && flagBlade && flagMotor && flagPrice) {
                var productsRegisterX1 = {
                    "userId": <%=userId%>,
                    "productType": type,
                    "productName": name,
                    "productCode": "BS",
                    "productBrand": brand,
                    "productSize": size,
                    "productColor": color,
                    "productBlade": blade,
                    "productMotor": motor,
                    "productStock": 0,
                    "productPrice": price
                };
                var productsRegisterInput = {"productsRegisterX1": productsRegisterX1};
                $.ajax({
                    type: "POST",
                    url: "http://localhost:8080/pas2/product/register",
                    dataType: "json",
                    contentType: "application/json",
                    data: JSON.stringify(productsRegisterInput),
                    headers: {'Content-Type': 'application/json'},
                    success: function (data) {
                        console.log(data);
                        if (data.productsRegisterZ1 != null) {
                            var productId = data.productsRegisterZ1.productModelId;
                            options.title = '信息录入成功啦 :)';
                            options.description = '产品编号：' + productId;
                            options.type = 'success';
                            options.closeTimeout = 2000;
                            GrowlNotification.notify(options);
                            window.setTimeout("registerForm.submit();", 2000);
                        } else {
                            var error = data.Error;
                            options.title = '系统出错 :(';
                            options.description = '错误信息：' + error.message;
                            options.type = 'error';
                            options.closeTimeout = 3000;
                            GrowlNotification.notify(options);
                        }
                    },
                    error: function (e) {
                        console.log('ajax请求异常，异常信息如下：', e);
                    }
                });
            } else {
                if (!flagType) {
                    $("#productsType").addClass("form-control is-invalid");
                }
                if (!flagName) {
                    $("#productsName").addClass("form-control is-invalid");
                }
                if (!flagBrand) {
                    $("#productsBrand").addClass("form-control is-invalid");
                }
                if (!flagSize) {
                    $("#productsSize").addClass("form-control is-invalid");
                }
                if (!flagColor) {
                    $("#productsColor").addClass("form-control is-invalid");
                }
                if (!flagBlade) {
                    $("#productsBlade").addClass("form-control is-invalid");
                }
                if (!flagMotor) {
                    $("#productsMotor").addClass("form-control is-invalid");
                }
                if (!flagPrice) {
                    $("#productsPrice").addClass("form-control is-invalid");
                }
            }

        });

    });

    $(function () {
        $("#yielding").click(function () {
            window.location.href='yield.jsp?userId=<%=userId%>&from=<%=type%>';
        });
        $("#delivery").click(function () {
            window.location.href='deliver.jsp?userId=<%=userId%>&from=<%=type%>';
        });
    });

    $(function() {
        var beginDate,endDate;
        var flagStartDate = true;
        var flagEndDate = true;
        var myDate = new Date();
        var date = myDate.toLocaleDateString();//获取当前日期
        var row = $("#detailsPattern").clone();
        var d = date.split("/");
        var year = parseInt(d[2]);
        year = year - 2000;
        d[2]=year.toString();
        if(parseInt(d[0]) < 10){
            d[0] = "0"+d[0];
        }
        if(parseInt(d[1]) < 10){
            d[1] = "0"+d[1];
        }
        date = d[0]+"/"+ d[1] + "/" + year;
        $("#beginDate").val(date);
        $("#endDate").val(date);
        beginDate = $("#beginDate").val();
        endDate = $("#endDate").val();
        $("#beginDate").blur(function () {
            $("#detailsQuery").attr("disabled", false);
            $("#detailsBody tr:gt(0)").empty();
            document.getElementById("detailsHolder").style.display = "none";
            beginDate = $("#beginDate").val();
            if (beginDate == "") {
                $("#beginDate").removeClass("form-control is-valid");
                $("#beginDate").addClass("form-control is-invalid");
                flagStartDate = false;
            } else {
                $("#beginDate").removeClass("form-control is-invalid");
                $("#beginDate").addClass("form-control is-valid");
                flagStartDate = true;
            }
        });

        $("#endDate").blur(function () {
            $("#detailsQuery").attr("disabled", false);
            $("#detailsBody tr:gt(0)").empty();
            document.getElementById("detailsHolder").style.display = "none";
            $("#dataQuery").attr("disabled", false);
            $("#tableBody tr:gt(0)").empty();
            document.getElementById("detailsHolder").style.display = "none";
            endDate = $("#endDate").val();
            if (endDate == "") {
                $("#endDate").removeClass("form-control is-valid");
                $("#endDate").addClass("form-control is-invalid");
                flagEndDate = false;
            } else {
                $("#endDate").removeClass("form-control is-invalid");
                $("#endDate").addClass("form-control is-valid");
                flagEndDate = true;
            }
        });

        $("#detailsQuery").on('click', function () {
            $("#detailsQuery").attr("disabled", true);
            if (flagStartDate && flagEndDate){
                $("#beginDate").addClass("form-control is-valid");
                $("#endDate").addClass("form-control is-valid");
                var b = beginDate.split("/");
                var e = endDate.split("/");
                var startDate = "20"+b[2]+b[0]+b[1];
                var endingDate = "20"+e[2]+e[0]+e[1];
                var options = getOptions();
                var productsDetailsX1 = {
                    "productCode": "BS",
                    "startDate": startDate,
                    "endDate": endingDate
                };
                var productsDetailsInput = {"productsDetailsX1": productsDetailsX1};
                $.ajax({
                    type: "POST",
                    url: "http://localhost:8080/pas2/detail/query",
                    dataType: "json",
                    contentType: "application/json",
                    data: JSON.stringify(productsDetailsInput),
                    headers: {'Content-Type': 'application/json'},
                    success: function (data) {
                        console.log(data);
                        var details = data.productsDetailsZ1List;
                        if (data.Error == null) {
                            if(details[0] !=null ){
                                document.getElementById("detailsHolder").style.display = "inline";
                                $.each(details, function (i, n) {
                                    var rowc = row.clone();
                                    rowc.find("#series").text(n.operationSeries.substring(0,10));
                                    rowc.find("#productId").text(n.productId);
                                    rowc.find("#number").text((n.productIncrement >= 0)?"+"+n.productIncrement:n.productIncrement);
                                    rowc.find("#cup").text((n.withCups == "Y")?"是":"否");
                                    rowc.find("#circle").text((n.withSwitches == "Y")?"是":"否");
                                    rowc.find("#switch").text((n.withCircles == "Y"?"是":"否"));
                                    rowc.find("#operator").text(n.operationName);
                                    rowc.find("#date").text(n.operationDate);
                                    rowc.find("#time").text(n.operationTime.substring(0,2) + ":" + n.operationTime.substring(2,4) + ":" + n.operationTime.substring(4,6));
                                    rowc.appendTo("#detailsTable");
                                });
                                $("#detailsTable").freezeHeader();
                                $("#detailsTable").basictable();
                                document.getElementById("detailsPattern").style.display = "none";
                            }else {
                                options.description = "空空如也 :) 满足条件的数据似乎没有。。";
                                options.closeTimeout = 3000;
                                options.type = "info";
                                GrowlNotification.notify(options);
                            }
                        } else {
                            options.title = "查询出错:("
                            options.description = "错误信息："+ data.Error.message;
                            options.closeTimeout = 3000;
                            options.type = "warning";
                            GrowlNotification.notify(options);
                        }
                    },
                    error: function (e) {
                        console.log('ajax请求异常，异常信息如下：', e);
                    }
                });
            }else{
                if(!flagStartDate){
                    $("#beginDate").addClass("form-control is-invalid");
                }
                if(!flagEndDate){
                    $("#endDate").addClass("form-control is-invalid");
                }
            }

            function getOptions() {
                var animationOptions = {
                    open: "slide-in",
                    close: "slide-out"
                };
                return options = {
                    image: {
                        visible: false
                    },
                    position: "top-center",
                    closeWith: ['click'],
                    animation: animationOptions,
                    closeTimeout: 3000,
                    showButtons: false,
                    showProgress: true
                };
            }

        });

    });

</script>
</body>
</html>
