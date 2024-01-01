<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/12/19
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户主界面</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f0f2f5;
            margin: 0;
            padding: 0;
            color: #1c1e21;
        }

        #header {
            background-color: #4267b2;
            color: white;
            padding: 10px;
            text-align: center;
        }

        #content {
            margin: 20px;
            text-align: center;
        }

        p {
            font-size: 16px;
        }

        a {
            color: #4267b2;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        .order-link {
            display: block;
            margin-bottom: 10px;
            padding: 10px;
            background-color: #4267b2;
            border-radius: 5px;
            color: white;
            font-size: 18px;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>账号</th>
        <th>用户名</th>
        <th>性别</th>
        <th>联系电话</th>
        <th>邮编地址</th>
        <th>余额</th>
    </tr>
    <tr>
        <td>${sessionScope.user.account}</td>
        <td>${sessionScope.user.name}</td>
        <td>${sessionScope.user.gender}</td>
        <td>${sessionScope.user.phone}</td>
        <td>${sessionScope.user.zipcode}</td>
        <td>${sessionScope.user.balance}</td>
    </tr>
</table>

<div id="content">
    <a href="">修改个人信息</a>
    <a class="order-link" href="${pageContext.request.contextPath}/toUserFinished?userId=${user.id}">已完成订单</a>
    <a class="order-link" href="${pageContext.request.contextPath}/toUserFeedOngoing?userId=${user.id}">饲养中订单</a>
    <a class="order-link" href="${pageContext.request.contextPath}/toUserHarvestInformation?userId=${user.id}">收获中订单</a>
    <a class="order-link" href="${pageContext.request.contextPath}/toDisputeOngoing?userId=${user.id}">售后中订单</a>
    <a class="order-link" href="${pageContext.request.contextPath}/toWaitingPaid?userId=${user.id}">待支付订单</a>
    <a class="order-link" href="${pageContext.request.contextPath}/toWaitingEvaluate">待评价订单</a>
    <br>
    <a class="order-link" href="${pageContext.request.contextPath}/toBuy?userId=${user.id}">购买商品</a>
</div>
</body>
</html>
