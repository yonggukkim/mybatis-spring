<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
<%
	Comment comment = (Comment)request.getAttribute("comment");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= comment.getCommentNo() %><br />
	<%= comment.getUserId() %><br />
	<%= comment.getCommentContent() %><br />
	<%= comment.getRegDate() %>
	<a href="./form.do">메인</a>
</body>
</html>