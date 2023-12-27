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
    <title>已完成订单</title>
</head>
<body>
<%--
对于用户的每个已完成订单
--%>
<p>订单号：   产品姓名：    产品种类：    评价状态：    <a href="disputeHandle.jsp">申请售后</a></p>
<a href="home.jsp">返回上一级</a>
<table>
    <tr>
        <th>订单号</th>
        <th>宠物姓名</th>
        <th>宠物种类</th>
        <th>开始时间</th>
        <th>结束时间</th>
        <th>最终收益</th>
        <th>评价状态</th>
    </tr>
    <c:if test="${!empty orders}">
        <c:forEach items="${orders}" var="order" varStatus="st">
            <tr>
                <td align="center">${order.id}</td>
                <td align="center">${order.nickName}</td>
                <td align="center">${order.goods.type}</td>
                <td align="center">${order.startTime}</td>
                <td align="center">${order.endTime}</td>
                <td align="center">${order.endYield}</td>
                <td align="center">
                    <c:choose>
                        <c:when test="${order.remark eq null}">
                            <form>
                                <label for="evaluateState">评价等级</label>
                                <input type="text" id="evaluateState">
                                <input type="submit" value="提交">
                            </form>
                        </c:when>
                        <c:otherwise>
                            ${order.remark}
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>
