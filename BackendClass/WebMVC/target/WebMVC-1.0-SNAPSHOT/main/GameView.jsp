<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome to GameLand</title>
</head>
<body>
<h1>JSP GameLand에 오신 것을 환영합니다!</h1>
<p>원하시는 게임을 선택해주세요</p>
<a href="<c:url value='/game/Gababo.jsp'/>">가위 바위 보</a>
<a href="<c:url value='/game/guess'/>">숫자 맞추기</a>
<a href="<c:url value='${pageContext.request.contextPath}/main/mainView.jsp'/>">메인화면</a>
</body>
</html>