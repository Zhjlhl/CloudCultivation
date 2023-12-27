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
    <title>Title</title>
</head>
<body>
<c:if test="${! empty disputes}">
    <table>
        <tr>
            <th>订单号</th>
            <th>宠物姓名</th>
            <th>宠物种类</th>
            <th>开始日期</th>
            <th>处理原因</th>
            <th>处理状态</th>
            <th>查看和客服聊天记录</th>
        </tr>
        <c:forEach items="${disputes}" var="dispute">
            <tr>
                <td>${dispute.order.id}</td>
                <td>${dispute.order.nickName}</td>
                <td>${dispute.order.goods.type}</td>
                <td>${dispute.startTime}</td>
                <td>${dispute.reason}</td>
                <td>${dispute.state}</td>
                <td><a href="chatWithService.jsp">查看</a> </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
