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
	// 이벤트 핸들러 사용 형식
	$(function(){
		$("#comment").live('click',function(){
			var options ={
				type : 'POST',	//받는 형식 get, post
				url : 'ajax.do',  // 불러올 url 주소
				dataType : 'html', // 페이지 형식을 html형식으로 받겠다.
 				/* data : 'n=1',	  // 쿼리스트링 ?다음에 들어갈 값 */
				success : function(data) {
					$('#notice_content').html(data);
				}
			};
			$('#frm').ajaxSubmit(options); //form 안에 있는 input을 실행 시키겠다..?
			return false;
		});
	});
	function form_select(num) {
		$.ajax({
			type : "POST",
			url : "ajax.do",
			dataType : "html",
			data : "n="+num,
			success : function(data) {
				$('#notice_content').html(data);				
			}
		});
	}
</script>
</head>
<body>
<div class="res" id="notice_content">
</div>
<form name="frm" id="frm">
<input type="hidden" value="1" name="n" />
<input type="image" src="" id="comment" />
</form>
</body>
</html>