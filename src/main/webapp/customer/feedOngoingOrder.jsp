<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/12/19
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>饲养中订单页面</title>
</head>
<body>
<%--
用户点击，触发后端，进入饲养界面，看到饲养信息和购买饲料
--%>
<%-- 如果待收货时间为0，则提供个按钮转区harvestHandle页面，否则就正常显示还有多少天收获
     --%>
<p>单号：  姓名：   当前状态：   上次饲养时间：   当前饲料：    待收货时间：
    <a href="feedGoodsInfo">查看更多</a>   <a href="disputeHandle">申请售后</a>
</p>
<a href="/customer/home.jsp">返回上一级</a>
<table>
    <tr>
        <th>订单号</th>
        <th>宠物姓名</th>
        <th>宠物种类</th>
        <th>查看更多</th>
    </tr>
    <c:if test="${!empty orders}">
        <c:forEach items="${orders}" var="order" varStatus="st">
            <tr>
                <td align="center">${order.id}</td>
                <td align="center">${order.nickName}</td>
                <td align="center">${order.goods.type}</td>
                <td align="center">${order.harvestTime}</td>
                <td align="center"><a href="/customer/feedGoodsInfo.jsp">查看更多</a></td>
</table>
</body>
</html>