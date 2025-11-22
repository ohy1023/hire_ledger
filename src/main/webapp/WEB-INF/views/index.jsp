<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <title>HireLedger 홈</title>
    <link rel="stylesheet" href="/css/index.css">
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
                    HireLedger는 직업 소개소 직원이 근로자와 고용주를 연결하고, 고용관계와 수수료를 체계적으로 관리할 수 있는 웹 기반 고용 관리 시스템입니다.<br/>
                    소개소 직원은 근로자가 원하는 일자리에 맞춰 회사, 공장, 가정집 등 고용주와 연락을 주선하고 면접을 조율합니다.<br/>
                    고용관계가 성립되면, 근로자와 고용주로부터 수수료를 받고 이를 기록 및 관리할 수 있습니다.<br/>
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
