<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 8/26/2026
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,
initial-scale=1">
    <title>Đăng nhập</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/assets/style.css">
</head>
<body>
<main class="card login-card">
    <h1>Đăng nhập</h1>
    <p class="hint">Tài khoản demo: <strong>student</strong> /
        <strong>123456</strong></p>
    <p class="error">${error}</p>
    <form method="post"
          action="${pageContext.request.contextPath}/login">
        <label for="username">Tên đăng nhập</label>
        <input id="username" name="username" value="${username}"
               required autofocus>
        <label for="password">Mật khẩu</label>
        <input id="password" name="password" type="password"
               required>
        <button type="submit">Đăng nhập</button>
    </form>
</main>
</body>
</html>
