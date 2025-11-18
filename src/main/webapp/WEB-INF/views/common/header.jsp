<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    .header {
        background-color: #2c3e50;
        padding: 15px 0;
        box-shadow: 0 2px 5px rgba(0,0,0,0.1);
    }

    .header-container {
        max-width: 1200px;
        margin: 0 auto;
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 0 20px;
    }

    .logo {
        color: #ecf0f1;
        font-size: 24px;
        font-weight: bold;
        text-decoration: none;
    }

    .logo:hover {
        color: #3498db;
    }

    .nav-menu {
        display: flex;
        list-style: none;
        gap: 20px;
        align-items: center;
    }

    .nav-menu li a,
    .nav-menu li button {
        color: #ecf0f1;
        text-decoration: none;
        padding: 8px 15px;
        border-radius: 5px;
        transition: background-color 0.3s;
        border: none;
        background: none;
        cursor: pointer;
        font-size: 14px;
    }

    .nav-menu li a:hover,
    .nav-menu li button:hover {
        background-color: #34495e;
    }

    .nav-menu li a.active {
        background-color: #3498db;
    }

    .user-info {
        color: #ecf0f1;
        padding: 8px 15px;
        background-color: #34495e;
        border-radius: 5px;
        font-size: 14px;
    }

    .logout-form {
        display: inline;
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
                        <span class="user-info">
                            <sec:authentication property="principal.username"/>님
                        </span>
                    </li>
                    <li>
                        <form action="<c:url value='/logout'/>" method="post" class="logout-form">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <button type="submit">로그아웃</button>
                        </form>
                    </li>
                </sec:authorize>

                <sec:authorize access="!isAuthenticated()">
                    <li><a href="<c:url value='/login'/>">로그인</a></li>
                    <li><a href="<c:url value='/register'/>">회원가입</a></li>
                </sec:authorize>
            </ul>
        </nav>
    </div>
</header>
