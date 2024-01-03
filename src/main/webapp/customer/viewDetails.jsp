<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/12/30
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看详情页面</title>
    <script>
        function buy(goodsId, goodsPrice) {
            if ("${sessionScope.user.id}" == null) {
                alert("请登录");
            } else {
                // 转换余额为数字
                var userBalance = parseFloat("${sessionScope.user.balance}");
                if (userBalance < goodsPrice) {
                    alert("余额不足请充值");
                } else {
                    if (window.confirm("确认购买")) {
                        window.location.href = "${pageContext.request.contextPath}/buy?goodsId=" + goodsId + "&confirm=false";
                    } else {
                        window.location.href = "${pageContext.request.contextPath}/buy?goodsId=" + goodsId + "&confirm=true";
                    }
                }
            }
        }
    </script>
</head>
<body>
<c:if test="${!empty message}">
    <script>
        alert("${message}")
    </script>
</c:if>
<c:choose>
    <c:when test="${! empty sessionScope.user}">
        <p>用户名：${sessionScope.user.name}     余额：${sessionScope.user.balance}</p>
        <a href="${pageContext.request.contextPath}/customer/charge.jsp">充值</a>
    </c:when>
    <c:when test="${empty sessionScope.user}">
        <p>未登录</p>
    </c:when>
</c:choose>
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
        <td><a href="${pageContext.request.contextPath}/toBuyGoods?userId=${user.id}&goodsId=${goods.id}">确认购买</a></td>
        <td><a href="${pageContext.request.contextPath}/toBuy?userId=${user.id}&index=1">取消购买</a></td>
    </tr>
</table>

</body>
</html>
