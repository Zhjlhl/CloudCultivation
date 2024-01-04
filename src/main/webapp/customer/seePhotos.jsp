<%--
  Created by IntelliJ IDEA.
  User: Jiejie
  Date: 2024/1/4
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>查看图片</title>
</head>
<body>
<c:forEach items="feedings" var="feeding">
    <img src="/seePhoto/${feeding.photo}" alt="图片">

</c:forEach> 
</body>
</html>
