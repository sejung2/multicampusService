<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("id", "hong");
    request.setAttribute("pwd", "1234");
    request.setAttribute("name", "홍길동");
    request.setAttribute("email", "hong@test.com");
%>
<jsp:forward page="el-forward-result.jsp" />

</body>
</html>
