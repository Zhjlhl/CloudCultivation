<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/1/1
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有饲养订单页面</title>
</head>
<body>
<table>
    <tr>
        <th>订单号</th>
        <th>宠物姓名</th>
        <th>宠物种类</th>
        <th>主人</th>
        <th>今日饲料</th>
        <th>投喂状态</th>
        <th>上传信息状态</th>
    </tr>
    <c:if test="${!empty orders}">
        <c:forEach items="${orders}" var="order" varStatus="st">
            <tr>
                <td >${order.id}</td>
                <td >${order.nickname}</td>
                <td >${order.goods.type}</td>
                <td>${order.user.name}</td>
                <td>${order.feed}</td>
                <td>${order.state}</td>
            </tr>
        </c:forEach>
    </c:if>
</table>
<a href="${pageContext.request.contextPath}/toMerchantHome">返回到主页</a>
</body>
</html>
