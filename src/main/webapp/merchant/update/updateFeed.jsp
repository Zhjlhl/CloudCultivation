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
    <label for="feedType">饲料种类：</label>
    <input type="text" id="feedType" name="type">
    <br>
    <label for="number">饲料数量：</label>
    <input type="number" id="number" name="number">
    <br>
    <label for="price">饲料价格：</label>
    <input type="number" id="price" name="price">
    <br>
    <label for="description">饲料描述：</label>
    <input type="text" id="description" name="description">
    <br>
</form>
<a href="/merchant/home.jsp">回到上一级</a>
</body>
</html>
