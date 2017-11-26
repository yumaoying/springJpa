<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>数据更新</title>
</head>
<body>
<form action="update" method="post">
  id: &nbsp;&nbsp;&nbsp;<input type="text" name="id" value="${decryData.id}" readonly><br>
  内容：&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="value" value="${decryData.value}" ><br>
    处理时间：&nbsp;&nbsp;&nbsp; <input type="text" name="time" value="${decryData.time}" ><br>
  <input type="submit" value="更新"><br>
</form>


</body>
</html>
