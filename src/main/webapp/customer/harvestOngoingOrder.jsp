<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/12/19
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>收获中订单</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f0f2f5;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        table {
            border-collapse: collapse;
            width: 80%;
            margin: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        th, td {
            padding: 15px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #4267b2;
            color: #fff;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        button {
            background-color: #4267b2;
            color: #fff;
            border: none;
            padding: 8px 16px;
            cursor: pointer;
            border-radius: 4px;
        }

        #popup-container {
            display: none;
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        a {
            color: #4267b2;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
    <script>
        function showPopup() {
            var popupContainer = document.getElementById('popup-container');
            popupContainer.style.display = 'block';
        }

        function hidePopup() {
            var popupContainer = document.getElementById('popup-container');
            popupContainer.style.display = 'none';
        }
    </script>
</head>
<body>
<%--
如果状态是已发货，则设置按钮显示物流信息
--%>
<table>
    <tr>
        <th>单号</th>
        <th>收获日期</th>
        <th>收货方式</th>
        <th>收益</th>
        <th>状态</th>
        <th>申请售后</th>
    </tr>
    <c:if test="${!empty harvests}">
        <c:forEach items="${harvests}" var="harvest" varStatus="st">
            <tr>
                <td align="center">${harvest.orders.id}</td>
                <td align="center">${harvest.date}</td>
                <td align="center">${harvest.way}</td>
                <td align="center">${harvest.earnings}</td>
                <td align="center">
                    <c:choose>
                        <c:when test="${harvest.state eq '已发货'}">
                            <button onclick="showPopup()">已发货</button>
                            <div id="popup-container">
                                <p>已发货，物流公司：${harvest.delivery}</p>
                                <button onclick="hidePopup()">关闭</button>
                            </div>
                        </c:when>
                        <c:otherwise>
                            ${harvest.state}
                        </c:otherwise>
                    </c:choose>
                </td>
                <td> <a href="${pageContext.request.contextPath}/toApplyForAfterSaleService?harvestId=${harvest.id}">申请售后</a></td>
            </tr>
        </c:forEach>
    </c:if>
</table>

</body>
</html>
