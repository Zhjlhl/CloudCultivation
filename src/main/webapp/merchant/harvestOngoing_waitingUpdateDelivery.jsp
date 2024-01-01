<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/1/1
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>待填写物流信息订单</title>
</head>
<body>
<c:if test="${!empty havrests}">
    <table>
        <tr>
            <th>订单号</th>
            <th>宠物名</th>
            <th>宠物种类</th>
            <th>收获日期</th>
            <th>收获方式</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${harvests}" var="harvest" >
            <tr>
                <td >${harvset.orders.id}</td>
                <td >${harvset.orders.nickname}</td>
                <td >${harvset.orders.goods.name}</td>
                <td >${harvset.date}</td>
                <td >${order.way}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/toUpdateDelivery?originalPage=waitingUpdateDelivery&harvestId=${harvest.id}">去填写快递信息</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<a href="${pageContext.request.contextPath}/toMerchantHarvestOngoingOrder">返回所有收获中订单页面</a>
</body>
</html>
