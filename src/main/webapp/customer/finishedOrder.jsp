<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/12/19
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>已完成订单</title>
</head>
<body>
<%--
对于用户的每个已完成订单
--%>
<a href="${pageContext.request.contextPath}/toUserHome">返回上一级</a>
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
                <td align="center">${order.nickname}</td>
                <td align="center">${order.goods.type}</td>
                <td align="center">
                    <fmt:formatDate value="${order.date}" pattern="yyyy-MM-dd" />
                </td>
                <td align="center">
                    <fmt:formatDate value="${order.endTime}" pattern="yyyy-MM-dd" />
                </td>
                <td align="center">${order.endYield}</td>
                <td align="center">
                    <c:choose>
                        <c:when test="${order.remark eq null}">
                            <form action="${pageContext.request.contextPath}/submitEvaluation?orderId=${order.id}" method="post">
                                <label for="evaluateState">评价等级</label>
                                <input type="text" name="evaluateState" id ="evaluateState">
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
