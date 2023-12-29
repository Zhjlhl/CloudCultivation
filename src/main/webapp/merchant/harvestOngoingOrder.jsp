<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/12/18
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商家进行中订单</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/toMerchantUpdateDelivery">填写快递信息</a>
<br>
<p> 单号： 收获日期： 收获方式 ： 快递：</p>
<c:if test="${!empty orders}">
    <table>
        <th>单号</th>
        <th>收获日期</th>
        <th>收获方式</th>
        <th>状态</th>
    <c:forEach items="orders" var="order">

    </c:forEach>
    </table>
</c:if>
<a href="${pageContext.request.contextPath}/toMerchantHome">回到上一级</a>
</body>

</html>
