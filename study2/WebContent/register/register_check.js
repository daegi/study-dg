

function register_check() {
	// var userinput = eval("document.userinput");
	var form1 = document.getElementById("form1");
	var userid = document.getElementById("userid");
	var userpwd1 = document.getElementById("userpwd1");
	var userpwd2 = document.getElementById("userpwd2");
	var username = document.getElementById("username");
	var birth = document.getElementById("birth");
	var email1 = document.getElementById("email1");
	var email2 = document.getElementById("email2");
	var tel1 = document.getElementById("tel1");
	var tel2 = document.getElementById("tel2");
	var tel3 = document.getElementById("tel3");
	var question = document.getElementById("question");
	var answer = document.getElementById("answer");
	var job = document.getElementById("job");
	var zipcode = document.getElementById("zipcode");
	var address1 = document.getElementById("address1");
	var address2 = document.getElementById("address2");
	
	
	// 아이디, 패스,이메일, 전화 정규 표현식
	var rgid=/^[a-z0-9_]{4,16}$/;
	var rgpw=/^[a-zA-Z0-9]{8,12}$/;
	// var rgem=/^$/;
	// var rgtel=/^$/;
	
	// 달력 스크립트
	

	// 빈값 체크
	if (userid.value == "") {
		alert("아이디를 입력하세요.");
		return;
	}
	
	if( !rgid.test(userid) ){
		alert("아이디는 4~16자의 영문 소문자와 숫자만 사용할 수 있습니다.");
		return;
	}
	
	
	if (userpwd1.value == "") {
		alert("비밀번호를 입력하세요.");
		userpwd1.focus();
		return;
	}
	if (userpwd2.value == "") {
		alert("비밀번호를 다시 한번 입력하세요.");
		userpwd2.focus();
		return;
	}

	if (userpwd2.value != userpwd2.value){
		alert("비밀번호를 동일하게 입력하세요");
		return;
	}
	
	if(!rgpw.test(userpwd1))
	{ 
		alert('비밀번호는 숫자와 영문자 조합으로 8~12자리를 사용해야 합니다.'); 
		return;
	}
	
/*
 * var chk_num = upw.search(/[0-9]/g); var chk_eng = upw.search(/[a-z]/ig);
 * if(chk_num < 0 || chk_eng < 0) { alert('비밀번호는 숫자와 영문자를 혼용하여야 합니다.'); return
 * false; }
 * 
 * if(/(\w)\1\1\1/.test(upw)) { alert('비밀번호에 같은 문자를 4번 이상 사용하실 수 없습니다.'); return
 * false; } if(upw.search(uid)>-1) { alert('ID가 포함된 비밀번호는 사용하실 수 없습니다.'); return
 * false; }
 */
	
	
	
	
	if (username.value == "") {
		alert("이름을 입력하세요.");
		username.focus();
		return;
	}

	if (birth.value == "") {
		alert("생일을 입력하세요.");
		birth.focus();
		return;
	}

	if (email1.value == "") {
		alert("이메일 아이디를 입력하세요.");
		email.focus();
		return;
	}

	if (email2.value == "") {
		alert("이메일 도메인 입력하세요.");
		email.focus();
		return;
	}
	if (tel1.value == "") {
		alert("핸드폰 번호를 입력하세요.");
		tel2.focus();
		return;
	}

	if (tel2.value == "") {
		alert("핸드폰 번호를 입력하세요.");
		tel2.focus();
		return;
	}

	if (tel3.value == "") {
		alert("핸드폰 번호를 입력하세요.");
		tel3.focus();
		return;
	}

	if (question.value() == "") {
		alert("직업을 입력하세요.");
		jquestion.focus();
		return;
	}

	if (answer.value() == "") {
		alert("직업을 입력하세요.");
		answer.focus();
		return;
	}

	if (job.value() == "") {
		alert("직업을 입력하세요.");
		job.focus();
		return;
	}

	if (zipcode.value == "") {
		alert("우편번호를 입력하세요.");
		zipcode.focus();
		return;
	}
	if (address1.value == "") {
		alert("주소를 입력하세요.");
		address1.focus();
		return;
	}
	if (address2.value == "") {
		alert("주소를 입력하세요.");
		address2.focus();
		return;
	}
	form1.action = "member_insert.jsp";
	form1.submit();
}







var NUM="0123456789";
var SALPHA="abcdefghijklmnopqrstuvwxyz";
var ALPHA="ABCDEFGHIJKLMNOPQRSTUVWXYZ"+SALPHA;
var PASSWORD="!@.#,$%^*&_-"+ALPHA+NUM;
var ERRORMSG="";
function StringSize(c){var b;
var a=0;
for(b=0;
b<c.length;
b++){if(c.charCodeAt(b)>255){a+=2
}else{a++
}}return a
}function CheckType(c,b){var a;
for(a=0;
a<c.length;
a++){if(b.indexOf(c.substring(a,a+1))<0){return false
}}return true
}function CheckLenEng(d,c,a,g,b){var e=StringSize(d);
var f,h;
if(b){h="을";
f="은"
}else{h="를";
f="는"
}if(e==0&&a>0){ERRORMSG=c+h+"  입력해 주십시오.";
return false
}if(a==0&&e>g){ERRORMSG=c+f+" "+g+"자 이하로 입력해 주십시오.\n\n현재 입력된 길이 : "+e+"자";
return false
}if(e<a||e>g){ERRORMSG=c+f+" "+a+"자 이상, "+g+"자 이하로 입력해 주십시오.\n\n현재 입력된 길이 : "+e+"자";
return false
}return true
}function IDCheck(b){var a=id("loginId").value;
if(!CheckType(a,SALPHA+NUM)){ERRORMSG="회원아이디는 영문 소문자와 숫자로,  첫 글자는 꼭 영문 소문자로 작성해야 합니다.";
alert(ERRORMSG);
id("loginId").focus();
return
}else{if(NUM.indexOf(a.charAt(0))>=0){ERRORMSG="회원아이디의 첫 글자는 꼭 영문 소문자로 작성해야 합니다.";
alert(ERRORMSG);
id("loginId").focus();
return
}else{if(a.substring(0,5)=="admin"||a.substring(0,5)=="guest"){ERRORMSG="회원아이디는 admin이나 guest로 시작할 수 없습니다.";
alert(ERRORMSG);
id("loginId").focus();
return
}else{if(a.substring(0,9)=="oramaster"||a.substring(0,9)=="webmaster"||a=="storm"||a=="admin"){ERRORMSG="사용 하실수 없는 회원아이디 입니다.";
alert(ERRORMSG);
id("loginId").focus();
return
}else{if(!CheckLenEng(a,"회원아이디",4,10,0)){alert(ERRORMSG);
id("loginId").focus();
return
}}}}}b.action="/popup/checkId";
b.submit()
};