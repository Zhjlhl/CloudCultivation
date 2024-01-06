<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/12/30
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        #dataTable tr:not(:first-child):nth-child(n+31) {
            display: none;
        }

        #showMoreBtn {
            display: block;
            margin-top: 10px;
        }
        #dataTable {
            border-collapse: collapse;
            width: 100%;
        }

        #dataTable th, #dataTable td {
            border: 1px solid #ddd;
            padding: 8px;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
            max-width: 100px; /* 设置最大宽度，超过这个宽度会显示省略号 */
        }
    </style>
    <title>饲料购买页面</title>
</head>
<body>
<p>用户名：${user.name}     余额：${user.balance}</p >
<a href="${pageContext.request.contextPath}/customer/charge.jsp">充值</a><br>

<%--<c:if test="${! empty message}">
    <script>
        alert(${message})
    </script>
</c:if>--%>

<c:if test="${! empty feeds}">
<form action="${pageContext.request.contextPath}/buyFeed">
    <table  id="dataTable">
        <tr >
            <th>饲料名</th>
            <th>饲料价格</th>
            <th>商家剩余数量</th>
            <th>饲料描述</th>
            <th>选择</th>
        </tr>
        <c:forEach items="${feeds}" var="feed">
            <tr>
                <td>${feed.name}</td>
                <td>${feed.price}</td>
                <td>${feed.remain}</td>
                <td>${feed.description}</td>
                <td><input type="radio" name="feedId" value="${feed.id}">${feed.name}</td>
            </tr>
        </c:forEach>
    </table>
    <label for="quantity">购买数量</label>
    <input type="hidden" name="ordersId" value="${orders.id}">
    <input type="number" name="quantity" id="quantity">
    <input type="submit" value="提交">
    </c:if>
    <div>
        ${message}
    </div>
</body>
</html>

