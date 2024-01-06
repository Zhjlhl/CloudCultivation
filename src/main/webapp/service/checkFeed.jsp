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
  <title>审核饲料页面</title>
</head>
<body>
<div>${message}</div>
<c:if test="${! empty feeds}">
  <table>
    <tr>
      <th>饲料名</th>
      <th>商家名</th>
      <th>价格</th>
      <th>总数</th>
      <th>描述</th>
      <th>原因</th>
      <th>审核状态</th>
    </tr>
    <c:forEach items="${feeds}" var="feed">
      <tr>
        <td>${feed.name}</td>
        <td>${feed.merchant.name}</td>
        <td>${feed.price}</td>
        <td>${feed.amount}</td>
        <td>${feed.description}</td>
          <%--提交饲料的审核信息--%>
        <form action="${pageContext.request.contextPath}/passFeedCheck">
          <td>
            <input type="text" name="reason">
          </td>
          <td>
            <input type="hidden" name="feedId" value="${feed.id}">
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
