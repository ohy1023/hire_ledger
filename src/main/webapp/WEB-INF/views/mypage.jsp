<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html language="ko">
<head>
    <meta charset="UTF-8">
    <title>내 정보</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }
        .my-info-container {
            width: 350px;
            margin: 100px auto;
            padding: 30px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .my-info-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .info-item {
            margin-bottom: 10px;
        }
        .info-item span {
            font-weight: bold;
        }
    </style>
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp" />

    <div class="my-info-container">
        <h2>내정보</h2>

        <div class="info-item">
            <span>이름:</span> <c:out value="${accountDto.username}"/>
        </div>
        <div class="info-item">
            <span>이메일:</span> <c:out value="${accountDto.email}"/>
        </div>
        <div class="info-item">
            <span>전화번호:</span> <c:out value="${accountDto.formattedTel}"/>
        </div>
        <div class="info-item">
            <span>성별:</span> <c:out value="${accountDto.gender}"/>
        </div>
        <div class="info-item">
            <span>생년월일:</span> <c:out value="${accountDto.birthDate}"/>
        </div>
        <div class="info-item">
            <span>국가:</span> <c:out value="${accountDto.country}"/>
        </div>
        <div class="info-item">
            <span>근로 유형:</span> <c:out value="${accountDto.workType}"/>
        </div>
        <div class="info-item">
            <span>가입일:</span> <c:out value="${accountDto.createdAt}"/>
        </div>
        <div class="info-item">
            <span>권한:</span>
            <c:forEach var="role" items="${accountDto.roleTypes}">
                <c:out value="${role}"/>
            </c:forEach>
        </div>
    </div>
</body>
</html>
