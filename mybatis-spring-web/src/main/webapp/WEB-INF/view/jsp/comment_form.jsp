<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- comment에 저장된 값을 가져온다.  -->
	<form:form commandName="comment" action="comment_insert">
	<label><spring:message code="commentInsert" /><br />
	</label>
	<label><spring:message code="commentNo" /> :
	<form:input path="commentNo" /><br />
	</label>
	<label><spring:message code="userId" /> :
	<form:input path="userId" /><br />
	</label>
	<label><spring:message code="commentContent" /> :
	<form:input path="commentContent" /><br />
	</label>
	<input type="submit" value="<spring:message code="Insert.btn" />">
	<br />
	</form:form>
	
	<form:form commandName="comment" action="comment_select">
	<label><spring:message code="commentSelect" /> :
	<form:input path="commentNo" /><br />
	</label>
	<input type="submit" value="<spring:message code="select.btn" />">
	<br />
	</form:form>
	
	<form:form commandName="comment" action="comment_update">
	<label><spring:message code="commentUpdate" /><br />
	</label>
	<label><spring:message code="commentNo" /> :
	<form:input path="commentNo" /><br />
	</label>
	<label><spring:message code="userId" /> :
	<form:input path="userId" /><br />
	</label>
	<label><spring:message code="commentContent" /> :
	<form:input path="commentContent" /><br />
	</label>
	<input type="submit" value="<spring:message code="Update.btn" />">
	<br />
	</form:form>
	
	<form:form commandName="comment" action="comment_delete">
	<label><spring:message code="commentDelete" /> :
	<form:input path="commentNo" /><br />
	</label>
	<input type="submit" value="<spring:message code="Delete.btn" />">
	<br />
	</form:form>
</body>
</html>