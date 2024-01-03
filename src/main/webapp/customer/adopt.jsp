<%--
  Created by IntelliJ IDEA.
  User: hyy
  Date: 2024/1/2
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>确认购买</title>
</head>
<body>
<table>
    <tr>
        <th>商品种类</th>
        <th>商品成熟周期</th>
        <th>预期收益</th>
        <th>剩余数量</th>
        <th>描述</th>
        <th>价格</th>
    </tr>
    <tr>
        <td>${goods.name}</td>
        <td>${goods.growth}</td>
        <td>${goods.yield}</td>
        <td>${goods.amount}</td>
        <td>${goods.description}</td>
        <td>${goods.price}</td>
    </tr>
    <tr>
        <td><a href="${pageContext.request.contextPath}/toBuyGoods?userId=${user.id}&goodsId=${good.id}">确认购买</a></td>
        <td><a href="${pageContext.request.contextPath}/toBuy?userId=${user.id}&index=1">取消购买</a></td>
    </tr>
</table>
</body>
</html>
