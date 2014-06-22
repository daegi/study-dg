142    폼 입력 내용을 체크하여 깔끔하게 경고창 보여주기 

  
<!--1. 아래 스크립트를 HEAD 부분에 복사해 넣으세요. 없으면 그냥 두세요-->
<SCRIPT LANGUAGE="JavaScript">
<!-- Begin
function checkFields() {
missinginfo = "";
if (document.form.name.value == "") {
missinginfo += "\n     -  성명";
}
if ((document.form.from.value == "") || 
(document.form.from.value.indexOf('@') == -1) || 
(document.form.from.value.indexOf('.') == -1)) {
missinginfo += "\n     -  이메일 주소";
}
if ((document.form.website.value == "") || 
(document.form.website.value.indexOf("http://") == -1) || 
(document.form.website.value.indexOf(".") == -1)) {
missinginfo += "\n     -  홈페이지";
}
if(document.form.comments.value == "") {
missinginfo += "\n     -  내용";
}
if (missinginfo != "") {
missinginfo ="_____________________________\n" +
"다음항목에 에러가 있습니다:\n" +
missinginfo + "\n_____________________________" +
"\n확인후 다시 입력 하세요";
alert(missinginfo);
return false;
}
else return true;
}
//  End -->
</script>
</HEAD>
<!--2. BODY 태그내에 onload="" 혹은 onunload 부분이 있으면 복사해 넣으세요-->
<BODY BGCOLOR="#FFFFFF">
<!--3. BODY 부분에 아래의 스크립트를 복사해 넣으세요-->

<CENTER><form name=form onSubmit="return checkFields();">
<input type=hidden name=to value='you @ your domain . web'>
<input type=hidden name=subject value="Freedback">
<pre>
Name:      <input type=text name="name" size=30>
E-mail:    <input type=text name="from" size=30>
Web Site:  <input type=text value="http://" name="website" size=30>
Comments:  
<textarea rows=3 cols=40 name="comments"></textarea>
<input type=submit name="submit" value="Submit Form!">
</pre>
</form>
</CENTER> 






141    부끄럼 타는 버튼  

<!--1. 아래 스크립트를 HEAD 부분에 복사해 넣으세요. 없으면 그냥 두세요-->
<SCRIPT LANGUAGE="JavaScript">
<!-- Begin
var flag = 1;
function t() {
if(flag == 1) {
N.style.top = "75px";
N.style.left = "700px";
}
if(flag == 2) {
N.style.top = "115px";
N.style.left = "100px";
}
if(flag == 3) {
N.style.top = "300px";
N.style.left = "350px";
}
flag = flag + 1;
if(flag == 4) {
flag = 1;
   }
}
function al() {
alert("Correct!");
}
//  End -->
</script>
</HEAD>
<!--2. BODY 태그내에 onload="" 혹은 onunload 부분이 있으면 복사해 넣으세요-->
<BODY BGCOLOR="#FFFFFF">
<!--3. BODY 부분에 아래의 스크립트를 복사해 넣으세요-->

<center>
"아뇨"를 클릭해 보셔!!
</center>
<DIV ID="N" STYLE="position:absolute; left:350px; top:300px; width:50px; height:50px;">
<form>
<input type=button value=" 아~~뇨 " onMouseover="t()">
</form>
</DIV>
<DIV ID="Y" STYLE="position:absolute; left:300px; top:300px; width:50px; height:50px;">
<form>
<input type=button value=" 당근이쥥 " onClick="al()">
</form>
</DIV>
 
 





140    나쁜말 입력 금지 

<!--1. 아래 스크립트를 HEAD 부분에 복사해 넣으세요. 없으면 그냥 두세요-->
<SCRIPT LANGUAGE="JavaScript">
<!-- Original:  Cut-N-Paste JavaScript
<!-- Begin
function smutEngine() {
smut="#@&*%!#@&*%!#@&*%!";
cmp="해커 섹스 나쁜놈 새끼 ";
txt=document.isn.dirt.value;
tstx="";
for (var i=0;i<16;i++){
pos=cmp.indexOf(" ");
wrd=cmp.substring(0,pos);
wrdl=wrd.length
cmp=cmp.substring(pos+1,cmp.length);
while (txt.indexOf(wrd)>-1){
pos=txt.indexOf(wrd);
txt=txt.substring(0,pos)+smut.substring(0,wrdl)
+txt.substring((pos+wrdl),txt.length);
   }
}
document.isn.dirt.value=txt;
}
// End -->
</SCRIPT>
</HEAD>
<!--2. BODY 태그내에 onload="" 혹은 onunload 부분이 있으면 복사해 넣으세요-->
<BODY BGCOLOR="#FFFFFF">
<!--3. BODY 부분에 아래의 스크립트를 복사해 넣으세요-->

<CENTER>
<FORM NAME="isn">
<DIV ALIGN=CENTER><INPUT TYPE="text" NAME="dirt" SIZE=40 VALUE=""><BR>
<INPUT TYPE="button" NAME="smut1" VALUE=" Submit " onClick="smutEngine(this.form)">
</DIV> 
</FORM>
</CENTER> 
 


  




139    비밀번호 종합 체크  

 
<!--1. 아래 스크립트를 HEAD 부분에 복사해 넣으세요. 없으면 그냥 두세요-->
<SCRIPT LANGUAGE="JavaScript">
<!-- Begin
function validatePwd() {
var invalid = " "; // 공백은 불허
var minLength = 6; // 최대길이
var pw1 = document.myForm.password.value;
var pw2 = document.myForm.password2.value;
// 두칸다 넣었는지
if (pw1 == '' || pw2 == '') {
alert('두번 넣으라니깐!');
return false;
}
// 최소 글자수 체크
if (document.myForm.password.value.length < minLength) {
alert('최소 ' + minLength + ' 이상이여야 한다자나!.');
return false;
}
// 공백체크
if (document.myForm.password.value.indexOf(invalid) > -1) {
alert("빈칸도 안돼");
return false;
}
else {
if (pw1 != pw2) {
alert ("위에꺼랑 다르자나! 다시입력!");
return false;
}
else {
alert('짝짝짝');
return true;
      }
   }
}
//  End -->
</script>
</HEAD>
<!--2. BODY 태그내에 onload="" 혹은 onunload 부분이 있으면 복사해 넣으세요-->
<BODY BGCOLOR="#FFFFFF">
<!--3. BODY 부분에 아래의 스크립트를 복사해 넣으세요-->

<center>
<form name=myForm onSubmit="return validatePwd()">
비밀번호를 2번 입력 하세요
<br>
(6~12자 사이로 입력하시고 공백은 허용하지 않습니다)
<p>
비밀번호 <input type=password name=password maxlength=12>
<br>
한번 더 <input type=password name=password2 maxlength=12>
<p>
<input type=submit value="Submit">
</form>
</center>
 
 







 138    제목을 골라 메일 보내기
 
<!--1. 아래 스크립트를 HEAD 부분에 복사해 넣으세요. 없으면 그냥 두세요-->
<SCRIPT LANGUAGE="JavaScript">
<!-- Begin
function getCookie(name){
var cname = name + "=";               
var dc = document.cookie;             
if (dc.length > 0) {              
begin = dc.indexOf(cname);       
if (begin != -1) {           
begin += cname.length;       
end = dc.indexOf(";", begin);
if (end == -1) end = dc.length;
return unescape(dc.substring(begin, end));
   } 
}
var blank = "";
return blank;
}
function setCookie(name, value, expires) {
document.cookie = name + "=" + escape(value) + 
((expires != null) ? "; expires=" + expires.toGMTString() : "")
+ "; path=/";
}
function setName() {
var expdate = new Date ();
expdate.setTime (expdate.getTime() + (24 * 60 * 60 * 1000 * 365));
var prompt=i = document.Mail.name.value;
setCookie("name", i, expdate);
}
function getName() {
if(getCookie("name") != null) {
document.Mail.Name.value = getCookie("emailname");
   }
}
function getInfo() {
var now= new Date();
document.Mail.Info.value = "Browser: " + navigator.userAgent;
document.Mail.Info.value += "Date:" + now;
}
function checkMultiple() {
if (getCookie("emailsent") == 'true') return true;
else return false;
}
function process() {
setCookie("emailsent", "true");
with (document.Mail) {
if (Subject.selectedIndex == 1) action = "mailto:babo@babo.com?subject=질문";
else if (Subject.selectedIndex == 2) action = "mailto:babo@babo.com?subject=대답";
else if (Subject.selectedIndex == 3) action = "mailto:babo@babo.com?subject=제안";
else if (Subject.selectedIndex == 4) action = "mailto:babo@babo.com?subject=잡담";
else action = "mailto:babo@babo.com?subject=그냥";
   }
}
function formCheck() {
var passed = false;
with (document.Mail) {
if (Subject.selectedIndex == 0) { 
alert("Please pick a subject.");
Subject.focus();
}
else if (Name.value == "") {
alert("Please inlcude your name.");
Name.focus();
}
else if (checkMultiple()) {
if (confirm("You just sent an e-mail from this form, are you sure you want to send another?")) {
process();
passed = true;
   }
}
else {
process();
passed = true;
   }
}
return passed;
}
// End -->
</SCRIPT>
</HEAD>
<!--2. BODY 태그내에 onload="" 혹은 onunload 부분이 있으면 복사해 넣으세요-->
<BODY BGCOLOR="#FFFFFF">
<!--3. BODY 부분에 아래의 스크립트를 복사해 넣으세요-->

<CENTER>
<BR>
<FORM NAME = "Mail" ACTION = "mailto:babo@babo.com?subject=그냥" METHOD = "POST" ENCTYPE = "text/plain" onSubmit="return formCheck();">
<INPUT TYPE = "hidden" SIZE = 0 NAME = "Info">
<TABLE BORDER = 0 CELLPADDING = 10 CELLSPACING = 0>
<TR><TD>
이름 :  
<INPUT TYPE = "text" NAME = "Name" onChange = "setName()">
</TD><TD ALIGN = RIGHT >
제목 :  
<SELECT NAME = "Subject">
<OPTION SELECT>선택하세요</OPTION>
<OPTION>1. 질문</OPTION>
<OPTION>2. 답변</OPTION>
<OPTION>3. 제안</OPTION>
<OPTION>4. 잡담</OPTION>
<OPTION>5. 기타</OPTION>
</SELECT>
</TD></TR>
<TR>
<TD COLSPAN = 2>
내용을 적어주세요  :
<BR><BR>
<TEXTAREA NAME = "Comments, Suggestions" COLS = 75 ROWS = 6>
</TEXTAREA>
</TD>
</TR>
</TABLE>
<CENTER>
<TABLE>
<TR>
<TD align=center>
<INPUT TYPE = "submit" VALUE = "Send">
</TD>
</TR>
</TABLE>
</FORM>
<SCRIPT LANGUAGE="JavaScript">
<!-- Begin
getInfo();
getName();
// End -->
</SCRIPT>
</FONT>
</CENTER>
 
 






 137    자바스크립트로 메일링 리스트를 만들어 보자 
 
<!--1. 아래 스크립트를 HEAD 부분에 복사해 넣으세요. 없으면 그냥 두세요-->
<SCRIPT LANGUAGE="JavaScript">
<!--  Begin
function resetform() {
document.forms[0].elements[1]=="";
}
function submitForms() {
if (isEmail() && isFname() && isLname() && isAddress() && isCity() && isState() && isZip())
if (confirm("\n 이메일로 귀하의 정보를 보내시겠습니까?\n"))
{
alert("\n귀하의 정보를 보냅니다\n");
return true;
}
else
{
alert("\n 취소하시겠습니까?");
return false
}
else 
return false;
}
function isEmail() {
if (document.forms[0].elements[1].value == "") {
alert ("\n 이메일 주소를 넣어 주세요.")
document.forms[0].elements[1].focus();
return false;
}
if (document.forms[0].elements[1].value.indexOf ('@',0) == -1 ||
document.forms[0].elements[1].value.indexOf ('.',0) == -1) {
alert ("\n The E-Mail field requires a \"@\" and a \".\"be used. \n\n이메일 주소를 다시 입력하세요")
document.forms[0].elements[1].select();
document.forms[0].elements[1].focus();
return false;
}
return true;
}
function isFname() {
if (document.forms[0].elements[2].value == "")
{
alert ("\n The First Name field is blank. \n\n 이름을 입력하세요")
document.forms[0].elements[2].focus();
return false;
}
return true;
}
function isLname() {
if (document.forms[0].elements[3].value == "") {
alert ("\n The Last Name field is blank. \n\n성을 입력하세요.")
document.forms[0].elements[3].focus();
return false;
}
return true;
}
function isAddress() {
if (document.forms[0].elements[4].value == "") {
alert ("\n The Address field is blank. \n\n주소를 입력하세요.")
document.forms[0].elements[4].focus();
return false;
}
return true;
}
function isCity()
{
if (document.forms[0].elements[5].value == "")
{
alert ("\n The City field is blank. \n\n사는곳을 입력하세요")
document.forms[0].elements[5].focus();
return false;
}
return true;
}
function isState() {
if (document.forms[0].elements[6].value == "") {
alert ("\n The state field is blank.\n\n사는곳을 입력하세요")
document.forms[0].elements[6].focus();
return false;
}
return true;
}
function isZip() {
if (document.forms[0].elements[7].value == "") {
alert ("\n The Zip code field is blank. \n\n우편번호를 입력하세요")
document.forms[0].elements[7].focus();
return false;
}
return true;
}
// End -->
</script>
</HEAD>
<!--2. BODY 태그내에 onload="" 혹은 onunload 부분이 있으면 복사해 넣으세요-->
<BODY BGCOLOR="#FFFFFF">
<!--3. BODY 부분에 아래의 스크립트를 복사해 넣으세요-->

<CENTER>
<FORM enctype="text/plain" name="addform" method='get'
action='mailto:babo@babo.com?subject=Mailing List' onSubmit="return submitForms()">
<TABLE border=3 width=430 cellpadding=10><TD align="center">
<strong>
<font face="arial" size=+2>메일링 리스트에 가입하세요</font>
</strong>
</TABLE>
<input type="hidden" name="Form" value="Submit Sub">
<TABLE border=3 cellspacing=0 cellpadding=2 bgcolor="#C0C0C0">
<tr valign=baseline>
<TD>
<font face="arial">Email Address:</font>
</TD>
<TD>
<input type=text name="Email Address" size=35,1 maxlength=80>
</TD>
</tr>
<tr>
<TD>
<font face="arial">First Name:</font>
</TD>
<TD>
<input type=text name="First Name" size=35,1 maxlength=80>
</TD></tr>
<tr>
<TD>
<font face="arial">Last Name:</font>
</TD>
<TD>
<input type=text name="Last Name" size=35,1 maxlength=80>
</TD></tr>
<tr>
<TD>
<font face="arial">Address:</font>
</TD>
<TD>
<input type=text name="Address" size=35,1 maxlength=80>
</TD></tr>
<tr>
<TD>
<font face="arial">City:</font>
</TD>
<TD>
<input type=text name="City" size=35,1 maxlength=80>
</TD></tr>
<tr>
<TD>
<font face="arial">State:</font>
</TD>
<TD>
<input type=text name="State" size=10,1 maxlength=25>
</TD></tr>
<tr>
<TD>
<font face="arial">Zip Code:</font>
</TD>
<TD>
<input type=text name="Zip" size=20,1 maxlength=35>
</TD></tr></TABLE>
<br>
<center>
<input type="submit" value="  Submit  ">
<input type="button" value="  Return  " onclick="window.location='your-page.html'">
<input type="reset" value="Reset Form" onclick=resetform()>
</FORM>
</CENTER>
 
 




136    멀티 메일러 - Multi_Mailer  

 
<!--3. BODY 부분에 아래의 스크립트를 복사해 넣으세요-->

<FORM NAME="mailer" METHOD="post" ACTION="" ENCTYPE="text/plain" 
onSubmit="(document.mailer.action += mailtoandsubject)"> 
<TABLE BORDER=0>
<TR VALIGN="top">
<TD>받는사람 :</TD>
<TD><SELECT NAME="mailtoperson" onChange="msg(this.form)">
<OPTION VALUE="">-- Select --
<OPTION VALUE="person1@daum.net">기술책임자
<OPTION VALUE="person2@daum.net">요금책임자
<OPTION VALUE="person3@daum.net">웹 마스터
</SELECT></TD>
</TR>
<TR VALIGN="top">
<TD>성명 :</TD>
<TD><INPUT TYPE="text" SIZE=45 NAME="name" onChange="msg(this.form)"></TD>
</TR>
<TR VALIGN="top">
<TD>회신 이메일 주소 :</TD>
<TD><INPUT TYPE="text" SIZE=45 NAME="email" onChange="msg(this.form)"></TD>
</TR>
<TR VALIGN="top">
<TD>종류 :</TD>
<TD>
<SELECT NAME="priority" onChange="msg(this.form)">
<OPTION VALUE="Normal">일반
<OPTION VALUE="Urgent">긴급
<OPTION VALUE="No Reply Needed">회신거부
</SELECT></TD>
</TR>
<TR VALIGN="top">
<TD>제목 :</TD>
<TD><INPUT TYPE="text" SIZE=45 NAME="subject" onChange="msg(this.form)"></TD>
</TR>
<TR VALIGN="top">
<TD>내용 :</TD>
<TD><TEXTAREA NAME="message" COLS=45 ROWS=5 WRAP="virtual" OnChange="msg(this.form)"></TEXTAREA></TD>
</TR>
<TR>
<TD> </TD>
<TD><INPUT TYPE="submit" VALUE="보내기">
<INPUT TYPE="reset" VALUE="재작성"></TD>
</TR>
</TABLE>
</FORM>
<SCRIPT LANGUAGE="JavaScript">
function msg() {
document.mailer.action = "mailto:" 
mailtoandsubject = ((document.mailer.mailtoperson.options[document.mailer.mailtoperson.selectedIndex].value) + '?subject=' + document.mailer.subject.value); 
} 
</SCRIPT>  
 
 





 135    체크박스가 아닌곳을 선택해도 체크박스 선택하기 
 
<!--1. 아래 스크립트를 HEAD 부분에 복사해 넣으세요. 없으면 그냥 두세요-->
<SCRIPT LANGUAGE="JavaScript">
<!-- Begin
function changeBox(cbox) {
box = eval(cbox);
box.checked = !box.checked;
}
//  End -->
</script>
</HEAD>
<!--2. BODY 태그내에 onload="" 혹은 onunload 부분이 있으면 복사해 넣으세요-->
<BODY BGCOLOR="#FFFFFF">
<!--3. BODY 부분에 아래의 스크립트를 복사해 넣으세요-->

<BODY>
<center>
<form name=demoform>
<input type=checkbox name=agreebox>
<span id="hellospan" style="cursor:hand;" onClick="changeBox('document.demoform.agreebox')">이 텍스트를 클릭해도 왼쪽 체크박스를 틀릭한 것과 같습니다 (IE Only)</span>
</form>
</center>
 
 
  






 134    자바스크립트 에러 검증 스크립트  
 
<!--1. 아래 스크립트를 HEAD 부분에 복사해 넣으세요. 없으면 그냥 두세요-->
<SCRIPT LANGUAGE="JavaScript">
<!-- Begin
function reportError(msg,url,line) {
var str = "Err: " + msg + " on line: " 
+ line + "\nURL: " + url  + "\nWeb: " 
+ navigator.appName + " " + navigator.appName 
+ " " + navigator.appVersion;
document.errform.error.value = str;
return true;
}
window.onerror = reportError;
//  End -->
</script>
</HEAD>
<!--2. BODY 태그내에 onload="" 혹은 onunload 부분이 있으면 복사해 넣으세요-->
<BODY BGCOLOR="#FFFFFF">
<!--3. BODY 부분에 아래의 스크립트를 복사해 넣으세요-->
<CENTER><form name=err>
<input type=button value="Cause JS Error" onClick="brokenScript()">
</form><p>
<form name=errform>
<textarea name=error rows=5 cols=70></textarea>
</form>
</CENTER>
 
  






 133    소스 훔쳐보기  
 
<!--1. 아래 스크립트를 HEAD 부분에 복사해 넣으세요. 없으면 그냥 두세요-->
<SCRIPT LANGUAGE="JavaScript">
<!-- Begin
function viewSource() {
document.getSource.view.value="잠지만 기다리세요";
setTimeout("document.getSource.view.value='View Source!'",6000);
window.location.href= "view-source:" + document.getSource.url.value;
return false;
}
//  End -->
</script>
</HEAD>
<!--2. BODY 태그내에 onload="" 혹은 onunload 부분이 있으면 복사해 넣으세요-->
<BODY BGCOLOR="#FFFFFF">
<!--3. BODY 부분에 아래의 스크립트를 복사해 넣으세요-->

<center>
보기를 윈하는 페이지의 완전한 URL 을 입력하세요
<br>
<br>
<form name=getSource onSubmit="return viewSource();">
<input type=text name=url value="http://">
<br>
<br>
<input type=submit name=view value=" 소스 보기 ">
</form>
</center> 
 


  




132    체크박스 클릭하면 즉시 이동 시키기

 
<center>
<form>
<input type=checkbox onclick="window.location='http://kr.yahoo.com'; return true;">야후! 코리아
</form>
</center> 
 
 



 131    년도별 띠 알아보기

<!--1. 아래 스크립트를 HEAD 부분에 복사해 넣으세요. 없으면 그냥 두세요-->
<script LANGUAGE="JavaScript">
<!--
function getpet () {
        var toyear = 1997; //(1997 - 내가 태어난날) % 12 합니다.
        var birthyear = document.frm.inyear.value;
        var birthpet="Ox"
        x = (toyear - birthyear) % 12// x값을 구합니다.
        if ((x == 1) || (x == -11)) {
            birthpet="쥐띠"      }
            else  {
             if (x == 0)             {
             birthpet="Ox"           }
             else  {
              if ((x == 11) || (x == -1)) {
              birthpet="호랑이띠"          }
              else  {
               if ((x == 10) || (x == -2)) {
               birthpet="토끼띠"         }
               else  {
                if ((x == 9) || (x == -3))  {
                birthpet="용띠"         }
                else  {
                 if ((x == 8) || (x == -4))  { 
                 birthpet="뱀띠"          }
                 else  {
                  if ((x == 7) || (x == -5))  { 
                  birthpet="말띠"          }
                  else  {
                   if ((x == 6) || (x == -6))  { 
                   birthpet="양띠"          }
                   else  {
                    if ((x == 5) || (x == -7))  {  
                    birthpet="원숭이띠"         }
                    else  {
                     if ((x == 4) || (x == -8))  {
                     birthpet="닭띠"        }
                     else  {
                      if ((x == 3) || (x == -9))  {
                      birthpet="개띠"            }
                      else  {
                       if ((x == 2) || (x == -10))  {
                       birthpet="돼지띠"             }  
                      }
                     }
                    }
                   }
                  }
                 }
                }
               }
              }
             }
            }
        document.frm.birth.value = birthpet;
}
// -->
</script>

<!--3. BODY 부분에 아래의 스크립트를 복사해 넣으세요-->
<p align=center>
<form NAME="frm">
희망 연도를 입력하세요
<input TYPE="text" SIZE="4" NAME="inyear" value="2000" onFocus="this.select()">년
<input TYPE="button" VALUE="확인" onClick="getpet()"> 
===============>
<input TYPE="text" SIZE="9" NAME="birth">입니다.
</form> 
 


  




130    페이지 로딩시 첫번째 필드의 특정 항목 자동선택 시키기   

 
<!--이 스크립트를 HEAD 부분에 복사해 넣으세요-->
<SCRIPT LANGUAGE="JavaScript">
<!-- Begin
function toForm() {
document.form.field1.focus();
// Replace field1 in the script with the field name of which you want to place the focus.
}
//  End -->
</script>
</HEAD>
<!--BODY 태그내에 onload="" 부분을 복사해 넣으세요-->
<BODY BGCOLOR="#FFFFFF" onLoad="toForm()">
<!--BODY 부분에 아래의 스크립트를 복사해 넣으세요-->
<FORM  NAME="form" METHOD="POST" ACTION="#">
<SELECT NAME="field1" SIZE="1">
<OPTION VALUE="one">첫번째필드-1
<OPTION VALUE="two">첫번째필드-2
</SELECT>
<BR>
<INPUT TYPE="TEXT" NAME="field2" SIZE="10"> Field 2<BR>
<INPUT TYPE="TEXT" NAME="field3" SIZE="10"> Field 3<BR>
<BR>
<INPUT TYPE="SUBMIT" NAME="submit" VALUE="Submit">  
<INPUT TYPE="RESET" onclick="toForm();">
</FORM>
 
 






129    영어공부-아라비아 숫자 읽기 

 
<!--1. 아래 스크립트를 HEAD 부분에 복사해 넣으세요. 없으면 그냥 두세요-->
<SCRIPT LANGUAGE="JavaScript">
var n = "";
function validate(input) {
if (input.length == 0) {
alert ('Please Enter A Number.');
document.myform.textver.value = "";
return true;
}
else convert(input);
}
function d1(x) { // single digit terms
switch(x) {
case '0': n= ""; break;
case '1': n= " One "; break;
case '2': n= " Two "; break;
case '3': n= " Three "; break;
case '4': n= " Four "; break;
case '5': n= " Five "; break;
case '6': n= " Six "; break;
case '7': n= " Seven "; break;
case '8': n= " Eight "; break;
case '9': n= " Nine "; break;
default: n = "Not a Number";
}
return n;
}
function d2(x) { // 10x digit terms
switch(x) {
case '0': n= ""; break;
case '1': n= ""; break;
case '2': n= " Twenty "; break;
case '3': n= " Thirty "; break;
case '4': n= " Forty "; break;
case '5': n= " Fifty "; break;
case '6': n= " Sixty "; break;
case '7': n= " Seventy "; break;
case '8': n= " Eighty "; break;
case '9': n= " Ninety "; break;
default: n = "Not a Number";
}
return n;
}
function d3(x) { // teen digit terms
switch(x) {
case '0': n= " Ten "; break;
case '1': n= " Eleven "; break;
case '2': n= " Twelve "; break;
case '3': n= " Thirteen "; break;
case '4': n= " Fourteen "; break;
case '5': n= " Fifteen "; break;
case '6': n= " Sixteen "; break;
case '7': n= " Seventeen "; break;
case '8': n= " Eighteen "; break;
case '9': n= " Nineteen "; break;
default: n=  "Not a Number";
}
return n;
}
function convert(input) {
var inputlength = input.length;
var x = 0;
var teen1 = "";
var teen2 = "";
var teen3 = "";
var numName = "";
var invalidNum = "";
var a1 = ""; // for insertion of million, thousand, hundred 
var a2 = "";
var a3 = "";
var a4 = "";
var a5 = "";
digit = new Array(inputlength); // stores output
for (i = 0; i < inputlength; i++)  {
digit[inputlength - i] = input.charAt(i)};
store = new Array(9); // store output
for (i = 0; i < inputlength; i++) {
x= inputlength - i;
switch (x) { // assign text to each digit
case x=9: d1(digit[x]); store[x] = n; break;
case x=8: if (digit[x] == "1") {teen3 = "yes"}
          else {teen3 = ""}; d2(digit[x]); store[x] = n; break;
case x=7: if (teen3 == "yes") {teen3 = ""; d3(digit[x])}
          else {d1(digit[x])}; store[x] = n; break;
case x=6: d1(digit[x]); store[x] = n; break;
case x=5: if (digit[x] == "1") {teen2 = "yes"}
          else {teen2 = ""}; d2(digit[x]); store[x] = n; break;
case x=4: if (teen2 == "yes") {teen2 = ""; d3(digit[x])}    
          else {d1(digit[x])}; store[x] = n; break;
case x=3: d1(digit[x]); store[x] = n; break;
case x=2: if (digit[x] == "1") {teen1 = "yes"}
          else {teen1 = ""}; d2(digit[x]); store[x] = n; break;
case x=1: if (teen1 == "yes") {teen1 = "";d3(digit[x])}     
          else {d1(digit[x])}; store[x] = n; break;
}
if (store[x] == "Not a Number"){invalidNum = "yes"};
switch (inputlength){
case 1:   store[2] = ""; 
case 2:   store[3] = ""; 
case 3:   store[4] = ""; 
case 4:   store[5] = "";
case 5:   store[6] = "";
case 6:   store[7] = "";
case 7:   store[8] = "";
case 8:   store[9] = "";
}
if (store[9] != "") { a1 =" Hundred, "} else {a1 = ""};
if ((store[9] != "")||(store[8] != "")||(store[7] != ""))
{ a2 =" Million, "} else {a2 = ""};
if (store[6] != "") { a3 =" Hundred "} else {a3 = ""};
if ((store[6] != "")||(store[5] != "")||(store[4] != ""))
{ a4 =" Thousand, "} else {a4 = ""};
if (store[3] != "") { a5 =" Hundred "} else {a5 = ""};
}
// add up text, cancel if invalid input found
if (invalidNum == "yes"){numName = "Invalid Input"}
else {
numName =  store[9] + a1 + store[8] + store[7] 
+ a2 + store[6] + a3 + store[5] + store[4] 
+ a4 + store[3] + a5 + store[2] + store[1];
}
store[1] = ""; store[2] = ""; store[3] = ""; 
store[4] = ""; store[5] = ""; store[6] = "";
store[7] = ""; store[8] = ""; store[9] = "";
if (numName == ""){numName = "Zero"};
document.myform.textver.value = numName;
return true;
}
</script>
</HEAD>
<!--2. BODY 태그내에 onload="" 혹은 onunload 부분이 있으면 복사해 넣으세요-->
 
<BODY BGCOLOR="#FFFFFF">
<!--3. BODY 부분에 아래의 스크립트를 복사해 넣으세요-->

<form name="myform">
<table border=0 width="100%">
<tr>
<td>아라비아 숫자:</td>
<td><input name="numver" size=9 maxlength=9> <input onclick="return validate(document.myform.numver.value)" type="button" value="숫자를 입력하세요"></td>
</tr>
<tr>
<td>영어로는 이렇게 읽습니다:</td>
<td><input name="textver" size="50" maxlength=50></td>
</tr>
<tr>
<td align=middle colspan=2> </td>
</tr>
</table>
    </div>
</form> 
 





128    간단한 웹메일 보내기

 
<!--이 스크립트를 HEAD 부분에 복사해 넣으세요-->
<script>
function sendIt(){
var toMail = theEmail.value var Subj = theSub.value
document.theForm.action = "mailto:" + toMail + "?Subject=" + Subj
}
</script>
</HEAD>
<BODY BGCOLOR="#FFFFFF">
<!--BODY 부분에 아래의 스크립트를 복사해 넣으세요-->
<p><small><strong><font face="Arial">받을 사람의 이메일 주소   </font></strong></small><input
type="text" name="theEmail" size="36"></p>
<p><strong><small><font face="Arial">제목</font></small></strong>:
      <input type="text" name="theSub" size="36"></p>
<form name="theForm" method="post" onSubmit="sendIt()" enctype="text/plain">
  <p><strong><small><font face="Arial">보내는 사람</font></small></strong>:
            <input type="text" name="theSender"
  size="36"></p>
  <p><strong><small><font face="Arial">내용</font></small></strong></p>
  <p><textarea rows="13" name="theMsg" cols="77"></textarea></p>
  <p><input type="submit" value="Send Message"></p>
</form> 
 







127    페이지 검색기   

<!--1. 아래 스크립트를 HEAD 부분에 복사해 넣으세요. 없으면 그냥 두세요-->
<SCRIPT LANGUAGE="JavaScript">
<!-- Begin
var NS4 = (document.layers);
var IE4 = (document.all);
var win = this;
var n   = 0;
function findInPage(str) {
var txt, i, found;
if (str == "")
return false;
if (NS4) {
if (!win.find(str))
while(win.find(str, false, true))
n++;
else
n++;
if (n == 0) alert(str + " was not found on this page.");
}
if (IE4) {
txt = win.document.body.createTextRange();
for (i = 0; i <= n && (found = txt.findText(str)) != false; i++) {
txt.moveStart("character", 1);
txt.moveEnd("textedit");
}
if (found) {
txt.moveStart("character", -1);
txt.findText(str);
txt.select();
txt.scrollIntoView();
n++;
}
else {
if (n > 0) {
n = 0;
findInPage(str);
}
else
alert(str + " was not found on this page.");
}
}
return false;
}
//  End -->
</script>

</HEAD>
<!--2. BODY 태그내에 onload="" 혹은 onunload 부분이 있으면 복사해 넣으세요-->
 
<BODY BGCOLOR="#FFFFFF">
<!--3. BODY 부분에 아래의 스크립트를 복사해 넣으세요-->
<form name=search onSubmit="return findInPage(this.string.value);">
현재 페이지에서 검색
<input name=string type=text size=15 onChange="n = 0;">
</form>
우리나라 대한민국 민주당 국민회의 한나라당 평민당 자민련 
 








 126    웹 서치 엔진
 
<script language="JavaScript">
function search2(){
var a= window.open("about:blank","b","width=200,height=300,resizable=no,maximizable=no")
var b = document.search.query2.value
var c = document.search.yahoo.value
var d = document.search.altavista.value
var e = document.search.webcrawler.value
var f = document.search.excite.value
var hp= document.search.home.value
a.document.write("<html>\n<head>\n<title>The C Zone</title>\n</head>")
a.document.write("<body bgcolor='#DAA520' vlink='#0000FF' alink='#FF0000'>\n")
a.document.write("<a href='"+c+b+"' target='main'>Yahoo!</a><br><br>\n")
a.document.write("<a href='"+d+b+"' target='main'>Altavista</a><br><br>\n")
a.document.write("<a href='"+e+b+"' target='main'>WebCrawler</a><br><br>\n")
a.document.write("<a href='"+f+b+"' target='main'>Excite</a><br><br>\n")
a.document.write("<a href='"+hp+"' target='main'>Home</a><br><br>\n")
a.document.close()
self.name = "main"
}
</script><form name="search">
<input type="hidden" name="yahoo" value="http://search.yahoo.com/search?p=">
<input type="hidden" name="altavista" value="http://www.altavista.com/cgi-bin/query?pg=q&
what=web&fmt=.&q=">
<input type="hidden" name="webcrawler" value="http://www.webcrawler.com/cgi-bin/WebQuery?
searchText=">
<input type="hidden" name="excite" value="http://www.excite.com/search.gw?trace=a&
search=">
<input type="hidden" name="lycos" value="http://www.lycos.com/cgi-bin/pursuit?query=">
<input type="hidden" name="hotbot" value="http://hotbot.lycos.com/?MT=">
<input type="hidden" name="looksmart" 
value="http://www.looksmart.com/r_search?l&iabw&search=0&key=">
<input type="hidden" name="home" value="file:///c:/my%20html/search2.html">
Search the internet for:
<input type="text" size="25" name="query2" class="fm"><br>
<input type="button" value="Search" onClick="search2()" class="fm"> <input type="reset" class="fm"
value=" Clear "><br>
<font style="font-size:8pt;">
(검색을 선택하면 원하는 검색엔진을 선택하는 창이 생깁니다)
</font>
</form> 
 







125    폼 내용 전송전 확인 메세지 띄우기 

 
<!--1. 아래 스크립트를 HEAD 부분에 복사해 넣으세요. 없으면 그냥 두세요-->
<SCRIPT LANGUAGE="JavaScript">
<!-- Begin
function onKeyPress () {
var keycode;
if (window.event) keycode = window.event.keyCode;
else if (e) keycode = e.which;
else return true;
if (keycode == 13) {    //엔터키를 눌렀을때
alert("전송하시려면 확인 버튼을 누르세요");
return false
}
return true 
}
document.onkeypress = onKeyPress;
//  End -->
</script>
</HEAD>
<!--2. BODY 태그내에 onload="" 혹은 onunload 부분이 있으면 복사해 넣으세요-->
<BODY BGCOLOR="#FFFFFF">
<!--3. BODY 부분에 아래의 스크립트를 복사해 넣으세요-->
<input type="text">
<input value="확인" type=submit onClick="alert('감사합니다. 입력하신 폼을 전송합니다');">


 
  





 124    폼 버튼 이름과 하이퍼링크가 계속 바뀌는 스트립트 
 
[스크립트]
//head 부분에 삽입
<SCRIPT LANGUAGE="JavaScript">
<!-- begin
// please help yourself to this code.
var startTime   =null;
var timerID     =null;
var initial     =new Date();
var pos         =0;
var menuItem    =null;
function initArray() {
this.length = initArray.arguments.length
   for (var i = 0; i < this.length; i++)      {
    this[i+1] = initArray.arguments[i]
   }
}
function parsemenuItem(data,num) {
for(var i=0;i<data.length;i++)  {
  if(data.substring(i,i+1)=="|")  break;
   }
   if (num==0) return(data.substring(0,i));
   else  return(data.substring(i+1,data.length));
}
function startTimer() {
   initial = new Date();
   startTime=initial.getTime();
   stopTimer();
   menuItem = new initArray("자바스크립트 메뉴화면|http://javascript.htm",
      "자바스크립트 메뉴화면|http://top.thm",
      "야후 코리아|http://yahoo.co.kr",
      "투표하기|http://",
      "방명록|http://",
      "심마니|http://",
      "자바스크립트 Q&A|",
      "Email|mailto:webmaster@javascript.co.kr");  // 원하는 사이트 제목과 주소를 형식에 맞추어 입력하세요.
   showTimer();
}
function stopTimer() {
   timerID=null;
   menuItem=null;
   //clearTimeout(timerID);
}
function showTimer() {
pos= (pos == menuItem.length) ? 1 : pos +1;
document.forms[0].elements[0].value=parsemenuItem(menuItem[pos],0);
   timerID=window.setTimeout('showTimer()',1500);
}
function goToUrl()  {
   //parent.welcome.location=parsemenuItem(menuItem[pos],1);
   this.location=parsemenuItem(menuItem[pos],1);
   return (false);
}
// end -->
</SCRIPT>
//body 부분에 삽입
<BODY onLoad= "window.startTimer()" BGCOLOR="#FFFFFF">
<FORM>
<CENTER><P>
<INPUT TYPE="button" VALUE="  WHERE TO? " NAME="goTo" onClick="window.goToUrl()">
</P></CENTER>
</FORM>


 


  






 123    누를 때마다 메시지가 바귀는 자바 버튼
 
// HEAD 에 들어갈 자바스크립트
<script language="JavaScript">
<!--
     function toggle( ) {
          var butval=document.FormName.ButtonName.value
          text=(butval==" 라라라 ")?" 룰룰루 " : " 하하하 " 
          //--* butval의 값이 (라라라)일경우 클릭하면 (룰룰루)가 나오고 
          //-- 아닐때는 클릭하면 (하하하)가 나온다. 
          document.FormName.ButtonName.value=text
}
//-->
</script>
// BODY 에 들어갈 폼 태그
<form name="FormName" method="get">
<input type="button" name="ButtonName" value=" 라라라 " onclick="toggle( )"> 
</form>
 
 





122    폼을 입력한 후 확인 시키고 다은 페이지로 이동하게 하는 스크립트

<SCRIPT LANGUAGE="JavaScript">
<!--- Hide script from old browsers.
var reccnt
var count_addrbook_from = 0
var t = 0
var count_user_entries
var total_corrections_index_number = 0
var total_current_corrections_sofar  = 0

var num_items_on_page
var page_item_count
var num_items_left_to_page
num_items_left_to_page = 0
addrbook = new Array(); 
storeck = new Array();
//*******************************************************************
//*******************************************************************
//for each input field entered it goes into a two dimentional array
//the input text field is then cleared - focus is adjusted 
//*******************************************************************
//*******************************************************************
function accept_form_data(){
    
   document.addr.count.value = ++reccnt;
   addrbook[t] = new Array(); 
   for (p=0; p < 5; p++) {
   addrbook[t][p] = document.addr.field[p].value; 
   document.addr.field[p].value = "";  
} 
document.addr.elements[1].focus();
  
          t++;
          count_user_entries = t; 
} 
//*******************************************************************
//*******************************************************************
//after user clicks finished data entry button then the labels are 
//shown 4 per page with a checkbox attached. the user checks the box 
//if corrections are necessary 
//*******************************************************************
//******************************************************************* 
function show_form_data() {
page_item_count = 0
if (count_user_entries - num_items_left_to_page > 4) {
   q = count_addrbook_from + 4; 
}
else {
   q = count_addrbook_from + (count_user_entries - num_items_left_to_page);
}
//******************************************************************* 
//the second window is opened and configured 
//******************************************************************* 
msgWindow=window.open('','xxxx',
'toolbar=no,scrollbars=no,status=no,location=no,resizable=yes,menu=no,width=400,height=480') 
//******************************************************************* 
//the second window is presented using html  
//*******************************************************************
msgWindow.document.write("<div align='center'>");
msgWindow.document.write("<form name='labels'>");
msgWindow.document.write("<table border=0>"); 
//msgWindow.document.write("<tr>");
//msgWindow.document.write("</tr>");
//******************************************************************* 
//first for array give new label second for gives items in label
//*******************************************************************  
       for (g=count_addrbook_from; g < q; g++){
        
            if (page_item_count == 2) msgWindow.document.write("</tr>"); 
            if (page_item_count == 2) msgWindow.document.write("<tr>");        
             
             msgWindow.document.write("<td width=144>");
             msgWindow.document.write("<input type='checkbox' name='check1' size=0>",
             '(check to correct)',"<br>") ;
             
         for (h=0; h < 5; h++){
             msgWindow.document.write(addrbook[g][h],"<br>");
             if (h == 4) msgWindow.document.write("<br><br>");
        } 
             msgWindow.document.write("</td>");
             page_item_count ++         
}
   msgWindow.document.write("</tr>");
   msgWindow.document.write("</table>");
   msgWindow.document.write("<input type='button' name='button3' value='next page' onClick='opener.calcpage()'>");
   msgWindow.document.write("</div>"); 
   msgWindow.document.write("</form>");
}
//*******************************************************************
//*******************************************************************
//first checks to see if any checkboxes checked. closes current    
//window in preparation of showing new window with next 4 labels     
//*******************************************************************
//*******************************************************************
function calcpage(){
        checkck();         
        msgWindow.close();
        num_items_left_to_page = num_items_left_to_page + 4 ;
        count_addrbook_from = count_addrbook_from + 4 ; 
        if (q < count_user_entries) {
           indent=window.setTimeout("show_form_data()",500);        
}
else{
           total_current_corrections_sofar = 0 ;
                show_form_corrections();
    }
}
//*******************************************************************
//*******************************************************************
//will stoe the relative position of checkbox increased by from index
//to give the true element number to look up in addrbook in order to
//show label to correct later on    
//*******************************************************************
//*******************************************************************
function checkck(){
  if (page_item_count == 1) {    
     if (msgWindow.document.labels.check1.checked == true) {
            storeck[total_corrections_index_number] = count_addrbook_from;
            total_corrections_index_number++  
}
}
  else {
     for (e=0; e < page_item_count; e++) {
         if (msgWindow.document.labels.check1[e].checked == true) {
             storeck[total_corrections_index_number] = e + count_addrbook_from;
             total_corrections_index_number++
} 
}
         
} 
} 
//*******************************************************************
//*******************************************************************
//if correction exits controls the showing of them     
//*******************************************************************
//******************************************************************* 
function show_form_corrections(){
    
  if (total_current_corrections_sofar > 0) {
      msgWindow2.close();
}
  if (total_current_corrections_sofar < total_corrections_index_number) { 
      indent2=window.setTimeout("showcorrections()",500);               
  }
}
//*******************************************************************
//*******************************************************************
//presents html to show corrections and on change in any field will
//change appropriate addrbook element   
//*******************************************************************
//*******************************************************************
function showcorrections(){
//******************************************************************* 
//the second window is opened and configured 
//******************************************************************* 
msgWindow2=window.open('','xxxxz',
'toolbar=no,scrollbars=no,status=no,location=no,resizable=yes,menu=no,width=600,height=500') 
//******************************************************************* 
//the second window is presented using html  
//*******************************************************************
msgWindow2.document.write("<div align='center'>");
msgWindow2.document.write("<b>this presents one correction screen at a time</b>"); 
msgWindow2.document.write("<form name='corrections'>");
msgWindow2.document.write("<table border=0>"); 
msgWindow2.document.write("<tr>");
msgWindow2.document.write("<td align='right'>");
msgWindow2.document.write("<b>name:</b>");
msgWindow2.document.write("</td>");
msgWindow2.document.write("<td align='left'>");
msgWindow2.document.write("<input type=text name='corrfld' size=30 onChange='opener.changename()'><br>");  
msgWindow2.document.write("</td>");
msgWindow2.document.write("</tr>");
msgWindow2.document.write("<tr>");
msgWindow2.document.write("<td align='right'>");
msgWindow2.document.write("<b>address:</b>");
msgWindow2.document.write("</td>");
msgWindow2.document.write("<td align='left'>");
msgWindow2.document.write("<input type=text name='corrfld' size=30 onChange='opener.changestreet()'><br>");  
msgWindow2.document.write("</td>");
msgWindow2.document.write("</tr>");
msgWindow2.document.write("<tr>");
msgWindow2.document.write("<td align='right'>");
msgWindow2.document.write("<b>city:</b>");
msgWindow2.document.write("</td>");
msgWindow2.document.write("<td align='left'>");
msgWindow2.document.write("<input type=text name='corrfld' size=15 onChange='opener.changecity()'><br>");  
msgWindow2.document.write("</td>");
msgWindow2.document.write("</tr>");
msgWindow2.document.write("<tr>");
msgWindow2.document.write("<td align='right'>");
msgWindow2.document.write("<b>state:</b>");
msgWindow2.document.write("</td>");
msgWindow2.document.write("<td align='left'>");
msgWindow2.document.write("<input type=text name='corrfld' size=2 onChange='opener.changestate()'><br>");  
msgWindow2.document.write("</td>");
msgWindow2.document.write("</tr>");
msgWindow2.document.write("<tr>");
msgWindow2.document.write("<td align='right'>");
msgWindow2.document.write("<b>zip:</b>");
msgWindow2.document.write("</td>");
msgWindow2.document.write("<td align='left'>");
msgWindow2.document.write("<input type=text name='corrfld' size=5 onChange='opener.changezip()'><br>");  
msgWindow2.document.write("</td>");
msgWindow2.document.write("</tr>");
//******************************************************************* 
//first for array give new label second for gives items in label
//*******************************************************************  
         for (h=0; h < 5; h++){
msgWindow2.document.corrections.corrfld[h].value = addrbook[storeck[total_current_corrections_sofar]][h];
        } 
   total_current_corrections_sofar++
  
   msgWindow2.document.write("</table>");
   msgWindow2.document.write("<input type='button' name='button4' value='next correction' onClick='opener.show_form_corrections()'>");        
   msgWindow2.document.write("</div>"); 
   msgWindow2.document.write("</form>");
} 
//*******************************************************************
//*******************************************************************
//processes actual change routine for name   
//*******************************************************************
//*******************************************************************
function changename(){
if (total_corrections_index_number == 1){
    addrbook[storeck][0] = msgWindow2.document.corrections.corrfld[0].value ; 
}
else{ 
    addrbook[storeck[total_current_corrections_sofar - 1]][0] = msgWindow2.document.corrections.corrfld[0].value ; 
}
}
//*******************************************************************
//*******************************************************************
//processes actual change routine for street
//*******************************************************************
//*******************************************************************
function changestreet(){
if (total_corrections_index_number == 1){
    addrbook[storeck][1] = msgWindow2.document.corrections.corrfld[1].value ; 
}
else{ 
    addrbook[storeck[total_current_corrections_sofar - 1]][1] = msgWindow2.document.corrections.corrfld[1].value ; 
}
}
//*******************************************************************
//*******************************************************************
//processes actual change routine for city   
//*******************************************************************
//*******************************************************************
function changecity(){
if (total_corrections_index_number == 1){
    addrbook[storeck][2] = msgWindow2.document.corrections.corrfld[2].value ; 
}
else{ 
    addrbook[storeck[total_current_corrections_sofar - 1]][2] = msgWindow2.document.corrections.corrfld[2].value ; 
}
}
//*******************************************************************
//*******************************************************************
//processes actual change routine for state   
//*******************************************************************
//*******************************************************************
function changestate(){
if (total_corrections_index_number == 1){
    addrbook[storeck][3] = msgWindow2.document.corrections.corrfld[3].value ; 
}
else{ 
    addrbook[storeck[total_current_corrections_sofar - 1]][3] = msgWindow2.document.corrections.corrfld[3].value ; 
}
}
//*******************************************************************
//*******************************************************************
//processes actual change routine for zip  
//*******************************************************************
//*******************************************************************
function changezip(){
if (total_corrections_index_number == 1){
    addrbook[storeck][4] = msgWindow2.document.corrections.corrfld[4].value ; 
}
else{ 
    addrbook[storeck[total_current_corrections_sofar - 1]][4] = msgWindow2.document.corrections.corrfld[4].value ; 
}
}
//*******************************************************************
//counter on form intialized and focus set for first text box 
//*******************************************************************
function firsttime(){
     
   reccnt = 1;
   document.addr.elements[1].focus();
   document.addr.count.value = reccnt;
}
// End the hiding here. -->
</SCRIPT>
</HEAD>
<!-- end of script --> 
<BODY onLoad="firsttime();">
<!************************* --> 
<!-- defines the input form -->
<!************************* --> 
<center>
<b>
tab to go from one field to next - 
a tab after zip field will present next data entry 
</b>
<form name="addr" >
<table border=0>
<tr>
<td>
<b>record count:</b>
</td>
<td>
<input type=text name="count" size=4><br>
</td>
</tr>
<tr>
<td align="right">
<b>name:</b>
</td>
<td align="left">
<input type=text name="field" size=30><br>
</td>
</tr>
<tr>
<td align="right">
<b>address:</b>
</td>
<td align="left"> 
<input type=text name="field" size=30><br>
</td>
</tr>
<tr>
<td align="right">
<b>city:</b>
</td>
<td align="left">
<input type=text name="field" size=15><br>
</td>
</tr>
<tr> 
<td align="right"> 
<b>state:</b>
</td>
<td align="left">
<input type=text name="field" maxlength=2 size=2><br>
</td>
</tr>
<tr>
<td align="right">
<b>zip:</b>
</td>
<td align="left">
<input type=text name="field" maxlength=5 size=5 onChange="accept_form_data();"><br>
</td>
</tr>
</table>
<input type="button" name="button2" value="click button when done" onClick="show_form_data();"> 
</form> 
 





121    앞으로, 뒤로 가기 버튼 

 
<FORM>
<INPUT TYPE="button" VALUE="  BACK  " onClick="history.go(-1)">
<INPUT TYPE="button" VALUE="FORWARD" onCLick="history.go(1)">
</FORM>. 
 





 


120    이메일 주소 체크하기 

<!---- [1단계] 아래의 소스코드를 <HEAD>와 </HEAD> 사이에 붙여 넣으세요 ---->
<SCRIPT LANGUAGE="Javascript">
<!--
function emailCheck (emailStr) {
/* The following pattern is used to check if the entered e-mail address
   fits the user@domain format.  It also is used to separate the username
   from the domain. */
var emailPat=/^(.+)@(.+)$/
/* The following string represents the pattern for matching all special
   characters.  We don't want to allow special characters in the address. 
   These characters include ( ) < > @ , ; : \ " . [ ]    */
var specialChars="\\(\\)<>@,;:\\\\\\\"\\.\\[\\]"
/* The following string represents the range of characters allowed in a 
   username or domainname.  It really states which chars aren't allowed. */
var validChars="\[^\\s" + specialChars + "\]"
/* The following pattern applies if the "user" is a quoted string (in
   which case, there are no rules about which characters are allowed
   and which aren't; anything goes).  E.g. "jiminy cricket"@disney.com
   is a legal e-mail address. */
var quotedUser="(\"[^\"]*\")"
/* The following pattern applies for domains that are IP addresses,
   rather than symbolic names.  E.g. joe@[123.124.233.4] is a legal
   e-mail address. NOTE: The square brackets are required. */
var ipDomainPat=/^\[(\d{1,3})\.(\d{1,3})\.(\d{1,3})\.(\d{1,3})\]$/
/* The following string represents an atom (basically a series of
   non-special characters.) */
var atom=validChars + '+'
/* The following string represents one word in the typical username.
   For example, in john.doe@somewhere.com, john and doe are words.
   Basically, a word is either an atom or quoted string. */
var word="(" + atom + "|" + quotedUser + ")"
// The following pattern describes the structure of the user
var userPat=new RegExp("^" + word + "(\\." + word + ")*$")
/* The following pattern describes the structure of a normal symbolic
   domain, as opposed to ipDomainPat, shown above. */
var domainPat=new RegExp("^" + atom + "(\\." + atom +")*$")

/* Finally, let's start trying to figure out if the supplied address is
   valid. */
/* Begin with the coarse pattern to simply break up user@domain into
   different pieces that are easy to analyze. */
var matchArray=emailStr.match(emailPat)
if (matchArray==null) {
  /* Too many/few @'s or something; basically, this address doesn't
     even fit the general mould of a valid e-mail address. */
        alert("유효한 이메일 주소가 아닌것 같습니다 (@ 와 . 체크)")
        return false
}
var user=matchArray[1]
var domain=matchArray[2]
// See if "user" is valid 
if (user.match(userPat)==null) {
    // user is not valid
    alert("사용자 이름이 틀립니다")
    return false
}
/* if the e-mail address is at an IP address (as opposed to a symbolic
   host name) make sure the IP address is valid. */
var IPArray=domain.match(ipDomainPat)
if (IPArray!=null) {
    // this is an IP address
          for (var i=1;i<=4;i++) {
            if (IPArray[i]>255) {
                alert("IP 주소가 틀렸습니다")
                return false
            }
    }
    return true
}
// Domain is symbolic name
var domainArray=domain.match(domainPat)
if (domainArray==null) {
        alert("도메인명이 맞지 않습니다")
    return false
}
/* domain name seems valid, but now make sure that it ends in a
   three-letter word (like com, edu, gov) or a two-letter word,
   representing country (uk, nl), and that there's a hostname preceding 
   the domain or country. */
/* Now we need to break up the domain to get a count of how many atoms
   it consists of. */
var atomPat=new RegExp(atom,"g")
var domArr=domain.match(atomPat)
var len=domArr.length
if (domArr[domArr.length-1].length<2 || 
    domArr[domArr.length-1].length>3) {
   // the address must end in a two letter or three letter word.
   alert("도메인명의 마지막 글자는 3글자거나 2자리의 국가코드 입니다")
   return false
}
// Make sure there's a host name preceding the domain.
if (len<2) {
   var errStr="이주소의 호스트명이 없군요!"
   alert(errStr)
   return false
}
// If we've gotten this far, everything's valid!
return true;
}
// -->
</script>
<!------------------------- 여기까지 ---------------------------------->
</head>
<BODY>
<center>

<!---- [2단계] 아래의 방법으로 원하는 위치에 복사 해 넣으세요 ------------------>
<form name=emailform onSubmit="return emailCheck(this.email.value);">
이메일 주소를 입력 하세요 :  <input type=text name="email"><br>
<input type=submit value="Submit">
</form>
<!------------------------- 여기까지 ---------------------------------->
 
 


  




119    첫글자를 대문자로 바꾸어주기   

 
<!---- [1단계] 아래의 소스코드를 <HEAD>와 </HEAD> 사이에 붙여 넣으세요 ---->
<SCRIPT LANGUAGE="JavaScript">
<!-- 
function changeCase(frmObj) {
var index;
var tmpStr;
var tmpChar;
var preString;
var postString;
var strlen;
tmpStr = frmObj.value.toLowerCase();
strLen = tmpStr.length;
if (strLen > 0)  {
for (index = 0; index < strLen; index++)  {
if (index == 0)  {
tmpChar = tmpStr.substring(0,1).toUpperCase();
postString = tmpStr.substring(1,strLen);
tmpStr = tmpChar + postString;
}
else {
tmpChar = tmpStr.substring(index, index+1);
if (tmpChar == " " && index < (strLen-1))  {
tmpChar = tmpStr.substring(index+1, index+2).toUpperCase();
preString = tmpStr.substring(0, index+1);
postString = tmpStr.substring(index+2,strLen);
tmpStr = preString + tmpChar + postString;
         }
      }
   }
}
frmObj.value = tmpStr;
}
//-->
</script>
<!------------------------- 여기까지 ---------------------------------->
</HEAD>

<BODY>
<!---- [2단계] 아래의 방법으로 원하는 위치에 복사 해 넣으세요 ------------------>
<center>
<form name=form>
<input type=text name=box value="type in here!">
<input type=button value="수정하기" onClick="javascript:changeCase(this.form.box)">
</form>
</center>
<!------------------------- 여기까지 ---------------------------------->
 
 






118    dHTML과 자바스크립트를 이용한 FORM 예제

 
<!---- [1단계] 아래의 소스코드를 <HEAD>와 </HEAD> 사이에 붙여 넣으세요 ---->
<STYLE type="text/css">
div.box {
        width: 602px;
        background:#e2e2e2;
        border:solid 1px; 
        border-color:#000000;
        }
A:link         {
        color: #FF5200; 
        text-decoration: none; 
        }
A:visited { 
        color: #CC3300; 
        text-decoration: none; 
        }
A:active { 
        color: #FF0000; 
        background: #c0c0c9; 
        text-decoration: none; 
        }
A:hover {
        color: #ffffff;
        background: #c0c0c0;
        }
</STYLE>
<!------------------------- 여기까지 ---------------------------------->
</HEAD>
<!---- [2단계] 아래의 방법으로 원하는 위치에 복사 해 넣으세요 ------------------>
<SCRIPT LANGUAGE = "JavaScript">
<!--
var numberOfWords = 10; // 필터링할 단어의 갯수
var message = "저속한 말은 사용금지";
var isProfane = new makeArray(numberOfWords);
var word = new makeArray(numberOfWords);
function checkForProfanity(usersInput) {
var temp = usersInput;
temp = temp.toLowerCase();
// 필터링할 금지단어 설정
word[1] = "shit";
word[2] = "fuck";
word[3] = "asshole";
word[4] = "ass";
word[5] = "cunt";
word[6] = "suck";
word[7] = "pussy";
word[8] = "cock";
word[9] = "cum";
word[10] = "penis";
for (var j = 1; j <= numberOfWords; j++) {
isProfane[j] = temp.indexOf(word[j]);
}

for (var j = 1; j <= numberOfWords; j++) {
   if (isProfane[j] != -1) {
      alert("Please refrain from using the word \'"+word[j]+"\' in this form.");
      usersInput = message;
      j = numberOfWords + 1; }
   else {}
}
      return usersInput;
}
function makeArray(n) {
   this.length = n
   for (var i = 1; i<=n; i++) {
       this[i] = new String();
   }
   return this;
}
//-->
</SCRIPT>
<!------------------------- 여기까지 ---------------------------------->
<!---- [2단계] <BODY> 태그안에 있는 코드를 복사 해 넣으세요 --------------->
<BODY bgcolor="#ffffff" link="#000000" vlink="#000000"  onload="loadDoc()">
<!---- [3단계] 아래의 방법으로 원하는 위치에 복사 해 넣으세요 ------------------>
<SCRIPT LANGUAGE = "JavaScript">
<!--
function testBox1(form) {
        Ctrl = form.key;
        if (Ctrl.value == "") {
                validatePrompt (Ctrl, "키워드를 입력 하세요")
                return (false);
        } else
                return (true);
}
//---------
function testBox2(form) {
        Ctrl = form.mfgname;
        if (Ctrl.value == "") {
                validatePrompt (Ctrl, "제조자명을 입력하세요")
                return (false);
        } else
                return (true);
}
//---------
function testBox3(form) {
        Ctrl = form.edc;
        if (Ctrl.value == "" || Ctrl.value.indexOf ('@', 0) == -1) {
                validatePrompt (Ctrl, "이메일 주소가 올바르지 않습니다")
                return (false);
        } else
                return (true);
}
//---------
function testBox4(form) {
        Ctrl = form.mfgpart;
        if (Ctrl.value.length != 5) {
                validatePrompt (Ctrl, "다섯글자를 입력 하세요")
                return (false);
        } else
                return (true);
}
//---------
function testBox5(form) {
        Ctrl = form.hiprice;
        if (Ctrl.value.length < 2) {
                validatePrompt (Ctrl, "최소한 2자 이상 입력 하세요")
                return (false);
        } else
                return (true);
}
//---------
function runSubmit (form, button)  {
        if (!testBox1(form)) return;
        if (!testBox2(form)) return;
        if (!testBox3(form)) return;
        if (!testBox4(form)) return;
        if (!testBox5(form)) return;
        alert ("성공");
        document.test.submit();
        return;
}
//---------
function validatePrompt (Ctrl, PromptStr) {
        alert (PromptStr)
        Ctrl.focus();
        return;
}
function loadDoc() {
   document.test.key.focus ();
        return;
} 
// -->
</script>

</table>
<script language="JavaScript">
        function changeTip(a,b,c,d,e,f,g,h) {
                if (a.style.display =='') {
                        a.style.display = 'none';
                }
                else {
                        a.style.display='';
                        b.style.display='none';
                        c.style.display='none';
                        d.style.display='none';
                        e.style.display='none';
                        f.style.display='none';
                        g.style.display='none';
                        h.style.display='none';
                }
        }
function showDefault()        {
                tip.style.display='';
        }
function showKey()        {
                key.style.display='';
                linkKey.style.textDecoration='none';
                linkKey.style.cursor='hand';
                linkKey.style.color='#ff0000';
                linkKey.style.fontWeight='bold';
                linkKey.style.letterSpacing='0.1em';
        }
        function showCat()        {
                cat.style.display='';
                linkCat.style.textDecoration='none';
                linkCat.style.cursor='hand';
                linkCat.style.fontWeight='bold';
                linkCat.style.color='#ff0000';
        }
        function showMfg()        {
                mfg.style.display='';
                linkMfg.style.textDecoration='none';
                linkMfg.style.cursor='hand';
                linkMfg.style.fontWeight='bold';
                linkMfg.style.color='#ff0000';
        }
        function showSms()        {
                Sms.style.display='';
                linkSms.style.textDecoration='none';
                linkSms.style.cursor='hand';
                linkSms.style.fontWeight='bold';
                linkSms.style.color='#ff0000';
        }
        function showMfgPart()        {
                mfgPart.style.display='';
                linkMfgPart.style.textDecoration='none';
                linkMfgPart.style.cursor='hand';
                linkMfgPart.style.fontWeight='normal';
                linkMfgPart.style.color='#ff0000';
        }
        function showMax()        {
                max.style.display='';
                linkMax.style.textDecoration='none';
                linkMax.style.cursor='hand';
                linkMax.style.fontWeight='bold';
                linkMax.style.color='#ff0000';
        }
        function showMin()        {
                min.style.display='';
                linkMin.style.textDecoration='none';
                linkMin.style.cursor='hand';
                linkMin.style.fontWeight='bold';
                linkMin.style.color='#ff0000';
        }
        function hideDefault()        {
                tip.style.display='none';
        }
        function hideKey()        {
                key.style.display='none';
                linkKey.style.textDecoration='none';
                linkKey.style.cursor='hand';
                linkKey.style.color='#000000';
                linkKey.style.fontWeight='normal';
                linkKey.style.letterSpacing='';
        }
        function hideCat()        {
                cat.style.display='none';
                linkCat.style.textDecoration='none';
                linkCat.style.cursor='hand';
                linkCat.style.fontWeight='normal';
                linkCat.style.color='#000000';
        }
        function hideMfg()        {
                mfg.style.display='none';
                linkMfg.style.textDecoration='none';
                linkMfg.style.cursor='hand';
                linkMfg.style.fontWeight='normal';
                linkMfg.style.color='#000000';
        }
        function hideSms()        {
                Sms.style.display='none';
                linkSms.style.textDecoration='none';
                linkSms.style.cursor='hand';
                linkSms.style.fontWeight='normal';
                linkSms.style.color='#000000';
        }
        function hideMfgPart()        {
                mfgPart.style.display='none';
                linkMfgPart.style.textDecoration='none';
                linkMfgPart.style.cursor='hand';
                linkMfgPart.style.fontWeight='normal';
                linkMfgPart.style.color='#000000';
        }
        function hideMax()        {
                max.style.display='none';
                linkMax.style.textDecoration='none';
                linkMax.style.cursor='hand';
                linkMax.style.fontWeight='normal';
                linkMax.style.color='#000000';
        }
        function hideMin()        {
                min.style.display='none';
                linkMin.style.textDecoration='none';
                linkMin.style.cursor='hand';
                linkMin.style.fontWeight='normal';
                linkMin.style.color='#000000';
        }
</script>

        <table width="605" cellpadding=0 cellspacing=0 border=0>
                        <tr>
                                <td>
                                                <DIV ID=tiplink style="cursor: hand;" onClick="hideKey();hideCat();hideMfg();hideSms();hideMfgPart();hideMax();hideMin();showDefault();">
                                        <font face="helvetica,arial" size="4" color="black"><b>
                                        찾으시는 상품을 입력한 후 버튼을 클릭 하세요
                                        </b></font></div>
                                </td>
                        </tr>
                        <tr>
                                <td bgcolor="#000000">
                                        <img src="space.gif" width=1 height=2><br>
                                </td>
                        </tr>
                </table>
        <form name="test" action="#" method="POST">
        <table width=605 cellpadding=0 cellspacing=0 border=0>
                <tr>
                        <td width=400>
                        
                        <table border=0 cellpadding=0 cellspacing=0>
                        <tr><td bgcolor="#000000" rowspan=2>
                        <img src="/common/space.gif" width=1 height=1><br>
                        </td>
                        <td bgcolor="#000000">
                        <img src="/common/space.gif" width=1 height=1><br>
                        </td>
                        <td bgcolor="#000000" rowspan=2>
                        <img src="/common/space.gif" width=1 height=1><br>
                        </td>
                        </tr>
                        <tr>
                        <td>
                                <table bgcolor="#e2e2e2" cellpadding=4>
                                        <tr>
                                                <td colspan=2 width=380>
                                <font face="굴림" size="2" color="#ff0000">
                                
                                </font>
                                                </td>
                                        </tr>
                                        <tr>
                                                <td align=right>
                                                
                                                <DIV ID=linkKey style="cursor: hand;" onClick="showKey();hideCat();hideMfg();hideSms();hideMfgPart();hideMax();hideMin();hideDefault();">
                                                <font face="굴림" size="2">키워드</font>
                                                </div>
                                                </td>
                                                <td>
                                                <input size=20 name="key" value="" maxlength=50 onBlur = "this.value = checkForProfanity(this.value);" onFocus="showKey();hideCat();hideMfg();hideSms();hideMfgPart();hideMax();hideMin();hideDefault();">
                                                </td>
                                        </tr>
                                        <tr>
                                                <td align=right>
                                                <DIV ID=linkCat style="cursor: hand;" onClick="hideKey();showCat();hideMfg();hideSms();hideMfgPart();hideMax();hideMin();hideDefault();">
                                        <font face="굴림" size="2">제품 분류</font>
                                        </div>
                                </td>
                                <td>
                                        <SELECT NAME="category" onFocus="hideKey();showCat();hideMfg();hideSms();hideMfgPart();hideMax();hideMin();hideDefault();">
                                                <OPTION VALUE="">
                                                모든 항목
                                                <OPTION VALUE="A">
                                                악세사리
                                                <OPTION VALUE="CR">
                                                CD-ROM 드라이브
                                                <OPTION VALUE="MC">
                                                CPU 업그레이드
                                                <OPTION VALUE="D">
                                                Data storage
                                                <OPTION VALUE="C">
                                                데스크탑
                                                <OPTION VALUE="DC">
                                                Digital Imaging
                                                <OPTION VALUE="I">
                                                Input devices
                                                <OPTION VALUE="U">
                                                메모리 업그레이드
                                                <OPTION VALUE="MO">
                                                모뎀
                                                <OPTION VALUE="VM">
                                                모니터
                                                <OPTION VALUE="M">
                                                멀티미디어
                                                <OPTION VALUE="N">
                                                네트워킹
                                                <OPTION VALUE="L">
                                                노트북
                                                <OPTION VALUE="O">
                                                오피스 제품
                                                <OPTION VALUE="PD">
                                                PDA
                                                <OPTION VALUE="B">
                                                Power protection
                                                <OPTION VALUE="P">
                                                프린터
                                                <OPTION VALUE="SK">
                                                스캐너
                                                <OPTION VALUE="S">
                                                소프트웨어
                                                <OPTION VALUE="V">
                                                비디오카드
                                        </SELECT>
                                        </td>
                                        </tr>
                                        <tr>
                                        <td align=right>
                                        <DIV ID=linkMfg style="cursor: hand;" onClick="hideKey();hideCat();showMfg();hideSms();hideMfgPart();hideMax();hideMin();hideDefault();">
                                        <font face="굴림" size="2">제조사의 이름</font>
                                        </div>
                                        </td>
                                        <td>
                                        <input size=20 name="mfgname" value="" maxlength=30 onBlur = "this.value = checkForProfanity(this.value);" onFocus="hideKey();hideCat();showMfg();hideSms();hideMfgPart();hideMax();hideMin();hideDefault();">
                                        </td></tr>
                                        <tr>
                                        <td align=right>
                                        <DIV ID=linkSms style="cursor: hand;" onClick="hideKey();hideCat();hideMfg();showSms();hideMfgPart();hideMax();hideMin();hideDefault();">
                                        <font face="굴림" size="2">이메일 주소</font>
                                        </div>
                                        </td>
                                        <td>
                                        <input size=20 name="edc" value="" maxlength=30 onBlur = "this.value = checkForProfanity(this.value);" onFocus="hideKey();hideCat();hideMfg();showSms();hideMfgPart();hideMax();hideMin();hideDefault();">
                                        </td>
                                        </tr>
                                        <tr>
                                        <td align=right>
                                        <DIV ID=linkMfgPart style="cursor: hand;" onClick="hideKey();hideCat();hideMfg();hideSms();showMfgPart();hideMax();hideMin();hideDefault();">
                                        <font face="굴림" size="2">제품의 부품번호</font>
                                        </div>
                                        </td>
                                        <td>
                                        <input size=20 name="mfgpart" value="" maxlength=30 onBlur = "this.value = checkForProfanity(this.value);" onFocus="hideKey();hideCat();hideMfg();hideSms();showMfgPart();hideMax();hideMin();hideDefault();">
                                        </td>
                                        </tr>
                                        <tr>
                                        <td align=right>
                                        <DIV ID=linkMax style="cursor: hand;" onClick="hideKey();hideCat();hideMfg();hideSms();hideMfgPart();showMax();hideMin();hideDefault();">
                                        <font face="굴림" size="2">최고 가격</font>
                                        </div>
                                        </td>
                                        <td>
                                        <input size=20 name="hiprice" value="" maxlength=30 onBlur = "this.value = checkForProfanity(this.value);" onFocus="hideKey();hideCat();hideMfg();hideSms();hideMfgPart();showMax();hideMin();hideDefault();">
                                        </td>
                                        </tr>
                                        <tr>
                                        <td align=right>
                                        <DIV ID=linkMin style="cursor: hand;" onClick="hideKey();hideCat();hideMfg();hideSms();hideMfgPart();hideMax();showMin();hideDefault();">
                                        <font face="굴림" size="2">최저 가격</font>
                                        </div>
                                        </td>
                                        <td>
                                        <input size=20 name="lowprice" value="" maxlength=30 onBlur = "this.value = checkForProfanity(this.value);" onFocus="hideKey();hideCat();hideMfg();hideSms();hideMfgPart();hideMax();showMin();hideDefault();">
             
 






117    다른사람에게 이메일 보내기 

 
<!---- [1단계] 아래의 소스코드를 <HEAD>와 </HEAD> 사이에 붙여 넣으세요 ---->
<SCRIPT LANGUAGE="JavaScript">
<!-- 
function mailsome1(){
who=prompt("받을사람의 이메일 주소를 입력 하세요 : ","his@domain.com");
what=prompt("메일 제목을 입력 하세요 : ","안녕하세요");
if (confirm(who+" 에게 "+what+" 의 제목으로 편지를 보내겠습니까?")==true){
parent.location.href='mailto:'+who+'?subject='+what+'';
   }
}
//-->
</SCRIPT>
<BODY>
<CENTER>
<a href='javascript:mailsome1()'>편지 보내기</a>
<FORM>
<input type=button value="편지 보내기" onClick="mailsome1()">
</FORM>
<!------------------------- 여기까지 ---------------------------------->
 
 


  





116    지정된 문자수가 채워지면 자동으로 다음칸으로 이동되는 스크립트 

 
<!---- [1단계] 아래의 소스코드를 <HEAD>와 </HEAD> 사이에 붙여 넣으세요 ---->
<SCRIPT LANGUAGE="JavaScript">
<!-- 
var isNN = (navigator.appName.indexOf("Netscape")!=-1);
function autoTab(input,len, e) {
var keyCode = (isNN) ? e.which : e.keyCode; 
var filter = (isNN) ? [0,8,9] : [0,8,9,16,17,18,37,38,39,40,46];
if(input.value.length >= len && !containsElement(filter,keyCode)) {
input.value = input.value.slice(0, len);
input.form[(getIndex(input)+1) % input.form.length].focus();
}
function containsElement(arr, ele) {
var found = false, index = 0;
while(!found && index < arr.length)
if(arr[index] == ele)
found = true;
else
index++;
return found;
}
function getIndex(input) {
var index = -1, i = 0, found = false;
while (i < input.form.length && index == -1)
if (input.form[i] == input)index = i;
else i++;
return index;
}
return true;
}
//  -->
</script>
<!------------------------- 여기까지 ---------------------------------->
<!---- [2단계] 아래의 방법으로 원하는 위치에 복사 해 넣으세요 ------------------>
<!----- return autoTab(this, 문자수, event); -------->
<form>
<table>
<tr>
<td>전화번호 : <br>
(
<small><input onKeyUp="return autoTab(this, 3, event);" size="4" maxlength="3"></small>) - 
<small><input onKeyUp="return autoTab(this, 4, event);" size="5" maxlength="4"></small> - 
<small><input onKeyUp="return autoTab(this, 4, event);" size="5" maxlength="4"></small>
</td>
</tr>
<tr>
<td>주민등록 번호 : <br>
<small><input onKeyUp="return autoTab(this, 6, event);" size="7" maxlength="6"></small> - 
<small><input onKeyUp="return autoTab(this, 7, event);" size="8" maxlength="7"></small>
</td>
</tr>
</table>
</form>
</center>
<!------------------------- 여기까지 ---------------------------------->
 
 







115    더 간단한 (할말만 적어보내는) 폼메일 

 
<!---- 아래의 방법으로 원하는 위치에 복사 해 넣으세요 ------------------>
<FORM method="get" action="mailto:your_id@domain.com?subject='이곳에 메일 제목을 입력 하세요'" enctype="text/plain">
<P align="center">
<TEXTAREA name="Comment" rows="6" cols="51">
여기에 내용을 입력하신후,
보내기를 누르면 저에게 메일로 보내집니다
</TEXTAREA>
<BR> 
<INPUT type="submit" value="보내기"> </P>
</FORM>
<!------------------------- 여기까지 ---------------------------------->
 
 






114    입력 내용을 미리 보고 폼메일로 보내자 

 
<!---- [1단계] 아래의 소스코드를 <HEAD>와 </HEAD> 사이에 붙여 넣으세요 ---->
<script Language="JavaScript">
<!--
function add(){
var m1 = (document.form1.first.value + " " + document.form1.last.value);
var m2 = "     "
var m3 = (document.form1.apt.value + " " + document.form1.street.value);
var m4 = "     "
var m5 = (document.form1.city.value + " " + document.form1.province.value);
var m6 = "     "
var m7 = (document.form1.country.value + " " + document.form1.postal.value);
var msg=(m1 + m2 + m3 + m4 + m5 + m6 + m7);
document.form1.full.value =msg;
}
//-->
</script>
<!------------------------- 여기까지 ---------------------------------->
</head>
<body>
<center>
<!---- [2단계] 아래의 방법으로 원하는 위치에 복사 해 넣으세요 ------------------>
<form name="form1" method="post" action="mailto:help@jasko.co.kr" enctype=text/plain>
이름<BR>
<input name="name" type="text" onblur="add()"><BR>
닉네임<BR>
<input name="nick_name" type="text" onblur="add()"><BR>
주소<BR>
<input name="address" type="text" onblur="add()"><BR>
지역<BR>
<input name="area" type="text" onblur="add()"><BR>
국가<BR>
<input name="nation" type="text" onblur="add()"><BR>
홈페이지<BR>
<input name="home" type="text" onblur="add()"><BR>
이메일주소<BR>
<input name="email" type="text" onblur="add()"><BR>
취미<BR>
<input name="hobby" type="text" onblur="add()"><BR>
전체 내용<BR>
<textarea name="full" cols="25" rows="4" wrap=no></textarea><BR>
<input type="submit" name="Submit" value="보내기">
<input type="reset" name="Reset" value="다시쓰기">
</form>
<!------------------------- 여기까지 ---------------------------------->
 
 







113    팝업창에서 확인하는 간단한 폼메일 스크립트입니다 

 
<!---- [1단계] 아래의 방법으로 원하는 위치에 복사 해 넣으세요 ------------------>
<script language="JavaScript">
<!--
function writ()
{
newwin=open('','newwin','scrollbars=0','width=100,height=100');
newwin.document.writeln("<html><body>");
newwin.document.writeln("<form action=mailto:your_id@domain.com?subject='메일제목을 입력 하세요' method=post enctype=text/plain>");
newwin.document.writeln("<p><a name=button></a><input type=submit value=보내기></p>");
newwin.document.writeln("<p>이름 : <input type=text name=Name value="+document.letter.name.value+"></p>");
newwin.document.writeln("<p>이메일: <input type=text name=E-mail_address value="+document.letter.email.value+"></p>");
newwin.document.writeln("<p>사는곳: <input type=text name=State value="+document.letter.state.value+"></p>");
newwin.document.writeln("<p>내용:<br><textarea name=Comments rows=10 cols=30>"+document.letter.com.value+"</textarea></p>");
newwin.document.writeln("</body></html>");
}
//-->
</script>
<center>버튼을 클릭하면 팝업창이 뜹니다</center>
<form name="letter">
<p>이름 : <input type="text" name="name"></p>
<p>E-mail : <input type="text" name="email"></p>
<p>사는곳 : <input type="text" name="state"></p>
<p>내용 :<br><textarea name="com" cols="30" rows="10"></textarea></p>
<input type="button" value="확인" onClick="check()">
<script language="JavaScript">
function check() {
var name = document.letter.name.value;
var email = document.letter.email.value;
var state = document.letter.state.value;
var com = document.letter.com.value;
if(name==""){
alert("이름을 적어주세요");
}
if(email==""){
alert("이메일주소를 안적으셨네요");
}
if(state==""){
alert("사는곳이 분명치 않군요");
}
if(com==""){
alert("내용을 입력 하세요");
} else {
writ()
   }
}
</script>
<!------------------------- 여기까지 ---------------------------------->
 
 


  





112    이메일을 보내게 하는 간단한 스크립트 

 
<form>
<input type="button" value="Email Me" onClick="location.href='mailto:id@yourdomain.com'">
</form>
 
  






111    풀다운 메뉴로 전자메일을 골라 보내자  

 
<!---- [1단계] 아래의 방법으로 원하는 위치에 복사 해 넣으세요 ------------------>
<SCRIPT LANGUAGE="JavaScript">
<!--
function changePage(theform) {
num= theform.FriendSelect.selectedIndex;
if (num==1) {
        site = "mailto:adamite@bora.dacom.co.kr"; // 첫번재 이메일주소
        }
if (num==2) {
        site = "mailto:me@you.com"; // 두번재 이메일주소
        }
if (num==3) {
        site = "mailto:you@me.net"; // 세번재 이메일주소
        }
if (num==4) {
        site = "mailto:wow@this_is_cool.org"; // 네번재 이메일주소
        }
top.location.href=site;
}
//-->
</SCRIPT>
<!------------------------- 여기까지 ---------------------------------->
<!---- [2단계] 아래의 방법으로 원하는 위치에 복사 해 넣으세요 ------------------>

<CENTER>
<FORM>
<SELECT NAME="FriendSelect" ONCHANGE="changePage(this.form)">
<OPTION VALUE="" SELECTED>고르세요
<OPTION>웹마스터
<OPTION>최진실
<OPTION>주윤발
<OPTION>김영삼
</SELECT>
</FORM>
</CENTER>
<!------------------------- 여기까지 ---------------------------------->
 
 


  







 110    사용자의 정보와 의견 보내기 - 폼메일 


<!---- 아래의 방법으로 원하는 위치에 복사 해 넣으세요 ------------------>
<script language="JavaScript">
<!--
function validate_form() {
  validity = true; 
  if (!check_empty(document.form.NAME.value))
        { validity = false; alert('이름을 적어주세요'); }
  if (!check_email(document.form.EMAIL.value))
        { validity = false; alert('이메일주소가 아닙니다'); }
  if (!check_empty(document.form.DESCRIPTION.value))
        { validity = false; alert('내용을 적어 주세요'); }
  if (validity)
        alert ("감사합니다");
  return validity;
}
function check_empty(text) {
  return (text.length > 0); 
}
function check_email(address) {
  if ((address == "")
    || (address.indexOf ('@') == -1)
    || (address.indexOf ('.') == -1))
      return false;
  return true;
}
function check_url(address) {
  if ((address == "")
    || (address.indexOf ('http://') == -1)
    || (address.indexOf ('.') == -1))
      return false;
  return true;
}
// -->
</script>
<form action="mailto:help@jasko.co.kr" method="post">
        <p align="center">
        <font size="5">
        <strong><u>방명록</u></strong></font></p>
    <p>이름 : <input type="text" name="Name"  value="이름을 적어주세요" rows="1"><br>
    <p>이메일 주소 : <input type="text" name="Your E-mail address" value="이메일 주소를 적어주세요" rows="1"><br>
    <p>홈페이지 주소 : <input type="text" name="Web address"  value="http://" rows="1"></p>
    <p>사용하시는 브라우저 종류 : <input type="text" size="20" name="T1"></p>
    <p>이 홈페이지를 어떻게 보셨나요<br>
    <select name="verdict" size="1">
        <option value="No comments">노코멘트</option>
        <option value="Its ok">그럭저럭</option>
        <option value="Looks nice">좋은데요 </option>
        <option value="Looks great!">대단해요 </option>
        <option value="Well done!!!">우와!! 쥐긴다!!! </option>
    </select> </p>
    
        <p>하실 말씀</p>
    <p><textarea name="S1" rows="5" cols="31"></textarea><br>
    <input type="submit" name="Submit" value="Submit" onSubmit="mailto:help@jasko.co.kr"  onclick="window.location='http://www.jasko.co.kr';">

<!---- 위에서 이메일 주소를 변경하고, 메일을 보낸 후 이동할 곳의 주소로 수정 해 주세요 ---->
        <input  type="reset" name="Reset" value="Reset"> </p>
    <p> </p>
    </p>
</form>
<!------------------------- 여기까지 ---------------------------------->


 


  






109    간단한 Form Mail 

 
<!---- [1단계] 아래의 소스코드를 <HEAD>와 </HEAD> 사이에 붙여 넣으세요 ---->
<SCRIPT LANGUAGE="JavaScript">
<!-- 
function email()
{
    var add = document.form.To.value
    var subject = document.form.Subject.value
    document.form.action="mailto:your_id@domain.com"+add+"?subject="+subject;
}
//-->
</SCRIPT>
<!------------------------- 여기까지 ---------------------------------->
</head>
<body>
<!---- [2단계] 아래의 방법으로 원하는 위치에 복사 해 넣으세요 ------------------>
<FORM METHOD="post" NAME="form" ACTION="" onSubmit="email();return true" ENCTYPE="text/plain">
<TABLE BORDER=0>
  <TR>
   <TD ALIGN="right"><B>받을사람 :</B></TD>
   <TD ALIGN="left"><INPUT TYPE="text" NAME="To" SIZE=30></TD>
  </TR>
  <TR>
   <TD ALIGN="right"><B>제목 :</B></TD>
   <TD ALIGN="left"><INPUT TYPE="text" NAME="Subject" SIZE=30></TD>
  </TR>
  <TR>
   <TD ALIGN="right"><B>회신 주소 :</B></TD>
   <TD ALIGN="left"><INPUT TYPE="text" NAME="Reply-to" SIZE=30></TD>
  </TR>
  <TR>
   <TD VALIGN="top"><B>내용입력 :</B></TD>
   <TD ALIGN="left"><TEXTAREA COLS=40 ROWS=20 NAME="Message"></TEXTAREA>
</TD>
  </TR>
  <TR>
   <TD COLSPAN=2 ALIGN="center">
   <INPUT TYPE="submit" VALUE="보내기" >
   <INPUT TYPE="reset" VALUE="다시작성"></TD>
  </TR>
</TABLE>
</FORM>
<!------------------------- 여기까지 ---------------------------------->
 
 







108    RGB → HEX 코드로 간단하게 변환시키는 스크립트  

 
<!--1. <BODY></BODY> 부분에 아래의 스크립트를 복사해 넣으세요-->

<script language="JavaScript">
<!--
function RGBtoHex(R,G,B) {return toHex(R)+toHex(G)+toHex(B)}
function toHex(N) {
if (N==null) return "00";
N=parseInt(N); if (N==0 || isNaN(N)) return "00";
N=Math.max(0,N); N=Math.min(N,255); N=Math.round(N);
return "0123456789ABCDEF".charAt((N-N%16)/16)
      + "0123456789ABCDEF".charAt(N%16);
}
//-->
</script>
<CENTER><form name=rgb>
R:<input type=text name=r size=3 value=255>
G:<input type=text name=g size=3 value=255>
B:<input type=text name=b size=3 value=255>
<input type=button name=btn value="Convert to Hex"
onCLick="this.form.hex.value=RGBtoHex(this.form.r.value,this.form.g.value,this.form.b.value)">
<input type=text name=hex size=8>
</form>
</CENTER> 
 







107    HEX → RGB 스크립트

 
<!--1. <BODY></BODY> 부분에 아래의 스크립트를 복사해 넣으세요-->

<script language="JavaScript">
<!--
R = HexToR("#FFFFFF");
G = HexToG("#FFFFFF");
B = HexToB("#FFFFFF");
function HexToR(h) { return parseInt((cutHex(h)).substring(0,2),16) }
function HexToG(h) { return parseInt((cutHex(h)).substring(2,4),16) }
function HexToB(h) { return parseInt((cutHex(h)).substring(4,6),16) }
function cutHex(h) { return (h.charAt(0)=="#") ? h.substring(1,7) : h}
//-->
</script>

<CENTER>
<form name=rgb>
<input type=text name=hex size=8 value="FFFFFF">
<input type=button name=btn value="Convert to RGB"
onCLick="this.form.r.value=HexToR(this.form.hex.value);
this.form.g.value=HexToG(this.form.hex.value);
this.form.b.value=HexToB(this.form.hex.value);
">
R:<input type=text name=r size=3>
G:<input type=text name=g size=3>
B:<input type=text name=b size=3>
</form>
</CENTER> 
 







106    파일내 텍스트 서치 엔진

 
<!--1. <BODY></BODY> 부분에 아래의 스크립트를 복사해 넣으세요-->

<CENTER>
<form name="f1" action="" onSubmit="if(this.t1.value!=null && this.t1.value!='') findString(this.t1.value);return false">
<input type="text" name=t1 value="" size=20>
<input type="submit" name=b1 value="Find">
</form>
</CENTER>
<script language="JavaScript">
<!--
var TRange=null
function findString (str) {
if (parseInt(navigator.appVersion)<4) return;
var strFound;
if (navigator.appName=="Netscape") {
  // 네츠케이프
  strFound=self.find(str);
  if (!strFound) {
   strFound=self.find(str,0,1)
   while (self.find(str,0,1)) continue
  }
}
if (navigator.appName.indexOf("Microsoft")!=-1) {
  // 익스플로러
  if (TRange!=null) {
   TRange.collapse(false)
   strFound=TRange.findText(str)
   if (strFound) TRange.select()
  }
  if (TRange==null || strFound==0) {
   TRange=self.document.body.createTextRange()
   strFound=TRange.findText(str)
   if (strFound) TRange.select()
  }
}
if (!strFound) alert ("찾으시는 검색어 '"+str+"' 가 없습니다")
}
//-->
</script> 
 







105    플래쉬 효과가 나는 하이퍼링크 텍스트 스크립트 

 
■ IE4.x
<!--1. <BODY></BODY> 부분에 아래의 스크립트를 복사해 넣으세요-->
<SCRIPT>
<!--
var x,y
var timer
var i_fadestrength=5
var step=1
var maxfontsize=180
var fontsizefactor=maxfontsize/100
var content
function cursorposition(e){
        x=event.clientX+document.body.scrollLeft
        y=event.clientY+document.body.scrollTop
}
function showmessage(whatmessage, whatfont, whatcolor) {
        if (document.all) {
                content="<nobr><font color="+whatcolor+" face="+whatfont+">"+whatmessage+"</font><nobr>"
                ring.innerHTML=content
                resizemessage()
        }
}
function resizemessage() {
if (document.all) {
        ring.filters.alpha.opacity=Math.floor(100-i_fadestrength)
        if (i_fadestrength>=120) {i_fadestrength=0;step=1}
        document.all.ring.style.visibility="visible"
        document.all.ring.style.fontSize=i_fadestrength*fontsizefactor
        document.all.ring.style.posLeft=x-(Math.floor(i_fadestrength/1.3*fontsizefactor))
        document.all.ring.style.posTop=y-(Math.floor(i_fadestrength/1.4*fontsizefactor))        
        step+=1.5
        i_fadestrength+=step
        timer=setTimeout("resizemessage()",50)
}
}
function hidemessage(e){
if (document.all) {
        clearTimeout(timer)
        document.all.ring.style.visibility="hidden"
        i_fadestrength=5
        step=1
}
}
if (document.all) {
        document.onmousemove=cursorposition;
}
if (document.all) {
        document.write("<DIV id='ring' style='position:absolute;font-family:Verdana;filter:alpha(opacity=0);'></DIV>")
        document.write("<DIV style='position:relative;'>")
}
//-->
</SCRIPT>
<CENTER><a href="http://www.mybizs.com" onMouseOver="showmessage('HELLO','Arial black','red')" onMouseOut="hidemessage()">이곳은 어디일까요</a> 
<a href="http://www.mybizs.com" onMouseOver="showmessage('메롱','굴림','FF0000')" onMouseOut="hidemessage()">그럼, 요기는요?</a> 
</CENTER>
 
 







104    HTML 코드를 특수문자로 바꾸어 주는 스크립트 

 
<CENTER>
<textarea style="width:200;height:100" name="n1">
샘플 :
<html>
<body>
</body>
</html>
</textarea><br>
<input type="button" onclick="txt=document.all.n1.value;hh()" value="OK"></CENTER>
<script>
// Plaese visit my website : http://www.mybizs.com
txt="";txt2="";txt3="";num=0
function hh(){
document.all.n1.value=Math.floor(num/txt.length*100)+"%"
txt3=txt.charAt(num)
if(txt3 == " "){txt3=" "};if(txt3 == "&"){txt3="&"};if(txt3 == "\""){txt3="""};if(txt3 == "<"){txt3="<"};if(txt3 == ">"){txt3=">"}
txt2=txt2+txt3
num++;if(num != txt.length){setTimeout("hh()",1)};else{document.all.n1.value=txt2}
}
</script 
 
 


  






103    상태바에서 남은 일/시를 알려주는 카운트 다운 폼 스크립트

 
<!--1. 아래의 스크립트를 <HEAD></HEAD>사이에 복사해 넣으세요-->
<script>
var futuredate
var nowdate
var resulthoursraw
var resulthours
var resultminutesraw
var resultminutes
var resultsecondsraw
var resultseconds
var content
function setfuturedate() {
        var futureyear=document.future.ye.options[document.future.ye.selectedIndex].value
        var futuremonth=document.future.mo.options[document.future.mo.selectedIndex].value
        var futureday=document.future.da.options[document.future.da.selectedIndex].value
        futuredate=new Date(futureyear,futuremonth,futureday,0,0,0)
        docountdown()
}
function docountdown() {
        caclulateresults()
        formatresults()
        displayresults()
        setTimeout("docountdown()",1000)
}
function caclulateresults() {
        nowdate=new Date()
        
        resultdaysraw=(Date.parse(futuredate)-Date.parse(nowdate))/1000/60/60/24
        resultdays=Math.floor((Date.parse(futuredate)-Date.parse(nowdate))/1000/60/60/24) 
        resulthoursraw=(resultdaysraw-resultdays)*24
        resulthours=Math.floor((resultdaysraw-resultdays)*24)
        resultminutesraw=(resulthoursraw-resulthours)*60
        resultminutes=Math.floor((resulthoursraw-resulthours)*60)
        resultsecondsraw=(resultminutesraw-resultminutes)*60
        resultseconds=Math.floor((resultminutesraw-resultminutes)*60)
}
function formatresults() {
        content="앞으로 "+resultdays+" 일 "+resulthours+"  시간 "+resultminutes +"  분 "+resultseconds +" 초가 남았습니다."
}
function displayresults() {
        if (document.all) {
                window.status=content
        }
        if (document.layers) {
                window.status=content
        }
}
</script>
</HEAD>
<!--2. <BODY> 태그내에 onload="" 혹은 onunload 부분이 있으면 복사해 넣으세요-->
<BODY BGCOLOR="#FFFFFF">
<!--3. <BODY></BODY> 부분에 아래의 스크립트를 복사해 넣으세요-->

<form name="future">
<font size=2 face=Verdana><b>카운트 다운</b><br>
D-day 를 선택한후 카운트 다운 버튼을 클릭하세요<br><br>
        <select name="ye" style="font-size:8pt">
                <option>year</option>
                <option value="2000">2000</option>
                <option value="2001">2001</option>
                <option value="2002">2002</option>
                <option value="2003">2003</option>
                <option value="2004">2004</option>
        </select>
        <select name="mo" style="font-size:8pt">
                <option>month</option>
                <option value="0">January</option>
                <option value="1">February</option>
                <option value="2">March</option>
                <option value="3">April</option>
                <option value="4">May</option>
                <option value="5">June</option>
                <option value="6">July</option>
                <option value="7">August</option>
                <option value="8">September</option>
                <option value="9">October</option>
                <option value="10">November</option>
                <option value="11">December</option>
        </select>
        <select name="da" style="font-size:8pt">
                <option>day</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
                <option value="13">13</option>
                <option value="14">14</option>
                <option value="15">15</option>
                <option value="16">16</option>
                <option value="17">17</option>
                <option value="18">18</option>
                <option value="19">19</option>
                <option value="20">20</option>
                <option value="21">21</option>
                <option value="22">22</option>
                <option value="23">23</option>
                <option value="24">24</option>
                <option value="25">25</option>
                <option value="26">26</option>
                <option value="27">27</option>
                <option value="28">28</option>
                <option value="29">29</option>
                <option value="30">30</option>
                <option value="31">31</option>        
        </select>
        <input type="button" onClick="setfuturedate()" value=" 카운트 다운 " style="font-size:8pt"></form> 
 







102    마우스 오버로 text-area 문자열 자동 선택시키기 

 
<textarea rows="4" name="S1" cols="39" onMouseOver="this.focus()"
onFocus="this.select()"><input type="text" name="emailaddr" value="your e-mail" size="31"  onMouseOver="this.focus()" onFocus="this.select()"> 
</textarea> 
 


 
 







101    각국의 화폐단위를 알아보자 - 콤보박스의 선택값 넘기기

 
<form method="POST" name="frm" action="">
  
  <p><select name="Country" size="1" onChange="text.value = Country[selectedIndex].value" style="background-color: rgb(255,0,0); color: rgb(255,255,0)">
    <option selected value="Dollar">USA</option>
    <option value="Hryvnia">Ukraine</option>
    <option value="Ruble">Russia</option>
    <option value="Yen">Japan</option>
    <option value="Franc ">French</option>
    <option value="Dollar ">HongKong</option>
    <option value="Yuan">Chinise</option>
    <option value="Schilling">Austria</option>
    <option value="Manat">Azerbaijan</option>
    <option value="East Caribbean Dollar">Antigua and Barbuda</option>
    <option value="Kwanza">Angola</option>
    <option value="Sucres">Ecuador</option>
    <option value="Pound">Egypt</option>
    <option value="Kroon">Estonia</option>
    <option value="Dollar">Bahamas</option>
    <option value="Taka">Bangladesh</option>
    <option value="Dollar">Barbados</option>
    <option value="Ruble">Belarus</option>
    <option value="Franc">Belgium</option>
    <option value="Bolivanio">Bolivia</option>
    <option value="DINAR">Bosnia and Herzegovina</option>
    <option value="Pula">Botswana</option>
    <option value="Ringgit">Malaysia</option>
    <option value="Brazilian Cruzeiro">Brazil </option>
    <option value="Pound Sterling">United Kingdom </option>
    <option value="Dirham">United Arab Emirates</option>
    <option value="Uzbek Sum">Uzbekistan </option>
  </select></p>

  <p><input type="text" name="text" size="20" style="color: rgb(0,0,255); background-color: rgb(255,255,0)"></p>
  <p><input type="reset" value="Reset" name="B2"></p>
</form> 
 


  






100    [전문가용] DHTML FORM  

 
<!--1. 아래의 스크립트를 <HEAD></HEAD>사이에 복사해 넣으세요-->
<STYLE type="text/css">
div.box {
        width: 602px;
        background:#3388BB;
        border:solid 1px; 
        border-color:#cccccc;
        }
.buttonup {
        width: 300px;
        background:#3388BB;
        border:solid 1px; 
        border-color:#cccccc;
        font-family: Verdana; 
        font-weight: normal; 
        font-size:10pt; 
        color:#FFFFFF; 
        cursor: hand;
        }
.buttonover {
        width: 300px;
        background:#ff3300;
        border:solid 1px; 
        border-color:white #808080 #808080  white;
        font-family: Verdana; 
        font-weight: bold; 
        font-size:10pt; 
        color:#FFFFFF; 
        cursor: hand;
        }
.buttondown {
        width: 300px;
        background:#ff3300;
        border:solid 1px; 
        border-color:#808080 white white #808080;
        font-family: Verdana; 
        font-weight: normal; 
        font-size:10pt; 
        color:#FFFFFF; 
        cursor: hand;
        }
A:link         {
        color: #BFDFFF; 
        text-decoration: none; 
        }
A:visited { 
        color: #CC3300; 
        text-decoration: none; 
        }
A:active { 
        color: #FF0000; 
        background: #BFDFFF; 
        text-decoration: none; 
        }
A:hover {
        color: #ffffff;
        background: #BFDFFF;
        }
A.hol {color: #804040}
FORM         {
        margin:0px;
        margin-bottom:10px;
        }
INPUT        {
        background-color: #CCCCCC;
        color:black;
        font-size: 10pt;
        border-color: #FFFFFF;
        }
SELECT        {
        background-color: #CCCCCC;
        margin-top: 2px;
        width=200px;
        }
.querytext {
        width=300px;
        }
.search {
        color:white;
        background-color: #FF3300;
        width: 80px;
        cursor:hand;
        font-size: 10pt;
        font-weight: bold;
        border-color: #cccccc;
        }
TEXTAREA {
        background-color: #CCCCCC;
        margin-top: 2px;
        width=200px;
        }
.date {
        margin-left:10px;
        margin-right:5px;
        color: #3388BB;
        font-size: 10pt;
        margin-top: 0px;
        font-family: verdana;
        font-weight:bold;
        }
</STYLE>
</HEAD>
<script language="JavaScript">
function doscreen(){ 
        window.moveTo(0,0)
        window.resizeTo(screen.Width+0,screen.Height-25)
}
</script>
<SCRIPT LANGUAGE="JavaScript">
      function checkLength() {
        var el = event.srcElement
        if (el.tagName=="INPUT")
          if (el.value.length+1>=el.maxLength) {
            var i = 0
            while (el!=el.form.elements[i])
              i++
            if (i==el.form.elements.length) i=-1
            el.form.elements[i+1].focus()
          }  
      }
</SCRIPT>
<!--this script is checkForPronaity V.2 by cacho@skynet.ca -->
<SCRIPT LANGUAGE = "JavaScript">
<!--
var numberOfWords = 32;
var message = "저속한 단어는 사용할 수 없습니다";
var isProfane = new makeArray(numberOfWords);
var word = new makeArray(numberOfWords);
function checkForProfanity(usersInput) {
var temp = usersInput;
temp = temp.toLowerCase();
// 금지된 단어들
word[1] = "shit";
word[2] = "fuck";
word[3] = "asshole";
word[4] = "ass";
word[5] = "cunt";
word[6] = "suck";
word[7] = "pussy";
word[8] = "cock";
word[9] = "cum";
word[10] = "penis";
word[11] = "nuts";
word[12] = " dick";
word[13] = "geek";
word[14] = "nerd";
word[15] = "fag";
word[16] = "idiot";
word[17] = "stupid";
word[18] = "bitch";
word[19] = "gimp";
word[20] = "dummy";
word[21] = "freak";
word[22] = "satan";
word[23] = "devil";
word[24] = "kill";
word[25] = "death";
word[26] = "damn";
word[27] = "gay";
word[28] = "lesbian";
word[29] = "sex";
word[30] = "condom";
word[31] = "brown stuff";
word[32] = "browner";
for (var j = 1; j <= numberOfWords; j++) {
isProfane[j] = temp.indexOf(word[j]);
}

for (var j = 1; j <= numberOfWords; j++) {
   if (isProfane[j] != -1) {
      alert("저속어 사용금지 \'"+word[j]+"\' ");
      usersInput = message;
      j = numberOfWords + 1;}
   else {}
}
      return usersInput;
}
function makeArray(n) {
   this.length = n
   for (var i = 1; i<=n; i++) {
       this[i] = new String();
   }
   return this;
}
//-->
</SCRIPT>
<SCRIPT LANGUAGE = "JavaScript">
<!--
function testBox1(form) {
        Ctrl = form.name;
        if (Ctrl.value == "") {
                validatePrompt (Ctrl, "이름입력")
                return (false);
        } else
                return (true);
}
//---------
function testBox2(form) {
        Ctrl = form.use;
        if (Ctrl.value.length < 2) {
                validatePrompt (Ctrl, "최소한 2글자 이상")
                return (false);
        } else
                return (true);
}
//---------
function testBox3(form) {
        Ctrl = form.mail;
        if ((Ctrl.value == "" || Ctrl.value.indexOf ('@', 0) == -1) || Ctrl.value.indexOf('.') == -1)  {
                validatePrompt (Ctrl, "이상한 멜 주소네요")
                return (false);
        } else
                return (true);
}
//---------
function testBox4(form) {
        Ctrl = form.state;
        if (Ctrl.value.length != 2) {
                validatePrompt (Ctrl, "2글자 이상")
                return (false);
        } else
                return (true);
}
//---------
function testBox6(form) {
        Ctrl = form.url;
        if ((Ctrl.value == "" || Ctrl.value.indexOf ('http://', 0) == -1) || Ctrl.value.indexOf('.') == -1)  {
                validatePrompt (Ctrl, "주소가 이상해여")
                return (false);
        } else
                return (true);
}
//---------
function testBox5(form) {
        if (form.state.value) {
                var states = 'ALAKAZARCACOCTDCDEFLGAHIIDILINIAKSKYLAMEMDMAMIMNMSMOMTNENVNHNJNMNYNCNDOHOKORPARISCSDTNTXUTVTVAWAWVWIWY00', numstates = states.length/2;
                for (var i = 0; i < numstates; i++) { if (form.state.value == states.substring(i*2,i*2+2)) { return true; } }
                alert('지역이 맞지 않습니다 \n 2글자로 된 영문 대문자만 허용');
                form.state.focus(); form.state.value = ""; 
        return false;
        }
return true;
}
//---------
function runSubmit (form, button)  {
        if (!testBox1(form)) return;
        if (!testBox2(form)) return;
        if (!testBox3(form)) return;
        if (!testBox4(form)) return;
        if (!testBox5(form)) return;
        if (!testBox6(form)) return;
        alert ("completed successfully");
        makeTest();
        document.test.submit();
        return;
}
//---------
function validatePrompt (Ctrl, PromptStr) {
        alert (PromptStr)
        Ctrl.focus();
        return;
}
function loadDoc() {
        // initial focus; use if needed
        //document.test.key.focus ();
        return;
} 
// -->
</script>
<!--this script inserts the current date and lets you know if this is a holiday-->
<SCRIPT LANGUAGE="Javascript">
function putDate(){
calendar = new Date();
day = calendar.getDay();
month = calendar.getMonth();
date = calendar.getDate();
year = calendar.getYear();
var dayname = new Array ("일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일");
var monthname = new Array ("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" );
document.write(dayname[day] + " - ");
document.write(monthname[month] + " ");
if (date < 10) document.write(date + ", ");
        else document.write(date + ", ");
if (year < 100)        document.write("19" + year + "    "); 
        else if (year > 1999) document.write(year + "    ");
document.write("<font color=804040>");
if ((month == 0) && (date == 1)) document.write("설날");
if ((month == 0) && (day == 1) && (date > 14) && (date < 23)) document.write("Martin Luther King's Birthday");
if ((month == 1) && (date == 12)) document.write("Lincoln's Birthday");
if ((month == 1) && (date == 14)) document.write("Valentine's Day");
if ((month == 1) && (day == 1) && (date > 14) && (date < 22)) document.write("President's Day");
if ((month == 1) && (date == 22) && (day == 1)) document.write("President's Day<BR>");
if ((month == 1) && (date == 22)) document.write("Washington's Birthday");
if ((month == 2) && (date == 17)) document.write("St. Patrick's Day");
if ((month == 3) && (day == 0) && (date > 0) && (date < 8)) document.write("Daylight Savings Time Begins");
if ((month == 4) && (day == 0) && (date > 7) && (date < 16)) document.write("Mother's Day");
if ((month == 4) && (day == 1) && (date > 24)) document.write("Memorial Day");
if ((month == 5) && (date == 14)) document.write("Flag Day");
if ((month == 5) && (day == 0) && (date > 15) && (date < 24)) document.write("Father's Day");
if ((month == 6) && (date == 4)) document.write("Independence Day");
if ((month == 8) && (day == 1) && (date > 0) && (date < 8)) document.write("Labor Day");
if ((month == 9) && (day == 1) && (date > 7) && (date < 16)) document.write("Columbus Day, ");
if ((month == 9) && (day == 0) && (date > 24) && (date < 31)) document.write("Daylight Savings Time Ends");
if ((month == 9) && (day == 0) && (date == 31)) document.write("Daylight Savings Time Ends<BR>");
if ((month == 9) && (date == 31)) document.write("Halloween");
if ((month == 10) && (date == 11)) document.write("Veteran's Day");
if ((month == 10) && (day == 4) && (date > 23) && (date < 30)) document.write("Thanksgiving");
if ((month == 10) && (date == 30) && (day == 4)) document.write("Thanksgiving");
if ((month == 11) && (date == 24)) document.write("크리스마스 이브");
if ((month == 11) && (date == 25)) document.write("크리스마스");
if ((month == 11) && (date == 31)) document.write("망년회 하는날");
if ((month == 9) && (date == 5)) document.write("<a class=hol href='http://www.chabad.org'>Sukkos (Jewish Holiday)</a>");
if ((month == 9) && (date == 12)) document.write("Sh'mini Atzeret (Jewish Holiday)");
if ((month == 9) && (date == 13)) document.write("Simchat Torah (Jewish - Israel Holiday)");
if ((month == 11) && (date == 14)) document.write("Hannukah (Jewish Holiday)");
if ((month == 1) && (date == 1)) document.write("Tu B'Shvat (Jewish - Israel Holiday)");
if ((month == 2) && (date == 2)) document.write("Purim (Jewish - Israel Holiday)");
if ((month == 3) && (date == 1)) document.write("Passover (Jewish Holiday)");
document.write("</font>");}
</SCRIPT>
<!--this script rotates words-->
    <SCRIPT LANGUAGE="JavaScript" ID=code>
      // Define set of words to rotate between
      // Note: You will see the actual appearance, rather than the raw source in the HTML page. 
      // Do a view-source to see the words description as defined in code.
      var words = new Array
        ("안녕하세요? 자스코 입니다", 
        "최고의 자바스크립트 소스뱅크",
        "쉬운 자바 베껴쓰는 자바", "자바 애플릿", 
        "CGI 스크립트 까지 맘대로 가져가세요");
      function rotateWords(elID) {
        // cycle through colors on the timer
        var el = document.all[elID];
        if (null==el.words) el.words = 0; // store color index on element
        if (++el.words==words.length) el.words=0;
        el.innerHTML = words[el.words];
      }
      function doLoad() {
        // Start up timer and pass in ID of element to insert words into
        // This can't be started until the page is loaded 
        setInterval("rotateWords('word')",2500) 
      }
      
    </SCRIPT>
    <script>
    function setStatus(msg){
    status = msg
    return true
    }
    </script>
<!--this is the DHTML that makes the discription appear etc-->
<script language="JavaScript">
        function changeTip(a,b,c,d,e,f,g,h) {
                if (a.style.display =='') {
                        a.style.display = 'none';
                }
                else {
                        a.style.display='';
                        b.style.display='none';
                        c.style.display='none';
                        d.style.display='none';
                        e.style.display='none';
                        f.style.display='none';
                        g.style.display='none';
                        h.style.display='none';
                }
        }
function doHead(){
                headline.filters.item(0).Apply();
                headline.style.visibility="visible";
                headline.filters.item(0).Play();
        }
function doBody(){
                bodytext.filters.item(0).Apply();
                bodytext.style.visibility="visible";
                bodytext.filters.item(0).Play();
        }
function showDefault()        {
                tip.style.display='';
        }
function showKey()        {
        if(key.filters.item(0).status != 2){
                key.filters.item(0).Apply();
                key.style.visibility="visible";
                key.filters.item(0).Play();
                key.style.display='';
                linkKey.style.textDecoration='none';
                linkKey.style.cursor='hand';
                linkKey.style.color='#ff0000';
                linkKey.style.fontWeight='bold';
        }
}
        function showCat()        {
        if(cat.filters.item(0).status != 2){
                cat.filters.item(0).Apply();
                cat.style.visibility="visible";
                cat.filters.item(0).Play();
                cat.style.display='';
                linkCat.style.textDecoration='none';
                linkCat.style.cursor='hand';
                linkCat.style.fontWeight='bold';
                linkCat.style.color='#ff0000';
        }
}
        function showMfg()        {
        if(mfg.filters.item(0).status != 2){
                mfg.filters.item(0).Apply();
                mfg.style.visibility="visible";
                mfg.filters.item(0).Play();
                mfg.style.display='';
                linkMfg.style.textDecoration='none';
                linkMfg.style.cursor='hand';
                linkMfg.style.fontWeight='bold';
                linkMfg.style.color='#ff0000';
        }
}
        function showSms()        {
        if(Sms.filters.item(0).status != 2){
                Sms.filters.item(0).Apply();
                Sms.style.visibility="visible";
                Sms.filters.item(0).Play();
                Sms.style.display='';
                linkSms.style.textDecoration='none';
                linkSms.style.cursor='hand';
                linkSms.style.fontWeight='bold';
                linkSms.style.color='#ff0000';
        }
}
        function showMfgPart()        {
        if(mfgPart.filters.item(0).status != 2){
                mfgPart.filters.item(0).Apply();
                mfgPart.style.visibility="visible";
                mfgPart.filters.item(0).Play();
                mfgPart.style.display='';
                linkMfgPart.style.textDecoration='none';
                linkMfgPart.style.cursor='hand';
                linkMfgPart.style.fontWeight='bold';
                linkMfgPart.style.color='#ff0000';
        }
}
        function showMax()        {
        if(max.filters.item(0).status != 2){
                max.filters.item(0).Apply();
                max.style.visibility="visible";
                max.filters.item(0).Play();
                max.style.display='';
                linkMax.style.textDecoration='none';
                linkMax.style.cursor='hand';
                linkMax.style.fontWeight='bold';
                linkMax.style.color='#ff0000';
        }
}
        function showMin()        {
        if(min.filters.item(0).status != 2){
                min.filters.item(0).Apply();
                min.style.visibility="visible";
                min.filters.item(0).Play();
                min.style.display='';
                linkMin.style.textDecoration='none';
                linkMin.style.cursor='hand';
                linkMin.style.fontWeight='bold';
                linkMin.style.color='#ff0000';
        }
}
        function hideDefault()        {
                tip.style.display='none';
        }
        function hideKey()        {
                key.style.display='none';
                linkKey.style.textDecoration='none';
                linkKey.style.cursor='hand';
                linkKey.style.color='#ffffff';
                linkKey.style.fontWeight='normal';
        }
        function hideCat()        {
                cat.style.display='none';
                linkCat.style.textDecoration='none';
                linkCat.style.cursor='hand';
                linkCat.style.fontWeight='normal';
                linkCat.style.color='#ffffff';
        }
        function hideMfg()        {
                mfg.style.display='none';
                linkMfg.style.textDecoration='none';
                linkMfg.style.cursor='hand';
                linkMfg.style.fontWeight='normal';
                linkMfg.style.color='#ffffff';
        }
        function hideSms()        {
                Sms.style.display='none';
                linkSms.style.textDecoration='none';
                linkSms.style.cursor='hand';
                linkSms.style.fontWeight='normal';
                linkSms.style.color='#ffffff';
        }
        function hideMfgPart()        {
                mfgPart.style.display='none';
                linkMfgPart.style.textDecoration='none';
                linkMfgPart.style.cursor='hand';
                linkMfgPart.style.fontWeight='normal';
                linkMfgPart.style.color='#ffffff';
        }
        function hideMax()        {
                max.style.display='none';
                linkMax.style.textDecoration='none';
                linkMax.style.cursor='hand';
                linkMax.style.fontWeight='normal';
                linkMax.style.color='#ffffff';
        }
        function hideMin()        {
                min.style.display='none';
                linkMin.style.textDecoration='none';
                linkMin.style.cursor='hand';
                linkMin.style.fontWeight='normal';
                linkMin.style.color='#ffffff';
        }
</script>
<!--make page-->
<script LANGUAGE="JavaScript">
function makeTest() {
story = "<HEAD><TITLE>Verification</TITLE><style>BODY{font-family:  verdana, arial, helvetica, sans-serif;font-size: 7.5px;        color: black; margin: 10;}TABLE{margin:0;}TD{font-family: verdana, arial, helvetica, sans-serif;font-size: 8pt;        color: black;}FORM{margin:0px;margin-bottom:10px;}A{ color: #31319C;text-decoration: none;font-weight:normal;}.text {font-family: verdana; font-size: 7.5pt; color: #BFDFFF; line-height: 14px; margin-left: 12; margin-right: 7;}A:hover{text-decoration: underline;}.toolbar {font-family: verdana; font-size: 9pt; font-weight: bold;}.toolbar1 {font-family:Garamond, Book Antiqua, Arial Narrow,arial; font-size: 12pt; font-weight: bold; color: #004891; letter-spacing:1px;}.bord {border: solid 1px; border-color:#808091 black #000000 #808091;}.box {border:solid 1px; border-color: #c0c0c0 black #808080 #c0c0c0;} .web {font-family: webdings; font-size: 7pt; font-weight: normal; text-decoration: none;} .dec {text-decoration: none; color:  #004891;font-size: 8pt;}.search {color:white;background-color: #FF3300;width: 102px;cursor:hand;font-size: x-small;font-weight: bold;border-color: #cccccc;}</style></HEAD>" + "<body bgcolor=#BFDFFF LINK=#0080C0 VLINK=#0080C0 margin-top=0 margin-left=0><A NAME=" + document.test.use.value + "></A><A NAME=top></A>" + "<FIELDSET class=bord STYLE='color: #000000; margin-left: 1; line-height: 19px;width: 97%'><LEGEND align=left class=toolbar1 width=100%>" + "  " + document.test.name.value + "    " + "<A HREF='mailto:" + document.test.mail.value + "'>" + document.test.mail.value + "</A></LEGEND>" + "<table border=0 cellspacing=0 width=100%>" + "<tr><td colspan=2 bgcolor=#000000 class=box><SPAN CLASS=toolbar STYLE='color: #ffffff'>  Contact Info</span></td><td bgcolor=#000000 class=box><SPAN CLASS=toolbar STYLE='color: #ffffff'>  Comments:</SPAN></td></tr>" + "<tr><td valign=middle width=40%>" + "<table border=1 bgcolor=#ffffff cellspacing=0 width=100% RULES=ROWS FRAME=BELOW BORDERCOLOR=#004891 BORDERCOLORDARK=#BFDFFF>" + "<tr><td colspan=2 width=100%><B>" + document.test.mess.value + "</B></td></tr>" + "<tr><td align=right><B>Username:</B></td><td align=right>" + document.test.use.value + "</td></tr>" + "<tr><td colspan=2><b>URL:</b></td></tr><tr>" + "<td align=right colspan=2><A HREF='" + document.test.url.value + "'>" + document.test.url.value + "</A></td></tr>" + "<tr><td align=right><B>State:</B></td><td align=right>" + document.test.state.value + "</td></tr></table>" + "</td><TD WIDTH=1></TD><td valign=top width=60%>" + "<table border=0 cellspacing=0 width=100%>" + "<tr><td valign=top width=100% bgcolor=#3388BB HEIGHT=100><br><div CLASS=text>" + document.test.comm.value + "</div></td></tr>" + "<tr><td align=right valign=bottom width=100% BGCOLOR=#004891><SPAN STYLE='font-size: 6.7pt; color: FFFFCC'>Posted:     At:   </SPAN></td></tr></table>" + "</td></tr></table></FIELDSET>" + "<br><center><font size=1 color=#004891><b>if the information above is correct click submit to sign my guestbook</b></font></center><br>" + "<form name='test' ACTION='http://members.aol.com/cgi-bin/guestbook/javadhtml/gbook.html' METHOD='POST' margin=0>" + "<input type='hidden' name='name' Value='" + document.test.name.value + "'>" + "<input type='hidden' name='mess' Value='" + document.test.mess.value + "'>" + "<input type='hidden' name='use' Value='" + document.test.use.value + "'>" + "<input type='hidden' name='mail' Value='" + document.test.mail.value + "'>" + "<input type='hidden' name='state' Value='" + document.test.state.value + "'>" + "<input type='hidden' name='url' Value='" + document.test.url.value + "'>" + "<input type='hidden' name='comm' Value='" + document.test.comm.value + "'>" + "<input type=hidden name=AllowHTML Value=yes>" + "<input type=hidden name=ResponsePage Value='http://members.aol.com/javadhtml/gbook.html#" + document.test.use.value + "'>" + "<center>" + "<input type=Submit name=Submit value=Submit class=search>" + "     <button onClick='window.close()' class=search>Close Window</button>" + "</center>" + "</form>" + "</body>"
TestWin = window.open("","",",width=600,height=220,scrollbars=yes");
TestWin.document.write(story);
TestWin.document.close();
}
</script>
<!--2. <BODY> 태그내에 onload="" 혹은 onunload 부분이 있으면 복사해 넣으세요-->
<BODY BGCOLOR="#FFFFFF">
<!--3. <BODY></BODY> 부분에 아래의 스크립트를 복사해 넣으세요-->
 
<BODY bgcolor="#BFDFFF" link="#000000" vlink="#000000"  onload="doscreen(); loadDoc(); doHead(); doLoad()"; doscreen();>
        <table width="605" cellpadding=0 cellspacing=0 border=0>
                        <tr>
                                <td align=right>
<DIV ID="headline"  style="FILTER: revealTrans(duration=2.8, Transition=12); VISIBILITY: hidden; WIDTH: auto;" onFilterChange="doBody();">
<div style="width: auto; filter: dropshadow(color=#dddddd, offx=1, offy=1, positive=1)">
                                                <DIV ID=tiplink align="right" style="cursor: hand;" onClick="hideKey();hideCat();hideMfg();hideSms();hideMfgPart();hideMax();hideMin();showDefault();">
                                        <font face="helvetica,arial" size="4" color="black"><b>
                                        DHTML & Javascript Form   
                                        </b></font></div>
</div>
</div>
                                </td>
                        </tr>
                        <tr>
                                <td bgcolor="#3388BB">
                                        <img src="space.gif" width=1 height=2><br>
                                </td>
                        </tr>
                </table>
<!--headline_end-->
<span class=date><script language="javascript">        putDate(); </script></span>
        <form name="test" ACTION="http://yourdomain.com" METHOD="POST" onkeypress="checkLength()">
        <table width=605 cellpadding=0 cellspacing=0 border=0>
                <tr>
                        <td width=400 valign=top height=340>
                        
                        <table border=0 cellpadding=0 cellspacing=0>
                        <tr><td bgcolor="#cccccc" rowspan=2>
                        <img src="/common/space.gif" width=1 height=1><br>
                        </td>
                        <td bgcolor="#cccccc">
                        <img src="/common/space.gif" width=1 height=1><br>
                        </td>
                        <td bgcolor="#cccccc" rowspan=2>
                        <img src="/common/space.gif" width=1 height=1><br>
                        </td>
                        </tr>
                        <tr>
                        <td>
                                <table bgcolor="#000000" cellpadding=4>
                                        <tr>
                                                <td colspan=2 width=380>
                                <font face="verdana,arial,helvetica" size="2" color="#ff0000">
                                
                                </font>
                                                </td>
                                        </tr>
                                        <tr>
<!--1-->                                
                                                <td align=right width=155>
                                                <DIV ID=linkKey style="cursor: hand; color:#ffffff;" onClick="showKey();hideCat();hideMfg();hideSms();hideMfgPart();hideMax();hideMin();hideDefault();">
                                                <font face="verdana,arial,helvetica"  size="2">성명</font>
                                                </div>
                                                </td>
<!--1a-->                                
                                                <td>
                                                <input size=20 name="name" value="" maxlength=50 onBlur = "this.value = checkForProfanity(this.value);" onFocus="showKey();hideCat();hideMfg();hideSms();hideMfgPart();hideMax();hideMin();hideDefault();">
                                                </td>
                                        </tr>
                                        <tr>
<!--2-->
                                                <td align=right>
                                                <DIV ID=linkCat style="cursor: hand; color:#ffffff;" onClick="hideKey();showCat();hideMfg();hideSms();hideMfgPart();hideMax();hideMin();hideDefault();">
                                        <font face="verdana,arial,helvetica" size="2">인터넷 커뮤니케이션</font>
                                        </div>
                                </td>
<!--2a-->
                                <td>
                                        <SELECT NAME="mess" onFocus="hideKey();showCat();hideMfg();hideSms();hideMfgPart();hideMax();hideMin();hideDefault();">
                                                <option value=""></option>
                                                <option value="ICQ:">ICQ:</option>
                                                <option value="AOLs Instant Messenger:">AOL's Instant Messenger:</option>
                                                <option value="Microsofts NetMeeting:">Microsoft's NetMeeting:</option>
                                                <option value="Mirc:">Mirc:</option>
                                                <option value="Other:">Other:</option>
                                        </SELECT>
                                        </td>
                                        </tr>
                                        <tr>
<!--3-->
                                        <td align=right>
                                        <DIV ID=linkMfg style="cursor: hand; color:#ffffff;" onClick="hideKey();hideCat();showMfg();hideSms();hideMfgPart();hideMax();hideMin();hideDefault();">
                                        <font face="verdana,arial,helvetica" size="2">사용자 이름 혹은 번호</font>
                                        </div>
                                        </td>
<!--3a-->
                                        <td>
                                        <input size=20 name="use" value="" maxlength=30 onBlur = "this.value = checkForProfanity(this.value);" onFocus="hideKey();hideCat();showMfg();hideSms();hideMfgPart();hideMax();hideMin();hideDefault();">
                                     
 







99    재미있는 기타코드 보여주기

 
<!-- 1. BODY 태그안에 아래와 같이 함수를 복사해 넣으세요 -->
<BODY BGCOLOR="#CCFF99" onLoad="setGuitar()">
<!-- 2. 아래와 같은 방법으로 BODY 부분에 스크립트를 입력하세요 -->
<CENTER><H2>기타코드 챠트</H2></CENTER>
<TABLE BORDER=2 WIDTH=160 ALIGN=CENTER>
<TR>
<TD BGCOLOR="orange" CELLPADDING=0 CELLSPACING=0 ALIGN=CENTER >
<FORM NAME="guitar">
<SCRIPT LANGUAGE="JavaScript">
<!-- 
var Timerid = 0;
var chords = new Object();
chords["A"] = "100000;1;5;14;15;16"
chords["A7"] = "100000;1;3;5;14;16"
chords["Am"]= "100000;1;5;10;14;15"
chords["Am7"]= "010001;30;32;33;34"
chords["A13"]= "100000;1;3;20;22;23"
chords["B7"] = "100000;4;8;13;15;17"
chords["C"] = "100000;3;5;10;14;19"
chords["D"] = "110000;2;15;17;22"
chords["D7"] = "110000;2;10;15;17"
chords["Dm"] = "110000;2;11;15;22"
chords["D9"] = "100000;26;31;33;34;35"
chords["E7"] = "000000;0;2;4;5;9;13"
chords["Em7"] = "000000;0;3;5;13;14;22"
chords["Eb9"] = "100000;20;25;27;28;29"
chords["E13"] = "000000;0;2;5;9;13;16"
chords["F"] = "110000;10;11;15;20"
chords["F5"] = "001111;6;19"
chords["G"] = "000000;2;3;4;13;18;23"
chords["G5"] = "001111;24;37"
chords["G7"] = "000000;2;3;4;11;13;18"
chords["Gmaj7"] = "010001;18;22;26;27"
chords["Gm7"] = "010001;18;20;21;22"
chords["G6"] = "010001;14;18;22;27"
chords["G6/9"] = "110000;14;15;22;23"
for (Countx = 1; Countx < 8; Countx++) {
        var Count, Countx;
        for (Count = 1; Count <7; Count++) {
                document.write ("<input type=radio onClick='toggle(this)'>")
        }
        document.write ("<BR>")
        if (Countx == 1)
                document.write ("<img src=black.gif width=150 height=3 align=absmiddle>")
        else
                document.write ("<img src=black.gif width=150 height=1 align=absmiddle>")
        document.write ("<BR>")
}
function toggle(button) {
        button.checked = !button.checked;
}
function resetGuitar() {
        var Count;
        clearTimeout(Timerid);
        for (Count=1; Count < 42; Count++) {
                document.guitar[Count-1].checked=false
        }
}
function flashString () {
        var Count;
        for (Count = 0; Count < 6; Count++) {
        if (Frets[1].substring(Count,Count+1) == "1")
                document.guitar[Count].checked = !document.guitar[Count].checked
        }
        Timerid = setTimeout ("flashString()", 500)
}
function setGuitar() {
        resetGuitar();
        var Item, Ret, Count, Temp, Skip;
        Item = document.guitar.chord.selectedIndex;
        if (Item != -1) {
                Text = document.guitar.chord.options[Item].text;
                Frets = parser (chords[Text])
                for (Count = 2; Count <= Frets[0]; Count++) {
                        Temp = parseInt(Frets[Count]);
                        document.guitar[Temp].checked=true;
                }
                if (parseInt(Frets[1]) > 0) 
                        flashString();
        }
}
function parser (InString)  {
        var Sep = ";", NumSeps=1, Count, Start, ParseMark, parse; 
        for (Count=1; Count < InString.length; Count++)  {
                if (InString.charAt(Count)==Sep)
                        NumSeps++;
        }
        parse = new Array ();
        var Start=0, Count=1, ParseMark=0, LoopCtrl=1;
        while (LoopCtrl==1)  {
                ParseMark = InString.indexOf(Sep, ParseMark);
                TestMark=ParseMark+0;
                if ((TestMark==0) || (TestMark==-1)){
                        parse[Count]= InString.substring (Start, InString.length);
                        LoopCtrl=0;
                        break;
                }
                parse[Count] = InString.substring (Start, ParseMark);
                Start=ParseMark+1, ParseMark=Start, Count++;
        }
        parse[0]=Count;
        return (parse);
}
// -->
</SCRIPT>
<P>
</TD></TR>
<TD ALIGN=CENTER BGCOLOR="gray">
<SELECT NAME="chord" SIZE=6>
<OPTION>A
<OPTION>A7
<OPTION>Am
<OPTION>Am7
<OPTION>A13
<OPTION>B7
<OPTION>C
<OPTION>D
<OPTION>D7
<OPTION>Dm
<OPTION>D9
<OPTION>E7
<OPTION>Em7
<OPTION>Eb9
<OPTION>E13
<OPTION>F
<OPTION>F5
<OPTION>G
<OPTION>G5
<OPTION>G7
<OPTION>Gmaj7
<OPTION>Gm7
<OPTION>G6
<OPTION>G6/9
</SELECT>
<HR>
<P>
<INPUT TYPE="button" VALUE=" 보기 " onClick="setGuitar()">
<INPUT TYPE="button" VALUE=" 지우기 " onClick="resetGuitar()"> 
</FORM>
</TD></TR>
</TABLE>
 
 






98    결제정보 및 배달지 정보 입력 받기 소스  

 
<BODY BGCOLOR="#CCFF99">
<!--  아래와 같은 방법으로 BODY 부분에 스크립트를 입력하세요 -->
<p>
<form name=calcform method=post>
<table border=0 cellpadding=0 cellspacing=1>
<tr><td colspan=2><font size=2 face=arial><B>결제자 정보:</B></td></tr>
<tr><td width=130 align=right><font size=2 face=arial><B>First Name:</B> </td>
<td nowrap><font size=3 face=arial><input type=hidden name="realname">
<input type=text name="firstn" size=12 onBlur="aname()"></td></tr>
<tr><td width=130 align=right><font size=2 face=arial><B>Last Name:</B> </td><td><font size=3 face=arial> <input type=text name="lastn" size=17 onBlur="aname()"></td></tr>
<tr><td align=right><font size=2 face=arial><B>Email:</B> </td><td><font size=3 face=arial> <input type=text name=email size=18></td></tr>
<tr><td align=right><font size=2 face=arial><B>Daytime Phone:</B> </td><td><font size=3 face=arial> <input type=text name=DayPhone size=18 value=""></td></tr>
<tr><td align=right><font size=2 face=arial><B>Company:</B> </td><td><font size=3 face=arial> <input type=text name=Company size=18 value=""></td></tr>
<tr><td align=right><font size=2 face=arial><B>Street:</B> </td><td><font size=3 face=arial> <input type=text name=Street size=18 value=""></td></tr>
<tr><td align=right><font size=2 face=arial><B>City:</B> </td><td><font size=3 face=arial> <input type=text name=City size=18 value=""></td></tr>
<tr><td align=right><font size=2 face=arial><B>State:</B> </td><td><font size=2 face=arial> <SELECT NAME=State onChange="calculate();"><OPTION VALUE=""><OPTION VALUE=AL>Alabama<OPTION VALUE=AK>Alaska<OPTION VALUE=AZ>Arizona<OPTION VALUE=AR>Arkansas<OPTION VALUE=CA>California<OPTION VALUE=CO>Colorado<OPTION VALUE=CT>Connecticut<OPTION VALUE=DE>Delaware<OPTION VALUE=DC>District Of Columbia<OPTION VALUE=FL>Florida<OPTION VALUE=GA>Georgia<OPTION VALUE=HI>Hawaii<OPTION VALUE=ID>Idaho<OPTION VALUE=IL>Illinois<OPTION VALUE=IN>Indiana<OPTION VALUE=IA>Iowa<OPTION VALUE=KS>Kansas<OPTION VALUE=KY>Kentucky<OPTION VALUE=LA>Louisiana<OPTION VALUE=ME>Maine<OPTION VALUE=MD>Maryland<OPTION VALUE=MA>Massachusetts<OPTION VALUE=MI>Michigan<OPTION VALUE=MN>Minnesota<OPTION VALUE=MS>Mississippi<OPTION VALUE=MO>Missouri<OPTION VALUE=MT>Montana<OPTION VALUE=NE>Nebraska<OPTION VALUE=NV>Nevada<OPTION VALUE=NH>New Hampshire<OPTION VALUE=NJ>New Jersey<OPTION VALUE=NM>New Mexico<OPTION VALUE=NY>New York<OPTION VALUE=NC>North Carolina<OPTION VALUE=ND>North Dakota<OPTION VALUE=OH>Ohio<OPTION VALUE=OK>Oklahoma<OPTION VALUE=OR>Oregon<OPTION VALUE=PA>Pennsylvania<OPTION VALUE=RI>Rhode Island<OPTION VALUE=SC>South Carolina<OPTION VALUE=SD>South Dakota<OPTION VALUE=TN>Tennessee<OPTION VALUE=TX>Texas<OPTION VALUE=UT>Utah<OPTION VALUE=VT>Vermont<OPTION VALUE=VA>Virginia<OPTION VALUE=WA>Washington<OPTION VALUE=WV>West Virginia<OPTION VALUE=WI>Wisconsin<OPTION VALUE=WY>Wyoming<OPTION VALUE="BC">British Columbia<OPTION VALUE="AB">Alberta<OPTION VALUE="SASK">Sask<OPTION VALUE="MAN">Manitoba<OPTION VALUE="ONT">Ontario<OPTION VALUE="QUE">Quebec<OPTION VALUE="MAR">Maritimes<OPTION VALUE="NF">Newfoundland</select></td></tr>
<tr><td align=right><font size=2 face=arial><B>Other State/Provence:</B> </td><td><font size=3 face=arial> <input type=text name=State2 size=18></td></tr>
<tr><td align=right><font size=2 face=arial><B>Zip:</B> </td><td><font size=3 face=arial> <input type=text name=Zip_code value="" size=8 maxlength=8> <font size=2 face=arial></td></tr>
<tr><td align=right><font size=2 face=arial><B>Country:</B> </td><td><font size=2 face=arial> <select name="Country">
<option value=US Selected>United States
<option value=CA >Canada
<option value=GB >United Kingdom
<option value=AF >Afghanistan
<option value=AL >Albania
<option value=DZ >Algeria
<option value=AS >American Samoa
<option value=AD >Andorra
<option value=AO >Angola
<option value=AI >Anguilla
<option value=AQ >Antarctica
<option value=AG >Antigua and Barbuda
<option value=AR >Argentina
<option value=AM >Armenia
<option value=AW >Aruba
<option value=AU >Australia
<option value=AT >Austria
<option value=AZ >Azerbaijan
<option value=BS >Bahamas
<option value=BH >Bahrain
<option value=BD >Bangladesh
<option value=BB >Barbados
<option value=BY >Belarus
<option value=BE >Belgium
<option value=BZ >Belize
<option value=BJ >Benin
<option value=BM >Bermuda
<option value=BT >Bhutan
<option value=BO >Bolivia
<option value=BA >Bosnia and Herzegovina
<option value=BW >Botswana
<option value=BV >Bouvet Island
<option value=BR >Brazil
<option value=IO >British Indian Ocean Territory
<option value=BN >Brunei Darussalam
<option value=BG >Bulgaria
<option value=BF >Burkina Faso
<option value=BI >Burundi
<option value=KH >Cambodia
<option value=CM >Cameroon
<option value=CV >Cape Verde
<option value=KY >Cayman Islands
<option value=CF >Central African Republic
<option value=TD >Chad
<option value=CL >Chile
<option value=CN >China
<option value=CX >Christmas Island
<option value=CC >Cocos (Keeling) Islands
<option value=CO >Colombia
<option value=KM >Comoros
<option value=CG >Congo
<option value=CK >Cook Islands
<option value=CR >Costa Rica
<option value=HR >Croatia
<option value=CU >Cuba
<option value=CY >Cyprus
<option value=CZ >Czech Republic
<option value=CI >C?e d'Ivoire
<option value=DK >Denmark
<option value=DJ >Djibouti
<option value=DM >Dominica
<option value=DO >Dominican Republic
<option value=TP >East Timor
<option value=EC >Ecuador
<option value=EG >Egypt
<option value=SV >El salvador
<option value=GQ >Equatorial Guinea
<option value=ER >Eritrea
<option value=EE >Estonia
<option value=ET >Ethiopia
<option value=FK >Falkland Islands
<option value=FO >Faroe Islands
<option value=FJ >Fiji
<option value=FI >Finland
<option value=FR >France
<option value=GF >French Guiana
<option value=PF >French Polynesia
<option value=TF >French Southern Territories
<option value=GA >Gabon
<option value=GM >Gambia
<option value=GE >Georgia
<option value=DE >Germany
<option value=GH >Ghana
<option value=GI >Gibraltar
<option value=GR >Greece
<option value=GL >Greenland
<option value=GD >Grenada
<option value=GP >Guadeloupe
<option value=GU >Guam
<option value=GT >Guatemala
<option value=GN >Guinea
<option value=GW >Guinea-Bissau
<option value=GY >Guyana
<option value=HT >Haiti
<option value=HM >Heard Island and McDonald Islands
<option value=VA >Holy See (Vatican City State)
<option value=HN >Honduras
<option value=HK >Hong Kong
<option value=HU >Hungary
<option value=IS >Iceland
<option value=IN >India
<option value=ID >Indonesia
<option value=IR >Iran
<option value=IQ >Iraq
<option value=IE >Ireland
<option value=IL >Israel
<option value=IT >Italy
<option value=JM >Jamaica
<option value=JP >Japan
<option value=JO >Jordan
<option value=KZ >Kazakstan
<option value=KE >Kenya
<option value=KI >Kiribati
<option value=KW >Kuwait
<option value=KG >Kyrgystan
<option value=LA >Lao
<option value=LV >Latvia
<option value=LB >Lebanon
<option value=LS >Lesotho
<option value=LR >Liberia
<option value=LY >Libyan Arab Jamahiriya
<option value=LI >Liechtenstein
<option value=LT >Lithuania
<option value=LU >Luxembourg
<option value=MO >Macau
<option value=MK >Macedonia (FYR)
<option value=MG >Madagascar
<option value=MW >Malawi
<option value=MY >Malaysia
<option value=MV >Maldives
<option value=ML >Mali
<option value=MT >Malta
<option value=MH >Marshall Islands
<option value=MQ >Martinique
<option value=MR >Mauritania
<option value=MU >Mauritius
<option value=YT >Mayotte
<option value=MX >Mexico
<option value=FM >Micronesia
<option value=MD >Moldova
<option value=MC >Monaco
<option value=MN >Mongolia
<option value=MS >Montserrat
<option value=MA >Morocco
<option value=MZ >Mozambique
<option value=MM >Myanmar
<option value=NA >Namibia
<option value=NR >Nauru
<option value=NP >Nepal
<option value=NL >Netherlands
<option value=AN >Netherlands Antilles
<option value=NT >Neutral Zone
<option value=NC >New Caledonia
<option value=NZ >New Zealand
<option value=NI >Nicaragua
<option value=NE >Niger
<option value=NG >Nigeria
<option value=NU >Niue
<option value=NF >Norfolk Island
<option value=KP >North Korea
<option value=MP >Northern Mariana Islands
<option value=NO >Norway
<option value=OM >Oman
<option value=PK >Pakistan
<option value=PW >Palau
<option value=PA >Panama
<option value=PG >Papua New Guinea
<option value=PY >Paraguay
<option value=PE >Peru
<option value=PH >Philippines
<option value=PN >Pitcairn
<option value=PL >Poland
<option value=PT >Portugal
<option value=PR >Puerto Rico
<option value=QA >Qatar
<option value=RE >Reunion
<option value=RO >Romania
<option value=RU >Russian Federation
<option value=RW >Rwanda
<option value=SH >Saint Helena
<option value=KN >Saint Kitts and Nevis
<option value=LC >Saint Lucia
<option value=PM >Saint Pierre and Miquelon
<option value=VC >Saint Vincent and the Grenadines
<option value=WS >Samoa
<option value=SM >San Marino
<option value=ST >Sao Tome and Principe
<option value=SA >Saudi Arabia
<option value=SN >Senegal
<option value=SC >Seychelles
<option value=SL >Sierra Leone
<option value=SG >Singapore
<option value=SK >Slovakia
<option value=SI >Slovenia
<option value=SB >Solomon Islands
<option value=SO >Somalia
<option value=ZA >South Africa
<option value=GS >South Georgia
<option value=KR >South Korea
<option value=ES >Spain
<option value=LK >Sri Lanka
<option value=SD >Sudan
<option value=SR >Suriname
<option value=SJ >Svalbard and Jan Mayen Islands
<option value=SZ >Swaziland
<option value=SE >Sweden
<option value=CH >Switzerland
<option value=SY >Syria
<option value=TW >Taiwan
<option value=TJ >Tajikistan
<option value=TZ >Tanzania
<option value=TH >Thailand
<option value=TG >Togo
<option value=TK >Tokelau
<option value=TO >Tonga
<option value=TT >Trinidad and Tobago
<option value=TN >Tunisia
<option value=TR >Turkey
<option value=TM >Turkmenistan
<option value=TC >Turks and Caicos Islands
<option value=TV >Tuvalu
<option value=UG >Uganda
<option value=UA >Ukraine
<option value=AE >United Arab Emirates
<option value=UM >United States Minor Outlying Islands
<option value=UY >Uruguay
<option value=UZ >Uzbekistan
<option value=VU >Vanuatu
<option value=VE >Venezuela
<option value=VN >Viet Nam
<option value=VG >Virgin Islands (British)
<option value=VI >Virgin Islands (U.S.)
<option value=WF >Wallis and Futuna Islands
<option value=EH >Western Sahara
<option value=YE >Yemen
<option value=YU >Yugoslavia
<option value=ZR >Zaire
<option value=ZM >Zambia
<option value=ZW >Zimbabwe
</select></td></tr>
</table>
<p>
<table border=0 cellpadding=0 cellspacing=1>
<tr><td colspan=2><font size=2 face=arial><B>배달지 정보:</B> [<a href=javascript:CopyInfo();>Same as above</a>]</td></tr>
<tr><td width=130 align=right><font size=2 face=arial><B>First Name:</B> </td>
<td nowrap><font size=3 face=arial><input type=text name="Ship_firstn" size=12></td></tr>
<tr><td width=130 align=right><font size=2 face=arial><B>Last Name:</B> </td>
<td><font size=3 face=arial> <input type=text name="Ship_lastn" size=17></td></tr>
<tr><td align=right><font size=2 face=arial><B>Daytime Phone:</B> </td><td><font size=3 face=arial> <input type=text name=Ship_Phone size=18 value=""></td></tr>
<tr><td align=right><font size=2 face=arial><B>Company:</B> </td><td><font size=3 face=arial> <input type=text name=Ship_Company size=18 value=""></td></tr>
<tr><td align=right><font size=2 face=arial><B>Street:</B> </td><td><font size=3 face=arial> <input type=text name=Ship_Street size=18 value=""></td></tr>
<tr><td align=right><font size=2 face=arial><B>City:</B> </td><td><font size=3 face=arial> <input type=text name=Ship_City size=18 value=""></td></tr>
<tr><td align=right><font size=2 face=arial><B>State:</B> </td><td><font size=2 face=arial> <SELECT NAME=Ship_State onChange="calculate();"><OPTION VALUE=""><OPTION VALUE=AL>Alabama<OPTION VALUE=AK>Alaska<OPTION VALUE=AZ>Arizona<OPTION VALUE=AR>Arkansas<OPTION VALUE=CA>California<OPTION VALUE=CO>Colorado<OPTION VALUE=CT>Connecticut<OPTION VALUE=DE>Delaware<OPTION VALUE=DC>District Of Columbia<OPTION VALUE=FL>Florida<OPTION VALUE=GA>Georgia<OPTION VALUE=HI>Hawaii<OPTION VALUE=ID>Idaho<OPTION VALUE=IL>Illinois<OPTION VALUE=IN>Indiana<OPTION VALUE=IA>Iowa<OPTION VALUE=KS>Kansas<OPTION VALUE=KY>Kentucky<OPTION VALUE=LA>Louisiana<OPTION VALUE=ME>Maine<OPTION VALUE=MD>Maryland<OPTION VALUE=MA>Massachusetts<OPTION VALUE=MI>Michigan<OPTION VALUE=MN>Minnesota<OPTION VALUE=MS>Mississippi<OPTION VALUE=MO>Missouri<OPTION VALUE=MT>Montana<OPTION VALUE=NE>Nebraska<OPTION VALUE=NV>Nevada<OPTION VALUE=NH>New Hampshire<OPTION VALUE=NJ>New Jersey<OPTION VALUE=NM>New Mexico<OPTION VALUE=NY>New York<OPTION VALUE=NC>North Carolina<OPTION VALUE=ND>North Dakota<OPTION VALUE=OH>Ohio<OPTION VALUE=OK>Oklahoma<OPTION VALUE=OR>Oregon<OPTION VALUE=PA>Pennsylvania<OPTION VALUE=RI>Rhode Island<OPTION VALUE=SC>South Carolina<OPTION VALUE=SD>South Dakota<OPTION VALUE=TN>Tennessee<OPTION VALUE=TX>Texas<OPTION VALUE=UT>Utah<OPTION VALUE=VT>Vermont<OPTION VALUE=VA>Virginia<OPTION VALUE=WA>Washington<OPTION VALUE=WV>West Virginia<OPTION VALUE=WI>Wisconsin<OPTION VALUE=WY>Wyoming<OPTION VALUE="BC">British Columbia<OPTION VALUE="AB">Alberta<OPTION VALUE="SASK">Sask<OPTION VALUE="MAN">Manitoba<OPTION VALUE="ONT">Ontario<OPTION VALUE="QUE">Quebec<OPTION VALUE="MAR">Maritimes<OPTION VALUE="NF">Newfoundland</select></td></tr>
<tr><td align=right><font size=2 face=arial><B>Other State/Provence:</B> </td><td><font size=3 face=arial> <input type=text name=Ship_State2 size=18></td></tr>
<tr><td align=right><font size=2 face=arial><B>Zip:</B> </td><td><font size=3 face=arial> <input type=text name=Ship_Zip value="" size=8 maxlength=8> <font size=2 face=arial></td></tr>
<tr><td align=right><font size=2 face=arial><B>Country:</B> </td><td><font size=2 face=arial> <select name="Ship_Country">
<option value=US Selected>United States
<option value=CA >Canada
<option value=GB >United Kingdom
<option value=AF >Afghanistan
<option value=AL >Albania
<option value=DZ >Algeria
<option value=AS >American Samoa
<option value=AD >Andorra
<option value=AO >Angola
<option value=AI >Anguilla
<option value=AQ >Antarctica
<option value=AG >Antigua and Barbuda
<option value=AR >Argentina
<option value=AM >Armenia
<option value=AW >Aruba
<option value=AU >Australia
<option value=AT >Austria
<option value=AZ >Azerbaijan
<option value=BS >Bahamas
<option value=BH >Bahrain
<option value=BD >Bangladesh
<option value=BB >Barbados
<option value=BY >Belarus
<option value=BE >Belgium
<option value=BZ >Belize
<option value=BJ >Benin
<option value=BM >Bermuda
<option value=BT >Bhutan
<option value=BO >Bolivia
<option value=BA >Bosnia and Herzegovina
<option value=BW >Botswana
<option value=BV >Bouvet Island
<option value=BR >Brazil
<option value=IO >British Indian Ocean Territory
<option value=BN >Brunei Darussalam
<option value=BG >Bulgaria
<option value=BF >Burkina Faso
<option value=BI >Burundi
<option value=KH >Cambodia
<option value=CM >Cameroon
<option value=CV >Cape Verde
<option value=KY >Cayman Islands
<option value=CF >Central African Republic
<option value=TD >Chad
<option value=CL >Chile
<option value=CN >China
<option value=CX >Christmas Island
<option value=CC >Cocos (Keeling) Islands
<option value=CO >Colombia
<option value=KM >Comoros
<option value=CG >Congo
<option value=CK >Cook Islands
<option value=CR >Costa Rica
<option value=HR >Croatia
<option value=CU >Cuba
<option value=CY >Cyprus
<option value=CZ >Czech Republic
<option value=CI >C?e d'Ivoire
<option value=DK >Denmark
<option value=DJ >Djibouti
<option value=DM >Dominica
<option value=DO >Dominican Republic
<option value=TP >East Timor
<option value=EC >Ecuador
<option value=EG >Egypt
<option value=SV >El salvador
<option value=GQ >Equatorial Guinea
<option value=ER >Eritrea
<option value=EE >Estonia
<option value=ET >Ethiopia
<option value=FK >Falkland Islands
<option value=FO >Faroe Islands
<option value=FJ >Fiji
<option value=FI >Finland
<option value=FR >France
<option value=GF >French Guiana
<option value=PF >French Polynesia
<option value=TF >French Southern Territories
<option value=GA >Gabon
<option value=GM >Gambia
<option value=GE >Georgia
<option value=DE >Germany
<option value=GH >Ghana
<option value=GI >Gibraltar
<option value=GR >Greece
<option value=GL >Greenland
<option value=GD >Grenada
<option value=GP >Guadeloupe
<option value=GU >Guam
<option value=GT >Guatemala
<option value=GN >Guinea
<option value=GW >Guinea-Bissau
<option value=GY >Guyana
<option value=HT >Haiti
<option value=HM >Heard Island and McDonald Islands
<option value=VA >Holy See (Vatican City State)
<option value=HN >Honduras
<option value=HK >Hong Kong
<option value=HU >Hungary
<option value=IS >Iceland
<option value=IN >India
<option value=ID >Indonesia
<option value=IR >Iran
<option value=IQ >Iraq
<option value=IE >Ireland
<option value=IL >Israel
<option value=IT >Italy
<option value=JM >Jamaica
<option value=JP >Japan
<option value=JO >Jordan
<option value=KZ >Kazakstan
<option value=KE >Kenya
<option value=KI >Kiribati
<option value=KW >Kuwait
<option value=KG >Kyrgystan
<option value=LA >Lao
<option value=LV >Latvia
<option value=LB >Lebanon
<option value=LS >Lesotho
<option value=LR >Liberia
<option value=LY >Libyan Arab Jamahiriya
<option value=LI >Liechtenstein
<option value=LT >Lithuania
<option value=LU >Luxembourg
<option value=MO >Macau
<option value=MK >Macedonia (FYR)
<option value=MG >Madagascar
<option value=MW >Malawi
<option value=MY >Malaysia
<option value=MV >Maldives
<option value=ML >Mali
<option value=MT >Malta
<option value=MH >Marshall Islands
<option value=MQ >Martinique
<option value=MR >Mauritania
<option value=MU >Mauritius
<option value=YT >Mayotte
<option value=MX >Mexico
<option value=FM >Micronesia
<option value=MD >Moldova
<option value=MC >Monaco
<option value=MN >Mongolia
<option value=MS >Montserrat
<option value=MA >Morocco
<option value=MZ >Mozambique
<option value=MM >Myanmar
<option value=NA >Namibia
<option value=NR >Nauru
<option value=NP >Nepal
<option value=NL >Netherlands
<option value=AN >Netherlands Antilles
<option value=NT >Neutral Zone
<option value=NC >New Caledonia
<option value=NZ >New Zealand
<option value=NI >Nicaragua
<option value=NE >Niger
<option value=NG >Nigeria
<option value=NU >Niue
<option value=NF >Norfolk Island
<option value=KP >North Korea
<option value=MP >Northern Mariana Islands
<option value=NO >Norway
<option value=OM >Oman
<option value=PK >Pakistan
<option value=PW >Palau
<option value=PA >Panama
<option value=PG >Papua New Guinea
<option value=PY >Paraguay
<option value=PE >Peru
<option value=PH >Philippines
<option value=PN >Pitcairn
<option value=PL >Poland
<option value=PT >Portugal
<option value=PR >Puerto Rico
<option value=QA >Qatar
<option value=RE >Reunion
<option value=RO >Romania
<option value=RU >Russian Federation
<option value=RW >Rwanda
<option value=SH >Saint Helena
<option value=KN >Saint Kitts and Nevis
<option value=LC >Saint Lucia
<option value=PM >Saint Pierre and Miquelon
<option value=VC >Saint Vincent and the Grenadines
<option value=WS >Samoa
<option value=SM >San Marino
<option value=ST >Sao Tome and Principe
<option value=SA >Saudi Arabia
<option value=SN >Senegal
<option value=SC >Seychelles
<option value=SL >Sierra Leone
<option value=SG >Singapore
<option value=SK >Slovakia
<option value=SI >Slovenia
<option value=SB >Solomon Islands
<option value=SO >Somalia
<option value=ZA >South Africa
<option value=GS >South Georgia
<option value=KR >South Korea
<option value=ES >Spain
<option value=LK >Sri Lanka
<option value=SD >Sudan
<option value=SR >Suriname
<option value=SJ >Svalbard and Jan Mayen Islands
<option value=SZ >Swaziland
<option value=SE >Sweden
<option value=CH >Switzerland
<option value=SY >Syria
<option value=TW >Taiwan
<option value=TJ >Tajikistan
<option value=TZ >Tanzania
<option value=TH >Thailand
<option value=TG >Togo
<option value=TK >Tokelau
<option value=TO >Tonga
<option value=TT >Trinidad and Tobago
<option value=TN >Tunisia
<option value=TR >Turkey
<option value=TM >Turkmenistan
<option value=TC >Turks and Caicos Islands
<option value=TV >Tuvalu
<option value=UG >Uganda
<option value=UA >Ukraine
<option value=AE >United Arab Emirates
<option value=UM >United States Minor Outlying Islands
<option value=UY >Uruguay
<option value=UZ >Uzbekistan
<option value=VU >Vanuatu
<option value=VE >Venezuela
<option value=VN >Viet Nam
<option value=VG >Virgin Islands (British)
<option value=VI >Virgin Islands (U.S.)
<option value=WF >Wallis and Futuna Islands
<option value=EH >Western Sahara
<option value=YE >Yemen
<option value=YU >Yugoslavia
<option value=ZR >Zaire
<option value=ZM >Zambia
<option value=ZW >Zimbabwe
</select></td></tr>
</table></td></tr>
</table>
<input type=hidden name=refer>
<input type=radio name=SaveMyInfo onclick=SaveInfo()> Save this info on my browser for future use<br>
<INPUT TYPE="button" value="Continue..." onMouseDown="checkItOut();"> 
<script language="javascript">
function getCookieVal (offset) { var endstr = document.cookie.indexOf (";", offset);  if (endstr == -1) endstr = document.cookie.length;  return unescape(document.cookie.substring(offset, endstr));}
function GetCookie (name) { var arg = name + "="; var alen = arg.length; var clen = document.cookie.length; var i = 0; while (i < clen) {var j = i + alen; if (document.cookie.substring(i, j) == arg) return getCookieVal (j); i = document.cookie.indexOf(" ", i) + 1; if (i == 0) break;} return null;}
function SetCookie (name, value) {var argv = SetCookie.arguments; var argc = SetCookie.arguments.length; var expires = (argc > 2) ? argv[2] : null; var path = (argc > 3) ? argv[3] : null; var domain = (argc > 4) ? argv[4] : null; var secure = (argc > 5) ? argv[5] : false; document.cookie = name + "=" + escape (value) + ((expires == null) ? "" : ("; expires=" + expires.toGMTString())) + ((path == null) ? "" : ("; path=" + path)) + ((domain == null) ? "" : ("; domain=" + domain)) + ((secure == true) ? "; secure" : "");}
var expDays = 100; var exp = new Date(); exp.setTime(exp.getTime() + (expDays*50*60*60*1000));
function CopyInfo(){
        document.calcform.Ship_firstn.value = document.calcform.firstn.value;
        document.calcform.Ship_lastn.value = document.calcform.lastn.value;
        document.calcform.Ship_Company.value = document.calcform.Company.value;
        document.calcform.Ship_Phone.value = document.calcform.DayPhone.value;
        document.calcform.Ship_Street.value = document.calcform.Street.value;
        document.calcform.Ship_City.value = document.calcform.City.value;
        document.calcform.Ship_State.selectedIndex = document.calcform.State.selectedIndex;
        document.calcform.Ship_Zip.value = document.calcform.Zip_code.value;
        document.calcform.Ship_Country.selectedIndex = document.calcform.Country.selectedIndex;
        document.calcform.Ship_State2.value = document.calcform.State2.value;
}
function SaveInfo(){
        SavedInfo = new Array(document.calcform.firstn.value,
        document.calcform.lastn.value,
        document.calcform.email.value,
        document.calcform.DayPhone.value,
        document.calcform.Company.value,
        document.calcform.Street.value,
        document.calcform.City.value,
        document.calcform.State.selectedIndex,
        document.calcform.Zip_code.value,
        document.calcform.Country.selectedIndex,
        document.calcform.Ship_firstn.value,
        document.calcform.Ship_lastn.value,
        document.calcform.Ship_Phone.value,
        document.calcform.Ship_Company.value,
        document.calcform.Ship_Street.value,
        document.calcform.Ship_City.value,
        document.calcform.Ship_State.selectedIndex,
        document.calcform.Ship_Zip.value,
        document.calcform.Ship_Country.selectedIndex,
        document.calcform.State2.value,
        document.calcform.Ship_State2.value) //alert(SavedInfo)
        SetCookie('Address',SavedInfo, exp, "/")
}
function LoadInfo(){
        a = GetCookie('Address');
        if (a != null) {b = a.split(',');
        document.calcform.firstn.value = b[0]
        document.calcform.lastn.value = b[1]
        document.calcform.email.value = b[2]
        document.calcform.DayPhone.value = b[3]
        document.calcform.Company.value = b[4]
        document.calcform.Street.value = b[5]
        document.calcform.City.value = b[6]
        document.calcform.State.selectedIndex = b[7]
        document.calcform.Zip_code.value = b[8]
        document.calcform.Country.selectedIndex = b[9]
        document.calcform.Ship_firstn.value = b[10]
        document.calcform.Ship_lastn.value = b[11]
        document.calcform.Ship_Phone.value = b[12]
        document.calcform.Ship_Company.value = b[13]
        document.calcform.Ship_Street.value = b[14]
        document.calcform.Ship_City.value = b[15]
        document.calcform.Ship_State.selectedIndex = b[16]
        document.calcform.Ship_Zip.value = b[17]
        document.calcform.Ship_Country.selectedIndex = b[18]
        document.calcform.State2.value = b[19]
        document.calcform.Ship_State2.value = b[20]
}}
function checkItOut() {aname();
        document.calcform.refer.value = document.location;
        if (document.calcform.firstn.value == "") {alert("The First Name field is not filled in.");document.calcform.firstn.focus();
        } else { if (document.calcform.lastn.value == "") {alert("The Last Name field is not filled in.");document.calcform.lastn.focus();
        } else { if (document.calcform.email.value == "") {alert("Email field is empty."); document.calcform.email.focus();
        } else { if (document.calcform.DayPhone.value == "") {alert("Phone Number field is empty.");document.calcform.DayPhone.focus();
        } else { if (document.calcform.Street.value == "") {alert("Street Number field is empty."); document.calcform.Street.focus();
        } else { if (document.calcform.City.value == "") {alert("You have not filled in the City."); document.calcform.City.focus();
        } else { if ((document.calcform.State.options[document.calcform.State.selectedIndex].value == 0)&&(document.calcform.State2.value == "")) {alert("You have not chosen a State");document.calcform.State.focus();
        } else { if (document.calcform.Zip_code.value == "") {alert("You need to fill in your Zip Code."); document.calcform.Zip_code.focus();
        } else { if (document.calcform.Country.value == "") {alert("You need to slect your Country."); document.calcform.Country.focus();
        } else { if (document.calcform.Ship_firstn.value == "") {alert("The First Name field is not filled in.");document.calcform.Ship_firstn.focus();
        } else { if (document.calcform.Ship_lastn.value == "") {alert("The Last Name field is not filled in.");document.calcform.Ship_lastn.focus();
        } else { if (document.calcform.Ship_Phone.value == "") {alert("Phone Number field is empty.");document.calcform.Ship_Phone.focus();
        } else { if (document.calcform.Ship_Street.value == "") {alert("Street Number field is empty."); document.calcform.Ship_Street.focus();
        } else { if (document.calcform.Ship_City.value == "") {alert("You have not filled in the City."); document.calcform.Ship_City.focus();
        } else { if ((document.calcform.Ship_State.options[document.calcform.Ship_State.selectedIndex].value == 0)&&(document.calcform.Ship_State2.value == "")) {alert("You have not chosen a State");document.calcform.Ship_State.focus();
        } else { if (document.calcform.Ship_Zip.value == "") {alert("You need to fill in your Zip Code."); document.calcform.Ship_Zip.focus();
        } else { if (document.calcform.Ship_Country.value == "") {alert("You need to select your Country."); document.calcform.Ship_Country.focus();
        } else { 
        document.calcform.action = "";
        document.calcform.submit();
}}}}}}}}}}}}}}}}}}
LoadInfo();
</SCRIPT>
</FORM>
 
 







97    다양한 텍스트 폼 스크롤러를 하나로 

 
<!-- 메모장 등으로 아래의 방법으로 HTML 문서의 BODY 부분에 붙여 넣으세요 -->
<script language="JavaScript">
<!--
function createArr(num) { for(var i = 0; i < num; i++) { this[i] = null } }
function fillArr(tx,me,ti,wa) { this.text = tx;  this.method = me.toLowerCase();  this.ticks = ti;  this.wait = wa }
function block(num,txt,mthod,tcks,wit) { blocks[num] = new fillArr(txt,mthod,tcks,wit) }
function ms(unt) { var sp = "";  for( var i = 1; i <= unt; i++ ) { sp += " " } return(sp) }
function Activate() { if (cblock == max) { cblock = 0;  if (iloop == 0) { loops--;  if (loops == 0) { meth = "0" } else { meth = blocks[cblock].method } } else { meth = blocks[cblock].method } } else { meth = blocks[cblock].method }
if (meth == "0") { document.Active.ASCII.value = end }
if (meth == "display") { Tape = blocks[cblock].text;  Wait = blocks[cblock].wait;  Display() }
if (meth == "display center") { Tape = blocks[cblock].text;  Wait = blocks[cblock].wait;  half = Tape.length / 2;  DisplayC() }
if (meth == "scroll left") { clen = tlen;  Tape = blocks[cblock].text;  Ticks = blocks[cblock].ticks;  tTicks = Ticks * 2;  ScrollL() }
if (meth == "scroll right") { clen = 0 - blocks[cblock].text.length;  Tape = blocks[cblock].text;  Ticks = blocks[cblock].ticks;  tTicks = Ticks * 2;  ScrollR() }
if (meth == "scroll lc") { clen = 0 - blocks[cblock].text.length;  Tape = blocks[cblock].text;  Ticks = blocks[cblock].ticks;  Wait = blocks[cblock].wait;  tTicks = Ticks * 2;  half = Tape.length / 2;  ScrollLC() }
if (meth == "scroll rc") { clen = tlen;  Tape = blocks[cblock].text;  Ticks = blocks[cblock].ticks;  Wait = blocks[cblock].wait;  tTicks = Ticks * 2;  half = Tape.length / 2;  ScrollRC() }
if (meth == "scroll cl") { Tape = blocks[cblock].text;  Ticks = blocks[cblock].ticks;  tTicks = Ticks * 2;  half = Tape.length / 2;  clen = cent - half;  ScrollCL() }
if (meth == "scroll cr") { Tape = blocks[cblock].text;  Ticks = blocks[cblock].ticks;  tTicks = Ticks * 2;  half = Tape.length / 2;  clen = cent - half;  ScrollCR() }
if (meth == "slide left") { Tape = blocks[cblock].text;  Ticks = blocks[cblock].ticks;  Wait = blocks[cblock].wait;  cpos = 0;  clet = Tape.charAt(cpos);  clen = tlen;  cstr = "";  SlideL() }
if (meth == "slide lc") { Tape = blocks[cblock].text;  Ticks = blocks[cblock].ticks;  Wait = blocks[cblock].wait;  cpos = Tape.length - 1;  clet = Tape.charAt(cpos);  clen = 0;  cstr = "";  half = Tape.length / 2;  iba = cent - half;  ib = ms(iba);  SlideLC() }
if (meth == "slide rc") { Tape = blocks[cblock].text;  Ticks = blocks[cblock].ticks;  Wait = blocks[cblock].wait;  cpos = 0;  clet = Tape.charAt(cpos);  cstr = "";  half = Tape.length / 2;  clen = cent + half;  fs = ms(cent - half);  SlideRC() }
if (meth == "slide cl") { Tape = blocks[cblock].text;  Ticks = blocks[cblock].ticks;  cpos = 0;  clet = Tape.charAt(cpos);  cstr = Tape.substring(1,Tape.length);  half = Tape.length / 2;  clen = cent - half;  iba = 0;  ib = ms(iba);  SlideCL() }
if (meth == "slide cr") { Tape = blocks[cblock].text;  Ticks = blocks[cblock].ticks;  cpos = Tape.length - 1;  clet = Tape.charAt(cpos);  cstr = Tape.substring(0,Tape.length - 1);  half = Tape.length / 2;  clen = 0;  fs = ms(cent - half);  SlideCR() }
if (meth == "slip left") { clen = 0;  Tape = blocks[cblock].text;  Ticks = blocks[cblock].ticks;  SlipL() }
if (meth == "slip right") { clen = 0;  Tape = blocks[cblock].text;  Ticks = blocks[cblock].ticks;  SlipR() }
if (meth == "slip letter") { Tape = blocks[cblock].text;  Ticks = blocks[cblock].ticks;  cpos = Tape.length - 1;  clet = Tape.charAt(cpos);  cstr = Tape.substring(0,Tape.length - 1);  clen = 0;  SlipLet() }
if (meth == "split"){ Tape = blocks[cblock].text;  Ticks = blocks[cblock].ticks;  var iii = Tape.length / 2;  if (iii / 2 != Math.ceil(iii / 2)) { Tape = Tape + " " } hstr1 = Tape.substring(0,Tape.length/2);  hstr2 = Tape.substring(Tape.length/2,Tape.length);  tTicks = Ticks * 2;  clen = cent - hstr1.length;  iba = 0;  ib = ms(iba);  Split() }
if (meth == "merge"){ Tape = blocks[cblock].text;  Ticks = blocks[cblock].ticks;  var iii = Tape.length / 2;  if (iii / 2 != Math.ceil(iii / 2)) { Tape = Tape + " " } hstr1 = Tape.substring(0,Tape.length/2);  hstr2 = Tape.substring(Tape.length/2,Tape.length);  tTicks = Ticks * 2;  clen = 0 - hstr1.length;  iba = tlen;  ib = ms(iba);  Wait = blocks[cblock].wait;  Merge() } }
function Display() { document.Active.ASCII.value = Tape;  cblock++;  timerID = setTimeout("Activate()",Wait) }
function DisplayC() { var temp = cent - half;  ini = ms(temp);  document.Active.ASCII.value = ini + Tape;  cblock++;  timerID = setTimeout("Activate()",Wait) }
function ScrollL() { if (clen >= 0) { ini = ms(clen);  tickered = ini + Tape;  document.Active.ASCII.value = tickered;  clen--;  timerID = setTimeout("ScrollL()",Ticks) } else { beg = 0 - clen;  if (beg == Tape.length) { document.Active.ASCII.value = "";  cblock++;  timerID = setTimeout("Activate()",Ticks) } else { tickered = Tape.substring(beg,tlen);  document.Active.ASCII.value = tickered;  clen--;  timerID = setTimeout("ScrollL()",tTicks) } } }
function ScrollR() { if (clen >= 0) { if (clen > tlen) { document.Active.ASCII.value = "";  cblock++;  timerID = setTimeout("Activate()",Ticks) } else { ini = ms(clen);  tickered = ini + Tape;  document.Active.ASCII.value = tickered;  clen++;  timerID = setTimeout("ScrollR()",Ticks) } } else { beg = 0 - clen;  tickered = Tape.substring(beg,tlen);  document.Active.ASCII.value = tickered;  clen++;  timerID = setTimeout("ScrollR()",tTicks) } }
function ScrollLC() { if (clen >= 0) { if (cent <= (clen + half)) { cblock++;  timerID = setTimeout("Activate()",Wait) } else { ini = ms(clen);  tickered = ini + Tape;  document.Active.ASCII.value = tickered;  clen++;  timerID = setTimeout("ScrollLC()",Ticks) } } else { beg = 0 - clen;  if (cent <= (clen + half)) { cblock++;  timerID = setTimeout("Activate()",Wait) } else { tickered = Tape.substring(beg,tlen);  document.Active.ASCII.value = tickered;  clen++;  timerID = setTimeout("ScrollLC()",tTicks) } } }
function ScrollRC() { if (clen >= 0) { if (cent >= (clen + half)) { cblock++;  timerID = setTimeout("Activate()",Wait) } else { ini = ms(clen);  tickered = ini + Tape;  document.Active.ASCII.value = tickered;  clen--;  timerID = setTimeout("ScrollRC()",Ticks) } } else { beg = 0 - clen;  if (cent >= (clen + half)) { cblock++;  timerID = setTimeout("Activate()",Wait) } tickered = Tape.substring(beg,tlen);  document.Active.ASCII.value = tickered;  clen--;  timerID = setTimeout("ScrollRC()",tTicks) } }
function ScrollCL() { if (clen >= 0) { ini = ms(clen);  tickered = ini + Tape;  document.Active.ASCII.value = tickered;  clen--;  timerID = setTimeout("ScrollCL()",Ticks) } else { beg = 0 - clen;  if (beg >= Tape.length) { document.Active.ASCII.value = "";  cblock++;  timerID = setTimeout("Activate()",Wait) } else { tickered = Tape.substring(beg,tlen);  document.Active.ASCII.value = tickered;  clen--;  timerID = setTimeout("ScrollCL()",tTicks) } } }
function ScrollCR() { if (clen >= 0) { if (clen > tlen) { document.Active.ASCII.value = "";  cblock++;  timerID = setTimeout("Activate()",Wait) } else { ini = ms(clen);  tickered = ini + Tape;  document.Active.ASCII.value = tickered;  clen++;  timerID = setTimeout("ScrollCR()",Ticks) } } else { beg = 0 - clen;  tickered = Tape.substring(beg,tlen);  document.Active.ASCII.value = tickered;  clen++;  timerID = setTimeout("ScrollCR()",tTicks) } }
function SlideL() { if (clen >= 0) { ini = ms(clen);  tickered = cstr + ini + clet;  document.Active.ASCII.value = tickered;  clen -= 3;  timerID = setTimeout("SlideL()",Ticks) } else { document.Active.ASCII.value = cstr + clet;  cstr = document.Active.ASCII.value;  clen = tlen - cstr.length;  cpos++;  clet = Tape.charAt(cpos);  if (clet == " ") { cstr = cstr + " ";  cpos++;  clet = Tape.charAt(cpos) } if (clet == "") { cblock++;  timerID = setTimeout("Activate()",Wait) } else { timerID = setTimeout("SlideL()",Ticks) } } }
function SlideLC() { if (clen <= cent - half) { ini = ms(clen);  tickered = ini + clet + ib + cstr;  document.Active.ASCII.value = tickered;  clen += 3;  iba -= 3;  ib = ms(iba);  timerID = setTimeout("SlideLC()",Ticks) } else { iba = cent - half;  ini = ms(iba);  ib = ms(iba);  document.Active.ASCII.value = ini + clet + cstr;  cstr = clet + cstr;  clen = 0;  cpos--;  if (cpos >= 0) { clet = Tape.charAt(cpos);  if (clet == " ") { cstr = " " + cstr;  cpos--;  clet = Tape.charAt(cpos) } timerID = setTimeout("SlideLC()",Ticks) } else { cblock++;  timerID = setTimeout("Activate()",Wait) } } }
function SlideRC() { if (clen >= 0) { ini = ms(clen);  tickered = fs + cstr + ini + clet;  document.Active.ASCII.value = tickered;  clen -= 3;  timerID = setTimeout("SlideRC()",Ticks) } else { clen = cent + half;  cstr += clet;  document.Active.ASCII.value = fs + cstr;  cpos++;  clet = Tape.charAt(cpos);  if (clet == " ") { cstr = cstr + " ";  cpos++;  clet = Tape.charAt(cpos) } if (clet == "") { document.Active.ASCII.value = fs + Tape;  cblock++;  timerID = setTimeout("Activate()",Wait) } else { timerID = setTimeout("SlideRC()",Ticks) } } }
function SlideCL() { if (clen > 0) { ini = ms(clen);  tickered = ini + clet + ib + cstr;  document.Active.ASCII.value = tickered;  clen -= 3;  iba += 3;  ib = ms(iba);  timerID = setTimeout("SlideCL()",Ticks) } else { iba = 0;  ib = ms(iba);  clen = cent - half;  ini = ms(clen);  document.Active.ASCII.value = ini + cstr;  cstr = cstr.substring(1,Tape.length);  cpos++;  clet = Tape.charAt(cpos);  if (clet == " ") { cstr = cstr.substring(1,Tape.length);  cpos++;  clet = Tape.charAt(cpos) } if (clet == "") { document.Active.ASCII.value = "";  cblock++;  timerID = setTimeout("Activate()",Ticks) } else { timerID = setTimeout("SlideCL()",Ticks) } } }
function SlideCR() { if (clen <= cent + half) { ini = ms(clen);  tickered = fs + cstr + ini + clet;  document.Active.ASCII.value = tickered;  clen += 3;  timerID = setTimeout("SlideCR()",Ticks) } else { clen = 0;  document.Active.ASCII.value = fs + cstr;  cstr = cstr.substring(0,cstr.length - 1);  cpos--;  half += 1;  if (cpos >= 0) {                ;  clet = Tape.charAt(cpos);  if (clet == " ") { cstr = cstr.substring(0,cstr.length - 1);  cpos--;  clet = Tape.charAt(cpos) } timerID = setTimeout("SlideCR()",Ticks) } else { cblock++;  timerID = setTimeout("Activate()",Ticks) } } }
function SlipR() { if (clen >= 0) { if (clen > tlen) { document.Active.ASCII.value = "";  cblock++;  timerID = setTimeout("Activate()",Ticks) } else { ini = ms(clen);  tickered = ini + Tape;  document.Active.ASCII.value = tickered;  clen++;  timerID = setTimeout("SlipR()",Ticks) } } else { beg = 0 - clen;  tickered = Tape.substring(beg,tlen);  document.Active.ASCII.value = tickered;  clen++;  timerID = setTimeout("SlipR()",Ticks) } }
function SlipL() { if (clen >= 0) { ini = ms(clen);  tickered = ini + Tape;  document.Active.ASCII.value = tickered;  clen--;  timerID = setTimeout("SlipL()",Ticks) } else { beg = 0 - clen;  if (beg == Tape.length) { document.Active.ASCII.value = "";  cblock++;  timerID = setTimeout("Activate()",Ticks) } else { tickered = Tape.substring(beg,tlen);  document.Active.ASCII.value = tickered;  clen--;  timerID = setTimeout("SlipL()",Ticks) } } }
function SlipLet() { if (clen < tlen) { ini = ms(clen);  tickered = cstr + ini + clet;  document.Active.ASCII.value = tickered;  clen += 3;  timerID = setTimeout("SlipLet()",Ticks) } else { clen = 0;  cstr = cstr.substring(0,cstr.length - 1);  cpos--;  if (cpos >= 0) {                ;  clet = Tape.charAt(cpos);  if (clet == " ") { cstr = cstr.substring(0,cstr.length - 1);  cpos--;  clet = Tape.charAt(cpos) } timerID = setTimeout("SlipLet()",Ticks) } else { cblock++;  timerID = setTimeout("Activate()",Ticks) } } }
function Split() { if (clen >= 0) { ini = ms(clen);  tickered = ini + hstr1 + ib + hstr2;  document.Active.ASCII.value = tickered;  clen--;  iba += 2;  ib = ms(iba);  timerID = setTimeout("Split()",Ticks) } else { if (clen <= 0 - hstr1.length) { cblock++;  timerID = setTimeout("Activate()",Ticks) } else { beg = 0 - clen;  tickered = hstr1.substring(beg,tlen);  document.Active.ASCII.value = tickered + ib + hstr2;  clen--;  iba += 2;  ib = ms(iba);  timerID = setTimeout("Split()",tTicks) } } }
function Merge() { if (clen >= 0) { if (clen > cent - hstr1.length) { tickered = ini + hstr1 + hstr2;  document.Active.ASCII.value = tickered;  cblock++;  timerID = setTimeout("Activate()",Wait) } else { ini = ms(clen);  tickered = ini + hstr1 + ib + hstr2;  document.Active.ASCII.value = tickered;  clen++;  iba -= 2;  ib = ms(iba);  timerID = setTimeout("Merge()",Ticks) } } else { beg = 0 - clen;  tickered = hstr1.substring(beg,tlen);  document.Active.ASCII.value = tickered + ib + hstr2;  clen++;  iba -= 4;  ib = ms(iba);  timerID = setTimeout("Merge()",tTicks) } }
var max = 18
var blocks = new createArr(max)
// 텍스트의 전체 길이
var len = 50
// 반복 횟수
var loops = 0
// 반복횟수를 지정하면 마지막 메세지를 설정 할 수 있습니다
var end = '자바스크립트 소스뱅크'
/******* 최대메세지 갯수보다 1 적게 설정하세요 ************/
block(17,"열여덟번째 메세지 입니다","display",0,500)
block(18,"열아홉번째 메세지","display center",0,500)
block(2,"세번째 메세지","scroll left",25,0)
block(3,"네번째 메세지","scroll right",25,0)
block(4,"왼쪽에서 스크롤된 후 사라집니다","scroll lc",25,500) // 왼쪽에서 스크롤된 후 사라짐
block(5,"오른쪽에서 스크롤 된 후 사라닙니다","scroll rc",25,500) // 오른쪽에서 스크롤된 후 사라짐
block(6,"7번째 메세지","scroll cl",25,0)
block(7,"여덟번째 메세지","scroll cr",25,0)
block(8,"아홉번째 메세지","slide left",25,500)
block(9,"열번째 메세지","slide lc",25,500)
block(10,"열한번째 메세지","slide rc",25,500)
block(11,"열두번째 메세지","slide cl",25,0)
block(12,"열세번째 메세지","slide cr",25,0)
block(13,"열네번째 메세지","slip left",25,0)
block(14,"열다섯번째 메세지","slip right",25,0)
block(15,"열여섯번째 메세지","slip letter",25,0)
block(16,"","display",0,500)
block(0,"하하하","merge",25,1000)
block(1,"두번째 메세지","split",25,0)  // 메세지 분리
var tlen = 2.4 * len
var cent = tlen / 2.2
var clen = null
var tickered = null
var ini = null
var iloop = 0
if (loops == 0) {iloop = 1}
var cblock = 0
var timerID = null
var beg = null
var clet = null
var cstr = null
var cpos = null
var ib = null
var iba = null
var fs = null
var hstr1 = null
var hstr2 = null
//-->
</script>
</HEAD>
<BODY>
<script language="JavaScript">
document.write('<center><form name="Active" onSubmit="0">')
document.write('<input type="text" name="ASCII" size="50" style="background-color:yellow;border:none">')
document.write('</form></center>')
Activate()
</script>
 
 


  






96    날짜형식 자동완성 및 유효성 검사 하기 

 
<!-- 1. 메모장 등으로 아래의 내용을 HTML 문서의 HEAD 부분에 붙여 넣으세요 -->

<script language="javascript">
<!-- 
var isNav4 = false, isNav5 = false, isIE4 = false
var strSeperator = "/"; 
var vDateType = 3; // 날짜포맷 방식을 선택 하세요
//                1 = mm/dd/yyyy
//                2 = yyyy/dd/mm
//                3 = dd/mm/yyyy
var vYearType = 4; // 네츠케이프에서 연도수 (2자리, 4자리)
var vYearLength = 2; // 연도 자릿수
var err = 0;

if(navigator.appName == "Netscape") 
{
   if (navigator.appVersion < "5")  
   {
      isNav4 = true;
      isNav5 = false;
        }
   else
   if (navigator.appVersion > "4") 
   {
      isNav4 = false;
      isNav5 = true;
        }
}
else  
{
   isIE4 = true;
}
function DateFormat(vDateName, vDateValue, e, dateCheck, dateType)  {
vDateType = dateType;
   
   
   if (vDateValue == "~")
   {
      alert("AppVersion = "+navigator.appVersion+" \nNav. 4 Version = "+isNav4+" \nNav. 5 Version = "+isNav5+" \nIE Version = "+isIE4+" \nYear Type = "+vYearType+" \nDate Type = "+vDateType+" \nSeparator = "+strSeperator);
      vDateName.value = "";
      vDateName.focus();
      return true;
   }
      
   var whichCode = (window.Event) ? e.which : e.keyCode;
   if (vDateValue.length > 8 && isNav4)
   {
      if ((vDateValue.indexOf("-") >= 1) || (vDateValue.indexOf("/") >= 1))
         return true;
   }
   
   var alphaCheck = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ/-";
   if (alphaCheck.indexOf(vDateValue) >= 1)  
   {
      if (isNav4)
      {
         vDateName.value = "";
         vDateName.focus();
         vDateName.select();
         return false;
      }
      else
      {
         vDateName.value = vDateName.value.substr(0, (vDateValue.length-1));
         return false;
      } 
   }
   if (whichCode == 8) // 네츠케이프 에서 백스페이스키 무시
      return false;
   else 
   {
      // 키보드(키패드)값
      
      var strCheck = '47,48,49,50,51,52,53,54,55,56,57,58,59,95,96,97,98,99,100,101,102,103,104,105';
      if (strCheck.indexOf(whichCode) != -1)  
      {
         if (isNav4)  
         {
            if (((vDateValue.length < 6 && dateCheck) || (vDateValue.length == 7 && dateCheck)) && (vDateValue.length >=1))
            {
               alert("날짜형식이 맞지 않습니다");
               vDateName.value = "";
               vDateName.focus();
               vDateName.select();
               return false;
            }
            if (vDateValue.length == 6 && dateCheck)  
            {
               var mDay = vDateName.value.substr(2,2);
               var mMonth = vDateName.value.substr(0,2);
               var mYear = vDateName.value.substr(4,4)
               
               if (mYear.length == 2 && vYearType == 4) 
               {
                  var mToday = new Date();
                  
                  var checkYear = mToday.getFullYear() + 30; 
                  var mCheckYear = '20' + mYear;
                  if (mCheckYear >= checkYear)
                     mYear = '19' + mYear;
                  else
                     mYear = '20' + mYear;
               }
               var vDateValueCheck = mMonth+strSeperator+mDay+strSeperator+mYear;
               
               if (!dateValid(vDateValueCheck))  
               {
                  alert("Invalid Date\nPlease Re-Enter");
                  vDateName.value = "";
                  vDateName.focus();
                  vDateName.select();
                  return false;
                         }
               return true;
            
            }
            else
            {
              
               
               if (vDateValue.length >= 8  && dateCheck)  
               {
                  if (vDateType == 1) // mmddyyyy
                  {
                     var mDay = vDateName.value.substr(2,2);
                     var mMonth = vDateName.value.substr(0,2);
                     var mYear = vDateName.value.substr(4,4)
                     vDateName.value = mMonth+strSeperator+mDay+strSeperator+mYear;
                  }
                  if (vDateType == 2) // yyyymmdd
                  {
                     var mYear = vDateName.value.substr(0,4)
                     var mMonth = vDateName.value.substr(4,2);
                     var mDay = vDateName.value.substr(6,2);
                     vDateName.value = mYear+strSeperator+mMonth+strSeperator+mDay;
                  }
                  if (vDateType == 3) // ddmmyyyy
                  {
                     var mMonth = vDateName.value.substr(2,2);
                     var mDay = vDateName.value.substr(0,2);
                     var mYear = vDateName.value.substr(4,4)
                     vDateName.value = mDay+strSeperator+mMonth+strSeperator+mYear;
                  }
                  
                 
                  var vDateTypeTemp = vDateType;
                  vDateType = 1;
                  var vDateValueCheck = mMonth+strSeperator+mDay+strSeperator+mYear;
                  
                  if (!dateValid(vDateValueCheck))  
                  {
                     alert("날짜형식이 맞지 않습니다");
                     vDateType = vDateTypeTemp;
                     vDateName.value = "";
                     vDateName.focus();
                     vDateName.select();
                     return false;
                            }
                     vDateType = vDateTypeTemp;
                     return true;
                    }
               else
               {
                  if (((vDateValue.length < 8 && dateCheck) || (vDateValue.length == 9 && dateCheck)) && (vDateValue.length >=1))
                  {
                     alert("날짜형식이 맞지 않습니다");
                     vDateName.value = "";
                     vDateName.focus();
                     vDateName.select();
                     return false;
                  }
               }
            }
         }
         else  
         {
            if (((vDateValue.length < 8 && dateCheck) || (vDateValue.length == 9 && dateCheck)) && (vDateValue.length >=1))
            {
               alert("날짜형식이 맞지 않습니다");
               vDateName.value = "";
               vDateName.focus();
               return true;
            }
            
            
            if (vDateValue.length >= 8 && dateCheck)  
            {
            
              
               if (vDateType == 1) // mm/dd/yyyy
               {
                  var mMonth = vDateName.value.substr(0,2);
                  var mDay = vDateName.value.substr(3,2);
                  var mYear = vDateName.value.substr(6,4)
               }
               if (vDateType == 2) // yyyy/mm/dd
               {
                  var mYear = vDateName.value.substr(0,4)
                  var mMonth = vDateName.value.substr(5,2);
                  var mDay = vDateName.value.substr(8,2);
               }
               if (vDateType == 3) // dd/mm/yyyy
               {
                  var mDay = vDateName.value.substr(0,2);
                  var mMonth = vDateName.value.substr(3,2);
                  var mYear = vDateName.value.substr(6,4)
               }
               if (vYearLength == 4)
               {
                  if (mYear.length < 4)
                  {
                     alert("날짜형식이 맞지 않습니다");
                     vDateName.value = "";
                     vDateName.focus();
                     return true;
                  }
               }
               
               var vDateTypeTemp = vDateType;
               
               vDateType = 1;
               
               var vDateValueCheck = mMonth+strSeperator+mDay+strSeperator+mYear;
               
               if (mYear.length == 2 && vYearType == 4 && dateCheck)  
               {
                  
                  var mToday = new Date();
                  
                  var checkYear = mToday.getFullYear() + 30; 
                  var mCheckYear = '20' + mYear;
                  if (mCheckYear >= checkYear)
                     mYear = '19' + mYear;
                  else
                     mYear = '20' + mYear;
                  vDateValueCheck = mMonth+strSeperator+mDay+strSeperator+mYear;
                  
                 
                  if (vDateTypeTemp == 1) // mm/dd/yyyy
                     vDateName.value = mMonth+strSeperator+mDay+strSeperator+mYear;
                  if (vDateTypeTemp == 3) // dd/mm/yyyy
                     vDateName.value = mDay+strSeperator+mMonth+strSeperator+mYear;
               } 
               
               
               if (!dateValid(vDateValueCheck))  
               {
                  alert("날짜형식이 맞지 않습니다");
                  vDateType = vDateTypeTemp;
                  vDateName.value = "";
                  vDateName.focus();
                  return true;
                         }
               vDateType = vDateTypeTemp;
               return true;
            
            }
            else
            {
               
               if (vDateType == 1)
               {
                  if (vDateValue.length == 2)  
                  {
                     vDateName.value = vDateValue+strSeperator;
                  }
                  if (vDateValue.length == 5)  
                  {
                     vDateName.value = vDateValue+strSeperator;
                  }
               }
               if (vDateType == 2)
               {
                  if (vDateValue.length == 4)  
                  {
                     vDateName.value = vDateValue+strSeperator;
                  }
                  if (vDateValue.length == 7)  
                  {
                     vDateName.value = vDateValue+strSeperator;
                  }
               } 
               if (vDateType == 3)
               {
                  if (vDateValue.length == 2)  
                  {
                     vDateName.value = vDateValue+strSeperator;
                  }
                  if (vDateValue.length == 5)  
                  {
                     vDateName.value = vDateValue+strSeperator;
                  }
               }
               return true;
            }
         }
         if (vDateValue.length == 10   && dateCheck)  
         {
            if (!dateValid(vDateName))  
            {
               alert("날짜형식이 맞지 않습니다");
               vDateName.focus();
               vDateName.select();
                 }
         }
         return false;
      }
      else  
      {
         if (isNav4)
         {
            vDateName.value = "";
            vDateName.focus();
            vDateName.select();
            return false;
         }
         else
         {
            vDateName.value = vDateName.value.substr(0, (vDateValue.length-1));
            return false;
         }
                }
        }
}

   function dateValid(objName) {
      var strDate;
      var strDateArray;
      var strDay;
      var strMonth;
      var strYear;
      var intday;
      var intMonth;
      var intYear;
      var booFound = false;
      var datefield = objName;
      var strSeparatorArray = new Array("-"," ","/",".");
      var intElementNr;
      var strMonthArray = new Array(12);
      strMonthArray[0] = "Jan";
      strMonthArray[1] = "Feb";
      strMonthArray[2] = "Mar";
      strMonthArray[3] = "Apr";
      strMonthArray[4] = "May";
      strMonthArray[5] = "Jun";
      strMonthArray[6] = "Jul";
      strMonthArray[7] = "Aug";
      strMonthArray[8] = "Sep";
      strMonthArray[9] = "Oct";
      strMonthArray[10] = "Nov";
      strMonthArray[11] = "Dec";
      
      strDate = objName;
      
      if (strDate.length < 1) {
         return true;
      }
      for (intElementNr = 0; intElementNr < strSeparatorArray.length; intElementNr++) {
         if (strDate.indexOf(strSeparatorArray[intElementNr]) != -1) 
         {
            strDateArray = strDate.split(strSeparatorArray[intElementNr]);
            if (strDateArray.length != 3) 
            {
               err = 1;
               return false;
            }
            else 
            {
               strDay = strDateArray[0];
               strMonth = strDateArray[1];
               strYear = strDateArray[2];
            }
            booFound = true;
         }
      }
      if (booFound == false) {
         if (strDate.length>5) {
            strDay = strDate.substr(0, 2);
            strMonth = strDate.substr(2, 2);
            strYear = strDate.substr(4);
         }
      }
      if (strYear.length == 2) {
         strYear = '20' + strYear;
      }
      strTemp = strDay;
      strDay = strMonth;
      strMonth = strTemp;
      intday = parseInt(strDay, 10);
      if (isNaN(intday)) {
         err = 2;
         return false;
      }
      
      intMonth = parseInt(strMonth, 10);
      if (isNaN(intMonth)) {
         for (i = 0;i<12;i++) {
            if (strMonth.toUpperCase() == strMonthArray[i].toUpperCase()) {
               intMonth = i+1;
               strMonth = strMonthArray[i];
               i = 12;
            }
         }
         if (isNaN(intMonth)) {
            err = 3;
            return false;
         }
      }
      intYear = parseInt(strYear, 10);
      if (isNaN(intYear)) {
         err = 4;
         return false;
      }
      if (intMonth>12 || intMonth<1) {
         err = 5;
         return false;
      }
      if ((intMonth == 1 || intMonth == 3 || intMonth == 5 || intMonth == 7 || intMonth == 8 || intMonth == 10 || intMonth == 12) && (intday > 31 || intday < 1)) {
         err = 6;
         return false;
      }
      if ((intMonth == 4 || intMonth == 6 || intMonth == 9 || intMonth == 11) && (intday > 30 || intday < 1)) {
         err = 7;
         return false;
      }
      if (intMonth == 2) {
         if (intday < 1) {
            err = 8;
            return false;
         }
         if (LeapYear(intYear) == true) {
            if (intday > 29) {
               err = 9;
               return false;
            }
         }
         else {
            if (intday > 28) {
               err = 10;
               return false;
            }
         }
      }
         return true;
      }
   function LeapYear(intYear) {
      if (intYear % 100 == 0) {
         if (intYear % 400 == 0) { return true; }
      }
      else {
         if ((intYear % 4) == 0) { return true; }
      }
         return false;
      }
// -->
</script>
        
</head>
<!-- 2. 메모장 등으로 아래의 내용을 HTML 문서의 <BODY> 태그 안에 붙여 넣으세요 -->
<body onLoad="document.dateTest.testDateFormat1.focus()">
<!-- 3. 메모장 등으로 아래의 방법으로 HTML 문서의 BODY 부분에 붙여 넣으세요 -->
   
   <form name='dateTest'>
      <table border = '0' width='70%' align=center>
      <tr>
         <td>
            <table align='center' border='1'>
               <tr>
                  <td  bgcolor='white' width='75%'>
                     <font color='black'>날짜를 mm/dd/yyyy 형식으로 입력 하세요</font>
                  </td>
                  <td>
                     <input type="text" name="testDateFormat1" size='10' maxlength="10" onFocus="javascript:vDateType='1'" onKeyUp="DateFormat(this,this.value,event,false,'1')" onBlur="DateFormat(this,this.value,event,true,'1')">
                  </td>
               </tr>
            </table>
         </td>
       </tr>
       <tr>
         <td>
            <table align='center' border='1'>
               <tr>
                  <td  bgcolor='white' width='75%'>
                     <font color='black'>날짜를 yyyy/mm/dd  형식으로 입력 하세요</font>
                  </td>
                  <td>
                     <input type="text" name="testDateFormat3" size='10' maxlength="10" onFocus="javascript:vDateType='2'" onKeyUp="DateFormat(this,this.value,event,false,'2')" onBlur="DateFormat(this,this.value,event,true,'2')">
                  </td>
               </tr>
            </table>
         </td>
      </tr>
      <tr>
         <td>
            <table align='center' border='1'>
               <tr>
                  <td  bgcolor='white' width='75%'>
                     <font color='black'>날짜를 dd/mm/yyyy  형식으로 입력 하세요</font>
                  </td>
                  <td>
                     <input type="text" name="testDateFormat5" size='10' maxlength="10" onFocus="javascript:vDateType='3'" onKeyUp="DateFormat(this,this.value,event,false,'3')" onBlur="DateFormat(this,this.value,event,true,'3')">
                  </td>
               </tr>
            </table>
         </td>
      </tr>
      <tr>
         <td>
            <table border='1'>
               <tr>
                  <td>
                     <table border='0'>
                        <tr>
                           <td>
                              <b>Navigator 4.x</b>
                           </td> 
                           <td>
                              8자리가 입력되면 자동으로 포맷 됩니다
                           </td>
                        </tr>
                        <tr>
                           <td>
                              <b>Navigator 6.x</b>
                           </td>
                           <td>
                              숫자를 넣으면 자동 포맷 됩니다
                           </td>
                        </tr>
                        <tr>
                           <td>
                              <b>IE</b>
                           </td>
                           <td>
                              자동으로 포맷 됩니다
                           </td>
                        </tr>
                     </table>
                  </td>
               </tr>
               <tr>
                  <td align='center' bgcolor='silver'>
                     <font size='+1' color='white'>유효성 검사는 필드를 떠날때 실행 됩니다</font>
                  </td>
               </tr>
            </table>
         </td>
      </tr>
      </table>
               
   </form>
 
 







95    데이터 입력받아 알파벳(가나다)순으로 정열시켜 보여주기

 
<!-- 1. 메모장 등으로 아래의 내용을 HTML 문서의 HEAD 부분에 붙여 넣으세요 -->
<SCRIPT LANGUAGE="JAVASCRIPT">
<!--
var entered_names
var how_many = prompt("알파벳 순으로 정열시킬 데이트의 갯수를 지정 하세요","5")
var names = new Array(how_many)
for(i=0; i<=(how_many - 1); i++) {
        entered_name = prompt((i + 1)+" 번째 데이터를 입력 하세요 ")
        names[i] = entered_name
}
document.write("귀하께서 입력하신 내용은 이렇슴다")
document.write("<OL>")
for (x in names) {
        document.write("<LI>" + names[x])
}
document.write("</OL><BR><BR>")
document.write("알파벳 순으로 정렬시켜 보니 이렇군요")
document.write("<OL>")
names = names.sort()
for (x in names) {
        document.write("<LI>" + names[x])
}
document.write("<OL>")
//-->
</SCRIPT>
 
 







94    입력된 메세지의 용량 구하기 

 
<!--  아래와 같은 방법으로 BODY 부분에 스크립트를 입력하세요 -->
<script language="javascript">
function calc_length()
{
var doc1 = document.form1.S1.value   
document.form1.box.value = doc1.length + " Bytes" 
var rohn1 = doc1.length / 1024         
var rohn2 = rohn1 * 1000
var rohn3 = parseInt(rohn2)
var kb   = rohn3 /1000
document.form1.box2.value = kb + " KB"
}
</script>
<div align="center">
<form name="form1">
<textarea rows="10" name="S1" cols="50">이 스크립트는 TEXTAREA 에 작성된 메세지의 전체 용량을 계산하여 아래쪽에 바이트와 킬로바이트 단위로 보여줍니다</textarea><br>
<input type="button" name="b1" value=" 계산하기 " onClick="calc_length()"><br>
<input type="text" name="box" style="border: 0" disabled><br>
<input type="text" name="box2" style="border: 0" disabled>
</form>
</div> 
 







93    회원명단에서 선택된 회원들에게 동일내용으로 이메일 보내기

<!-- 1. 메모장 등으로 아래의 내용을 HTML 문서의 HEAD 부분에 붙여 넣으세요 -->
<SCRIPT LANGUAGE="JavaScript">
<!--
/////////////// 아이디|성명|이메일주소|전화번호 //////////////////////
var addrSo = new Array(10); // 전체 회원의 수
addrSo[0] = "[뻐꾸기]|김동수|aaa@domain.com|(02)1234-5678" 
addrSo[1] = "[갈매기]|이영민|bbb@domain.com|(032)234-5678"
addrSo[2] = "[오리알]|황익현|ccc@domain.com|(042)234-5678"
addrSo[3] = "[dream]|마광수|ddd@domain.com|(061)1234-5678"
addrSo[4] = "[1004]|서태쥐|eee@domain.com|(02)1234-5678"
addrSo[5] = "[toto]|김대충|fff@domain.com|(02)1234-5678"
addrSo[6] = "[타조알]|한고집|ggg@domain.com|(02)1234-5678"
addrSo[7] = "[aroma]|민아리||(02)1234-5678"
addrSo[8] = "[개다리]|도곤봉|hhh@domain.com|(02)1234-5678"
addrSo[9] = "[도끼]|김동필||(02)1234-5678"

var ieStart = "<table border=0><tr><td width=40 valign=top align=left></td><td width=500><h1>회원 연락처</h1><p class='tiny'>(모두체크 : X  모두해제 : O )<table width=470 border=0 cellspacing=3 cellpadding=3><tr><td colspan=3 height=10> </td></tr><tr bgcolor='#ffcc33'><td colspan=3 width=470><b> 등록된 회원</b></td></tr><tr bgcolor='#cccccc'><td align='center'><input type='button' value='X' onclick='checkAll();'><input type='button' value='O' onclick='clearAll();'></td><td>성명 [닉네임]</td><td>전화번호</td></tr>"
var ieEnd = "</table></td></tr><tr><td width=40 valign=top align=left></td><td width=500 valign=bottom>...선택한 회원에게 한꺼번에 메일 보내기..... <input type='button' value=' 메일발송 ' onclick='sendMail();'></td></tr></table>"
var nsStart = "<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.0 Transitional//EN'><html><head><title>회원에게 메일 보내기</title><script language='JavaScript' src='address.js'></script><style>H1 {font-family:Verdana; font-size:16pt; font-weight:bold; color:#006699; margin-top:0pt;} H2 {} A {text-decoration:none; color:#000000;} A:link {text-decoration:none; color:#000000;} A:vlink {text-decoration:none; color:#cc33cc;} A:active {text-decoration:none; color:#000000;} A:hover {text-decoration:none; color:#3300ff; font-weight:bold;} TD {font-family:Verdana; font-size:11pt;} .TINY {font-family:Verdana; font-size:10pt;} </style><body><form name='collsend'><table border=0><tr><td width=40 valign=top align=left></td><td width=500><h1>회원 연락처</h1><p class='tiny'>( 모두선택 : X 모두해제 : O)<table width=470 border=0 cellspacing=3 cellpadding=3><tr><td colspan=3 height=10> </td></tr><tr bgcolor='#ffcc33'><td colspan=3 width=470><b> 등록 회원 명단</b></td></tr><tr bgcolor='#cccccc'><td align='center'><input type='button' value='X' onclick='checkAll();'><input type='button' value='O' onclick='clearAll();'></td><td>이름 [닉네임]</td><td>전화번호</td></tr>"
var nsEnd = "</table></td></tr><tr><td width=40 valign=top align=left></td><td width=500 valign=bottom>...선택된 회원에게 메일 보내기...... <input type='button' value=' 메일발송 ' onclick='sendMail();'></td></tr></table></form><p> </p></body></html>"

function showAddr() {
        var tabrow = ""
        addrSo.sort();
                for (var i=0; i<addrSo.length; i++) {
                        var setsplit = addrSo[i].split("|");
                        var lname = setsplit[0];
                        var fname = setsplit[1];
                        var email = setsplit[2];
                        var phone = setsplit[3];
                        tabrow = tabrow + "<tr bgcolor='#f0f0f0'><td align='center'><input type='checkbox' name="+i+" value="+email+"></td><td><a href='mailto:"+email+"'>"+fname+" "+lname+"</a></td><td>"+phone+"</td></tr>";
                }
                if (document.all) {
                        collsend.innerHTML = ieStart+tabrow+ieEnd                
                }
                if (document.layers) {
                        document.write(nsStart+tabrow+nsEnd);
                }
}
function sendMail() {
        var mailer = ""
        for (var i=2; i<=addrSo.length+1; i++) {
                if (document.forms.collsend[i].checked == true) {
                        if (document.forms.collsend[i].value != "") {
                                mailer = mailer + document.forms.collsend[i].value + ";"
                        }
                }
        }
        if (mailer != "") {
                var start = 0
                var end = mailer.length-1;
                window.location.href = "mailto:"+mailer.substring(start,end);
        }
        else if (mailer == "") {
                alert("Please check at least one list item!");
        }
}
function checkAll() {
        for (var i=2; i<=addrSo.length+1; i++) {
                if (document.forms.collsend[i].checked != true && document.forms.collsend[i].value != "") {
                        document.forms.collsend[i].checked = true;
                }
        }
}
function clearAll() {
        for (var i=2; i<=addrSo.length+1; i++) {
                if (document.forms.collsend[i].checked = true) {
                        document.forms.collsend[i].checked = false;
                }
        }
}
//-->
</SCRIPT>
<style>
H1 {font-family:Verdana; font-size:16pt; font-weight:bold; color:#006699; margin-top:0pt;}
H2 {}
A {text-decoration:none; color:#000000;}
A:link {text-decoration:none; color:#000000;}
A:vlink {text-decoration:none; color:#cc33cc;}
A:active {text-decoration:none; color:#000000;}
A:hover {text-decoration:none; color:#3300ff; font-weight:bold;}
TD {font-family:Verdana; font-size:11pt;}
.TINY {font-family:Verdana; font-size:10pt;}
</style>
</head>
<!-- 2. 메모장 등으로 아래의 내용을 HTML 문서의 <BODY> 태그 안에 붙여 넣으세요 -->
<body onload="showAddr();">
<!-- 3. 메모장 등으로 아래의 방법으로 HTML 문서의 BODY 부분에 붙여 넣으세요 -->
<form name="collsend">
</form>
 
 







92    효율적인 날짜 드롭다운 상자 만들기   

 
<!-- 1. 메모장 등으로 아래의 내용을 HTML 문서의 HEAD 부분에 붙여 넣으세요 -->
<SCRIPT LANGUAGE="JavaScript">
<!--
function MyDropDown() {
  var Today = new Date()
  var day = Today.getDate()
  var month = Today.getMonth()
  document.FNQRY.beg_month.selectedIndex=month
  document.FNQRY.beg_day.selectedIndex=(day-1);
  document.FNQRY.end_month.selectedIndex=month
  document.FNQRY.end_day.selectedIndex=(day-1);
}
//-->
</SCRIPT> 
</HEAD>
<!-- 2. 메모장 등으로 아래의 내용을 HTML 문서의 <BODY> 태그 안에 붙여 넣으세요 -->

<BODY ONLOAD='MyDropDown()'>
<!-- 3. 메모장 등으로 아래의 방법으로 HTML 문서의 BODY 부분에 붙여 넣으세요 -->
<FORM NAME=FNQRY>
<P><SELECT NAME="beg_month" SIZE="1">
<OPTION VALUE="1">January</OPTION>
<OPTION VALUE="2">February</OPTION>
<OPTION VALUE="3">March</OPTION>
<OPTION VALUE="4">April</OPTION>
<OPTION VALUE="5">May</OPTION>
<OPTION VALUE="6">June</OPTION>
<OPTION VALUE="7">July</OPTION>
<OPTION VALUE="8">August</OPTION>
<OPTION VALUE="9">September</OPTION>
<OPTION VALUE="10">October</OPTION>
<OPTION VALUE="11">November</OPTION>
<OPTION VALUE="12">December</OPTION>
</SELECT>
<SELECT NAME="beg_day" SIZE="1"><OPTION VALUE="01">1</OPTION>
<OPTION VALUE="02">2</OPTION>
<OPTION VALUE="03">3</OPTION>
<OPTION VALUE="04">4</OPTION>
<OPTION VALUE="05">5</OPTION>
<OPTION VALUE="06">6</OPTION>
<OPTION VALUE="07">7</OPTION>
<OPTION VALUE="08">8</OPTION>
<OPTION VALUE="09">9</OPTION>
<OPTION VALUE="10">10</OPTION>
<OPTION VALUE="11">11</OPTION>
<OPTION VALUE="12">12</OPTION>
<OPTION VALUE="13">13</OPTION>
<OPTION VALUE="14">14</OPTION>
<OPTION VALUE="15">15</OPTION>
<OPTION VALUE="16">16</OPTION>
<OPTION VALUE="17">17</OPTION>
<OPTION VALUE="18">18</OPTION>
<OPTION VALUE="19">19</OPTION>
<OPTION VALUE="20">20</OPTION>
<OPTION VALUE="21">21</OPTION>
<OPTION VALUE="22">22</OPTION>
<OPTION VALUE="23">23</OPTION>
<OPTION VALUE="24">24</OPTION>
<OPTION VALUE="25">25</OPTION>
<OPTION VALUE="26">26</OPTION>
<OPTION VALUE="27">27</OPTION>
<OPTION VALUE="28">28</OPTION>
<OPTION VALUE="29">29</OPTION>
<OPTION VALUE="30">30</OPTION>
<OPTION VALUE="31">31</OPTION>
</SELECT>
<SELECT NAME="beg_year" SIZE="1"><OPTION VALUE="2001">2001</OPTION>
</SELECT>
- <SELECT NAME="end_month" SIZE="1"><OPTION VALUE="1">January</OPTION>
<OPTION VALUE="2">February</OPTION>
<OPTION VALUE="3">March</OPTION>
<OPTION VALUE="4">April</OPTION>
<OPTION VALUE="5">May</OPTION>
<OPTION VALUE="6">June</OPTION>
<OPTION VALUE="7">July</OPTION>
<OPTION VALUE="8">August</OPTION>
<OPTION VALUE="9">September</OPTION>
<OPTION VALUE="10">October</OPTION>
<OPTION VALUE="11">November</OPTION>
<OPTION VALUE="12">December</OPTION>
</SELECT>
<SELECT NAME="end_day" SIZE="1"><OPTION VALUE="01">1</OPTION>
<OPTION VALUE="02">2</OPTION>
<OPTION VALUE="03">3</OPTION>
<OPTION VALUE="04">4</OPTION>
<OPTION VALUE="05">5</OPTION>
<OPTION VALUE="06">6</OPTION>
<OPTION VALUE="07">7</OPTION>
<OPTION VALUE="08">8</OPTION>
<OPTION VALUE="09">9</OPTION>
<OPTION VALUE="10">10</OPTION>
<OPTION VALUE="11">11</OPTION>
<OPTION VALUE="12">12</OPTION>
<OPTION VALUE="13">13</OPTION>
<OPTION VALUE="14">14</OPTION>
<OPTION VALUE="15">15</OPTION>
<OPTION VALUE="16">16</OPTION>
<OPTION VALUE="17">17</OPTION>
<OPTION VALUE="18">18</OPTION>
<OPTION VALUE="19">19</OPTION>
<OPTION VALUE="20">20</OPTION>
<OPTION VALUE="21">21</OPTION>
<OPTION VALUE="22">22</OPTION>
<OPTION VALUE="23">23</OPTION>
<OPTION VALUE="24">24</OPTION>
<OPTION VALUE="25">25</OPTION>
<OPTION VALUE="26">26</OPTION>
<OPTION VALUE="27">27</OPTION>
<OPTION VALUE="28">28</OPTION>
<OPTION VALUE="29">29</OPTION>
<OPTION VALUE="30">30</OPTION>
<OPTION VALUE="31">31</OPTION>
</SELECT>
<SELECT NAME="end_year" SIZE="1"><OPTION VALUE="2001">2001</OPTION>
</SELECT>
</P>
<P><INPUT TYPE="SUBMIT" NAME="Submit1" VALUE=" 전 송 "></P>
</FORM>
 
 







91    폼메일 스크립트 (공백입력,전화번호, 이메일 유효성 검사)

 
이 (자바스크립트를 이용한) 폼 메일은 전송시 사용자 PC의 메일클라이언트 (아웃룩 익스프레스 등)을 이용하여 메일을 전송합니다.
자체 메일서버를 이용한 폼메일은 CGI 자료실의 폼메일 스크립트를 이용하세요.
아래의 폼메일에서 양식을 변경하고자 할때에는, 먼저, <form></form> 사이의 각 항목 을 추가/삭제 하시고, 해당 항목에 대한 빈칸체크 스크립트도 동시에 삭제 해 주어야 자바스크립트 에러가 생기지 않습니다.
이메일항목은 가능하면 지우지 마세요.
역시 지우시려면 두번째 자바스크립트내의 이메일체크 스크립트를 삭제 하여야 에러가 생기지 않습니다
<HTML>
<HEAD>
<!-- 1. 아래의 스크립트를 HEAD 부분에 복사 해 넣으세요 -->
<!---------- 전화번호 유효성 검사 ----------------------->
<script language="JavaScript" type="text/javascript">
<!-- 
var nr=0;
function numericCheck(){
  nr1=document.pform.PHONE.value;
  flg=0;
  str="";
  spc=""
  arw="";
  for (var i=0;i<nr1.length;i++){
   cmp="0123456789"
   tst=nr1.substring(i,i+1)
   if (cmp.indexOf(tst)<0){
    flg++;
    str+=" "+tst;
    spc+=tst;
    arw+="^";
   }
   else{arw+="_";}
  }
  if (flg!=0){
   if (spc.indexOf(" ")>-1) {
    str+=" and/or a space";
    }
   alert('잘못 입력하였습니다');
   return false;
  }
  return true;
}
//-->
</SCRIPT>

<!--------------- 공백 체크 및 이메일 유효성 검사 -------------------->
<script language="JavaScript" type="text/javascript">
<!--
function CheckFields(pform) {
// 공백란 체크
  if ( pform.NAME.value   == "" ||          // 이름항목
       pform.NICNAME.value  == "" ||      // 아이디(별명)항목
       pform.EMAIL.value  == "" ||           // 이메일 항목
       pform.ADDRESS.value    == "" ||      // 주소 항목
       pform.POSTCODE.value    == "" ||     // 우편번호 항목
       pform.PHONE.value    == "" ) {            // 전화번호 항목
     alert( "필수항목 입력이 되지 않았습니다" );
     return false;
  }
// 이메일 체크
else if ( pform.EMAIL.value.length <= 6 ||
      pform.EMAIL.value.indexOf ('@', 0) == -1 ||
      pform.EMAIL.value.indexOf ('.', 0) == -1){
      alert("'' " + pform.EMAIL.value + " '', 은 이메일주소가 아닙니다");
      return false;
}
  else {
         alert ("'감사합니다'" +pform.NAME.value + " '' \n자료가 서버에 전송될동안 잠시 기다려 주세요")
         
     // 받을 이메일 주소 입력
     pform.action="mailto:jaytee@dreamwiz.com";
     // 전송후 리다이렉트 될 페이지 설정
         location.href="thanks.htm";
         
                  
     return true;
  }
}
// -->
</script>
</HEAD>
<BODY BGCOLOR="#CCFF99">
<!-- 2. 아래와 같은 방법으로 BODY 부분에 스크립트를 입력하세요 -->
<!--- enctype 은 반드시 text/plain 으로 해 줍니다 ---------------->
<form method="POST"  OnSubmit="JavaScript:return CheckFields(this);" name="pform" enctype="text/plain">
    
  <table cellspacing=0 cellpadding=0 width=450 border=0 height="114" align="center">
    <tbody> 
    <tr width=442> 
      <td colspan=4><img  src="1px.gif" height=1 width=442></td>
    </tr>
    
<!------------------- 상단 타이틀 부분 -------------------------------------------->
        
        <tr> 
      <td width=2 bgcolor=#cccccc rowspan=17><img height=10 
src="images/airshim.gif" width=1></td>
      <td bgcolor=#006600 height="25" colspan="2"> 
        <div align="center"><font face="Arial, Helvetica, sans-serif" 
color=#bddbf8 size=3><b><font color="#ffffff">폼 메일 샘플</font></b></font></div>
      </td>
      <td bgcolor=#006600 rowspan="17" height="37" width="1"></td>
    </tr>
  <!--------------- 메일리스트 가입여부 -------------------------------------------->
        
        <tr> 
      <td colspan="2" bgcolor=#D2DFCE height="40"> 
        <p align=center><br>
          <font color="#000000" face="Verdana, Arial, Helvetica, sans-serif" size="2"><b>메일리스트에 가입</b></font><font color="#000000">: 
          <input type="radio" name="ADD_TO_MAIL_LIST" value="Yes">가입 
          <input type="radio" name="ADD_TO_MAIL_LIST" value="No">노우<br>
          <br>
          </font></p>
      </td>
    </tr>
    
<!---------------보내는 사람 이름 입력 -------------------------------------->
        
        <tr> 
      <td valign=top width="220" bgcolor=#D2DFCE> <font color="#000000" face="Verdana, Arial, Helvetica, sans-serif" size="2"><b>  * </b>이름 :</font> </td>
      <td valign=top width="230" bgcolor=#D2DFCE> 
        <div align="left"> 
          <input type=TEXT size=25 name="NAME">
        </div>
      </td>
    </tr>
<!--------------- 아이디 입력 ------------------------------------------------>

    <tr> 
      <td valign=top width="220" bgcolor=#D2DFCE> 
        <div align="left"><font color="#000000" face="Verdana, Arial, Helvetica, sans-serif" size="2"><b>  * </b>별명(혹은 아이디):  </font></div>
      </td>
      <td valign=top width="230" bgcolor=#D2DFCE> 
        <div align="left"> 
          <input type=TEXT size=25 name="NICNAME">
        </div>
      </td>
    </tr>
    
        
<!---------------- 전화 번호 입력 -------------------------------------------->
        
        <tr> 
      <td valign=top width="220" bgcolor=#D2DFCE> 
        <div align="left"><font color="#000000" face="Verdana, Arial, Helvetica, sans-serif" size="2"><b>  * </b>전화번호 :  </font></div>
      </td>
      <td valign=top width="230" bgcolor=#D2DFCE> 
        <div align="left"> 
          <input type=text name="PHONE" size="25" maxlength="10" onBlur="numericCheck()">
        </div>
      </td>
    </tr>
    
        
<!----------------- 이메일 입력 ---------------------------------------------->
        
        
        <tr> 
      <td valign=top width="220" bgcolor=#D2DFCE> 
        <div align="left"><font color="#000000" face="Verdana, Arial, Helvetica, sans-serif" size="2"><b>  * </b>E-mail :  </font></div>
      </td>
      <td valign=top width="230" bgcolor=#D2DFCE> 
        <div align="left"> 
          <input name="EMAIL" type=TEXT size=25 value="-- your email --">
        </div>
      </td>
    </tr>
    
<!------------------ 주소 입력 ---------------------------------------------->
        
        <tr> 
      <td valign=top width="220" bgcolor=#D2DFCE> 
        <div align="left">  <font color="#000000" face="Verdana, Arial, Helvetica, sans-serif" size="2"><b>* 
          </b>주소 :  </font></div>
      </td>
      <td valign=top width="180" bgcolor=#D2DFCE> 
        <div align="left"> 
          <textarea name="ADDRESS" cols="20"></textarea>
        </div>
      </td>
    </tr>
    
        
<!-------------------- 우편 번호 입력 ---------------------------------------->
        
        <tr> 
      <td valign=top width="220" bgcolor=#D2DFCE> 
        <div align="left"><font color="#000000" face="Verdana, Arial, Helvetica, sans-serif" size="2"><b>  *</b> 
          우편번호 :  </font></div>
      </td>
      <td valign=top width="230" bgcolor=#D2DFCE> 
        <div align="left"> 
          <input type="text" name="POSTCODE" size="6" maxlength="6">
        </div>
      </td>
    </tr>
    
        
        <tr> 
      <td valign=top colspan="2" bgcolor=#D2DFCE height="12" align="center"> 
        <p align="center"><font color=000000><font color=000000><font face="Verdana, Arial, Helvetica, sans-serif" size="2"><br>
<!--------숨은 항목으로 전송 ---------------------------------------------------->                  
                  
<script language=JAVASCRIPT type="text/javascript">
                <!-- 
                document.write("<INPUT TYPE=hidden NAME='PAGE TITLE' VALUE='"+document.title+"'>")
                document.write("<INPUT TYPE=hidden NAME='URL' VALUE='"+document.URL+"'>")
                document.write("<INPUT TYPE=hidden NAME='DOMAIN' VALUE='"+document.domain+"'>")
                document.write("<INPUT TYPE=hidden NAME='REFERRERED BY' VALUE='"+document.referrer+"'>")
                document.write("<INPUT TYPE=hidden NAME='BROWSER USED' VALUE='"+navigator.appName+" "+navigator.appVersion+"'>")
                // -->
</script>

<!-------------------- 전송 버튼 ------------------------------------------------>
                  <input type="submit" name="Submit" value=" 보내기 ">
          </font></font></font></p>
        <p align="center"> </p>
      </td>
    </tr>
    </tbody> 
  </table>
  
  
  <br>
</form>
</BODY>
</HTML> 
 






90    텍스트 상자의 내용을 한꺼번에 선택 합니다 

<!-- 메모장 등으로 아래의 방법으로 HTML 문서의 BODY 부분에 붙여 넣으세요 -->
<form NAME="form">
<input type=button value=" 선택하기 " onClick="javascript:this.form.txt.focus();this.form.txt.select();">    
<textarea NAME="txt" ROWS=10 COLS=75 WRAP=VIRTUAL>
이곳에 있는 내용을 한꺼번에 선택 하려면
위의 [선택하기] 버튼을 클릭 하면 됩니다
</textarea>
</form>
 
 







89    경고창을 15초 동안 닫을 수 없습니다  

<!-- 3. 메모장 등으로 아래의 방법으로 HTML 문서의 BODY 부분에 붙여 넣으세요 -->
<script>
var now=new Date();
var a=now.getSeconds();
alert("이 창은 15초가 되지 않으면 닫을 수 없습니다");
var now2=new Date();
var b=now2.getSeconds();
if (b<a) {
b=b+60; }
/************** b=b-15 부분에서 15는 지연시간을 나타냅니다 ***********/
b=b-15;
while (b<=a) {
/************** 이곳에 원하는 안내문구를 넣으세요 ********************/
alert("이 메세지는 alert 상자에 나타나는 메세지 입니다\n이 메세지는 사용자께서 반드시 읽어 보아야 할 메세지 이므로\n15초가 지나기 전에는 절대 닫지 못합니다\n\n감사합니다");
/************** 여기까지 ********************************************/
now2=new Date();
b=now2.getSeconds();
if (b<a) {
b=b+60; }
/************** b=b-15 부분에서 15는 지연시간을 나타냅니다 ***********/
b=b-15; }
 
 






88    원하는 포맷으로 날짜형식 입력받기  

 
<!-- 1. 아래의 스크립트를 HEAD 부분에 복사 해 넣으세요 -->
<script language="javascript">
<!-- 
var isNav4 = false, isNav5 = false, isIE4 = false
var strSeperator = "/"; 
var vDateType = 3; // 날짜형식
//                1 = mm/dd/yyyy
//                2 = yyyy/dd/mm  
//                3 = dd/mm/yyyy
var vYearType = 4; // 네츠케이프용 2자리 혹은 4자리 연도 표기
var vYearLength = 2; // 사용자 입력 연도 자릿수
var err = 0; // 에러코드 디폴트값

if(navigator.appName == "Netscape") 
{
   if (navigator.appVersion < "5")  
   {
      isNav4 = true;
      isNav5 = false;
        }
   else
   if (navigator.appVersion > "4") 
   {
      isNav4 = false;
      isNav5 = true;
        }
}
else  
{
   isIE4 = true;
}
function DateFormat(vDateName, vDateValue, e, dateCheck, dateType)  {
vDateType = dateType;
   
   if (vDateValue == "~")
   {
      alert("AppVersion = "+navigator.appVersion+" \nNav. 4 Version = "+isNav4+" \nNav. 5 Version = "+isNav5+" \nIE Version = "+isIE4+" \nYear Type = "+vYearType+" \nDate Type = "+vDateType+" \nSeparator = "+strSeperator);
      vDateName.value = "";
      vDateName.focus();
      return true;
   }
      
   var whichCode = (window.Event) ? e.which : e.keyCode;
   if (vDateValue.length > 8 && isNav4)
   {
      if ((vDateValue.indexOf("-") >= 1) || (vDateValue.indexOf("/") >= 1))
         return true;
   }
   
   var alphaCheck = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ/-";
   if (alphaCheck.indexOf(vDateValue) >= 1)  
   {
      if (isNav4)
      {
         vDateName.value = "";
         vDateName.focus();
         vDateName.select();
         return false;
      }
      else
      {
         vDateName.value = vDateName.value.substr(0, (vDateValue.length-1));
         return false;
      } 
   }
   if (whichCode == 8)
      return false;
   else 
   {
      var strCheck = '47,48,49,50,51,52,53,54,55,56,57,58,59,95,96,97,98,99,100,101,102,103,104,105';
      if (strCheck.indexOf(whichCode) != -1)  
      {
         if (isNav4)  
         {
            if (((vDateValue.length < 6 && dateCheck) || (vDateValue.length == 7 && dateCheck)) && (vDateValue.length >=1))
            {
               alert("Invalid Date\nPlease Re-Enter");
               vDateName.value = "";
               vDateName.focus();
               vDateName.select();
               return false;
            }
            if (vDateValue.length == 6 && dateCheck)  
            {
               var mDay = vDateName.value.substr(2,2);
               var mMonth = vDateName.value.substr(0,2);
               var mYear = vDateName.value.substr(4,4)
               
               if (mYear.length == 2 && vYearType == 4) 
               {
                  var mToday = new Date();
                  
                  var checkYear = mToday.getFullYear() + 30; 
                  var mCheckYear = '20' + mYear;
                  if (mCheckYear >= checkYear)
                     mYear = '19' + mYear;
                  else
                     mYear = '20' + mYear;
               }
               var vDateValueCheck = mMonth+strSeperator+mDay+strSeperator+mYear;
               
               if (!dateValid(vDateValueCheck))  
               {
                  alert("Invalid Date\nPlease Re-Enter");
                  vDateName.value = "";
                  vDateName.focus();
                  vDateName.select();
                  return false;
                         }
               return true;
            
            }
            else
            {
               
               if (vDateValue.length >= 8  && dateCheck)  
               {
                  if (vDateType == 1) // mmddyyyy
                  {
                     var mDay = vDateName.value.substr(2,2);
                     var mMonth = vDateName.value.substr(0,2);
                     var mYear = vDateName.value.substr(4,4)
                     vDateName.value = mMonth+strSeperator+mDay+strSeperator+mYear;
                  }
                  if (vDateType == 2) // yyyymmdd
                  {
                     var mYear = vDateName.value.substr(0,4)
                     var mMonth = vDateName.value.substr(4,2);
                     var mDay = vDateName.value.substr(6,2);
                     vDateName.value = mYear+strSeperator+mMonth+strSeperator+mDay;
                  }
                  if (vDateType == 3) // ddmmyyyy
                  {
                     var mMonth = vDateName.value.substr(2,2);
                     var mDay = vDateName.value.substr(0,2);
                     var mYear = vDateName.value.substr(4,4)
                     vDateName.value = mDay+strSeperator+mMonth+strSeperator+mYear;
                  }
                  
                  var vDateTypeTemp = vDateType;
                  vDateType = 1;
                  var vDateValueCheck = mMonth+strSeperator+mDay+strSeperator+mYear;
                  
                  if (!dateValid(vDateValueCheck))  
                  {
                     alert("Invalid Date\nPlease Re-Enter");
                     vDateType = vDateTypeTemp;
                     vDateName.value = "";
                     vDateName.focus();
                     vDateName.select();
                     return false;
                            }
                     vDateType = vDateTypeTemp;
                     return true;
                    }
               else
               {
                  if (((vDateValue.length < 8 && dateCheck) || (vDateValue.length == 9 && dateCheck)) && (vDateValue.length >=1))
                  {
                     alert("Invalid Date\nPlease Re-Enter");
                     vDateName.value = "";
                     vDateName.focus();
                     vDateName.select();
                     return false;
                  }
               }
            }
         }
         else  
         {
            if (((vDateValue.length < 8 && dateCheck) || (vDateValue.length == 9 && dateCheck)) && (vDateValue.length >=1))
            {
               alert("Invalid Date\nPlease Re-Enter");
               vDateName.value = "";
               vDateName.focus();
               return true;
            }
            
            if (vDateValue.length >= 8 && dateCheck)  
            {
            
              
               if (vDateType == 1) // mm/dd/yyyy
               {
                  var mMonth = vDateName.value.substr(0,2);
                  var mDay = vDateName.value.substr(3,2);
                  var mYear = vDateName.value.substr(6,4)
               }
               if (vDateType == 2) // yyyy/mm/dd
               {
                  var mYear = vDateName.value.substr(0,4)
                  var mMonth = vDateName.value.substr(5,2);
                  var mDay = vDateName.value.substr(8,2);
               }
               if (vDateType == 3) // dd/mm/yyyy
               {
                  var mDay = vDateName.value.substr(0,2);
                  var mMonth = vDateName.value.substr(3,2);
                  var mYear = vDateName.value.substr(6,4)
               }
               if (vYearLength == 4)
               {
                  if (mYear.length < 4)
                  {
                     alert("Invalid Date\nPlease Re-Enter");
                     vDateName.value = "";
                     vDateName.focus();
                     return true;
                  }
               }
               
              var vDateTypeTemp = vDateType;
               
               vDateType = 1;
               
               var vDateValueCheck = mMonth+strSeperator+mDay+strSeperator+mYear;
               
               if (mYear.length == 2 && vYearType == 4 && dateCheck)  
               {
                  
                  var mToday = new Date();
                  
                  var checkYear = mToday.getFullYear() + 30; 
                  var mCheckYear = '20' + mYear;
                  if (mCheckYear >= checkYear)
                     mYear = '19' + mYear;
                  else
                     mYear = '20' + mYear;
                  vDateValueCheck = mMonth+strSeperator+mDay+strSeperator+mYear;
                  
                  if (vDateTypeTemp == 1) // mm/dd/yyyy
                     vDateName.value = mMonth+strSeperator+mDay+strSeperator+mYear;
                  if (vDateTypeTemp == 3) // dd/mm/yyyy
                     vDateName.value = mDay+strSeperator+mMonth+strSeperator+mYear;
               } 
               
               
               if (!dateValid(vDateValueCheck))  
               {
                  alert("Invalid Date\nPlease Re-Enter");
                  vDateType = vDateTypeTemp;
                  vDateName.value = "";
                  vDateName.focus();
                  return true;
                         }
               vDateType = vDateTypeTemp;
               return true;
            
            }
            else
            {
               
               if (vDateType == 1)
               {
                  if (vDateValue.length == 2)  
                  {
                     vDateName.value = vDateValue+strSeperator;
                  }
                  if (vDateValue.length == 5)  
                  {
                     vDateName.value = vDateValue+strSeperator;
                  }
               }
               if (vDateType == 2)
               {
                  if (vDateValue.length == 4)  
                  {
                     vDateName.value = vDateValue+strSeperator;
                  }
                  if (vDateValue.length == 7)  
                  {
                     vDateName.value = vDateValue+strSeperator;
                  }
               } 
               if (vDateType == 3)
               {
                  if (vDateValue.length == 2)  
                  {
                     vDateName.value = vDateValue+strSeperator;
                  }
                  if (vDateValue.length == 5)  
                  {
                     vDateName.value = vDateValue+strSeperator;
                  }
               }
               return true;
            }
         }
         if (vDateValue.length == 10   && dateCheck)  
         {
            if (!dateValid(vDateName))  
            {
               alert("Invalid Date\nPlease Re-Enter");
               vDateName.focus();
               vDateName.select();
                 }
         }
         return false;
      }
      else  
      {
         if (isNav4)
         {
            vDateName.value = "";
            vDateName.focus();
            vDateName.select();
            return false;
         }
         else
         {
            vDateName.value = vDateName.value.substr(0, (vDateValue.length-1));
            return false;
         }
                }
        }
}

   function dateValid(objName) {
      var strDate;
      var strDateArray;
      var strDay;
      var strMonth;
      var strYear;
      var intday;
      var intMonth;
      var intYear;
      var booFound = false;
      var datefield = objName;
      var strSeparatorArray = new Array("-"," ","/",".");
      var intElementNr;
      // var err = 0;
      var strMonthArray = new Array(12);
      strMonthArray[0] = "Jan";
      strMonthArray[1] = "Feb";
      strMonthArray[2] = "Mar";
      strMonthArray[3] = "Apr";
      strMonthArray[4] = "May";
      strMonthArray[5] = "Jun";
      strMonthArray[6] = "Jul";
      strMonthArray[7] = "Aug";
      strMonthArray[8] = "Sep";
      strMonthArray[9] = "Oct";
      strMonthArray[10] = "Nov";
      strMonthArray[11] = "Dec";
      
      //strDate = datefield.value;
      strDate = objName;
      
      if (strDate.length < 1) {
         return true;
      }
      for (intElementNr = 0; intElementNr < strSeparatorArray.length; intElementNr++) {
         if (strDate.indexOf(strSeparatorArray[intElementNr]) != -1) 
         {
            strDateArray = strDate.split(strSeparatorArray[intElementNr]);
            if (strDateArray.length != 3) 
            {
               err = 1;
               return false;
            }
            else 
            {
               strDay = strDateArray[0];
               strMonth = strDateArray[1];
               strYear = strDateArray[2];
            }
            booFound = true;
         }
      }
      if (booFound == false) {
         if (strDate.length>5) {
            strDay = strDate.substr(0, 2);
            strMonth = strDate.substr(2, 2);
            strYear = strDate.substr(4);
         }
      }
      //Adjustment for short years entered
      if (strYear.length == 2) {
         strYear = '20' + strYear;
      }
      strTemp = strDay;
      strDay = strMonth;
      strMonth = strTemp;
      intday = parseInt(strDay, 10);
      if (isNaN(intday)) {
         err = 2;
         return false;
      }
      
      intMonth = parseInt(strMonth, 10);
      if (isNaN(intMonth)) {
         for (i = 0;i<12;i++) {
            if (strMonth.toUpperCase() == strMonthArray[i].toUpperCase()) {
               intMonth = i+1;
               strMonth = strMonthArray[i];
               i = 12;
            }
         }
         if (isNaN(intMonth)) {
            err = 3;
            return false;
         }
      }
      intYear = parseInt(strYear, 10);
      if (isNaN(intYear)) {
         err = 4;
         return false;
      }
      if (intMonth>12 || intMonth<1) {
         err = 5;
         return false;
      }
      if ((intMonth == 1 || intMonth == 3 || intMonth == 5 || intMonth == 7 || intMonth == 8 || intMonth == 10 || intMonth == 12) && (intday > 31 || intday < 1)) {
         err = 6;
         return false;
      }
      if ((intMonth == 4 || intMonth == 6 || intMonth == 9 || intMonth == 11) && (intday > 30 || intday < 1)) {
         err = 7;
         return false;
      }
      if (intMonth == 2) {
         if (intday < 1) {
            err = 8;
            return false;
         }
         if (LeapYear(intYear) == true) {
            if (intday > 29) {
               err = 9;
               return false;
            }
         }
         else {
            if (intday > 28) {
               err = 10;
               return false;
            }
         }
      }
         return true;
      }
   function LeapYear(intYear) {
      if (intYear % 100 == 0) {
         if (intYear % 400 == 0) { return true; }
      }
      else {
         if ((intYear % 4) == 0) { return true; }
      }
         return false;
      }
//  End -->
</script>

</HEAD>
<!-- 2. BODY 태그안에 아래와 같이 함수를 복사해 넣으세요 -->
<BODY BGCOLOR="#CCFF99" onLoad="document.dateTest.testDateFormat1.focus()">
<!-- 3. 아래와 같은 방법으로 BODY 부분에 스크립트를 입력하세요 -->
<form name='dateTest'>
      <table border = '0' width='400'  align=center>
      <tr>
         <td>
            <table align='center' border='1' width='400'>
               <tr>
                  <td  bgcolor='orange' width='75%' align=center>
                     <font color='black'><B>mm/dd/yyyy 형식</B></font>
                  </td>
                  <td>
                     <input type="text" name="testDateFormat1" size='10' maxlength="10" onFocus="javascript:vDateType='1'" onKeyUp="DateFormat(this,this.value,event,false,'1')" onBlur="DateFormat(this,this.value,event,true,'1')">
                  </td>
               </tr>
            </table>
         </td>
       </tr>
       <tr>
         <td>
            <table align='center' border='1' width='400'>
               <tr>
                  <td  bgcolor='orange' width='75%' align=center>
                     <font color='black'><B>yyyy/mm/dd 형식</B></font>
                  </td>
                  <td>
                     <input type="text" name="testDateFormat3" size='10' maxlength="10" onFocus="javascript:vDateType='2'" onKeyUp="DateFormat(this,this.value,event,false,'2')" onBlur="DateFormat(this,this.value,event,true,'2')">
                  </td>
               </tr>
            </table>
         </td>
      </tr>
      <tr>
         <td>
            <table align='center' border='1' width='400'>
               <tr>
                  <td  bgcolor='orange' width='75%' align=center>
                     <font color='black'><B>dd/mm/yyyy 형식</B></font>
                  </td>
                  <td>
                     <input type="text" name="testDateFormat5" size='10' maxlength="10" onFocus="javascript:vDateType='3'" onKeyUp="DateFormat(this,this.value,event,false,'3')" onBlur="DateFormat(this,this.value,event,true,'3')">
                  </td>
               </tr>
            </table>
         </td>
      </tr>
      </table>
               
   </form>
 
 







87    조립 컴퓨터 견적 내기 + 이메일로 주문  

 
<!-- 1. 메모장 등으로 아래의 내용을 HTML 문서의 HEAD 부분에 붙여 넣으세요 -->
<SCRIPT LANGUAGE="JavaScript">
<!--
function ComputeTotal( form )
{
/******** 각 품목별 마진율을 지정 합니다 *************/
Profit_rate1 = 1 + 0.12 
Profit_rate2 = 1 + 0.10 
Profit_rate3 = 1 + 0.11 
Profit_rate4 = 1 + 0.20 
Profit_rate5 = 1 + 0.07 
/********* 각 항목별로 마진율을 적용 합니다 
마진율 적용 없이 판매가를 적용하려면 아래 각 항목에서 Profit_rate 부분을 삭제하고
폼 항목의 value 를 판매가로 입력 합니다 ***********/
        CPU = form.CPU1.value = round(form.CPU.value * Profit_rate1)
        MAB = form.Mainboard1.value = round(form.Mainboard.value*Profit_rate2)
        MM1 = form.Memory2.value = round(form.Memory0.value * Profit_rate1)
        MM2 = form.Memory3.value = round(form.Memory1.value * Profit_rate1)
        HI1 = form.HDIDE2.value = round(form.HDIDE0.value * Profit_rate1)
        HI2 = form.HDIDE3.value = round(form.HDIDE1.value * Profit_rate1)
        HS1 = form.HDSCSI2.value = round(form.HDSCSI0.value * Profit_rate1)
        HS2 = form.HDSCSI3.value = round(form.HDSCSI1.value * Profit_rate1)
        VID = form.Video1.value = round(form.Video.value * Profit_rate3)
        MON = form.Monitor1.value = round(form.Monitor.value * Profit_rate1)
        CDR = form.CD1.value = round(form.CD.value * Profit_rate1)
        DVD = form.DVD1.value = round(form.DVD.value * Profit_rate4)
        RDR = form.Removable1.value = round(form.Removable.value * Profit_rate5)
        SND = form.Sound1.value = round(form.Sound.value * Profit_rate1)
        SPK = form.Speakers1.value = round(form.Speakers.value * Profit_rate1)
        MOD = form.Modem1.value = round(form.Modem.value * Profit_rate1)
        NET = form.Network1.value = round(form.Network.value * Profit_rate1)
        CAS = form.Case1.value = round(form.Case.value * Profit_rate1)
        MOS = form.Mouse1.value = round(form.Mouse.value * Profit_rate1)
        KEY = form.Keyboard1.value = round(form.Keyboard.value * Profit_rate1)
        OS1 = form.OS1.value = round(form.OS.value * Profit_rate1)
        SOF = form.Software1.value = round(form.Software.value * Profit_rate1)
        PRN = form.Printer1.value = round(form.Printer.value * Profit_rate1)
        SCN = form.Scanner1.value = round(form.Scanner.value * Profit_rate1)
        UPS = form.UPS1.value = round(form.UPS.value * Profit_rate1)
subtotal1 = CPU + MAB + MM1 + MM2 + HI1 + HI2 + HS1 + HS2 + VID 
        + MON + CDR + DVD + RDR + SND + SPK + MOD + NET + CAS + MOS 
        + KEY + OS1 + SOF + PRN + SCN + UPS
form.subtotal1.value = subtotal1
}
function round(number,X) {
X = (!X ? 2 : X);
return Math.round(number*Math.pow(10,X))/Math.pow(10,X);
}
//-->
</SCRIPT>
</HEAD>
<BODY>
<!----- 아래의 방법으로 HTML 문서의 BODY 부분에 붙여 넣으세요 --------->
<!----------- 이메일 주문서를 받을 주소를 설정 합니다 -------------------->
<CENTER><H3>아래 목록에서 선택 하신 후 [주문하기] 버튼을 눌러 주세요</H3></CENTER>
<FORM         METHOD="POST" ACTION="mailto:babo@babo.com?subject=주문서">
  <table width="591" border="0" bgcolor="orange">
    <tr> 
      <td bgcolor="white"  width="535"> 
        <select name="CPU" onChange="ComputeTotal(this.form)">
          <option value="0">CPU 를 선택 하세요</option>
<!-------------- value 에는 제품 원가를 입력 합니다------------------------------------->
                  <option value="200000">Intel Celeron processor 300MHz w/128KB cache PPGA</option>
          <option value="70000">Intel Celeron processor 333MHz w/128KB cache PPGA</option>
          <option value="85000">Intel Celeron processor 366MHz w/128KB cache PPGA</option>
          <option value="105000">Intel Celeron processor 400MHz w/128KB cache PPGA</option>
          <option value="135000">Intel Celeron processor 433MHz w/128KB cache PPGA</option>
          <option value="175000">Intel Celeron processor 466MHz w/128KB cache PPGA</option>
          <option value="179000">Intel Pentium II processor 350MHz w/512KB cache</option>
          <option value="185000">Intel Pentium II processor 400MHz w/512KB cache</option>
          <option value="255000">Intel Pentium III processor 450MHz w/512KB cache</option>
          <option value="480000">Intel Pentium III processor 500MHz w/512KB cache</option>
          <option value="570000">Intel Pentium III processor 550MHz w/512KB cache</option>
          <option value="35000">AMD-K6 II 300 with 3DNow! Processor Socket7</option>
          <option value="42000">AMD-K6 II 350 with 3DNow! Processor Socket7</option>
          <option value="80000">AMD-K6 II 400 with 3DNow! Processor Socket7</option>
          <option value="100000">AMD-K6 II 450 with 3DNow! Processor Socket7</option>
          <option value="170000">AMD-K6 III 400 with 3DNow! Processor Socket7</option>
          <option value="220000">AMD-K6 III 450 with 3DNow! Processor Socket7</option>
          <option value="420000">AMD-K6 III 500 with 3DNow! Processor Socket7</option>
        </select>
      </td>
      <td bgcolor="white"  width="40"> 
        <input type="TEXT" style="background-color:yellow" style="background-color:yellow" size=6 name="CPU1" maxlength="6">
      </td>
    </tr>
    <tr> 
      <td bgcolor="white"  width="535"> 
        <select name="Mainboard" onChange="ComputeTotal(this.form)">
          <option value="0">메인보드를 선택 하세요</option>
          <option value="98000">ABIT Intel 440BX Slot1 ATX</option>
          <option value="82000">Asus Intel 440BX Slot1 ATX</option>
          <option value="165000">Asus Intel 440BX Dual Slot1 ATX</option>
          <option value="240000">Asus Intel 440BX Dual Slot1 SCSI ATX</option>
          <option value="80000">EPoX Intel 440BX Slot1 ATX</option>
          <option value="160000">EPoX Intel 440BX Dual Slot1 ATX</option>
          <option value="90000">SuperMicro Intel 440BX Slot1 ATX</option>
          <option value="170000">SuperMicro Intel 440BX Dual Slot1 ATX</option>
          <option value="245000">SuperMicro Intel 440BX Dual Slot1 SCSI ATX</option>
          <option value="98000">ABIT Intel 440BX PPGA ATX</option>
          <option value="140000">ABIT Intel 440BX Dual PPGA ATX</option>
          <option value="82000">Asus Intel 440BX PPGA ATX</option>
          <option value="80000">EPoX Intel 440BX PPGA ATX</option>
          <option value="89000">SuperMicro Intel 440BX PPGA ATX</option>
          <option value="82000">Asus Intel 440BX PPGA ATX</option>
          <option value="80000">EPoX Intel 440BX PPGA ATX</option>
          <option value="85000">SuperMicro Intel 440BX PPGA Slot1 ATX</option>
          <option value="82000">Asus ALI Socket7 ATX</option>
          <option value="80000">EPoX VIA MVP3 Socket7 ATX</option>
        </select>
      </td>
      <td bgcolor="white"  width="40"> 
        <input type="TEXT" style="background-color:yellow" size=6 name="Mainboard1" maxlength="6">
      </td>
    </tr>
    <tr> 
      <td bgcolor="white"  width="535"> 
        <select name="Memory0" onChange="ComputeTotal(this.form)">
          <option value="0">Select a Momory on Blank0</option>
          <option value="32000">32 Megs PC 100 SDRAM</option>
          <option value="57000">64 Megs PC 100 SDRAM</option>
          <option value="90000">128 Megs PC 100 SDRAM</option>
        </select>
      </td>
      <td bgcolor="white"  width="40"> 
        <input type="TEXT" style="background-color:yellow" size=6 name="Memory2" maxlength="6">
      </td>
    </tr>
    <tr> 
      <td bgcolor="white"  width="535"> 
        <select name="Memory1" onChange="ComputeTotal(this.form)">
          <option value="0000">Select a Momory on Blank1 (optional)</option>
          <option value="32000">32 Megs PC 100 SDRAM</option>
          <option value="57000">64 Megs PC 100 SDRAM</option>
          <option value="90000">128 Megs PC 100 SDRAM</option>
        </select>
      </td>
      <td bgcolor="white"  width="40"> 
        <input type="TEXT" style="background-color:yellow" size=6 name="Memory3" maxlength="6">
      </td>
    </tr>
    <tr> 
      <td bgcolor="white"  width="535"> 
        <select name="HDIDE0" onChange="ComputeTotal(this.form)">
          <option value="0">Select a IDE Hard Drive1</option>
          <option value="100000">6 Gig UDMA</option>
          <option value="140000">8 Gig UDMA</option>
          <option value="175000">10 Gig UDMA</option>
          <option value="205000">13 Gig UDMA</option>
          <option value="275000">18 Gig UDMA</option>
        </select>
      </td>
      <td bgcolor="white"  width="40"> 
        <input type="TEXT" style="background-color:yellow" size=6 name="HDIDE2" maxlength="6">
      </td>
    </tr>
    <tr> 
      <td bgcolor="white"  width="535"> 
        <select name="HDIDE1" onChange="ComputeTotal(this.form)">
          <option value="0">Select a IDE Hard Drive2 (optional)</option>
          <option value="100000">6 Gig UDMA</option>
          <option value="140000">8 Gig UDMA</option>
          <option value="175000">10 Gig UDMA</option>
          <option value="205000">13 Gig UDMA</option>
          <option value="275000">18 Gig UDMA</option>
        </select>
      </td>
      <td bgcolor="white"  width="40"> 
        <input type="TEXT" style="background-color:yellow" size=6 name="HDIDE3" maxlength="6">
      </td>
    </tr>
    <tr> 
      <td bgcolor="white"  width="535"> 
        <select name="HDSCSI0" onChange="ComputeTotal(this.form)">
          <option value="0">Select a SCSI Hard Drive1 (optional)</option>
          <option value="470000">4 Gig U2 SCSI </option>
          <option value="550000">9 Gig U2 SCSI</option>
          <option value="1030000">18 Gig U2 SCSI</option>
        </select>
      </td>
      <td bgcolor="white"  width="40"> 
        <input type="TEXT" style="background-color:yellow" size=6 name="HDSCSI2" maxlength="6">
      </td>
    </tr>
    <tr> 
      <td bgcolor="white"  width="535"> 
        <select name="HDSCSI1" onChange="ComputeTotal(this.form)">
          <option value="0">Select a SCSI Hard Drive2 (optional)</option>
          <option value="470000">4 Gig U2 SCSI </option>
          <option value="550000">9 Gig U2 SCSI</option>
          <option value="1030000">18 Gig U2 SCSI</option>
        </select>
      </td>
      <td bgcolor="white"  width="40"> 
        <input type="TEXT" style="background-color:yellow" size=6 name="HDSCSI3" maxlength="6">
      </td>
    </tr>
    <tr> 
      <td bgcolor="white"  width="535"> 
        <select name="Video" onChange="ComputeTotal(this.form)">
          <option value="0">비디오 카드를 선택 하세요</option>
          <option value="110000">3Dfx Voodoo3 2000 AGP2X OEM/Bulk 16MB SDRAM</option>
          <option value="150000">3Dfx Voodoo3 3000 AGP2X OEM/Bulk 16MB SDRAM w/TV Out</option>
          <option value="30000">ATI 3D Charger AGP 4MB EDO RAGE IIC 3D/2D MPEG1</option>
          <option value="175000">ATI All-in-Wonder Pro AGP OEM 3D Rage Pro and ImpacTV2, 8MB</option>
          <option value="40000">ATI XPERT98 8MB AGP2X SDRAM MPEG-2/DVD Bulk OEM</option>
          <option value="160000">ATI RAGE FURY AGP2X 32MB SDRAM MPEG-2/DVD Bulk OEM w/TV Out</option>
          <option value="95000">ATI XPERT128 16MB AGP2X SDRAM MPEG-2/DVD Bulk OEM</option>
          <option value="45000">Diamond SpeedStar A50 AGP2X OEM/Bulk SiS 6326AGP 8MB SDRAM</option>
          <option value="80000">Diamond Viper V550 AGP RIVA TNT 16MB SDRAM OEM/Bulk</option>
          <option value="170000">Diamond Viper V770 AGP4X RIVA TNT2 32MB SDRAM Retail</option>
          <option value="110000">Diamond Monster Fusion AGP OEM/Bulk Voodoo Banshee 16MB SGRAM</option>
          <option value="50000">Jaton Video-97AGP 2X Trident 985 4MB SGRAM</option>
          <option value="100000">Matrox Millennium G200 AGP2X 128-bit DualBus 8M SGRAM OEM</option>
          <option value="190000">Matrox Millennium G400 AGP4X 256-bit 32M SGRAM DualHead Retail</option>
          <option value="170000">Matrox Millennium G400 SH AGP4X 256-bit 32M SGRAM single display OEM</option>
        </select>
      </td>
      <td bgcolor="white"  width="40"> 
        <input type="TEXT" style="background-color:yellow" size=6 name="Video1" maxlength="6">
      </td>
    </tr>
    <tr> 
      <td bgcolor="white"  width="535"> 
        <select name="Monitor" onChange="ComputeTotal(this.form)">
          <option value="0">모니터를 선택 하세요</option>
          <option value="125000">KDS VS-5e 15/13.9 1280 NI .28mm Digital OSD, MPRII, DDC1/2B</option>
          <option value="190000">KDS AV-5T 15/13.9 1280 NI .25mm Sony Trinitron Digital OSD</option>
          <option value="255000">KDS VS-7e 17/15.8 1280 NI .28mm Digital OSD, MPRII, DPMS </option>
          <option value="310000">KDS AV-7T 17/15.9 1280 NI .25mm Sony Trinitron Digital OSD</option>
          <option value="430000">KDS VS19sn 19/18 1600@75Hz .25mm Short Neck Digital OSD</option>
          <option value="600000">Sony GDM-420GS Trinitron 19/18 short-neck .25-.27AG TCO92</option>
          <option value="1530000">Sony GDM-500PS Trinitron 21/19.8 short-neck .25-.27AG TCO95</option>
          <option value="1900000">Sony GDM-F500 FD Trinitron 21/19.8 .22AG USB TCO95</option>
          <option value="2600000">Sony GDM-W900 Wide Trinitron 24/22.5 .25-.28AG TCO95</option>
          <option value="135000">Tatung C5BZR 15 Color Digital SVGA 1280 NI .28mm Green</option>
          <option value="250000">Tatung C7BZR-25 17/15.9 Color 1280@60Hz .25mm Green Digital OSD</option>
          <option value="430000">Tatung C7NZR 19/17.9 Color 1600@75Hz NI .26mm Green Digital OSD</option>
        </select>
      </td>
      <td bgcolor="white"  width="40"> 
        <input type="TEXT" style="background-color:yellow" size=6 name="Monitor1" maxlength="6">
      </td>
    </tr>
    <tr> 
      <td bgcolor="white"  width="535"> 
        <select name="CD" onChange="ComputeTotal(this.form)">
          <option value="0">CD-ROM Drive </option>
          <option value="40000">Toshiba XM-6402B Int 40X-Max CD-ROM 6.0MB/s 80ms 256KB EIDE</option>
          <option value="42000">Acer CD-640A Internal 40X-Max 6.0MB/s 85ms 128KB ATAPI</option>
        </select>
      </td>
      <td bgcolor="white"  width="40"> 
        <input type="TEXT" style="background-color:yellow" size=6 name="CD1" maxlength="6">
      </td>
    </tr>
    <tr> 
      <td bgcolor="white"  width="535"> 
        <select name="DVD" onChange="ComputeTotal(this.form)">
          <option value="00">DVD Drive (옵션)</option>
          <option value="90000">Toshiba DVD 4.8X DVD-ROM 32X CD-ROM</option>
          <option value="100000">Creative PC-DVD 6X DVD-ROM 24X CD-ROM</option>
        </select>
      </td>
      <td bgcolor="white"  width="40"> 
        <input type="TEXT" style="background-color:yellow" size=6 name="DVD1" maxlength="6">
      </td>
    </tr>
    <tr> 
      <td bgcolor="white"  width="535"> 
        <select name="Removable" onChange="ComputeTotal(this.form)">
          <option value="0">Select a Removable Drive (optional)</option>
          <option value="75000">Iomega Zip ATAPI Insider 100MB Internal for PCs 3?EIDE</option>
          <option value="140000">Iomega Zip 100MB External for PCs 3? w/ parallel cable</option>
          <option value="180000">Iomega Zip 100MB Plus External for PCs 3? w/ cable</option>
        </select>
      </td>
      <td bgcolor="white"  width="40"> 
        <input type="TEXT" style="background-color:yellow" size=6 name="Removable1" maxlength="6">
      </td>
    </tr>
    <tr> 
      <td bgcolor="white"  width="535"> 
        <select name="Sound" onChange="ComputeTotal(this.form)">
          <option value="0">사운드 카드</option>
          <option value="56000">Aureal Vortex2 SuperQuad Digital PCI OEM AU8830 A3D2.0 320V +S/PDIF</option>
          <option value="25000">Creative Labs Sound Blaster 16 Wav Effects CT4170 OEM</option>
          <option value="67000">Creative Labs Sound Blaster PCI 128 PnP 128v wave Retail</option>
          <option value="53000">Creative Labs Sound Blaster Live! Value PCI 256v wave Retail</option>
          <option value="170000">Creative Labs Sound Blaster Live! PCI 256v wave Retail</option>
          <option value="95000">Diamond Monster Sound MX300 PCI Aureal A3D2.0 320v Wav. Retail</option>
          <option value="25000">Jaton SonicWave 4D PCI PnP 64-voice wavetable 4D audio</option>
        </select>
      </td>
      <td bgcolor="white"  width="40"> 
        <input type="TEXT" style="background-color:yellow" size=6 name="Sound1" maxlength="6">
      </td>
    </tr>
    <tr> 
      <td bgcolor="white"  width="535"> 
        <select name="Speakers" onChange="ComputeTotal(this.form)">
          <option value="0">스피커</option>
          <option value="10000">MLi-168 5W/ch shielded amp'd spkr pair, AC/DC, bass boost </option>
          <option value="39000">MLi-480 3-piece (2x6W 1x18W) shielded speakers system </option>
          <option value="30000">Midiland Forzando II 14W/ch PMPO:350W 2-way speaker pair </option>
          <option value="130000">S2 / Midiland S2-4030 4-piece shielded speaker system </option>
          <option value="345000">S2 / Midiland S2-4100 4-piece shielded speaker system</option>
          <option value="155000">Altec Lansing ADA305 3-piece Digital PowerCube Surround USB</option>
          <option value="90000">Cambridge Soundworks PC Works 5-Piece FourPointSurround System</option>
        </select>
      </td>
      <td bgcolor="white"  width="40"> 
        <input type="TEXT" style="background-color:yellow" size=6 name="Speakers1" maxlength="6">
      </td>
    </tr>
    <tr> 
      <td bgcolor="white"  width="535"> 
        <select name="Modem" onChange="ComputeTotal(this.form)">
          <option value="0">모뎀</option>
          <option value="35000">Aopen PCI Internal V.90 56K Voice Cirrus chipset</option>
          <option value="139000">Diamond SupraSonic II with Shotgun?technology (Dual 56K)</option>
          <option value="140000">US Robotics Sportster External V.90 56K Faxmodem, x2 technology</option>
          <option value="90000">US Robotics Sportster Internal V.90 56K OEM Faxmodem, x2 technology</option>
          <option value="145000">US Robotics Sportster Voice External V.90 56K Faxmodem Pro, x2 technology</option>
          <option value="99000">US Robotics Sportster Voice Internal V.90 56K OEM Faxmodem, x2 technology</option>
          <option value="75000">US Robotics Sportster Winmodem V.90 56K, internal</option>
        </select>
      </td>
      <td bgcolor="white"  width="40"> 
        <input type="TEXT" style="background-color:yellow" size=6 name="Modem1" maxlength="6">
      </td>
    </tr>
    <tr> 
      <td bgcolor="white"  width="535"> 
        <select name="Network" onChange="ComputeTotal(this.form)">
          <option value="0">랜카드</option>
          <option value="75000">3Com EtherLink XL PCI Combo (3C900B-COMBO) Bulk OEM</option>
          <option value="59000">3Com Fast EtherLink XL TX 10/100 PCI (3C905B-TX) Bulk OEM</option>
          <option value="35000">NC2000 10/100 PCI Ethernet (U1205C)</option>
          <option value="52000">Intel EtherExpress PRO/100+ TX PCI (PILA8460-B) w/ Wake-Up OEM</option>
        </select>
      </td>
      <td bgcolor="white"  width="40"> 
        <input type="TEXT" style="background-color:yellow" size=6 name="Network1" maxlength="6">
      </td>
    </tr>
    <tr> 
      <td bgcolor="white"  width="535"> 
        <select name="Case" onChange="ComputeTotal(this.form)">
          <option value="0">케이스</option>
          <option value="45000">Standard Case</option>
          <option value="65000">Super Middle Tower ATX 5x5?(1Hdn) 3x3?(2 Hdn) 250W ATX UL</option>
          <option value="89000">SuperMicro SC701-A Tower ATX 3x5?5x3?(3 Hdn) 235W PS </option>
          <option value="89000">SuperMicro SC730-A Mid Tower ATX 235W PS 16.5x6.7x15.75</option>
          <option value="150000">SuperMicro SC750-A (ATX) Tower 6x5?300W PS</option>
          <option value="90000">Super Tower ATX 8x5?(2Hdn) 3x3?(2 Hdn) 300W ATX UL</option>
        </select>
      </td>
      <td bgcolor="white"  width="40"> 
        <input type="TEXT" style="background-color:yellow" size=6 name="Case1" maxlength="6">
      </td>
    </tr>
    <tr> 
      <td bgcolor="white"  width="535"> 
        <select name="Mouse" onChange="ComputeTotal(this.form)">
          <option value="0">마우스</option>
          <option value="25000">Logitech First Mouse+ OEM w/ scroll wheel, PS/2</option>
          <option value="45000">Logitech MouseMan OEM 3-button, PS/2 mouse port</option>
          <option value="50000">Logitech USB Wheel Mouse, 3-button w/ scroll wheel</option>
          <option value="45000">Microsoft IntelliMouse Pro serial & PS/2 Retail Box</option>
          <option value="30000">Microsoft OEM Intellimouse PS/2 V1.1A</option>
          <option value="20000">Microsoft PS/2 mouse 2 OEM </option>
          <option value="10000">High-resolution Microsoft compatible serial mouse 
          </option>
        </select>
      </td>
      <td bgcolor="white"  width="40"> 
        <input type="TEXT" style="background-color:yellow" size=6 name="Mouse1" maxlength="6">
      </td>
    </tr>
    <tr> 
      <td bgcolor="white"  width="535"> 
        <select name="Keyboard" onChange="ComputeTotal(this.form)">
          <option value="0">키보드</option>
          <option value="17000">mitsumi Keyboard-52TB 104-key w/Win95 keys, PS/2</option>
          <option value="35000">Microsoft 104 Natural Keyboard Elite OEM</option>
          <option value="29000">Logitech Internet Keyboard 104-key 17 Internet buttons</option>
          <option value="59000">Logitech NewTouch Split Ergo Keyboard with Touchpad</option>
        </select>
      </td>
      <td bgcolor="white"  width="40"> 
        <input type="TEXT" style="background-color:yellow" size=6 name="Keyboard1" maxlength="6">
      </td>
    </tr>
    <tr> 
      <td bgcolor="white"  width="535"> 
        <select name="OS" onChange="ComputeTotal(this.form)">
          <option value="0000">O/S</option>
          <option value="95000">Microsoft OEM Windows 98 CD-ROM</option>
          <option value="120000">Microsoft OEM Windows NT Work Station v4.0 CD-ROM </option>
          <option value="185000">Microsoft OEM Windows NT Server v4.0 CD-ROM </option>
        </select>
      </td>
      <td bgcolor="white"  width="40"> 
        <input type="TEXT" style="background-color:yellow" size=6 name="OS1" maxlength="6">
      </td>
    </tr>
    <tr> 
      <td bgcolor="white"  width="535"> 
        <select name="Software" onChange="ComputeTotal(this.form)">
          <option value="0">Select a Software Package (optional)</option>
          <option value="150000"> Corel Office 2000 </option>
          <option value="199000"> Microsoft Office '97 Professional</option>
        </select>
      </td>
      <td bgcolor="white"  width="40"> 
        <input type="TEXT" style="background-color:yellow" size=6 name="Software1" maxlength="6">
      </td>
    </tr>
    <tr> 
      <td bgcolor="white"  width="535"> 
        <select name="Printer" onChange="ComputeTotal(this.form)">
          <option value="0">프린터</option>
          <option value="310000">Alps MD-1000 1200dpi Photo Printer</option>
          <option value="350000">Alps MD-1300 1200dpi Photo Printer</option>
          <option value="490000">Alps MD-5000 2400dpi Photo Printer</option>
        </select>
      </td>
      <td bgcolor="white"  width="40"> 
        <input type="TEXT" style="background-color:yellow" size=6 name="Printer1" maxlength="6">
      </td>
    </tr>
    <tr> 
      <td bgcolor="white"  width="535"> 
        <select name="Scanner" onChange="ComputeTotal(this.form)">
          <option value="0">스캐너</option>
          <option value="90000">AcerScan 310s (30 bit, 4800dpi)</option>
          <option value="120000">AcerScan 610plus (30 bit, 9600 dpi)</option>
        </select>
      </td>
      <td bgcolor="white"  width="40"> 
        <input type="TEXT" style="background-color:yellow" size=6 name="Scanner1" maxlength="6">
      </td>
    </tr>
    <tr> 
      <td bgcolor="white"  width="535"> 
        <select name="UPS" onChange="ComputeTotal(this.form)">
          <option value="0">UPS</option>
          <option value="200000">APC Back-UPS 500 (500VA/330W) UPS 15/20 Minutes</option>
          <option value="300000">UAPC Back-UPS Pro 350 (350VA/220W) UPS 5/16.5 Minutes (USB Win98 Only)</option>
        </select>
      </td>
      <td bgcolor="white"  width="40"> 
        <input type="TEXT" style="background-color:yellow" size=6 name="UPS1" maxlength="6">
      </td>
    </tr>
    <tr> 
      <td bgcolor="white"  width="535"> 
        <p align="right"> <b>합 계: </b> 
      </td>
      <td bgcolor="white"  width="40"><b> 
        <input type="TEXT" style="background-color:lightblue" size=6 name="subtotal1" maxlength="6">
        </b></td>
    </tr>
<tr><td bgcolor="white"  colspan=2 align=center>
<input type=submit value="                 주문 메일 발송                 "></td></tr>
  </table>
  <p> </p>
  </form>
  
   
  






86    신용카드 유효성 검사  

 
<!-- 1. 메모장 등으로 아래의 내용을 HTML 문서의 HEAD 부분에 붙여 넣으세요 -->
<script = "JavaScript">
<!--
function check_card() {
var cardtype=document.order.cardtype.options[document.order.cardtype.selectedIndex].value;
var cnlen=document.order.ccnum.value.length;
var ccnum=document.order.ccnum.value;
if (cardtype == "") { 
alert('카드 종류를 선택 하세요')
document.order.cardtype.focus();
return;
}
if (cardtype != "") { 
if (document.order.nameoncard.value == "") {
alert('카드 소유자 성명을 적어 주세요')
document.order.nameoncard.focus();
return;
}
if (document.order.cardexp.value == "") {
alert('유효기간을 입력 하세요')
document.order.cardexp.focus();
return;
}
if (isNaN(document.order.cardexp.value)) {
alert('숫자만 입력 가능합니다')
document.order.cardexp.focus();
return;
   }
if (ccnum == "") {
alert('카드번호를 입력 하세요')
document.order.ccnum.focus();
return;
}
if (ccnum.indexOf(" ")!=-1) {
alert('부호를 제외한 숫자만 입력 가능합니다')
document.order.ccnum.focus();
return;
   }
if (ccnum.indexOf("-")!=-1) {
alert('부호를 제외한 숫자만 입력 가능합니다')
document.order.ccnum.focus();
return;
   }
if (isNaN(ccnum)) {
alert('부호를 제외한 숫자만 입력 가능합니다')
document.order.ccnum.focus();
return;
   }
if ((cardtype == "American Express") && !(cnlen==15)) { 
bad_card(cardtype)
return;
  }
if (((cardtype == "MasterCard") || (cardtype == "Discover")) && !(cnlen==16)) { 
bad_card(cardtype)
return;
  }
if ((cardtype == "Visa") && !((cnlen==13) || (cnlen==16))) { 
bad_card(cardtype)
return;
  }
ccdgt = new Array();
for (c = 0; c < cnlen; c++) { 
ccdgt[c] = ccnum.substring(c,c+1);
  }
ccdgta = new Array();
for (c = 0; c < cnlen; c++) { 
ccdgta[c] = ccdgt[c]*2; 
  }
if ((cnlen==13)||(cnlen==15)) {
if (ccdgta[1] >= 10) { 
ccda1=ccdgta[1].toString();
var cc1b = ccda1.substring(0,1);
var cc1c = ccda1.substring(1,2);
var cc1 = parseInt(cc1b)+parseInt(cc1c);
} 
else {
var cc1 = ccdgta[1];
  }
if (ccdgta[3] >= 10) { 
ccda3=ccdgta[3].toString();
var cc3b = ccda3.substring(0,1);
var cc3c = ccda3.substring(1,2);
var cc3 = parseInt(cc3b)+parseInt(cc3c);
} 
else {
var cc3 = ccdgta[3];
  }
if (ccdgta[5] >= 10) { 
ccda5=ccdgta[5].toString();
var cc5b = ccda5.substring(0,1);
var cc5c = ccda5.substring(1,2);
var cc5 = parseInt(cc5b)+parseInt(cc5c);
} 
else {
var cc5 = ccdgta[5];
  }
if (ccdgta[7] >= 10) { 
ccda7=ccdgta[7].toString();
var cc7b = ccda7.substring(0,1);
var cc7c = ccda7.substring(1,2);
var cc7 = parseInt(cc7b)+parseInt(cc7c);
} 
else {
var cc7 = ccdgta[7];
  }
if (ccdgta[9] >= 10) { 
ccda9=ccdgta[9].toString();
var cc9b = ccda9.substring(0,1);
var cc9c = ccda9.substring(1,2);
var cc9 = parseInt(cc9b)+parseInt(cc9c);
} 
else {
var cc9 = ccdgta[9];
  }
if (ccdgta[11] >= 10) { 
ccda11=ccdgta[11].toString();
var cc11b = ccda11.substring(0,1);
var cc11c = ccda11.substring(1,2);
var cc11 = parseInt(cc11b)+parseInt(cc11c);
} 
else {
var cc11 = ccdgta[11];
  }
if (cnlen == 13) { 
ccval = ccdgt[0]+cc1+ccdgt[2]+cc3+ccdgt[4]+cc5+ccdgt[6]+cc7+ccdgt[8]+cc9+ccdgt[10]+cc11+ccdgt[12];
if (ccval != 0) { 
bad_card(cardtype)
return;
  }
else {
alert('13 자리 카드번호는 가능합니다');
document.order.ccnum.focus();
return;
   }
  }
if (ccdgta[13] >= 10) { 
ccda13=ccdgta[13].toString();
var cc13b = ccda13.substring(0,1);
var cc13c = ccda13.substring(1,2);
var cc13 = parseInt(cc13b)+parseInt(cc13c);
} 
else {
var cc13 = ccdgta[13];
  }
if (cnlen == 15) {
var ccval = parseInt(ccdgt[0])+parseInt(cc1)+parseInt(ccdgt[2])+parseInt(cc3)+parseInt(ccdgt[4])+parseInt(cc5)+parseInt(ccdgt[6])+parseInt(cc7)+parseInt(ccdgt[8])+parseInt(cc9)+parseInt(ccdgt[10])+parseInt(cc11)+parseInt(ccdgt[12])+parseInt(cc13)+parseInt(ccdgt[14]);
ccvalstr=ccval.toString();
if (ccvalstr.substring(1,2) !=0) { 
bad_card(cardtype)
return;
   }
  }
}
if (ccdgta[0] >= 10) { 
ccda0=ccdgta[0].toString();
var cc0b = ccda0.substring(0,1);
var cc0c = ccda0.substring(1,2);
var cc0 = parseInt(cc0b)+parseInt(cc0c);
} 
else {
var cc0 = ccdgta[0];
  }
if (ccdgta[2] >= 10) { 
ccda2=ccdgta[2].toString();
var cc2b = ccda2.substring(0,1);
var cc2c = ccda2.substring(1,2);
var cc2 = parseInt(cc2b)+parseInt(cc2c);
} 
else {
var cc2 = ccdgta[2];
  }
if (ccdgta[4] >= 10) { 
ccda4=ccdgta[4].toString();
var cc4b = ccda4.substring(0,1);
var cc4c = ccda4.substring(1,2);
var cc4 = parseInt(cc4b)+parseInt(cc4c);
} 
else {
var cc4 = ccdgta[4];
  }
if (ccdgta[6] >= 10) { 
ccda6=ccdgta[6].toString();
var cc6b = ccda6.substring(0,1);
var cc6c = ccda6.substring(1,2);
var cc6 = parseInt(cc6b)+parseInt(cc6c);
} 
else {
var cc6 = ccdgta[6];
  }
if (ccdgta[8] >= 10) { 
ccda8=ccdgta[8].toString();
var cc8b = ccda8.substring(0,1);
var cc8c = ccda8.substring(1,2);
var cc8 = parseInt(cc8b)+parseInt(cc8c);
} 
else {
var cc8 = ccdgta[8];
  }
if (ccdgta[10] >= 10) { 
ccda10=ccdgta[10].toString();
var cc10b = ccda10.substring(0,1);
var cc10c = ccda10.substring(1,2);
var cc10 = parseInt(cc10b)+parseInt(cc10c);
} 
else {
var cc10 = ccdgta[10];
  }
if (ccdgta[12] >= 10) { 
ccda12=ccdgta[12].toString();
var cc12b = ccda12.substring(0,1);
var cc12c = ccda12.substring(1,2);
var cc12 = parseInt(cc12b)+parseInt(cc12c);
} 
else {
var cc12 = ccdgta[12];
  }
if (ccdgta[14] >= 10) { 
ccda14=ccdgta[14].toString();
var cc14b = ccda14.substring(0,1);
var cc14c = ccda14.substring(1,2);
var cc14 = parseInt(cc14b)+parseInt(cc14c);
} 
else {
var cc14 = ccdgta[14];
  }
var ccval = parseInt(cc0)+parseInt(ccdgt[1])+parseInt(cc2)+parseInt(ccdgt[3])+parseInt(cc4)+parseInt(ccdgt[5])+parseInt(cc6)+parseInt(ccdgt[7])+parseInt(cc8)+parseInt(ccdgt[9])+parseInt(cc10)+parseInt(ccdgt[11])+parseInt(cc12)+parseInt(ccdgt[13])+parseInt(cc14)+parseInt(ccdgt[15]);
ccvalstr=ccval.toString();
if (ccvalstr.substring(1,2) !=0) { 
bad_card(cardtype)
return;
  }
}
alert('유효성 검사가 끝났습니다\n정상적인 카드 입니다')
return;
}
function bad_card(ctype) {
alert('귀하의 카드는 사용할 수 없는 '+ctype+ ' 카드 번호 입니다')
document.order.ccnum.focus();
}
//-->
</script>
</head>
<body>
<!-- 2. 메모장 등으로 아래의 방법으로 HTML 문서의 BODY 부분에 붙여 넣으세요 -->

<CENTER><H3>신용카드 정보를 입력 하세요</H3></CENTER>
<form action="#" name="order">
<TABLE width=400 align=center bgcolor=teal>
<TR>
        <td bgcolor="white"  bgcolor=white>신용카드 종류</TD>
        <td bgcolor="white" > <select name="cardtype">
        <option value="">카드 종류를 선택 하세요</option>
        <option value="Visa">비자카드</option>
        <option value="MasterCard">마스타 카드</option>
        <option value="Discover">Discover</option>
        <option value="American Express">American Express</option>
</select>
</TD>
</TR>
<TR>
        <td bgcolor="white" >소유자 성명</TD>
        <td bgcolor="white" > <input type="text" name="nameoncard" size=25 maxlength=40 value=""></TD>
</TR>
<TR>
        <td bgcolor="white" >유효기간 (월/년)</TD>
        <td bgcolor="white" > <input type="text" name="cardexp" size=4 maxlength=4 value=""> (mmyy 형식으로 입력)</TD>
</TR>
<TR>
        <td bgcolor="white" >신용카드 번호</TD>
        <td bgcolor="white" > <input type="text" name="ccnum" size=25 maxlength=40 value=""></TD>
</TR>
<TR>
        <td bgcolor="white" align=center colspan=2><input type="button" value="  확          인  " onclick="javascript:check_card();"></TD>
</TR>
</TABLE>
</form>
 
 






85    숫자를 입력하면 자동으로 화폐단위를 넣어 줍니다  

 
<!------1. 아래의 코드를 HEAD 부분에 복사해 넣으세요 -------------->
<script>
<!--
// 단위를 넣지 않으려면 '원' 표시를 지우세요
var prefix="원"
var wd
function parseelement(thisone){
if (thisone.value.charAt(0)=="원")
return
wd="w"
var tempnum=thisone.value
for (i=0;i<tempnum.length;i++){
if (tempnum.charAt(i)=="."){
wd="d"
break
}
}
if (tempnum.charAt(tempnum.length-2)=="."){
thisone.value=tempnum+"0" +prefix
}
else{
tempnum=Math.round(tempnum*100)/100
thisone.value=tempnum+prefix
}
}
//-->
</script>
</HEAD>
<BODY>
<CENTER><B>아래 글상자에 숫자를 넣고 바깥쪽을 클릭 하세요</B></CENTER>
<p align=center>
<!------2. 아래의 방식으로 BODY 부분에  붙여 넣으세요 ------------->
금액 : <input type="text" size=10 onBlur="parseelement(this)">
주소 : <input type="text" size=15>

</BODY>
 
 







84    [투표] 이메일로 받아보는 간단한 투표스크립트 

 
<!------1. 아래의 코드를 HEAD 부분에 복사해 넣으세요 -------------->
<script>
<!--
var x
if (document.referrer=="")
x="알려지지 않은 사이트"
else
x=document.referrer
var inform="보내는 장소: "+x+" 사용 환경: "+navigator.appName+" "+navigator.appVersion
//-->
</script>
</HEAD>
<BODY>
<!------2. 아래의 방식으로 BODY 부분에  붙여 넣으세요 ------------->

<table border="0" align=center width="300" bgcolor="#FFCC00">
        <tr>
                <td align="center" valign="top"><font size="3" color=white><B>JASKO Poll</B></font></td>
        </tr>
        
        <tr>
                <td bgColor=white align=center><strong>이 사이트가 마음에 드시나요 ?</strong>
<!---------------------- 수신할 이메일 주소를 적어 주세요 ------------->
                <form action="mailto:help@mybizs.com?subject=나의한표" method="POST" enctype="text/plain" name="poll">
                <table border="0" cellpadding="0" cellspacing="0" width="100%">
                        <tr bgColor=#EEEEEE>
                                <td valign="top" width="80%">  <font size="2">예, 맘에 듭니다</font></td>
                                <td align="right" valign="top" width="20%">
<!---------------- 이곳을 체크하면 [response=예,맘에 듭니다] 라는 메세지가 옵니다--->
                                
                                <input type="radio" checked name="response" value="예,맘에 듭니다">
                                <script>
                                <!--
                                document.write('<input type="hidden" name="info" value='+'"'+inform+'">')
                                //-->
                                </script>
                                </td>
                        </tr>
                        <tr bgColor=#EEEEEE>
                                <td valign="top" width="80%">  <font size="2">아니오, 맘에 듭니다</font></td>
                                <td align="right" valign="top" width="20%">
                                
<!---------------- 이곳을 체크하면 [response=아니오,맘에 듭니다] 라는 메세지가 옵니다--->
                                <input type="radio" name="response" value="아니오,맘에 듭니다"><br>
                                </td>
                        </tr>
                        <tr>
                                <td align="center" colspan=2>
                                <br>
                                <input type="submit" value=" 확인 ">
                                </td>
                        </tr>
                </table>
                </form>
                </td>
        </tr>
</table>
 
 






83    버튼 클릭으로 숫자를 증가/감소 시킵니다

 
<!------- 원하는 위치에 아래의 내용을 복사해 넣으세요 -------->
<center>
<form>
<input type=text name=amount value=500>
<input type=button value="증가" onClick="javascript:this.form.amount.value++;">
<input type=button value="감소" onClick="javascript:this.form.amount.value--;">
</form>
</center>
<!------- 여기까지 ----->.
 
 







82    대문자를 입력하면 소문자로 바꾸어 줍니다

 
<!----- 원하는 위치에 아래와 같이 코드를 붙여 넣으세요 ------->
<form name="capsform">
<input type="text" name="caps" size=40 value="" onChange="javascript:this.value=this.value.toLowerCase();">
<!-- toLowerCase() 는 문자열의 값을 소문자로 바꾸어 줍니다 --->
<!-- 마찬가지로 소문자를 대문자로 바꾸려면 toUpperCase() 를 사용합니다-->
<input type="button" value=" 확인 ">
</form>
<!------------------ 여기까지 -------------->.
 
 






81    다양한 문자입력 금지 스크립트  

 
<!----- 원하는 위치에 아래와 같이 코드를 붙여 넣으세요 ------->
<form onSubmit="return false;">
특수문자 입력을 금지 합니다<br>
(예 ; !@#$%^&* etc)<br>
<textarea rows=2 cols=20 name=comments onKeypress="if ((event.keyCode > 32 && event.keyCode < 48) || (event.keyCode > 57 && event.keyCode < 65) || (event.keyCode > 90 && event.keyCode < 97)) event.returnValue = false;"></textarea>
</TD>
</TR>
<TR>
        <TD>
따옴표 입력을 금지합니다 :<br>
<input type=text name=txtEmail onKeypress="if (event.keyCode==34 || event.keyCode==39) event.returnValue = false;">
</TD>
</TR>
<TR>
        <TD>
숫자만 입력이 가능합니다 :<br>
<input type=text name=txtPostalCode onKeypress="if (event.keyCode < 45 || event.keyCode > 57) event.returnValue = false;">
</form>
<!------------------ 여기까지 -------------->
 
 






80    콤보메뉴에서 오늘 날짜와 연도가 자동으로 선택 되어 집니다 

 
<!----- 1. 아래의 스크립트를 HEAD 부분에 붙여 넣으세요 -------->
<SCRIPT LANGUAGE="JavaScript">
<!-- 
Now = new Date();
NowDay = Now.getDate();
NowMonth = Now.getMonth();
NowYear = Now.getYear();
if (NowYear < 2000) NowYear += 1900; 
function DaysInMonth(WhichMonth, WhichYear)
{
  var DaysInMonth = 31;
  if (WhichMonth == "Apr" || WhichMonth == "Jun" || WhichMonth == "Sep" || WhichMonth == "Nov") DaysInMonth = 30;
  if (WhichMonth == "Feb" && (WhichYear/4) != Math.floor(WhichYear/4))        DaysInMonth = 28;
  if (WhichMonth == "Feb" && (WhichYear/4) == Math.floor(WhichYear/4))        DaysInMonth = 29;
  return DaysInMonth;
}
function ChangeOptionDays(Which)
{
  DaysObject = eval("document.Form1." + Which + "Day");
  MonthObject = eval("document.Form1." + Which + "Month");
  YearObject = eval("document.Form1." + Which + "Year");
  Month = MonthObject[MonthObject.selectedIndex].text;
  Year = YearObject[YearObject.selectedIndex].text;
  DaysForThisSelection = DaysInMonth(Month, Year);
  CurrentDaysInSelection = DaysObject.length;
  if (CurrentDaysInSelection > DaysForThisSelection)
  {
    for (i=0; i<(CurrentDaysInSelection-DaysForThisSelection); i++)
    {
      DaysObject.options[DaysObject.options.length - 1] = null
    }
  }
  if (DaysForThisSelection > CurrentDaysInSelection)
  {
    for (i=0; i<(DaysForThisSelection-CurrentDaysInSelection); i++)
    {
      NewOption = new Option(DaysObject.options.length + 1);
      DaysObject.add(NewOption);
    }
  }
    if (DaysObject.selectedIndex < 0) DaysObject.selectedIndex == 0;
}
function SetToToday(Which)
{
  DaysObject = eval("document.Form1." + Which + "Day");
  MonthObject = eval("document.Form1." + Which + "Month");
  YearObject = eval("document.Form1." + Which + "Year");
  YearObject[0].selected = true;
  MonthObject[NowMonth].selected = true;
  ChangeOptionDays(Which);
  DaysObject[NowDay-1].selected = true;
}
function WriteYearOptions(YearsAhead)
{
  line = "";
  for (i=0; i<YearsAhead; i++)
  {
    line += "<OPTION>";
    line += NowYear + i;
  }
  return line;
}
// -->
</script>

<!------------------ 여기까지 --------------->
</HEAD>
<!----- 2. BODY 태그안에 아래의 이벤트 핸들러를 붙여 넣으세요 -->
<BODY onLoad="SetToToday('FirstSelect');">
<B>오늘 연도와 날짜가 자동으로 선택 됩니다</B>
<!----- 3. 원하는 위치에 아래와 같이 코드를 붙여 넣으세요 ------->
<FORM name="Form1">
<SELECT name="FirstSelectYear" onchange="ChangeOptionDays('FirstSelect')">
        <SCRIPT language="JavaScript">
                document.write(WriteYearOptions(50));
        </SCRIPT>
</SELECT>
<SELECT name="FirstSelectMonth" onchange="ChangeOptionDays('FirstSelect')">
<!------ 필요하면 아래 월 표시를 한글로 바꾸어 주세요 ------->
        <OPTION>Jan
        <OPTION>Feb
        <OPTION>Mar
        <OPTION>Apr
        <OPTION>May
        <OPTION>Jun
        <OPTION>Jul
        <OPTION>Aug
        <OPTION>Sep
        <OPTION>Oct
        <OPTION>Nov
        <OPTION>Dec
</SELECT>
<SELECT name="FirstSelectDay">
        <OPTION>1
        <OPTION>2
        <OPTION>3
        <OPTION>4
        <OPTION>5
        <OPTION>6
        <OPTION>7
        <OPTION>8
        <OPTION>9
        <OPTION>10
        <OPTION>11
        <OPTION>12
        <OPTION>13
        <OPTION>14
        <OPTION>15
        <OPTION>16
        <OPTION>17
        <OPTION>18
        <OPTION>19
        <OPTION>20
        <OPTION>21
        <OPTION>22
        <OPTION>23
        <OPTION>24
        <OPTION>25
        <OPTION>26
        <OPTION>27
        <OPTION>28
        <OPTION>29
        <OPTION>30
        <OPTION>31
</SELECT>
</FORM>

<!------------------ 여기까지 -------------->
 
  






79    날짜입력을 팝업 카렌다에서 선택할수 있습니다  

 
<!------- 1. 아래의 스크립트를 HEAD 부분에 복사해 넣으세요 ----->
<script language="JavaScript" src="pop_calendar.js"></script>
<!------- 여기까지 ----->
</HEAD>
<BODY>
<!------- 2. 원하는 위치에 아래의 내용을 복사해 넣으세요 -------->
<p align=center>
<form name=calform>
날짜입력 <input type=text name="datebox" size=15>
  <a href="javascript:show_calendar('calform.datebox');" onmouseover="window.status='날짜를 선택하세요';return true;" onmouseout="window.status='';return true;">[찾아보기]</a>
</form>
</center>
<!------- 여기까지 ----->
 
 


  





78    간단한, 문자, 숫자 입력 유효성 검사하기  

 
<!----- 1. 아래의 스크립트를 HEAD 부분에 붙여 넣으세요 -------->
<SCRIPT LANGUAGE="JavaScript">
<!-- 
function validate(){
var digits="0123456789"
var temp
if (document.testform.Name.value=="") {
alert("이름을 입력 하세요")
return false
}
if (document.testform.age.value=="") {
alert("숫자만 입력 하세요")
return false
}
for (var i=0;i<document.testform.age.value.length;i++){
temp=document.testform.age.value.substring(i,i+1)
if (digits.indexOf(temp)==-1){
alert("숫자만 입력 하세요")
return false
      }
   }
return true
}
// -->
</SCRIPT>
<!------------------ 여기까지 --------------->
</HEAD>
<BODY>
<p align=center>
<!----- 2. 원하는 위치에 아래와 같이 코드를 붙여 넣으세요 ------->
<FORM name="testform" onSubmit="return validate()">
성명 : <input type="text" size=30 name="Name">
나이 : <input type="text" size=3 name="age">
<input type="submit" value=" 확인 ">
</FORM>
<!------------------ 여기까지 -------------->
 
 






77    텍스트 상자에 인라인 자동완성 효과를 줍니다

 
<!----- 1. 아래의 스크립트를 HEAD 부분에 붙여 넣으세요 -------->
<SCRIPT LANGUAGE="JavaScript">
<!-- 
var listOpt = new Array("", "Hello", "자바스크립트", "소스뱅크", "mybizs.com에 오셨네요", "잘", "계시다 가세요");
var Ex = false;
var Net = false;
var app = navigator.appName.substring(0,1);
if (app == 'N') Net = true; 
else Ex = true;
document.onkeyup = keyUp;
if (Net) document.captureEvents(Event.KEYUP);
function keyUp(ev) {
if (Net) { 
var source = ev.target.name;
if(source) {
if(ev.which == 0 && source == "target_box") cycleUp(source);
   }
}
else if (Ex) {
var source = window.event.srcElement.name;
if(source) {
if(window.event.keyCode == 40 && source  == "target_box") cycleUp(source);
if(window.event.keyCode == 38 && source  == "target_box") cycleDown(source);
      }
   }
}
var arrayIndex = 0;
function cycleUp(source) {
arrayIndex++;
if(arrayIndex > listOpt.length-1) arrayIndex = 0;
var change_box = eval("document.cycleForm." + source);
change_box.value = listOpt[arrayIndex];
}
function cycleDown(source) {
arrayIndex--;
if(arrayIndex < 0) arrayIndex = listOpt.length - 1;
var change_box = eval("document.cycleForm." + source);
change_box.value = listOpt[arrayIndex];
}
// -->
</script>
<!------------------ 여기까지 --------------->
</HEAD>
<BODY>
<CENTER>텍스트 상자에 커서를 두고 키보드의 화살표(↓↑)를 상하로 움직여 보세요</CENTER>
<!----- 2. 원하는 위치에 아래와 같이 코드를 붙여 넣으세요 ------->
<center>
<form name="cycleForm">
<input name="target_box" value="" size="25"><br>
</form>
</center>
<!------------------ 여기까지 -------------->
 
 







76    문자열에 공백이 있으면 + 부호로 이어줍니다  

<!----- 1. 아래의 스크립트를 HEAD 부분에 붙여 넣으세요 -------->
<SCRIPT LANGUAGE="JavaScript">
<!-- 
function convertSpaces(str) {
var out = "", flag = 0;
for (i = 0; i < str.length; i++) {
if (str.charAt(i) != " ") {
out += str.charAt(i);
flag = 0;
}
else {
if(flag == 0) {
out += "+";
flag = 1;
      }
   }
}
return out;
}
// -->
</script>
<!------------------ 여기까지 --------------->
</HEAD>
<BODY>
<P align=center>
입력상자에 공백과 문자열을 입력 한 후 버튼을 클릭 해 보세요
<P align=center>
<!----- 2. 원하는 위치에 아래와 같이 코드를 붙여 넣으세요 ------->

<form>
이름 입력 :  <input name=input type=text size=15 onBlur="this.value = convertSpaces(this.value);">
<input type=button value=" 확인">
</form>
<!------------------ 여기까지 -------------->
 
 






75    친구에게 현재 페이지 추천하기

 
<!----- 1. 아래의 스크립트를 HEAD 부분에 붙여 넣으세요 -------->
<SCRIPT LANGUAGE="JavaScript">
<!-- 
var good;
function checkEmailAddress(field) {
var goodEmail = field.value.match(/\b(^(\S+@).+((\.com)|(\.net)|(\.edu)|(\.mil)|(\.gov)|(\.org)|(\..{2,2}))$)\b/gi);
if (goodEmail) {
good = true;
}
else {
alert('이메일 형식이 아닙니다');
field.focus();
field.select();
good = false;
   }
}
u = window.location;
m = "이 홈페이지를 참고 하세요";
function mailThisUrl() {
good = false
checkEmailAddress(document.eMailer.address);
if (good) {
window.location = "mailto:"+document.eMailer.address.value+"?subject="+m+"&body="+document.title+" "+u;
   }
}
// -->
</script>

<!------------------ 여기까지 --------------->
</HEAD>
<BODY>
<!----- 2. 원하는 위치에 아래와 같이 코드를 붙여 넣으세요 ------->
<p align=center>
<B>친구에게 추천하기</B>
<p align=center>
<form name="eMailer">
친구의 이메일 주소 :
<input type="text" name="address"><br>
<input type="button" value="이문서 주소를 친구에게 보내기" onClick="mailThisUrl();">
</form>
<!------------------ 여기까지 -------------->
 
 






74    하이퍼링크에 새창으로 열기 옵션 넣기

 
<!----- 1. 아래의 스크립트를 HEAD 부분에 붙여 넣으세요 -------->
<SCRIPT LANGUAGE="JavaScript">
<!-- 
function hyperlinks(target)
{
  if (target) where = "_blank";
  else where = "_self";
  for (var i=0; i<=(document.links.length-1); i++)
  {
  document.links[i].target = where;
  }
}
// -->
</script>
<!------------------ 여기까지 --------------->
</HEAD>
<BODY>
<p align="center">
          <form>
<TABLE width=200 height=150 align=center border=1>
<TR>
        <TD>
           <a href="http://www.yahoo.co.kr/">야후! 코리아</a><br>
           <a href="http://www.daum.net">한메일.넷</a><br>
           <a href="http://dreamwiz.com/">드림위즈</a><br><br>
<!----- 2. 원하는 위치에 아래와 같이 코드를 붙여 넣으세요 ------->
        <input type="checkbox" name="targetnew" onclick="hyperlinks(this.checked)"> 새창에서 링크열기
<!------------------ 여기까지 -------------->
        </TD>
</TR>
</TABLE>
        </form>
 
 


  






73    품목별 주문수량을 입력받아 총금액 보여주기

 
<!----- 1. 아래의 스크립트를 HEAD 부분에 붙여 넣으세요 -------->
<SCRIPT LANGUAGE="JavaScript">
<!-- 
function checkChoice(whichbox) {
with (whichbox.form) {
if (isNaN(whichbox.value)) { 
whichbox.value = whichbox.priorval;
whichbox.focus();
}
whichbox.value = Math.abs(whichbox.value);
var dec = whichbox.value.indexOf('.', 1)
if (dec > 0) { 
alert('No decimal places allowed for \"' +whichbox.name +'\" !');
whichbox.value = whichbox.priorval;
whichbox.focus();
}
hiddentotal.value = eval(hiddentotal.value) - eval(whichbox.price * whichbox.priorval);
whichbox.priorval = whichbox.value;
hiddentotal.value = eval(hiddentotal.value) + eval(whichbox.price * whichbox.value);
return(formatCurrency(hiddentotal.value));
   }
}
function formatCurrency(num) {
num = num.toString().replace(/\$|\,/g,'');
if(isNaN(num)) num = "0";
cents = Math.floor((num * 100 + 0.5) % 100);
num = Math.floor((num * 100 + 0.5) / 100).toString();
if(cents < 10) cents = "0" + cents;
for (var i = 0; i < Math.floor((num.length - (1 + i)) / 3); i++)
num = num.substring(0,num.length - (4 * i + 3))+','+num.substring(num.length-(4 * i + 3));
return (num + " 원");
}
function InitForm() {
document.myform.total.value = '0 원';
document.myform.hiddentotal.value = 0;
for (xx = 0; xx < document.myform.elements.length; xx++) {
if (document.myform.elements[xx].type == 'text') { 
document.myform.elements[xx].value = 0;
   }
}
/*
for (xx=0; xx < document.myform2.elements.length; xx++) {
if (document.myform2.elements[xx].type == 'text') {
document.myform2.elements[xx].value = 0;
      }
   }
*/
}
// -->
</script>
<!------------------ 여기까지 --------------->
</HEAD>
<!----- 2. BODY 태그안에 아래의 이벤트 핸들러를 붙여 넣으세요 -->
<BODY onLoad="InitForm()">

<!----- 3. 원하는 위치에 아래와 같이 코드를 붙여 넣으세요 ------->
<form name=myform>

<TABLE align=center width=400 border=0 bgColor=#FFCC00 cellspacing=1 cellpadding=5>
<TR height=30>
        <TD align=center colspan=2><font color=white size=3 face=바탕><B>메 뉴 판</B></font></TD>
</TR>
<TR bgColor=lightyellow>
        <TD><B>메뉴 명</B></TD>
        <TD><B>수량 입력</B></TD>
</TR>
<TR bgColor=white>
        <TD>안심스테이크    25,000원</TD>
        <TD><input type=text name=Steak   size=3 value=0 priorval=0 price="25000" onChange="this.form.total.value=checkChoice(this);">개</TD>
</TR>
<TR bgColor=white>
        <TD>켄터키 후라디드 치킨  9,000원</TD>
        <TD><input type=text name=Chicken size=3 value=0 priorval=0 price="9000" onChange="this.form.total.value=checkChoice(this);">개</TD>
</TR>
<TR bgColor=white>
        <TD>삼계탕    5,000원</TD>
        <TD><input type=text name=sam   size=3 value=0 priorval=0 price="5000" onChange="this.form.total.value=checkChoice(this);">개</TD>
</TR>
<TR bgColor=lightyellow>
        <TD><B>주문 총액</B></TD>
        <TD>
        <input type="text" name="total" value="" size=15 readonly style="text-align:center;background-color:lightblue">
        <input type=hidden name=hiddentotal value=0></TD>
</TR>
</TABLE>
</form>

<!------------------ 여기까지 -------------->
 
 






72    라디오버튼 클릭으로 주문한 메뉴 합계금액 보여주기 

 
<!----- 1. 아래의 스크립트를 HEAD 부분에 붙여 넣으세요 -------->
<SCRIPT LANGUAGE="JavaScript">
<!--
function CheckChoice(whichbox) {
with (whichbox.form) {
if (whichbox.type == "radio") {
hiddentotal.value = eval(hiddentotal.value) - eval(hiddenpriorradio.value);
hiddenpriorradio.value = eval(whichbox.price);
hiddentotal.value = eval(hiddentotal.value) + eval(whichbox.price);
}
else {
if (whichbox.checked == false) {
hiddentotal.value = eval(hiddentotal.value) - eval(whichbox.value);
}
else {
hiddentotal.value = eval(hiddentotal.value) + eval(whichbox.value);
   }
}
if (hiddentotal.value < 0) {
InitForm();
}
return(formatCurrency(hiddentotal.value));
   }
}
function formatCurrency(num) {
num = num.toString().replace(/\$|\,/g,'');
if(isNaN(num)) num = "0";
cents = Math.floor((num*100+0.5)%100);
num = Math.floor((num*100+0.5)/100).toString();
if(cents < 10) cents = "0" + cents;
for (var i = 0; i < Math.floor((num.length-(1+i))/3); i++)
num = num.substring(0,num.length-(4*i+3))+','+num.substring(num.length-(4*i+3));
return (num + "원");
}
function InitForm() {
document.myform.total.value='0원';
document.myform.hiddentotal.value=0;
document.myform.hiddenpriorradio.value=0;
/* 항목을 추가하려면 아래의 방식으로 추가 할 수 있습니다
document.myform2.total.value='0원';
document.myform2.hiddentotal.value=0;
document.myform2.hiddenpriorradio.value=0;
document.myform2.hiddenpriorradio.value=0;
*/
for (xx=0; xx < document.myform.elements.length; xx++) {
if (document.myform.elements[xx].type == 'checkbox' | document.myform.elements[xx].type == 'radio') {
document.myform.elements[xx].checked = false;
   }
}
/*
for (xx=0; xx < document.myform2.elements.length; xx++) {
if (document.myform2.elements[xx].type == 'checkbox' | document.myform2.elements[xx].type == 'radio') {
document.myform2.elements[xx].checked = false;
      }
   }
*/
}
//-->
</script>
<!------------------ 여기까지 --------------->
</HEAD>
<!----- 2. BODY 태그안에 아래의 이벤트 핸들러를 붙여 넣으세요 -->
<BODY onLoad="InitForm();" onreset="InitForm();">
<!----- 3. 원하는 위치에 아래와 같이 코드를 붙여 넣으세요 ------->
<p><B>메뉴를 선택 해 주세요</B>
<p>
<form method=POST name=myform>
스테이크 20,000원
<input type=checkbox name=Steak value=20000 onClick="this.form.total.value=CheckChoice(this);">
치킨 9,000원
<input type=checkbox name=Chicken value=9000 onClick="this.form.total.value=CheckChoice(this);">
돈까스 5,000원
<input type=checkbox name=don value=5000 onClick="this.form.total.value=CheckChoice(this);">
<br>
<br>
<hr>
<p>
<b>디저트를 신청 하세요 (한가지만 신청 가능합니다)</b>
<p>
아니요, 됐습니다
<input type=radio name=Sauce value=none price=0 onClick="this.form.total.value=CheckChoice(this);">
콜라 2,000원
<input type=radio name=Sauce value=coke price=2000 onClick="this.form.total.value=CheckChoice(this);">
주스 5,000원
<input type=radio name=Sauce value=juice price=5000 onClick="this.form.total.value=CheckChoice(this);">
아이스크림 3,000원
<input type=radio name=Sauce value=icecream price=3000 onClick="this.form.total.value=CheckChoice(this);">
<br>
<br>
<hr>
<p>
<input type=hidden name=hiddentotal value=0>
<input type=hidden name=hiddenpriorradio value=0>
총 금액은 : <input type=text name=total readonly> 입니다
</font>
</form>
<!------------------ 여기까지 -------------->
 
 


  






71    2개의 콤보메뉴에서 동일내용은 선택을 할 수 없습니다  

 
<!----- 1. 아래의 스크립트를 HEAD 부분에 붙여 넣으세요 -------->
<SCRIPT LANGUAGE="JavaScript">
<!-- 
var OptLstTxt = new Array;
var OptLstVal = new Array;
var OptLen = 0;
function NoDupl(SelObjFrom, SelObjTo) {
var OldToVal = SelObjTo.options[SelObjTo.selectedIndex].value;
if (OptLen == 0) {
OptLen = SelObjFrom.length;
for (var i = 1; i < OptLen; i++) {
OptLstTxt[i] = SelObjFrom.options[i].text;
OptLstVal[i] = SelObjFrom.options[i].value;
   }
}
var j = 1;
for (var i = 1; i < OptLen; i++) {
if (OptLstVal[i] != SelObjFrom.options[SelObjFrom.selectedIndex].value) {
if (j == SelObjTo.length) {
SelObjTo.options[j] = new Option(OptLstTxt[i]);
}
else {
SelObjTo.options[j].text = OptLstTxt[i];
}
SelObjTo.options[j].value = OptLstVal[i];
if (OptLstVal[i] == OldToVal) {
SelObjTo.selectedIndex = j;
}
j++;
   }
}
if (SelObjTo.length > j)
SelObjTo.options[(SelObjTo.length - 1)] = null;
}
// -->
</script>
<!------------------ 여기까지 --------------->
</HEAD>
<BODY>
<!----- 2. 원하는 위치에 아래와 같이 코드를 붙여 넣으세요 ------->
<form method="POST" name="MForm">
같은 색상을 선택 해 보세요 :
<br><br>
<select name="Color_1" onChange="NoDupl(this,document.MForm.Color_2)">
<option selected value=''>첫번째 색상을 선택하세요</option>
<option value='R'>빨강색</option>
<option value='J'>노랑색</option>
<option value='G'>녹색</option>
<option value='B'>파랑색</option>
</select>
<select name="Color_2" onChange="NoDupl(this,document.MForm.Color_1)">
<option selected value=''>두번째 색상을 선택하세요</option>
<option value='R'>빨강색</option>
<option value='J'>노랑색</option>
<option value='G'>녹색</option>
<option value='B'>파랑색</option>
</select>
</form>

<!------------------ 여기까지 -------------->
 
 






70    태그 입력 금지시키기  

<!----- 1. 아래의 스크립트를 HEAD 부분에 붙여 넣으세요 -------->
<SCRIPT LANGUAGE="JavaScript">
<!-- 
function Del(Word) {
a = Word.indexOf("<");
b = Word.indexOf(">");
len = Word.length;
c = Word.substring(0, a);
if(b == -1)
b = a;
d = Word.substring((b + 1), len);
Word = c + d;
tagCheck = Word.indexOf("<");
if(tagCheck != -1)
Word = Del(Word);
return Word;
}
function Check() {
ToCheck = document.form.text.value;
Checked = Del(ToCheck);
document.form.text.value = Checked;
return true;
}
// -->
</SCRIPT>
<!------------------ 여기까지 --------------->
</HEAD>
<BODY>
<P align=center><B>태그입력은 금지되어 있습니다</B>
<P align=center>
<!----- 2. 원하는 위치에 아래와 같이 코드를 붙여 넣으세요 ------->
<form action="../submit.html" name=form onSubmit="return Check()">
<textarea cols="50" rows="6" name="text"></textarea>
<br>
<input type="submit" value=" 확인 ">
</form>

<!------------------ 여기까지 --------------> 
 






69    폼메일 - 미리 지정된 사람에게 메일을 보냅니다 

 
<SCRIPT LANGUAGE="JavaScript">
function msg() {
document.mailer.action = "mailto:" 
mailtoandsubject = ((document.mailer.mailtoperson.options[document.mailer.mailtoperson.selectedIndex].value) + '?subject=' + document.mailer.subject.value); 
} 
</SCRIPT> 
</HEAD>
<BODY>
<!----- 원하는 위치에 아래와 같이 코드를 붙여 넣으세요 ------->
<FORM NAME="mailer" METHOD="post" ACTION="" ENCTYPE="text/plain" onSubmit="(document.mailer.action += mailtoandsubject)"> 
<TABLE BORDER=0 bgColor=gray cellspacing=1 cellpadding=5 width=500 align=center>
        <TR VALIGN="top">
                <TD align=right bgColor=#F5F5F5 width=100>받는사람  </TD>
                <TD bgColor=white><SELECT NAME="mailtoperson" onChange="msg(this.form)">
                <OPTION VALUE="">-- 받을사람 --
                <OPTION VALUE="help1@mybizs.com">기술 팀장
                <OPTION VALUE="help2@mybizs.com">디자인팀장
                <OPTION VALUE="help3@mybizs.com">마케팅팀장
                </SELECT></TD>
        </TR>
        <TR VALIGN="top">
                <TD  align=right bgColor=#F5F5F5>성명  </TD>
                <TD bgColor=white><INPUT TYPE="text" SIZE=45 NAME="name" onChange="msg(this.form)"></TD>
        </TR>
        <TR VALIGN="top">
                <TD  align=right bgColor=#F5F5F5>Email  </TD>
                <TD bgColor=white><INPUT TYPE="text" SIZE=45 NAME="email" onChange="msg(this.form)"></TD>
        </TR>
        <TR VALIGN="top">
                <TD  align=right bgColor=#F5F5F5>옵션  </TD>
                <TD bgColor=white>
                <SELECT NAME="priority" onChange="msg(this.form)">
                <OPTION VALUE="Normal">보통
                <OPTION VALUE="Urgent">긴급
                <OPTION VALUE="No Reply Needed">답장필요 없슴
                </SELECT></TD>
        </TR>
        <TR VALIGN="top">
                <TD  align=right bgColor=#F5F5F5>제목  </TD>
                <TD bgColor=white><INPUT TYPE="text" SIZE=45 NAME="subject" onChange="msg(this.form)"></TD>
        </TR>
        <TR VALIGN="top">
                <TD  align=right bgColor=#F5F5F5>내용  </TD>
                <TD bgColor=white><TEXTAREA NAME="message" COLS=45 ROWS=5 WRAP="virtual" OnChange="msg(this.form)"></TEXTAREA></TD>
        </TR>
        <TR>
                <TD  bgColor=#F5F5F5 colspan=2 bgColor=white align=center>
                <INPUT TYPE="submit" VALUE=" 보내기 ">
                <INPUT TYPE="reset" VALUE=" 재작성 "></TD>
        </TR>
</TABLE>
</FORM>
<!------------------ 여기까지 -------------->
 
 





68    이전필드의 입력값을 메모리 형태로 가져 옵니다

 
<!----- 원하는 위치에 아래와 같이 코드를 붙여 넣으세요 ------->
<form name=form1>
<TABLE width=300 align=center bgColor=#FFCC00 cellspacing=1 cellpadding=5>
<TR>
        <TD align=right bgColor=lightyellow><B>텍스트 입력</B> </TD>
        <TD bgColor=lightyellow><input type=text name=textvalue size=25></TD>
</TR>
<TR>
        <TD align=right bgColor=lightyellow>첫번째 메모리 </TD>
        <TD bgColor=white><input type=text name=mem1 size=25 onFocus="if (this.value == ''){this.value=(textvalue.value)}"></TD>
</TR>
<TR>
        <TD align=right bgColor=lightyellow>두번째 메모리 </TD>
        <TD bgColor=white><input type=text name=mem2 size=25 onFocus="if (this.value == ''){this.value=(textvalue.value)}"></TD>
</TR>
<TR>
        <TD align=right bgColor=lightyellow>세번째 메모리 </TD>
        <TD bgColor=white><input type=text name=mem3 size=25 onFocus="if (this.value == ''){this.value=(mem1.value + ' ' + textvalue.value)}"></TD>
</TR>
<TR>
        <TD  align=center colspan=2 bgColor=lightyellow><input type=reset value=" 재작성 " name="B2"></TD>
</TR>
</TABLE>
</form>
<!------------------ 여기까지 -------------->
 
 






67    자바스크립트 메일리스트  

<!----- 1. 아래의 스크립트를 HEAD 부분에 붙여 넣으세요 -------->
<SCRIPT LANGUAGE="JavaScript">
<!--  
function resetform() {
document.forms[0].elements[1]=="";
}
function submitForms() {
if (isEmail() && isFname() && isPhone()) 
// 이메일, 성명, 전화번호 항목 체크
// 각 항목을 필수항목으로 만드려면 아래 함수들을 여기에 추가합니다
if (confirm("메일리스트에 가입하시겠습니까?"))
{
alert("메일링 가입신청서를 전송하겠습니다.\n\n감사합니다");
return true;
}
else
{
alert("다음에는 꼭 가입 해 주세요");
return false
}
else 
return false;
}
// 이메일 항목 입력 체크
function isEmail() {
if (document.forms[0].elements[1].value == "") {
alert ("E-Mail 을 적어주세요")
document.forms[0].elements[1].focus();
return false;
}
if (document.forms[0].elements[1].value.indexOf ('@',0) == -1 ||
document.forms[0].elements[1].value.indexOf ('.',0) == -1) {
alert ("이메일 주소가 잘못되었습니다")
document.forms[0].elements[1].select();
document.forms[0].elements[1].focus();
return false;
}
return true;
}
// 성명 항목 입력 체크
function isFname() {
if (document.forms[0].elements[2].value == "")
{
alert ("이름을 적어 주세요")
document.forms[0].elements[2].focus();
return false;
}
return true;
}
function isLname() {
if (document.forms[0].elements[3].value == "") {
alert ("별명을 적어주세요")
document.forms[0].elements[3].focus();
return false;
}
return true;
}
// 주소 항목 입력 체크
function isAddress() {
if (document.forms[0].elements[4].value == "") {
alert ("주소를 적어 주세요")
document.forms[0].elements[4].focus();
return false;
}
return true;
}
// 전화번호 항목 입력 체크
function isTel1()
{
if (document.forms[0].elements[5].value == "")
{
alert ("전화번호를 적어 주세요")
document.forms[0].elements[5].focus();
return false;
}
return true;
}
// 휴대폰 항목 입력 체크
function isPhone() {
if (document.forms[0].elements[6].value == "") {
alert ("휴대폰 번호를 적어주세요")
document.forms[0].elements[6].focus();
return false;
}
return true;
}
// 홈페이지 항목 입력 체크
function isHomePage() {
if (document.forms[0].elements[7].value == "") {
alert ("홈페이지가 빠졌네요")
document.forms[0].elements[7].focus();
return false;
}
return true;
}
// -->
</SCRIPT>
<!------------------ 여기까지 --------------->
</HEAD>
<BODY>
<!----- 2. 원하는 위치에 아래와 같이 코드를 붙여 넣으세요 ------->
<CENTER>
<FORM enctype="text/plain" name="addform" method='post'
action="mailto:mybizs@orgio.net=메일링신청" onSubmit="return submitForms()">
<!--- 실제 사용시 위의 이메일 주소를 여러분의 주소로 바꾸어 사용하세요 -->
<input type="hidden" name="Form" value="Mail List">
<TABLE border=0 cellspacing=1 cellpadding=5 bgcolor="teal">
        <TR>
        <TD align=center colspan=2><font size=3 color=white><b>Jasko Mail List</b></font></TD>
        </TR>
        <TR>
        <TD bgColor=lightblue>Email 주소:</TD>
        <TD bgColor=white><input type=text name="Email" size=30,1 maxlength=80> ※ 필수항목</TD>
        </TR>
        <TR>
        <TD bgColor=lightblue>성명:</TD>
        <TD bgColor=white><input type=text name="Name" size=20,1 maxlength=80> ※ 필수항목</TD>
        </TR>
        
        <TR>
        <TD bgColor=lightblue>닉네임:</TD>
        <TD bgColor=white><input type=text name="NickName" size=20,1 maxlength=80></TD>
        </TR>
        
        <TR>
        <TD bgColor=lightblue>주소:</TD>
        <TD bgColor=white><input type=text name="Address" size=35,1 maxlength=80>        </TD>
        </TR>
        
        <TR>
        <TD bgColor=lightblue>전화번호:</TD>
        <TD bgColor=white><input type=text name="Telephone" size=30,1 maxlength=80> ※ 필수항목</TD>
        </TR>
        
        <TR>
        <TD bgColor=lightblue>휴대폰:</TD>
        <TD bgColor=white><input type=text name="CellulaPhone" size=30,1 maxlength=25></TD>
        </TR>
        
        <TR>
        <TD bgColor=lightblue>홈페이지:</TD>
        <TD bgColor=white><input type=text name="HomePage" size=35,1 maxlength=35></TD>
        </TR>
        <TR>
        <TD align=center colspan=2><input type="submit" value="  신청하기  ">
        <input type="button" value="  홈으로  " onclick="window.location='http://www.mybizs.com">
        <input type="reset" value=" 재작성 " onclick=resetform()>
        </TD>
        </TR>

</TABLE>
</FORM>
</CENTER>
<!------------------ 여기까지 -------------->
 
 






66    사용자가 리스트 박스 항목 추가/삭제 하기 

 
<!----- 1. 아래의 스크립트를 HEAD 부분에 붙여 넣으세요 -------->
<SCRIPT LANGUAGE="JavaScript">
<!-- 
function move(fbox,tbox) {
var i = 0;
if(fbox.value != "") {
var no = new Option();
no.value = fbox.value;
no.text = fbox.value;
tbox.options[tbox.options.length] = no;
fbox.value = "";
   }
}
function remove(box) {
for(var i=0; i<box.options.length; i++) {
if(box.options[i].selected && box.options[i] != "") {
box.options[i].value = "";
box.options[i].text = "";
   }
}
BumpUp(box);
} 
function BumpUp(abox) {
for(var i = 0; i < abox.options.length; i++) {
if(abox.options[i].value == "")  {
for(var j = i; j < abox.options.length - 1; j++)  {
abox.options[j].value = abox.options[j + 1].value;
abox.options[j].text = abox.options[j + 1].text;
}
var ln = i;
break;
   }
}
if(ln < abox.options.length)  {
abox.options.length -= 1;
BumpUp(abox);
   }
}
function Moveup(dbox) {
for(var i = 0; i < dbox.options.length; i++) {
if (dbox.options[i].selected && dbox.options[i] != "" && dbox.options[i] != dbox.options[0]) {
var tmpval = dbox.options[i].value;
var tmpval2 = dbox.options[i].text;
dbox.options[i].value = dbox.options[i - 1].value;
dbox.options[i].text = dbox.options[i - 1].text
dbox.options[i-1].value = tmpval;
dbox.options[i-1].text = tmpval2;
      }
   }
}
function Movedown(ebox) {
for(var i = 0; i < ebox.options.length; i++) {
if (ebox.options[i].selected && ebox.options[i] != "" && ebox.options[i+1] != ebox.options[ebox.options.length]) {
var tmpval = ebox.options[i].value;
var tmpval2 = ebox.options[i].text;
ebox.options[i].value = ebox.options[i+1].value;
ebox.options[i].text = ebox.options[i+1].text
ebox.options[i+1].value = tmpval;
ebox.options[i+1].text = tmpval2;
      }
   }
}
//-->
</script>
<!------------------ 여기까지 --------------->
</HEAD>
<BODY>
<!----- 2. 원하는 위치에 아래와 같이 코드를 붙여 넣으세요 ------->
<form ACTION="" METHOD="POST">
<table bgColor=teal width=400 align=center cellspacing=1 cellpadding=10>
        <tr bgColor=white>
                <td align=center>
                추가할 항목을 적어 주세요<br>
                <input type="text" name="list1" value="">
                </td>
                <td align=right>
                <input type="button" value="추가" onclick="move(this.form.list1,this.form.list2)" name="B1"><br>
                <input type="button" value="삭제" onclick="remove(this.form.list2)" name="B2"><br><br>
                <input type="button" value="위로" onclick="Moveup(this.form.list2)" name="B3"><br>
                <input type="button" value="아래로" onclick="Movedown(this.form.list2)" name="B4">
                </td>
                
                <td>
                <select multiple size=7 name="list2">
                <option value="one">첫번째항목</option>
                <option value="two">두번째항목</option>
                <option value="three">세번째 항목</option>
                <option value="four">네번째 항목</option>
                <option value="five">다섯번째 항목</option>
                <option value="six">여섯번째 항목</option>
                </select>
                </td>
        </tr>
</table>
</form>
<!------------------ 여기까지 -------------->
 
 






65    지정된 글자수만큼만 입력가능하게 하고, 남은 글자수를 실시간으로 보여줍니다 

 
<!----- 1. 아래의 스크립트를 HEAD 부분에 붙여 넣으세요 -------->
<SCRIPT LANGUAGE="JavaScript">
<!-- 
function textCounter(field, countfield, maxlimit) {
if (field.value.length > maxlimit) 
field.value = field.value.substring(0, maxlimit);
else 
countfield.value = maxlimit - field.value.length;
}
// -->
</script>
<!------------------ 여기까지 --------------->
</HEAD>
<BODY>
<!----- 2. 원하는 위치에 아래와 같이 코드를 붙여 넣으세요 ------->
<center>
<form name=myform action="../submit.html">

<p align=center><B>125 자 이내로 적어 주세요</B>
<p align=cneter>
<textarea name=message wrap=physical cols=28 rows=4 onKeyDown="textCounter(this.form.message,this.form.remLen,125);" onKeyUp="textCounter(this.form.message,this.form.remLen,125);"></textarea>
<!--- 위에서 숫자 125 가 지정된 최대글자 수 입니다 --->
<br>
<input readonly type=text name=remLen size=3 maxlength=3 value="125"> 글자가 남았습니다</font>
</form>

<!------------------ 여기까지 -------------->
 
 






64    사용자가 목록 추가하기

 
<!-----  원하는 위치에 아래와 같이 코드를 붙여 넣으세요 ------->
<CENTER>
<FORM name="history">
<INPUT name="command" type="text" value="">
<INPUT type="button" value="추가하기" onclick="f_store(document.history.command.value)">
<INPUT name="history" type="button" value="추가된 목록 보기" onclick="f_print()">
</FORM>
<P>
<SCRIPT language="JavaScript">
<!-- hide it ...
function MakeArray( n ) {
if( n <= 0 ) {
this.length = 0;
return this;
}
this.length = n;
for( var i = 1; i <= n; i++ ) {
this[ i ] = 0;
}
return this;
}
var history = new MakeArray( 15 );
var index = 0;
var cmmnd = 1;
function f_store( sTR ) {
var i;
if( index >= history.length ) {
for( i = 1; i < history.length; i++ )
history[i-1] = history[i];
index = history.length - 1;
}
history[ index ] = cmmnd + ":" + sTR;
++cmmnd;
++index;
document.history.command.value="";
}
function f_print() {
var allCmmnds, i;
allCmmnds = "";
for( i = 0; i < index; i++ )
allCmmnds += history[i] + "\n";
alert( allCmmnds );
//allCmmnds += history[i] + "<br>";
//document.write(allCmmnds);
}
// -->
</SCRIPT>
<!------------------ 여기까지 -------------->
 
 


  




63    사용자가 자신의 PC 파일을 열어 직접 실행 시킬 수 있습니다  

<!----- 1. 아래의 스크립트를 HEAD 부분에 붙여 넣으세요 -------->
<SCRIPT LANGUAGE="JavaScript">
<!-- 
function whatFile() {
window.location= 'file:///' + document.form1.cmuds.value;
}
// -->
</script>
<!------------------ 여기까지 --------------->
</HEAD>
<BODY>
<!----- 2. 원하는 위치에 아래와 같이 코드를 붙여 넣으세요 ------->
<form name=form1>
<input type=file name="cmuds">
<input type=button onClick="whatFile()" value=" 파일 실행하기 ">
</form>

<!------------------ 여기까지 -------------->






 

62    텍스트영역에서 이메일 주소만 추출 합니다  

 
<!----- 1. 아래의 스크립트를 HEAD 부분에 붙여 넣으세요 -------->
<SCRIPT LANGUAGE="JavaScript">
<!-- 
function findEmailAddresses(StrObj) {
var separateEmailsBy = ", ";
var email = "<없습니다>"; 
var emailsArray = StrObj.match(/([a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\.[a-zA-Z0-9._-]+)/gi);
if (emailsArray) {
email = "";
for (var i = 0; i < emailsArray.length; i++) {
if (i != 0) email += separateEmailsBy;
email += emailsArray[i];
      }
   }
return email;
}
// -->
</script>
<!------------------ 여기까지 --------------->
</HEAD>
<BODY>
<!----- 2. 원하는 위치에 아래와 같이 코드를 붙여 넣으세요 ------->
<center>
아래 텍스트영역에 일반 텍스트와 이메일 주소들을 넣고 바깥쪽을 클릭 해 보세요
<form>
<textarea name=comments rows=10 cols=50 onBlur="this.form.email.value=findEmailAddresses(this.value);"></textarea>
<br>
Email 주소 확인:  <input type=text name=email size=35>
</form>
</center>
<!------------------ 여기까지 -------------->
 
 





  

 

61    submit 버튼을 두번 클릭하지 못하게 비활성화 시킵니다  

 
<!----- 1. 아래의 스크립트를 HEAD 부분에 붙여 넣으세요 -------->
<SCRIPT LANGUAGE="JavaScript">
<!-- 
function disableForm(theform) {
if (document.all || document.getElementById) {
for (i = 0; i < theform.length; i++) {
var tempobj = theform.elements[i];
if (tempobj.type.toLowerCase() == "submit" || tempobj.type.toLowerCase() == "reset")
tempobj.disabled = true;
}
return false; // 실제 사용시는 return true 로 설정 하세요
// return true;
}
else {
alert("폼이 전송되고 버튼이 비활성화 되었습니다.\n이 스크립트는 IE4.x 이상, 네츠케이프 6.x 이상에서만 작동합니다");
return false;
   }
}
//-->
</script>
 
<!------------------ 여기까지 --------------->
</HEAD>
<BODY>
<!----- 3. 원하는 위치에 아래와 같이 코드를 붙여 넣으세요 ------->
<center>
<form onSubmit="return disableForm(this);" method=post action='../submit.html'>
이름을 입력 한 후 전송 버튼을 클릭 하세요 :<br>
<input type=text name=person>
<input type=submit><input type=reset>
</form>
</center>
<!------------------ 여기까지 -------------->
 
 


  






60    소숫점 2자리까지만 입력이 가능합니다 

<!----- 1. 아래의 스크립트를 HEAD 부분에 붙여 넣으세요 -------->
<SCRIPT LANGUAGE="JavaScript">
<!-- 
function checkDecimals(fieldName, fieldValue) {
decallowed = 2;  // 허용할 소숫점 자리수 설정
if (isNaN(fieldValue) || fieldValue == "") {
alert("숫자만 넣어 주세요");
fieldName.select();
fieldName.focus();
}
else {
if (fieldValue.indexOf('.') == -1) fieldValue += ".";
dectext = fieldValue.substring(fieldValue.indexOf('.')+1, fieldValue.length);
if (dectext.length > decallowed)
{
alert ("소수점은 " + decallowed + " 자리 까지만 입력 가능합니다.");
fieldName.select();
fieldName.focus();
      }
else {
alert ("잘 입력 하셨네요");
// return true
      }
   }
}
// -->
</script>
<!------------------ 여기까지 --------------->
</HEAD>
<BODY>
<!----- 2. 원하는 위치에 아래와 같이 코드를 붙여 넣으세요 ------->
<center>
<form>
소숫점 2자리가지 숫자만 입력 가능합니다  <br>
<input type=text name=numbox>
<input type=button name=ok value=" 보내기 " onClick="checkDecimals(this.form.numbox, this.form.numbox.value)">
</form>
</center>
<!------------------ 여기까지 -------------->
 
 






59    팝업창의 값을 참조하여 오프너에 보내기 예제 

 
============
opener.html
============
<HTML>
<HEAD>
<!---- [1단계] 아래의 소스코드를 <HEAD>와 </HEAD> 사이에 붙여 넣으세요 ---->
<SCRIPT LANGUAGE="JavaScript">
<!--
// 목록보기 버튼을 클릭하면 list.html 문서창을 열어줍니다
function showList() {
  sList = window.open("list.html", "list", "width=200,height=160");
}
// 문서를 닫을때 팝업창의 opener 속성을 null 로 만들어 줍니다
function remLink() {
  if (window.sList && window.sList.open && !window.sList.closed)
    window.sList.opener = null;
}
// -->
</SCRIPT>
<!------------------------- 여기까지 ---------------------------------->
</HEAD>
<BODY onunLoad="remLink()">
<!---- [2단계] 아래의 코드를 <BODY> 태그와 </BODY> 태그안에 붙여 넣으세요 ---->
<FORM NAME="myForm">목록을 클릭하여 선택 하세요 : 
<INPUT TYPE="text" NAME="myText" SIZE="10" VALUE="">
<INPUT TYPE="button" VALUE="목록보기" onClick="showList()">
</FORM>
<!------------------------- 여기까지 ---------------------------------->
</BODY>
</HTML>
=========
list.html
=========
<HTML>
<HEAD>
<TITLE> Jasko Sample Script </TITLE>
<!---- [1단계] 아래의 소스코드를 <HEAD>와 </HEAD> 사이에 붙여 넣으세요 ---->
<SCRIPT LANGUAGE="JavaScript">
<!--
// opener 윈도우가 열려있는 상태이면
// 텍스트박스에 선택한 값을 넣고
// 현재의 이 창을 닫습니다
function pick(symbol) {
  if (window.opener && !window.opener.closed)
    window.opener.document.myForm.myText.value = symbol;
  window.close();
}
// -->
</SCRIPT>
</HEAD>
<BODY>
<!---- [2단계] 아래의 코드를 <BODY> 태그와 </BODY> 태그안에 붙여 넣으세요 ---->
<TABLE BORDER="0" cellspacing=1 align=center bgColor=teal width=100%>
<TR BGCOLOR="lightyellow"><TD><B>인기가수</B></TD><TD><B>인기배우</B></TD></TR>
<TR bgColor=white><TD><A HREF="javascript:pick('조용필')">조용필</A></TD>
<TD><A HREF="javascript:pick('장동건')">장동건</A></TD></TR>
<TR bgColor=white><TD><A HREF="javascript:pick('이미자')">이미자</A></TD>
<TD><A HREF="javascript:pick('원  빈')">원  빈</A></TD></TR>
<TR bgColor=white><TD><A HREF="javascript:pick('패티김')">패티김</A></TD>
<TD><A HREF="javascript:pick('신은경')">신은경</A></TD></TR>
<TR bgColor=white><TD><A HREF="javascript:pick('이수미')">이수미</A></TD>
<TD><A HREF="javascript:pick('최무룡')">최무룡</A></TD></TR>
<TR bgColor=white><TD><A HREF="javascript:pick('HOT')">HOT</A></TD>
<TD><A HREF="javascript:pick('배삼룡')">배삼룡</A></TD></TR>
</TABLE>
<!------------------------- 여기까지 ---------------------------------->
</BODY>
</HTML>


 






58    체크박스 항목을 그룹별로 선택하게 해 줍니다 

 
<!---- [1단계] 아래의 소스코드를 <HEAD>와 </HEAD> 사이에 붙여 넣으세요 ---->

<SCRIPT LANGUAGE="JavaScript">
<!-- 
  function selectivecheck(field, myselection)
    {
      var fieldid;
      var pos;
      var criteria;
      var strng;
      strng = myselection.value;
      for (i=0; i<field.length; i++)
        {
          if (strng=="all")
            {
            field[i].checked = true;
            }
          else
            {
              fieldid = field[i].id;
              pos = strng.substring(0,1);
              criteria = strng.substring(1,2);  
              if (fieldid.substring(pos,pos+1)==criteria)
                {
                  field[i].checked = true;
                }
              else
                {
                  field[i].checked = false; 
                }
            }
        }
    }
//  -->
</script>
<!------------------------- 여기까지 ---------------------------------->
</HEAD>
<BODY>
<!---- [2단계] 아래의 방법으로 <BODY> 태그와 </BODY> 태그안에 붙여 넣으세요 ---->

<form>
<table align="center">
<tr><td>
  <input id=a1 type=checkbox name=list value="1">그룹 A 서브그룹 1<br>
  <input id=a2 type=checkbox name=list value="2">그룹 A 서브그룹 2<br>
  <input id=b1 type=checkbox name=list value="3">그룹 B 서브그룹 1<br>
  <input id=b2 type=checkbox name=list value="4">그룹 B 서브그룹 2<br>
  <input id=c1 type=checkbox name=list value="5">그룹 C 서브그룹 1<br>
  <input id=c2 type=checkbox name=list value="6">그룹 C 서브그룹 2<br>
<p>
그룹별로 선택 하기 : <select size="1" name="mycombobox">
  <option value="all">모든 그룹 선택</option>
  <option value="0a ">A 그룹</option>
  <option value="0b ">B 그룹</option>
  <option value="0c ">C 그룹</option>
  <option value="11 ">서브그룹 1</option>
  <option value="12 ">서브그룹 2</option>
</select>
<br>
<div align="center">
<input type="button" value="그룹선택" onclick=" selectivecheck(this.form.list, this.form.mycombobox)">
</div>
</td></tr>
</table>
</form>
<!------------------------- 여기까지 ---------------------------------->
 
 







57    주문자 정보 필드 값을 배송지 정보 필드에 복사합니다 

 
<!----- 1. 아래의 스크립트를 HEAD 부분에 붙여 넣으세요 -------->
<SCRIPT LANGUAGE="JavaScript">
<!-- 
var ShipFirst = "";
var ShipID = "";
var ShipEmail = "";
var ShipCompany = "";
var ShipAddress1 = "";
var ShipAddress2 = "";
var ShipPhone = "";
var ShipGoods = "";
var ShipGoodsIndex = 0;
var ShipQTT = "";
var ShipConfirm = 0;
function InitSaveVariables(form) {
ShipFirst = form.ShipFirst.value;
ShipID = form.ShipID.value;
ShipEmail = form.ShipEmail.value;
ShipCompany = form.ShipCompany.value;
ShipAddress1 = form.ShipAddress1.value;
ShipAddress2 = form.ShipAddress2.value;
ShipPhone = form.ShipPhone.value;
ShipQTT = form.ShipQTT.value;
ShipGoodsIndex = form.ShipGoods.selectedIndex;
ShipGoods = form.ShipGoods[ShipGoodsIndex].value;
ShipConfirm = form.ShipConfirm.checked;
}
function ShipToBillPerson(form) {
if (form.copy.checked) {
InitSaveVariables(form);
form.ShipFirst.value = form.BillFirst.value;
form.ShipID.value = form.BillId.value;
form.ShipEmail.value = form.BillEmail.value;
form.ShipCompany.value = form.BillCompany.value;
form.ShipAddress1.value = form.BillAddress1.value;
form.ShipAddress2.value = form.BillAddress2.value;
form.ShipPhone.value = form.BillPhone.value;
form.ShipQTT.value = form.BillQTT.value;
form.ShipGoods.selectedIndex = form.BillGoods.selectedIndex;
form.ShipConfirm.checked = form.BillConfirm.checked;
}
else {
form.ShipFirst.value = ShipFirst;
form.ShipID.value = ShipID;
form.ShipEmail.value = ShipEmail;
form.ShipCompany.value = ShipCompany;
form.ShipAddress1.value = ShipAddress1;
form.ShipAddress2.value = ShipAddress2;
form.ShipPhone.value = ShipPhone;
form.ShipQTT.value = ShipQTT;       
form.ShipGoods.selectedIndex = ShipGoodsIndex;
form.ShipConfirm.checked = ShipConfirm;
   }
}
// -->
</script>
<!------------------ 여기까지 --------------->
</HEAD>
<!----- 2. BODY 태그안에 아래의 이벤트 핸들러를 붙여 넣으세요 -->
<BODY>
<!----- 3. 원하는 위치에 아래와 같이 코드를 붙여 넣으세요 ------->
<center>
<form method="post" action="../submit.html" name="billform">
<table border="0" cellspacing="1" cellpadding="4" width="400" bgColor=orange>
        <tr>
                <td colspan=2 width="100%">
                <b><font color=white size="-1" face="굴림">결제자 정보</b>
                </td>
        </tr>
        <tr>
                <td bgColor=lightyellow>성명:</td>
                <td bgColor=white><input type="text" size="15" maxlength="50" name="BillFirst"></td>
        </tr>
        <tr>
                <td bgColor=lightyellow>아이디:</td>
                <td bgColor=white><input type="text" size="15" maxlength="50" name="BillId"></td>
        </tr>
        <tr>
                <td bgColor=lightyellow>E-Mail:</td>
                <td bgColor=white><input type="text" size="15" name="BillEmail"></td>
        </tr>
        <tr>
                <td bgColor=lightyellow>회사명:</td>
                <td bgColor=white><input type="text" size="25" maxlength="100" name="BillCompany"></td>
        </tr>
        <tr>
                <td bgColor=lightyellow>주소1:</td>
                <td bgColor=white><input type="text" size="40" maxlength="35" name="BillAddress1"></td>
        </tr>
        <tr>
                <td bgColor=lightyellow>주소2:</td>
                <td bgColor=white><input type="text" size="40" maxlength="35" name="BillAddress2"></td>
        </tr>
        <tr>
                <td bgColor=lightyellow>긴급 연락처:</td>
                <td bgColor=white><input type="text" size="25" maxlength="21" name="BillPhone"></td>
        </tr>
        <tr>
                <td bgColor=lightyellow>상품정보:</td> 
                <td bgColor=white>
                <select name="BillGoods">
                <option selected>
                <option value="item1">품목 1
                <option value="item2">품목 2
                <option value="item3">품목 3
                <option value="item4">품목 4
                </select>
                  
                수량 <input type="text" size="10" maxlength="10" name="BillQTT">
                </td>
        </tr>
        <tr>
                <td colspan=2 align=center bgColor=lightyellow>
                <input type="checkbox" name="BillConfirm" selected> 확인메일 발송 </td>
        </tr>

        <tr>
                <td colspan=2 width="100%">
                <b><font color=white size="-1" face="굴림">배송지 정보</b>
                <font color=white face="굴림">
                (내용이 위와 같음 : <input type="checkbox" name="copy"
                OnClick="javascript:ShipToBillPerson(this.form);" value="checkbox"> )
                </td>
        </tr>
        <tr>
                <td bgColor=lightyellow>성명:</td>
                <td bgColor=white><input type="text" size="15" maxlength="50" name="ShipFirst"></td>
        </tr>
        <tr>
                <td bgColor=lightyellow>아이디:</td>
                <td bgColor=white><input type="text" size="15" maxlength="50" name="ShipID"></td>
        </tr>
        <tr>
                <td bgColor=lightyellow>E-Mail:</td>
                <td bgColor=white><input type="text" size="15" name="ShipEmail"></td>
        </tr>
        <tr>
                <td bgColor=lightyellow>회사명:</td>
                <td bgColor=white><input type="text" size="25" maxlength="100" name="ShipCompany"></td>
        </tr>
        <tr>
                <td bgColor=lightyellow>주소1:</td>
                <td bgColor=white><input type="text" size="40" maxlength="35" name="ShipAddress1"></td>
        </tr>
        <tr>
                <td bgColor=lightyellow>주소2:</td>
                <td bgColor=white><input type="text" size="40" maxlength="35" name="ShipAddress2"></td>
        </tr>
        <tr>
                <td bgColor=lightyellow>긴급 연락처:</td>
                <td bgColor=white><input type="text" size="25" maxlength="21" name="ShipPhone"></td>
        </tr>
        <tr>
                <td bgColor=lightyellow>상품종류:</td> 
                <td bgColor=white>
                <select name="ShipGoods">
                <option selected>
                <option value="item1">품목 1
                <option value="item2">품목 2
                <option value="item3">품목 3
                <option value="item4">품목 4
                </select>
                수량 <input type="text" size="10" maxlength="10" name="ShipQTT">
                </td>
        </tr>
        <tr>
                <td colspan=2 align=center bgColor=lightyellow>
                <input type="checkbox" name="ShipConfirm" selected>  확인메일 발송        </td>
        </tr>
</table>
</form>
</center>
<!------------------ 여기까지 -------------->
 
 






56    폼 요소들의 배경색이 애니메이션 됩니다 

 
<!----- 1. 아래의 스크립트를 HEAD 부분에 붙여 넣으세요 -------->
<SCRIPT>
// 배경 색상 전환효과를 설정 하세요
// 1 : 어둡게 → 중간밝기 → 어둡게
// 2 : 밝게 → 중간밝기 → 밝게
// 3 : 밝게 → 어둡게 → 밝게
// 4 : 밝게 → 아주밝게 → 밝게
// 5 : 어둡게 → 아주밝게 → 어둡게
var fade_effect=3
var eventobj=false
var timer
var previouscolor
var ns6=document.getElementById&&!document.all
if (fade_effect==1) {
        var darkmax=1
        var lightmax=127
}
if (fade_effect==2) {
        var darkmax=127
        var lightmax=254
}
if (fade_effect==3) {
        var darkmax=1
        var lightmax=254
}
if (fade_effect==4) {
        var darkmax=180
        var lightmax=254
}
if (fade_effect==5) {
        var darkmax=1
        var lightmax=80
}
var hexc = new Array('0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F')
var redrgb=lightmax
var greenrgb=lightmax
var bluergb=lightmax
var redcol_1
var redcol_2 
var greencol_1 
var greencol_2 
var bluecol_1 
var bluecol_2 
var stepmax=15
var stepred=Math.ceil(stepmax*Math.random())
var stepgreen=Math.ceil(stepmax*Math.random())
var stepblue=Math.ceil(stepmax*Math.random())
function setrandomstep() {
        stepred=Math.ceil(stepmax*Math.random())
        stepgreen=Math.ceil(stepmax*Math.random())
        stepblue=Math.ceil(stepmax*Math.random())
}
function makedarker() {
        redrgb-=stepred
        greenrgb-=stepgreen
        bluergb-=stepblue
        if (redrgb<darkmax) {redrgb=darkmax}
        if (greenrgb<darkmax) {greenrgb=darkmax}
        if (bluergb<darkmax) {bluergb=darkmax}
        if (redrgb>darkmax || greenrgb>darkmax || bluergb>darkmax) {
              redcol_1 = hexc[Math.floor(redrgb/16)];
             redcol_2 = hexc[redrgb%16];
                 greencol_1 = hexc[Math.floor(greenrgb/16)];
              greencol_2 = hexc[greenrgb%16];
                  bluecol_1 = hexc[Math.floor(bluergb/16)];
              bluecol_2 = hexc[bluergb%16];
                  var backcolor="#"+redcol_1+redcol_2+greencol_1+greencol_2+bluecol_1+bluecol_2
        eventobj.style.backgroundColor=backcolor
                timer=setTimeout("makedarker()",20);
    } 
          else {
                  clearTimeout(timer)
                setrandomstep()
                setTimeout("makelighter()",20)
          }
}
function makelighter() {
        redrgb+=stepred
        greenrgb+=stepgreen
        bluergb+=stepblue
        if (redrgb>=lightmax) {redrgb=lightmax}
        if (greenrgb>=lightmax) {greenrgb=lightmax}
        if (bluergb>=lightmax) {bluergb=lightmax}
        
        if (redrgb<lightmax || greenrgb<lightmax || bluergb<lightmax) {
              redcol_1 = hexc[Math.floor(redrgb/16)];
             redcol_2 = hexc[redrgb%16];
                 greencol_1 = hexc[Math.floor(greenrgb/16)];
              greencol_2 = hexc[greenrgb%16];
                  bluecol_1 = hexc[Math.floor(bluergb/16)];
              bluecol_2 = hexc[bluergb%16];
                  var backcolor="#"+redcol_1+redcol_2+greencol_1+greencol_2+bluecol_1+bluecol_2
        eventobj.style.backgroundColor=backcolor
                timer=setTimeout("makelighter()",20);
    } 
          else {
                  clearTimeout(timer)
                setrandomstep()
                setTimeout("makedarker()",20)
          }
}
function animate(e) {
    if (document.all) {
        if (eventobj) {
            eventobj.style.backgroundColor=previouscolor
        }
        clearTimeout(timer)
        eventobj=   event.srcElement
        previouscolor= eventobj.style.backgroundColor
        makedarker()
    }
}
function stopit() {
    if (document.all) {
        clearTimeout(timer)
        eventobj.style.backgroundColor=previouscolor
    }
}
</script>
<!------------------ 여기까지 --------------->
</HEAD>
<BODY>
각 폼 요소를 클릭하거나 마우스를 대어 보세요
<br><br>

<!--- 2. 각 폼 요소마다  onFocus="animate(event)" onBlur="stopit()"  를 붙여 넣으세요 ---->
<!---- 마우스를 댈때 스크립트를 실행 시키려면 
onmouseOver="animate(event)" onmouseOut="stopit()" 
으로 설정 하세요 ---->
<INPUT TYPE="text" NAME=""  onFocus="animate(event)" onBlur="stopit()" >
<INPUT TYPE="password" onmouseOver="animate(event)" onmouseOut="stopit()" >
<br><br>
<INPUT TYPE="radio" NAME="" onFocus="animate(event)" onBlur="stopit()" >
<INPUT TYPE="radio" NAME="" onFocus="animate(event)" onBlur="stopit()" >
<br><br>
<INPUT TYPE="checkbox" NAME="" onFocus="animate(event)" onBlur="stopit()" >
<INPUT TYPE="checkbox" NAME="" onFocus="animate(event)" onBlur="stopit()" >
<br><br>
<TEXTAREA NAME="" ROWS="" COLS="" onFocus="animate(event)" onBlur="stopit()" ></TEXTAREA>
<br><br>
<input type="button" onmouseOver="animate(event)" onmouseOut="stopit()"  value=" 테스트 해보자 ">

<!------------------ 여기까지 -------------->
 
 






55    콤보 메뉴의 옵션 항목이 5초마다 저절로 바뀝니다 

 
<!-----  원하는 위치에 아래와 같이 코드를 붙여 넣으세요 ------->
<form name=menuform>
<select size=1 name="msg">
<option>야후 코리아로 가는길
<option>라이코스 코리아는 어때요?
<option>아니아니, 멜 확인이 급해! 한메일로 가자
<option>자스코도 빼놓을 수는 없죠
</select></form>
<script language="javascript">
<!-- 
function rotate() {
menu = document.menuform.msg;
chosen = menu.selectedIndex;
menu.selectedIndex= (chosen == (menu.length-1)) ? 0 : chosen + 1;
setTimeout("rotate()",5000); // 5초마다 바뀝니다
}
rotate();
// -->
</script>
<!------------------ 여기까지 -------------->
 
 






54    숫자에 3자리 단위로 콤마를 찍어 줍니다

 
<!----- 1. 아래의 스크립트를 HEAD 부분에 붙여 넣으세요 -------->
<SCRIPT LANGUAGE="JavaScript">
<!-- 
function commaSplit(srcNumber) {
var txtNumber = '' + srcNumber;
if (isNaN(txtNumber) || txtNumber == "") {
alert("숫자만 입력 하세요");
fieldName.select();
fieldName.focus();
}
else {
var rxSplit = new RegExp('([0-9])([0-9][0-9][0-9][,.])');
var arrNumber = txtNumber.split('.');
arrNumber[0] += '.';
do {
arrNumber[0] = arrNumber[0].replace(rxSplit, '$1,$2');
} while (rxSplit.test(arrNumber[0]));
if (arrNumber.length > 1) {
return arrNumber.join('');
}
else {
return arrNumber[0].split('.')[0];
      }
   }
}
// -->
</script>
<!------------------ 여기까지 --------------->
<!----- 2. 원하는 위치에 아래와 같이 코드를 붙여 넣으세요 ------->
<form name="commas" action="../submit.html" method=post>
금액: 
<input type=text name="inpNumber" value="" onBlur="document.commas.inpNumber.value=commaSplit(document.commas.inpNumber.value);">
성명:
<input type=text name=oname>
<input type=submit>
</form>
<!------------------ 여기까지 -------------->
 
 
 






53    홈페이지 추천하기

 
<!----- 1. 아래의 스크립트를 HEAD 부분에 붙여 넣으세요 -------->
<SCRIPT LANGUAGE="JavaScript">
<!-- 
var good;
function checkEmailAddress(field) {
var goodEmail = field.value.match(/\b(^(\S+@).+((\.com)|(\.net)|(\.edu)|(\.mil)|(\.gov)|(\.org)|(\..{2,2}))$)\b/gi);
if (goodEmail) {
good = true;
}
else {
alert('이메일 주소는 정확하게 작성 하세요');
field.focus();
field.select();
good = false;
   }
}
u = window.location;
m = "이 사이트 참 좋은 것 같아...";
function mailThisUrl() {
good = false
checkEmailAddress(document.eMailer.address);
if (good) {
window.location = "mailto:"+document.eMailer.address.value+"?subject="+m+"&body="+document.title+" "+u;
   }
}
//-->
</script>
<!------------------ 여기까지 --------------->
</HEAD>
<BODY>
<!----- 2. 원하는 위치에 아래와 같이 코드를 붙여 넣으세요 ------->
<form name="eMailer">
<B>이 페이지 추천하기</B>
<br>
받는 사람의 이메일 주소를 입력 하세요
<br>
<input type="text" name="address" size="25">
<input type="button" value="추천 하기" onClick="mailThisUrl();">
</form>
<!------------------ 여기까지 -------------->
 
 






52    콤보메뉴에서 항상 오늘날짜를 년-월-일 로 보여줍니다

 
<!----- 원하는 위치에 아래와 같이 코드를 붙여 넣으세요 ------->
<SCRIPT LANGUAGE="JavaScript">
<!-- 
today = new Date();
thismonth = today.getMonth()+1;
thisyear = today.getYear();
thisday = today.getDate();
montharray=new Array(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
maxdays=montharray[thismonth-1];
if (thismonth==2) {
if ((thisyear/4)!=parseInt(thisyear/4)) maxdays=28;
else maxdays=29;
}
thismonth = "" + thismonth
if (thismonth.length == 1) {
thismonth = "0" + thismonth;
}
document.write("<form>");
document.write("<select name=dates size=1>");
for (var theday = 1; theday <= maxdays; theday++) {
var theday = "" + theday;
if (theday.length == 1) {
theday = "0" + theday;
}
document.write("<option");
if (theday == thisday) document.write(" selected");
document.write(">");
document.write(thisyear + "-" + thismonth + "-" + theday);
}
document.write("</select></form>");
//  -->
</SCRIPT>
<!------------------ 여기까지 -------------->
 
 





51    애니메이션 후 이동하는 콤보메뉴 만들기

 
<!---- 아래의 코드를 원하는 위치에 복사 해 넣으세요 -------------------->
<form name="take" >
<table border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="100%"><select name="take2" size="5" style="width:200px">
        <option selected value="http://www.mybizs.com">JavaScript Source</option>
        <option value="http://www.imbc.com">문화방송</option>
        <option value="http://www.kbs.co.kr">한국방송</option>
        <option value="http://www.chosun.com">조선일보</option>
        <option value="http://www.hani.com">한겨레신문</option>
      </select>
<script>
<!--
// 애니메이션 프레임숫자를 설정합니다 
var setframes=6
var selected=-1
var switchit=-1
var cycle=0
function animate_go(){
if (cycle>=setframes){
document.take.take2.selectedIndex =selected
window.location=document.take.take2.options[document.take.take2.selectedIndex].value
return
}
switchit=(switchit==-1)? selected : -1
document.take.take2.selectedIndex =switchit
cycle++
setTimeout("animate_go()",100)
}
//-->
</script>
</td>
    </tr>
    <tr>
      <td width="100%">
          <div align="center">
          <p>
          <input type="button"
      value="가보자-->>" name="B1" onClick="selected=document.take.take2.selectedIndex;cycle=0;animate_go()">
          </div>
          </td>
    </tr>
  </table>
</form>
<!------------------------- 여기까지 ---------------------------------->
 
 






50    자동으로 현재의 년월일을 선택하는 콤보상자

 
<!---- [1단계] 아래의 소스코드를 <HEAD>와 </HEAD> 사이에 붙여 넣으세요 ---->
<SCRIPT language="JavaScript">
Now = new Date();
NowDay = Now.getDate();
NowMonth = Now.getMonth();
NowYear = Now.getYear();
if (NowYear < 2000) NowYear += 1900;
function DaysInMonth(WhichMonth, WhichYear){
        var DaysInMonth = 31;
        if (WhichMonth == "Apr" || WhichMonth == "Jun" || WhichMonth == "Sep" || WhichMonth == "Nov") DaysInMonth = 30;
        if (WhichMonth == "Feb" && (WhichYear/4) != Math.floor(WhichYear/4))        DaysInMonth = 28;
        if (WhichMonth == "Feb" && (WhichYear/4) == Math.floor(WhichYear/4))        DaysInMonth = 29;
        return DaysInMonth;
}
function ChangeOptionDays(Which){
        DaysObject = eval("document.Form1." + Which + "Day");
        MonthObject = eval("document.Form1." + Which + "Month");
        YearObject = eval("document.Form1." + Which + "Year");
        Month = MonthObject[MonthObject.selectedIndex].text;
        Year = YearObject[YearObject.selectedIndex].text;
        DaysForThisSelection = DaysInMonth(Month, Year);
        CurrentDaysInSelection = DaysObject.length;
        if (CurrentDaysInSelection > DaysForThisSelection)        {
                for (i=0; i<(CurrentDaysInSelection-DaysForThisSelection); i++)                {
                        DaysObject.options[DaysObject.options.length - 1] = null
                }
        }
        if (DaysForThisSelection > CurrentDaysInSelection)        {
                for (i=0; i<(DaysForThisSelection-CurrentDaysInSelection); i++)                {
                        NewOption = new Option(DaysObject.options.length + 1);
                        DaysObject.add(NewOption);
                }
        }
        if (DaysObject.selectedIndex < 0) DaysObject.selectedIndex == 0;
}
function SetToToday(Which){
        DaysObject = eval("document.Form1." + Which + "Day");
        MonthObject = eval("document.Form1." + Which + "Month");
        YearObject = eval("document.Form1." + Which + "Year");
        YearObject[0].selected = true;
        MonthObject[NowMonth].selected = true;
        ChangeOptionDays(Which);
        DaysObject[NowDay-1].selected = true;
}
function WriteYearOptions(YearsAhead){
        line = "";
        for (i=0; i<YearsAhead; i++)        {
                line += "<OPTION>";
                line += NowYear + i;
        }
        return line;
}
</SCRIPT>
<!------------------------- 여기까지 ---------------------------------->
</HEAD>
<!---- [2단계] <BODY> 태그안에 있는 코드를 복사 해 넣으세요 --------------->
<BODY onload="SetToToday('FirstSelect');">
<!------------------------- 여기까지 ---------------------------------->
<!---- [3단계] 아래의 코드를 <BODY> 태그와 </BODY> 태그안에 붙여 넣으세요 ---->
<FORM name="Form1">
<SELECT name="FirstSelectYear" onchange="ChangeOptionDays('FirstSelect')">
        <SCRIPT language="JavaScript">
                document.write(WriteYearOptions(50));
        </SCRIPT>
</SELECT>
<SELECT name="FirstSelectMonth" onchange="ChangeOptionDays('FirstSelect')">
        <OPTION>Jan
        <OPTION>Feb
        <OPTION>Mar
        <OPTION>Apr
        <OPTION>May
        <OPTION>Jun
        <OPTION>Jul
        <OPTION>Aug
        <OPTION>Sep
        <OPTION>Oct
        <OPTION>Nov
        <OPTION>Dec
</SELECT>
<SELECT name="FirstSelectDay">
        <OPTION>1
        <OPTION>2
        <OPTION>3
        <OPTION>4
        <OPTION>5
        <OPTION>6
        <OPTION>7
        <OPTION>8
        <OPTION>9
        <OPTION>10
        <OPTION>11
        <OPTION>12
        <OPTION>13
        <OPTION>14
        <OPTION>15
        <OPTION>16
        <OPTION>17
        <OPTION>18
        <OPTION>19
        <OPTION>20
        <OPTION>21
        <OPTION>22
        <OPTION>23
        <OPTION>24
        <OPTION>25
        <OPTION>26
        <OPTION>27
        <OPTION>28
        <OPTION>29
        <OPTION>30
        <OPTION>31
</SELECT>
</FORM>
<!------------------------- 여기까지 ---------------------------------->
 
 






49    이미지를 이용한 다이나믹 submit 버튼 예제  

 
<!---- [1단계] 아래의 소스코드를 <HEAD>와 </HEAD> 사이에 붙여 넣으세요 ---->
<script>
// 사용할 버튼 이미지들을 설정합니다
var Pic = new Array
Pic[0] = 'reset_green.gif'
Pic[1] = 'reset_orange.gif'
Pic[2] = 'reset_red.gif'
Pic[3] = 'submit_green.gif'
Pic[4] = 'submit_orange.gif'
Pic[5] = 'submit_red.gif'
var p = Pic.length
var preLoad = new Array()
var i = 0;
for (i = 0; i < p; i++){
     preLoad[i] = new Image()
     preLoad[i].src = Pic[i]
}
function switchImage(whichImage,imageNumber){
   document.images[whichImage].src = preLoad[imageNumber].src
}
</script>
<!------------------------- 여기까지 ---------------------------------->
</HEAD>
<body bgcolor="#000000">
<!---- [2단계] 아래의 코드를 <BODY> 태그와 </BODY> 태그안에 붙여 넣으세요 ---->
<a href="" onMouseOut  = "switchImage('resetImage',0)" onMouseOver = "switchImage('resetImage',1)" onMouseDown = "switchImage('resetImage',2)">
<img name="resetImage" src="reset_green.gif" width="83" height="30" border="0">
</a>
<a href="javascript:doSubmit()" onMouseOut  = "switchImage('submitImage',3)" onMouseOver = "switchImage('submitImage',4)" onMouseDown = "switchImage('submitImage',5)">
<img name="submitImage" src="submit_green.gif" width="83" height="30" border="0">
</a>
<!------------------------- 여기까지 ----------------------------------> 
 






48    입력영역에 최대 입력 글자수를 제한 합니다

 
<!---- [1단계] 아래의 방법으로 원하는 위치에 복사 해 넣으세요 ------------------>
<script>
<!--
function checkchars(cur){
// 최대입력 글자수를 지정하세요
var maxlength=10 // 50글자
if (cur.chars.value.length>maxlength){
alert("10글자 까지만 입력 할 수 있습니다")
return false
}
}
//-->
</script>
<form onsubmit="return checkchars(this)">
<strong>10자 이하만 입력 해 주세요</strong><br>
<textarea rows="5" cols="38" name="chars"></textarea>
<br><input type="submit">
</form>
<!------------------------- 여기까지 ---------------------------------->
 
 






47    필수항목은 반드시 입력 하게 합니다

 
<!---- [1단계] 아래의 소스코드를 <HEAD>와 </HEAD> 사이에 붙여 넣으세요 ---->
<script>
function checkrequired(which){
var pass=true
if (document.images){
for (i=0;i<which.length;i++){
var tempobj=which.elements[i]
if (tempobj.name.substring(0,8)=="required"){ // required 라는 단어가 들어간 항목만 체크
if (((tempobj.type=="text"||tempobj.type=="textarea")&&tempobj.value=='')||(tempobj.type.toString().charAt(0)=="s"&&tempobj.selectedIndex==-1)){
pass=false
break
}
}
}
}
if (!pass){
alert("필수항목의 입력이 되지 않았습니다")
return false
}
else
return true
}
</script>
<!------------------------- 여기까지 ---------------------------------->

</HEAD>
<BODY>
<!---- [2단계] 아래의 방법으로 원하는 위치에 복사 해 넣으세요 ------------------>
<!----- form 태그에 onSubmit="return checkrequired(this)" 을 넣어준 후,
필수항목인 경우 name 을 required 로 시작하는 이름으로 붙여 줍니다
------>
<form onSubmit="return checkrequired(this)">
이름 : <input type="text" name="requiredname"><br>
메일 : <input type="text" name="requiredemail"><br>
취미 : 
<select name="requiredhobby">
<option value=a>등산</option>
<option value=b>낚시</option>
<option value=c>바둑</option>
<option value=d>수영</option>
<option value=e>골프</option>
</select>
<br>
하실말씀 : <br>
<textarea name="comments" style="width:200;height:100"></textarea>
<br>
<input type=submit>
</form>
<!------------------------- 여기까지 ---------------------------------->
 
 






46    정규식을 사용한 이메일 주소 체크하기 

 
<!---- [1단계] 아래의 방법으로 원하는 위치에 복사 해 넣으세요 ------------------>
<form name="validation" onSubmit="return checkbae()">
이메일 주소 :<br>
<input type="text" size=18 name="emailcheck">
<input type="submit">
</form>
<script language="JavaScript1.2">
var testresults
function checkemail(){
var str=document.validation.emailcheck.value
var filter=/^(\w+(?:\.\w+)*)@((?:\w+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i
if (filter.test(str))
testresults=true
else{
alert("유효한 이메일 주소가 아닙니다")
testresults=false
}
return (testresults)
}
function checkbae(){
if (document.layers||document.getElementById||document.all)
return checkemail()
else
return true
}
</script>
<!------------------------- 여기까지 ---------------------------------->
 
 






45    콤보상자에서 선택한 내용을 입력영역에 차례대로 디스플레이 해 줍니다  

 
<!---- [1단계] 아래의 소스코드를 <HEAD>와 </HEAD> 사이에 붙여 넣으세요 ---->
<SCRIPT LANGUAGE="JavaScript">
<!-- 
oldvalue = "";
function passText(passedvalue) {
  if (passedvalue != "") {
    var totalvalue = passedvalue+"\n"+oldvalue;
    document.displayform.itemsbox.value = totalvalue;
    oldvalue = document.displayform.itemsbox.value;
  }
}
//-->
</script>
<!------------------------- 여기까지 ---------------------------------->
</HEAD>
<BODY>
<!---- [2단계] 아래의 방법으로 원하는 위치에 복사 해 넣으세요 ------------------>
<form name="selectform">
<font size="3"><b>항목을 선택 하세요</b></font><br>
<select name="dropdownbox" size=1>
<option value="">내용선택</option>
<option value="첫번째 내용">첫번째 내용 입니다</option>
<option value="두번째 내용">두번째 내용 입니다</option>
<option value="세번째 내용">세번째 내용 입니다</option>
<option value="네번째 내용">네번째 내용 입니다</option>
<option value="다섯번째 내용">다섯번째 내용 입니다</option>
<option value="여섯번째 내용">여섯번째 내용 입니다</option>
</select>
<input type=button value="내용추가하기" onClick="passText(this.form.dropdownbox.options[this.form.dropdownbox.selectedIndex].value);">
</form>
<form name="displayform" >
<font size="3"><b>추가된 내용목룍</b></font><br>
<textarea cols="40" rows="5" name="itemsbox" ></textarea>
</form>
<!------------------------- 여기까지 ---------------------------------->
 
 






44    입력한 이메일 주소를 경고창을 띄워 확인 시킨 후 submit 합니다 

 
<!---- [1단계] 아래의 소스코드를 <HEAD>와 </HEAD> 사이에 붙여 넣으세요 ---->
<script>
function alertemail(which){
if (confirm("입력한 이메일 주소는 \""+which.value+"\" 입니다. 이 주소가 맞습니까??"))
return true
else{
which.focus()
return false
}
}
</script>
<!------------------------- 여기까지 ---------------------------------->
</HEAD>
<BODY>
<!---- [2단계] 아래의 방법으로 원하는 위치에 복사 해 넣으세요 ------------------>
<form onSubmit="return alertemail(useremail)">
<input type="text" value="이메일 입력" name="useremail">
<input type=submit>
</form>
<!------------------------- 여기까지 ---------------------------------->


 






 

43    특정 이메일 주소 입력을 금지합니다  

 
<!---- [1단계] 아래의 방법으로 원하는 위치에 복사 해 넣으세요 ------------------>
daum, kebi, yahoo,hanmail 계정은 입력할 수 없습니다<br>
<form name="validation" onSubmit="return checkbae()">
이메일 주소 입력 : 
<input type="text" size=18 name="emailcheck"><br>
<input type="submit">
</form>

<script language="JavaScript1.2">
// 이메일 주소 입력 금지시키기
// 금지할 도메인을 입력 하세요
var invalidaddress=new Array()
invalidaddress[0]="daum"
invalidaddress[1]="kebi"
invalidaddress[2]="yahoo"
invalidaddress[3]="hanmail"
var testresults
function checkemail(){
var invalidcheck=0;
var str=document.validation.emailcheck.value
var filter=/^(\w+(?:\.\w+)*)@((?:\w+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i
if (filter.test(str)){
var tempstring=str.split("@")
tempstring=tempstring[1].split(".")
for (i=0;i<invalidaddress.length;i++){
if (tempstring[0]==invalidaddress[i])
invalidcheck=1
}
if (invalidcheck!=1)
testresults=true
else{
alert("입력 금지된 계정입니다")
testresults=false
}
}
else{
alert("이메일 주소가 유효하지 않습니다")
testresults=false
}
return (testresults)
}
function checkbae(){
if (document.layers||document.getElementById||document.all)
return checkemail()
else
return true
}
</script>
<!------------------------- 여기까지 ---------------------------------->
 
 






42    여러가지 형태의 날짜 입력값을 특정 형태로 변환합니다 

<!---- [1단계] 아래의 소스코드를 <HEAD>와 </HEAD> 사이에 붙여 넣으세요 ---->
<SCRIPT LANGUAGE="JavaScript">
<!-- 
function check_date(field){
var checkstr = "0123456789";
var DateField = field;
var Datevalue = "";
var DateTemp = "";
var seperator = ".";
var day;
var month;
var year;
var leap = 0;
var err = 0;
var i;
   err = 0;
   DateValue = DateField.value;
   /* 숫자가 아닌 문자 삭제 */
   for (i = 0; i < DateValue.length; i++) {
          if (checkstr.indexOf(DateValue.substr(i,1)) >= 0) {
             DateTemp = DateTemp + DateValue.substr(i,1);
          }
   }
   DateValue = DateTemp;
   /* 날짜를 여덟자리로 변환*/
   /* 연도가 2자리로 입력 된다면 20 을 추가 */
   if (DateValue.length == 6) {
      DateValue = '20' + DateValue.substr(0,6); }
   if (DateValue.length != 8) {
      err = 19;}
   /* 년도가 0000 으로 입력되는지 체크 */
   year = DateValue.substr(0,4);
   if (year == 0) {
      err = 20;
   }
   /* 월의 유효성 체크 */
   month = DateValue.substr(4,2);
   if ((month < 1) || (month > 12)) {
      err = 21;
   }
   /* 날짜의 유효성 체크 */
   day = DateValue.substr(6,2);
   if (day < 1) {
     err = 22;
   }
   /* 윤년/2월 체크 */
   if ((year % 4 == 0) || (year % 100 == 0) || (year % 400 == 0)) {
      leap = 1;
   }
   if ((month == 2) && (leap == 1) && (day > 29)) {
      err = 23;
   }
   if ((month == 2) && (leap != 1) && (day > 28)) {
      err = 24;
   }
   /* 기타 월의 유효성 체크  */
   if ((day > 31) && ((month == "01") || (month == "03") || (month == "05") || (month == "07") || (month == "08") || (month == "10") || (month == "12"))) {
      err = 25;
   }
   if ((day > 30) && ((month == "04") || (month == "06") || (month == "09") || (month == "11"))) {
      err = 26;
   }
   /* 00 입력시 입력내용 삭제 */
   if ((day == 0) && (month == 0) && (year == 00)) {
      err = 0; day = ""; month = ""; year = ""; seperator = "";
   }
   /* 에러가 없다면 날짜 출력 */
   if (err == 0) {
      DateField.value = year + seperator + month + seperator + day;
   }
   else {
      alert("날짜 입력이 틀렸습니다");
      DateField.select();
          DateField.focus();
   }
}
// -->
</script>
</HEAD>
<BODY>
<!---- [2단계] 아래의 방법으로 원하는 위치에 복사 해 넣으세요 ------------------>
<FORM name="datecheck">
<TABLE border="0">
    <TR>
    <TD style="font-size:12px">
        <b>2002년5월6일 을 입력하려면, 아래 형식중 한가지를 사용하세요</b><br><br>
        yymmdd 형식 (020506)<BR>
        yyyymmdd 형식 (20020506)<BR>
        yyyyXmmXdd 형식 (2002.05.06 혹은 2002,05,06 ...) <br><br>
          </TD>
        </TR>
        <TR>
          <TD>
          <INPUT type="text" name=testdat size='10' maxlength="10" onblur="check_date(this)">
          <INPUT type= "submit" name="button" value="확인">
        <p style="font-size:12px; color:red">날자를 입력 한 후 다른곳을 선택하면 날짜가 변환됩니다
    </TD>
        </TR>
</TABLE>
</FORM>
<!------------------------- 여기까지 ---------------------------------->
 
 






41    입력상자의 날짜형식 변환하기 

 
<!---- 아래의 방법으로 원하는 위치에 복사 해 넣으세요 ------------------>
<SCRIPT LANGUAGE="JavaScript">
<!-- 
function convert() {
year = f1.t1.value.substring(0,4);
month = f1.t1.value.substring(4,6);
day = f1.t1.value.substring(6,8);
datestring = year + "년 " + month + "월 " + day + "일";
document.f1.t1.value=datestring
}
// -->
</script>
<form name=f1>
년월일을 붙여서 입력 하세요 <input type=text name=t1 onblur="convert(this)"> 예; 20021225
</form>
<!------------------------- 여기까지 ---------------------------------->
 
 







 40    이름이나 아이디중 한가지만 입력하게 합니다
 
<!---- [1단계] 아래의 소스코드를 <HEAD>와 </HEAD> 사이에 붙여 넣으세요 ---->
<SCRIPT LANGUAGE="JavaScript">
<!-- 
function checkFields() {
name = document.submitform.name.value;
id = document.submitform.id.value;
if ((name == "") && (id == "") ) {
alert("이름이나 아이디중 한가지만 입력하세요");
return false;
}
else return true;
}
// -->
</script>
<!------------------------- 여기까지 ---------------------------------->
</HEAD>
<BODY>
<!---- [2단계] 아래의 방법으로 원하는 위치에 복사 해 넣으세요 ------------------>
<center>
<form action="" name=submitform onSubmit="return checkFields()">
이름이나 아이디중 한가지만 입력하세요<br><br>
<table border=0>
<tr>
<td align=center>이름</td>
<td> </td>
<td align=center>아이디</td>
</tr>
<tr>
<td align=center><input type=text name=name value="" onFocus="document.submitform.id.value='';" size=10></td>
<td align=center>혹은</td>
<td align=center><input type=text name=id value="" onFocus="document.submitform.name.value='';" size=10></td>
</tr>
<tr>
<td colspan=3 align=center><input type=submit></td>
</tr>
</table>
</form>
</center>
<!------------------------- 여기까지 ---------------------------------->
 
 


  





39    체크박스 항목을 모두선택, 모두해제, 또는 반전 시켜 줍니다 

 
<!---- [1단계] 아래의 소스코드를 <HEAD>와 </HEAD> 사이에 붙여 넣으세요 ---->
<SCRIPT LANGUAGE="JavaScript">
<!-- 
function checkAll() {
for (var j = 1; j <= 7; j++) {
box = eval("document.checkboxform.C" + j); 
if (box.checked == false) box.checked = true;
   }
}
function uncheckAll() {
for (var j = 1; j <= 7; j++) {
box = eval("document.checkboxform.C" + j); 
if (box.checked == true) box.checked = false;
   }
}
function switchAll() {
for (var j = 1; j <= 7; j++) {
box = eval("document.checkboxform.C" + j); 
box.checked = !box.checked;
   }
}
//-->
</script>
<!----------- 위 소스코드내용중 j <= 7 부분을 모두 체크박스의 갯수와 맞추어 주세요 -------->
<!------------------------- 여기까지 ---------------------------------->
</HEAD>
<BODY>
<!---- [2단계] 아래의 방법으로 원하는 위치에 복사 해 넣으세요 ------------------>
<form name=checkboxform>
<input type=checkbox name=C1 checked>C1<br>
<input type=checkbox name=C2 checked>C2<br>
<input type=checkbox name=C3 checked>C3<br>
<input type=checkbox name=C4 checked>C4<br>
<input type=checkbox name=C5 checked>C5<br>
<input type=checkbox name=C6 checked>C6<br>
<input type=checkbox name=C7 checked>C7<br>
<br>
<input type=button value="모두선택" onClick="checkAll()"> 
<input type=button value="모두해제" onClick="uncheckAll()"> 
<input type=button value="반전하기" onClick="switchAll()">
</form>
<!------------------------- 여기까지 ---------------------------------->
 
 






 

38    영문자나 숫자만 입력 할 수 있습니다 

 
<!---- [1단계] 아래의 소스코드를 <HEAD>와 </HEAD> 사이에 붙여 넣으세요 ---->
<SCRIPT LANGUAGE="JavaScript">
<!-- 
function validate(field) {
var valid = "abcdefghijklmnopqrstuvwxyz0123456789"
var ok = "yes";
var temp;
for (var i=0; i<field.value.length; i++) {
temp = "" + field.value.substring(i, i+1);
if (valid.indexOf(temp) == "-1") ok = "no";
}
if (ok == "no") {
alert("영문자와 숫자만 입력할 수 있습니다");
field.focus();
field.select();
   }
}
//-->
</script>
<!------------------------- 여기까지 ---------------------------------->
</HEAD>
<BODY>
<!---- [2단계] 아래의 방법으로 원하는 위치에 복사 해 넣으세요 ------------------>
<form>
아이디 <input type=text name="entry" onBlur="validate(this)">
<input type=submit>
<br><br>
※ 아이디는 영문자나 숫자만 가능합니다
</form>
<!------------------------- 여기까지 ---------------------------------->
 
 


  





37    한번만 submit 되게 합니다  

 
<!---- [1단계] 아래의 소스코드를 <HEAD>와 </HEAD> 사이에 붙여 넣으세요 ---->
<SCRIPT LANGUAGE="JavaScript">
<!-- 
var submitcount=0;
function reset() {
document.emailform.name.value="";
document.emailform.email.value="";
document.emailform.comments.value="";
}
function checkFields() {
if ( (document.emailform.name.value=="")  || 
     (document.emailform.email.value=="") || 
     (document.emailform.comments.value=="") )
   {
   alert("항목을 채워주세요");
   return false;
   }
else 
   {
   if (submitcount == 0)
      {
      submitcount++;
      return true;
      }
   else 
      {
      alert("버튼은 한번만 눌러주세요");
      return false;
      }
   }
}
//-->
</script>
<!------------------------- 여기까지 ---------------------------------->
</HEAD>
<!---- [2단계] <BODY> 태그안에 있는 코드를 복사 해 넣으세요 --------------->
<BODY onLoad="reset()">
<!------------------------- 여기까지 ---------------------------------->
<!---- [3단계] 아래의 방법으로 원하는 위치에 복사 해 넣으세요 ------------------>
<form method=post action="#" name="emailform" onSubmit="return checkFields()">
<input type=hidden name=to value="이메일@주소">
<input type=hidden name=subject value="메일제목">
<pre>
이  름 :   <input type=text name="name">
이메일 :   <input type=text name="email">
하실말씀
<textarea name="comments" wrap="virtual" rows="7" cols="45"></Textarea>
<input type=submit>
</pre>
</form>
<!------------------------- 여기까지 ---------------------------------->
 
 







36    폼 요소에 멋진 페이드 효과 주기

 
<!---- [1단계] 아래의 소스코드를 <HEAD>와 </HEAD> 사이에 붙여 넣으세요 ---->
<SCRIPT>
// 아래 옵션중 한가지를 지정하세요
//
// 1 : 어두운색 -> 중간색 -> 어두운색
// 2 : 밝은색 -> 중간색 -> 밝은색
// 3 : 밝은색 -> 어두운색 -> 밝은색
// 4 : 밝은색 -> 아주밝은색 -> 밝은색
// 5 : 어두운색 -> 아주 어두운색 -> 어두운색
var fade_effect=2
var eventobj=false
var timer
var previouscolor
var ns6=document.getElementById&&!document.all
if (fade_effect==1) {
        var darkmax=1
        var lightmax=127
}
if (fade_effect==2) {
        var darkmax=127
        var lightmax=254
}
if (fade_effect==3) {
        var darkmax=1
        var lightmax=254
}
if (fade_effect==4) {
        var darkmax=180
        var lightmax=254
}
if (fade_effect==5) {
        var darkmax=1
        var lightmax=80
}
var hexc = new Array('0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F')
var redrgb=lightmax
var greenrgb=lightmax
var bluergb=lightmax
var redcol_1
var redcol_2 
var greencol_1 
var greencol_2 
var bluecol_1 
var bluecol_2 
var stepmax=15
var stepred=Math.ceil(stepmax*Math.random())
var stepgreen=Math.ceil(stepmax*Math.random())
var stepblue=Math.ceil(stepmax*Math.random())
function setrandomstep() {
        stepred=Math.ceil(stepmax*Math.random())
        stepgreen=Math.ceil(stepmax*Math.random())
        stepblue=Math.ceil(stepmax*Math.random())
}
function makedarker() {
        redrgb-=stepred
        greenrgb-=stepgreen
        bluergb-=stepblue
        if (redrgb<darkmax) {redrgb=darkmax}
        if (greenrgb<darkmax) {greenrgb=darkmax}
        if (bluergb<darkmax) {bluergb=darkmax}
        if (redrgb>darkmax || greenrgb>darkmax || bluergb>darkmax) {
              redcol_1 = hexc[Math.floor(redrgb/16)];
             redcol_2 = hexc[redrgb%16];
                 greencol_1 = hexc[Math.floor(greenrgb/16)];
              greencol_2 = hexc[greenrgb%16];
                  bluecol_1 = hexc[Math.floor(bluergb/16)];
              bluecol_2 = hexc[bluergb%16];
                  var backcolor="#"+redcol_1+redcol_2+greencol_1+greencol_2+bluecol_1+bluecol_2
        eventobj.style.backgroundColor=backcolor
                timer=setTimeout("makedarker()",20);
    } 
          else {
                  clearTimeout(timer)
                setrandomstep()
                setTimeout("makelighter()",20)
          }
}
function makelighter() {
        redrgb+=stepred
        greenrgb+=stepgreen
        bluergb+=stepblue
        if (redrgb>=lightmax) {redrgb=lightmax}
        if (greenrgb>=lightmax) {greenrgb=lightmax}
        if (bluergb>=lightmax) {bluergb=lightmax}
        
        if (redrgb<lightmax || greenrgb<lightmax || bluergb<lightmax) {
              redcol_1 = hexc[Math.floor(redrgb/16)];
             redcol_2 = hexc[redrgb%16];
                 greencol_1 = hexc[Math.floor(greenrgb/16)];
              greencol_2 = hexc[greenrgb%16];
                  bluecol_1 = hexc[Math.floor(bluergb/16)];
              bluecol_2 = hexc[bluergb%16];
                  var backcolor="#"+redcol_1+redcol_2+greencol_1+greencol_2+bluecol_1+bluecol_2
        eventobj.style.backgroundColor=backcolor
                timer=setTimeout("makelighter()",20);
    } 
          else {
                  clearTimeout(timer)
                setrandomstep()
                setTimeout("makedarker()",20)
          }
}
function animate(e) {
    if (document.all) {
        if (eventobj) {
            eventobj.style.backgroundColor=previouscolor
        }
        clearTimeout(timer)
        eventobj=   event.srcElement
        previouscolor= eventobj.style.backgroundColor
        makedarker()
    }
}
function stopit() {
    if (document.all) {
        clearTimeout(timer)
        eventobj.style.backgroundColor=previouscolor
    }
}
</script>
<!------------------------- 여기까지 ---------------------------------->
</HEAD>
<BODY>
<!---- [2단계] 아래의 방법으로 원하는 위치에 복사 해 넣으세요 ------------------>
<!---- 
각 폼태그에
onFocus="animate(event)" onBlur="stopit()" 
를 넣어 주세요
---->
<FORM METHOD=POST ACTION="">
<INPUT TYPE="text" NAME="" onFocus="animate(event)" onBlur="stopit()" value="이곳을 클릭 하세요">
<BR>
<SELECT NAME="" onFocus="animate(event)" onBlur="stopit()" >
        <OPTION VALUE="">첫번째 항목</OPTION>
        <OPTION VALUE="">두번째 항목</OPTION>
        <OPTION VALUE="">세번째 항목</OPTION>
        <OPTION VALUE="">네번째 항목</OPTION>
        <OPTION VALUE="">다섯번째 항목</OPTION>
</SELECT>
<BR>
<INPUT TYPE="radio" NAME="" onFocus="animate(event)" onBlur="stopit()" >
<INPUT TYPE="radio" NAME="" onFocus="animate(event)" onBlur="stopit()" >
<INPUT TYPE="radio" NAME="" onFocus="animate(event)" onBlur="stopit()" >
<INPUT TYPE="checkbox" NAME="" onFocus="animate(event)" onBlur="stopit()" >
<INPUT TYPE="checkbox" NAME="" onFocus="animate(event)" onBlur="stopit()" >
<INPUT TYPE="checkbox" NAME="" onFocus="animate(event)" onBlur="stopit()" >
<BR>
<TEXTAREA NAME="" ROWS="10" COLS="50" onFocus="animate(event)" onBlur="stopit()">
이곳을 클릭 해 보세요
각 폼태그에
onFocus="animate(event)" onBlur="stopit()" 
를 넣어 주세요
</TEXTAREA>
<BR>
<INPUT TYPE="reset" onFocus="animate(event)" onBlur="stopit()" >
<INPUT TYPE="submit" onFocus="animate(event)" onBlur="stopit()" >
<INPUT TYPE="password" onFocus="animate(event)" onBlur="stopit()" >
</FORM>
<!------------------------- 여기까지 ----------------------------------> 
 






35    현재 페이지 이메일로 보내는 버튼 만들기

 
<!---- 아래의 방법으로 원하는 위치에 복사 해 넣으세요 ------------------>
<SCRIPT LANGUAGE="JavaScript">
<!--
function EmailLink(){
window.location = "mailto:"+"?subject=이 사이트를 참고 해 보세요" + "&body="+document.title+"  "+window.location;
}
document.write('<INPUT TYPE="button" VALUE="추천하기" onClick="EmailLink()"></FORM>')
//-->
</SCRIPT>
<!------------------------- 여기까지 ---------------------------------->
 
 






34    원하는 사람에게 메일 보내기 버튼 만들기

 
<!---- [1단계] 아래의 소스코드를 <HEAD>와 </HEAD> 사이에 붙여 넣으세요 ---->
<SCRIPT LANGUAGE="JavaScript">
<!--
function mailsome1(){
who=prompt("받는사람의 이메일 주소 : ","nobody@domain.com");
what=prompt("제목 : ","안녕하세요");
if (confirm(who+" 님께 " + what + " 의 제목으로 발송할까요?")==true){
parent.location.href='mailto:'+who+'?subject='+what+'';
   }
}
//-->
</SCRIPT>
<!------------------------- 여기까지 ---------------------------------->
</HEAD>
<BODY>
<!---- [2단계] 아래의 방법으로 원하는 위치에 복사 해 넣으세요 ------------------>
<a href='javascript:mailsome1()'>메일 보내기</a>
<input type=button value="메일 보내기" onClick="mailsome1()">
<!------------------------- 여기까지 ---------------------------------->
 
 






33    동의하지 않으면 버튼을 누를수 없습니다  

 
<!---- [1단계] 아래의 소스코드를 <HEAD>와 </HEAD> 사이에 붙여 넣으세요 ---->
<script>
var checkobj
function agreesubmit(el){
checkobj=el
if (document.all||document.getElementById){
for (i=0;i<checkobj.form.length;i++){  
var tempobj=checkobj.form.elements[i]
if(tempobj.type.toLowerCase()=="submit")
tempobj.disabled=!checkobj.checked
}
}
}
function defaultagree(el){
if (!document.all&&!document.getElementById){
if (window.checkobj&&checkobj.checked)
return true
else{
alert("동의 하지 않으면 버튼을 클릭 할 수 없습니다")
return false
}
}
}
</script>
<!------------------------- 여기까지 ---------------------------------->
</HEAD>
<BODY>
<!---- [2단계] 아래의 방법으로 원하는 위치에 복사 해 넣으세요 ------------------>
<p>
<form name="agreeform" onSubmit="return defaultagree(this)">
<textarea cols=30 rows=5>
나는 자랑스런 태극기 앞에
조국과 민족의 영광을 위하여
몸과 마음을 바쳐 충성을 다할것을
굳게 다짐 합니다
</textarea>
<p>
<input name="agreecheck" type="checkbox" onClick="agreesubmit(this)"><b>예, 동의 합니다</b>
<input type="Submit" value=" 확 인 " disabled>
</form>
<script>
document.forms.agreeform.agreecheck.checked=false
</script>
<!------------------------- 여기까지 ---------------------------------->
 
 






32    텍스트 영역에서 입력 글자(단어)수를 제한 합니다  

 
<!---- [1단계] 아래의 소스코드를 <HEAD>와 </HEAD> 사이에 붙여 넣으세요 ---->
<SCRIPT LANGUAGE="JavaScript">
<!--
   var submitcount=0;
   function checkSubmit() {
      if (submitcount == 0)      {
      submitcount++;
      document.myForm.submit();
      }
   }
function wordCounter(field, countfield, maxlimit) {
wordcounter=0;
for (x=0;x<field.value.length;x++) {
      if (field.value.charAt(x) == " " && field.value.charAt(x-1) != " ")  {wordcounter++}
      if (wordcounter > 250) {field.value = field.value.substring(0, x);}
      else {countfield.value = maxlimit - wordcounter;}
      }
   }
function textCounter(field, countfield, maxlimit) {
  if (field.value.length > maxlimit)      {
  field.value = field.value.substring(0, maxlimit);
  }
      else      {
          countfield.value = maxlimit - field.value.length;
          }
  }
//-->
</script>
<!------------------------- 여기까지 ---------------------------------->
</HEAD>
<BODY>
<!---- [2단계] 아래의 방법으로 원하는 위치에 복사 해 넣으세요 ------------------>
<FORM NAME=myForm>
<p><B>10 단어 이내로만 작성 해 주세요</B>
<p><textarea name="tx1" cols="40" rows="5" wrap="hard" onKeyDown="wordCounter(this.form.tx1,this.form.remLen,10);" onKeyUp="wordCounter(this.form.tx1,this.form.remLen,10);"></textarea>
<p>남은 단어 수 : <input type=box readonly name=remLen size=3 value=10>
<p><B>10 글자 이내로 작성 해 주세요</B>
<p><textarea name="tx2" cols="40" rows="5" wrap="hard" onKeyDown="textCounter(this.form.tx2,this.form.remLentext,10);" onKeyUp="textCounter(this.form.tx2,this.form.remLentext,10);"></textarea>
<p>남은 글자 수 : <input type=box readonly name=remLentext size=3 value=10>
<p>
<INPUT TYPE="button" VALUE="확인" onclick='' name=submit1>
<INPUT TYPE="reset" VALUE="다시 쓰기" id=reset1 name=reset1>
</FORM>
<!------------------------- 여기까지 ---------------------------------->
 
 






31    뒤에 붙는 불필요한 공백 문자열을 없애줍니다 

 
<p>아래의 간단한 코드는 파일이름.txt 뒤에 붙는 불필요한 공백들을 없애줍니다
<p>
<form action=http://www.mybizs.com>
파일명 :  
<input type=text name=filename size=40 value="파일이름.txt" onChange="javascript:while(''+this.value.charAt(this.value.length-1)==' ')this.value=this.value.substring(0,this.value.length-1);">
<input type=submit value=" 확인 ">
</form> 
 






30    앞에 붙는 불필요한 공백문자열을 지워 줍니다 

<BODY>
<p>아래의 간단한 코드는 파일이름.txt 앞에 붙는 불필요한 공백들을 없애줍니다<br>
테스트 하시려면 file.txt 앞에 공백을 입력 한 후 버튼을 눌러보세요
<p>
<form action=http://www.jasko.co.kr/result.html>
파일이름 :  <input type=text name=filename size=40 value="file.txt" onChange="javascript:while(''+this.value.charAt(0)==' ')this.value=this.value.substring(1,this.value.length);"><br>
<input type=submit value="확인">
</form>
</BODY>
 
 






29    특정 파일형태만 업로드 할 수 있습니다  

 
<!---- [1단계] 아래의 소스코드를 <HEAD>와 </HEAD> 사이에 붙여 넣으세요 ---->
<SCRIPT LANGUAGE="JavaScript">
<!-- 
extArray = new Array(".gif", ".jpg", ".png");
function LimitAttach(form, file) {
allowSubmit = false;
if (!file) return;
while (file.indexOf("\\") != -1)
file = file.slice(file.indexOf("\\") + 1);
ext = file.slice(file.indexOf(".")).toLowerCase();
for (var i = 0; i < extArray.length; i++) {
if (extArray[i] == ext) { allowSubmit = true; break; }
}
if (allowSubmit) form.submit();
else
alert("아래 형태의 파일만 업로드 할 수 있습니다:  " 
+ (extArray.join("  ")) + "\n다시 선택 해 주세요");
}
//-->
</script>
<!------------------------- 여기까지 ---------------------------------->
</HEAD>
<BODY>
<center>
아래 파일들만 업로드 할 수 있습니다
<script>
document.write(extArray.join("  "));
</script>
<p>
<!------------------------- 여기까지 ---------------------------------->
<form method=post name=upform action="../../result,html" enctype="multipart/form-data">
<input type=file name=uploadfile>
<p>
<input type=button name="Submit" value=" 전송 " onclick="LimitAttach(this.form, this.form.uploadfile.value)">
</form>
<!------------------------- 여기까지 ---------------------------------->
</center>
 
 






28    유효한 IP 주소인지 검사합니다  

 
<!---- [1단계] 아래의 소스코드를 <HEAD>와 </HEAD> 사이에 붙여 넣으세요 ---->
<SCRIPT LANGUAGE="JavaScript">
<!-- 
function verifyIP (IPvalue) {
errorString = "";
theName = "IPaddress";
var ipPattern = /^(\d{1,3})\.(\d{1,3})\.(\d{1,3})\.(\d{1,3})$/;
var ipArray = IPvalue.match(ipPattern); 
if (IPvalue == "0.0.0.0")
errorString = errorString + theName + ': '+IPvalue+' 은 좀 특별한 주소군요. 여기서는 사용할 수 없습니다';
else if (IPvalue == "255.255.255.255")
errorString = errorString + theName + ': '+IPvalue+' 은 좀 특별한 주소군요. 여기서는 사용할 수 없습니다';
if (ipArray == null)
errorString = errorString + theName + ': '+IPvalue+' 는 잘못된 주소 입니다';
else {
for (i = 0; i < 4; i++) {
thisSegment = ipArray[i];
if (thisSegment > 255) {
errorString = errorString + theName + ': '+IPvalue+' 은 잘못된 주소 입니다';
i = 4;
}
if ((i == 0) && (thisSegment > 255)) {
errorString = errorString + theName + ': '+IPvalue+' 은 좀 특별한 주소군요. 여기서는 사용할 수 없습니다';
i = 4;
      }
   }
}
extensionLength = 3;
if (errorString == "")
alert ("주소를 맞게 입력 하셨군요");
myForm.sybmit();
else
alert (errorString);
}
//-->
</script>
<!------------------------- 여기까지 ---------------------------------->
<!---- [2단계] 아래의 방법으로 원하는 위치에 복사 해 넣으세요 ------------------>
<form name=myForm action="../../result.html">
IP 주소를 입력 하세요 :
<input size=15 name="IPvalue">
<input type="submit" value=" 확인 " onClick="verifyIP(IPvalue.value)";>
</form>
<!------------------------- 여기까지 ---------------------------------->
 
 






27    탭키 대신 엔터키를 눌러 이동합니다

 
<!---- [1단계] 아래의 소스코드를 <HEAD>와 </HEAD> 사이에 붙여 넣으세요 ---->
<SCRIPT LANGUAGE="JavaScript">
<!-- 
nextfield = "box1"; // 첫번째 상자의 이름
netscape = "";
ver = navigator.appVersion; len = ver.length;
for(iln = 0; iln < len; iln++) if (ver.charAt(iln) == "(") break;
netscape = (ver.charAt(iln+1).toUpperCase() != "C");
function keyDown(DnEvents) { 
k = (netscape) ? DnEvents.which : window.event.keyCode;
if (k == 13) { 
if (nextfield == 'done') return true; 
else { 
eval('document.myForm.' + nextfield + '.focus()');
return false;
      }
   }
}
document.onkeydown = keyDown; 
if (netscape) document.captureEvents(Event.KEYDOWN|Event.KEYUP);
//-->
</script>
<!------------------------- 여기까지 ---------------------------------->
</HEAD>
<BODY>
<!---- [2단계] 아래의 방법으로 원하는 위치에 복사 해 넣으세요 ------------------>
<p align=center><b>각 항목을 입력 한 후 엔터키를 눌러 보세요</b>
<form name=myForm action="../../result.html">
성별: <input type=text name=box1 onFocus="nextfield ='box2';"><br>
이름: <input type=text name=box2 onFocus="nextfield ='box3';"><br>
별명: <input type=text name=box3 onFocus="nextfield ='box4';"><br>
나이: <input type=text name=box4 onFocus="nextfield ='done';"><br>
<input type=submit name=done value="확인">
</form>
</center>
<!------------------------- 여기까지 ----------------------------------> 
 






26    전송버튼에 '전송중...' 이라는 표시를 해 줍니다 

<!---- [1단계] 아래의 소스코드를 <HEAD>와 </HEAD> 사이에 붙여 넣으세요 ---->
<SCRIPT LANGUAGE="JavaScript">
<!-- 
function submitForm(s)  {
s.value = "  전송중...  ";
return true;
}
// -->
</script>
<!------------------------- 여기까지 ---------------------------------->
</HEAD>
<BODY>
<!---- [2단계] 아래의 방법으로 원하는 위치에 복사 해 넣으세요 ------------------>
<center>
<form name=myform onSubmit="return submitForm(this.submitbutton)">
이름 :  <input type=text name=firstname size=20>
<input type=submit name=submitbutton value="보낼께요">
</form>
</center>
<!------------------------- 여기까지 ---------------------------------->
 
 






25    사용자가 table sort 시키기   

 
<!---- [1단계] 아래의 소스코드를 <HEAD>와 </HEAD> 사이에 붙여 넣으세요 ---->
<SCRIPT LANGUAGE="JavaScript">
<!-- 
function setDataType(cValue)
  {
    var isDate = new Date(cValue);
    if (isDate == "NaN")
      {
        if (isNaN(cValue))
          {
            cValue = cValue.toUpperCase();
            return cValue;
          }
        else
          {
            var myNum;
            myNum = String.fromCharCode(48 + cValue.length) + cValue;
            return myNum;
          }
        }
  else
      {
        var myDate = new String();
        myDate = isDate.getFullYear() + " " ;
        myDate = myDate + isDate.getMonth() + " ";
        myDate = myDate + isDate.getDate(); + " ";
        myDate = myDate + isDate.getHours(); + " ";
        myDate = myDate + isDate.getMinutes(); + " ";
        myDate = myDate + isDate.getSeconds();
        return myDate ;
      }
  }
function sortTable(col, tableToSort)
  {
    var iCurCell = col + tableToSort.cols;
    var totalRows = tableToSort.rows.length;
    var bSort = 0;
    var colArray = new Array();
    var oldIndex = new Array();
    var indexArray = new Array();
    var bArray = new Array();
    var newRow;
    var newCell;
    var i;
    var c;
    var j;
    for (i=1; i < tableToSort.rows.length; i++)
      {
        colArray[i - 1] = setDataType(tableToSort.cells(iCurCell).innerText);
        iCurCell = iCurCell + tableToSort.cols;
      }
    for (i=0; i < colArray.length; i++)
      {
        bArray[i] = colArray[i];
      }
    colArray.sort();
    for (i=0; i < colArray.length; i++)
      { 
        indexArray[i] = (i+1);
        for(j=0; j < bArray.length; j++)
          { 
            if (colArray[i] == bArray[j])
              {  
                for (c=0; c<i; c++)
                  {
                    if ( oldIndex[c] == (j+1) )
                    {
                      bSort = 1;
                    }
                      }
                      if (bSort == 0)
                        {
                          oldIndex[i] = (j+1);
                        }
                          bSort = 0;
                        }
          }
    }
  for (i=0; i<oldIndex.length; i++)
    {
      newRow = tableToSort.insertRow();
      for (c=0; c<tableToSort.cols; c++)
        {
          newCell = newRow.insertCell();
          newCell.innerHTML = tableToSort.rows(oldIndex[i]).cells(c).innerHTML;
        }
      }
  for (i=1; i<totalRows; i++)
    {
      tableToSort.moveRow((tableToSort.rows.length -1),1);
    }
  for (i=1; i<totalRows; i++)
    {
      tableToSort.deleteRow();
    }
  }
// -->
</script>
<!------------------------- 여기까지 ---------------------------------->
</HEAD>
<BODY>
<!---- [2단계] 아래의 방법으로 원하는 위치에 복사 해 넣으세요 ------------------>
<table width="95%" border=1 cellspacing=1 cellpadding=1 name="rsTable" id=rsTable  cols=5>
  <tr bgcolor=#FF9900> 
    <td> 
      <div align="center"><a href="javascript:sortTable(0, rsTable);"><font color=white><b>번호</b></font></a></div>
    </td>
    <td> 
      <div align="center"><a href="javascript:sortTable(1, rsTable);"><font color=white><b>이름</b></font></a></div>
    </td>
    <td> 
      <div align="center"><a href="javascript:sortTable(2, rsTable);"><font color=white><b>생년월일</b></font></a></div>
    </td>
    <td> 
      <div align="center"><a href="javascript:sortTable(3, rsTable);"><font color=white><b>전화번호</b></font></a></div>
    </td>
    <td> 
      <div align="center"><a href="javascript:sortTable(4, rsTable);"><font color=white><b>비고</b></font></a></div>
    </td>
  </tr>
  <tr> 
    <td> 
      <div align="center">1</div>
    </td>
    <td> 
      <div align="center">홍길동</div>
    </td>
    <td> 
      <div align="center">4/9/72</div>
    </td>
    <td> 
      <div align="center">763-555-1212</div>
    </td>
    <td> 
      <div align="center">REVIEW</div>
    </td>
  </tr>
  <tr> 
    <td> 
      <div align="center">2</div>
    </td>
    <td> 
      <div align="center">이몽룡</div>
    </td>
    <td> 
      <div align="center">9/3/63</div>
    </td>
    <td> 
      <div align="center">215-555-1400</div>
    </td>
    <td> 
      <div align="center">SAME</div>
    </td>
  </tr>
  <tr> 
    <td> 
      <div align="center">3</div>
    </td>
    <td> 
      <div align="center">전지현</div>
    </td>
    <td> 
      <div align="center">3/4/71</div>
    </td>
    <td> 
      <div align="center">612-555-0987</div>
    </td>
    <td> 
      <div align="center">REVIEW</div>
    </td>
  </tr>
  <tr> 
    <td> 
      <div align="center">4</div>
    </td>
    <td> 
      <div align="center">이수만</div>
    </td>
    <td> 
      <div align="center">8/2/71</div>
    </td>
    <td> 
      <div align="center">215-555-7654</div>
    </td>
    <td> 
      <div align="center">SAME</div>
    </td>
  </tr>
  <tr> 
    <td> 
      <div align="center">5</div>
    </td>
    <td> 
      <div align="center">신돌석</div>
    </td>
    <td> 
      <div align="center">3/28/70</div>
    </td>
    <td> 
      <div align="center">763-555-8295</div>
    </td>
    <td> 
      <div align="center">REVIEW</div>
    </td>
  </tr>
  <tr> 
    <td> 
      <div align="center">6</div>
    </td>
    <td> 
      <div align="center">최민수</div>
    </td>
    <td> 
      <div align="center">2/28/29</div>
    </td>
    <td> 
      <div align="center">612-555-1338</div>
    </td>
    <td> 
      <div align="center">REVIEW</div>
    </td>
  </tr>
  <tr> 
    <td> 
      <div align="center">7</div>
    </td>
    <td> 
      <div align="center">정애리</div>
    </td>
    <td> 
      <div align="center">12/31/00</div>
    </td>
    <td> 
      <div align="center">610-555-0987</div>
    </td>
    <td> 
      <div align="center">SAME</div>
    </td>
  </tr>
  <tr> 
    <td> 
      <div align="center">8</div>
    </td>
    <td> 
      <div align="center">하리수</div>
    </td>
    <td> 
      <div align="center">4/1/70</div>
    </td>
    <td> 
      <div align="center">000-555-9099</div>
    </td>
    <td> 
      <div align="center">SAME</div>
    </td>
  </tr>
  <tr> 
    <td> 
      <div align="center">9</div>
    </td>
    <td> 
      <div align="center">토마토</div>
    </td>
    <td> 
      <div align="center">1/1/30</div>
    </td>
    <td> 
      <div align="center">613-555-1338</div>
    </td>
    <td> 
      <div align="center">DIFFERENT</div>
    </td>
  </tr>
  <tr> 
    <td> 
      <div align="center">10</div>
    </td>
    <td> 
      <div align="center">111222</div>
    </td>
    <td> 
      <div align="center">2/2/01</div>
    </td>
    <td> 
      <div align="center">345-555-7654</div>
    </td>
    <td> 
      <div align="center">DIFFERENT</div>
    </td>
  </tr>
  <tr> 
    <td> 
      <div align="center">11</div>
    </td>
    <td> 
      <div align="center">Doraemon</div>
    </td>
    <td> 
      <div align="center">3/13/74</div>
    </td>
    <td> 
      <div align="center">215-555-4043</div>
    </td>
    <td> 
      <div align="center">DIFFERENT</div>
    </td>
  </tr>
</table>
<!------------------------- 여기까지 ---------------------------------->
 
 







24    레이어를 사용하여 select box 를 동적으로 생성합니다  

 
<!---- [1단계] 아래의 소스코드를 <HEAD>와 </HEAD> 사이에 붙여 넣으세요 ---->

<!---------- 서브 카테고리가 보여질 레이어의 위치를 설정 하세요--->
<style>
#sub1, #sub2, #sub3
{ position: absolute;left: 180px;visibility: hidden;z-index: 3}
</style>
<SCRIPT LANGUAGE="JavaScript">
<!--
catnumber = 3 // 카테고리의 갯수 설정
offset = 150 
performOnchange = false
if (document.all) {
  docObj = "document.all."
  styleObj = ".style"
  } else {
  docObj = "document."
  styleObj = ""
}
function openselect(subcat) {
  popupselect = eval(docObj + subcat + styleObj)
  popupselect.visibility = "visible"
}
function closeselect(submenu,subcat){
  popupselect = eval(docObj + subcat + styleObj)
  if (submenu.selectedIndex != 0) {
    popupselect.visibility = "hidden"
    numchoice = submenu.selectedIndex
    choice = submenu[numchoice].value
    myForm.subcategory.value = choice
    submenu.selectedIndex = 0
  }
}
function lock() {
  performOnchange = false
}
function unlock() {
  performOnchange = true
}
function selectSub(cat) {
  for (i=1; i <= catnumber; i++) {
    subcat = "sub" + i
    popupselect = eval(docObj + subcat + styleObj)
    popupselect.visibility = "hidden"
  }
  if (performOnchange == true) {
    letsopen = "sub" + cat.selectedIndex
    if (letsopen == "sub0") {
      alert("카테고리를 선택 해 주세요")
      choice = "- 서브 카테고리 -"
      myForm.subcategory.value = choice
      cat.focus()
      } else {
      openselect(letsopen)
      lock()
    }
  }
}
// -->
</script>
<!------------------------- 여기까지 ---------------------------------->
</HEAD>
<BODY>
<!---- [2단계] 아래의 방법으로 원하는 위치에 복사 해 넣으세요 ------------------>
<!---- 첫번째 서브 카테고리 설정 ----->
<span id="sub1">
  <select name="sub_singer" onchange="closeselect(this,'sub1')">
    <option selected value="">- 서브 카테고리 -
    <option value="조용필">조용필
    <option value="이수미">이수미
    <option value="한경애">한경애
  </select>
</span>
<!---- 두번째 서브 카테고리 설정 ----->
<span id="sub2">
  <select name="sub_hobby" onchange="closeselect(this,'sub2')">
    <option selected value="">- 서브 카테고리 -
    <option value="클래식 감상">클래식 감상
    <option value="우표수집">우표수집
    <option value="색칠하기">색칠하기
  </select>
</span>
<!---- 세번째 서브 카테고리 설정 ----->
<span id="sub3">
  <select name="sub_int" onchange="closeselect(this,'sub3')">
    <option selected value="">- 서브 카테고리 -
    <option value="php">php
    <option value="java">java
    <option value="asp">asp
    <option value="mysql">mysql
  </select>
</span>
<!---- 메인 카테고리 설정 ----->
  <select name="main_category" onmouseover="unlock()" onchange="selectSub(this)">
    <option selected value="">-- 카테고리 선택 --
    <option value="좋아하는 가수">좋아하는 가수
    <option value="취미">취미
    <option value="관심분야">관심분야
  </select>
  
  
<p>
<form name=myForm action="http://www.mybizs.com">
<input type="text" name="subcategory" readonly="readonly" value="- 서브 카테고리 -">
<input type=submit value=" 전송 ">
<!------------------------- 여기까지 ---------------------------------->
 
 


  





23    폼요소가 하이라이트 됩니다   

 
<!---- [1단계] 아래의 소스코드를 <HEAD>와 </HEAD> 사이에 붙여 넣으세요 ---->
<script language="JavaScript1.2">
var highlightcolor="yellow" // 하이라이트 색상을 설정 하세요
var ns6=document.getElementById&&!document.all
var previous=''
var eventobj
var intended=/INPUT|TEXTAREA|SELECT|OPTION/; // 적용할 폼 요소
function checkel(which){
if (which.style&&intended.test(which.tagName)){
if (ns6&&eventobj.nodeType==3)
eventobj=eventobj.parentNode.parentNode
return true
}
else
return false
}
function highlight(e){
eventobj=ns6? e.target : event.srcElement
if (previous!=''){
if (checkel(previous))
previous.style.backgroundColor=''
previous=eventobj
if (checkel(eventobj))
eventobj.style.backgroundColor=highlightcolor
}
else{
if (checkel(eventobj))
eventobj.style.backgroundColor=highlightcolor
previous=eventobj
}
}
</script>
<!------------------------- 여기까지 ---------------------------------->
</HEAD>
<BODY>
<!---- [2단계] FORM 태그안에 onClick="highlight(event)" 를 아래의 방법으로 복사 해 넣으세요 ------------------>
<FORM name=myForm onClick="highlight(event)" action="../../result.html">
이름 :<INPUT TYPE="text" NAME=""><p>
<SELECT NAME="sel">
<option value="">항목을 선택하세요
<option value="">첫번째 항목
<option value="">두번째 항목
</SELECT><br>
<INPUT TYPE="radio" NAME="r">라디오1
<INPUT TYPE="radio" NAME="r">라디오2<p>
<INPUT TYPE="checkbox" NAME="c1">체크박스1
<INPUT TYPE="checkbox" NAME="c2">체크박스2<p>
의견을 적어주세요<br>
<TEXTAREA NAME="Comment" ROWS="" COLS=""></TEXTAREA><p>
<INPUT TYPE="submit">
</FORM>
 
 






22    입력 문자열 앞에 붙는 공백 제거하기

 
<!---- [1단계] 아래의 소스코드를 <HEAD>와 </HEAD> 사이에 붙여 넣으세요 ---->
<script> 
var reg = /\s+/g; 
function trim(str){ 
return str.replace(reg,''); 
} 
</script>
<!------------------------- 여기까지 ---------------------------------->
</HEAD>
<!---- [2단계] 아래의 방법으로 원하는 위치에 복사 해 넣으세요 ------------------>
<BODY>
<FORM name="F" action="http://www.mybizs.com" onsubmit="trim(this.T.value)">
<INPUT TYPE="text" NAME="T">
<INPUT TYPE="submit">
</FORM>
<!------------------------- 여기까지 ---------------------------------->
 
 






21    입력필드에 내용을 입력하면 아래쪽에 큰 글자로 보여줍니다  

 
<!-- [1단계] 아래의 스크립트를 HEAD 부분에 붙여 넣으세요 ---------->
<script language=javaScript>
<!-- 
var message = ""
function showresult() {                
    if(document.all) {
        message=document.forms[0].elements[0].value
        firstfont.innerHTML=message
        secondfont.innerHTML=message
        }
        var timer=setTimeout("showresult()",300) 
}
// -->
</script>
</HEAD>
<!-- [2단계] 아래의 태그를 <BODY> 태그안에 붙여 넣으세요 ------------->
<body onLoad="showresult()">
<!--- [3단계] ---- 아래의 코드를 BODY 부분에 붙여 넣으세요 ------------->
<div id="formdiv" style="position:absolute;visibility:visible;top:10px; left:20px">
        <form name="formname" action="http://www.mybizs.com">
                <table cellpadding=2 border=2 width=400>
                <tr>
                <td bgcolor=orange align=middle valign=middle>
                <font size=2 face=굴림 color=FFFFFF>
                <b>입력 해 주세요</b><br>
                <input name="inputname" type="text" size="30">
                <input type=submit>
                </td>
                </tr>
                </table>
        </form>
</div>
<div id="secondfont" style="position:absolute;visibility:visible;top:150px;left:10px;font-family:Verdana;font-size:40pt;color:FFCCCC;filter:glow(color:FFFFCC,strength:2) blur() flipV()"> </div>
<div id="firstfont" style="position:absolute;visibility:visible;top:100px;left:10px;font-family:Verdana;font-size:40pt;color:FF0000; filter:glow(color:FFFF00,strength:3) blur()"> </div>
<!---- 여기까지 ------------------------------------------>
 
 






20    자바스크립트로 폼 입력값 전송받기 

 
대부분의 폼을 전송할때 보통은 CGI 프로그램을 사용하지만 HTML 에서 get 방식으로 폼을 전송하면 자바스크립트로 그 값을 받을 수 있습니다.
아래 예제는 폼전송 양식과 폼값을 받는 문서의 예제입니다
-----------------------------
전송 문서 (send.html)
-----------------------------
<HTML>
<HEAD>
</HEAD>
<BODY>
<FORM name=form1 ACTION="result.html">
<INPUT TYPE="checkbox" NAME="check1" value="first_value">첫번째항목
<INPUT TYPE="checkbox" NAME="check2" value="second_value">두번째항목
<INPUT TYPE="checkbox" NAME="check3" value="third_value">세번째항목
<INPUT TYPE="submit">
</FORM>
</BODY>
</HTML>
-----------------------------
출력 문서 (result.html)
-----------------------------
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<!-- [1단계] 아래의 스크립트를 HEAD 부분에 붙여 넣으세요 ---------->
<script>
<!--
var myValueIn = unescape(location.search.replace(/\+/g,' '));
myValueIn = myValueIn.substring(1).split('&');
for(i=0;i<myValueIn.length;i++)
        myValueIn[i] = myValueIn[i].split('=');
var myValueOut = "<h3>아래 내용으로 전송 되었습니다</h3><hr>\n<table border=1>";
myValueOut += "<tr><th>name</th><th>value</th></tr>";
for(i=0;i<myValueIn.length;i++){
  myValueOut += "<tr>\n";
  myValueOut += "\t<td align=right><b>"+myValueIn[i][0]+"</b>: </td>\n";
  myValueOut += "\t<td>"+myValueIn[i][1]+"</td>\n";
  myValueOut += "</tr>\n";
}
myValueOut += "</table>\n";
//-->
</script>
<body>
<!-- [2단계] 출력할 위치에 아래의 스크립트를 붙여 넣으세요 ------------>
<script>
document.write(myValueOut);
</script>
<p>
<p align=right><b><i>http://www.mybizs.com</i></b>
</body>
</html> 
 


  





19    팝업 윈도우로 변수값 넘기기

 
*************
parse2.html
*************
<html>
<head>
<meta http-equiv=content-type content=text/html; charset=euc-kr>
<!---- [1단계] 아래의 스크립트를 HEAD 부분에 복사 해 넣으세요 ----->
<script language="javascript">
<!--
// 도큐먼트의 form 값 파싱함수
function parse(form) {
resultWin=window.open("pop2.html",'pop','width=500,height=300'); // 팝업창 pop2.html 로 submit
}
//-->
</script>
<!--------------------------- 여기까지 ---------------------------->
</head>
<body>
<!---- [2단계] 아래와 같은 방법으로 태그와 코드를 복사 해 넣으세요 --->
<form name="form1" method=post onsubmit="parse(this); return false;">
<input type="text" name="text1">
<input type="text" name="text2">
<input type="submit" name=submit value="전송버튼">
</form>
<!--------------------------- 여기까지 ---------------------------->
</body>
</html>
*************
pop2.html
*************
<html>
<head>
<!---- [1단계] 아래의 스크립트를 HEAD 부분에 복사 해 넣으세요 ----->
<SCRIPT LANGUAGE="JavaScript"> 
<!-- 
// 오프너에서 전송된 값을 현 도큐먼트의 폼값에 뿌려주는 함수
function parse2() { 
// 오프너의 폼요소를 o_element 변수에 대입
var o_element =window.opener.document.forms[0].elements; 
// 현재 도큐먼트의 폼요소를 p_element 변수에 대입
var p_element =document.forms[0].elements; 
// 오프너의 폼요소 갯수만큼 읽어와 현재 도큐먼트 폼 요소 값으로 대입
for(i=0;i<o_element.length;i++)
        p_element[i].value = o_element[i].value; 
} 
//--> 
</script> 
<!--------------------------- 여기까지 ---------------------------->
</HEAD> 
<!---- [2단계] <BODY> 태그안에 아래와 같이 코드를 붙여 넣으세요 ----->
<BODY onLoad="parse2()"> 
<!---- [3단계] BODY 부분에 아래와 같은 방법으로 태그와 코드를 복사 해 넣으세요 --->
<form name="form1" method=post action="http://www.mybizs.com">
<input type="text" name="text1">
<input type="text" name="text2">
<input type="submit" name="submit1" value=" 전송 ">
</form>
<!--------------------------- 여기까지 ---------------------------->
</BODY> 
</HTML>  
 


  





18    3단계의 콤보상자에 오늘의 연월일을 자동으로 나타내 줍니다

 
<!---- [1단계] 아래의 스크립트를 HEAD 부분에 복사 해 넣으세요 ----->
<SCRIPT language="JavaScript">
Now = new Date();
NowDay = Now.getDate();
NowMonth = Now.getMonth();
NowYear = Now.getYear();
if (NowYear < 2000) NowYear += 1900; //for Netscape
function DaysInMonth(WhichMonth, WhichYear)
{
        var DaysInMonth = 31;
        if (WhichMonth == "4월" || WhichMonth == "6월" || WhichMonth == "9월" || WhichMonth == "11월") DaysInMonth = 30;
        if (WhichMonth == "2월" && (WhichYear/4) != Math.floor(WhichYear/4))        DaysInMonth = 28;
        if (WhichMonth == "2월" && (WhichYear/4) == Math.floor(WhichYear/4))        DaysInMonth = 29;
        return DaysInMonth;
}
function ChangeOptionDays(Which)
{
        DaysObject = eval("document.Form1." + Which + "Day");
        MonthObject = eval("document.Form1." + Which + "Month");
        YearObject = eval("document.Form1." + Which + "Year");
        Month = MonthObject[MonthObject.selectedIndex].text;
        Year = YearObject[YearObject.selectedIndex].text;
        DaysForThisSelection = DaysInMonth(Month, Year);
        CurrentDaysInSelection = DaysObject.length;
        if (CurrentDaysInSelection > DaysForThisSelection)
        {
                for (i=0; i<(CurrentDaysInSelection-DaysForThisSelection); i++)
                {
                        DaysObject.options[DaysObject.options.length - 1] = null
                }
        }
        if (DaysForThisSelection > CurrentDaysInSelection)
        {
                for (i=0; i<(DaysForThisSelection-CurrentDaysInSelection); i++)
                {
                        NewOption = new Option(DaysObject.options.length + 1);
                        DaysObject.add(NewOption);
                }
        }
        if (DaysObject.selectedIndex < 0) DaysObject.selectedIndex == 0;
}
function SetToToday(Which)
{
        DaysObject = eval("document.Form1." + Which + "Day");
        MonthObject = eval("document.Form1." + Which + "Month");
        YearObject = eval("document.Form1." + Which + "Year");

        YearObject[0].selected = true;
        MonthObject[NowMonth].selected = true;
        ChangeOptionDays(Which);
        DaysObject[NowDay-1].selected = true;
}
function WriteYearOptions(YearsAhead)
{
        line = "";
        for (i=0; i<YearsAhead; i++)
        {
                line += "<OPTION>";
                line += NowYear + i;
        }
        return line;
}
</SCRIPT>
<!--------------------------- 여기까지 ---------------------------->
</head>
<!---- [2단계] <BODY> 태그안에 아래와 같이 코드를 붙여 넣으세요 ----->
<body onload="SetToToday('FirstSelect');">
<!---- [2단계] 아래와 같은 방법으로 태그와 코드를 복사 해 넣으세요 --->
<FORM name="Form1" action="http://www.mybizs.com">
<SELECT name="FirstSelectYear" onchange="ChangeOptionDays('FirstSelect')">
<SCRIPT language="JavaScript">document.write(WriteYearOptions(50));</SCRIPT>
</SELECT>
<SELECT name="FirstSelectMonth" onchange="ChangeOptionDays('FirstSelect')">
        <OPTION>1월
        <OPTION>2월
        <OPTION>3월
        <OPTION>4월
        <OPTION>5월
        <OPTION>6월
        <OPTION>7월
        <OPTION>8월
        <OPTION>9월
        <OPTION>10월
        <OPTION>11월
        <OPTION>12월
</SELECT>
<SELECT name="FirstSelectDay">
        <OPTION>1
        <OPTION>2
        <OPTION>3
        <OPTION>4
        <OPTION>5
        <OPTION>6
        <OPTION>7
        <OPTION>8
        <OPTION>9
        <OPTION>10
        <OPTION>11
        <OPTION>12
        <OPTION>13
        <OPTION>14
        <OPTION>15
        <OPTION>16
        <OPTION>17
        <OPTION>18
        <OPTION>19
        <OPTION>20
        <OPTION>21
        <OPTION>22
        <OPTION>23
        <OPTION>24
        <OPTION>25
        <OPTION>26
        <OPTION>27
        <OPTION>28
        <OPTION>29
        <OPTION>30
        <OPTION>31
</SELECT>
<input type="submit" name="submit1" value=" 전송 ">
</FORM>
<!--------------------------- 여기까지 ---------------------------->
 
 






17    폼필드에 입력할 수 있는 글자의 수를 제한 합니다  

<!---- [1단계] 아래의 스크립트를 HEAD 부분에 복사 해 넣으세요 ----->
<script>
function enforcechar(what,limit){
if (what.value.length>=limit)
return false
}
</script>
<!--------------------------- 여기까지 ---------------------------->
</head>
<body>
<!---- [2단계] 아래와 같은 방법으로 태그와 코드를 복사 해 넣으세요 --->
<p>10자까지만 입력할 수 있습니다<br>
<input type="text" size=15 onkeypress="return enforcechar(this, 10)"><br>
<p>20자까지만 입력할 수 있습니다<br>
<textarea cols=60 rows=5 onkeypress="return enforcechar(this, 20)"></textarea><br>
<!--------------------------- 여기까지 ---------------------------->
 
 






16    마우스를 클릭하면 필드의 내용이 모두 선택됩니다

 
<body>
<!---- 원하는 필드에 아래와 같은 방법으로 onfocus="this.select()" 를 복사 해 넣으세요 --->
<textarea name="" rows="5" cols="60" onfocus="this.select()">마우스를 클릭하면 이곳의 텍스트가 모두 선택됩니다</textarea>
<p>
<input type="text" name="text1" size=60 onfocus="this.select()" value="마우스를 클릭하면 이곳의 텍스트가 모두 선택됩니다">
<!--------------------------- 여기까지 ---------------------------->
</body>
 
 






15    텍스트 필드에 디폴트 메세지를 보여주고 클릭하면 사라집니다

 
<!---- [1단계] 아래의 스크립트를 HEAD 부분에 복사 해 넣으세요 ----->
<script>
function clearText(thefield){
if (thefield.defaultValue==thefield.value)
        thefield.value = ""
} 
</script>
<!--------------------------- 여기까지 ---------------------------->
</head>
<body>
<p>마우스를 클릭하면 텍스트가 사라집니다
<!---- [2단계] 아래와 같은 방법으로 태그와 코드를 복사 해 넣으세요 --->
<form>
<input type="text" value="검색어를 입력 하세요" onFocus="clearText(this)">
</form>
<!--------------------------- 여기까지 ---------------------------->
 
 






14    버튼으로 텍스트영역의 크기를 제어합니다  

 
자바스크립트로 textarea 의 rows, cols 속성을 제어하는 스크립트 입니다.
사용자 입력영역을 많이 사용하는 페이지에서 사용자 편의를 향상 시킬수 있습니다
<html>
<head>
<meta http-equiv=content-type content=text/html; charset=euc-kr>
</head>
<body>
<!---- 아래와 같은 방법으로 태그와 코드를 복사 해 넣으세요 --->
<form name="form1" method=post action="http://www.mybizs.com" onsubmit="">
<input type="button" name="button1" onclick="javascript:this.form.area.rows +=1" value=" R++ ">
<input type="button" name="button1" onclick="javascript:this.form.area.rows -=1" value=" R-- ">
<input type="button" name="button1" onclick="javascript:this.form.area.cols +=1" value=" C++ ">
<input type="button" name="button1" onclick="javascript:this.form.area.cols -=1" value=" C-- ">
<p>
<textarea name="area" rows="10" cols="50"></textarea>
</form>

</body>
</html>
 
  





13    이메일 주소가 올바른지 한번더 입력하여 체크합니다 

 
<!---- [1단계] 아래의 스크립트를 복사 해 넣으세요 --->
<script>
var fieldalias="이메일 주소"
function verify(element1, element2){
var passed=false
if (element1.value==''){
alert(fieldalias+"항목을 채워 주세요!")
element1.focus()
}
else if (element2.value==''){
alert(fieldalias+"를 넣어주세요!")
element2.focus()
}
else if (element1.value!=element2.value){
alert(fieldalias+"가 서로 다릅니다")
element1.select()
}
else
passed=true
return passed
}
</script>

<!---- [2단계] 아래와 같은 방법으로 태그와 코드를 복사 해 넣으세요 --->
<!---- return verify(this.첫번째이메일필드명, this.두번째이메일필드명) ---->
<form name=test onSubmit="return verify(this.email_1, this.email_2)">
이메일 : <input type="text" name="email_1"><br>
한번더 : <input type="text" name="email_2"><br>
<input type="submit">
</form>
<!-------------- 여기까지 ---------------->
 
 


  





12    동적으로 생성되는 다이나믹 콤보상자 메뉴

 
<!---- [1단계] BODY 부분에 아래와 같은 방법으로 태그와 코드를 복사 해 넣으세요 --->
<a href="javascript:populate(combo1)">웹마스터</a> | 
<a href="javascript:populate(combo2)">뉴스 사이트</a> | 
<a href="javascript:populate(combo3)">검색엔진</a>
<form name="myCombo">
        <select name="mySel" size="1">
        <option value="#"></option>
        <option value="#"></option>
        <option value="#"></option>
        </select>
<input type="button" name="test" value=" 이동 " onClick="gothere()">
</form>
<!---- [2단계] 아래와 같은 방법으로 메뉴를 설정 하세요 --->
<script>
<!--
var combo1=new Array() // 첫번째 콤보상자
combo1[0]=new Option("htnl","http://www.mybizs.com")
combo1[1]=new Option("자바스크립트","http://www.mybizs.com")
combo1[2]=new Option("자바 애플릿","http://www.mybizs.com")
combo1[3]=new Option("CGI 스크립트","http://www.mybizs.com")
combo1[4]=new Option("ASP / PHP","http://www.mybizs.com")
var combo2=new Array() // 두번째 콤보상자
combo2[0]=new Option("MBC","http://www.imbc.com")
combo2[1]=new Option("KBS","http://www.kbs.co.kr")
combo2[2]=new Option("SBS","http://www.sbs.co.kr")
combo2[3]=new Option("인터넷 조선일보","http://www.chosun.com")
var combo3=new Array() // 세번째 콤보상자
combo3[0]=new Option("다음 커뮤니케이션","http://www.daum.net")
combo3[1]=new Option("드림위즈","http://www.dreamwiz.com")
combo3[2]=new Option("라이코스 코리아","http://www.lycos.co.kr")

var cacheobj=document.myCombo.mySel
function populate(x){
for (m=cacheobj.options.length-1;m>0;m--)
cacheobj.options[m]=null
selectedarray=eval(x)
for (i=0;i<selectedarray.length;i++)
cacheobj.options[i]=new Option(selectedarray[i].text,selectedarray[i].value)
cacheobj.options[0].selected=true
}
function gothere(){
location=cacheobj.options[cacheobj.selectedIndex].value
}
// 디폴트로 보여줄 콤보상자를 지정합니다
populate(combo1)
//-->
</script>
<!-------------- 여기까지 ---------------->
 
 






11    체크박스나 라디오버튼의 모두선택/모두해제 시키는 스크립트  

 
<!---- [1단계] 아래의 스크립트를 HEAD 부분에 복사 해 넣으세요 ----->
<script>
function checkall(formname,checkname,thestate){
var el_collection=eval("document.forms."+formname+"."+checkname)
for (c=0;c<el_collection.length;c++)
el_collection[c].checked=thestate
}
</script>
<!-------------- 여기까지 ---------------->
</head>
<body>
<form name="myForm">
<input type="radio" name="v1"> 라디오버튼
<input type="checkbox" name="v1"> 체크박스-1
<input type="checkbox" name="v1"> 체크박스-2
</form>
<!---- [1단계] BODY 부분에 아래와 같은 방법으로 태그와 코드를 복사 해 넣으세요 --->
<a href="javascript:checkall('myForm','v1',true)">모두선택</a> | 
<a href="javascript:checkall('myForm','v1',false)">모두해제</a>
<!-------------- 여기까지 ---------------->
 
 







10    테이블을 이용한 스프레드시트 시뮬레이션

 
<!---- [1단계] 아래와 같은 방법으로 태그와 코드를 복사 해 넣으세요 --->
<script language="javascript">
<!--
var nCountA=0
var nCountB=0
var nCountC=0
var nCountD=0
var nCountE=0
var nSumA=0
var nSumB=0
var nSumC=0
var nSumD=0
var nSume=0
function addItA() { // A 열 합계 계산
nCountA=0
var nA1=parseFloat(window.document.ss.A1.value)
if (nA1/1!==nA1) {nA1=0} else {nCountA++}
var nA2=parseFloat(window.document.ss.A2.value)
if (nA2/1!==nA2) {nA2=0} else {nCountA++}
var nA3=parseFloat(window.document.ss.A3.value)
if (nA3/1!==nA3) {nA3=0} else {nCountA++}
var nA4=parseFloat(window.document.ss.A4.value)
if (nA4/1!==nA4) {nA4=0} else {nCountA++}
//
var nA5=parseFloat(window.document.ss.A5.value)
if (nA5/1!==nA5) {nA5=0} else {nCountA++}
var nA6=parseFloat(window.document.ss.A6.value)
if (nA6/1!==nA6) {nA6=0} else {nCountA++}
var nA7=parseFloat(window.document.ss.A7.value)
if (nA7/1!==nA7) {nA7=0} else {nCountA++}
var nA8=parseFloat(window.document.ss.A8.value)
if (nA8/1!==nA8) {nA8=0} else {nCountA++}
var nA9=parseFloat(window.document.ss.A9.value)
if (nA9/1!==nA9) {nA9=0} else {nCountA++}
// alert("nCountA="+nCountA)
nSumA=nA1+nA2+nA3+nA4+nA5+nA6+nA7+nA8+nA9
window.document.ss.A10.value=nSumA
}
function addItB() {// B 열 합계 계산
nCountB=0
var nB1=parseFloat(window.document.ss.B1.value)
if (nB1/1!==nB1) {nB1=0} else {nCountB++}
var nB2=parseFloat(window.document.ss.B2.value)
if (nB2/1!==nB2) {nB2=0} else {nCountB++}
var nB3=parseFloat(window.document.ss.B3.value)
if (nB3/1!==nB3) {nB3=0} else {nCountB++}
//
var nB4=parseFloat(window.document.ss.B4.value)
if (nB4/1!==nB4) {nB4=0} else {nCountB++}
var nB5=parseFloat(window.document.ss.B5.value)
if (nB5/1!==nB5) {nB5=0} else {nCountB++}
var nB6=parseFloat(window.document.ss.B6.value)
if (nB6/1!==nB6) {nB6=0} else {nCountB++}
var nB7=parseFloat(window.document.ss.B7.value)
if (nB7/1!==nB7) {nB7=0} else {nCountB++}
var nB8=parseFloat(window.document.ss.B8.value)
if (nB8/1!==nB8) {nB8=0} else {nCountB++}
var nB9=parseFloat(window.document.ss.B9.value)
if (nB9/1!==nB9) {nB9=0} else {nCountB++}
// alert("nCountB="+nCountB)
nSumB=nB1+nB2+nB3+nB4+nB5+nB6+nB7+nB8+nB9
window.document.ss.B10.value=nSumB
}
function addItC() {// C 열 합계 계산
nCountC=0
var nC1=parseFloat(window.document.ss.C1.value)
if (nC1/1!==nC1) {nC1=0} else {nCountC++}
var nC2=parseFloat(window.document.ss.C2.value)
if (nC2/1!==nC2) {nC2=0} else {nCountC++}
var nC3=parseFloat(window.document.ss.C3.value)
if (nC3/1!==nC3) {nC3=0} else {nCountC++}
var nC4=parseFloat(window.document.ss.C4.value)
if (nC4/1!==nC4) {nC4=0} else {nCountC++}
//
var nC5=parseFloat(window.document.ss.C5.value)
if (nC5/1!==nC5) {nC5=0} else {nCountC++}
var nC6=parseFloat(window.document.ss.C6.value)
if (nC6/1!==nC6) {nC6=0} else {nCountC++}
var nC7=parseFloat(window.document.ss.C7.value)
if (nC7/1!==nC7) {nC7=0} else {nCountC++}
var nC8=parseFloat(window.document.ss.C8.value)
if (nC8/1!==nC8) {nC8=0} else {nCountC++}
var nC9=parseFloat(window.document.ss.C9.value)
if (nC9/1!==nC9) {nC9=0} else {nCountC++}
// alert("nCountC="+nCountC)
nSumC=nC1+nC2+nC3+nC4+nC5+nC6+nC7+nC8+nC9
window.document.ss.C10.value=nSumC
}
function addItD() {// D 열 합계 계산
nCountD=0
var nD1=parseFloat(window.document.ss.D1.value)
if (nD1/1!==nD1) {nD1=0} else {nCountD++}
var nD2=parseFloat(window.document.ss.D2.value)
if (nD2/1!==nD2) {nD2=0} else {nCountD++}
var nD3=parseFloat(window.document.ss.D3.value)
if (nD3/1!==nD3) {nD3=0} else {nCountD++}
var nD4=parseFloat(window.document.ss.D4.value)
if (nD4/1!==nD4) {nD4=0} else {nCountD++}
//
var nD5=parseFloat(window.document.ss.D5.value)
if (nD5/1!==nD5) {nD5=0} else {nCountD++}
var nD6=parseFloat(window.document.ss.D6.value)
if (nD6/1!==nD6) {nD6=0} else {nCountD++}
var nD7=parseFloat(window.document.ss.D7.value)
if (nD7/1!==nD7) {nD7=0} else {nCountD++}
var nD8=parseFloat(window.document.ss.D8.value)
if (nD8/1!==nD8) {nD8=0} else {nCountD++}
var nD9=parseFloat(window.document.ss.D9.value)
if (nD9/1!==nD9) {nD9=0} else {nCountD++}
// alert("nCountD="+nCountD)
nSumD=nD1+nD2+nD3+nD4+nD5+nD6+nD7+nD8+nD9
window.document.ss.D10.value=nSumD
}
function addItE() {// E 열 합계 계산
nCountE=0
var nE1=parseFloat(window.document.ss.E1.value)
if (nE1/1!==nE1) {nE1=0} else {nCountE++}
var nE2=parseFloat(window.document.ss.E2.value)
if (nE2/1!==nE2) {nE2=0} else {nCountE++}
var nE3=parseFloat(window.document.ss.E3.value)
if (nE3/1!==nE3) {nE3=0} else {nCountE++}
var nE4=parseFloat(window.document.ss.E4.value)
if (nE4/1!==nE4) {nE4=0} else {nCountE++}
//
var nE5=parseFloat(window.document.ss.E5.value)
if (nE5/1!==nE5) {nE5=0} else {nCountE++}
var nE6=parseFloat(window.document.ss.E6.value)
if (nE6/1!==nE6) {nE6=0} else {nCountE++}
var nE7=parseFloat(window.document.ss.E7.value)
if (nE7/1!==nE7) {nE7=0} else {nCountE++}
var nE8=parseFloat(window.document.ss.E8.value)
if (nE8/1!==nE8) {nE8=0} else {nCountE++}
var nE9=parseFloat(window.document.ss.E9.value)
if (nE9/1!==nE9) {nE9=0} else {nCountE++}
// alert("nCountE="+nCountE)
nSumE=nE1+nE2+nE3+nE4+nE5+nE6+nE7+nE8+nE9
window.document.ss.E10.value=nSumE
}
function avgA() { // A 열 평균
addItA()
window.document.ss.A10.value=nSumA/nCountA
// alert('nSumA='+nSumA+'\nnCountA='+nCountA)
}
function avgB() { // B 열 평균
addItB()
window.document.ss.B10.value=nSumB/nCountB
// alert('nSumB='+nSumB+'\nnCountB='+nCountB)
}
function avgC() { // C 열 평균
addItC()
window.document.ss.C10.value=nSumC/nCountC
// alert('nSumC='+nSumC+'\nnCountC='+nCountC)
}
function avgD() { // D 열 평균
addItD()
window.document.ss.D10.value=nSumD/nCountD
// alert('nSumD='+nSumD+'\nnDountD='+nCountD)
}

function avgE() { // E 열 평균
addItE()
window.document.ss.E10.value=nSumE/nCountE
// alert('nSumE='+nSumE+'\nnCountE='+nCountE)
}
//-->
</script>

<p align=center><b>아래 각 항목에 숫자를 입력 한 뒤 합계/평균 버튼을 클릭 해 보세요</b>
<form method="POST" name="ss">
<p align="center">
<input type="text" size="3" name="T0">
<input type="text" size="12" name="T1" value="A"> 
<input type="text" size="12" name="B" value="B">
<input type="text" size="12" name="B11" value="C">
<input type="text" size="12" name="B12" value="D">
<input type="text" size="12" name="B33" value="E"><br>
<input type="text" size="3" name="T1" value="1">
<input type="text" size="12" name="A1">
<input type="text" size="12" name="B1">
<input type="text" size="12" name="C1">
<input type="text" size="12" name="D1">
<input type="text" size="12" name="E1"><br>
<input type="text" size="3" name="T2" value="2">
<input type="text" size="12" name="A2">
<input type="text" size="12" name="B2">
<input type="text" size="12" name="C2">
<input type="text" size="12" name="D2">
<input type="text" size="12" name="E2"><br>
<input type="text" size="3" name="T3" value="3">
<input type="text" size="12" name="A3">
<input type="text" size="12" name="B3">
<input type="text" size="12" name="C3">
<input type="text" size="12" name="D3">
<input type="text" size="12" name="E3"><br>
<input type="text" size="3" name="T4" value="4">
<input type="text" size="12" name="A4">
<input type="text" size="12" name="B4">
<input type="text" size="12" name="C4">
<input type="text" size="12" name="D4">
<input type="text" size="12" name="E4"><br>
<input type="text" size="3" name="T5" value="5">
<input type="text" size="12" name="A5">
<input type="text" size="12" name="B5">
<input type="text" size="12" name="C5">
<input type="text" size="12" name="D5">
<input type="text" size="12" name="E5"><br>
<input type="text" size="3" name="T6" value="6">
<input type="text" size="12" name="A6">
<input type="text" size="12" name="B6">
<input type="text" size="12" name="C6">
<input type="text" size="12" name="D6">
<input type="text" size="12" name="E6"><br>
<input type="text" size="3" name="T7" value="7">
<input type="text" size="12" name="A7">
<input type="text" size="12" name="B7">
<input type="text" size="12" name="C7">
<input type="text" size="12" name="D7">
<input type="text" size="12" name="E7"><br>
<input type="text" size="3" name="T8" value="8">
<input type="text" size="12" name="A8">
<input type="text" size="12" name="B8">
<input type="text" size="12" name="C8">
<input type="text" size="12" name="D8">
<input type="text" size="12" name="E8"><br>
<input type="text" size="3" name="T9" value="9">
<input type="text" size="12" name="A9">
<input type="text" size="12" name="B9">
<input type="text" size="12" name="C9">
<input type="text" size="12" name="D9">
<input type="text" size="12" name="E9"><br>
<input type="text" size="3" name="T10" value="10">
<input type="text" size="12" name="A10">
<input type="text" size="12" name="B10">
<input type="text" size="12" name="C10">
<input type="text" size="12" name="D10">
<input type="text" size="12" name="E10"></p>
<div align="center">
<center>
<table border="0">
<tr>
<td><input type="button" name="BT1" value=" 합계 A " onclick="addItA()">
</td>
<td><input type="button" name="BT2" value=" 합계 B " onclick="addItB()">
</td>
<td><input type="button" name="BT3" value=" 합계 C" onclick="addItC()">
</td>
<td><input type="button" name="BT4" value=" 합계 D" onclick="addItD()">
</td>
<td><input type="button" name="BT5" value=" 합계 E " onclick="addItE()">
</td>
<td><input type="reset" name="BT11" value="재작성">
</td>
</tr>
<tr>
<td><input type="button" name="BT6" value="평균 A" onclick="avgA()">
</td>
<td><input type="button" name="BT7" value="평균 B" onclick="avgB()">
</td>
<td><input type="button" name="BT8" value="평균 C" onclick="avgC()">
</td>
<td><input type="button" name="BT9" value="평균 D" onclick="avgD()">
</td>
<td><input type="button" name="BT10" value="평균 E" onclick="avgE()">
</td>
<td>  </td>
</tr>
</table>
</div>
</form>
 
 







9    한글입력을 금지시킵니다 

 
<!-- [1단계] 아래 스크립트를 HEAD 부분에 붙여 넣으세요 -->
<SCRIPT LANGUAGE="JavaScript">
<!--
function hanCheck(x) {
for(i=0;i<x.user_id.value.length;i++) {
var a=x.user_id.value.charCodeAt(i);
if (a > 128) {
alert('한글 입력 금지');
x.user_id.value="";
x.user_id.focus();
return;
}
}
alert("ok");
}
//-->
</SCRIPT>
</HEAD>
<BODY>
<!-- [2단계] 아래의 방법으로 폼을 작성합니다 ---->
<form>
User_id <input type=text name="user_id">
<input type=button onClick="hanCheck(this.form)" value="Check">
</form>
 
 






8    엔터키를 누르면 다음 입력상자로 이동합니다

<BODY>
<!---
아래의 형식으로 <input> 태그안에 자바스크립트 코드를 입력 하세요 
onkeydown="if (event.keyCode == 13) 폼의이름.이동할입력상자이름.focus();"
---->
<FORM name=login_form METHOD=POST ACTION="http://www.kbs.co.kr/">
아이디 : <INPUT TYPE="text" NAME="user_id" onkeydown="if (event.keyCode == 13) login_form.user_password.focus();"><br>
비밀번호 : <INPUT TYPE="text" NAME="user_password" onkeydown="if (event.keyCode == 13) login_form.submit();"><br>
<INPUT TYPE="button" value="로그인" onClick="document.login_form.submit()">
</FORM>
 
 






7    사용자가 텍스트 박스 추가 하기 

 
<!---- [1단계] 아래의 스크립트를 HEAD 부분에 복사 해 넣으세요 ----->
<script language="javascript"> 
<!-- 
function make() { 
var len = document.form1.select1.options[document.form1.select1.selectedIndex].value; 
txtbox=" "; 
for(i=0; i<len; i++){ 
txtbox=txtbox+"<input type=text><br>"; 
        } 
layer1.innerHTML = txtbox; 
} 
//--> 
</script> 
</head> 
<body> 
<!---- [2단계] 아래와 같은 방법으로 태그와 코드를 복사 해 넣으세요 --->
<form name="form1" method=post>
추가할 갯수를 선택 하세요 
<select name="select1" onchange="make()"> 
        <option value="1">1</option> 
        <option value="2">2</option> 
        <option value="3">3</option> 
        <option value="4">4</option> 
</select> 
<p> 
<span id="layer1"></span> 
</form> 
<!--------------------------- 여기까지 ---------------------------->
 






6    라디오버튼으로 여러개의 폼 요소를 숨기거나 보이게 해 줍니다

 
<!---- [1단계] 아래 코드를 <HEAD> 와 <HEAD> 태그 사이에 붙여 넣으세요 --->
<STYLE TYPE="text/css">
        .initial {position:relative; visibility:hidden}
</STYLE>
</head>
<script language='Javascript'>
<!--
var MyDivisions=new Array(3);
MyDivisions[0]="DivSelect0";
MyDivisions[1]="DivSelect1";
MyDivisions[2]="DivSelect2";
// 계속 추가할 수 있습니다
  function ShowMe(index)
  {
   if (document.layers)   { 
                             document.layers[index].visibility="show";                        
                             eval("document.FR"+index+".R"+index+".checked=true"); 
                             for (var u=0; u < MyDivisions.length;u++) 
                             {
                                if ( u != index) 
                                {
                                  document.layers[u].visibility="hidden";
                                  eval("document.FR"+u+".R"+u+".checked=false"); 
                                } 
                             }
                          } 
   
   else if (document.all) { 
                             document.all(MyDivisions[index]).style.visibility="visible";
                             eval("document.FR"+index+".R"+index+".checked=true"); 
                             for (var u=0; u < MyDivisions.length;u++) 
                             {
                                if ( u != index) 
                                {
                                  document.all(MyDivisions[u]).style.visibility="hidden";
                                  eval("document.FR"+u+".R"+u+".checked=false"); 
                                }    
                             }
                             
                          }
  else if (document.getElementById) { 
                             document.getElementById(MyDivisions[index]).style.visibility="visible";
                             eval("document.FR"+index+".R"+index+".checked=true"); 
                             for (var u=0; u < MyDivisions.length;u++) 
                             {
                                if ( u != index) 
                                {
                                  document.getElementById(MyDivisions[u]).style.visibility="hidden";
                                  eval("document.FR"+u+".R"+u+".checked=false"); 
                                }    
                             }
                             
                          }
   }
//-->
</script>
<!------------------------- 여기까지 ------------------------------------>
<body>
<!---- [2단계] 아래의 방법으로 <BODY> 와 <BODY> 태그 사이에 붙여 넣으세요 --->
<FORM NAME="FR0">
<input type="radio" value="Update"  name="R0" OnClick="ShowMe(0)"><b>클릭 하세요 -1</b></FORM>
          <div id="DivSelect0" class=initial>
                  <FORM NAME="FS0">
          <select size="1" name="Select0">
          <option value="Hello 1">Hello 1</option>
          <option value="2">12</option>
          <option value="3">13</option>
          </select>
                  </FORM>
          </div>

<FORM NAME="FR1">
<input type="radio" name="R1" value="Delete" OnClick="ShowMe(1)"><b>클릭 하세요 -2</b></FORM>
                 <div id='DivSelect1' class=initial>
                 <FORM NAME="FS1">
          <select size="1" name="Select1">
          <option value="Hello 1">Hello 2</option>
          <option value="2">21</option>
          <option value="3">22</option>
          </select>
                  </FORM>
        </div>
<FORM NAME="FR2">
<input type="radio" name="R2" value="Delete" OnClick="ShowMe(2)"><b>클릭 하세요 -3</b></FORM>
                 <div id='DivSelect2' class=initial>
                 <FORM NAME="FS2">
          <select size="1" name="Select2">
          <option value="Hello 1">Hello 3</option>
          <option value="2">21</option>
          <option value="3">22</option>
          </select>
                  </FORM>
        </div>
</body>
</html>





5    사용자 선택에 따라 각기 다른 action 값 주기  

 
<!---- [1단계] 아래 코드를 <HEAD> 와 <HEAD> 태그 사이에 붙여 넣으세요 --->
<script>
function Check(){
if (document.myForm.myRadio1.checked) {
  document.myForm.action="http://www.kbs.co.kr/";
  document.myForm.submit();
}
else {
  document.myForm.action="http://www.daum.net";
  document.myForm.submit();
}  
}
</script>
</head>
<body>
<!---- [2단계] 아래의 방법으로 <BODY> 와 <BODY> 태그 사이에 붙여 넣으세요 --->
<form name="myForm" onSubmit="Check();">
  <input type="radio" name="myRadio1" value=first>첫번째 페이지로 보내기<br>
  <input type="radio" name="myRadio2" value=second>두번째 페이지로 보내기
  <p><input type="submit" value=" Send " name="mySubmit"></p>
</form>
 






4    정확한 이메일 주소를 적지 않으면 버튼이 활성화 되지 않습니다

 
<!---- [1단계] 아래 코드를 <HEAD> 와 </HEAD> 태그 사이에 붙여 넣으세요 --->
<SCRIPT LANGUAGE="JavaScript">
<!--
var IE4 = (document.all) ? 1 : 0;
if (IE4)
  var timerID = setInterval("enableSubmit()", 200);
function enableSubmit() {
  if (!IE4) return;
  var form = document.newsletter;
  var currentState = form.sub.disabled;
  var newState = !isEmail(form.email.value);
  if (newState != currentState)
    form.sub.disabled = newState;
}
function isEmail(str) {
  var supported = 0;
  if (window.RegExp) {
    var tempStr = "a";
    var tempReg = new RegExp(tempStr);
    if (tempReg.test(tempStr)) supported = 1;
  }
  if (!supported) 
    return (str.indexOf(".") > 2) && (str.indexOf("@") > 0);
  var r1 = new RegExp("(@.*@)|(\\.\\.)|(@\\.)|(^\\.)");
  var r2 = new RegExp("^.+\\@(\\[?)[a-zA-Z0-9\\-\\.]+\\.([a-zA-Z]{2,3}|[0-9]{1,3})(\\]?)$");
  return (!r1.test(str) && r2.test(str));
}
// -->
</SCRIPT>
</head>
<body>
<p>이메일 주소를 입력 하세요
<!---- [2단계] 아래의 방법으로 <BODY> 와 </BODY> 태그 사이에 붙여 넣으세요 --->
<FORM NAME="newsletter">
<INPUT TYPE="text" NAME="email" SIZE="30" onKeyUp="enableSubmit()">
<INPUT TYPE="submit" NAME="sub" VALUE="Submit" DISABLED>
</FORM>
<!------------------------- 여기까지 ------------------------------------>
  






3    빈칸을 채우지 않으면 입력상자에 경고색을 보냅니다  

 
<!---- [1단계] 아래 코드를 <HEAD> 와 </HEAD> 태그 사이에 붙여 넣으세요 --->
<SCRIPT LANGUAGE="JavaScript">
<!--
function setColor(el, bg) {
  if (el.style) el.style.backgroundColor = bg;
}
function checkInput(form) {
  var bgBad = "#cccc99";
  var bgGood = "white";
  var valid = true;
  if (form.first.value == "") {
    valid = false;
    setColor(form.first, bgBad);
  } else {
    setColor(form.first, bgGood);
  }
  if (form.last.value == "") {
    valid = false;
    setColor(form.last, bgBad);
  } else {
    setColor(form.last, bgGood);
  }
  if (!valid) alert("빈칸을 채워 주세요");
  return valid;
}
// -->
</SCRIPT>
</head>
<body>
<h3>빈칸을 채우지 않으면 입력상자의 색상이 바뀝니다</h3>
<!---- [2단계] 아래의 방법으로 <BODY> 와 </BODY> 태그 사이에 붙여 넣으세요 --->
<FORM onSubmit="return checkInput(this)">
이름 : <INPUT TYPE="text" NAME="first" SIZE="30" VALUE=""><BR>
별명 : <INPUT TYPE="text" NAME="last" SIZE="30" VALUE=""><BR>
<INPUT TYPE="submit" VALUE=" 보내기 ">
</FORM>
<!------------------------- 여기까지 ------------------------------------>
  






2    실시간으로 입력할 수 있는 글자의 수를 알려줍니다 

<!---- [1단계] 아래 코드를 <HEAD> 와 </HEAD> 태그 사이에 붙여 넣으세요 --->
<script language = "javascript">
<!--
function doleft2() {
document.form.text.value = "";
}
function docheck() {
char = eval(document.form.text.value.length)
var dif = eval(char - 125)
var value = document.form.text.value.substr(0,char-dif);
document.form.text.value = value;
var left = "0"
}
function doleft() {
total = eval("125")
char = eval(document.form.text.value.length)
left = eval(total - char)
if (left <= "-1")
{
var dif = eval(char - 125)
var value = document.form.text.value.substr(0,char-dif);
document.form.text.value = value;
var left = "0"
}
document.form.left.value = left
}
document.write("<body onload=\"doleft2()\">")
//-->
</script>
</head>
<body>
<!---- [2단계] 아래의 방법으로 <BODY> 와 </BODY> 태그 사이에 붙여 넣으세요 --->
<p>
<form name="form" onsubmit="docheck();alert('샘플입니다')">
<textarea onclick="docheck()" onkeyup="javascript:doleft();" id="text" name="text" rows="6" cols="24"></textarea>
<p>
앞으로 <input type="text" name="left" value="125" size="3" readonly id="left"> 글자를 입력 할 수 있습니다
<p>
<input type="submit">
</form>
</body>
</html>







1    옵션 엘리먼트 추가시키기 

 
<!---- 아래의 방법으로 <BODY> 와 </BODY> 태그 사이에 붙여 넣으세요 --->
<input type="button" value=" 추가하기 " onclick="addNewOption()">
<select id="oSelect">
  <option>이곳에 옵션 항목이 추가 됩니다
</select>
<script>
<!--
var optionNo = 0;
function addNewOption() {
  optionNo += 1;
  oNewOption = new Option();
  oNewOption.text = "옵션 : " + optionNo;
  oSelect.add(oNewOption, 1);
}
// -->
</script>