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
<select id="bca1" name="bnum" onclick="javascript:cca();">
<% for( Object o : list) { 
	Bca bca = (Bca)o; %>
	<option value="<%= bca.getBnum() %>"><%= bca.getBname() %></option>
<% } %>
</select>
</body>
</html>