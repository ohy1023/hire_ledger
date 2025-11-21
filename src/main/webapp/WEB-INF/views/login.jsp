<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib
prefix="form" uri="http://www.springframework.org/tags/form" %> <%@ page
contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <title>로그인</title>
    <style>
      body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
        margin: 0;
        padding: 0;
        min-height: 100vh;
        display: flex;
        flex-direction: column;
      }

      .login-wrapper {
        flex: 1;
        display: flex;
        align-items: center;
        justify-content: center;
        padding: 40px 20px;
      }

      .login-container {
        width: 420px;
        padding: 40px;
        background: rgba(255, 255, 255, 0.95);
        border-radius: 20px;
        box-shadow: 0 10px 40px rgba(0, 0, 0, 0.2);
        backdrop-filter: blur(10px);
      }

      .login-container h2 {
        text-align: center;
        margin-bottom: 30px;
        color: #667eea;
        font-size: 32px;
        font-weight: 700;
        letter-spacing: -0.5px;
      }

      .form-group {
        margin-bottom: 20px;
      }

      .login-container label {
        display: block;
        margin-bottom: 8px;
        font-weight: 600;
        color: #333;
        font-size: 14px;
      }

      .login-container input[type='text'],
      .login-container input[type='password'] {
        width: 100%;
        padding: 14px 16px;
        margin-bottom: 0;
        border-radius: 12px;
        border: 2px solid #e0e0e0;
        font-size: 15px;
        transition: all 0.2s ease;
        box-sizing: border-box;
      }

      .login-container input[type='text']:focus,
      .login-container input[type='password']:focus {
        outline: none;
        border-color: #667eea;
        box-shadow: 0 0 0 3px rgba(102, 126, 234, 0.1);
      }

      .login-container button {
        width: 100%;
        padding: 14px;
        background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
        color: white;
        border: none;
        border-radius: 12px;
        cursor: pointer;
        font-size: 16px;
        font-weight: 600;
        transition: all 0.2s ease;
        margin-top: 10px;
        box-shadow: 0 4px 15px rgba(102, 126, 234, 0.3);
      }

      .login-container button:hover {
        transform: translateY(-2px);
        box-shadow: 0 6px 20px rgba(102, 126, 234, 0.4);
      }

      .login-container button:active {
        transform: translateY(0);
      }

      .error {
        color: #e74c3c;
        text-align: center;
        margin-bottom: 15px;
        padding: 12px;
        background: rgba(231, 76, 60, 0.1);
        border-radius: 8px;
        font-size: 14px;
      }

      .remember-me {
        display: flex;
        align-items: center;
        margin-bottom: 20px;
        gap: 10px;
      }

      .remember-me input[type='checkbox'] {
        width: 18px;
        height: 18px;
        margin: 0;
        cursor: pointer;
        accent-color: #667eea;
      }

      .remember-me label {
        margin: 0;
        font-size: 14px;
        font-weight: 500;
        color: #666;
        cursor: pointer;
      }

      @media (max-width: 480px) {
        .login-container {
          width: 100%;
          padding: 30px 20px;
        }

        .login-container h2 {
          font-size: 28px;
        }
      }
    </style>
  </head>
  <body>
    <jsp:include page="/WEB-INF/views/common/header.jsp" />
    <div class="login-wrapper">
      <div class="login-container">
        <h2>로그인</h2>

        <form action="<c:url value='/login'/>" method="post">
          <div class="form-group">
            <label for="username">이메일</label>
            <input
              type="text"
              id="username"
              name="username"
              placeholder="이메일을 입력하세요"
              required
            />
          </div>

          <div class="form-group">
            <label for="password">비밀번호</label>
            <input
              type="password"
              id="password"
              name="password"
              placeholder="비밀번호를 입력하세요"
              required
            />
          </div>

          <div class="remember-me">
            <input type="checkbox" id="remember-me" name="remember-me" />
            <label for="remember-me">로그인 상태 유지 (14일)</label>
          </div>

          <button type="submit">로그인</button>
        </form>
      </div>
    </div>
  </body>
</html>
