<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/12/20
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset=UTF-8>
    <title>申请售后页面</title>
</head>
<body>
<form>
    <table>
        <tr>
            <th>订单id</th>
            <th>宠物姓名</th>
            <th>宠物种类</th>
            <th>购买时间</th>
            <th>问题选择</th>
            <th>问题描述</th>
        </tr>
        <tr>
            <th>${orders.id}</th>
            <th>${orders.nickname}</th>
            <th>${orders.goods.type}</th>
            <th>${orders.date}</th>
            <th>
            <input type="radio" id="动物死亡" name="radio" value="user" required>动物死亡
            <input type="radio" id="商家跑路" name="radio" value="merchant" required>商家跑路
            <input type="radio" id="用户中途退出" name="radio" value="service" required>用户中途退出
            <input type="radio" id="商家违约" name="radio" value="administrator" required>商家违约
            <input type="radio" id="七天内无理由退款" name="radio" value="administrator" required>七天内无理由退款
            <input type="radio" id="其他问题" name="radio" value="administrator" required>其他问题
            </th>
            <th><input type="text" id="description"></th>
        </tr>
    </table>
</form>
<a href="${pageContext.request.contextPath}/toUserHome">返回首页</a>
</body>
</html>
