<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Fredoka+One&family=Seymour+One&display=swap" rel="stylesheet">
    <link rel="icon" href="/resources/images/icon/favicon.jpg">
    <link rel="stylesheet" href="/resources/css/freeBoardWrite.css">
    <title>댑스 : 커뮤니티 글쓰기</title>
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
                        <li><a href="/member/mypage"><b>MY PAGE</b></a></li>
                        <li><a href="/member/logout"><b>LOGOUT</b></a></li>
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
                    <li><a href="./board.html">커뮤니티</a></li>
                </ul>
            </nav>
        </section>
        <!-- 헤더 -->
    

        <!-- 메인 -->
        <main>
            <section id="topsize"></section>
            <form action="/freeboard/write" method="POST">
                <div id="main">
                    <section id="write-area">
                        <p>커뮤니티 글쓰기</p>
                        <input type="text" name="subject" placeholder="제목을 입력해 주세요."><br>
                        <textarea name="content" cols="0" rows="0" placeholder="내용을 입력해 주세요."></textarea>
                    </section>
                    <div id="control-area">
    
                        <section id="category-section">
                            <select name="category" id="category">
                                <option value="자유" selected>자유</option>
                                <option value="사는얘기">사는얘기</option>
                                <option value="모집공고">모집공고</option>
                                <option value="고민상담">고민상담</option>
                            </select>
                        </section>
                        <section id="control-section">
                            <input type="reset" value="초기화">
                            <input type="submit" value="등록">
                        </section>
                    </div>
                </div>
            </form>
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