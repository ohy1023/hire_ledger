<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html language="ko">
  <head>
    <meta charset="UTF-8" />
    <title>내 정보</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/mypage.css">
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
          <label for="profileImageInput" class="image-upload-btn">
            프로필 이미지 변경
            <input type="file" id="profileImageInput" accept="image/*" />
          </label>
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

    <script>
      document
        .getElementById('profileImageInput')
        .addEventListener('change', function (e) {
          const file = e.target.files[0];
          if (file) {
            const reader = new FileReader();
            reader.onload = function (e) {
              const placeholder = document.getElementById('profilePlaceholder');
              const existingImage = document.getElementById('profileImage');

              if (placeholder) {
                placeholder.style.display = 'none';
              }

              if (existingImage) {
                existingImage.src = e.target.result;
              } else {
                const img = document.createElement('img');
                img.id = 'profileImage';
                img.src = e.target.result;
                img.className = 'profile-image';
                img.alt = '프로필 이미지';
                document
                  .querySelector('.profile-image-wrapper')
                  .appendChild(img);
              }
            };
            reader.readAsDataURL(file);
          }
        });
    </script>
  </body>
</html>
