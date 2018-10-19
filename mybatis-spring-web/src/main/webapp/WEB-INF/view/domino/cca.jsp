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
</head>
<body>
<div>
<select id="cca1" name="cnum">
<% for( Object o : list) { 
	Cca cca = (Cca)o;
%>
	<option value="<%= cca.getCnum() %>"><%= cca.getCname() %></option>
<% } %>
</select>
</div>
</body>
</html>