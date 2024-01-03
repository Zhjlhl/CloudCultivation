<%--
  Created by IntelliJ IDEA.
  User: hyy
  Date: 2024/1/2
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户余额不足</title>
</head>
<body>
<p>您的余额不足，请先完成余额充值。</p>
<%--请求交给controller处理      @RequestParm("operate")String operate，finish是充值，cancel是取消充值跳转到商城界面--%>
<form action="${pageContext.request.contextPath}/toCharge">
    <label for="amount">充值金额:</label>
    <input type=number name="amount" id="amount">
    <input type="hidden" name="userId" id="userId" value="${user.id}">
    <input type=submit name="operate" value="我已完成支付"><br>
    <a href="${pageContext.request.contextPath}/toBuy?userId=${user.id}&index=1">取消充值</a>
</form>
<img src="${pageContext.request.contextPath}/customer/img/pay.png" alt="充值二维码"/><br>
<%--
    </td>
    <a href="${pageContext.request.contextPath}/toUserHome">我已完成支付</a>
--%>
</body>
</html>
