<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/12/19
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>云养殖出售网站</title>
    <style>
        /* styles.css */
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        .container {
            background-color: #fff;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 80%;
            max-width: 1200px;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        .product-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 20px;
            margin-top: 20px;
        }

        .product {
            border: 1px solid #ddd;
            padding: 20px;
            border-radius: 8px;
            text-align: center;
        }

        .product img {
            max-width: 100%;
            border-radius: 4px;
            margin-bottom: 10px;
        }

        h3 {
            color: #333;
        }

        p {
            color: #666;
            margin-bottom: 10px;
        }

        .view-details {
            padding: 10px 20px;
            background-color: #4267b2;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .view-details:hover {
            background-color: #4267b2;
        }
    </style>
</head>
<body>
<p>用户名：${user.name}     余额：${user.balance}</p >
<a href="${pageContext.request.contextPath}/customer/charge.jsp">充值</a><br>
<a href="${pageContext.request.contextPath}/toUserHome">返回首页</a><br>
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
