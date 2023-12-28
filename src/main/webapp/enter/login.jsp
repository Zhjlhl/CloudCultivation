<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>用户登录界面</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f2f5;
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
            max-width: 400px;
        }

        h2 {
            text-align: center;
            color: #1877f2;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            margin-bottom: 8px;
        }

        input {
            padding: 12px;
            margin-bottom: 16px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        .checkbox {
            margin-bottom: 16px;
        }

        .buttons {
            display: flex;
            justify-content: space-between;
        }

        .login-button, .reset-button {
            padding: 14px;
            background-color: #1877f2;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .login-button:hover, .reset-button:hover {
            background-color: #1659a3;
        }

        .bottom-text {
            margin-top: 20px;
            font-size: 12px;
            color: #666;
        }

        .register-link {
            margin-top: 10px;
            text-align: center;
        }

        a {
            color: #1877f2;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

    </style>
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            const urlParams = new URLSearchParams(window.location.search);
            const loginError = urlParams.get('loginError');

            if (loginError === 'true') {
                alert("登录失败，请检查用户名和密码！");
            }
        });
    </script>
</head>
<body>
<div class="container">
    <h2>用户登录界面</h2>
    <form class="login" action="${pageContext.request.contextPath}/login" method="post">
        <label for="username">用户名:</label>
        <input type="text" id="username" name="account" value="DAGetmOCPk" required ><br>

        <label for="password">密码:</label>
        <input type="password" id="password" name="password" value="GF0v7NmioG" required><br>
        <div >
            <input type="radio" id="user" name="type" value="user" required>用户
            <input type="radio" id="merchant" name="type" value="merchant" required>商家
            <input type="radio" id="service" name="type" value="service" required>客服
            <input type="radio" id="administrator" name="type" value="administrator" required>管理员
        </div>
        <div class="checkbox">
            <input type="checkbox" id="agree" name="agree" required>
            <label for="agree">已阅读并同意我们的<a href="${pageContext.request.contextPath}/toInformation">服务协议</a></label>
        </div>

        <div class="buttons">
            <input type="submit" value="登录" class="login-button">
            <input type="reset" value="重置" class="reset-button">
        </div>
    </form>

    <div class="register-link">
        还未注册? <a href="${pageContext.request.contextPath}/toRegister">请点击这里</a>.
    </div>
</div>
</body>
</html>
