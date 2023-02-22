// 전체 동의 -> 동의함 체크 or 체크해제
var checkAll = function(){
    var allcheck = document.querySelector("#allagree");
    if(allcheck.checked==true){
        var agreeList = document.querySelectorAll("[value=Y]");
        agreeList[0].checked = true;
        agreeList[1].checked = true;
        // agreeList[0].setAttribute("checked", true);
        // agreeList[1].setAttribute("checked", true);
    }
    else{
        var agreeList = document.querySelectorAll("[value=Y]");
        agreeList[0].checked = false;
        agreeList[1].checked = false;
        // agreeList[0].removeAttribute("checked");
        // agreeList[1].removeAttribute("checked");
    }
}

// 확인
var checkAgree = function(){
    var agreeList = document.querySelectorAll("[value=Y]");
    if(agreeList[0].checked == true && agreeList[1].checked == true){
        location.href = "/member/register/step02";
    }
    else{
        alert("회원가입을 위해서 필수항목을 동의해야 합니다.");
    }
}