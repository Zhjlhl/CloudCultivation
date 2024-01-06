<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/12/18
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>订单号</th>
        <th>主人</th>
        <th>宠物姓名</th>
        <th>宠物种类</th>
        <th>购买日期</th>
        <th>订单结束日期</th>
        <th>最终状态</th>
        <%--<th>评价状态</th>--%>
    </tr>
    <c:if test="${!empty orders}">
        <c:forEach items="${orders}" var="order" varStatus="st">
            <tr>
                <td align="center">${order.id}</td>
                <td align="center">${order.user.name}</td>
                <td align="center">${order.nickname}</td>
                <td align="center">${order.goods.type}</td>
                <td align="center">${order.date}</td>
                <td align="center">${order.endTime}</td>
                <td align="center">${order.endState}</td>
                <%--<td align="center">
                    <c:choose>
                        <c:when test="${order.remark eq null}">
                            <form action="${pageContext.request.contextPath}/submitEvaluation" method="post">
                                <label for="evaluateState">评价等级</label>
                                <input type="text" name="evaluateState" id ="evaluateState">
                                <input type="hidden" name="orderId" value="${order.id}" >
                                <input type="submit" value="提交">
                            </form>
                        </c:when>
                        <c:otherwise>
                            ${order.remark}
                        </c:otherwise>
                    </c:choose>
                </td>--%>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>
