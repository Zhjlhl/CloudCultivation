<%--
  Created by IntelliJ IDEA.
  User: 36103
  Date: 2024/1/10
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>宠物取名</title>
</head>
<body>
<c:if test="${message == '取名成功'}">
    <script>
        alert("取名成功！")
    </script>
</c:if>
<c:if test="${message == '取名失败'}">
    <script>
        alert("取名失败！")
    </script>
</c:if>
请为您的宠物取名：
<br>
<form action="${pageContext.request.contextPath}/nickname?orderId=${order.id}">
    <input type="text" name="name">
    <input type="hidden" name="orderId" value="${order.id}">
    <input type="submit"  value="确定昵称">
</form>
<a href="${pageContext.request.contextPath}/toUserHome">返回主页</a>
</body>
</html>
