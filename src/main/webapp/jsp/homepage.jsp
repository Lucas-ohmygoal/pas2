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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.default.css" id="theme-stylesheet">
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    String userId = request.getParameter("userName");
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
    </div>
</div>
<!-- JavaScript files-->
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/homepage.js"></script>
<script type="text/javascript">

</script>
</body>
</html>
