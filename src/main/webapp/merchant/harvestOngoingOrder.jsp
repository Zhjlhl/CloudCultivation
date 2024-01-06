<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${!empty harvests}">
    <table>
        <tr>
            <th>订单号</th>
            <th>宠物名</th>
            <th>宠物种类</th>
            <th>收获日期</th>
            <th>收获方式</th>
            <th>物流状态</th>
        </tr>
        <c:forEach items="${harvests}" var="harvest" >
            <tr>
                <td >${harvest.orders.id}</td>
                <td >${harvest.orders.nickname}</td>
                <td >${harvest.orders.goods.name}</td>
                <td >${harvest.date}</td>
                <td >${harvest.way}</td>
                <td>
                    <c:choose>
                        <c:when test="${harvest.state != '已发货'}">
                            <a href="${pageContext.request.contextPath}/toMerchantUpdateDelivery?harvestId=${harvest.id}">去填写快递信息</a>
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
