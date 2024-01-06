<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/12/19
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传宠物今日信息</title>
</head>
<body>

<table>
    <tr>
        <th>订单号</th>
        <th>宠物名</th>
        <th>宠物种类</th>
        <th>主人</th>
    </tr>
    <tr>
        <td>${order.id}</td>
        <td>${order.nickname}</td>
        <td>${order.goods.name}</td>
        <td>${order.user.name}</td>
    </tr>
</table>
<form action="${pageContext.request.contextPath}/updateFeedOngoingInfo" method="post" enctype="multipart/form-data">
    <input type="hidden"  name="orderId" value="${orderId}">健康
    <label for="video">选择视频:</label>
    <input type="file" id="video" name="video" accept="video/*" required>
    <label for="video">选择图片:</label>
    <input type="file" id="image" name="image" accept="image/*" required>
    <label for="video">体重:</label>
    <input type="file" id="weight" name="weight" required>
    <input type="radio"  name="state" value="健康" required>健康
    <input type="radio"  name="state" value="生病" required>生病
    <button type="submit">上传</button>
</form>
<a href="${pageContext.request.contextPath}/toFeedOngoingOrder">返回到所有饲养订单页面</a>
<a href="${pageContext.request.contextPath}/toMerchantHome">返回到主页</a>
</body>
</html>
