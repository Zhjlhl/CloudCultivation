<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/1/1
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>审核纠纷页面</title>
</head>
<body>
<c:if test="${! empty dispute}">
    <c:if test="${dispute=='已收获'}">
    <table>
        <tr>
            <th>订单id</th>
            <th>用户id</th>
            <th>商家id</th>
            <th>涉及金额</th>
            <th>描述</th>
            <th>状态</th>
            <th>纠纷类型</th>
            <th>开始时间</th>
            <th>快递单号</th>  <%--好像物流信息是在harvest中--%>
            <th>物流公司</th>
            <th>收货状态</th>
            <th>操作</th>
        </tr>
        <form action="${pageContext.request.contextPath}/check">
            <tr>
                <td>${dispute.orders.id}</td>
                <td>${dispute.orders.user.id}</td>
                <td>${dispute.orders.merchant.id}</td>
                <td><input type="text" name="amount" value="${dispute.amount}"></td>
                <td>${dispute.description}</td>
                <td><input type="text" name="state" value="${dispute.state}"></td>
                <td>${dispute.type}</td>
                <td>${dispute.date}</td>
                <td><input type="text" name="number" value="${harvest.number}"></td>
                <td><input type="text" name="delivery" value="${harvest.delivery}"></td>
                <td><input type="text" name="state" value="${harvest.state}"></td>
                <td><input type="submit" value="提交"></td>
            </tr>
        </form>
        <tr>
        </tr>
    </table>
        <c:forEach items="${indexList}" var="index">
            <a href="${pageContext.request.contextPath}">${index}</a>
        </c:forEach>
</c:if>
</body>
</html>
