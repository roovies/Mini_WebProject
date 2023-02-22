var idUse = function(){
	/*var result = document.querySelector("#result").value;
	if(result=="no"){
	    opener.document.querySelector("[name=id]").value = document.querySelector("[name=id]").value;
		console.log(result);
	    window.close();
	}
	*/
	var result = document.querySelector("#msg").innerHTML;
	if(result=="사용 가능한 아이디입니다."){
	    opener.document.querySelector("[name=id]").value = document.querySelector("[name=id]").value;
	    window.close();
	}
}