<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2024/1/1
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改信息页面</title>
    <script>
        function checkPassword(){
            var password=document.getElementById("password")
            var rePassword=document.getElementById("rePassword")
            if(rePassword.value===password.value){
                alert("确定修改密码："+password.value)
                return true;
            }
            else{
                alert("两次密码不一样，请重新输入!")
                document.getElementById('password').value = "";
                document.getElementById('rePassword').value = "";
                return false;
            }
        }
    </script>
</head>
<body>
<form onsubmit="return checkPassword()" action="${pageContext.request.contextPath}/updateSelfInfo">
    <label for="name">用户名:</label>
    <input type="text" id="name" name="name" value="${sessionScope.user.name}"><br>
    <label for="phone">联系电话:</label>
    <input type="text" id="phone" name="phone" value="${sessionScope.user.phone}"><br>
    <label for="gender">性别:</label>
    <input type="text" id="gender" name="gender" value="${sessionScope.user.gender}"><br>
    <label for="zipcode">邮编地址:</label>
    <input type="text" id="zipcode" name="zipcode" value="${sessionScope.user.zipcode}"><br>
    <label for="password">密码:</label>
    <input type="password" id="password" name="password" required><br>
    <label for="rePassword">重复密码:</label>
    <input type="password" id="rePassword" name="rePassword" required><br>
    <input type="hidden" name="userId" id="userId" value="${user.id}">
    <input type="submit" value="提交">
</form>
</body>
</html>
