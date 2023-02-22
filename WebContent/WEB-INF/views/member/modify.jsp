<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Fredoka+One&family=Seymour+One&display=swap" rel="stylesheet">
    <link rel="icon" href="/resources/images/icon/favicon.jpg">
    <link rel="stylesheet" href="/resources/css/modify.css">
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js" defer></script>
    <script src="/resources/js/modify.js" defer></script>
    <title>댑스 : 회원정보 수정</title>
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
                    <li><a href="/freeboard/list">커뮤니티</a></li>
                </ul>
            </nav>
        </section>
        <!-- 헤더 -->
    

        <!-- 메인 -->
        <main>
            <section id="topsize"></section>
            <section id="register-msg">
                <p>회원정보 수정하기</p>
                <p>양식에 맞게 정확히 입력해주세요.</p>
                <div id="register-msg2">
                    <p><span>*</span>로 표기된 항목은 필수입력 항목입니다.</p>
                </div>
            </section>
            <form action="/member/mypage/modify" method="POST">
	            <section id="input-info">
	                <table>
	                    <tr>
	                        <th>아이디</th>
	                        <td>
	                            <input type="text" name="id" class="input-box" value="${id }" readonly>
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>패스워드 <span>*</span></th>
	                        <td>
	                            <input type="password" name="pwd" class="input-box"  value="${pwd }" placeholder="패스워드를 입력하세요" maxlength="16">
	                            <p>
	                                ※ 영문 대소문자, 숫자, 특수문자 중 2가지 이상 조합하여 설정해주세요. (8~16자)<br>
	                                ※ 아이디와 4자리 이상 동일하거나, 4자리 이상 반복되는 문자와 숫자는 사용이 불가합니다.<br>
	                                ※ 사용 가능 특수문자: !”#$%’()*+,-./:;<=>?@[]^_`{|}~
	                            </p>
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>패스워드 확인 <span>*</span></th>
	                        <td>
	                            <input type="password" name="pwd2" class="input-box"  value="${pwd }" placeholder="패스워드를 다시 입력하세요" maxlength="16">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>이름</th>
	                        <td>
	                            <input type="text" name="name" class="input-box" value="${name }" readonly>
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>이메일 <span>*</span></th>
	                        <td>
	                            <input type="text" name="email1" class="email-box" value="${email1 }">
	                            <span id="gol">@</span>
	                            <input type="text" name="email2" class="email-box" value="${email2 }">
	                            <select name="domain" id="domain-box">
	                                <option value="">직접입력</option>
	                                <option value="naver.com">naver.com</option>
	                                <option value="naver.com">gmail.com</option>
	                            </select>
	                            <input type="button" value="이메일 인증" onclick="emailAuth()"><span id="msg"></span>
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>연락처 <span>*</span></th>
	                        <td><input type="text" name="phone" class="input-box" value="${phone }" maxlength="11"></td>
	                    </tr>
	                    <tr>
	                        <th>주소</th>
	                        <td>
	                            <input type="text" name="addr1" class="input-box" value="${addr1 }" readonly> 
	                            <input type="button" value="주소찾기" onclick="searchAddr()">
	                            <br><br>
	                            <input type="text" name="addr2" class="input-box" value="${addr2 }" placeholder="상세주소를 입력하세요">
	                        </td>
	                    </tr>
	                </table>
	            </section>
	            <section id="modifybox">
	                <input type="submit" value="수정하기" onclick="checkinfo()">
	            </section>
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