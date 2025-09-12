<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- 로그인 페이지로 이동하는 a 태그 location 값을 여러 방법으로 설정--%>
<a href="http://localhost:8080/Jsp01/el/login.jsp">로그인1</a><br>
<a href="Jsp01/el/login.jsp">로그인2</a><br> <!-- 현재 페이지를 요청할 때 서버의 주소는 브라우저에 저장됨 -->
<a href="<%=request.getContextPath()%>/login.jsp">로그인3</a><br> <!-- 현재 페이지 요청 시 사용했던 contextPath 와 동일한 path사용-->
<a href="${pageContext.request.contextPath}/el/login.jsp">로그인4</a><br>
</body>
</html>
