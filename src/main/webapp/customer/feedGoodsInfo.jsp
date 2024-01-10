<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/12/20
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>饲养中动物信息</title>

</head>
<body>
<!--
写2个图表，1：按天按周按月展示动物体重
         2：按天展示饲料种类
         !-->
<c:if test="${message == '投喂成功'}">
    <script>
        alert("投喂成功！")
    </script>
</c:if>
<c:if test="${message == '投喂失败'}">
    <script>
        alert("投喂失败！")
    </script>
</c:if>
<table>
    <tr>
        <th>订单id：</th>
        <th>动物姓名：</th>
        <th>动物种类：</th>
        <th>当前状态：</th>
        <th>当前体重：</th>
        <th>申请售后</th>
    </tr>
    <tr>
        <td>${orders.id}</td>
        <td>${orders.nickname}</td>
        <td>${orders.goods.type}</td>
        <td>${feeding.state}</td>
        <td>${feeding.weight}</td>
        <td><a href="/checkDispute">申请售后</a></td>
    </tr>
</table>
<%--<p>查看宠物以往信息：</p>
<form>
    <label for="date">选择查看日期</label>
    <input type="date" id="date">
    <input type="submit" value="选择查看">
</form>--%>
<p>已有饲料:</p>
<table>
    <tr>
        <th>饲料名</th>
        <th>拥有数量</th>
        <th>投喂</th>
    </tr>
    <c:forEach items="${feeds}" var="feed">
        <tr>
            <td>${feed.feed.name}</td>
            <td>${feed.remain}</td>
            <td>
                <a href="${pageContext.request.contextPath}/feed?buyId=${feed.id}&&userId=${sessionScope.user.id}">投喂</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="${pageContext.request.contextPath}/toBuyFeed?ordersId=${orders.id}">购买饲料</a>
<a href="${pageContext.request.contextPath}/toUserHome">返回首页</a>
</body>
</html>
