<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html language="ko">
  <head>
    <meta charset="UTF-8" />
    <title>내 정보</title>
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

      .mypage-wrapper {
        flex: 1;
        display: flex;
        align-items: center;
        justify-content: center;
        padding: 40px 20px;
      }

      .my-info-container {
        width: 500px;
        padding: 40px;
        background: rgba(255, 255, 255, 0.95);
        border-radius: 20px;
        box-shadow: 0 10px 40px rgba(0, 0, 0, 0.2);
        backdrop-filter: blur(10px);
      }

      .my-info-container h2 {
        text-align: center;
        margin-bottom: 30px;
        color: #667eea;
        font-size: 32px;
        font-weight: 700;
        letter-spacing: -0.5px;
      }

      .profile-image-section {
        text-align: center;
        margin-bottom: 30px;
        padding-bottom: 30px;
        border-bottom: 2px solid #f0f0f0;
      }

      .profile-image-wrapper {
        position: relative;
        display: inline-block;
        margin-bottom: 15px;
      }

      .profile-image {
        width: 150px;
        height: 150px;
        border-radius: 50%;
        object-fit: cover;
        border: 4px solid #667eea;
        box-shadow: 0 4px 15px rgba(102, 126, 234, 0.3);
        background: #f0f0f0;
      }

      .profile-image-placeholder {
        width: 150px;
        height: 150px;
        border-radius: 50%;
        background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
        display: flex;
        align-items: center;
        justify-content: center;
        color: white;
        font-size: 48px;
        border: 4px solid #667eea;
        box-shadow: 0 4px 15px rgba(102, 126, 234, 0.3);
        margin: 0 auto;
      }

      .image-upload-btn {
        display: inline-block;
        padding: 10px 20px;
        background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
        color: white;
        border: none;
        border-radius: 12px;
        cursor: pointer;
        font-size: 14px;
        font-weight: 600;
        transition: all 0.2s ease;
        box-shadow: 0 4px 15px rgba(102, 126, 234, 0.3);
      }

      .image-upload-btn:hover {
        transform: translateY(-2px);
        box-shadow: 0 6px 20px rgba(102, 126, 234, 0.4);
      }

      .image-upload-btn input[type='file'] {
        display: none;
      }

      .info-grid {
        display: grid;
        gap: 20px;
      }

      .info-item {
        padding: 15px;
        background: #f8f9fa;
        border-radius: 12px;
        border-left: 4px solid #667eea;
        transition: all 0.2s ease;
      }

      .info-item:hover {
        background: #f0f0f0;
        transform: translateX(5px);
      }

      .info-label {
        font-weight: 600;
        color: #667eea;
        font-size: 14px;
        margin-bottom: 5px;
        display: block;
      }

      .info-value {
        color: #333;
        font-size: 15px;
        word-break: break-word;
      }

      .role-badge {
        display: inline-block;
        padding: 4px 12px;
        background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
        color: white;
        border-radius: 20px;
        font-size: 12px;
        font-weight: 600;
        margin-right: 5px;
        margin-top: 5px;
      }

      @media (max-width: 600px) {
        .my-info-container {
          width: 100%;
          padding: 30px 20px;
        }

        .my-info-container h2 {
          font-size: 28px;
        }

        .profile-image,
        .profile-image-placeholder {
          width: 120px;
          height: 120px;
        }
      }
    </style>
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
