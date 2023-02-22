<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>댑스 : 회원가입</title>
    <link rel="stylesheet" href="/resources/css/emailcheck.css">
    <script src="/resources/js/emailcheck.js" defer></script>
</head>
<body>
    <div class="container">
        <header>
            <p>이메일 인증</p>
        </header>
        <form action="${url }" method="POST">
            <main>
                <input type="text" name="code" class="input-box" placeholder="인증번호를 입력하세요." maxlength="15" value="${code }">
                <input type="submit" value="확인">
            </main>
        </form>
        <footer>
		<c:if test="${result eq 'yes' }">
            <p id="msg">인증번호가 일치합니다.</p>
            <input type="button" value="인증완료" onclick="authOk()">
        </c:if>
        <c:if test="${result eq 'no' }">
            <p id="msg" style='color:red'>인증번호가 일치하지 않습니다.</p>
        </c:if>
        </footer>
    </div>
</body>
</html>