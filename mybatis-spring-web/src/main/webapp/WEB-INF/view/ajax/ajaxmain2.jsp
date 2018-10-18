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
		$("#comment").click(function(){
			$('#frm').ajaxSubmit({
				type : 'POST',
				url : 'ajax.do',
				dataType : 'html',
				success : function(data){
					$('#notice_content').html(data);
				}
			});
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
<div class="res" id="notice_content"></div>
<form id="frm">
<input type="hidden" value="1" name="n" />
<input type="image" src="" id="comment" />
</form>
</body>
</html>