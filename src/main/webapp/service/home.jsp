<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/1/1
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/toServiceDisputeOngoing?serviceId=${service.id}">纠纷中的订单</a>
<a href="${pageContext.request.contextPath}/toCheckGoods?serviceId=${service.id}">审核商品</a>
<a href="${pageContext.request.contextPath}/toCheckFeed?serviceId=${service.id}">审核饲料</a>
</body>
</html>
