<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/12/23
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>待支付订单</title>
</head>
<body>
<c:if test="${!empty orders}">
<table>
    <tr>
        <th>宠物种类</th>
        <th>成长周期</th>
        <th>预期收益</th>
        <th>支付金额</th>
        <th>宠物描述</th>
    </tr>
    <c:forEach items="${orders}" var="order">
        <c:when test="${order.paymentState eq \"待支付\"}">
            <tr>
                <th>${order.good.type}</th>
                <th>${order.good.growth}</th>
                <th>${order.good.yield}</th>
                <th>${order.good.price}</th>
                <th>${order.good.description}</th>
            </tr>
            </c:when>
    </c:forEach>
</table>
</c:if>
</body>
</html>
