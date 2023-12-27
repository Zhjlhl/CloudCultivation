<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/12/23
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>待评价订单</title>
</head>
<body>
<c:if test="${!empty orders}">
    <table>
        <tr>
            <th>订单号</th>
            <th>宠物姓名</th>
            <th>宠物种类</th>
            <th>购买时间</th>
            <th>宠物最终状态</th>
            <th>支付金额</th>
            <th>最终结束时间</th>
            <th>评价</th>
        </tr>
        <c:forEach items="${orders}" var="order">
            <c:when test="${order.evaluateState eq null}">
                <tr>
                    <th>${order.id}</th>
                    <th>${order.nickName}</th>
                    <th>${order.goods.type}</th>
                    <th>${order.startTime}</th>
                    <th>${order.endYield}</th>
                    <th>${order.goods.price}</th>
                    <th>${order.endTime}</th>
                    <th>
                        <form>
                            <label for="evaluateState">评价等级</label>
                            <input type="text" id="evaluateState">
                            <input type="submit" value="提交">
                        </form>
                    </th>
                </tr>
            </c:when>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
