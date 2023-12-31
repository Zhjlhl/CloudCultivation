<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/1/1
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有售后订单</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/toMerchantDisputeOngoingOrder?merchantId=${merchant.id}">售后中订单</a>
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
            <th>处理结果</th>
            <th>操作</th>
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
                <td>${dispute.result}</td>
                <td><a href="${pageContext.request.contextPath}/">反馈</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<a href="${pageContext.request.contextPath}/toMerchantHome">返回到主页</a>
</body>
</html>
