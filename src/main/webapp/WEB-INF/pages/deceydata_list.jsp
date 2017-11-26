<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="toadd">添加新数据</a>
<table border="1">
    <tr><th>编号</th><th>解密值</th><th>处理时间</th><th>查看</th><th>编辑</th><th>删除</th></tr>
    <c:forEach items="${dlist}" var="decryData">
    <tr>
       <td>${decryData.id}</td>
        <td>${decryData.value}</td>
        <td>${decryData.time}</td>
        <td><a href="toupdate?id=${decryData.id}" >查看</a></td>
        <td><a href="toupdate?id=${decryData.id}" >编辑</a></td>
        <td><a href="delete?id=${decryData.id }">删除</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
