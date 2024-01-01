<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/12/19
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${! empty harvest}">
    <table>
        <tr>
            <th>订单号</th>
            <th>小名</th>
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
    <form action="${pageContext.request.contextPath}/updateDelivery">
        <br>
        <input type="hidden" name="originalPage" value="${originalPage}" required>
        <input type="hidden" name="harvestId" value="${harvest.id}" required>
        <label for="trackNumber">快递单号：</label>
        <input type="text" id="trackNumber" name="trackNumber" required>
        <br>
        <label for="delivery">快递公司：</label>
        <input type="text" id="delivery" name="delivery" required>
        <input type="submit" value="提交">
    </form>
</c:if>
<a href="${pageContext.request.contextPath}/toMerchantHarvestOngoingOrder">回到所有收获中订单页面</a>
</body>
</html>
