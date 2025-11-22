<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <title>에러 발생</title>
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

      .error-wrapper {
        flex: 1;
        display: flex;
        align-items: center;
        justify-content: center;
        padding: 40px 20px;
      }

      .error-container {
        max-width: 600px;
        width: 100%;
        padding: 50px;
        background: rgba(255, 255, 255, 0.95);
        border-radius: 20px;
        box-shadow: 0 10px 40px rgba(0, 0, 0, 0.2);
        backdrop-filter: blur(10px);
        text-align: center;
      }

      .error-icon {
        font-size: 120px;
        margin-bottom: 30px;
        animation: shake 0.5s ease-in-out;
      }

      @keyframes shake {
        0%, 100% { transform: translateX(0); }
        25% { transform: translateX(-10px); }
        75% { transform: translateX(10px); }
      }

      .error-container h1 {
        color: #e74c3c;
        font-size: 48px;
        font-weight: 700;
        margin-bottom: 20px;
        letter-spacing: -1px;
      }

      .error-container h2 {
        color: #333;
        font-size: 24px;
        font-weight: 500;
        margin-bottom: 30px;
      }

      .error-message {
        padding: 20px;
        background: rgba(231, 76, 60, 0.1);
        border-left: 4px solid #e74c3c;
        border-radius: 12px;
        margin-bottom: 40px;
        color: #c0392b;
        font-size: 16px;
        line-height: 1.6;
        word-break: break-word;
      }

      .error-actions {
        display: flex;
        gap: 15px;
        justify-content: center;
        flex-wrap: wrap;
      }

      .btn {
        padding: 14px 30px;
        border: none;
        border-radius: 12px;
        font-size: 16px;
        font-weight: 600;
        cursor: pointer;
        transition: all 0.2s ease;
        text-decoration: none;
        display: inline-block;
      }

      .btn-primary {
        background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
        color: white;
        box-shadow: 0 4px 15px rgba(102, 126, 234, 0.3);
      }

      .btn-primary:hover {
        transform: translateY(-2px);
        box-shadow: 0 6px 20px rgba(102, 126, 234, 0.4);
      }

      .btn-secondary {
        background: rgba(255, 255, 255, 0.9);
        color: #667eea;
        border: 2px solid #667eea;
      }

      .btn-secondary:hover {
        background: #667eea;
        color: white;
      }

      @media (max-width: 600px) {
        .error-container {
          padding: 30px 20px;
        }

        .error-icon {
          font-size: 80px;
        }

        .error-container h1 {
          font-size: 36px;
        }

        .error-container h2 {
          font-size: 20px;
        }
      }
    </style>
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp" />
    
    <div class="error-wrapper">
        <div class="error-container">
            <div class="error-icon">⚠️</div>
            <h1>오류 발생</h1>
            <h2>문제가 발생했습니다</h2>
            
            <div class="error-message">
                <c:choose>
                    <c:when test="${not empty errorMessage}">
                        ${errorMessage}
                    </c:when>
                    <c:otherwise>
                        요청하신 페이지를 처리하는 중 오류가 발생했습니다.<br/>
                        잠시 후 다시 시도해주세요.
                    </c:otherwise>
                </c:choose>
            </div>

            <div class="error-actions">
                <a href="<c:url value='/'/>" class="btn btn-primary">홈으로 돌아가기</a>
                <a href="javascript:history.back()" class="btn btn-secondary">이전 페이지</a>
            </div>
        </div>
    </div>
</body>
</html>