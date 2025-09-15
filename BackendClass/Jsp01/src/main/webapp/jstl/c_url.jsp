<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<img src="/img/apple.png"> <!-- 현재 페이지 위치에 따라 경로 설정: 잘못된 경로 -->
<img src="../img/apple.png"> <!-- 현재 페이지 위치에 따라 상대적인 경로 설정: 잘못된 경로 -->
<img src="${pageContext.request.contextPath}/img/apple.png">
<img src="<c:url value='/img/apple.png'/>">
<%--
value의 경로는 contextPath 뒤부터 url을 만든다
script/css 자원의 uri 경로 생성 시 많이 사용하는 태그
--%>
</body>
</html>
