<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/12/27
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购买界面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/select">
    <input type="radio" name="type" value="植物">
    <input type="radio" name="type" value="动物">
    <input type="text" name="name">
</form>
<table>
    <tr>
        <th>大类别</th>
        <th>小类别</th>
        <th>成熟周期</th>
        <th>预期收益</th>
        <th>剩余数量</th>
        <th>描述</th>
        <th>价格</th>
        <th>购买</th>
    </tr>
    <c:forEach items="${goods}" var="good">
        <tr>
            <td>${good.type}</td>
            <td>${good.name}</td>
            <td>${good.growth}</td>
            <td>${good.yield}</td>
            <td>${good.amount}</td>
            <td>${good.description}</td>
            <td>${good.price}</td>
            <td>
                <a href="${pageContext.request.contextPath}/toAdopt?userId=${user.id}&goodsId=${good.id}">购买</a>
            </td>
        </tr>
    </c:forEach>
</table>
<c:forEach items="${indexList}" var="index">
<a href="${pageContext.request.contextPath}/toBuy?userId=${user.id}&index=${index}">${index}</a>
</c:forEach>
</body>
</html>

