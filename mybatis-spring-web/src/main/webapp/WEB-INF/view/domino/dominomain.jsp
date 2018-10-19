<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,model.*" %>
<%
	List list = (List)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript">
	function bca() {
		var num = document.getElementById("aca").value;
		$.ajax({
			type : 'post',
			url : 'bca.do',
			dataType : 'html',
			data : "anum="+num,
			success : function(result) {
				$('#bca').html(result);
				$('#cca').html("");
			}
		});
	}
	function cca() {
		var num1 = document.getElementById("aca").value;
		var num2 = document.getElementById("bca1").value;
		$.ajax({
			type : 'post',
			url : 'cca.do',
			dataType : 'html',
			data : "anum="+num1+"&bnum="+num2,
			success : function(result) {
				$('#cca').html(result);
			}
		});
	}
</script>
</head>
<body>
<form id="frm" name="frm">
<div>

<select id="aca" name="anum" onclick="javascript:bca();">
	<% for(Object o : list ) { 
		Aca aca = (Aca)o; %>
		<option value="<%=aca.getAnum() %>"><%= aca.getAname() %></option>
	<% } %>
</select>

</div>
<div id="bca"></div>
<div id="cca"></div>
</form>
</body>
</html>