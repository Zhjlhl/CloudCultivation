<%--
  Created by IntelliJ IDEA.
  User: Su
  Date: 2023/12/18
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商家信息</title>
</head>
<body>
<p>欢迎您!${merchant.name}</p>
<p>余额:${merchant.balance}</p>
<a href="/merchant/finishedOrder.jsp" >已完成订单</a>
<a href="/merchant/feedOngoingOrder.jsp" >饲养中订单</a>
<a href="${pageContext.request.contextPath}/toMerchantHarvestInformation">收获中订单</a>
<a href="/merchant/disputeOrder.jsp">售后中订单</a>
<a href="/merchant/watingUpdate.jsp">待上传宠物信息订单</a>
<br>
<a href="/merchant/update/updateFeed.jsp">上传饲料</a>
<a href="/merchant/update/updateGoods.jsp">上传商品</a>
</body>
</html>
