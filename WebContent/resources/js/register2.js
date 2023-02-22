// 아이디 중복 체크
var idCheck = function(){
    let openWin = window.open("/member/register/step02/id-check", "Child", "width=400, height=300, top=200, left=450, toolbar=no, location=no, status=no, memubar=no, resizable=no");
}


//이메일 select 선택
document.querySelector("select").addEventListener("change", function(){
    var domain = document.querySelector("option:checked").value;
    if(domain==""){
        document.querySelector("[name=email2]").removeAttribute("readonly");
        document.querySelector("[name=email2]").value = domain;
        document.querySelector("[name=email2]").focus();
    }
    else{
        document.querySelector("[name=email2]").setAttribute("readonly", true);
        document.querySelector("[name=email2]").value = domain;

    }
})

//이메일 인증
var emailAuth = function(){
	var email = document.querySelector("[name=email1]").value+"@"+document.querySelector("[name=email2]").value;
    let openWin = window.open("/member/register/step02/email-auth?email="+email, "Child", "width=400, height=300, top=200, left=450, toolbar=no, location=no, status=no, memubar=no, resizable=no");
	
}

// 주소 API
var searchAddr = function(){
    new daum.Postcode({
        oncomplete: function(data) {
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수
            if(data.userSelectedType === 'R'){
            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
            // 조합된 참고항목을 해당 필드에 넣는다.
            }
            document.querySelector("[name=addr1]").value = data.address + extraAddr;
            document.querySelector("[name=addr2]").focus();
        }
    }).open();
}