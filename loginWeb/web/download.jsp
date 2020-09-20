<%@ page import="java.util.ArrayList" %>
<%@ page import="vo.Download" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: 28492
  Date: 2020/9/19
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>下载</title>
</head>
<link rel="stylesheet" href="css/download.css">
<script type="text/javascript" src="js/download.js"></script>
<body>

<%
    Date d = new Date();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    String now = df.format(d);
%>

<%
    List<Download> downloadList = (List<Download>)session.getAttribute("dList");
    for(int i = 0; i < downloadList.size(); i++) {
        Download download = (Download) downloadList.get(i);
%>
<%--<tr>
    <td><%=download.getId() %></td>
    <td><%=download.getName() %></td>
    <td><%=download.getPath() %></td>
    <td><%=download.getDescription() %></td>
    <td><%=download.getSize() %></td>
    <td><%=download.getStar() %></td>
    <td><%=download.getImage() %></td>
</tr>--%>
<div class="box">
<img src="<%=download.getImage() %>" alt="1" class="flag">
<div class="name"><%=download.getName() %></div>
<br>
<span class="size">大小: <%=download.getSize() %></span>
    <span>&nbsp;&nbsp;&nbsp;&nbsp;时间：<%=now %></span>
<span>&nbsp;&nbsp;&nbsp;星级：</span>
   <%
    for(int j=0;j<download.getStar() ;j++){
    %>
    <img src="file/brightStar.png" alt="亮星星" class="star">
    <%
    }
   %>
    <%
        for(int j=0;j<5-download.getStar() ;j++){
    %>
    <img src="file/darkStar.png" alt="暗星星" class="star">
    <%
        }
    %>
    <input type="button" value="立即下载" onclick="downloadDoc('<%=download.getPath()%>')"/>
    <br>
<span class="description"><%=download.getDescription() %></span>
<hr/>
</div>
<%
    }
%>
</body>
</html>
