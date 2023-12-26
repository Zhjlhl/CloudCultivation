<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>用户注册界面</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f0f2f5;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 100%; /* 让容器宽度充满整个页面 */
            max-width: 400px; /* 设置最大宽度，以免容器过于宽大 */
        }

        h2 {
            text-align: center;
            color: #1877f2;
        }

        label {
            display: block;
            margin: 10px 0 5px;
            color: #333;
        }

        input {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            box-sizing: border-box;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        input[type="submit"], input[type="reset"] {
            background-color: #1877f2;
            color: #fff;
            cursor: pointer;
        }

        input[type="reset"] {
            background-color: #ccc;
            margin-right: 10px;
        }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/register" method="post">
    <h2>用户注册界面</h2>

    <label for="username">用户名:</label>
    <input type="text" id="username" name="username" required>

    <label for="password">密码:</label>
    <input type="password" id="password" name="password" required>

    <label for="confirmPassword">确认密码:</label>
    <input type="password" id="confirmPassword" name="confirmPassword" required>

    <input type="submit" value="注册">
    <input type="reset" value="重置">
</form>
</body>
</html>

