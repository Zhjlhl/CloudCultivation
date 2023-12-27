<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>-->
<!DOCTYPE html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
    }

    #chat-container {
      width: 400px;
      margin: 50px auto;
      border: 1px solid #ccc;
      border-radius: 5px;
      overflow: hidden;
    }

    #chat-messages {
      height: 300px;
      padding: 10px;
      overflow-y: auto;
      background-color: #f4f4f4;
    }

    #chat-input {
      display: flex;
      padding: 10px;
      background-color: #fff;
    }

    #message-input {
      flex: 1;
      margin-right: 10px;
    }

    button {
      background-color: #4CAF50;
      color: #fff;
      border: none;
      padding: 10px;
      cursor: pointer;
    }

  </style>
  <title>客服聊天</title>
</head>
<body>
<div id="chat-container">
  <div id="chat-messages"></div>
  <div id="chat-input">
    <textarea id="message-input" placeholder="输入消息..."></textarea>
    <button onclick="sendMessage()">发送</button>
  </div>
</div>
<script src="script.js"></script>
</body>
</html>
