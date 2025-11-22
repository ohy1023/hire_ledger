<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib
prefix="form" uri="http://www.springframework.org/tags/form" %> <%@ page
contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <title>로그인</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
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
