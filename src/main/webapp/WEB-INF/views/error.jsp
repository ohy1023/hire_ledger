<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <title>에러 발생</title>
    <link rel="stylesheet" href="/css/error.css">
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