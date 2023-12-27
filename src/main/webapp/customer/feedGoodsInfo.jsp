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

    <!-- 添加一个脚本部分，用于处理点击事件 -->
    <script>
        function handleFeedClick(feedName) {
            // 在这里，您可以使用feedName执行您想要的操作
            // 例如，将其发送到服务器或在页面上显示
            alert("用户点击了饲料：" + feedName);
        }
    </script>
</head>
<body>
<!--
写2个图表，1：按天按周按月展示动物体重
         2：按天展示饲料种类
         !-->
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
        <td>${order.id}</td>
        <td>${order.nickName}</td>
        <td>${order.goods.type}</td>
        <td>${order.lastFeeding.state}</td>
        <td>${order.lastFeeding.weight}</td>
        <td><a href="applyForAfterSaleService.jsp">申请售后</a></td>
    </tr>
</table>
<p>查看宠物以往信息：</p>
<form>
    <label for="date">选择查看日期</label>
    <input type="date" id="date">
    <input type="submit" value="选择查看">
</form>
<p>已有饲料</p>
<table>
    <tr>
        <th>饲料名</th>
        <th>拥有数量</th>
        <th>投喂</th>
    </tr>
    <c:forEach items="${order.feeds}" var="feed">
        <tr>
            <td>${feed.name}</td>
            <td>${feed.remain}</td>
            <td>
                <form>
                    <!-- 在按钮上添加一个点击事件处理函数，并传递饲料名作为参数 -->
                    <input type="button" value="投喂" onclick="handleFeedClick('${feed.name}')">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<form>
    <input type="submit" value="去购买饲料">
</form>
<a href="home.jsp">返回首页</a>
</body>
</html>
