<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <!-- 省略其他头部信息... -->
</head>
<body>
<div class="container">
  <h1>User Details</h1>


  <p>id:${user.id}</p>
  <p>account:${user.account}</p>
  <p>name:${user.name}</p>
  <p>Gender:${user.gender}</p>
  <p>Phone:${user.phone}</p>
  <p>zipcode:${user.zipcode}</p>
  <p>balance:${user.balance}</p>


  <!-- 添加其他用户信息... -->
</div>
</body>
</html>
