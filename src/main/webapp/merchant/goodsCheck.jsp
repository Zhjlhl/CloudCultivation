<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/1/1
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>审核中的商品</title>
</head>
<body>
<c:if test="${! empty goods}">
    <table>
        <tr>
            <th>名字</th>
            <th>数量</th>
            <th>种类</th>
            <th>价格</th>
            <th>生长周期</th>
            <th>预期收益</th>
            <th>描述</th>
            <th>审核状态</th>
        </tr>
        <c:forEach items="goods" var="good">
            <tr>
                <td>${good.name}</td>
                <td>${good.amount}</td>
                <td>${good.type}</td>
                <td>${good.price}</td>
                <td>${good.growth}</td>
                <td>${good.yield}</td>
                <td>${good.description}</td>
                <td>${good.check}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<a href="${pageContext.request.contextPath}/toMerchantHome">返回首页</a>
</body>
</html>
