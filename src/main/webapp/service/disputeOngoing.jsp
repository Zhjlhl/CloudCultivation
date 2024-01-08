<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/1/1
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>纠纷中订单</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/toServiceUncheck?serviceId=${service.id}">未审核订单</a>
<c:if test="${! empty disputes}">
  <table>
      <tr>
          <th>订单id</th>
          <th>用户id</th>
          <th>商家id</th>
          <th>涉及金额</th>
          <th>描述</th>
          <th>状态</th>
          <th>纠纷类型</th>
          <th>开始时间</th>
          <th>审核状态</th>
      </tr>
      <c:forEach items="${disputes}" var="dispute">
          <tr>
              <td>${dispute.orders.id}</td>
              <td>${dispute.orders.user.id}</td>
              <td>${dispute.orders.merchant.id}</td>
              <td>${dispute.amount}</td>
              <td>${dispute.description}</td>
              <td>${dispute.state}</td>
              <td>${dispute.type}</td>
              <td>${dispute.date}</td>
              <c:if test="${dispute.check == '未审核'}">
                  <td>
                      <a href="${pageContext.request.contextPath}/toCheck?disputeId=${dispute.id}&serviceId=${service.id}">去审核</a>
                  </td>
              </c:if>
              <c:if test="${dispute.check=='已审核'}">
                  <td>
                      ${dispute.check}
                  </td>
              </c:if>
          </tr>
      </c:forEach>
  </table>
        <c:forEach items="${indexList}" var="index">
            <a href="${pageContext.request.contextPath}">${index}</a>
        </c:forEach>
</c:if>
<a href="${pageContext.request.contextPath}/toServiceHome">返回主页</a>
</body>
</html>
