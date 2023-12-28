<%--
  Created by IntelliJ IDEA.
  User: Jiejie
  Date: 2023/12/17
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>云养殖系统</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f2f5;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
        }

        header {
            position: fixed;
            top: 0;
            width: 100%;
            background-color: #4267B2;
            color: #fff;
            padding: 10px;
            text-align: center;
        }

        nav, section, .advertisement, footer {
            width: 100%;
            box-sizing: border-box;
            margin-top: 60px;
        }

        nav {
            background-color: #3b5998;
            padding: 10px;
            color: #fff;
            text-align: center;
        }

        nav a {
            color: #fff;
            text-decoration: none;
            margin: 0 15px;
            font-size: 1.5em;
        }

        section {
            margin: 20px;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 800px;
        }

        .advertisement {
            margin-top: 20px;
            padding: 15px;
            background-color: #e9ebee;
            border-radius: 8px;
            text-align: center;
        }

        footer {
            background-color: #4267B2;
            color: #fff;
            padding: 10px;
            text-align: center;
        }
    </style>
</head>
<body>

<header>
    <h1>云养殖系统</h1>
</header>



<section>

    <div class="advertisement">
        <h2>云养殖 - 提升农业产量！</h2>
        <p>尝试我们先进的云养殖解决方案，提高作物产量，轻松享受高效农业。</p>
        <a href="#">了解更多</a>
    </div>

    <nav>
        <a href="${pageContext.request.contextPath}/toLogin">去登录</a>
    </nav>

</section>

<footer>
    &copy; 2023 云养殖公司 保留所有权利。
</footer>

</body>
</html>

