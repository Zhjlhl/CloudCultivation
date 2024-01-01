<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/12/27
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>认养界面</title>
</head>
<body>
<p>余额：${user.account}</p>
<form onsubmit="pay.jsp">
    <table>
        <tr>
            <th>宠物种类</th>
            <th>宠物价格</th>
        </tr>
        <tr>
            <td>${tarGoods.type}</td>
            <td>${tarGgoods.price}</td>
        </tr>
    </table>
    <label for="nickName">请取名</label>
    <input type="text" id="nickName">
    <input type="submit" value="确认提交">
</form>
</body>
</html>
