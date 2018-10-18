<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript">
	$(function(){
		$('#log_in').bind('click', function(){
			$('#frm').ajaxSubmit({
				type : 'POST',
				url : 'login_pro.do',
				beforeSubmit : applicant_check,
				success : applicant_Ok,
				error : function(){
					alert('에러 발생! 잠시 후 다시 시도해 주세요.');
					return;
				}
			});
			return false;
		});
	});					/* 데이터 받아 오는 것, 상태표시 */
 	function apllicant_Ok(responseText, statusText, xhr, $form){
		if(statusText == 'success') {
			if(responseText == "0") {
				alert("정보가 부족합니다.");
				form.IID.value = "";
				form.PASSWD.value = "";
				form.IID.focus();
			}else if(responseText == "1") {
				alert("아이디가 존재하지 않습니다.");
				form.IID.value = "";
				form.PASSWD.value = "";
				form.IID.focus();
			}else if(responseText == "2") {
				alert("비밀번호가 일치하지 않습니다.");
				form.PASSWD.value = "";
				form.PASSWD.focus();
			}else if(responseText == "4") {
				location.href="main1.do";
			}
		}
	}
	function applicant_check() {
		if(!document.getElementById("IID").value) {
			alert("아이디를 입력하세요.");
			document.frm.IID.focus();
			return false;
		}
		if(!document.getElementById("PASSWD").value) {
			alert("비밀번호를 입력하세요.");
			document.frm.PASSWD.focus();
			return false;
		}
	}
</script>
</head>
<body>
<form name="frm" id="frm" >
<div class="loginarea">
	<dl>
		<dt class="blind">아이디</dt>
		<dd>
			<input type="text" name="IID" id="IID" style="width:140px;" />
		</dd>
		<dt class="blind">패스워드</dt>
		<dd>
			<input type="password" name="PASSWD" id="PASSWD" style="width:140px;" />
		</dd>
		<ul>
			<li>
				<input type="image" src="" id="log_in" alt="로그인" title="로그인" />
			</li>
		</ul>
	</dl>
</div>
</form>
</body>
</html>