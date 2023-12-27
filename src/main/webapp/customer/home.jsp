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
    <title>Title</title>
</head>
<body>
<p>欢迎您!${user.name}</p>
<p>余额:${user.balance}</p>
<a href="/customer/finishedOrder.jsp" >已完成订单</a>
<a href="/customer/feedOngoingOrder.jsp" >饲养中订单</a>
<a href="/customer/harvestOngoingOrder.jsp" >收获中订单</a>
<a href="/customer/disputeOngoingOrder.jsp">售后中订单</a>
<a href="/customer/watingPaid.jsp">待支付订单</a>
<a href="/customer/watingEvaluate.jsp">待评价订单</a>
<a href="/customer/chatWithMerchant.jsp">和商家交流信息</a>
<br>
<a href="/customer/buy.jsp">购买商品</a>
</body>
</html>
