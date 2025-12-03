<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <title>고용주 목록</title>
    <link rel="stylesheet" href="<c:url value='/css/employer.css'/>">
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp" />

    <div class="employer-wrapper">
        <div class="employer-container">
            <h2>고용주 목록</h2>

            <c:choose>
                <c:when test="${empty employers}">
                    <div class="empty-state">
                        <p>등록된 고용주가 없습니다.</p>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="employer-grid">
                        <c:forEach var="employer" items="${employers}">
                            <div class="employer-card">
                                <div class="employer-card-header">
                                    <h3><c:out value="${employer.name}" /></h3>
                                    <span class="employer-type"><c:out value="${employer.type}" /></span>
                                </div>
                                
                                <div class="employer-card-body">
                                    <div class="info-row">
                                        <span class="info-label">전화번호</span>
                                        <span class="info-value"><c:out value="${employer.tel}" /></span>
                                    </div>
                                    
                                    <c:if test="${not empty employer.gender}">
                                        <div class="info-row">
                                            <span class="info-label">성별</span>
                                            <span class="info-value"><c:out value="${employer.gender}" /></span>
                                        </div>
                                    </c:if>
                                    
                                    <c:if test="${not empty employer.birthDate}">
                                        <div class="info-row">
                                            <span class="info-label">생년월일</span>
                                            <span class="info-value">
                                                <fmt:formatDate value="${employer.birthDate}" pattern="yyyy-MM-dd" />
                                            </span>
                                        </div>
                                    </c:if>
                                    
                                    <c:if test="${not empty employer.note}">
                                        <div class="info-row note-row">
                                            <span class="info-label">메모</span>
                                            <span class="info-value note"><c:out value="${employer.note}" /></span>
                                        </div>
                                    </c:if>
                                </div>
                                
                                <div class="employer-card-footer">
                                    <a href="<c:url value='/employers/${employer.id}'/>" class="detail-btn">상세보기</a>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</body>
</html>

