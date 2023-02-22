var checkDelete = function(){
    if(confirm("정말 회원탈퇴를 진행할까요? 확인을 누르시면 취소가 불가능합니다.")){
        location.href = "/member/mypage/delete";
    }

}