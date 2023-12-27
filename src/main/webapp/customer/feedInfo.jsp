<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/12/19
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>云养殖出售网站</title>
    <style>
        /* styles.css */
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
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
            max-width: 1200px;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        .product-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 20px;
            margin-top: 20px;
        }

        .product {
            border: 1px solid #ddd;
            padding: 20px;
            border-radius: 8px;
            text-align: center;
        }

        .product img {
            max-width: 100%;
            border-radius: 4px;
            margin-bottom: 10px;
        }

        h3 {
            color: #333;
        }

        p {
            color: #666;
            margin-bottom: 10px;
        }

        .view-details {
            padding: 10px 20px;
            background-color: #1877f2; /* Facebook blue */
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .view-details:hover {
            background-color: #1659a3; /* Darker shade of blue on hover */
        }
    </style>
</head>
<body>
<p>宠物信息:</p>
<p>当前饲料:</p>
<div class="container">
    <h1>云养殖饲料列表</h1>
    <div class="product-grid">
        <div class="product">
            <img src="img/feed1.jpg" alt="Product 1">
            <h3>商品名称 1</h3>
            <p>商品描述 1</p>
            <button class="view-details">查看详情</button>
        </div>
        <!-- 添加更多商品... -->
    </div>
</div>
</body>
</html>
