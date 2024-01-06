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
    <title>上传饲料页面</title>
</head>
<body>
<form class="addFeed" action="${pageContext.request.contextPath}/addFeed?merchantId=${merchant.id}" method="post">
    <label for="image">饲料图片：</label>
    <input type="file" id="image" accept="image/*" name="image" >
    <br>
    <label for="name">饲料名：</label>
    <input type="text" id="name" name="name"  required>
    <br>
    <label for="amount">饲料数量：</label>
    <input type="number" id="amount" name="amount" required>
    <br>
    <label for="price">饲料价格：</label>
    <input type="number" id="price" name="price" required>
    <br>
    <label for="description">饲料描述：</label>
    <input type="text" id="description" name="description" required>
    <br>
    <input type="submit" value="上传" class="addFeed-button">
</form>
<a href="${pageContext.request.contextPath}/toMerchantHome">返回到主页</a>
</body>
</html>
