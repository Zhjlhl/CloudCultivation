<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/1/1
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>今日待上信息订单</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/chooseFeedOngoingOrder?type=all">所有饲养中订单</a>
<a href="${pageContext.request.contextPath}/chooseFeedOngoingOrder?type=type=waitingFeed">今日待投喂订单</a>
<table>
    <tr>
        <th>订单号</th>
        <th>宠物姓名</th>
        <th>宠物种类</th>
        <th>主人</th>
        <th>操作</th>
    </tr>
    <c:if test="${!empty orders}">
        <c:forEach items="${orders}" var="order" varStatus="st">
            <tr>
                <td align="center">${order.id}</td>
                <td align="center">${order.nickName}</td>
                <td align="center">${order.goods.type}</td>
                <td>${order.user.name}</td>
                <td><a href="${pageContext.request.contextPath}/toUpdateFeedOngoingInfo?orderId=${order.id}">去上传</a></td>
            </tr>
        </c:forEach>
    </c:if>
</table>

</body>
</html>
