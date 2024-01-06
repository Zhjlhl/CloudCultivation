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
<form class="updateGoods" action="${pageContext.request.contextPath}/updateGoods?merchantId=${merchant.id}"  method="post">
    <label for="image">商品图片：</label>
    <input type="file" id="image" accept="image/*" name="image" required>
    <br>
    <label for="name">商品名：</label>
    <input type="text" id="name" name="name" required>
    <br>
    <label for="type">商品种类：</label>
    <input type="text" id="type" name="type" required>
    <br>
    <label for="growth">成熟周期：</label>
    <input type="text" id="growth" name="growth" required>
    <br>
    <label for="yield">预期收益：</label>
    <input type="text" id="yield" name="yield" required>
    <br>
    <label for="amount">商品数量：</label>
    <input type="number" id="amount" name="amount" required>
    <br>
    <label for="price">商品价格：</label>
    <input type="number" id="price" name="price" required>
    <br>
    <label for="description">商品描述：</label>
    <input type="text" id="description" name="description" required>
    <br>
    <input type="submit" value="提交" class="updateGoods-button">
</form>
<a href="${pageContext.request.contextPath}/toMerchantHome">回到首页</a>
</body>
</html>
