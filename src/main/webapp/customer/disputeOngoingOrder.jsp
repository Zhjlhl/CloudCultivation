<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/12/19
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>售后处理</title>
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
            <th>查看和客服聊天记录</th>
        </tr>
        <c:forEach items="${disputes}" var="dispute">
            <tr>
                <td>${dispute.orders.id}</td>
                <td>${dispute.orders.nickname}</td>
                <td>${dispute.orders.goods.type}</td>
                <td>${dispute.date}</td>
                <td>${dispute.type}</td>
                <td>${dispute.description}</td>
                <td>${dispute.state}</td>
                <td><form action="${pageContext.request.contextPath}/toChatWithService">
                    <input type="hidden" name="orderId" value="${order.id}">
                    <input type="submit"  value="查看">
                </form> </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
