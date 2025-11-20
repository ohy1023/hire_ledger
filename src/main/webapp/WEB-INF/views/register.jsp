<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f4; }
        .register-container {
            width: 400px;
            margin: 80px auto;
            padding: 30px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .register-container h2 { text-align: center; margin-bottom: 20px; }
        .register-container input[type="text"],
        .register-container input[type="email"],
        .register-container input[type="password"],
        .register-container input[type="date"],
        .register-container select {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        .register-container button {
            width: 100%;
            padding: 10px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .register-container button:hover {
            background-color: #218838;
        }
        .error { color: red; text-align: center; margin-bottom: 10px; }
        .success { color: green; text-align: center; margin-bottom: 10px; }
    </style>
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp" />
<div class="register-container">
    <h2>회원가입</h2>

    <form action="${pageContext.request.contextPath}/admin/register" method="post">
        <input type="email" name="email" placeholder="이메일" required />
        <input type="password" name="password" placeholder="비밀번호" required />
        <input type="text" name="username" placeholder="이름" required />
        <input type="text" name="tel" placeholder="전화번호 (예: 010-1234-5678)" />
        <select name="gender">
            <option value="">성별 선택</option>
            <option value="MALE">남성</option>
            <option value="FEMALE">여성</option>
        </select>
        <input type="date" name="birthDate" placeholder="생년월일" />
        <input type="text" name="country" placeholder="국적" />
        <input type="text" name="university" placeholder="대학명" />
        <select name="workType">
            <option value="">근로 유형 선택</option>
            <option value="FULL_TIME">정규직</option>
            <option value="PART_TIME">파트타임</option>
            <option value="CONTRACT">계약직</option>
            <option value="INTERN">인턴</option>
            <option value="FREELANCER">프리랜서</option>
        </select>

        <input type="text" name="zipcode" placeholder="우편번호" />
        <input type="text" name="address" placeholder="기본 주소" />
        <input type="text" name="addressDetail" placeholder="상세 주소" />

        <label>권한 선택:</label>
        <div class="role-box">
        <label><input type="checkbox" name="roleTypes" value="USER"> USER</label>
        <label><input type="checkbox" name="roleTypes" value="MANAGER"> MANAGER</label>
        <label><input type="checkbox" name="roleTypes" value="ADMIN"> ADMIN</label>
        </div>

        <button type="submit">회원가입</button>
    </form>
</div>
</body>
</html>
