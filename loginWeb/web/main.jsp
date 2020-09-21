<%--
  Created by IntelliJ IDEA.
  User: 28492
  Date: 2020/9/18
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
<img src="file/mainHead.png" alt="1">
<span class="user">欢迎您：<%=session.getAttribute("username") %> <a href="servlet/Invalidate">【安全退出】</a></span>
<ul>
    <li><a href="main.jsp">首页</a></li>
    <li>|</li>
    <li><a href="getDownloadList.do">下载</a></li>
    <li>|</li>
    <li><a href="https://imgcook.taobao.org/"></a>设计</li>
    <li>|</li>
    <li><a href="https://www.instagram.com/taylorswift/">相册</a></li>
    <li>|</li>
    <li><a href="TaylorSwift.com">论坛</a></li>
    <li>|</li>
    <li><a href="http://www.liurui13.cn">关于</a></li>
</ul>
<img src="file/main.png" alt="2" class="main">
</body>
</html>
