<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL param 내장 객체 사용</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
%>
아이디: ${param.id}<br>
비밀번호: ${param.pwd}<br>
이름: ${param.name}<br>
이메일: ${param.email}<br>
</body>
</html>
