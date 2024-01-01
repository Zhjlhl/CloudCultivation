<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/12/18
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/toWaitingUpdateDelivery">待填写物流信息订单</a>
<br>
<c:if test="${!empty havrests}">
    <table>
        <tr>
            <th>订单号</th>
            <th>宠物名</th>
            <th>宠物种类</th>
            <th>收获日期</th>
            <th>收获方式</th>
            <th>收获状态</th>
        </tr>
            <c:forEach items="${harvests}" var="harvest" >
                <tr>
                    <td >${harvset.orders.id}</td>
                    <td >${harvset.orders.nickname}</td>
                    <td >${harvset.orders.goods.name}</td>
                    <td >${harvset.date}</td>
                    <td >${order.way}</td>
                    <td>
                        <c:choose>
                            <c:when test="${harvest.state == '待发货'}">
                                <a href="${pageContext.request.contextPath}/toUpdateDelivery?originalPage=all&harvestId=${harvest.id}">去填写快递信息</a>
                            </c:when>
                            <c:when test="${harvest.state == '已发货'}">
                                ${harvest.state}
                            </c:when>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
    </table>
</c:if>
<a href="${pageContext.request.contextPath}/toMerchantHome">回到上一级</a>
</body>

</html>
