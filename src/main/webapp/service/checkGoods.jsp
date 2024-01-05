<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/1/2
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>审核商品页面</title>
</head>
<body>
<c:if test="${! empty goods}">
    <table>
        <tr>
            <th>商品名</th>
            <th>商品种类</th>
            <th>商家</th>
            <th>价格</th>
            <th>成熟周期</th>
            <th>预期收益</th>
            <th>总数</th>
            <th>描述</th>
            <th>原因</th>
            <th>审核状态</th>
        </tr>
        <c:forEach items="${goods}" var="good">
            <tr>
                <td>${good.name}</td>
                <td>${good.type}</td>
                <td>${good.merchant.name}</td>
                <td>${good.price}</td>
                <td>${good.growth}</td>
                <td>${good.yield}</td>
                <td>${good.amount}</td>
                <td>${good.description}</td>
                <%--提交商品的审核信息--%>
                <form action="">
                    <td>
                        <input type="text" name="reason">
                    </td>
                    <td>
                        <input type="submit" name="checkState" value="pass">通过
                        <input type="submit" name="checkState" value="fail">不通过
                    </td>
                </form>
            </tr>
        </c:forEach>
</table>
         <c:forEach items="${indexList}" var="index">
            <a href="${pageContext.request.contextPath}">${index}</a>
         </c:forEach>
</c:if>
</body>
</html>
