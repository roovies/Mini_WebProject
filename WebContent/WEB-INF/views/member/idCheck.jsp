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
    <link rel="stylesheet" href="/resources/css/idcheck.css">
    <script src="/resources/js/idcheck.js" defer></script>
</head>
<body>
    <div class="container">
        <header>
            <p>아이디 중복 확인</p>
        </header>
        <form action="/member/register/step02/id-check" method="POST">
            <main>
                <input type="text" name="id" class="input-box" placeholder="4~15자 이내로 입력해주세요" maxlength="15" value="${id }">
                <input type="submit" value="중복확인">
            </main>
        </form>
        <footer>
        <c:if test="${exist eq 'no' }">
            <p id="msg">사용 가능한 아이디입니다.</p>
            <input type="button" value="사용하기" onclick="idUse()">
        </c:if>
        <c:if test="${exist eq 'yes' }">
            <p id="msg" style='color:red'>이미 사용중인 아이디입니다.</p>
        </c:if>
        </footer>
    </div>
</body>
</html>