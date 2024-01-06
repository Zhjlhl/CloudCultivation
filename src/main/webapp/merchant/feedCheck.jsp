<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/1/1
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>审核中的饲料</title>
</head>
<body>
<c:if test="${! empty feeds}">
    <table>
        <tr>
            <th>名字</th>
            <th>数量</th>
            <th>价格</th>
            <th>描述</th>
            <th>审核状态</th>
        </tr>
        <c:forEach items="${feeds}" var="feed">
            <tr>
                <td>${feed.name}</td>
                <td>${feed.amount}</td>
                <td>${feed.price}</td>
                <td>${feed.description}</td>
                <td>${feed.check}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<a href="${pageContext.request.contextPath}/toMerchantHome">返回首页</a>
</body>
</html>
