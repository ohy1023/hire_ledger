<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>에러 발생</title>
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp" />
    <h1>에러 페이지</h1>
    <p>${errorMessage}</p>
    <a href="/">홈으로</a>
</body>
</html>