<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
    <link rel="stylesheet" href="/css/registerAccount.css">
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp" />

    <div class="register-container">
        <h2>회원가입</h2>

        <div id="messageArea"></div>

        <form id="registerForm">
            <input type="email" name="email" id="email" placeholder="이메일" required />
            <input type="password" name="password" id="password" placeholder="비밀번호" required />
            <input type="text" name="username" id="username" placeholder="이름" required />
            <input type="text" name="tel" id="tel" placeholder="전화번호 (예: 01012345678)" />

            <select name="gender" id="gender">
                <option value="">성별 선택</option>
                <option value="MALE">남성</option>
                <option value="FEMALE">여성</option>
            </select>

            <input type="date" name="birthDate" id="birthDate" placeholder="생년월일" />
            <input type="text" name="country" id="country" placeholder="국적" />
            <input type="text" name="university" id="university" placeholder="대학명" />

            <select name="workType" id="workType">
                <option value="">근로 유형 선택</option>
                <option value="FULL_TIME">정규직</option>
                <option value="PART_TIME">파트타임</option>
                <option value="CONTRACT">계약직</option>
                <option value="INTERN">인턴</option>
                <option value="FREELANCER">프리랜서</option>
            </select>

            <input type="text" name="zipcode" id="zipcode" placeholder="우편번호" />
            <input type="text" name="address" id="address" placeholder="기본 주소" />
            <input type="text" name="addressDetail" id="addressDetail" placeholder="상세 주소" />

            <label>권한 선택:</label>
            <div class="role-box">
                <label><input type="checkbox" name="roleTypes" value="USER"> USER</label>
                <label><input type="checkbox" name="roleTypes" value="MANAGER"> MANAGER</label>
                <label><input type="checkbox" name="roleTypes" value="ADMIN"> ADMIN</label>
            </div>

            <button type="submit" id="submitBtn">회원가입</button>
        </form>
    </div>
    <script src="/js/registerAccount.js"></script>
</body>
</html>