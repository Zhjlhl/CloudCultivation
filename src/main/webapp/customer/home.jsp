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
<div id="header">
    <h1>欢迎您! ${user.name}</h1>
    <p>余额: ${user.balance}</p>
</div>

<div id="content">
    <a class="order-link" href="${pageContext.request.contextPath}/toUserFinished?userId=${user.id}">已完成订单</a>
    <a class="order-link" href="${pageContext.request.contextPath}/toUserFeedOngoing">饲养中订单</a>
    <a class="order-link" href="${pageContext.request.contextPath}/toUserHarvestInformation">收获中订单</a>
    <a class="order-link" href="${pageContext.request.contextPath}/toDisputeOngoing">售后中订单</a>
    <a class="order-link" href="${pageContext.request.contextPath}/toWatingPaid">待支付订单</a>
    <a class="order-link" href="${pageContext.request.contextPath}/towatingEvaluate">待评价订单</a>
    <a class="order-link" href="${pageContext.request.contextPath}/toChatWithMerchant">和商家交流信息</a>
    <br>
    <a class="order-link" href="${pageContext.request.contextPath}/toBuy">购买商品</a>
</div>
</body>
</html>
