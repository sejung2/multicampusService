<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>include 액션 태그1</title>
	</head>
	<body>
		<h3>includeAction1 입니다</h3>
		<hr>
		<%-- jsp 액션 태그 include --%>
        <jsp:include page="includeAction2.jsp" />
		
	</body>
</html>