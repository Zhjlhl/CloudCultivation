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
    <title>今日待投喂订单</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/chooseFeedOngoingOrder?type=all">所有饲养中订单</a>
<a href="${pageContext.request.contextPath}/chooseFeedOngoingOrder?type=type=waitingUpdateInfo">今日待上传信息订单</a>
<table>
    <tr>
        <th>订单号</th>
        <th>宠物姓名</th>
        <th>宠物种类</th>
        <th>主人</th>
        <th>今日投喂饲料</th>
        <th>今日投喂状态</th>
    </tr>
    <c:if test="${!empty orders}">
        <c:forEach items="${orders}" var="order" varStatus="st">
            <tr>
                <td align="center">${order.id}</td>
                <td align="center">${order.nickName}</td>
                <td align="center">${order.goods.type}</td>
                <td>${order.user.name}</td>
                <td>${order.feed.name}</td>
                <td>
                    <c:choose>
                        <c:when test="${order.feedState == '待投喂'}">
                            <a href="${pageContext.request.contextPath}/feed?feedState=already&originalPage=waitingFeed&orderId=${order.id}">已投喂</a>"
                        </c:when>
                        <c:when test="${order.feedState == '已投喂'}">
                            ${order.feedState}
                        </c:when>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>
<a href="${pageContext.request.contextPath}/toFeedOngoing">返回到所有饲养订单页面</a>
<a href="${pageContext.request.contextPath}/toMerchant">返回到主页</a>
</body>
</html>
