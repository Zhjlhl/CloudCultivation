<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <c:forEach items="${goods}" var="good">
            <tr>
                <td align="center">${good.name}</td>
                <td align="center">${good.amount}</td>
                <td align="center">${good.type}</td>
                <td align="center">${good.price}</td>
                <td align="center">${good.growth}</td>
                <td align="center">${good.yield}</td>
                <td align="center">${good.description}</td>
                <td align="center">${good.check}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<a href="${pageContext.request.contextPath}/toMerchantHome">返回首页</a>
</body>
</html>
