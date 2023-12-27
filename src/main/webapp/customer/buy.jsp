<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/12/27
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script>
        function handleBuyClick(GoodId) {
            // 在这里，您可以使用feedName执行您想要的操作
            // 例如，将其发送到服务器或在页面上显示
            alert("用户点击购买了：" + GoodId);
        }
    </script>
    <title>认养界面</title>
</head>
<body>
<table>
    <tr>
        <th>宠物种类</th>
        <th>成熟周期</th>
        <th>预期收益</th>
        <th>剩余数量</th>
        <th>描述</th>
        <th>价格</th>
        <th>购买</th>
    </tr>
<c:forEach items="${goods}" var="good">
<tr>
    <td>${good.type}</td>
    <td>${good.growth}</td>
    <td>${good.yield}</td>
    <td>${good.amount}</td>
    <td>${good.description}</td>
    <td>${good.price}</td>
    <td><form>
        <input type="button" value="购买" onclick="handleBuyClick('${good.id}')">
    </form></td>
</tr>
</c:forEach>
</table>
</body>
</html>
