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
<p>余额：${sessionScopen.user.account}</p>
<form action="${pageContext.request.contextPath}/toRecharge"></form>
<c:if test="${!empty orders}">
    <table>
        <tr>
            <th>宠物种类</th>
            <th>成长周期</th>
            <th>预期收益</th>
            <th>支付金额</th>
            <th>宠物描述</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${orders}" var="order">
            <c:choose>
                <c:when test="${order.paymentState eq \"待支付\"}">
                    <tr>
                        <th>${order.goods.type}</th>
                        <th>${order.goods.growth}</th>
                        <th>${order.goods.yield}</th>
                        <th>${order.goods.price}</th>
                        <th>${order.goods.description}</th>
                        <th><c:if test="${sessionScope.user.account >= order.goods.price}">
                            <form action="${pageContext.request.contextPath}/pay">
                                <input type="hidden" name="orderId" value="${order.id}">
                                <input type="submit" value="确认支付">
                                </c:if>
                                <c:if test="${sessionScope.user.account < order.goods.price}">
                                    <p>余额不足</p>
                                </c:if>
                            </form></th>
                    </tr>
                </c:when>
            </c:choose>
        </c:forEach>
    </table>
</c:if>
<c:if test="${empty orders}">
    <p>无待支付订单</p>
</c:if>
</body>
</html>
