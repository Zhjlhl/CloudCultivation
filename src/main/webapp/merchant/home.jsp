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
    <title>Title</title>
</head>
<body>
<p>欢迎您!${merchant.name}</p>
<p>余额:${merchant.balance}</p>
<a href="${pageContext.request.contextPath}/toMerchantFinished" >已完成订单</a>
<a href="${pageContext.request.contextPath}/toMerchantFeedOngoingOrder" >饲养中订单</a>
<a href="${pageContext.request.contextPath}/toMerchantHarvestOngoingOrder" >收获中订单</a>
<a href="${pageContext.request.contextPath}/toMerchantDisputeOrder">所有售后订单</a>
<a href="${pageContext.request.contextPath}/toMerchantFeedCheck">所有审核中饲料</a>
<a href="${pageContext.request.contextPath}/toMerchantGoodsCheck">所有审核中商品</a>
<br>
<a href="${pageContext.request.contextPath}/toMerchantUpdateFeed">上传饲料</a>
<a href="/merchant/update/updateGoods.jsp">上传商品</a>
</body>
</html>
