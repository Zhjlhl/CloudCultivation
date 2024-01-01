<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/1/1
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有售后中订单</title>
</head>
<body>
<c:if test="${! empty disputes}">
    <table>
        <tr>
            <th>订单号</th>
            <th>宠物姓名</th>
            <th>宠物种类</th>
            <th>开始日期</th>
            <th>处理类型</th>
            <th>处理原因</th>
            <th>处理状态</th>
        </tr>
        <c:forEach items="${disputes}" var="dispute">
            <tr>
                <td>${dispute.order.id}</td>
                <td>${dispute.order.nickName}</td>
                <td>${dispute.order.goods.type}</td>
                <td>${dispute.startTime}</td>
                <td>${dispute.type}</td>
                <td>${dispute.description}</td>
                <td>${dispute.state}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
