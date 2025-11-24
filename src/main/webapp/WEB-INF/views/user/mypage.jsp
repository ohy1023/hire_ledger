<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html language="ko">
  <head>
    <meta charset="UTF-8" />
    <title>내 정보</title>
    <link rel="stylesheet" href="<c:url value='/css/mypage.css'/>">
  </head>
  <body>
    <jsp:include page="/WEB-INF/views/common/header.jsp" />

    <div class="mypage-wrapper">
      <div class="my-info-container">
        <h2>내 정보</h2>

        <div class="profile-image-section">
          <div class="profile-image-wrapper">
            <c:choose>
              <c:when test="${not empty accountDto.faceUrl}">
                <img
                  src="<c:url value='${accountDto.faceUrl}'/>"
                  alt="프로필 이미지"
                  class="profile-image"
                  id="profileImage"
                />
              </c:when>
              <c:otherwise>
                <div class="profile-image-placeholder" id="profilePlaceholder">
                  👤
                </div>
              </c:otherwise>
            </c:choose>
          </div>
        </div>

        <div class="info-grid">
          <div class="info-item">
            <span class="info-label">이름</span>
            <div class="info-value">
              <c:out value="${accountDto.username}" />
            </div>
          </div>

          <div class="info-item">
            <span class="info-label">이메일</span>
            <div class="info-value"><c:out value="${accountDto.email}" /></div>
          </div>

          <div class="info-item">
            <span class="info-label">전화번호</span>
            <div class="info-value">
              <c:out value="${accountDto.formattedTel}" />
            </div>
          </div>

          <div class="info-item">
            <span class="info-label">성별</span>
            <div class="info-value"><c:out value="${accountDto.gender}" /></div>
          </div>

          <div class="info-item">
            <span class="info-label">생년월일</span>
            <div class="info-value">
              <c:out value="${accountDto.birthDate}" />
            </div>
          </div>

          <div class="info-item">
            <span class="info-label">국가</span>
            <div class="info-value">
              <c:out value="${accountDto.country}" />
            </div>
          </div>

          <div class="info-item">
            <span class="info-label">근로 유형</span>
            <div class="info-value">
              <c:out value="${accountDto.workType}" />
            </div>
          </div>

          <div class="info-item">
            <span class="info-label">가입일</span>
            <div class="info-value">
              <c:out value="${accountDto.createdAt}" />
            </div>
          </div>

          <div class="info-item">
            <span class="info-label">권한</span>
            <div class="info-value">
              <c:forEach var="role" items="${accountDto.roleTypes}">
                <span class="role-badge"><c:out value="${role}" /></span>
              </c:forEach>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="account-actions-wrapper">
        <!-- 회원정보 수정 버튼 -->
        <a href="<c:url value='/user/edit-info'/>" class="edit-btn">
            회원정보 수정
        </a>

        <!-- 계정 탈퇴 버튼 -->
        <form action="<c:url value='/user/delete-account'/>" method="post"
              onsubmit="return confirm('정말 계정을 탈퇴하시겠습니까? 복구는 불가능합니다.');">
            <button type="submit" class="delete-btn">계정 탈퇴</button>
        </form>
    </div>

  </body>
</html>
