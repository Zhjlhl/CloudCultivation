<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/12/19
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新快递</title>
</head>
<body>
<form>
    <label for="number">单号：</label>
    <input type="text" id="number" name="number">
    <br>
    <label for="trackNumber">快递单号：</label>
    <input type="text" id="trackNumber" name="trackNumber">
    <br>
    <label for="sourceAddress">发送地址：</label>
    <input type="text" id="sourceAddress" name="sourceAddress">
    <br>
    <label for="destination">接收地址：</label>
    <input type="text" id="destination" name="destination">
    <br>
    <label for="company">快递公司：</label>
    <input type="text" id="company" name="company">
</form>
<a href="/merchant/harvestOngoingOrder.jsp">回到上一级</a>
</body>
</html>
