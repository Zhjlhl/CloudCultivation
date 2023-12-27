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
<form>
    <label for="goodsType">商品种类：</label>
    <input type="text" id="goodsType" name="type">
    <br>
    <label for="growth">成熟周期：</label>
    <input type="text" id="growth" name="growth">
    <br>
    <label for="number">商品数量：</label>
    <input type="number" id="number" name="number">
    <br>
    <label for="price">商品价格：</label>
    <input type="number" id="price" name="price">
    <br>
    <label for="description">商品描述：</label>
    <input type="text" id="description" name="description">
    <br>
</form>
<a href="/merchant/home.jsp">回到上一级</a>
</body>
</html>
