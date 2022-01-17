<%@page contentType="text/html; UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//0TD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="utf-8" />
    <meta name="renderer" content="webkit" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black" />
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="format-detection" content="telephone=no" />
    <title>产品入库登记</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" />
    <link href="${pageContext.request.contextPath}/css/light-theme.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/dark-theme.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/colored-theme.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
        /*您可以将下列样式写入自己的样式表中*/
        .childBody{
            content: '';
            width: 100%;
            height: 100%;
            display: block;
            z-index: -1;
            background: url(../img/p_big3.jpg);
            background-size: cover;
            z-index: 1;
            position: absolute;
            top: 0;
            right: 0;
        }

        /*layui 元素样式改写*/
        .layui-btn-sm{line-height: normal; font-size: 12.5px;}
        .layui-table-view .layui-table-body{min-height: 256px;}
        .layui-table-cell .layui-input.layui-unselect{height: 30px; line-height: 30px;}

        /*设置 layui 表格中单元格内容溢出可见样式*/
        .table-overlay .layui-table-view,
        .table-overlay .layui-table-box,
        .table-overlay .layui-table-body{overflow: visible;}
        .table-overlay .layui-table-cell{height: auto; overflow: visible;}

        /*文本对齐方式*/
        .text-center{text-align: center;}
    </style>

</head>
<body class="childBody">
<%
    request.setCharacterEncoding("UTF-8");
    String userId = request.getParameter("userId");
    String from = request.getParameter("from");
%>
<section class="layui-col-md10" style="border-radius: 0.5rem;margin-top: 85px;margin-left: 120px; float: none;">
    <div class="layui-card">
        <div class="layui-card-header" style="font-size: 16px;text-align: center;"><a style="font-size: 18px;color: #009688;" id="genre"></a>产品出库登记表</div>
        <div class="layui-card-body layui-text">
            <div id="toolbar">
                <div>
                    <button type="button" class="layui-btn layui-btn-sm" data-type="addRow" title="添加一行">
                        <i class="layui-icon layui-icon-add-1"></i> 添加一行
                    </button>
                </div>
            </div>
            <div id="tableRes" class="table-overlay">
                <table id="dataTable" lay-filter="dataTable" class="layui-hide"></table>
            </div>
            <div id="action" class="text-center">
                <button type="submit" name="btnSave" class="layui-btn" data-type="save"><i class="layui-icon layui-icon-ok-circle"></i>提交</button>
                <button id="return" name="btnReset" class="layui-btn layui-btn-primary"><a style="text-decoration: none;color:black">返回上一层</a></button>
            </div>
        </div>
    </div>

    <pre id="jsonResult" style="display: none"></pre>

