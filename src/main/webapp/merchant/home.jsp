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
    <title>主页</title>
</head>
<body>
<table>
    <tr>
        <th>账号</th>
        <th>用户名</th>
        <th>余额</th>
        <th>法人代表</th>
        <th>简介</th>
        <th>联系电话</th>
    </tr>
    <tr>
        <td>${sessionScope.merchant.account}</td>
        <td>${sessionScope.merchant.name}</td>
        <td>${sessionScope.merchant.balance}</td>
        <td>${sessionScope.merchant.contacts}</td>
        <td>${sessionScope.merchant.description}</td>
        <td>${sessionScope.merchant.phone}</td>
    </tr>
</table>
<a href="${pageContext.request.contextPath}/toMerchantUpdateSelfInfo?merchantId=${merchant.id}">修改个人信息</a>
<a href="${pageContext.request.contextPath}/toMerchantFinished?merchantId=${merchant.id}" >已完成订单</a>
<a href="${pageContext.request.contextPath}/toMerchantFeedOngoingOrder?merchantId=${merchant.id}" >饲养中订单</a>
<a href="${pageContext.request.contextPath}/toMerchantHarvestOngoingOrder?merchantId=${merchant.id}" >收获中订单</a>
<a href="${pageContext.request.contextPath}/toMerchantDisputeOrder?merchantId=${merchant.id}">所有售后订单</a>
<a href="${pageContext.request.contextPath}/toMerchantFeedCheck?merchantId=${merchant.id}">所有审核中饲料</a>
<a href="${pageContext.request.contextPath}/toMerchantGoodsCheck?merchantId=${merchant.id}">所有审核中商品</a>
<br>
<a href="${pageContext.request.contextPath}/toMerchantUpdateFeed?merchantId=${merchant.id}">上传饲料</a>
<a href="${pageContext.request.contextPath}/toMerchantUpdateGoods?merchantId=${merchant.id}">上传商品</a>
</body>
</html>
