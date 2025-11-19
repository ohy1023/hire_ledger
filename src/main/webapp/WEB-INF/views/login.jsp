<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f4; }
        .login-container {
            width: 350px;
            margin: 100px auto;
            padding: 30px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .login-container h2 { text-align: center; margin-bottom: 20px; }
        .login-container input[type="text"],
        .login-container input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        .login-container button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .login-container button:hover {
            background-color: #0056b3;
        }
        .error { color: red; text-align: center; margin-bottom: 10px; }
    </style>
</head>
<body>
<div class="login-container">
    <h2>로그인</h2>

<form action="<c:url value='/login'/>" method="post">
    <input type="hidden" name="secret_key" value="secret"/>
    <label>Email:</label>
    <input type="text" name="username" required/>

    <label>Password:</label>
    <input type="password" name="password" required/>

    <div class="remember-me">
            <input type="checkbox" id="remember-me" name="remember-me"/>
            <label for="remember-me">로그인 상태 유지 (14일)</label>
    </div>

    <button type="submit">Login</button>
</form>
</div>
</body>
</html>
