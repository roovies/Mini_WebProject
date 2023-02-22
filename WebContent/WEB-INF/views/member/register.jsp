<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Fredoka+One&family=Seymour+One&display=swap" rel="stylesheet">
    <link rel="icon" href="./images/icon/favicon.jpg">
    <link rel="stylesheet" href="/resources/css/register.css">
    <script src="/resources/js/register.js" defer></script>
    <title>댑스 : 회원가입</title>
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
            <section id="register-msg">
                <p>약관 동의</p>
                <p>이용약관과 개인정보처리방침에 대한 안내를 읽고 동의 해주세요.</p>
                <div id="allagree-checkbox">
                    <input type="checkbox" id="allagree" onclick="checkAll()"> <p>모든 약관을 확인하고 전체 동의함</p>
                </div>
            </section>
            <section id="agree-area">
                <p class="agree-title">(필수) 댑스 회원 약관</p>
                <div class="agree-box">
                    <p class="agree-content">(주)댑스 코리아의 서비스 이용과 관련하여 필요한 사항들을 규정합니다.</p><br>
                    <p class="agree-title">제1장 총칙</p><br>
                    <p class="agree-title2">1. 목적</p>
                    <p class="agree-content">가. (주)댑스 코리아(이하 “회사”)에서 운영하는 사이트는 아래와 같은 약관에 동의하는 이용자들에게 제공되는 인터넷 서비스로 이용자와 회사의 권리 및 의무를 규정함을 목적으로 합니다.</p>
                    <p class="agree-content">나. 이용자는 회사가 정한 소정의 등록 절차를 걸쳐 ‘회원가입’ 버튼을 클릭하면 이 약관과 함께 이에 동의하는 것으로 간주합니다.</p>
                    <p class="agree-content">다. 회사 홈페이지의 모든 자료는 댑스 코리아에 의해 자격을 취득한 기타 이해관계자에 의한 저작권, 등록의장, 등록상표 또는 기타 지적소유권으로 보호되고 있습니다.</p>
                    <p class="agree-content">라. 본 사이트에 포함된 자료는 정보 목적으로 만 제공됩니다. 귀하는 본 사이트의 내용에 대하여 어떤 방법으로도 배포, 출판, 전송, 변경, 전시, 모방 작품의 창조 혹은 개발하지 않을 것에 동의하는 것으로 간주되며, 회사의 권한을 보호하고 옹호함은 물론 본 사이트의 자료를 허가 없이 유용함으로써 발생할 수 있는 어떠한 손해도 입히지 않아야 합니다. 허가 없이 사이트의 내용을 유용하는 경우에는 회사에 돌이킬 수 없는 손해를 입힐 수도 있다는 사실을 인지하시기 바랍니다. 이와 같이 인가되지 않은 유용 사실에 대하여 회사는 법적, 재정적으로 가능한 기타 추가적인 배상과 관련한 권한을 가지고 있습니다. 피드백 및 제출 자료. 귀하가 제출하는 자료의 내용에 대한 책임은 전적으로 귀하에게 있습니다. 제출자료에 불법, 중상모략, 비난 혹은 비도덕적인 내용이 포함되어서는 안됩니다. 사이트에 저작권, 등록 상표권, 사생활권 혹은 기타 사적 권리 혹은 소유권을 포함하는 제삼자의 권리를 침해하는 어떤 자료도 게시하여서는 안 됩니다.</p>
                    <p class="agree-content">마. 이용자의 개인 정보 보호 및 보안, 개인 정보에 대한 수집, 이용 및 저장과 관련한 관행 및 정책에 대하여는 회사의 개인정보처리방침에 의합니다. 개인정보처리방침은 홈페이지에 별도 게시하고 있습니다.</p>
                    <br>
                    <p class="agree-title2">2. 약관의 수정</p>
                    <p class="agree-content">가. 회사는 약관을 변경할 수 있으며 변경된 약관은 회원에게 화면을 통한 공지 등의 방법으로 공지함으로 효력을 발생합니다.</p>
                    <p class="agree-content">나. 회사는 약관을 개정할 경우에는 적용일자 및 개정 사유를 명시하여 홈페이지에 그 적용일의 7일 전부터 공시하거나 회원이 입력한 가장 최근의 e-mail로 전송하는 방법으로 회원에게 고지합니다. 다만, 회원에게 불리한 내용으로 약관을 개정하는 경우에는 적용일로부터 30일 전까지 홈페이지에 공시하고 회원이 입력한 가장 최근의 e-mail로 전송하는 방법으로 회원에게 고지합니다. 변경된 약관은 공시하거나 고지한 적용일로부터 효력이 발생합니다.</p>
                    <br>
                    <p class="agree-title2">3. “회원”의 정의</p>
                    <p class="agree-content">가. “회원”이란 회사 홈페이지, 모바일 버전 홈페이지 및 APP에 접속하여 본 약관에 따라 회사 인터넷 회원으로 가입하여 회사 홈페이지, 모바일 버전 홈페이지 및 APP이 제공하는 서비스를 받는 자를 말합니다.</p>
                    <p class="agree-content">나. 회원이 회사 인터넷 회원으로 가입하거나 소지한 부메랑 카드를 등록하면, “아웃백 부메랑 멤버십 회원”이 됩니다. 본 약관에서 별도로 정한 사항이 없다면, “아웃백 부메랑 멤버십 회원”으로서의 권한 및 이용과 관련한 규정은 “아웃백 부메랑 멤버십 이용약관”에 따릅니다.</p>
                    <p class="agree-content">다. 회원이 딜리버리 서비스 이용 신청 시, 별도의 가입 없이 딜리버리 서비스 이용 회원이 됩니다. “아웃백 딜리버리 서비스 이용 회원”의 권한 및 이용과 관련한 규정은 “아웃백 딜리버리 서비스 이용약관”에 따릅니다.</p>
                    <p class="agree-content">라. 본 약관과 아웃백 부메랑 멤버십 이용약관의 내용상 충돌이 있을 경우 아웃백 부메랑 멤버십 이용약관이 우선합니다.</p>
                    <p class="agree-content">마. 본 약관과 아웃백 딜리버리 서비스 이용약관의 내용상 충돌이 있을 경우 아웃백 딜리버리 서비스 이용약관이 우선합니다.</p>
                </div>
                <div class="agree-choice">
                    <input type="radio" name="agree1" value="N" class="agree-btn" checked><p>동의하지 않음</p>
                    <input type="radio" name="agree1" value="Y" class="agree-btn"><p>동의함</p>
                </div>
                <p class="agree-title">(필수) 개인정보 수집 및 이용에 대한 동의</p>
                <table>
                    <tr>
                        <th>목적</th>
                        <th>항목</th>
                        <th>보유기간</th>
                    </tr>
                    <tr>
                        <td>이용자 식별 및<br> 본인 여부 확인</td>
                        <td>
                            성명, 생년월일, 성별, 아이디, 비밀번호, 포인트 비밀번호,<br>
                            휴대전화 번호, 이메일, 부메랑 카드 번호, CI, DI
                        </td>
                        <td rowspan="4">회원 탈퇴 후 3개월</td>
                    </tr>
                    <tr>
                        <td>불만 처리 등 민원 처리</td>
                        <td>
                            성명, 아이디, 휴대전화 번호, 서비스 이용기록,<br>
                            이메일, 부메랑 카드 번호
                        </td>
                    </tr>
                    <tr>
                        <td>서비스 제공에 관한 계약 이행 및<br> 서비스 제공에 따른 콘텐츠 제공</td>
                        <td>
                            성명, 아이디, 휴대전화 번호, 서비스 이용 기록,<br>
                            이메일, 주소, 부메랑 카드 번호
                        </td>
                    </tr>
                    <tr>
                        <td>불량회원의 부정 이용 방지와<br>비인가 사용 방지</td>
                        <td>IP, 서비스 이용 기록, 접속 로그, 쿠키</td>
                    </tr>
                </table>
                <div class="agree-choice">
                    <input type="radio" name="agree2" value="N" class="agree-btn" checked><p>동의하지 않음</p>
                    <input type="radio" name="agree2" value="Y" class="agree-btn"><p>동의함</p>
                </div>
            </section>
            <section id="joinbox">
                <input type="submit" value="확인" onclick="checkAgree()">
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