<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <%@
taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib
prefix="sec" uri="http://www.springframework.org/security/tags" %>

<link rel="stylesheet" href="/css/header.css">

<header class="header">
  <div class="header-container">
    <a href="<c:url value='/'/>" class="logo">HireLedger</a>

    <nav>
      <ul class="nav-menu">
        <!-- 모든 권한에게 유저모드 표시 -->
        <sec:authorize access="hasAnyRole('USER', 'MANAGER', 'ADMIN')">
          <li><a href="<c:url value='/user'/>">유저모드</a></li>
        </sec:authorize>

        <!-- MANAGER와 ADMIN에게 매니저모드 표시 -->
        <sec:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
          <li><a href="<c:url value='/manager'/>">매니저모드</a></li>
        </sec:authorize>

        <!-- ADMIN에게만 관리자모드 표시 -->
        <sec:authorize access="hasRole('ADMIN')">
          <li><a href="<c:url value='/admin'/>">관리자모드</a></li>
        </sec:authorize>

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