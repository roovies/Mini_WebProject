<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/resources/css/login.css">
    <link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Fredoka+One&family=Seymour+One&display=swap" rel="stylesheet">
    <link rel="icon" href="/resources/images/icon/favicon.jpg">
    <title>댑스 : 로그인</title>
</head>
<body>
    <div class="container">
        <section id="fixed">
            <header>
                <nav id="sns">
                    <ul>
                        <li><a href="#"><img src="/resources/images/icon/icon_blog.png" alt="블로그"></a></li>
                        <li><a href="#"><img src="/resources/images/icon/icon_instgram.png" alt="인스타그램"></a></li>
                        <li><a href="#"><img src="/resources/images/icon/icon_youtube.png" alt="유튜브"></a></li>
                    </ul>
                </nav>
                <nav id="logo">
                    <a href="/"><h3>Dev's</h3></a>
                </nav>
                <nav id="login">
                    <ul>
                        <li><a href="/member/login"><b>LOGIN</b></a></li>
                        <li><a href="/member/register/step01"><b>JOIN</b></a></li>
                    </ul>
                </nav>
            </header>
            <hr>
    
            <!-- 네비게이션 -->
            <nav id="topMenu">
                <ul>
                    <li><a href="#">공지사항</a></li>
                    <li><a href="#">Q&A</a></li>
                    <li><a href="#">지식공유</a></li>
                    <li><a href="/freeboard/list">커뮤니티</a></li>
                </ul>
            </nav>
        </section>
        <!-- 헤더 -->
    
    
        <!-- 메인 -->
        <main>
            <section id="topsize"></section>
            <section id="wellcome-msg">
                    <p>LOGIN</p>
                    <p>로그인을 하시면 <span>댑스</span>의 다양한 서비스를 이용하실 수 있습니다.</p>
            </section>
            <form action="/member/login" method="POST">
                <section id="loginbox">
                    <section id="inputinfo">
                        <input type="text" name="id" placeholder="아이디 입력">
                        <input type="password" name="pwd" placeholder="패스워드 입력">
                    </section>
                    <input type="submit" value="로그인" id="login-btn">
                </section>
            </form>
            <section id="loginbox2">
                <p><input type="checkbox"> 아이디 저장</p>
                <p><a href="/member/search-id" id="searchId">아이디 찾기</a></p>
                <p><a href="/member/search-pwd" id="searchPwd">비밀번호 찾기</a></p>
            </section>
            <fieldset>
                <legend>SNS로 로그인</legend>
                <section id="login-api">
                    <a href="#"><img src="/resources/images/icon/icon_google.png" alt="구글로그인"></a>
                    <a href="#"><img src="/resources/images/icon/icon_kakao.png" alt="카카오로그인"></a>
                </section>
            </fieldset>
            <section id="joinbox">
                <p>아직 댑스 회원이 아니신가요?</p>
                <button onclick="location.href='/member/register/step01'">회원가입</button>
            </section>
        </main>

        <!-- 푸터 -->
        <footer>
            <section id="footer-menu">
                <ul>
                    <li><a href="#">회사 소개</a></li>
                    <li><a href="#">개인정보처리방침</a></li>
                    <li><a href="#">이용약관</a></li>
                    <li><a href="#">고객센터</a></li>
                </ul>
            </section>
            <section id="footer-txt">
                <ul>
                    <li>상호명: (주)댑스코리아</li>
                    <li>대표명: 이지환</li>
                    <li>문의: <a href="mailto:roovies@naver.com">roovies@naver.com</a></li>
                </ul>
            </section>
            <section id="footer-txt2">
                <ul>
                    <li>사업자등록번호: 123-45-678910</li>
                    <li>통신판매업신고번호: 제2023-서울마포-1234호</li>
                    <li>주소: 서울 마포구 마포대로 777 마포빌딩 9층</li>
                </ul>
            </section>
            <section id="copyright">
                <p>copyright ⓒ (주)댑스코리아 All rights reserved.</p>
            </section>
        </footer>
    </div>
</body>
</html>