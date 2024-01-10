<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/12/19
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>饲养中订单页面</title>
</head>
<c:if test="${!empty message}">
    <script>
        alert("${message}")
    </script>
</c:if>
<body>
<%--
用户点击，触发后端，进入饲养界面，看到饲养信息和购买饲料
--%>
<%-- 如果待收货时间为0，则提供个按钮转区harvestHandle页面，否则就正常显示还有多少天收获
     --%>
<p>单号：  姓名：   当前状态：   上次饲养时间：   当前饲料：    待收货时间：
    <a href="${pageContext.request.contextPath}/feedGoodsInfo">查看更多</a>
</p>
<a href="${pageContext.request.contextPath}/toUserHome">返回首页</a>
<table>
    <tr>
        <th>订单号</th>
        <th>宠物姓名</th>
        <th>宠物种类</th>
        <th>剩余收获时间</th>
        <th>查看更多</th>
    </tr>
    <c:if test="${!empty orders}">
        <c:forEach items="${orders}" var="order" varStatus="st">
            <tr>
                <td align="center">${order.id}</td>
                <td align="center">${order.nickname}</td>
                <td align="center">${order.goods.type}</td>
                <td align="center"><c:choose>
                    <c:when test="${order.remainDay == 0}">
                        <form action="${pageContext.request.contextPath}/applyForHarvest">
                            <select id="harvestWay" name="harvestWay">
                                <option value="全部寄回家">全部寄回家</option>
                                <option value="25%换收益">25%换收益</option>
                                <option value="50%换收益">50%换收益</option>
                                <option value="75%换收益">75%换收益</option>
                                <option value="100%换收益">100%换收益</option>
                            </select>
                            <input type="hidden" name="orderId" value="${order.id}">
                            <input type="submit" value="收获">
                        </form>
                    </c:when>
                    <c:when test="${order.goods.growth > 0}">
                        ${order.remainDay}
                    </c:when>
                </c:choose></td>
                <td align="center">
                    <form action="${pageContext.request.contextPath}/toCustomerFeedGoodsInfo">
                        <input type="hidden" name="ordersId" value="${order.id}" >
                        <input type="submit" value="查看更多">
                    </form>
                </td>

            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>