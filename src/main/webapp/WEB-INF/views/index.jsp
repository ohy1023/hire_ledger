<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <title>HireLedger 홈</title>
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

      .main-wrapper {
        flex: 1;
        display: flex;
        align-items: center;
        justify-content: center;
        padding: 60px 20px;
      }

      .welcome-container {
        max-width: 800px;
        width: 100%;
        padding: 50px;
        background: rgba(255, 255, 255, 0.95);
        border-radius: 20px;
        box-shadow: 0 10px 40px rgba(0, 0, 0, 0.2);
        backdrop-filter: blur(10px);
        text-align: center;
      }

      .welcome-container h1 {
        color: #667eea;
        font-size: 48px;
        font-weight: 700;
        margin-bottom: 20px;
        letter-spacing: -1px;
      }

      .welcome-container h2 {
        color: #333;
        font-size: 24px;
        font-weight: 500;
        margin-bottom: 30px;
      }

      .welcome-container p {
        color: #666;
        font-size: 18px;
        line-height: 1.6;
        margin-bottom: 40px;
      }

      .feature-cards {
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
        gap: 20px;
        margin-top: 40px;
      }

      .feature-card {
        padding: 30px 20px;
        background: #f8f9fa;
        border-radius: 15px;
        border-left: 4px solid #667eea;
        transition: all 0.2s ease;
      }

      .feature-card:hover {
        transform: translateY(-5px);
        box-shadow: 0 5px 20px rgba(102, 126, 234, 0.2);
      }

      .feature-card .icon {
        font-size: 40px;
        margin-bottom: 15px;
      }

      .feature-card h3 {
        color: #667eea;
        font-size: 20px;
        font-weight: 600;
        margin-bottom: 10px;
      }

      .feature-card p {
        color: #666;
        font-size: 14px;
        margin: 0;
      }

      .action-buttons {
        display: flex;
        gap: 15px;
        justify-content: center;
        margin-top: 40px;
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

      @media (max-width: 768px) {
        .welcome-container {
          padding: 30px 20px;
        }

        .welcome-container h1 {
          font-size: 36px;
        }

        .welcome-container h2 {
          font-size: 20px;
        }

        .feature-cards {
          grid-template-columns: 1fr;
        }
      }
    </style>
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp" />

    <div class="main-wrapper">
        <div class="welcome-container">
            <h1>환영합니다! 👋</h1>
            <h2>HireLedger에 오신 것을 환영합니다</h2>
            
            <sec:authorize access="isAuthenticated()">
                <p>
                    안녕하세요, <strong><sec:authentication property="principal.username" /></strong>님!<br/>
                    HireLedger를 통해 효율적으로 인사 관리를 시작하세요.
                </p>
            </sec:authorize>
            
            <sec:authorize access="!isAuthenticated()">
                <p>
                    HireLedger는 직원 관리와 인사 업무를 효율적으로 처리할 수 있는 통합 관리 시스템입니다.<br/>
                    로그인하여 다양한 기능을 이용해보세요.
                </p>
            </sec:authorize>

            <div class="feature-cards">
                <div class="feature-card">
                    <div class="icon">👥</div>
                    <h3>유저 모드</h3>
                    <p>개인 정보 관리 및 조회</p>
                </div>
                <div class="feature-card">
                    <div class="icon">👔</div>
                    <h3>매니저 모드</h3>
                    <p>팀 관리 및 업무 처리</p>
                </div>
                <div class="feature-card">
                    <div class="icon">⚙️</div>
                    <h3>관리자 모드</h3>
                    <p>시스템 전체 관리</p>
                </div>
            </div>

            <div class="action-buttons">
                <sec:authorize access="!isAuthenticated()">
                    <a href="<c:url value='/login'/>" class="btn btn-primary">로그인</a>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <a href="<c:url value='/user/my-info'/>" class="btn btn-primary">내 정보</a>
                    <a href="<c:url value='/user'/>" class="btn btn-secondary">유저 모드</a>
                </sec:authorize>
            </div>
        </div>
    </div>
</body>
</html>
