<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/1/1
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改个人信息</title>
    <script>
        function checkPassword(){
            var password=document.getElementById(password)
            var rePassword=document.getElementById(rePassword)
            if(rePassword==password){
                window.location.href="填写地址"
            }
            else{
                alert("两次密码不一样，请重新输入!")
            }
        }
    </script>
</head>
<body>
<form onsubmit="checkPassword()">
    <label for="name">用户名:</label>
    <input type="text" id="name" name="name" value="${sessionScope.merchant.name}">
    <label for="contacts">简介:</label>
    <input type="text" id="contacts" name="contacts" value="${sessionScope.merchant.contacts}">
    <label for="contacts">法人代表:</label>
    <input type="text" id="description" name="description" value="${sessionScope.merchant.description}">
    <label for="phone">联系电话:</label>
    <input type="text" id="phone" name="phone" value="${sessionScope.merchant.phone}">
    <label for="password">密码:</label>
    <input type="password" id="password" name="password">
    <label for="rePassword">重复密码:</label>
    <input type="password" id="rePassword" name="rePassword">
    <input type="submit" value="提交">
</form>
</body>
</html>
