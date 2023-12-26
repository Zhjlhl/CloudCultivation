<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>云养殖网站用户协议</title>
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
      max-width: 800px;
    }

    h2, h3 {
      color: #333;
    }

    p {
      line-height: 1.6;
      color: #666;
    }

    .bottom-text {
      margin-top: 20px;
      font-size: 12px;
      color: #888;
      text-align: right;
    }
    .back-to-login {
      margin-top: 20px;
      text-align: center;
    }

    .back-to-login a {
      display: inline-block;
      padding: 10px 20px;
      background-color: #1877f2; /* Facebook blue */
      color: #fff;
      text-decoration: none;
      border-radius: 5px;
      transition: background-color 0.3s;
    }

    .back-to-login a:hover {
      background-color: #1659a3;
    }
  </style>
</head>
<body>
<div class="container">
  <h2>云养殖网站用户协议</h2>

  <p>欢迎使用云养殖网站服务。在使用本服务之前，请您仔细阅读并理解本协议的所有内容。如果您不同意本协议的任何内容，请停止使用本服务。</p>

  <h3>一、服务内容</h3>
  <p>云养殖网站提供的服务包括但不限于养殖信息查询、社交互动、在线购买等。我们将尽最大努力提供稳定、安全的服务，保障您的使用体验。</p>

  <h3>二、用户账号</h3>
  <p>您在使用云养殖网站服务时需注册用户账号。请妥善保管账号和密码，不得将其提供给他人使用。您应对在账号下的所有活动负责。</p>

  <h3>三、协议修改和通知</h3>
  <p>云养殖网站有权随时修改本协议的任何内容，并通过网站公示生效。变更后的协议一经公布即视为您已接受。云养殖网站将通过网站通知、站内信等方式告知用户重要变更。</p>

  <p>感谢您阅读云养殖网站用户协议。如有任何疑问，请联系我们的客服。</p>

  <div class="bottom-text">
    <p>最后更新日期：2023年12月01日</p>
  </div>
  <div class="back-to-login">
    <a href="${pageContext.request.contextPath}/toLogin">返回登录界面</a>
  </div>
</div>
</body>
</html>

