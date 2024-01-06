<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${! empty harvest}">
    <table>
        <tr>
            <th>订单号</th>
            <th>宠物名</th>
            <th>种类</th>
            <th>收获日期</th>
            <th>收获方式</th>
        </tr>
        <tr>
            <td>${harvest.orders.id}</td>
            <td>${harvest.orders.nickname}</td>
            <td>${harvest.orders.goods.name}</td>
            <td>${harvest.date}</td>
            <td>${harvest.way}</td>
        </tr>
    </table>
    <form class="updateDelivery" action="${pageContext.request.contextPath}/updateDelivery?harvestId=${harvest.id}" method="post">
        <label for="number">快递单号：</label>
        <input type="text" id="number" name="number" required>
        <br>
        <label for="delivery">快递公司：</label>
        <input type="text" id="delivery" name="delivery" required>
        <input type="submit" value="提交" class="updateDelivery-button">
    </form>
</c:if>
<a href="${pageContext.request.contextPath}/toMerchantHarvestOngoingOrder?merchantId=${sessionScope.merchant.id}">回到所有收获中订单页面</a>
</body>
</html>