</section>
<!--recommended script position-->
<script src="${pageContext.request.contextPath}/layui/layui.js?v=201805080202" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/growl-notification.min.js"></script>
<script type="text/javascript">
    //准备视图对象
    window.viewObj = {
        tbData: [{
            tempId: new Date().valueOf(),
            userId: <%=userId%>,
            type: '',
            number: '',
            stateOne: 1,
            stateTwo: 0,
            stateThree: 0
        }],
        renderSelectOptions: function(data, settings){
            settings =  settings || {};
            var valueField = settings.valueField || 'value',
                textField = settings.textField || 'text',
                selectedValue = settings.selectedValue || "";
            var html = [];
            for(var i=0, item; i < data.length; i++){
                item = data[i];
                html.push('<option value="');
                html.push(item[valueField]);
                html.push('"');
                if(selectedValue && item[valueField] == selectedValue ){
                    html.push(' selected="selected"');
                }
                html.push('>');
                html.push(item[textField]);
                html.push('</option>');
            }
            return html.join('');
        }
    };

    //layui 模块化引用
    layui.use(['jquery', 'table', 'layer'], function(){
        var $ = layui.$, table = layui.table, form = layui.form, layer = layui.layer;

        //数据表格实例化
        var tbWidth = $("#tableRes").width();
        var layTableId = "layTable";
        var tableIns = table.render({
            elem: '#dataTable',
            id: layTableId,
            data: viewObj.tbData,
            width: tbWidth,
            page: true,
            loading: true,
            even: false, //不开启隔行背景
            cols: [[
                {title: '序号', type: 'numbers'},
                {field: 'type', title: '产品编号', edit: 'text'},
                {field: 'number', title: '产品数量', edit: 'text'},
                {field: 'state', title: '是否带有风杯', event: 'stateOne', templet: function(d){
                        var html = ['<input type="checkbox" name="stateOne" lay-skin="switch" lay-text="是|否"'];
                        html.push(d.stateOne > 0 ? ' checked' : '');
                        html.push('>');
                        return html.join('');
                    }},
                {field: 'state', title: '是否带有调速器', event: 'stateTwo', templet: function(d){
                        var html = ['<input type="checkbox" name="stateTwo" lay-skin="switch" lay-text="是|否"'];
                        html.push(d.stateTwo > 0 ? ' checked' : '');
                        html.push('>');
                        return html.join('');
                    }},
                {field: 'state', title: '是否带有中环', event: 'stateThree', templet: function(d){
                        var html = ['<input type="checkbox" name="stateThree" lay-skin="switch" lay-text="是|否"'];
                        html.push(d.stateThree > 0 ? ' checked' : '');
                        html.push('>');
                        return html.join('');
                    }},
                {field: 'tempId', title: '操作', templet: function(d){
                        return '<a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del" lay-id="'+ d.tempId +'"><i class="layui-icon layui-icon-delete"></i>移除</a>';
                    }}
            ]],
            done: function(res, curr, count){
                viewObj.tbData = res.data;
            }
        });

        //定义事件集合
        var active = {
            addRow: function(){	//添加一行
                var oldData = table.cache[layTableId];
                console.log(oldData);
                var newRow = {tempId: new Date().valueOf(), type: '', number: '', stateOne: 1,stateTwo:0,stateThree:0};
                oldData.push(newRow);
                tableIns.reload({
                    data : oldData
                });
            },
            updateRow: function(obj){
                var oldData = table.cache[layTableId];
                console.log(oldData);
                for(var i=0, row; i < oldData.length; i++){
                    row = oldData[i];
                    if(row.tempId == obj.tempId){
                        $.extend(oldData[i], obj);
                        return;
                    }
                }
                tableIns.reload({
                    data : oldData
                });
            },
            removeEmptyTableCache: function(){
                var oldData = table.cache[layTableId];
                for(var i=0, row; i < oldData.length; i++){
                    row = oldData[i];
                    if(!row || !row.tempId){
                        oldData.splice(i, 1);    //删除一项
                    }
                    continue;
                }
                tableIns.reload({
                    data : oldData
                });
            },
            save: function(){
                var oldData = table.cache[layTableId];
                console.log(oldData);
                for(var i=0, row; i < oldData.length; i++){
                    row = oldData[i]
                    if(!row.type){
                        layer.msg("请检查每一行，注意填写产品编号！", { icon: 5 }); //提示
                        return;
                    }
                    if(row.type.substring(0,2) != "<%=from%>"){
                        switch ("<%=from%>") {
                            case "RF":{
                                layer.msg("请检查每一行，注意填写的是楼顶扇的产品编号！", { icon: 5 }); //提示
                                break;
                            }
                            case "GD":{
                                layer.msg("请检查每一行，注意填写的是趴地扇的产品编号！", { icon: 5 }); //提示
                                break;
                            }
                            case "BS":{
                                layer.msg("请检查每一行，注意填写的是商务扇的产品编号！", { icon: 5 }); //提示
                                break;
                            }
                            default:{
                                layer.msg("请检查每一行，注意填写合法的产品编号", { icon: 5 }); //提示
                                break;
                            }
                        }

                        return;
                    }
                    if(!row.number || isNaN(row.number)){
                        layer.msg("请检查每一行，注意填写产品数量且不可出现除数字外其他字符！", { icon: 5 }); //提示
                        return;
                    }
                }
                document.getElementById("jsonResult").innerHTML = JSON.stringify(table.cache[layTableId], null, 2);	//使用JSON.stringify() 格式化输出JSON字符串
                var request = JSON.stringify(table.cache[layTableId], null, 2);
                var input = JSON.parse(request);
                var options = getOptions();
                var productsDecreaseX1=[];

                for(var i=0;i < input.length;i++){
                    productsDecreaseX1[i] = {
                        "userId": "<%=userId%>",
                        "operationSeries": input[i].tempId,
                        "productId": input[i].type,
                        "number": input[i].number,
                        "withCups": input[i].stateOne,
                        "withSwitches": input[i].stateTwo,
                        "withCircles": input[i].stateThree
                    };
                }
                var productsDecreaseInput = {"productsDecreaseX1List":productsDecreaseX1};
                console.log(productsDecreaseInput);
                $.ajax({
                    type: "POST",
                    url: "http://localhost:8080/pas2/product/decrease",
                    dataType: "json",
                    contentType: "application/json",
                    data: JSON.stringify(productsDecreaseInput),
                    headers: {'Content-Type': 'application/json'},
                    success: function (data) {
                        console.log(data);
                        if(data.Error != null){
                            options.title = '出库失败:(';
                            options.description = '错误信息：' + data.Error.message;
                            //options.image = 'img/success.png';
                            options.image = {
                                visible: true
                            };
                            options.type = 'error';
                            GrowlNotification.notify(options);
                            window.setTimeout("window.location.reload()", 3000);
                        }else {
                            options.title = '没毛病:)';
                            options.description = '出库成功！';
                            options.image = {
                                visible: true
                            };
                            options.type = 'success';
                            GrowlNotification.notify(options);
                            window.setTimeout("window.location.reload()", 3000);
                        }

                    },
                    error: function (e) {
                        console.log('ajax请求异常，异常信息如下：', e);
                    }
                });
            }
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
                closeTimeout: 3000,
                showButtons: false,
                showProgress: true
            };
        }

        //激活事件
        var activeByType = function (type, arg) {
            if(arguments.length === 2){
                active[type] ? active[type].call(this, arg) : '';
            }else{
                active[type] ? active[type].call(this) : '';
            }
        }

        //注册按钮事件
        $('.layui-btn[data-type]').on('click', function () {
            var type = $(this).data('type');
            activeByType(type);
        });


        //监听工具条
        table.on('tool(dataTable)', function (obj) {
            var data = obj.data, event = obj.event, tr = obj.tr; //获得当前行 tr 的DOM对象;
            console.log(data);
            switch(event){
                case "stateOne":
                    var stateVal = tr.find("input[name='stateOne']").prop('checked') ? 1 : 0;
                    $.extend(obj.data, {'stateOne': stateVal})
                    activeByType('updateRow', obj.data);	//更新行记录对象
                    break;
                case "stateTwo":
                    var stateVal = tr.find("input[name='stateTwo']").prop('checked')? 1 : 0;
                    if("<%=from%>" != "RF" && stateVal == 1){
                        layer.msg("请注意非楼顶扇不带有调速！", { icon: 5 }); //提示
                        stateVal = 0;
                    }
                    $.extend(obj.data, {'stateTwo': stateVal})
                    activeByType('updateRow', obj.data);	//更新行记录对象
                    break;
                case "stateThree":
                    var stateVal = tr.find("input[name='stateThree']").prop('checked') ? 1 : 0;
                    $.extend(obj.data, {'stateThree': stateVal})
                    activeByType('updateRow', obj.data);	//更新行记录对象
                    break;
                case "del":
                    layer.confirm('确定删除删除这条记录么？', function(index){
                        obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                        layer.close(index);
                        activeByType('removeEmptyTableCache');
                    });
                    break;
            }
        });
    });

    $(function () {
        switch ("<%=from%>") {
            case "RF": {
                $("#genre").html("楼顶扇");
                break;
            }
            case "GD": {
                $("#genre").html("趴地扇");
                break;
            }
            case "BS": {
                $("#genre").html("商务扇");
                break;
            }
            default:{

            }
        }

        $("#return").click(function () {
            window.history.go(-1);
        });
    });
</script>

</body>
</html>
