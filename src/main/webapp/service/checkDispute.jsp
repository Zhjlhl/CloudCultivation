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
    <table>
        <tr>
            <th>订单号</th>
            <th>用户id</th>
            <th>商家id</th>
            <th>赔偿金额</th>
            <th>描述</th>
            <th>状态</th>
            <th>纠纷类型</th>
            <th>投诉人</th>
            <th>处理时间</th>
            <th>处理结果</th>
            <th>操作</th>
        </tr>
        <form class="checkDispute" action="${pageContext.request.contextPath}/checkDispute?disputeId=${dispute.id}" method="post">
            <tr>
                <td>${dispute.orders.id}</td>
                <td>${dispute.orders.user.id}</td>
                <td>${dispute.orders.merchant.id}</td>
                <td><input type="double" name="amount" value="${dispute.amount}"></td>
                <td>${dispute.description}</td>
                <td><input type="text" name="state" value="${dispute.state}"></td>
                <td>${dispute.type}</td>
                <td>${dispute.date}</td>
                <td>${dispute.man}</td>
                <td><input type="text" name="result" value="${dispute.result}"></td>
                <td><input type="hidden" name="serviceId" value="${service.id}"></td>
                <td><input type="submit" value="提交" class="checkDispute-button"></td>
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
