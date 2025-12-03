<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <title>고용주 상세 정보</title>
    <link rel="stylesheet" href="<c:url value='/css/employer.css'/>">
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp" />

    <div class="employer-wrapper">
        <div class="employer-detail-container">
            <div class="detail-header">
                <h2>고용주 상세 정보</h2>
                <a href="<c:url value='/employers'/>" class="back-btn">목록으로</a>
            </div>

            <div class="detail-content">
                <div class="detail-section">
                    <h3>기본 정보</h3>
                    <div class="info-grid">
                        <div class="info-item">
                            <span class="info-label">이름</span>
                            <div class="info-value"><c:out value="${employer.name}" /></div>
                        </div>

                        <c:if test="${not empty employer.birthDate}">
                            <div class="info-item">
                                <span class="info-label">생년월일</span>
                                <div class="info-value">
                                    <fmt:formatDate value="${employer.birthDate}" pattern="yyyy년 MM월 dd일" />
                                </div>
                            </div>
                        </c:if>

                        <div class="info-item">
                            <span class="info-label">전화번호</span>
                            <div class="info-value"><c:out value="${employer.tel}" /></div>
                        </div>

                        <c:if test="${not empty employer.gender}">
                            <div class="info-item">
                                <span class="info-label">성별</span>
                                <div class="info-value"><c:out value="${employer.gender}" /></div>
                            </div>
                        </c:if>

                        <div class="info-item">
                            <span class="info-label">고용주 유형</span>
                            <div class="info-value"><c:out value="${employer.type}" /></div>
                        </div>
                    </div>
                </div>

                <c:if test="${not empty address}">
                    <div class="detail-section">
                        <h3>주소 정보</h3>
                        <div class="info-grid">
                            <div class="info-item">
                                <span class="info-label">우편번호</span>
                                <div class="info-value"><c:out value="${address.zipcode}" /></div>
                            </div>

                            <div class="info-item">
                                <span class="info-label">주소</span>
                                <div class="info-value"><c:out value="${address.address}" /></div>
                            </div>

                            <c:if test="${not empty address.addressDetail}">
                                <div class="info-item">
                                    <span class="info-label">상세주소</span>
                                    <div class="info-value"><c:out value="${address.addressDetail}" /></div>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </c:if>

                <c:if test="${not empty employer.note}">
                    <div class="detail-section">
                        <h3>메모</h3>
                        <div class="note-content">
                            <p><c:out value="${employer.note}" /></p>
                        </div>
                    </div>
                </c:if>

                <div class="detail-section">
                    <h3>등록 정보</h3>
                    <div class="info-grid">
                        <c:if test="${not empty employer.createdAt}">
                            <div class="info-item">
                                <span class="info-label">등록일</span>
                                <div class="info-value">
                                    <fmt:formatDate value="${employer.createdAt}" pattern="yyyy-MM-dd HH:mm:ss" />
                                </div>
                            </div>
                        </c:if>

                        <c:if test="${not empty employer.updatedAt}">
                            <div class="info-item">
                                <span class="info-label">수정일</span>
                                <div class="info-value">
                                    <fmt:formatDate value="${employer.updatedAt}" pattern="yyyy-MM-dd HH:mm:ss" />
                                </div>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

