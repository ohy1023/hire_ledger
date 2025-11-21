<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <%@
taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib
prefix="sec" uri="http://www.springframework.org/security/tags" %>

<style>
  * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
  }

  .header {
    background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
    padding: 18px 0;
    box-shadow: 0 4px 20px rgba(0, 0, 0, 0.15);
    position: sticky;
    top: 0;
    z-index: 1000;
    backdrop-filter: blur(10px);
  }

  .header-container {
    max-width: 1200px;
    margin: 0 auto;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 0 30px;
  }

  .logo {
    color: #ffffff;
    font-size: 28px;
    font-weight: 700;
    text-decoration: none;
    letter-spacing: 1px;
    display: flex;
    align-items: center;
    transition: color 0.2s ease;
    text-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
  }

  .logo:hover {
    color: #ffd700;
  }

  .logo::before {
    content: '📊';
    margin-right: 8px;
    font-size: 24px;
  }

  .nav-menu {
    display: flex;
    list-style: none;
    gap: 8px;
    align-items: center;
    flex-wrap: wrap;
  }

  .nav-menu li a,
  .nav-menu li button {
    color: #ffffff;
    text-decoration: none;
    padding: 10px 18px;
    border-radius: 25px;
    transition: background-color 0.2s ease;
    border: none;
    background: rgba(255, 255, 255, 0.1);
    cursor: pointer;
    font-size: 14px;
    font-weight: 500;
    backdrop-filter: blur(5px);
  }

  .nav-menu li a:hover,
  .nav-menu li button:hover {
    background: rgba(255, 255, 255, 0.25);
  }

  .nav-menu li a.active {
    background: rgba(255, 255, 255, 0.3);
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.2);
    font-weight: 600;
  }

  .user-info {
    color: #ffffff;
    padding: 10px 20px;
    background: rgba(255, 215, 0, 0.2);
    border-radius: 25px;
    font-size: 14px;
    font-weight: 600;
    border: 2px solid rgba(255, 215, 0, 0.3);
    transition: background-color 0.2s ease;
    display: inline-block;
  }

  .user-info:hover {
    background: rgba(255, 215, 0, 0.3);
  }

  .logout-form {
    display: inline;
  }

  .logout-form button {
    background: rgba(255, 77, 77, 0.2) !important;
    border: 2px solid rgba(255, 77, 77, 0.4) !important;
  }

  .logout-form button:hover {
    background: rgba(255, 77, 77, 0.4) !important;
    border-color: rgba(255, 77, 77, 0.6) !important;
  }

  @media (max-width: 768px) {
    .header-container {
      padding: 0 15px;
      flex-direction: column;
      gap: 15px;
    }

    .logo {
      font-size: 24px;
    }

    .nav-menu {
      gap: 5px;
      justify-content: center;
    }

    .nav-menu li a,
    .nav-menu li button {
      padding: 8px 12px;
      font-size: 12px;
    }
  }
</style>

<header class="header">
  <div class="header-container">
    <a href="<c:url value='/'/>" class="logo">HireLedger</a>

    <nav>
      <ul class="nav-menu">
        <li><a href="<c:url value='/user'/>">유저모드</a></li>
        <li><a href="<c:url value='/manager'/>">매니저모드</a></li>
        <li><a href="<c:url value='/admin'/>">관리자모드</a></li>

        <sec:authorize access="isAuthenticated()">
          <li>
            <a href="<c:url value='/user/my-info'/>" class="user-info">
              <sec:authentication property="principal.username" />님
            </a>
          </li>
          <li>
            <form
              action="<c:url value='/logout'/>"
              method="post"
              class="logout-form"
            >
              <input
                type="hidden"
                name="${_csrf.parameterName}"
                value="${_csrf.token}"
              />
              <button type="submit">로그아웃</button>
            </form>
          </li>
        </sec:authorize>

        <sec:authorize access="hasRole('ADMIN')">
          <li><a href="<c:url value='/admin/register'/>">회원가입</a></li>
        </sec:authorize>

        <sec:authorize access="!isAuthenticated()">
          <li><a href="<c:url value='/login'/>">로그인</a></li>
        </sec:authorize>
      </ul>
    </nav>
  </div>
</header>
