<%--
  Created by IntelliJ IDEA.
  User: 28492
  Date: 2020/9/18
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>error</title>
    <script type="text/javascript" src="js/error.js"></script>
    <link rel="stylesheet" href="css/error.css">
</head>

<body>
<img src="file/error.png" alt="error">
<div class="word">
    <p class="info"><%=request.getAttribute("msg")%></p>

    <p> <span id="showNum"> </span> 秒后自动返回到登录页面</p>
    <br>
    <p>&nbsp;&nbsp;不能跳转请
        <a href="login.html" >点击这儿</a></p>
</div>
</body>
</html>
